package org.bimserver.serializers;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.citygml.CityGmlSerializer;
import org.bimserver.collada.ColladaSerializer;
import org.bimserver.collada.KmzSerializer;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.User;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.PackageDefinition;
import org.bimserver.ifc.SerializerException;
import org.bimserver.ifc.XsltParameter;
import org.bimserver.ifc.XsltSerializer;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.ifc.xml.writer.IfcXmlSerializer;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.o3d.O3dJsonSerializer;
import org.bimserver.settings.ServerSettings;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.ResultType.Type;
import org.bimserver.version.Version;

public class EmfSerializerFactory {
	public interface EmfSerializerCreator {
		EmfSerializer create(Project project, User user, IfcModel model, String name) throws SerializerException;
	}

	Comparator<ResultType> resultTypeComparator = new Comparator<ResultType>(){
		@Override
		public int compare(ResultType o1, ResultType o2) {
			return o1.getNiceName().compareTo(o2.getNiceName());
		}};
	
	private final Map<ResultType, EmfSerializerCreator> emfSerializerCreators = new TreeMap<ResultType, EmfSerializerCreator>(resultTypeComparator);
	private static final EmfSerializerFactory INSTANCE = new EmfSerializerFactory();
	private FieldIgnoreMap fieldIgnoreMap;
	private PackageDefinition colladaSettings;
	private SchemaDefinition schemaDefinition;
	private Version version;

	private IfcEngineFactory ifcEngineFactory;

	private ResourceFetcher resourceFetcher;

	private EmfSerializerFactory() {
	}

	public static EmfSerializerFactory getInstance() {
		return INSTANCE;
	}

	public void init(Version version, SchemaDefinition schemaDefinition, FieldIgnoreMap fieldIgnoreMap, IfcEngineFactory ifcEngineFactory, PackageDefinition colladaSettings, ResourceFetcher resourceFetcher) {
		this.version = version;
		this.schemaDefinition = schemaDefinition;
		this.fieldIgnoreMap = fieldIgnoreMap;
		this.ifcEngineFactory = ifcEngineFactory;
		this.colladaSettings = colladaSettings;
		this.resourceFetcher = resourceFetcher;
	}
	
	public void register(ResultType type, EmfSerializerCreator emfSerializerCreater) {
		emfSerializerCreators.put(type, emfSerializerCreater);
	}

	public void unregister(ResultType type) {
		emfSerializerCreators.remove(type);
	}
	
	public EmfSerializer create(Project project, User user, ResultType resultType, IfcModel model, String name) throws NoSerializerFoundException, SerializerException {
		EmfSerializerCreator emfSerializerCreator = emfSerializerCreators.get(resultType);
		if (emfSerializerCreator == null) {
			throw new NoSerializerFoundException("Serializer for type " + resultType.getNiceName() + " not found or not enabled");
		}
		return emfSerializerCreator.create(project, user, model, name);
	}

	public boolean resultTypeEnabled(ResultType resultType) {
		return emfSerializerCreators.containsKey(resultType);
	}
	
	public Set<ResultType> getMultipleResultTypes() {
		Set<ResultType> result = new TreeSet<ResultType>(resultTypeComparator);
		for (ResultType resultType : emfSerializerCreators.keySet()) {
			if (resultType.getType() == Type.MULTIPLE) {
				result.add(resultType);
			}
		}
		return result;
	}

	public Set<ResultType> getSingleResultTypes() {
		return emfSerializerCreators.keySet();
	}
	
	public void initSerializers() {
		String enabledExportTypesString = ServerSettings.getSettings().getEnabledExportTypes();
		String[] enabledExportTypes = enabledExportTypesString.split(",");
		EnumSet<ResultType> enabled = EnumSet.noneOf(ResultType.class);
		for (String type : enabledExportTypes) {
			String upperCase = type.trim().toUpperCase();
			if (!upperCase.equals("")) {
				enabled.add(ResultType.valueOf(upperCase));
			}
		}
		if (enabled.contains(ResultType.IFC)) {
			register(ResultType.IFC, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) {
					IfcStepSerializer ifcSerializer = new IfcStepSerializer(project, user, fileName, model, schemaDefinition);
					ifcSerializer.setFileDescription("Bimserver.org " + version.getVersion() + " generated IFC file");
					ifcSerializer.setPreProcessorVersion("Bimserver.org " + version.getVersion());
					return ifcSerializer;
				}
			});
		} else {
			unregister(ResultType.IFC);
		}
		if (enabled.contains(ResultType.IFCXML)) {
			register(ResultType.IFCXML, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) {
					return new IfcXmlSerializer(fileName, model, schemaDefinition);
				}
			});
		} else {
			unregister(ResultType.IFCXML);
		}
		if (enabled.contains(ResultType.TEXT)) {
			register(ResultType.TEXT, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) {
					IfcStepSerializer ifcSerializer = new IfcStepSerializer(project, user, fileName, model, schemaDefinition);
					ifcSerializer.setFileDescription("Bimserver.org " + version.getVersion() + " generated IFC file");
					ifcSerializer.setPreProcessorVersion("Bimserver.org " + version.getVersion());
					return ifcSerializer;
				}
			});
		} else {
			unregister(ResultType.TEXT);
		}
		if (enabled.contains(ResultType.CITYGML)) {
			register(ResultType.CITYGML, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new CityGmlSerializer(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory);
				}
			});
		} else {
			unregister(ResultType.CITYGML);
		}
		if (enabled.contains(ResultType.COLLADA)) {
			register(ResultType.COLLADA, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new ColladaSerializer(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory, colladaSettings);
				}
			});
		} else {
			unregister(ResultType.COLLADA);
		}
		if (enabled.contains(ResultType.REPORT_SPACES)) {
			register(ResultType.REPORT_SPACES, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new XsltSerializer(fileName, model, fieldIgnoreMap, schemaDefinition, resourceFetcher.getResource("_Report1.xhtml.xsl"), ResultType.REPORT_SPACES, new XsltParameter("topic", "space"));
				}
			});
		} else {
			unregister(ResultType.REPORT_SPACES);
		}
		if (enabled.contains(ResultType.REPORT_COMPONENTS)) {
			register(ResultType.REPORT_COMPONENTS, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new XsltSerializer(fileName, model, fieldIgnoreMap, schemaDefinition, resourceFetcher.getResource("_Report1.xhtml.xsl"), ResultType.REPORT_COMPONENTS, new XsltParameter("topic", "component"));
				}
			});
		} else {
			unregister(ResultType.REPORT_COMPONENTS);
		}
		if (enabled.contains(ResultType.REPORT_SYSTEMS)) {
			register(ResultType.REPORT_SYSTEMS, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new XsltSerializer(fileName, model, fieldIgnoreMap, schemaDefinition, resourceFetcher.getResource("_Report1.xhtml.xsl"), ResultType.REPORT_SYSTEMS, new XsltParameter("topic", "system"));
				}
			});
		} else {
			unregister(ResultType.REPORT_SYSTEMS);
		}
		if (enabled.contains(ResultType.REPORT_TYPES)) {
			register(ResultType.REPORT_TYPES, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new XsltSerializer(fileName, model, fieldIgnoreMap, schemaDefinition, resourceFetcher.getResource("_Report1.xhtml.xsl"), ResultType.REPORT_TYPES, new XsltParameter("topic", "type"));
				}
			});
		} else {
			unregister(ResultType.REPORT_TYPES);
		}
		if (enabled.contains(ResultType.REPORT_ZONES)) {
			register(ResultType.REPORT_ZONES, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new XsltSerializer(fileName, model, fieldIgnoreMap, schemaDefinition, resourceFetcher.getResource("_Report1.xhtml.xsl"), ResultType.REPORT_ZONES, new XsltParameter("topic", "zone"));
				}
			});
		} else {
			unregister(ResultType.REPORT_ZONES);
		}
		if (enabled.contains(ResultType.COBIE2)) {
			register(ResultType.COBIE2, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new XsltSerializer(fileName, model, fieldIgnoreMap, schemaDefinition, resourceFetcher.getResource("_asCOBie2.xml.xsl"), ResultType.COBIE2);
				}
			});
		} else {
			unregister(ResultType.COBIE2);
		}
		if (enabled.contains(ResultType.KMZ)) {
			register(ResultType.KMZ, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new KmzSerializer(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory, colladaSettings);
				}
			});
		} else {
			unregister(ResultType.KMZ);
		}
		if (enabled.contains(ResultType.O3D_JSON)) {
			register(ResultType.O3D_JSON, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
					return new O3dJsonSerializer(project, user, fileName, model, fieldIgnoreMap, schemaDefinition, ifcEngineFactory);
				}
			});
		} else {
			unregister(ResultType.O3D_JSON);
		}
		if (enabled.contains(ResultType.OBJECT_INFO)) {
			register(ResultType.OBJECT_INFO, new EmfSerializerCreator() {
				@Override
				public EmfSerializer create(Project project, User user, IfcModel model, String fileName) {
					return new ObjectInfoSerializer(project, user, fileName, model, fieldIgnoreMap);
				}
			});
		} else {
			unregister(ResultType.OBJECT_INFO);
		}
	}
}