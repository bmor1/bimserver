/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.database.store.Project#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getHasAuthorizedUsers <em>Has Authorized Users</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getConcreteRevisions <em>Concrete Revisions</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getVirtualRevisions <em>Virtual Revisions</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getLastConcreteRevision <em>Last Concrete Revision</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getLastVirtualRevision <em>Last Virtual Revision</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getCheckouts <em>Checkouts</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getCreatedDate <em>Created Date</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getGeoTag <em>Geo Tag</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getSubProjects <em>Sub Projects</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getParent <em>Parent</em>}</li>
 *   <li>{@link org.bimserver.database.store.Project#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.database.store.StorePackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.database.store.StorePackage#getProject_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Has Authorized Users</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.database.store.User}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.database.store.User#getHasRightsOn <em>Has Rights On</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Authorized Users</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Authorized Users</em>' reference list.
	 * @see org.bimserver.database.store.StorePackage#getProject_HasAuthorizedUsers()
	 * @see org.bimserver.database.store.User#getHasRightsOn
	 * @model opposite="hasRightsOn"
	 * @generated
	 */
	EList<User> getHasAuthorizedUsers();

	/**
	 * Returns the value of the '<em><b>Concrete Revisions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.database.store.ConcreteRevision}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.database.store.ConcreteRevision#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Revisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Revisions</em>' reference list.
	 * @see org.bimserver.database.store.StorePackage#getProject_ConcreteRevisions()
	 * @see org.bimserver.database.store.ConcreteRevision#getProject
	 * @model opposite="project"
	 * @generated
	 */
	EList<ConcreteRevision> getConcreteRevisions();

	/**
	 * Returns the value of the '<em><b>Virtual Revisions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.database.store.VirtualRevision}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.database.store.VirtualRevision#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual Revisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual Revisions</em>' reference list.
	 * @see org.bimserver.database.store.StorePackage#getProject_VirtualRevisions()
	 * @see org.bimserver.database.store.VirtualRevision#getProject
	 * @model opposite="project"
	 * @generated
	 */
	EList<VirtualRevision> getVirtualRevisions();

	/**
	 * Returns the value of the '<em><b>Last Concrete Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Concrete Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Concrete Revision</em>' reference.
	 * @see #setLastConcreteRevision(ConcreteRevision)
	 * @see org.bimserver.database.store.StorePackage#getProject_LastConcreteRevision()
	 * @model required="true"
	 * @generated
	 */
	ConcreteRevision getLastConcreteRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getLastConcreteRevision <em>Last Concrete Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Concrete Revision</em>' reference.
	 * @see #getLastConcreteRevision()
	 * @generated
	 */
	void setLastConcreteRevision(ConcreteRevision value);

	/**
	 * Returns the value of the '<em><b>Last Virtual Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Virtual Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Virtual Revision</em>' reference.
	 * @see #setLastVirtualRevision(VirtualRevision)
	 * @see org.bimserver.database.store.StorePackage#getProject_LastVirtualRevision()
	 * @model
	 * @generated
	 */
	VirtualRevision getLastVirtualRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getLastVirtualRevision <em>Last Virtual Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Virtual Revision</em>' reference.
	 * @see #getLastVirtualRevision()
	 * @generated
	 */
	void setLastVirtualRevision(VirtualRevision value);

	/**
	 * Returns the value of the '<em><b>Checkouts</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.database.store.Checkout}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.database.store.Checkout#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkouts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkouts</em>' reference list.
	 * @see org.bimserver.database.store.StorePackage#getProject_Checkouts()
	 * @see org.bimserver.database.store.Checkout#getProject
	 * @model opposite="project"
	 * @generated
	 */
	EList<Checkout> getCheckouts();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see org.bimserver.database.store.StorePackage#getProject_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.database.store.ObjectState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.bimserver.database.store.ObjectState
	 * @see #setState(ObjectState)
	 * @see org.bimserver.database.store.StorePackage#getProject_State()
	 * @model
	 * @generated
	 */
	ObjectState getState();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.bimserver.database.store.ObjectState
	 * @see #getState()
	 * @generated
	 */
	void setState(ObjectState value);

	/**
	 * Returns the value of the '<em><b>Created Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created Date</em>' attribute.
	 * @see #setCreatedDate(Date)
	 * @see org.bimserver.database.store.StorePackage#getProject_CreatedDate()
	 * @model
	 * @generated
	 */
	Date getCreatedDate();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getCreatedDate <em>Created Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created Date</em>' attribute.
	 * @see #getCreatedDate()
	 * @generated
	 */
	void setCreatedDate(Date value);

	/**
	 * Returns the value of the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created By</em>' reference.
	 * @see #setCreatedBy(User)
	 * @see org.bimserver.database.store.StorePackage#getProject_CreatedBy()
	 * @model
	 * @generated
	 */
	User getCreatedBy();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getCreatedBy <em>Created By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created By</em>' reference.
	 * @see #getCreatedBy()
	 * @generated
	 */
	void setCreatedBy(User value);

	/**
	 * Returns the value of the '<em><b>Geo Tag</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Geo Tag</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geo Tag</em>' reference.
	 * @see #setGeoTag(GeoTag)
	 * @see org.bimserver.database.store.StorePackage#getProject_GeoTag()
	 * @model
	 * @generated
	 */
	GeoTag getGeoTag();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getGeoTag <em>Geo Tag</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geo Tag</em>' reference.
	 * @see #getGeoTag()
	 * @generated
	 */
	void setGeoTag(GeoTag value);

	/**
	 * Returns the value of the '<em><b>Sub Projects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.database.store.Project}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.database.store.Project#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Projects</em>' reference list.
	 * @see org.bimserver.database.store.StorePackage#getProject_SubProjects()
	 * @see org.bimserver.database.store.Project#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<Project> getSubProjects();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.database.store.Project#getSubProjects <em>Sub Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Project)
	 * @see org.bimserver.database.store.StorePackage#getProject_Parent()
	 * @see org.bimserver.database.store.Project#getSubProjects
	 * @model opposite="subProjects"
	 * @generated
	 */
	Project getParent();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Project value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.bimserver.database.store.StorePackage#getProject_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Project#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Project
