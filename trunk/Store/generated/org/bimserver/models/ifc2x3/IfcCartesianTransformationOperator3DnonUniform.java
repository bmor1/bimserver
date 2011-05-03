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

import org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3D;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Cartesian Transformation Operator3 Dnon Uniform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3DnonUniform#getScale2 <em>Scale2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3DnonUniform#getScale2AsString <em>Scale2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3DnonUniform#getScale3 <em>Scale3</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3DnonUniform#getScale3AsString <em>Scale3 As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator3DnonUniform()
 * @model
 * @generated
 */
public interface IfcCartesianTransformationOperator3DnonUniform extends IfcCartesianTransformationOperator3D
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * Returns the value of the '<em><b>Scale2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale2</em>' attribute.
	 * @see #setScale2(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator3DnonUniform_Scale2()
	 * @model
	 * @generated
	 */
	float getScale2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3DnonUniform#getScale2 <em>Scale2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale2</em>' attribute.
	 * @see #getScale2()
	 * @generated
	 */
	void setScale2(float value);

	/**
	 * Returns the value of the '<em><b>Scale2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale2 As String</em>' attribute.
	 * @see #setScale2AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator3DnonUniform_Scale2AsString()
	 * @model
	 * @generated
	 */
	String getScale2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3DnonUniform#getScale2AsString <em>Scale2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale2 As String</em>' attribute.
	 * @see #getScale2AsString()
	 * @generated
	 */
	void setScale2AsString(String value);

	/**
	 * Returns the value of the '<em><b>Scale3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale3</em>' attribute.
	 * @see #setScale3(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator3DnonUniform_Scale3()
	 * @model
	 * @generated
	 */
	float getScale3();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3DnonUniform#getScale3 <em>Scale3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale3</em>' attribute.
	 * @see #getScale3()
	 * @generated
	 */
	void setScale3(float value);

	/**
	 * Returns the value of the '<em><b>Scale3 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale3 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale3 As String</em>' attribute.
	 * @see #setScale3AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator3DnonUniform_Scale3AsString()
	 * @model
	 * @generated
	 */
	String getScale3AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3DnonUniform#getScale3AsString <em>Scale3 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale3 As String</em>' attribute.
	 * @see #getScale3AsString()
	 * @generated
	 */
	void setScale3AsString(String value);

} // IfcCartesianTransformationOperator3DnonUniform
