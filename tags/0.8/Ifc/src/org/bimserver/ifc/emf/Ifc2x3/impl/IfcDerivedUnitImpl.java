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

import org.bimserver.ifc.IfcRootObject;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.emf.Ifc2x3.IfcDerivedUnit;
import org.bimserver.ifc.emf.Ifc2x3.IfcDerivedUnitElement;
import org.bimserver.ifc.emf.Ifc2x3.IfcDerivedUnitEnum;
import org.bimserver.ifc.emf.Ifc2x3.IfcDimensionalExponents;
import org.bimserver.ifc.emf.Ifc2x3.IfcLabel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Derived Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcDerivedUnitImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcDerivedUnitImpl#getUnitType <em>Unit Type</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcDerivedUnitImpl#getUserDefinedType <em>User Defined Type</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcDerivedUnitImpl#getDimensions <em>Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDerivedUnitImpl extends IfcRootObject implements IfcDerivedUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDerivedUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDerivedUnit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDerivedUnitElement> getElements() {
		return (EList<IfcDerivedUnitElement>) eGet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_Elements(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedUnitEnum getUnitType() {
		return (IfcDerivedUnitEnum) eGet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UnitType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitType(IfcDerivedUnitEnum newUnitType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UnitType(), newUnitType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLabel getUserDefinedType() {
		return (IfcLabel) eGet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UserDefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedType(IfcLabel newUserDefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UserDefinedType(), newUserDefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedType() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UserDefinedType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedType() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UserDefinedType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionalExponents getDimensions() {
		return (IfcDimensionalExponents) eGet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_Dimensions(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimensions(IfcDimensionalExponents newDimensions) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_Dimensions(), newDimensions);
	}

} //IfcDerivedUnitImpl
