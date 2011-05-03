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

import org.bimserver.models.ifc2x3.IfcConnectionGeometry;
import org.bimserver.models.ifc2x3.IfcCurveOrEdgeCurve;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Connection Curve Geometry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionCurveGeometry#getCurveOnRelatingElement <em>Curve On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionCurveGeometry#getCurveOnRelatedElement <em>Curve On Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionCurveGeometry()
 * @model
 * @generated
 */
public interface IfcConnectionCurveGeometry extends IfcConnectionGeometry
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * Returns the value of the '<em><b>Curve On Relating Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve On Relating Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve On Relating Element</em>' reference.
	 * @see #setCurveOnRelatingElement(IfcCurveOrEdgeCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionCurveGeometry_CurveOnRelatingElement()
	 * @model
	 * @generated
	 */
	IfcCurveOrEdgeCurve getCurveOnRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionCurveGeometry#getCurveOnRelatingElement <em>Curve On Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve On Relating Element</em>' reference.
	 * @see #getCurveOnRelatingElement()
	 * @generated
	 */
	void setCurveOnRelatingElement(IfcCurveOrEdgeCurve value);

	/**
	 * Returns the value of the '<em><b>Curve On Related Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve On Related Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve On Related Element</em>' reference.
	 * @see #isSetCurveOnRelatedElement()
	 * @see #unsetCurveOnRelatedElement()
	 * @see #setCurveOnRelatedElement(IfcCurveOrEdgeCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionCurveGeometry_CurveOnRelatedElement()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCurveOrEdgeCurve getCurveOnRelatedElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionCurveGeometry#getCurveOnRelatedElement <em>Curve On Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve On Related Element</em>' reference.
	 * @see #isSetCurveOnRelatedElement()
	 * @see #unsetCurveOnRelatedElement()
	 * @see #getCurveOnRelatedElement()
	 * @generated
	 */
	void setCurveOnRelatedElement(IfcCurveOrEdgeCurve value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionCurveGeometry#getCurveOnRelatedElement <em>Curve On Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurveOnRelatedElement()
	 * @see #getCurveOnRelatedElement()
	 * @see #setCurveOnRelatedElement(IfcCurveOrEdgeCurve)
	 * @generated
	 */
	void unsetCurveOnRelatedElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionCurveGeometry#getCurveOnRelatedElement <em>Curve On Related Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Curve On Related Element</em>' reference is set.
	 * @see #unsetCurveOnRelatedElement()
	 * @see #getCurveOnRelatedElement()
	 * @see #setCurveOnRelatedElement(IfcCurveOrEdgeCurve)
	 * @generated
	 */
	boolean isSetCurveOnRelatedElement();

} // IfcConnectionCurveGeometry
