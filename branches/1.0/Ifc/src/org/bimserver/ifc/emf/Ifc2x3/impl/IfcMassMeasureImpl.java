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
import org.bimserver.ifc.emf.Ifc2x3.IfcMassMeasure;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mass Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMassMeasureImpl#getWrappedValue <em>Wrapped Value</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMassMeasureImpl#getWrappedValueAsString <em>Wrapped Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMassMeasureImpl extends WrappedValueImpl implements IfcMassMeasure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMassMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcMassMeasure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWrappedValue() {
		return (Float) eGet(Ifc2x3Package.eINSTANCE.getIfcMassMeasure_WrappedValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrappedValue(float newWrappedValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMassMeasure_WrappedValue(), newWrappedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWrappedValueAsString() {
		return (String) eGet(Ifc2x3Package.eINSTANCE.getIfcMassMeasure_WrappedValueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrappedValueAsString(String newWrappedValueAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMassMeasure_WrappedValueAsString(), newWrappedValueAsString);
	}

} //IfcMassMeasureImpl