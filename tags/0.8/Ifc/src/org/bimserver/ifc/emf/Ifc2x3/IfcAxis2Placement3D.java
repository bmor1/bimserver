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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Axis2 Placement3 D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D#getRefDirection <em>Ref Direction</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D#getP <em>P</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcAxis2Placement3D()
 * @model
 * @generated
 */
public interface IfcAxis2Placement3D extends IfcPlacement, IfcAxis2Placement {
	/**
	 * Returns the value of the '<em><b>Axis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis</em>' reference.
	 * @see #isSetAxis()
	 * @see #unsetAxis()
	 * @see #setAxis(IfcDirection)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcAxis2Placement3D_Axis()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getAxis();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D#getAxis <em>Axis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis</em>' reference.
	 * @see #isSetAxis()
	 * @see #unsetAxis()
	 * @see #getAxis()
	 * @generated
	 */
	void setAxis(IfcDirection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D#getAxis <em>Axis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAxis()
	 * @see #getAxis()
	 * @see #setAxis(IfcDirection)
	 * @generated
	 */
	void unsetAxis();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D#getAxis <em>Axis</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Axis</em>' reference is set.
	 * @see #unsetAxis()
	 * @see #getAxis()
	 * @see #setAxis(IfcDirection)
	 * @generated
	 */
	boolean isSetAxis();

	/**
	 * Returns the value of the '<em><b>Ref Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Direction</em>' reference.
	 * @see #isSetRefDirection()
	 * @see #unsetRefDirection()
	 * @see #setRefDirection(IfcDirection)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcAxis2Placement3D_RefDirection()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getRefDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D#getRefDirection <em>Ref Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Direction</em>' reference.
	 * @see #isSetRefDirection()
	 * @see #unsetRefDirection()
	 * @see #getRefDirection()
	 * @generated
	 */
	void setRefDirection(IfcDirection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D#getRefDirection <em>Ref Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefDirection()
	 * @see #getRefDirection()
	 * @see #setRefDirection(IfcDirection)
	 * @generated
	 */
	void unsetRefDirection();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D#getRefDirection <em>Ref Direction</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ref Direction</em>' reference is set.
	 * @see #unsetRefDirection()
	 * @see #getRefDirection()
	 * @see #setRefDirection(IfcDirection)
	 * @generated
	 */
	boolean isSetRefDirection();

	/**
	 * Returns the value of the '<em><b>P</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.ifc.emf.Ifc2x3.IfcDirection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>P</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>P</em>' reference list.
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcAxis2Placement3D_P()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.iso.org/iso10303-11/EXPRESS code=' IfcBuildAxes(Axis, RefDirection);'"
	 * @generated
	 */
	EList<IfcDirection> getP();

} // IfcAxis2Placement3D
