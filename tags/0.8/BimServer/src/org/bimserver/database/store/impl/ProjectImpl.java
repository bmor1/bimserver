/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.impl;

import java.util.Collection;
import java.util.Date;

import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.GeoTag;
import org.bimserver.database.store.ObjectState;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.VirtualRevision;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getHasAuthorizedUsers <em>Has Authorized Users</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getConcreteRevisions <em>Concrete Revisions</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getVirtualRevisions <em>Virtual Revisions</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getLastConcreteRevision <em>Last Concrete Revision</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getLastVirtualRevision <em>Last Virtual Revision</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getCheckouts <em>Checkouts</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getCreatedDate <em>Created Date</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getGeoTag <em>Geo Tag</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getSubProjects <em>Sub Projects</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ProjectImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectImpl extends EObjectImpl implements Project {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHasAuthorizedUsers() <em>Has Authorized Users</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasAuthorizedUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<User> hasAuthorizedUsers;

	/**
	 * The cached value of the '{@link #getConcreteRevisions() <em>Concrete Revisions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteRevisions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConcreteRevision> concreteRevisions;

	/**
	 * The cached value of the '{@link #getVirtualRevisions() <em>Virtual Revisions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualRevisions()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualRevision> virtualRevisions;

	/**
	 * The cached value of the '{@link #getLastConcreteRevision() <em>Last Concrete Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastConcreteRevision()
	 * @generated
	 * @ordered
	 */
	protected ConcreteRevision lastConcreteRevision;

	/**
	 * The cached value of the '{@link #getLastVirtualRevision() <em>Last Virtual Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastVirtualRevision()
	 * @generated
	 * @ordered
	 */
	protected VirtualRevision lastVirtualRevision;

	/**
	 * The cached value of the '{@link #getCheckouts() <em>Checkouts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckouts()
	 * @generated
	 * @ordered
	 */
	protected EList<Checkout> checkouts;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ObjectState STATE_EDEFAULT = ObjectState.ACTIVE;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ObjectState state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreatedDate() <em>Created Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATED_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreatedDate() <em>Created Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedDate()
	 * @generated
	 * @ordered
	 */
	protected Date createdDate = CREATED_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCreatedBy() <em>Created By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedBy()
	 * @generated
	 * @ordered
	 */
	protected User createdBy;

	/**
	 * The cached value of the '{@link #getGeoTag() <em>Geo Tag</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeoTag()
	 * @generated
	 * @ordered
	 */
	protected GeoTag geoTag;

	/**
	 * The cached value of the '{@link #getSubProjects() <em>Sub Projects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> subProjects;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Project parent;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<User> getHasAuthorizedUsers() {
		if (hasAuthorizedUsers == null) {
			hasAuthorizedUsers = new EObjectWithInverseResolvingEList.ManyInverse<User>(User.class, this, StorePackage.PROJECT__HAS_AUTHORIZED_USERS, StorePackage.USER__HAS_RIGHTS_ON);
		}
		return hasAuthorizedUsers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteRevision> getConcreteRevisions() {
		if (concreteRevisions == null) {
			concreteRevisions = new EObjectWithInverseResolvingEList<ConcreteRevision>(ConcreteRevision.class, this, StorePackage.PROJECT__CONCRETE_REVISIONS, StorePackage.CONCRETE_REVISION__PROJECT);
		}
		return concreteRevisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualRevision> getVirtualRevisions() {
		if (virtualRevisions == null) {
			virtualRevisions = new EObjectWithInverseResolvingEList<VirtualRevision>(VirtualRevision.class, this, StorePackage.PROJECT__VIRTUAL_REVISIONS, StorePackage.VIRTUAL_REVISION__PROJECT);
		}
		return virtualRevisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteRevision getLastConcreteRevision() {
		if (lastConcreteRevision != null && lastConcreteRevision.eIsProxy()) {
			InternalEObject oldLastConcreteRevision = (InternalEObject)lastConcreteRevision;
			lastConcreteRevision = (ConcreteRevision)eResolveProxy(oldLastConcreteRevision);
			if (lastConcreteRevision != oldLastConcreteRevision) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.PROJECT__LAST_CONCRETE_REVISION, oldLastConcreteRevision, lastConcreteRevision));
			}
		}
		return lastConcreteRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteRevision basicGetLastConcreteRevision() {
		return lastConcreteRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastConcreteRevision(ConcreteRevision newLastConcreteRevision) {
		ConcreteRevision oldLastConcreteRevision = lastConcreteRevision;
		lastConcreteRevision = newLastConcreteRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__LAST_CONCRETE_REVISION, oldLastConcreteRevision, lastConcreteRevision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualRevision getLastVirtualRevision() {
		if (lastVirtualRevision != null && lastVirtualRevision.eIsProxy()) {
			InternalEObject oldLastVirtualRevision = (InternalEObject)lastVirtualRevision;
			lastVirtualRevision = (VirtualRevision)eResolveProxy(oldLastVirtualRevision);
			if (lastVirtualRevision != oldLastVirtualRevision) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.PROJECT__LAST_VIRTUAL_REVISION, oldLastVirtualRevision, lastVirtualRevision));
			}
		}
		return lastVirtualRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualRevision basicGetLastVirtualRevision() {
		return lastVirtualRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastVirtualRevision(VirtualRevision newLastVirtualRevision) {
		VirtualRevision oldLastVirtualRevision = lastVirtualRevision;
		lastVirtualRevision = newLastVirtualRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__LAST_VIRTUAL_REVISION, oldLastVirtualRevision, lastVirtualRevision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Checkout> getCheckouts() {
		if (checkouts == null) {
			checkouts = new EObjectWithInverseResolvingEList<Checkout>(Checkout.class, this, StorePackage.PROJECT__CHECKOUTS, StorePackage.CHECKOUT__PROJECT);
		}
		return checkouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ObjectState newState) {
		ObjectState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedDate(Date newCreatedDate) {
		Date oldCreatedDate = createdDate;
		createdDate = newCreatedDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__CREATED_DATE, oldCreatedDate, createdDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getCreatedBy() {
		if (createdBy != null && createdBy.eIsProxy()) {
			InternalEObject oldCreatedBy = (InternalEObject)createdBy;
			createdBy = (User)eResolveProxy(oldCreatedBy);
			if (createdBy != oldCreatedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.PROJECT__CREATED_BY, oldCreatedBy, createdBy));
			}
		}
		return createdBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetCreatedBy() {
		return createdBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedBy(User newCreatedBy) {
		User oldCreatedBy = createdBy;
		createdBy = newCreatedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__CREATED_BY, oldCreatedBy, createdBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoTag getGeoTag() {
		if (geoTag != null && geoTag.eIsProxy()) {
			InternalEObject oldGeoTag = (InternalEObject)geoTag;
			geoTag = (GeoTag)eResolveProxy(oldGeoTag);
			if (geoTag != oldGeoTag) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.PROJECT__GEO_TAG, oldGeoTag, geoTag));
			}
		}
		return geoTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoTag basicGetGeoTag() {
		return geoTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeoTag(GeoTag newGeoTag) {
		GeoTag oldGeoTag = geoTag;
		geoTag = newGeoTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__GEO_TAG, oldGeoTag, geoTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getSubProjects() {
		if (subProjects == null) {
			subProjects = new EObjectWithInverseResolvingEList<Project>(Project.class, this, StorePackage.PROJECT__SUB_PROJECTS, StorePackage.PROJECT__PARENT);
		}
		return subProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (Project)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.PROJECT__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Project newParent, NotificationChain msgs) {
		Project oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Project newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, StorePackage.PROJECT__SUB_PROJECTS, Project.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, StorePackage.PROJECT__SUB_PROJECTS, Project.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.PROJECT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StorePackage.PROJECT__HAS_AUTHORIZED_USERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHasAuthorizedUsers()).basicAdd(otherEnd, msgs);
			case StorePackage.PROJECT__CONCRETE_REVISIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConcreteRevisions()).basicAdd(otherEnd, msgs);
			case StorePackage.PROJECT__VIRTUAL_REVISIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVirtualRevisions()).basicAdd(otherEnd, msgs);
			case StorePackage.PROJECT__CHECKOUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCheckouts()).basicAdd(otherEnd, msgs);
			case StorePackage.PROJECT__SUB_PROJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubProjects()).basicAdd(otherEnd, msgs);
			case StorePackage.PROJECT__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, StorePackage.PROJECT__SUB_PROJECTS, Project.class, msgs);
				return basicSetParent((Project)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StorePackage.PROJECT__HAS_AUTHORIZED_USERS:
				return ((InternalEList<?>)getHasAuthorizedUsers()).basicRemove(otherEnd, msgs);
			case StorePackage.PROJECT__CONCRETE_REVISIONS:
				return ((InternalEList<?>)getConcreteRevisions()).basicRemove(otherEnd, msgs);
			case StorePackage.PROJECT__VIRTUAL_REVISIONS:
				return ((InternalEList<?>)getVirtualRevisions()).basicRemove(otherEnd, msgs);
			case StorePackage.PROJECT__CHECKOUTS:
				return ((InternalEList<?>)getCheckouts()).basicRemove(otherEnd, msgs);
			case StorePackage.PROJECT__SUB_PROJECTS:
				return ((InternalEList<?>)getSubProjects()).basicRemove(otherEnd, msgs);
			case StorePackage.PROJECT__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StorePackage.PROJECT__NAME:
				return getName();
			case StorePackage.PROJECT__HAS_AUTHORIZED_USERS:
				return getHasAuthorizedUsers();
			case StorePackage.PROJECT__CONCRETE_REVISIONS:
				return getConcreteRevisions();
			case StorePackage.PROJECT__VIRTUAL_REVISIONS:
				return getVirtualRevisions();
			case StorePackage.PROJECT__LAST_CONCRETE_REVISION:
				if (resolve) return getLastConcreteRevision();
				return basicGetLastConcreteRevision();
			case StorePackage.PROJECT__LAST_VIRTUAL_REVISION:
				if (resolve) return getLastVirtualRevision();
				return basicGetLastVirtualRevision();
			case StorePackage.PROJECT__CHECKOUTS:
				return getCheckouts();
			case StorePackage.PROJECT__ID:
				return getId();
			case StorePackage.PROJECT__STATE:
				return getState();
			case StorePackage.PROJECT__CREATED_DATE:
				return getCreatedDate();
			case StorePackage.PROJECT__CREATED_BY:
				if (resolve) return getCreatedBy();
				return basicGetCreatedBy();
			case StorePackage.PROJECT__GEO_TAG:
				if (resolve) return getGeoTag();
				return basicGetGeoTag();
			case StorePackage.PROJECT__SUB_PROJECTS:
				return getSubProjects();
			case StorePackage.PROJECT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case StorePackage.PROJECT__DESCRIPTION:
				return getDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StorePackage.PROJECT__NAME:
				setName((String)newValue);
				return;
			case StorePackage.PROJECT__HAS_AUTHORIZED_USERS:
				getHasAuthorizedUsers().clear();
				getHasAuthorizedUsers().addAll((Collection<? extends User>)newValue);
				return;
			case StorePackage.PROJECT__CONCRETE_REVISIONS:
				getConcreteRevisions().clear();
				getConcreteRevisions().addAll((Collection<? extends ConcreteRevision>)newValue);
				return;
			case StorePackage.PROJECT__VIRTUAL_REVISIONS:
				getVirtualRevisions().clear();
				getVirtualRevisions().addAll((Collection<? extends VirtualRevision>)newValue);
				return;
			case StorePackage.PROJECT__LAST_CONCRETE_REVISION:
				setLastConcreteRevision((ConcreteRevision)newValue);
				return;
			case StorePackage.PROJECT__LAST_VIRTUAL_REVISION:
				setLastVirtualRevision((VirtualRevision)newValue);
				return;
			case StorePackage.PROJECT__CHECKOUTS:
				getCheckouts().clear();
				getCheckouts().addAll((Collection<? extends Checkout>)newValue);
				return;
			case StorePackage.PROJECT__ID:
				setId((Integer)newValue);
				return;
			case StorePackage.PROJECT__STATE:
				setState((ObjectState)newValue);
				return;
			case StorePackage.PROJECT__CREATED_DATE:
				setCreatedDate((Date)newValue);
				return;
			case StorePackage.PROJECT__CREATED_BY:
				setCreatedBy((User)newValue);
				return;
			case StorePackage.PROJECT__GEO_TAG:
				setGeoTag((GeoTag)newValue);
				return;
			case StorePackage.PROJECT__SUB_PROJECTS:
				getSubProjects().clear();
				getSubProjects().addAll((Collection<? extends Project>)newValue);
				return;
			case StorePackage.PROJECT__PARENT:
				setParent((Project)newValue);
				return;
			case StorePackage.PROJECT__DESCRIPTION:
				setDescription((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StorePackage.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StorePackage.PROJECT__HAS_AUTHORIZED_USERS:
				getHasAuthorizedUsers().clear();
				return;
			case StorePackage.PROJECT__CONCRETE_REVISIONS:
				getConcreteRevisions().clear();
				return;
			case StorePackage.PROJECT__VIRTUAL_REVISIONS:
				getVirtualRevisions().clear();
				return;
			case StorePackage.PROJECT__LAST_CONCRETE_REVISION:
				setLastConcreteRevision((ConcreteRevision)null);
				return;
			case StorePackage.PROJECT__LAST_VIRTUAL_REVISION:
				setLastVirtualRevision((VirtualRevision)null);
				return;
			case StorePackage.PROJECT__CHECKOUTS:
				getCheckouts().clear();
				return;
			case StorePackage.PROJECT__ID:
				setId(ID_EDEFAULT);
				return;
			case StorePackage.PROJECT__STATE:
				setState(STATE_EDEFAULT);
				return;
			case StorePackage.PROJECT__CREATED_DATE:
				setCreatedDate(CREATED_DATE_EDEFAULT);
				return;
			case StorePackage.PROJECT__CREATED_BY:
				setCreatedBy((User)null);
				return;
			case StorePackage.PROJECT__GEO_TAG:
				setGeoTag((GeoTag)null);
				return;
			case StorePackage.PROJECT__SUB_PROJECTS:
				getSubProjects().clear();
				return;
			case StorePackage.PROJECT__PARENT:
				setParent((Project)null);
				return;
			case StorePackage.PROJECT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StorePackage.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StorePackage.PROJECT__HAS_AUTHORIZED_USERS:
				return hasAuthorizedUsers != null && !hasAuthorizedUsers.isEmpty();
			case StorePackage.PROJECT__CONCRETE_REVISIONS:
				return concreteRevisions != null && !concreteRevisions.isEmpty();
			case StorePackage.PROJECT__VIRTUAL_REVISIONS:
				return virtualRevisions != null && !virtualRevisions.isEmpty();
			case StorePackage.PROJECT__LAST_CONCRETE_REVISION:
				return lastConcreteRevision != null;
			case StorePackage.PROJECT__LAST_VIRTUAL_REVISION:
				return lastVirtualRevision != null;
			case StorePackage.PROJECT__CHECKOUTS:
				return checkouts != null && !checkouts.isEmpty();
			case StorePackage.PROJECT__ID:
				return id != ID_EDEFAULT;
			case StorePackage.PROJECT__STATE:
				return state != STATE_EDEFAULT;
			case StorePackage.PROJECT__CREATED_DATE:
				return CREATED_DATE_EDEFAULT == null ? createdDate != null : !CREATED_DATE_EDEFAULT.equals(createdDate);
			case StorePackage.PROJECT__CREATED_BY:
				return createdBy != null;
			case StorePackage.PROJECT__GEO_TAG:
				return geoTag != null;
			case StorePackage.PROJECT__SUB_PROJECTS:
				return subProjects != null && !subProjects.isEmpty();
			case StorePackage.PROJECT__PARENT:
				return parent != null;
			case StorePackage.PROJECT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", state: ");
		result.append(state);
		result.append(", createdDate: ");
		result.append(createdDate);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ProjectImpl