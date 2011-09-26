/**
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcHalfSpaceSolid;
import org.bimserver.models.ifc2x3.IfcSurface;
import org.bimserver.models.ifc2x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Half Space Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHalfSpaceSolidImpl#getBaseSurface <em>Base Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHalfSpaceSolidImpl#getAgreementFlag <em>Agreement Flag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHalfSpaceSolidImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcHalfSpaceSolidImpl extends IfcGeometricRepresentationItemImpl implements IfcHalfSpaceSolid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcHalfSpaceSolidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcHalfSpaceSolid();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface getBaseSurface() {
		return (IfcSurface) eGet(Ifc2x3Package.eINSTANCE.getIfcHalfSpaceSolid_BaseSurface(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseSurface(IfcSurface newBaseSurface) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHalfSpaceSolid_BaseSurface(), newBaseSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getAgreementFlag() {
		return (Tristate) eGet(Ifc2x3Package.eINSTANCE.getIfcHalfSpaceSolid_AgreementFlag(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgreementFlag(Tristate newAgreementFlag) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHalfSpaceSolid_AgreementFlag(), newAgreementFlag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim() {
		return (Integer) eGet(Ifc2x3Package.eINSTANCE.getIfcHalfSpaceSolid_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHalfSpaceSolid_Dim(), newDim);
	}

} //IfcHalfSpaceSolidImpl