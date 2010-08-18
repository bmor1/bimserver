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
 * A representation of the model object '<em><b>Ifc Light Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getLightColour <em>Light Colour</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getAmbientIntensity <em>Ambient Intensity</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getIntensity <em>Intensity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcLightSource()
 * @model
 * @generated
 */
public interface IfcLightSource extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' reference.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(IfcLabel)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcLightSource_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLabel getName();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getName <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' reference.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(IfcLabel value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getName <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(IfcLabel)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getName <em>Name</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' reference is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(IfcLabel)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Light Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Light Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Light Colour</em>' reference.
	 * @see #setLightColour(IfcColourRgb)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcLightSource_LightColour()
	 * @model
	 * @generated
	 */
	IfcColourRgb getLightColour();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getLightColour <em>Light Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Light Colour</em>' reference.
	 * @see #getLightColour()
	 * @generated
	 */
	void setLightColour(IfcColourRgb value);

	/**
	 * Returns the value of the '<em><b>Ambient Intensity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ambient Intensity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ambient Intensity</em>' reference.
	 * @see #isSetAmbientIntensity()
	 * @see #unsetAmbientIntensity()
	 * @see #setAmbientIntensity(IfcNormalisedRatioMeasure)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcLightSource_AmbientIntensity()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcNormalisedRatioMeasure getAmbientIntensity();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getAmbientIntensity <em>Ambient Intensity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ambient Intensity</em>' reference.
	 * @see #isSetAmbientIntensity()
	 * @see #unsetAmbientIntensity()
	 * @see #getAmbientIntensity()
	 * @generated
	 */
	void setAmbientIntensity(IfcNormalisedRatioMeasure value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getAmbientIntensity <em>Ambient Intensity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAmbientIntensity()
	 * @see #getAmbientIntensity()
	 * @see #setAmbientIntensity(IfcNormalisedRatioMeasure)
	 * @generated
	 */
	void unsetAmbientIntensity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getAmbientIntensity <em>Ambient Intensity</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ambient Intensity</em>' reference is set.
	 * @see #unsetAmbientIntensity()
	 * @see #getAmbientIntensity()
	 * @see #setAmbientIntensity(IfcNormalisedRatioMeasure)
	 * @generated
	 */
	boolean isSetAmbientIntensity();

	/**
	 * Returns the value of the '<em><b>Intensity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intensity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intensity</em>' reference.
	 * @see #isSetIntensity()
	 * @see #unsetIntensity()
	 * @see #setIntensity(IfcNormalisedRatioMeasure)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcLightSource_Intensity()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcNormalisedRatioMeasure getIntensity();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getIntensity <em>Intensity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intensity</em>' reference.
	 * @see #isSetIntensity()
	 * @see #unsetIntensity()
	 * @see #getIntensity()
	 * @generated
	 */
	void setIntensity(IfcNormalisedRatioMeasure value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getIntensity <em>Intensity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntensity()
	 * @see #getIntensity()
	 * @see #setIntensity(IfcNormalisedRatioMeasure)
	 * @generated
	 */
	void unsetIntensity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcLightSource#getIntensity <em>Intensity</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Intensity</em>' reference is set.
	 * @see #unsetIntensity()
	 * @see #getIntensity()
	 * @see #setIntensity(IfcNormalisedRatioMeasure)
	 * @generated
	 */
	boolean isSetIntensity();

} // IfcLightSource
