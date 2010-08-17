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
 * A representation of the model object '<em><b>Ifc Offset Curve2 D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve2D#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve2D#getDistance <em>Distance</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve2D#getDistanceAsString <em>Distance As String</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve2D#isSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcOffsetCurve2D()
 * @model
 * @generated
 */
public interface IfcOffsetCurve2D extends IfcCurve {
	/**
	 * Returns the value of the '<em><b>Basis Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basis Curve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basis Curve</em>' reference.
	 * @see #setBasisCurve(IfcCurve)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcOffsetCurve2D_BasisCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getBasisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve2D#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Curve</em>' reference.
	 * @see #getBasisCurve()
	 * @generated
	 */
	void setBasisCurve(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance</em>' attribute.
	 * @see #setDistance(float)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcOffsetCurve2D_Distance()
	 * @model
	 * @generated
	 */
	float getDistance();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve2D#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' attribute.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(float value);

	/**
	 * Returns the value of the '<em><b>Distance As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance As String</em>' attribute.
	 * @see #setDistanceAsString(String)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcOffsetCurve2D_DistanceAsString()
	 * @model
	 * @generated
	 */
	String getDistanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve2D#getDistanceAsString <em>Distance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance As String</em>' attribute.
	 * @see #getDistanceAsString()
	 * @generated
	 */
	void setDistanceAsString(String value);

	/**
	 * Returns the value of the '<em><b>Self Intersect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Intersect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Intersect</em>' attribute.
	 * @see #setSelfIntersect(boolean)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcOffsetCurve2D_SelfIntersect()
	 * @model
	 * @generated
	 */
	boolean isSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve2D#isSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see #isSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(boolean value);

} // IfcOffsetCurve2D
