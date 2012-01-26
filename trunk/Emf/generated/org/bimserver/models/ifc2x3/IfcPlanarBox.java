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
 * A representation of the model object '<em><b>Ifc Planar Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPlanarBox#getPlacement <em>Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPlanarBox()
 * @model
 * @generated
 */
public interface IfcPlanarBox extends IfcPlanarExtent {
	/**
	 * Returns the value of the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement</em>' reference.
	 * @see #isSetPlacement()
	 * @see #unsetPlacement()
	 * @see #setPlacement(IfcAxis2Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPlanarBox_Placement()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement getPlacement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPlanarBox#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' reference.
	 * @see #isSetPlacement()
	 * @see #unsetPlacement()
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(IfcAxis2Placement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPlanarBox#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlacement()
	 * @see #getPlacement()
	 * @see #setPlacement(IfcAxis2Placement)
	 * @generated
	 */
	void unsetPlacement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPlanarBox#getPlacement <em>Placement</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Placement</em>' reference is set.
	 * @see #unsetPlacement()
	 * @see #getPlacement()
	 * @see #setPlacement(IfcAxis2Placement)
	 * @generated
	 */
	boolean isSetPlacement();

} // IfcPlanarBox
