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
import org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Force Warping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleForceWarpingImpl#getWarpingMoment <em>Warping Moment</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleForceWarpingImpl#getWarpingMomentAsString <em>Warping Moment As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLoadSingleForceWarpingImpl extends IfcStructuralLoadSingleForceImpl implements IfcStructuralLoadSingleForceWarping {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleForceWarpingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWarpingMoment() {
		return (Float) eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingMoment(float newWarpingMoment) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment(), newWarpingMoment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingMoment() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingMoment() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWarpingMomentAsString() {
		return (String) eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingMomentAsString(String newWarpingMomentAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString(), newWarpingMomentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingMomentAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingMomentAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString());
	}

} //IfcStructuralLoadSingleForceWarpingImpl
