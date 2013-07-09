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
import org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement;
import org.bimserver.ifc.emf.Ifc2x3.IfcConnectionPortGeometry;
import org.bimserver.ifc.emf.Ifc2x3.IfcProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Port Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcConnectionPortGeometryImpl#getLocationAtRelatingElement <em>Location At Relating Element</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcConnectionPortGeometryImpl#getLocationAtRelatedElement <em>Location At Related Element</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcConnectionPortGeometryImpl#getProfileOfPort <em>Profile Of Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConnectionPortGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionPortGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionPortGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getLocationAtRelatingElement() {
		return (IfcAxis2Placement) eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationAtRelatingElement(IfcAxis2Placement newLocationAtRelatingElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatingElement(), newLocationAtRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getLocationAtRelatedElement() {
		return (IfcAxis2Placement) eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatedElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationAtRelatedElement(IfcAxis2Placement newLocationAtRelatedElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatedElement(), newLocationAtRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLocationAtRelatedElement() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLocationAtRelatedElement() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getProfileOfPort() {
		return (IfcProfileDef) eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_ProfileOfPort(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileOfPort(IfcProfileDef newProfileOfPort) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_ProfileOfPort(), newProfileOfPort);
	}

} //IfcConnectionPortGeometryImpl
