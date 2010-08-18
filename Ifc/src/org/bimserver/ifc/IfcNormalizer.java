package org.bimserver.ifc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import nl.tue.buildingsmart.emf.DerivedReader;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.bimserver.emf.BasicEmfModel;
import org.bimserver.emf.EmfModel;
import org.bimserver.emf.NormalizedEmfModel;
import org.bimserver.ifc.file.reader.FastIfcFileReader;
import org.bimserver.ifc.file.reader.IfcFileReader;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifc.file.writer.IfcSerializer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

public class IfcNormalizer {
	public static void main(String[] args) {
		new IfcNormalizer().normalize(new File("../CityGML/test.ifc"));
	}

	private SchemaDefinition schema;

	public IfcNormalizer() {
		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
		schemaParser.parse();
		schema = schemaParser.getSchema();
		try {
			new DerivedReader(IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public NormalizedEmfModel normalize(EmfModel<Long> original) {
		Map<Long, EObject> objects = original.getObjects();
		Map<EObject, Long> treeMap = new TreeMap<EObject, Long>(new Comparator<EObject>() {
			@Override
			public int compare(EObject object1, EObject object2) {
				int compareTo = object1.eClass().getName().compareTo(object2.eClass().getName());
				if (compareTo == 0) {
					EClass eClass = object1.eClass();
					for (EAttribute eAttribute : eClass.getEAllAttributes()) {
						Object val1 = object1.eGet(eAttribute);
						Object val2 = object2.eGet(eAttribute);
						if (val1 == null && val2 != null) {
						} else if (val1 == null) {
							return -1;
						} else if (val2 == null) {
							return 1;
						} else {
							if (eAttribute.getEType() instanceof EEnum) {
								int compareTo2 = val1.toString().compareTo(val2.toString());
								if (compareTo2 != 0) {
									return compareTo2;
								}
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEString()) {
								int compareTo2 = ((String)val1).compareTo((String)val2);
								if (compareTo2 != 0) {
									return compareTo2;
								}
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEInt()) {
								int compareTo2 = ((Integer)val1).compareTo((Integer)val2);
								if (compareTo2 != 0) {
									return compareTo2;
								}
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
								int compareTo2 = ((Float)val1).compareTo((Float)val2);
								if (compareTo2 != 0) {
									return compareTo2;
								}
							}
						}
					}
					return object1.hashCode() - object2.hashCode();
				}
				return compareTo * 100000;
			}
		});
		for (Long key : objects.keySet()) {
			treeMap.put(objects.get(key), key);
		}
		NormalizedEmfModel resultModel = new NormalizedEmfModel();
		for (EObject object : treeMap.keySet()) {
			resultModel.add(object);
		}
		return resultModel;
	}
	
	private void normalize(File file) {
		File destFile = new File(file.getParentFile(), "normalized-" + file.getName());
		FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(schema);
		try {
			fastIfcFileReader.read(file);
			EmfModel<Long> model = fastIfcFileReader.getModel();
			EmfModel<Long> normalize = normalize(model);
			IfcSerializer ifcSerializer = new IfcSerializer(normalize, schema);
			ifcSerializer.write(destFile);
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}