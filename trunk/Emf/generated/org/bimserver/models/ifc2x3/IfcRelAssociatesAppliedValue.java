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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Associates Applied Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssociatesAppliedValue#getRelatingAppliedValue <em>Relating Applied Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesAppliedValue()
 * @model
 * @generated
 */
public interface IfcRelAssociatesAppliedValue extends IfcRelAssociates {
	/**
	 * Returns the value of the '<em><b>Relating Applied Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Applied Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Applied Value</em>' reference.
	 * @see #isSetRelatingAppliedValue()
	 * @see #unsetRelatingAppliedValue()
	 * @see #setRelatingAppliedValue(IfcAppliedValue)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesAppliedValue_RelatingAppliedValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAppliedValue getRelatingAppliedValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesAppliedValue#getRelatingAppliedValue <em>Relating Applied Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Applied Value</em>' reference.
	 * @see #isSetRelatingAppliedValue()
	 * @see #unsetRelatingAppliedValue()
	 * @see #getRelatingAppliedValue()
	 * @generated
	 */
	void setRelatingAppliedValue(IfcAppliedValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesAppliedValue#getRelatingAppliedValue <em>Relating Applied Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingAppliedValue()
	 * @see #getRelatingAppliedValue()
	 * @see #setRelatingAppliedValue(IfcAppliedValue)
	 * @generated
	 */
	void unsetRelatingAppliedValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesAppliedValue#getRelatingAppliedValue <em>Relating Applied Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Applied Value</em>' reference is set.
	 * @see #unsetRelatingAppliedValue()
	 * @see #getRelatingAppliedValue()
	 * @see #setRelatingAppliedValue(IfcAppliedValue)
	 * @generated
	 */
	boolean isSetRelatingAppliedValue();

} // IfcRelAssociatesAppliedValue
