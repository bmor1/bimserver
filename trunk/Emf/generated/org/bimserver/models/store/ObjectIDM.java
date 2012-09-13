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
package org.bimserver.models.store;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object IDM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.ObjectIDM#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.ObjectIDM#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getObjectIDM()
 * @model
 * @generated
 */
public interface ObjectIDM extends Plugin {
	/**
	 * Returns the value of the '<em><b>Serializers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Serializer}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Serializer#getObjectIDM <em>Object IDM</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getObjectIDM_Serializers()
	 * @see org.bimserver.models.store.Serializer#getObjectIDM
	 * @model opposite="objectIDM"
	 * @generated
	 */
	EList<Serializer> getSerializers();

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.UserSettings#getObjectIDMs <em>Object ID Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' reference.
	 * @see #setSettings(UserSettings)
	 * @see org.bimserver.models.store.StorePackage#getObjectIDM_Settings()
	 * @see org.bimserver.models.store.UserSettings#getObjectIDMs
	 * @model opposite="objectIDMs"
	 * @generated
	 */
	UserSettings getSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ObjectIDM#getSettings <em>Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(UserSettings value);

} // ObjectIDM
