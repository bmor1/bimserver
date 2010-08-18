package org.bimserver.ifc.database;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.bimserver.emf.EmfModel;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class IfcDatabase<K> {

	private final Map<Class<? extends EObject>, List<? extends EObject>> index = new HashMap<Class<? extends EObject>, List<? extends EObject>>();
	private final EmfModel<K> model;
	private final Map<EClass, Map<String, EObject>> guidIndex = new HashMap<EClass, Map<String, EObject>>();
	private final FieldIgnoreMap fieldIgnoreMap;

	public IfcDatabase(EmfModel<K> model, FieldIgnoreMap fieldIgnoreMap) {
		this.model = model;
		this.fieldIgnoreMap = fieldIgnoreMap;
	}

	@SuppressWarnings("unchecked")
	public void buildIndex(EPackage package1) {
		for (EClassifier classifier : package1.getEClassifiers()) {
			ArrayList<EObject> arrayList = new ArrayList<EObject>();
			index.put((Class<EObject>) classifier.getInstanceClass(), arrayList);
			index.put((Class<EObject>) classifier.getInstanceClass(), arrayList);
		}
		for (K key : model.keySet()) {
			EObject value = model.get((Long) key);
			if (value != null) {
				((List<EObject>) index.get(value.getClass())).add(value);
			}
		}
	}

	public void buildGuidIndex() {
		for (EClassifier classifier : model.getValues().iterator().next().eClass().getEPackage().getEClassifiers()) {
			if (classifier instanceof EClass) {
				Map<String, EObject> map = new TreeMap<String, EObject>();
				guidIndex.put((EClass) classifier, map);
			}
		}
		for (K key : model.keySet()) {
			EObject value = model.get((Long) key);
			if (value instanceof IfcRoot) {
				IfcRoot ifcRoot = (IfcRoot) value;
				sortAllAggregates(ifcRoot);
				guidIndex.get(value.eClass()).put(ifcRoot.getGlobalId().getWrappedValue(), value);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void sortAllAggregates(IfcRoot ifcRoot) {
		for (EStructuralFeature eStructuralFeature : ifcRoot.eClass().getEAllStructuralFeatures()) {
			if (!fieldIgnoreMap.shouldIgnoreField(ifcRoot.eClass(), ifcRoot.eClass(), eStructuralFeature)) {
				if (eStructuralFeature.getUpperBound() == -1 || eStructuralFeature.getUpperBound() > 1) {
					if (eStructuralFeature.getEType() instanceof EClass) {
						if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eStructuralFeature.getEType())) {
							EList<EObject> list = (EList<EObject>) ifcRoot.eGet(eStructuralFeature);
							sortPrimitiveList(list);
						} else {
							EList<EObject> list = (EList<EObject>) ifcRoot.eGet(eStructuralFeature);
							sortComplexList(ifcRoot.eClass(), list, eStructuralFeature);
						}
					}
				}
			}
		}
	}

	private void sortPrimitiveList(EList<EObject> list) {
		Collections.sort(list, new Comparator<EObject>() {
			@Override
			public int compare(EObject o1, EObject o2) {
				return comparePrimitives(o1, o2);
			}
		});
	}

	private void sortComplexList(final EClass originalQueryClass, EList<EObject> list, EStructuralFeature eStructuralFeature) {
		final EClass type = (EClass) eStructuralFeature.getEType();
		ECollections.sort(list, new Comparator<EObject>() {
			@Override
			public int compare(EObject o1, EObject o2) {
				int i=1;
				for (EStructuralFeature eStructuralFeature : type.getEAllStructuralFeatures()) {
					if (!fieldIgnoreMap.shouldIgnoreField(originalQueryClass, type, eStructuralFeature)) {
						Object val1 = o1.eGet(eStructuralFeature);
						Object val2 = o2.eGet(eStructuralFeature);
						if (val1 != null && val2 != null) {
							if (eStructuralFeature.getEType() instanceof EClass) {
								if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eStructuralFeature.getEType())) {
									int compare = comparePrimitives((EObject) val1, (EObject) val2);
									if (compare != 0) {
										return compare * i;
									}
								}
							}
						}
						i++;
					}
				}
				return 0;
			}
		});
	}

	private int comparePrimitives(EObject o1, EObject o2) {
		EClass eClass = o1.eClass();
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature("wrappedValue");
		Object val1 = o1.eGet(eStructuralFeature);
		Object val2 = o2.eGet(eStructuralFeature);
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
			return ((String) val1).compareTo((String) val2);
		} else if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEInt()) {
			return ((Integer) val1).compareTo((Integer) val2);
		} else {
			throw new RuntimeException("ni");
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getAll(Class<T> cl) {
		List<T> result = new ArrayList<T>();
		for (EObject object : model.getValues()) {
			if (object != null) {
				if (cl.isAssignableFrom(object.getClass())) {
					result.add((T) object);
				}
			}
		}
		return result;
	}

	public Set<String> getGuids(EClass eClass) {
		return guidIndex.get(eClass).keySet();
	}

	public EObject getByGuid(EClass eClass, String guid) {
		return guidIndex.get(eClass).get(guid);
	}
}