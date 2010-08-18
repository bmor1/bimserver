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
 * A representation of the model object '<em><b>Ifc Cost Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcCostValue#getCostType <em>Cost Type</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcCostValue#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcCostValue()
 * @model
 * @generated
 */
public interface IfcCostValue extends IfcAppliedValue, IfcMetricValueSelect {
	/**
	 * Returns the value of the '<em><b>Cost Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cost Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cost Type</em>' reference.
	 * @see #setCostType(IfcLabel)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcCostValue_CostType()
	 * @model
	 * @generated
	 */
	IfcLabel getCostType();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcCostValue#getCostType <em>Cost Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost Type</em>' reference.
	 * @see #getCostType()
	 * @generated
	 */
	void setCostType(IfcLabel value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #isSetCondition()
	 * @see #unsetCondition()
	 * @see #setCondition(IfcText)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcCostValue_Condition()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcText getCondition();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcCostValue#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #isSetCondition()
	 * @see #unsetCondition()
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(IfcText value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcCostValue#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCondition()
	 * @see #getCondition()
	 * @see #setCondition(IfcText)
	 * @generated
	 */
	void unsetCondition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcCostValue#getCondition <em>Condition</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Condition</em>' reference is set.
	 * @see #unsetCondition()
	 * @see #getCondition()
	 * @see #setCondition(IfcText)
	 * @generated
	 */
	boolean isSetCondition();

} // IfcCostValue
