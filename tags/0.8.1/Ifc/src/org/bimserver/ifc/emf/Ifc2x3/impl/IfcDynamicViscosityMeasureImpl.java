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
package org.bimserver.ifc.emf.Ifc2x3.impl;

import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.emf.Ifc2x3.IfcDynamicViscosityMeasure;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Dynamic Viscosity Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcDynamicViscosityMeasureImpl#getWrappedValue <em>Wrapped Value</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcDynamicViscosityMeasureImpl#getStringValuewrappedValue <em>String Valuewrapped Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDynamicViscosityMeasureImpl extends WrappedValueImpl implements IfcDynamicViscosityMeasure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDynamicViscosityMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDynamicViscosityMeasure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWrappedValue() {
		return (Float) eGet(Ifc2x3Package.eINSTANCE.getIfcDynamicViscosityMeasure_WrappedValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrappedValue(float newWrappedValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDynamicViscosityMeasure_WrappedValue(), newWrappedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStringValuewrappedValue() {
		return (String) eGet(Ifc2x3Package.eINSTANCE.getIfcDynamicViscosityMeasure_StringValuewrappedValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringValuewrappedValue(String newStringValuewrappedValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDynamicViscosityMeasure_StringValuewrappedValue(), newStringValuewrappedValue);
	}

} //IfcDynamicViscosityMeasureImpl