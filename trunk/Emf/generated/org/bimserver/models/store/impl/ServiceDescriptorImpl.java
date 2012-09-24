/**
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
 */
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.log.AccessMethod;

import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getToken <em>Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getNotificationProtocol <em>Notification Protocol</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#isReadRevision <em>Read Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#isReadExtendedData <em>Read Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#isWriteRevision <em>Write Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#isWriteExtendedData <em>Write Extended Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceDescriptorImpl extends IdEObjectImpl implements ServiceDescriptor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SERVICE_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__URL, newUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToken() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__TOKEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToken(String newToken) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__TOKEN, newToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessMethod getNotificationProtocol() {
		return (AccessMethod) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__NOTIFICATION_PROTOCOL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotificationProtocol(AccessMethod newNotificationProtocol) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__NOTIFICATION_PROTOCOL, newNotificationProtocol);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger getTrigger() {
		return (Trigger) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__TRIGGER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrigger(Trigger newTrigger) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__TRIGGER, newTrigger);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadRevision() {
		return (Boolean) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__READ_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadRevision(boolean newReadRevision) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__READ_REVISION, newReadRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadExtendedData() {
		return (Boolean) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__READ_EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadExtendedData(boolean newReadExtendedData) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__READ_EXTENDED_DATA, newReadExtendedData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWriteRevision() {
		return (Boolean) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__WRITE_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteRevision(boolean newWriteRevision) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__WRITE_REVISION, newWriteRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWriteExtendedData() {
		return (Boolean) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__WRITE_EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteExtendedData(boolean newWriteExtendedData) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__WRITE_EXTENDED_DATA, newWriteExtendedData);
	}

} //ServiceDescriptorImpl
