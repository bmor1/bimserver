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
 * A representation of the model object '<em><b>Ifc Face Bound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcFaceBound#getBound <em>Bound</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcFaceBound#getOrientation <em>Orientation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcFaceBound()
 * @model
 * @generated
 */
public interface IfcFaceBound extends IfcTopologicalRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound</em>' reference.
	 * @see #setBound(IfcLoop)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcFaceBound_Bound()
	 * @model
	 * @generated
	 */
	IfcLoop getBound();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcFaceBound#getBound <em>Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound</em>' reference.
	 * @see #getBound()
	 * @generated
	 */
	void setBound(IfcLoop value);

	/**
	 * Returns the value of the '<em><b>Orientation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation</em>' reference.
	 * @see #setOrientation(IfcLogical)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcFaceBound_Orientation()
	 * @model
	 * @generated
	 */
	IfcLogical getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcFaceBound#getOrientation <em>Orientation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' reference.
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(IfcLogical value);

} // IfcFaceBound
