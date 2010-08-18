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
import org.bimserver.ifc.emf.Ifc2x3.IfcCoordinatedUniversalTimeOffset;
import org.bimserver.ifc.emf.Ifc2x3.IfcDaylightSavingHour;
import org.bimserver.ifc.emf.Ifc2x3.IfcHourInDay;
import org.bimserver.ifc.emf.Ifc2x3.IfcLocalTime;
import org.bimserver.ifc.emf.Ifc2x3.IfcMinuteInHour;
import org.bimserver.ifc.emf.Ifc2x3.IfcSecondInMinute;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Local Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcLocalTimeImpl#getHourComponent <em>Hour Component</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcLocalTimeImpl#getMinuteComponent <em>Minute Component</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcLocalTimeImpl#getSecondComponent <em>Second Component</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcLocalTimeImpl#getZone <em>Zone</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcLocalTimeImpl#getDaylightSavingOffset <em>Daylight Saving Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLocalTimeImpl extends EObjectImpl implements IfcLocalTime {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLocalTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcLocalTime();
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
	public IfcHourInDay getHourComponent() {
		return (IfcHourInDay) eGet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_HourComponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHourComponent(IfcHourInDay newHourComponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_HourComponent(), newHourComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMinuteInHour getMinuteComponent() {
		return (IfcMinuteInHour) eGet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_MinuteComponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinuteComponent(IfcMinuteInHour newMinuteComponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_MinuteComponent(), newMinuteComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinuteComponent() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLocalTime_MinuteComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinuteComponent() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_MinuteComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSecondInMinute getSecondComponent() {
		return (IfcSecondInMinute) eGet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_SecondComponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondComponent(IfcSecondInMinute newSecondComponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_SecondComponent(), newSecondComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSecondComponent() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLocalTime_SecondComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSecondComponent() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_SecondComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCoordinatedUniversalTimeOffset getZone() {
		return (IfcCoordinatedUniversalTimeOffset) eGet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_Zone(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZone(IfcCoordinatedUniversalTimeOffset newZone) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_Zone(), newZone);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetZone() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLocalTime_Zone());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetZone() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_Zone());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDaylightSavingHour getDaylightSavingOffset() {
		return (IfcDaylightSavingHour) eGet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_DaylightSavingOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDaylightSavingOffset(IfcDaylightSavingHour newDaylightSavingOffset) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_DaylightSavingOffset(), newDaylightSavingOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDaylightSavingOffset() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLocalTime_DaylightSavingOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDaylightSavingOffset() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLocalTime_DaylightSavingOffset());
	}

} //IfcLocalTimeImpl
