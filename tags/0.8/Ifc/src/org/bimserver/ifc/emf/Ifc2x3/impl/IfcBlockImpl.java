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
import org.bimserver.ifc.emf.Ifc2x3.IfcBlock;
import org.bimserver.ifc.emf.Ifc2x3.IfcPositiveLengthMeasure;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcBlockImpl#getXLength <em>XLength</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcBlockImpl#getYLength <em>YLength</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcBlockImpl#getZLength <em>ZLength</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBlockImpl extends IfcCsgPrimitive3DImpl implements IfcBlock {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcBlock();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPositiveLengthMeasure getXLength() {
		return (IfcPositiveLengthMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcBlock_XLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXLength(IfcPositiveLengthMeasure newXLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlock_XLength(), newXLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPositiveLengthMeasure getYLength() {
		return (IfcPositiveLengthMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcBlock_YLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYLength(IfcPositiveLengthMeasure newYLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlock_YLength(), newYLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPositiveLengthMeasure getZLength() {
		return (IfcPositiveLengthMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcBlock_ZLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZLength(IfcPositiveLengthMeasure newZLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlock_ZLength(), newZLength);
	}

} //IfcBlockImpl