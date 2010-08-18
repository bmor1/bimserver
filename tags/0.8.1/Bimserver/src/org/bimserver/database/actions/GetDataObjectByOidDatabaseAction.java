package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ReadSet;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.VirtualRevision;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.emf.Ifc2x3.IfcGloballyUniqueId;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.bimserver.ifc.emf.Ifc2x3.WrappedValue;
import org.bimserver.shared.DataObject;
import org.bimserver.shared.UserException;
import org.bimserver.shared.DataObject.ListDataValue;
import org.bimserver.shared.DataObject.ReferenceDataValue;
import org.bimserver.shared.DataObject.SimpleDataValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class GetDataObjectByOidDatabaseAction extends BimDatabaseAction<DataObject> {

	private final int pid;
	private final int rid;
	private final long oid;
	private final short cid;

	public GetDataObjectByOidDatabaseAction(int pid, int rid, long oid, short cid) {
		this.pid = pid;
		this.rid = rid;
		this.oid = oid;
		this.cid = cid;
	}

	@Override
	public DataObject execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		HashBiMap<Long, EObject> mapResult = HashBiMap.create();
		
		VirtualRevision virtualRevision = bimDatabaseSession.getVirtualRevision(pid, rid);
		EObject eObject = null;
		for (ConcreteRevision concreteRevision : virtualRevision.getRevisions()) {
			ReadSet readSet = new ReadSet(concreteRevision.getProject().getId(), concreteRevision.getId());
			eObject = bimDatabaseSession.get(cid, oid, readSet, mapResult);
		}
		
		DataObject dataObject = null;
		if (eObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot)eObject;
			dataObject = new DataObject(eObject.eClass().getName(), oid, ifcRoot.getGlobalId().getWrappedValue(), ifcRoot.getName().getWrappedValue());
		} else {
			dataObject = new DataObject(eObject.eClass().getName(), oid, null, null);
		}
		fillDataObject(mapResult, eObject, dataObject);
		return dataObject;
	}

	@SuppressWarnings("unchecked")
	public static void fillDataObject(BiMap<Long, EObject> mapResult, EObject eObject, DataObject dataObject) {
		for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
			Object eGet = eObject.eGet(eStructuralFeature);
			if (eStructuralFeature instanceof EAttribute) {
				dataObject.addField(eStructuralFeature.getName(), new SimpleDataValue(eGet));
			} else if (eStructuralFeature instanceof EReference) {
				if (eStructuralFeature.getUpperBound() == 1) {
					EObject eObject2 = (EObject) eGet;
					if (eObject2 != null) {
						if (eObject2 instanceof WrappedValue || eObject2 instanceof IfcGloballyUniqueId) {
							EObject referenceEObject = (EObject) eGet;
							dataObject.addField(eStructuralFeature.getName(), new SimpleDataValue(referenceEObject.eGet(referenceEObject.eClass().getEStructuralFeature(
									"wrappedValue"))));
						} else {
							Long oid = mapResult.inverse().get(eObject2);
							String guid = getGuid(eObject2);
							dataObject.addField(eStructuralFeature.getName(), new ReferenceDataValue(eObject2.eClass().getName(), oid, guid));
						}
					} else {
						dataObject.addField(eStructuralFeature.getName(), null);
					}
				} else {
					EList<? extends EObject> list = (EList<EObject>)eGet;
					for (EObject item : list) {
						ListDataValue dataValue = new ListDataValue();
						dataObject.addField(eStructuralFeature.getName(), dataValue);
						if (item instanceof WrappedValue || item instanceof IfcGloballyUniqueId) {
							EObject referenceEObject = (EObject) item;
							dataValue.addValue(referenceEObject.eGet(referenceEObject.eClass().getEStructuralFeature("wrappedValue")));
						} else {
							Long oid = mapResult.inverse().get(item);
							String guid = getGuid(item);
							dataValue.addValue(item.eClass().getName(), oid, guid);
						}
					}
				}
			}
		}
	}

	private static String getGuid(EObject eObject2) {
		String guid = null;
		if (Ifc2x3Package.eINSTANCE.getIfcRoot().isSuperTypeOf(eObject2.eClass())) {
			EObject guidObject = (EObject) eObject2.eGet(eObject2.eClass().getEStructuralFeature("GlobalId"));
			if (guidObject != null) {
				guid = (String) guidObject.eGet(guidObject.eClass().getEStructuralFeature("wrappedValue"));
			}
		}
		return guid;
	}
}