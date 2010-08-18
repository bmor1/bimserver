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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Revolved Area Solid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcRevolvedAreaSolid#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcRevolvedAreaSolid#getAngle <em>Angle</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcRevolvedAreaSolid#getAxisLine <em>Axis Line</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid()
 * @model
 * @generated
 */
public interface IfcRevolvedAreaSolid extends IfcSweptAreaSolid {
	/**
	 * Returns the value of the '<em><b>Axis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis</em>' reference.
	 * @see #setAxis(IfcAxis1Placement)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid_Axis()
	 * @model
	 * @generated
	 */
	IfcAxis1Placement getAxis();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcRevolvedAreaSolid#getAxis <em>Axis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis</em>' reference.
	 * @see #getAxis()
	 * @generated
	 */
	void setAxis(IfcAxis1Placement value);

	/**
	 * Returns the value of the '<em><b>Angle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angle</em>' reference.
	 * @see #setAngle(IfcPlaneAngleMeasure)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid_Angle()
	 * @model
	 * @generated
	 */
	IfcPlaneAngleMeasure getAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcRevolvedAreaSolid#getAngle <em>Angle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angle</em>' reference.
	 * @see #getAngle()
	 * @generated
	 */
	void setAngle(IfcPlaneAngleMeasure value);

	/**
	 * Returns the value of the '<em><b>Axis Line</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis Line</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Line</em>' reference.
	 * @see #setAxisLine(IfcLine)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid_AxisLine()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.iso.org/iso10303-11/EXPRESS code=' IfcRepresentationItem() || IfcGeometricRepresentationItem () || IfcCurve() || IfcLine(Axis.Location,                    IfcRepresentationItem() || IfcGeometricRepresentationItem () || IfcVector(Axis.Z,1.0));'"
	 * @generated
	 */
	IfcLine getAxisLine();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcRevolvedAreaSolid#getAxisLine <em>Axis Line</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Line</em>' reference.
	 * @see #getAxisLine()
	 * @generated
	 */
	void setAxisLine(IfcLine value);

} // IfcRevolvedAreaSolid
