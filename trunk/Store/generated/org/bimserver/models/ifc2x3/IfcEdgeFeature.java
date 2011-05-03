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

import org.bimserver.models.ifc2x3.IfcFeatureElementSubtraction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Edge Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEdgeFeature#getFeatureLength <em>Feature Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEdgeFeature#getFeatureLengthAsString <em>Feature Length As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEdgeFeature()
 * @model
 * @generated
 */
public interface IfcEdgeFeature extends IfcFeatureElementSubtraction
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * Returns the value of the '<em><b>Feature Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Length</em>' attribute.
	 * @see #isSetFeatureLength()
	 * @see #unsetFeatureLength()
	 * @see #setFeatureLength(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEdgeFeature_FeatureLength()
	 * @model unsettable="true"
	 * @generated
	 */
	float getFeatureLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEdgeFeature#getFeatureLength <em>Feature Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Length</em>' attribute.
	 * @see #isSetFeatureLength()
	 * @see #unsetFeatureLength()
	 * @see #getFeatureLength()
	 * @generated
	 */
	void setFeatureLength(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcEdgeFeature#getFeatureLength <em>Feature Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFeatureLength()
	 * @see #getFeatureLength()
	 * @see #setFeatureLength(float)
	 * @generated
	 */
	void unsetFeatureLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcEdgeFeature#getFeatureLength <em>Feature Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Feature Length</em>' attribute is set.
	 * @see #unsetFeatureLength()
	 * @see #getFeatureLength()
	 * @see #setFeatureLength(float)
	 * @generated
	 */
	boolean isSetFeatureLength();

	/**
	 * Returns the value of the '<em><b>Feature Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Length As String</em>' attribute.
	 * @see #isSetFeatureLengthAsString()
	 * @see #unsetFeatureLengthAsString()
	 * @see #setFeatureLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEdgeFeature_FeatureLengthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFeatureLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEdgeFeature#getFeatureLengthAsString <em>Feature Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Length As String</em>' attribute.
	 * @see #isSetFeatureLengthAsString()
	 * @see #unsetFeatureLengthAsString()
	 * @see #getFeatureLengthAsString()
	 * @generated
	 */
	void setFeatureLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcEdgeFeature#getFeatureLengthAsString <em>Feature Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFeatureLengthAsString()
	 * @see #getFeatureLengthAsString()
	 * @see #setFeatureLengthAsString(String)
	 * @generated
	 */
	void unsetFeatureLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcEdgeFeature#getFeatureLengthAsString <em>Feature Length As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Feature Length As String</em>' attribute is set.
	 * @see #unsetFeatureLengthAsString()
	 * @see #getFeatureLengthAsString()
	 * @see #setFeatureLengthAsString(String)
	 * @generated
	 */
	boolean isSetFeatureLengthAsString();

} // IfcEdgeFeature
