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
import org.bimserver.ifc.emf.Ifc2x3.IfcDerivedMeasureValue;
import org.bimserver.ifc.emf.Ifc2x3.IfcFrequencyMeasure;
import org.bimserver.ifc.emf.Ifc2x3.IfcSoundValue;
import org.bimserver.ifc.emf.Ifc2x3.IfcTimeSeries;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Sound Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcSoundValueImpl#getSoundLevelTimeSeries <em>Sound Level Time Series</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcSoundValueImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcSoundValueImpl#getSoundLevelSingleValue <em>Sound Level Single Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSoundValueImpl extends IfcPropertySetDefinitionImpl implements IfcSoundValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSoundValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSoundValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getSoundLevelTimeSeries() {
		return (IfcTimeSeries) eGet(Ifc2x3Package.eINSTANCE.getIfcSoundValue_SoundLevelTimeSeries(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoundLevelTimeSeries(IfcTimeSeries newSoundLevelTimeSeries) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSoundValue_SoundLevelTimeSeries(), newSoundLevelTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSoundLevelTimeSeries() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSoundValue_SoundLevelTimeSeries());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSoundLevelTimeSeries() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSoundValue_SoundLevelTimeSeries());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFrequencyMeasure getFrequency() {
		return (IfcFrequencyMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcSoundValue_Frequency(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrequency(IfcFrequencyMeasure newFrequency) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSoundValue_Frequency(), newFrequency);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedMeasureValue getSoundLevelSingleValue() {
		return (IfcDerivedMeasureValue) eGet(Ifc2x3Package.eINSTANCE.getIfcSoundValue_SoundLevelSingleValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoundLevelSingleValue(IfcDerivedMeasureValue newSoundLevelSingleValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSoundValue_SoundLevelSingleValue(), newSoundLevelSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSoundLevelSingleValue() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSoundValue_SoundLevelSingleValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSoundLevelSingleValue() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSoundValue_SoundLevelSingleValue());
	}

} //IfcSoundValueImpl
