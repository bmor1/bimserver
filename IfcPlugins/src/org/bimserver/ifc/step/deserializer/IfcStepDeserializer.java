package org.bimserver.ifc.step.deserializer;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcBoolean;
import org.bimserver.models.ifc2x3.IfcLogical;
import org.bimserver.models.ifc2x3.Tristate;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.BooleanType;
import org.bimserver.plugins.schema.DefinedType;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.ExplicitAttribute;
import org.bimserver.plugins.schema.IntegerType;
import org.bimserver.plugins.schema.RealType;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.StringType;
import org.bimserver.plugins.schema.UnderlyingType;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.utils.FakeClosingInputStream;
import org.bimserver.utils.StringUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EEnumImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class IfcStepDeserializer extends EmfDeserializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(IfcStepDeserializer.class);
	private static final int AVERAGE_LINE_LENGTH = 58;

	public enum Mode {
		HEADER, DATA, FOOTER, DONE
	}

	private static final String WRAPPED_VALUE = "wrappedValue";
	private static final Map<String, EClassifier> classes = initClasses();

	private final Map<Long, List<WaitingObject>> waitingObjects = new HashMap<Long, List<WaitingObject>>();
	private SchemaDefinition schema;
	private EPackage ePackage;
	private Mode mode = Mode.HEADER;
	private IfcModel model;

	public void init(SchemaDefinition schema) {
		this.ePackage = Ifc2x3Package.eINSTANCE;
		this.schema = schema;
	}

	public IfcModelInterface read(InputStream in, String filename, boolean setOids, long fileSize) throws DeserializeException {
		mode = Mode.HEADER;
		if (filename != null && (filename.toUpperCase().endsWith(".ZIP") || filename.toUpperCase().endsWith(".IFCZIP"))) {
			ZipInputStream zipInputStream = new ZipInputStream(in);
			ZipEntry nextEntry;
			try {
				nextEntry = zipInputStream.getNextEntry();
				if (nextEntry == null) {
					throw new DeserializeException("Zip files must contain exactly one IFC-file, this zip-file looks empty");
				}
				if (nextEntry.getName().toUpperCase().endsWith(".IFC")) {
					IfcModelInterface model = null;
					FakeClosingInputStream fakeClosingInputStream = new FakeClosingInputStream(zipInputStream);
					model = read(fakeClosingInputStream, setOids, fileSize);
					if (model.getSize() == 0) {
						throw new DeserializeException("Uploaded file does not seem to be a correct IFC file");
					}
					if (zipInputStream.getNextEntry() != null) {
						zipInputStream.close();
						throw new DeserializeException("Zip files may only contain one IFC-file, this zip-file contains more files");
					} else {
						zipInputStream.close();
						return model;
					}
				} else {
					throw new DeserializeException("Zip files must contain exactly one IFC-file, this zip-file seems to have one or more non-IFC files");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			return read(in, setOids, fileSize);
		}
		return model;
	}

	private IfcModelInterface read(InputStream inputStream, boolean setOids, long fileSize) throws DeserializeException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8));
		int initialCapacity = (int) (fileSize / AVERAGE_LINE_LENGTH);
		model = new IfcModel(initialCapacity);
		int lineNumber = 0;
		try {
			String line = reader.readLine();
			MessageDigest md = MessageDigest.getInstance("MD5");
			while (line != null) {
				byte[] bytes = line.getBytes(Charsets.UTF_8);
				md.update(bytes, 0, bytes.length);
				try {
					while (!processLine(line.trim(), setOids)) {
						line += reader.readLine();
						lineNumber++;
					}
				} catch (Exception e) {
					LOGGER.error("", e);
					throw new DeserializeException("Error on line " + lineNumber + " (" + e.getMessage() + ") " + line, e);
				}
				line = reader.readLine();
				lineNumber++;
			}
			model.setChecksum(md.digest());
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("", e);
		}
		return model;
	}

	public IfcModel read(File sourceFile, boolean setOids) throws DeserializeException {
		try {
			FileInputStream in = new FileInputStream(sourceFile);
			read(in, setOids, sourceFile.length());
			in.close();
			model.setDate(new Date());
			model.setName(sourceFile.getName());
			return model;
		} catch (FileNotFoundException e) {
			throw new DeserializeException(e);
		} catch (IOException e) {
			throw new DeserializeException(e);
		}
	}

	public IfcModel getModel() {
		return model;
	}

	private static Map<String, EClassifier> initClasses() {
		HashMap<String, EClassifier> classes = new HashMap<String, EClassifier>(Ifc2x3Package.eINSTANCE.getEClassifiers().size());
		for (EClassifier classifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
			classes.put(classifier.getName().toUpperCase(), classifier);
		}
		return classes;
	}

	private boolean processLine(String line, boolean setOids) throws DeserializeException {
		switch (mode) {
		case HEADER:
			if (line.equals("DATA;")) {
				mode = Mode.DATA;
			}
			break;
		case DATA:
			if (line.equals("ENDSEC;")) {
				mode = Mode.FOOTER;
			} else {
				if (line.length() > 0 && line.charAt(0) == '#') {
					while (line.endsWith("*/")) {
						line = line.substring(0, line.lastIndexOf("/*")).trim();
					}
					if (line.endsWith(";")) {
						processRecord(line, setOids);
					} else {
						return false;
					}
				}
			}
			break;
		case FOOTER:
			System.out.println(model.size());
			if (line.equals("ENDSEC;")) {
				mode = Mode.DONE;
			}
			break;
		case DONE:
		}
		return true;
	}

	public void processRecord(String line, boolean setOids) throws DeserializeException {
		int equalSignLocation = line.indexOf("=");
		int lastIndexOfSemiColon = line.lastIndexOf(";");
		int indexOfFirstParen = line.indexOf("(");
		long recordNumber = Long.parseLong(line.substring(1, equalSignLocation).trim());
		String name = line.substring(equalSignLocation + 1, indexOfFirstParen).trim();
		EClass classifier = (EClass) classes.get(name);
		if (classifier != null) {
			IdEObject object = (IdEObject) Ifc2x3Factory.eINSTANCE.create(classifier);
			model.add(recordNumber, object);
			if (setOids) {
				object.setOid(recordNumber);
			}
			String realData = line.substring(indexOfFirstParen + 1, lastIndexOfSemiColon - 1);
			int lastIndex = 0;
			EntityDefinition entityBN = schema.getEntityBN(name);
			if (entityBN == null) {
				throw new DeserializeException("Unknown entity " + name);
			}
			for (Attribute attribute : entityBN.getAttributesCached(true)) {
				if (attribute instanceof ExplicitAttribute) {
					if (!entityBN.isDerived(attribute.getName())) {
						EStructuralFeature structuralFeature = classifier.getEStructuralFeature(attribute.getName());
						if (structuralFeature == null) {
							throw new DeserializeException("Unknown feature " + classifier.getName() + "." + attribute.getName());
						}
						int nextIndex = StringUtils.nextString(realData, lastIndex);
						String val = null;
						try {
							val = realData.substring(lastIndex, nextIndex - 1).trim();
						} catch (Exception e) {
							int expected = 0;
							for (Attribute attribute2 : entityBN.getAttributesCached(true)) {
								if (attribute2 instanceof ExplicitAttribute) {
									expected++;
								}
							}
							throw new DeserializeException(classifier.getName() + " expects " + expected + " fields, but less found");
						}
						lastIndex = nextIndex;
						char firstChar = val.charAt(0);
						if (firstChar == '$') {
							object.eUnset(structuralFeature);
						} else if (firstChar == '#') {
							readReference(val, object, structuralFeature);
						} else if (firstChar == '.') {
							readEnum(val, object, structuralFeature);
						} else if (firstChar == '(') {
							readList(val, object, structuralFeature);
						} else if (firstChar == '*') {
						} else {
							if (!structuralFeature.isMany()) {
								object.eSet(structuralFeature, convert(structuralFeature.getEType(), val));
								if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
									EStructuralFeature doubleStringFeature = classifier.getEStructuralFeature(attribute.getName() + "AsString");
									object.eSet(doubleStringFeature, val);
								}
							}
						}
					} else {
						int nextIndex = StringUtils.nextString(realData, lastIndex);
						lastIndex = nextIndex;
					}
				}
			}
			if (waitingObjects.containsKey(recordNumber)) {
				updateNode(recordNumber, classifier, object);
			}
		} else {
			throw new DeserializeException(name + " is not a known entity");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void readList(String val, EObject object, EStructuralFeature structuralFeature) throws DeserializeException {
		int index = 0;
		if (!structuralFeature.isMany()) {
			throw new DeserializeException("Field " + structuralFeature.getName() + " of " + structuralFeature.getEContainingClass().getName() + " is no aggregation");
		}
		BasicEList list = (BasicEList) object.eGet(structuralFeature);
		BasicEList doubleStringList = null;
		if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
			EStructuralFeature doubleStringFeature = structuralFeature.getEContainingClass().getEStructuralFeature(structuralFeature.getName() + "AsString");
			if (doubleStringFeature == null) {
				throw new DeserializeException("Field not found: " + structuralFeature.getName() + "AsString");
			}
			doubleStringList = (BasicEList)object.eGet(doubleStringFeature);
		}
		String realData = val.substring(1, val.length() - 1);
		int lastIndex = 0;
		while (lastIndex != realData.length() + 1) {
			int nextIndex = StringUtils.nextString(realData, lastIndex);
			String stringValue = realData.substring(lastIndex, nextIndex - 1).trim();
			lastIndex = nextIndex;
			if (stringValue.length() > 0) {
				if (stringValue.charAt(0) == '#') {
					Long referenceId = Long.parseLong(stringValue.substring(1));
					if (model.contains(referenceId)) {
						EObject referencedObject = model.get(referenceId);
						if (referencedObject != null) {
							EClass referenceEClass = referencedObject.eClass();
							if (((EClass) structuralFeature.getEType()).isSuperTypeOf(referenceEClass)) {
								while (list.size() <= index) {
									list.addUnique(ePackage.getEFactoryInstance().create(referenceEClass));
								}
								list.setUnique(index, referencedObject);
							} else {
								throw new DeserializeException(referenceEClass.getName() + " cannot be stored in " + structuralFeature.getName());
							}
						}
					} else {
						List<WaitingObject> waitingList = null;
						if (waitingObjects.containsKey(referenceId)) {
							waitingList = waitingObjects.get(referenceId);
						} else {
							waitingList = new ArrayList<WaitingObject>();
							waitingObjects.put(referenceId, waitingList);
						}
						waitingList.add(new WaitingObject(object, structuralFeature, index));
					}
				} else {
					Object convert = convert(structuralFeature.getEType(), stringValue);
					while (list.size() <= index) {
						if (doubleStringList != null) {
							doubleStringList.addUnique(stringValue);
						}
						list.addUnique(convert);
					}
					if (convert != null) {
						if (doubleStringList != null) {
							doubleStringList.setUnique(index, stringValue);
						}
						list.setUnique(index, convert);
					}
				}
			}
			index++;
		}
	}

	@SuppressWarnings("unchecked")
	private void updateNode(Long id, EClass ec, EObject eObject) throws DeserializeException {
		for (WaitingObject waitingObject : waitingObjects.get(id)) {
			if (waitingObject.getStructuralFeature().getUpperBound() != 1) {
				BasicEList<EObject> list = (BasicEList<EObject>) waitingObject.getObject().eGet(waitingObject.getStructuralFeature());
				if (waitingObject.getIndex() == -1) {
					list.addUnique(eObject);
				} else {
					if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(eObject.eClass())) {
						while (list.size() <= waitingObject.getIndex()) {
							list.addUnique(ec.getEPackage().getEFactoryInstance().create(eObject.eClass()));
						}
						list.setUnique(waitingObject.getIndex(), eObject);
					} else {
						throw new DeserializeException("Field " + waitingObject.getStructuralFeature().getName() + " of "
								+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName());
					}
				}
			} else {
				if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(eObject.eClass())) {
					waitingObject.getObject().eSet(waitingObject.getStructuralFeature(), eObject);
				} else {
					throw new DeserializeException("Field " + waitingObject.getStructuralFeature().getName() + " of "
							+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName());
				}
			}
		}
		waitingObjects.remove(id);
	}

	private Object convertSimpleValue(Class<?> instanceClass, String value) throws DeserializeException {
		if (!value.equals("")) {
			if (instanceClass == Integer.class || instanceClass == int.class) {
				return Integer.parseInt(value);
			} else if (instanceClass == Long.class || instanceClass == long.class) {
				return Long.parseLong(value);
			} else if (instanceClass == Boolean.class || instanceClass == boolean.class) {
				return Boolean.parseBoolean(value);
			} else if (instanceClass == Double.class || instanceClass == double.class) {
				try {
					return Double.parseDouble(value);
				} catch (NumberFormatException e) {
					throw new DeserializeException("Incorrent double floating point value", e);
				}
			} else if (instanceClass == String.class) {
				if (value.startsWith("'") && value.endsWith("'")) {
					String result = value.substring(1, value.length() - 1);
					while (result.contains("\\S\\")) {
						int index = result.indexOf("\\S\\");
						char x = result.charAt(index + 3);
						ByteBuffer b = ByteBuffer.wrap(new byte[]{(byte) (x + 128)});
						CharBuffer decode = Charsets.ISO_8859_1.decode(b);
						result = result.substring(0, index) + decode.get() + result.substring(index + 4);
					}
					while (result.contains("\\X\\")) {
						int index = result.indexOf("\\X\\");
						int code = Integer.parseInt(result.substring(index + 3, index + 5), 16);
						ByteBuffer b = ByteBuffer.wrap(new byte[]{(byte) (code)});
						CharBuffer decode = Charsets.ISO_8859_1.decode(b);
						result = result.substring(0, index) + decode.get() + result.substring(index + 5);
					}
					if (result.contains("\\X0\\") || result.contains("\\X2\\") || result.contains("\\X4\\")) {
						throw new DeserializeException("Unsupported string encoding: ISO 10646");
					}
					return result;
				} else {
					return value;
				}
			}
		}
		return null;
	}

	private Object convert(EClassifier classifier, String value) throws DeserializeException {
		if (classifier != null) {
			if (classifier instanceof EClassImpl) {
				if (null != ((EClassImpl) classifier).getEStructuralFeature(WRAPPED_VALUE)) {
					IdEObject create = (IdEObject) ePackage.getEFactoryInstance().create((EClass) classifier);
					Class<?> instanceClass = create.eClass().getEStructuralFeature(WRAPPED_VALUE).getEType().getInstanceClass();
					if (value.equals("")) {

					} else {
						if (instanceClass == Integer.class || instanceClass == int.class) {
							try {
								create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Integer.parseInt(value));
							} catch (NumberFormatException e) {
								throw new DeserializeException(value + " is not a valid integer value");
							}
						} else if (instanceClass == Long.class || instanceClass == long.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Long.parseLong(value));
						} else if (instanceClass == Boolean.class || instanceClass == boolean.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), value.equals(".T."));
						} else if (instanceClass == Double.class || instanceClass == double.class) {
							try {
								create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Double.parseDouble(value));
							} catch (NumberFormatException e) {
								throw new DeserializeException(value + " is not a valid double floating point number");
							}
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE + "AsString"), value);
						} else if (instanceClass == String.class) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), value.substring(1, value.length() - 1));
						} else if (instanceClass == Tristate.class) {
							Tristate tristate = null;
							if (value.equals(".T.")) {
								tristate = Tristate.TRUE;
							} else if (value.equals(".F.")) {
								tristate = Tristate.FALSE;
							} else if (value.equals(".U.")) {
								tristate = Tristate.UNDEFINED;
							}
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), tristate);
						}
					}
					return create;
				} else {
					return processInline(classifier, value);
				}
			} else if (classifier instanceof EDataType) {
				return convertSimpleValue(classifier.getInstanceClass(), value);
			}
		}
		return null;
	}

	private Object processInline(EClassifier classifier, String value) throws DeserializeException {
		if (value.indexOf("(") != -1) {
			String typeName = value.substring(0, value.indexOf("(")).trim();
			String v = value.substring(value.indexOf("(") + 1, value.length() - 1);
			EClass cl = (EClass) classes.get(typeName);
			if (cl == null) {
				DefinedType typeBN = schema.getTypeBN(typeName);
				if (typeBN == null) {
					throw new DeserializeException(typeName + " is not an existing IFC entity");
				}
				return convertSimpleValue(typeBN.getDomain(), v);
			} else {
				return convert(cl, v);
			}
		} else {
			return convertSimpleValue(classifier.getInstanceClass(), value);
		}
	}

	private Object convertSimpleValue(UnderlyingType domain, String value) {
		if (!value.equals("")) {
			if (domain instanceof RealType) {
				return Double.parseDouble(value);
			} else if (domain instanceof IntegerType) {
				return Integer.parseInt(value);
			} else if (domain instanceof BooleanType) {
				return Boolean.parseBoolean(value);
			} else if (domain instanceof StringType) {
				return value;
			}
		}
		return null;
	}

	private void readEnum(String val, EObject object, EStructuralFeature structuralFeature) throws DeserializeException {
		if (val.equals(".T.")) {
			if (structuralFeature.getEType() == Ifc2x3Package.eINSTANCE.getTristate()) {
				object.eSet(structuralFeature, Tristate.TRUE);
			} else if (structuralFeature.getEType().getName().equals("IfcBoolean")) {
				IfcBoolean createIfcBoolean = Ifc2x3Factory.eINSTANCE.createIfcBoolean();
				createIfcBoolean.setWrappedValue(Tristate.TRUE);
				object.eSet(structuralFeature, createIfcBoolean);
			} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
				object.eSet(structuralFeature, true);
			} else {
				IfcLogical createIfcBoolean = Ifc2x3Factory.eINSTANCE.createIfcLogical();
				createIfcBoolean.setWrappedValue(Tristate.TRUE);
				object.eSet(structuralFeature, createIfcBoolean);
			}
		} else if (val.equals(".F.")) {
			if (structuralFeature.getEType() == Ifc2x3Package.eINSTANCE.getTristate()) {
				object.eSet(structuralFeature, Tristate.FALSE);
			} else if (structuralFeature.getEType().getName().equals("IfcBoolean")) {
				IfcBoolean createIfcBoolean = Ifc2x3Factory.eINSTANCE.createIfcBoolean();
				createIfcBoolean.setWrappedValue(Tristate.FALSE);
				object.eSet(structuralFeature, createIfcBoolean);
			} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
				object.eSet(structuralFeature, false);
			} else {
				IfcLogical createIfcBoolean = Ifc2x3Factory.eINSTANCE.createIfcLogical();
				createIfcBoolean.setWrappedValue(Tristate.FALSE);
				object.eSet(structuralFeature, createIfcBoolean);
			}
		} else if (val.equals(".U.")) {
			if (structuralFeature.getEType() == Ifc2x3Package.eINSTANCE.getTristate()) {
				object.eSet(structuralFeature, Tristate.UNDEFINED);
			} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
				object.eUnset(structuralFeature);
			} else {
				IfcLogical createIfcBoolean = Ifc2x3Factory.eINSTANCE.createIfcLogical();
				createIfcBoolean.setWrappedValue(Tristate.UNDEFINED);
				object.eSet(structuralFeature, createIfcBoolean);
			}
		} else {
			if (structuralFeature.getEType() instanceof EEnumImpl) {
				String realEnumValue = val.substring(1, val.length() - 1);
				EEnumLiteral enumValue = (((EEnumImpl) structuralFeature.getEType()).getEEnumLiteral(realEnumValue));
				if (enumValue == null) {
					throw new DeserializeException("Enum type " + structuralFeature.getEType().getName() + " has no literal value '" + realEnumValue + "'");
				}
				object.eSet(structuralFeature, enumValue.getInstance());
			} else {
				throw new DeserializeException("Value " + val + " indicates enum type but " + structuralFeature.getEType().getName() + " expected");
			}
		}
	}

	private void readReference(String val, EObject object, EStructuralFeature structuralFeature) throws DeserializeException {
		long referenceId;
		try {
			referenceId = Long.parseLong(val.substring(1));
		} catch (NumberFormatException e) {
			throw new DeserializeException("'" + val + "' is not a valid reference");
		}
		if (model.contains(referenceId)) {
			object.eSet(structuralFeature, model.get(referenceId));
		} else {
			List<WaitingObject> waitingList = null;
			if (waitingObjects.containsKey(referenceId)) {
				waitingList = waitingObjects.get(referenceId);
			} else {
				waitingList = new ArrayList<WaitingObject>();
				waitingObjects.put(referenceId, waitingList);
			}
			waitingList.add(new WaitingObject(object, structuralFeature, -1));
		}
	}
}