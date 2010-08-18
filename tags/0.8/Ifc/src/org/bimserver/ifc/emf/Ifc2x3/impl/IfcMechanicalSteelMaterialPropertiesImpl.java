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
import org.bimserver.ifc.emf.Ifc2x3.IfcMechanicalSteelMaterialProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcModulusOfElasticityMeasure;
import org.bimserver.ifc.emf.Ifc2x3.IfcPositiveRatioMeasure;
import org.bimserver.ifc.emf.Ifc2x3.IfcPressureMeasure;
import org.bimserver.ifc.emf.Ifc2x3.IfcRelaxation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mechanical Steel Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getYieldStress <em>Yield Stress</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStress <em>Ultimate Stress</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStrain <em>Ultimate Strain</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getHardeningModule <em>Hardening Module</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getProportionalStress <em>Proportional Stress</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getPlasticStrain <em>Plastic Strain</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getRelaxations <em>Relaxations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMechanicalSteelMaterialPropertiesImpl extends IfcMechanicalMaterialPropertiesImpl implements IfcMechanicalSteelMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMechanicalSteelMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPressureMeasure getYieldStress() {
		return (IfcPressureMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYieldStress(IfcPressureMeasure newYieldStress) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStress(), newYieldStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYieldStress() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYieldStress() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPressureMeasure getUltimateStress() {
		return (IfcPressureMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStress(IfcPressureMeasure newUltimateStress) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStress(), newUltimateStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStress() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStress() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPositiveRatioMeasure getUltimateStrain() {
		return (IfcPositiveRatioMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrain(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStrain(IfcPositiveRatioMeasure newUltimateStrain) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrain(), newUltimateStrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStrain() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStrain() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcModulusOfElasticityMeasure getHardeningModule() {
		return (IfcModulusOfElasticityMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModule(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardeningModule(IfcModulusOfElasticityMeasure newHardeningModule) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModule(), newHardeningModule);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHardeningModule() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModule());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHardeningModule() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModule());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPressureMeasure getProportionalStress() {
		return (IfcPressureMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProportionalStress(IfcPressureMeasure newProportionalStress) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStress(), newProportionalStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProportionalStress() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProportionalStress() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPositiveRatioMeasure getPlasticStrain() {
		return (IfcPositiveRatioMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrain(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticStrain(IfcPositiveRatioMeasure newPlasticStrain) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrain(), newPlasticStrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticStrain() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticStrain() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelaxation> getRelaxations() {
		return (EList<IfcRelaxation>) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_Relaxations(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelaxations() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_Relaxations());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelaxations() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_Relaxations());
	}

} //IfcMechanicalSteelMaterialPropertiesImpl
