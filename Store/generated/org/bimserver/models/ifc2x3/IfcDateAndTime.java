/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Date And Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getDateComponent <em>Date Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getTimeComponent <em>Time Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDateAndTime()
 * @model
 * @generated
 */
public interface IfcDateAndTime extends IfcDateTimeSelect, IfcObjectReferenceSelect
{
	/**
	 * Returns the value of the '<em><b>Date Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Component</em>' reference.
	 * @see #setDateComponent(IfcCalendarDate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDateAndTime_DateComponent()
	 * @model
	 * @generated
	 */
	IfcCalendarDate getDateComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getDateComponent <em>Date Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Component</em>' reference.
	 * @see #getDateComponent()
	 * @generated
	 */
	void setDateComponent(IfcCalendarDate value);

	/**
	 * Returns the value of the '<em><b>Time Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Component</em>' reference.
	 * @see #setTimeComponent(IfcLocalTime)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDateAndTime_TimeComponent()
	 * @model
	 * @generated
	 */
	IfcLocalTime getTimeComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getTimeComponent <em>Time Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Component</em>' reference.
	 * @see #getTimeComponent()
	 * @generated
	 */
	void setTimeComponent(IfcLocalTime value);

} // IfcDateAndTime