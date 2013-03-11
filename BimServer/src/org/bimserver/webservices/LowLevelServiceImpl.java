package org.bimserver.webservices;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.changes.AddAttributeChange;
import org.bimserver.changes.AddReferenceChange;
import org.bimserver.changes.CreateObjectChange;
import org.bimserver.changes.RemoveAttributeChange;
import org.bimserver.changes.RemoveObjectChange;
import org.bimserver.changes.RemoveReferenceChange;
import org.bimserver.changes.SetAttributeChange;
import org.bimserver.changes.SetReferenceChange;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.CommitTransactionDatabaseAction;
import org.bimserver.database.actions.GetDataObjectByGuidDatabaseAction;
import org.bimserver.database.actions.GetDataObjectByOidDatabaseAction;
import org.bimserver.database.actions.GetDataObjectsByTypeDatabaseAction;
import org.bimserver.database.actions.GetDataObjectsDatabaseAction;
import org.bimserver.emf.IdEObject;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowLevelServiceImpl extends GenericServiceImpl implements LowLevelInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(LowLevelServiceImpl.class);
	
	public LowLevelServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public Long startTransaction(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		int pid = -1;
		int rid = -1;
		try {
			Project project = (Project) session.get(poid, Query.getDefault());
			pid = project.getId();
			if (project.getLastRevision() != null) {
				Revision revision = project.getLastRevision();
				ConcreteRevision lastConcreteRevision = revision.getLastConcreteRevision();
				rid = lastConcreteRevision.getId();
			}
			LongTransaction longTransaction = getBimServer().getLongTransactionManager().newLongTransaction(poid, pid, rid);
			return longTransaction.getTid();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long commitTransaction(Long tid, String comment) throws UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		LongTransaction longTransaction = getBimServer().getLongTransactionManager().get(tid);
		if (longTransaction == null) {
			throw new UserException("No transaction with tid " + tid + " was found");
		}
		CommitTransactionDatabaseAction action = new CommitTransactionDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), longTransaction, comment);
		try {
			session.executeAndCommitAction(action);
			return action.getRevision().getOid();
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return -1L;
	}

	@Override
	public void abortTransaction(Long tid) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).close();
	}

	@Override
	public void addStringAttribute(Long tid, Long oid, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addIntegerAttribute(Long tid, Long oid, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addDoubleAttribute(Long tid, Long oid, String attributeName, Double value) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public void setDoubleAttributes(Long tid, Long oid, String attributeName, List<Double> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
	}

	@Override
	public void setIntegerAttributes(Long tid, Long oid, String attributeName, List<Integer> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
	}

	@Override
	public void setLongAttributes(Long tid, Long oid, String attributeName, List<Long> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
	}

	@Override
	public void setBooleanAttributes(Long tid, Long oid, String attributeName, List<Boolean> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
	}

	@Override
	public void addBooleanAttribute(Long tid, Long oid, String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addReference(Long tid, Long oid, String referenceName, Long referenceOid) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new AddReferenceChange(oid, referenceName, referenceOid));
	}

	@Override
	public Long createObject(Long tid, String className) throws UserException {
		requireAuthenticationAndRunningServer();
		EClass eClass = ((Database) getBimServer().getDatabase()).getEClassForName(className);
		if (eClass == null) {
			throw new UserException("Unknown type: \"" + className + "\"");
		}
		Long oid = getBimServer().getDatabase().newOid(eClass);
		CreateObjectChange createObject = new CreateObjectChange(className, oid, eClass);
		LongTransaction longTransaction = getBimServer().getLongTransactionManager().get(tid);
		if (longTransaction == null) {
			throw new UserException("No transaction with tid " + tid + " was found");
		}
		longTransaction.add(createObject);
		return oid;
	}

	@Override
	public void removeAttribute(Long tid, Long oid, String attributeName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new RemoveAttributeChange(oid, attributeName, index));
	}

	@Override
	public void removeObject(Long tid, Long oid) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new RemoveObjectChange(oid, getBimServer().getDatabase().getEClassForOid(oid)));
	}

	@Override
	public void removeReference(Long tid, Long oid, String referenceName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new RemoveReferenceChange(oid, referenceName, index));
	}

	@Override
	public void setStringAttribute(Long tid, Long oid, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public String getStringAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return (String)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public void setIntegerAttribute(Long tid, Long oid, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}

	@Override
	public void setByteArrayAttribute(Long tid, Long oid, String attributeName, Byte[] value) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public void setLongAttribute(Long tid, Long oid, String attributeName, Long value) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	public Integer getIntegerAttribute(Long tid, Long oid, String attributeName) throws ServerException ,UserException {
		return (Integer)getAttribute(tid, oid, attributeName);
	}

	public Long getLongAttribute(Long tid, Long oid, String attributeName) throws ServerException ,UserException {
		return (Long)getAttribute(tid, oid, attributeName);
	}

	@Override
	public void setBooleanAttribute(Long tid, Long oid, String attributeName, Boolean value) throws UserException {
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public Boolean getBooleanAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (Boolean)getAttribute(tid, oid, attributeName);
	}

	@Override
	public void setDoubleAttribute(Long tid, Long oid, String attributeName, Double value) throws UserException {
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public Double getDoubleAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (Double)getAttribute(tid, oid, attributeName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Double> getDoubleAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<Double>)getAttribute(tid, oid, attributeName);
	}

	@SuppressWarnings("unchecked")
	public List<Boolean> getBooleanAttributes(Long tid, Long oid, String attributeName) throws ServerException ,UserException {
		return (List<Boolean>)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public byte[] getByteArrayAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (byte[])getAttribute(tid, oid, attributeName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<byte[]> getByteArrayAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<byte[]>)getAttribute(tid, oid, attributeName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getIntegerAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<Integer>)getAttribute(tid, oid, attributeName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStringAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<String>)getAttribute(tid, oid, attributeName);
	}
	
	private Object getAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			LongTransaction transaction = getBimServer().getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new Query(transaction.getPid(), transaction.getRid(), null, Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			return object.eGet(object.eClass().getEStructuralFeature(attributeName));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setEnumAttribute(Long tid, Long oid, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public String getEnumAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return (String)getAttribute(tid, oid, attributeName);
	}

	@Override
	public void setReference(Long tid, Long oid, String referenceName, Long referenceOid) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetReferenceChange(oid, referenceName, referenceOid));
	}
	
	@Override
	public Long getReference(Long tid, Long oid, String referenceName) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			LongTransaction transaction = getBimServer().getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new Query(transaction.getPid(), transaction.getRid(), null, Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			IdEObject ref = (IdEObject) object.eGet(object.eClass().getEStructuralFeature(referenceName));
			if (ref == null) {
				return -1L;
			}
			return ref.getOid();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getReferences(Long tid, Long oid, String referenceName) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			LongTransaction transaction = getBimServer().getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new Query(transaction.getPid(), transaction.getRid(), null, Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			List<IdEObject> list = (List<IdEObject>) object.eGet(object.eClass().getEStructuralFeature(referenceName));
			List<Long> oidList = new ArrayList<Long>();
			for (IdEObject idEObject : list) {
				oidList.add(idEObject.getOid());
			}
			return oidList;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void unsetAttribute(Long tid, Long oid, String attributeName) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, null));
	}

	@Override
	public void unsetReference(Long tid, Long oid, String referenceName) throws UserException {
		requireAuthenticationAndRunningServer();
		getBimServer().getLongTransactionManager().get(tid).add(new SetReferenceChange(oid, referenceName, -1));
	}
	
	@Override
	public List<SDataObject> getDataObjects(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<List<DataObject>> action = new GetDataObjectsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), roid, getAuthorization());
			return getBimServer().getSConverter().convertToSListDataObject(session.executeAndCommitAction(action));
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}
	
	
	@Override
	public SDataObject getDataObjectByGuid(Long roid, String guid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByGuidDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, guid, getAuthorization());
			SDataObject dataObject = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
			return dataObject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SDataObject> getDataObjectsByType(Long roid, String className) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		BimDatabaseAction<List<DataObject>> action = new GetDataObjectsByTypeDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, className, getAuthorization());
		try {
			List<DataObject> dataObjects = session.executeAndCommitAction(action);
			return getBimServer().getSConverter().convertToSListDataObject(dataObjects);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SDataObject getDataObjectByOid(Long roid, Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByOidDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, oid, getAuthorization());
			SDataObject dataObject = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
			return dataObject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
}