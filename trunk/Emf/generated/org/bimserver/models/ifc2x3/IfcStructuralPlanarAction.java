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
 * A representation of the model object '<em><b>Ifc Structural Planar Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralPlanarAction#getProjectedOrTrue <em>Projected Or True</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralPlanarAction()
 * @model
 * @generated
 */
public interface IfcStructuralPlanarAction extends IfcStructuralAction {
	/**
	 * Returns the value of the '<em><b>Projected Or True</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcProjectedOrTrueLengthEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projected Or True</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projected Or True</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcProjectedOrTrueLengthEnum
	 * @see #isSetProjectedOrTrue()
	 * @see #unsetProjectedOrTrue()
	 * @see #setProjectedOrTrue(IfcProjectedOrTrueLengthEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralPlanarAction_ProjectedOrTrue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcProjectedOrTrueLengthEnum getProjectedOrTrue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralPlanarAction#getProjectedOrTrue <em>Projected Or True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Projected Or True</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcProjectedOrTrueLengthEnum
	 * @see #isSetProjectedOrTrue()
	 * @see #unsetProjectedOrTrue()
	 * @see #getProjectedOrTrue()
	 * @generated
	 */
	void setProjectedOrTrue(IfcProjectedOrTrueLengthEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralPlanarAction#getProjectedOrTrue <em>Projected Or True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProjectedOrTrue()
	 * @see #getProjectedOrTrue()
	 * @see #setProjectedOrTrue(IfcProjectedOrTrueLengthEnum)
	 * @generated
	 */
	void unsetProjectedOrTrue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralPlanarAction#getProjectedOrTrue <em>Projected Or True</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Projected Or True</em>' attribute is set.
	 * @see #unsetProjectedOrTrue()
	 * @see #getProjectedOrTrue()
	 * @see #setProjectedOrTrue(IfcProjectedOrTrueLengthEnum)
	 * @generated
	 */
	boolean isSetProjectedOrTrue();

} // IfcStructuralPlanarAction
