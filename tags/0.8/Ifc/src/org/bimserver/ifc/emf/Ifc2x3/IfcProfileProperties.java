/**
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
 * 
 *
 * $Id$
 */
package org.bimserver.ifc.emf.Ifc2x3;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcProfileProperties#getProfileName <em>Profile Name</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcProfileProperties#getProfileDefinition <em>Profile Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcProfileProperties()
 * @model
 * @generated
 */
public interface IfcProfileProperties extends EObject {
	/**
	 * Returns the value of the '<em><b>Profile Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Name</em>' reference.
	 * @see #isSetProfileName()
	 * @see #unsetProfileName()
	 * @see #setProfileName(IfcLabel)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcProfileProperties_ProfileName()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLabel getProfileName();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcProfileProperties#getProfileName <em>Profile Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Name</em>' reference.
	 * @see #isSetProfileName()
	 * @see #unsetProfileName()
	 * @see #getProfileName()
	 * @generated
	 */
	void setProfileName(IfcLabel value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcProfileProperties#getProfileName <em>Profile Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProfileName()
	 * @see #getProfileName()
	 * @see #setProfileName(IfcLabel)
	 * @generated
	 */
	void unsetProfileName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcProfileProperties#getProfileName <em>Profile Name</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Profile Name</em>' reference is set.
	 * @see #unsetProfileName()
	 * @see #getProfileName()
	 * @see #setProfileName(IfcLabel)
	 * @generated
	 */
	boolean isSetProfileName();

	/**
	 * Returns the value of the '<em><b>Profile Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Definition</em>' reference.
	 * @see #isSetProfileDefinition()
	 * @see #unsetProfileDefinition()
	 * @see #setProfileDefinition(IfcProfileDef)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcProfileProperties_ProfileDefinition()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcProfileDef getProfileDefinition();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcProfileProperties#getProfileDefinition <em>Profile Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Definition</em>' reference.
	 * @see #isSetProfileDefinition()
	 * @see #unsetProfileDefinition()
	 * @see #getProfileDefinition()
	 * @generated
	 */
	void setProfileDefinition(IfcProfileDef value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcProfileProperties#getProfileDefinition <em>Profile Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProfileDefinition()
	 * @see #getProfileDefinition()
	 * @see #setProfileDefinition(IfcProfileDef)
	 * @generated
	 */
	void unsetProfileDefinition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcProfileProperties#getProfileDefinition <em>Profile Definition</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Profile Definition</em>' reference is set.
	 * @see #unsetProfileDefinition()
	 * @see #getProfileDefinition()
	 * @see #setProfileDefinition(IfcProfileDef)
	 * @generated
	 */
	boolean isSetProfileDefinition();

} // IfcProfileProperties