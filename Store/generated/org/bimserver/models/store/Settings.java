/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;

import org.bimserver.models.ifc2x3.impl.Ifc2x3PackageImpl;

import org.bimserver.models.log.LogPackage;

import org.bimserver.models.log.impl.LogPackageImpl;

import org.bimserver.models.store.*;

import org.bimserver.models.store.impl.CheckoutImpl;
import org.bimserver.models.store.impl.ClashDetectionSettingsImpl;
import org.bimserver.models.store.impl.ClashImpl;
import org.bimserver.models.store.impl.ConcreteRevisionImpl;
import org.bimserver.models.store.impl.EidClashImpl;
import org.bimserver.models.store.impl.GeoTagImpl;
import org.bimserver.models.store.impl.GuidClashImpl;
import org.bimserver.models.store.impl.IgnoreFileImpl;
import org.bimserver.models.store.impl.ProjectImpl;
import org.bimserver.models.store.impl.RevisionImpl;
import org.bimserver.models.store.impl.SerializerImpl;
import org.bimserver.models.store.impl.SettingsImpl;
import org.bimserver.models.store.impl.UserImpl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.Settings#isShowVersionUpgradeAvailable <em>Show Version Upgrade Available</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isUseCaching <em>Use Caching</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isAllowSelfRegistration <em>Allow Self Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isAutoTestClashes <em>Auto Test Clashes</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isIntelligentMerging <em>Intelligent Merging</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isCheckinMergingEnabled <em>Checkin Merging Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getRegistrationAddition <em>Registration Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getSmtpServer <em>Smtp Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getEmailSenderAddress <em>Email Sender Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getEnabledExportTypes <em>Enabled Export Types</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getCustomLogoAddress <em>Custom Logo Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getSiteAddress <em>Site Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getIgnoreFiles <em>Ignore Files</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getHeaderAddition <em>Header Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getFooterAddition <em>Footer Addition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getSettings()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Settings extends IdEObject
{
	/**
	 * Returns the value of the '<em><b>Show Version Upgrade Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Version Upgrade Available</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Version Upgrade Available</em>' attribute.
	 * @see #setShowVersionUpgradeAvailable(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_ShowVersionUpgradeAvailable()
	 * @model
	 * @generated
	 */
	boolean isShowVersionUpgradeAvailable();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isShowVersionUpgradeAvailable <em>Show Version Upgrade Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Version Upgrade Available</em>' attribute.
	 * @see #isShowVersionUpgradeAvailable()
	 * @generated
	 */
	void setShowVersionUpgradeAvailable(boolean value);

	/**
	 * Returns the value of the '<em><b>Send Confirmation Email After Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Send Confirmation Email After Registration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Send Confirmation Email After Registration</em>' attribute.
	 * @see #setSendConfirmationEmailAfterRegistration(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_SendConfirmationEmailAfterRegistration()
	 * @model
	 * @generated
	 */
	boolean isSendConfirmationEmailAfterRegistration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Send Confirmation Email After Registration</em>' attribute.
	 * @see #isSendConfirmationEmailAfterRegistration()
	 * @generated
	 */
	void setSendConfirmationEmailAfterRegistration(boolean value);

	/**
	 * Returns the value of the '<em><b>Use Caching</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Caching</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Caching</em>' attribute.
	 * @see #setUseCaching(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_UseCaching()
	 * @model
	 * @generated
	 */
	boolean isUseCaching();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isUseCaching <em>Use Caching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Caching</em>' attribute.
	 * @see #isUseCaching()
	 * @generated
	 */
	void setUseCaching(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Self Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Self Registration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Self Registration</em>' attribute.
	 * @see #setAllowSelfRegistration(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_AllowSelfRegistration()
	 * @model
	 * @generated
	 */
	boolean isAllowSelfRegistration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isAllowSelfRegistration <em>Allow Self Registration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Self Registration</em>' attribute.
	 * @see #isAllowSelfRegistration()
	 * @generated
	 */
	void setAllowSelfRegistration(boolean value);

	/**
	 * Returns the value of the '<em><b>Auto Test Clashes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Test Clashes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Test Clashes</em>' attribute.
	 * @see #setAutoTestClashes(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_AutoTestClashes()
	 * @model
	 * @generated
	 */
	boolean isAutoTestClashes();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isAutoTestClashes <em>Auto Test Clashes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Test Clashes</em>' attribute.
	 * @see #isAutoTestClashes()
	 * @generated
	 */
	void setAutoTestClashes(boolean value);

	/**
	 * Returns the value of the '<em><b>Intelligent Merging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intelligent Merging</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intelligent Merging</em>' attribute.
	 * @see #setIntelligentMerging(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_IntelligentMerging()
	 * @model
	 * @generated
	 */
	boolean isIntelligentMerging();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isIntelligentMerging <em>Intelligent Merging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intelligent Merging</em>' attribute.
	 * @see #isIntelligentMerging()
	 * @generated
	 */
	void setIntelligentMerging(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Users To Create Top Level Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Users To Create Top Level Projects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Users To Create Top Level Projects</em>' attribute.
	 * @see #setAllowUsersToCreateTopLevelProjects(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_AllowUsersToCreateTopLevelProjects()
	 * @model
	 * @generated
	 */
	boolean isAllowUsersToCreateTopLevelProjects();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Users To Create Top Level Projects</em>' attribute.
	 * @see #isAllowUsersToCreateTopLevelProjects()
	 * @generated
	 */
	void setAllowUsersToCreateTopLevelProjects(boolean value);

	/**
	 * Returns the value of the '<em><b>Checkin Merging Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkin Merging Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkin Merging Enabled</em>' attribute.
	 * @see #setCheckinMergingEnabled(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_CheckinMergingEnabled()
	 * @model
	 * @generated
	 */
	boolean isCheckinMergingEnabled();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isCheckinMergingEnabled <em>Checkin Merging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkin Merging Enabled</em>' attribute.
	 * @see #isCheckinMergingEnabled()
	 * @generated
	 */
	void setCheckinMergingEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Registration Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Addition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Addition</em>' attribute.
	 * @see #setRegistrationAddition(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_RegistrationAddition()
	 * @model
	 * @generated
	 */
	String getRegistrationAddition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getRegistrationAddition <em>Registration Addition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Addition</em>' attribute.
	 * @see #getRegistrationAddition()
	 * @generated
	 */
	void setRegistrationAddition(String value);

	/**
	 * Returns the value of the '<em><b>Smtp Server</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Server</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Server</em>' attribute.
	 * @see #setSmtpServer(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_SmtpServer()
	 * @model
	 * @generated
	 */
	String getSmtpServer();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getSmtpServer <em>Smtp Server</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smtp Server</em>' attribute.
	 * @see #getSmtpServer()
	 * @generated
	 */
	void setSmtpServer(String value);

	/**
	 * Returns the value of the '<em><b>Email Sender Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email Sender Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email Sender Address</em>' attribute.
	 * @see #setEmailSenderAddress(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_EmailSenderAddress()
	 * @model
	 * @generated
	 */
	String getEmailSenderAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getEmailSenderAddress <em>Email Sender Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email Sender Address</em>' attribute.
	 * @see #getEmailSenderAddress()
	 * @generated
	 */
	void setEmailSenderAddress(String value);

	/**
	 * Returns the value of the '<em><b>Enabled Export Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Export Types</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Export Types</em>' attribute.
	 * @see #setEnabledExportTypes(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_EnabledExportTypes()
	 * @model
	 * @generated
	 */
	String getEnabledExportTypes();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getEnabledExportTypes <em>Enabled Export Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Export Types</em>' attribute.
	 * @see #getEnabledExportTypes()
	 * @generated
	 */
	void setEnabledExportTypes(String value);

	/**
	 * Returns the value of the '<em><b>Custom Logo Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Logo Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Logo Address</em>' attribute.
	 * @see #setCustomLogoAddress(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_CustomLogoAddress()
	 * @model
	 * @generated
	 */
	String getCustomLogoAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getCustomLogoAddress <em>Custom Logo Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Logo Address</em>' attribute.
	 * @see #getCustomLogoAddress()
	 * @generated
	 */
	void setCustomLogoAddress(String value);

	/**
	 * Returns the value of the '<em><b>Site Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Site Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Site Address</em>' attribute.
	 * @see #setSiteAddress(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_SiteAddress()
	 * @model
	 * @generated
	 */
	String getSiteAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getSiteAddress <em>Site Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Site Address</em>' attribute.
	 * @see #getSiteAddress()
	 * @generated
	 */
	void setSiteAddress(String value);

	/**
	 * Returns the value of the '<em><b>Serializers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Serializer}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Serializer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getSettings_Serializers()
	 * @see org.bimserver.models.store.Serializer#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<Serializer> getSerializers();

	/**
	 * Returns the value of the '<em><b>Ignore Files</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.IgnoreFile}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.IgnoreFile#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignore Files</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignore Files</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getSettings_IgnoreFiles()
	 * @see org.bimserver.models.store.IgnoreFile#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<IgnoreFile> getIgnoreFiles();

	/**
	 * Returns the value of the '<em><b>Header Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Addition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Addition</em>' attribute.
	 * @see #setHeaderAddition(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_HeaderAddition()
	 * @model
	 * @generated
	 */
	String getHeaderAddition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getHeaderAddition <em>Header Addition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Addition</em>' attribute.
	 * @see #getHeaderAddition()
	 * @generated
	 */
	void setHeaderAddition(String value);

	/**
	 * Returns the value of the '<em><b>Footer Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footer Addition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Footer Addition</em>' attribute.
	 * @see #setFooterAddition(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_FooterAddition()
	 * @model
	 * @generated
	 */
	String getFooterAddition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getFooterAddition <em>Footer Addition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Footer Addition</em>' attribute.
	 * @see #getFooterAddition()
	 * @generated
	 */
	void setFooterAddition(String value);

} // Settings
