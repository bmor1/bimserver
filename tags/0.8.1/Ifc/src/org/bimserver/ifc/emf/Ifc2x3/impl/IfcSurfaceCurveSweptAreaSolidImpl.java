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
import org.bimserver.ifc.emf.Ifc2x3.IfcCurve;
import org.bimserver.ifc.emf.Ifc2x3.IfcParameterValue;
import org.bimserver.ifc.emf.Ifc2x3.IfcSurface;
import org.bimserver.ifc.emf.Ifc2x3.IfcSurfaceCurveSweptAreaSolid;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Curve Swept Area Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getDirectrix <em>Directrix</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getStartParam <em>Start Param</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getEndParam <em>End Param</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getReferenceSurface <em>Reference Surface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSurfaceCurveSweptAreaSolidImpl extends IfcSweptAreaSolidImpl implements IfcSurfaceCurveSweptAreaSolid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceCurveSweptAreaSolidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSurfaceCurveSweptAreaSolid();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getDirectrix() {
		return (IfcCurve) eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceCurveSweptAreaSolid_Directrix(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectrix(IfcCurve newDirectrix) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceCurveSweptAreaSolid_Directrix(), newDirectrix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcParameterValue getStartParam() {
		return (IfcParameterValue) eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceCurveSweptAreaSolid_StartParam(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartParam(IfcParameterValue newStartParam) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceCurveSweptAreaSolid_StartParam(), newStartParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcParameterValue getEndParam() {
		return (IfcParameterValue) eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceCurveSweptAreaSolid_EndParam(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndParam(IfcParameterValue newEndParam) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceCurveSweptAreaSolid_EndParam(), newEndParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface getReferenceSurface() {
		return (IfcSurface) eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceCurveSweptAreaSolid_ReferenceSurface(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceSurface(IfcSurface newReferenceSurface) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceCurveSweptAreaSolid_ReferenceSurface(), newReferenceSurface);
	}

} //IfcSurfaceCurveSweptAreaSolidImpl