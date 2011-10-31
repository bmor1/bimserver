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
import org.bimserver.ifc.emf.Ifc2x3.IfcOrientationSelect;
import org.bimserver.ifc.emf.Ifc2x3.IfcProfileProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcRelAssociatesProfileProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcShapeAspect;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Associates Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcRelAssociatesProfilePropertiesImpl#getRelatingProfileProperties <em>Relating Profile Properties</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcRelAssociatesProfilePropertiesImpl#getProfileSectionLocation <em>Profile Section Location</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcRelAssociatesProfilePropertiesImpl#getProfileOrientation <em>Profile Orientation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelAssociatesProfilePropertiesImpl extends IfcRelAssociatesImpl implements IfcRelAssociatesProfileProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssociatesProfilePropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileProperties getRelatingProfileProperties() {
		return (IfcProfileProperties) eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_RelatingProfileProperties(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingProfileProperties(IfcProfileProperties newRelatingProfileProperties) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_RelatingProfileProperties(), newRelatingProfileProperties);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getProfileSectionLocation() {
		return (IfcShapeAspect) eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_ProfileSectionLocation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileSectionLocation(IfcShapeAspect newProfileSectionLocation) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_ProfileSectionLocation(), newProfileSectionLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProfileSectionLocation() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_ProfileSectionLocation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProfileSectionLocation() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_ProfileSectionLocation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOrientationSelect getProfileOrientation() {
		return (IfcOrientationSelect) eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_ProfileOrientation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileOrientation(IfcOrientationSelect newProfileOrientation) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_ProfileOrientation(), newProfileOrientation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProfileOrientation() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_ProfileOrientation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProfileOrientation() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesProfileProperties_ProfileOrientation());
	}

} //IfcRelAssociatesProfilePropertiesImpl