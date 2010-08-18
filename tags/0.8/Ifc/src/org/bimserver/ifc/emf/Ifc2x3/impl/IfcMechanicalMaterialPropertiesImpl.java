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
import org.bimserver.ifc.emf.Ifc2x3.IfcDynamicViscosityMeasure;
import org.bimserver.ifc.emf.Ifc2x3.IfcMechanicalMaterialProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcModulusOfElasticityMeasure;
import org.bimserver.ifc.emf.Ifc2x3.IfcPositiveRatioMeasure;
import org.bimserver.ifc.emf.Ifc2x3.IfcThermalExpansionCoefficientMeasure;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mechanical Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getDynamicViscosity <em>Dynamic Viscosity</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getYoungModulus <em>Young Modulus</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getShearModulus <em>Shear Modulus</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getPoissonRatio <em>Poisson Ratio</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getThermalExpansionCoefficient <em>Thermal Expansion Coefficient</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMechanicalMaterialPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcMechanicalMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMechanicalMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDynamicViscosityMeasure getDynamicViscosity() {
		return (IfcDynamicViscosityMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicViscosity(IfcDynamicViscosityMeasure newDynamicViscosity) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosity(), newDynamicViscosity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDynamicViscosity() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDynamicViscosity() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcModulusOfElasticityMeasure getYoungModulus() {
		return (IfcModulusOfElasticityMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulus(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYoungModulus(IfcModulusOfElasticityMeasure newYoungModulus) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulus(), newYoungModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYoungModulus() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYoungModulus() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcModulusOfElasticityMeasure getShearModulus() {
		return (IfcModulusOfElasticityMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulus(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearModulus(IfcModulusOfElasticityMeasure newShearModulus) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulus(), newShearModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearModulus() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearModulus() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPositiveRatioMeasure getPoissonRatio() {
		return (IfcPositiveRatioMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatio(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoissonRatio(IfcPositiveRatioMeasure newPoissonRatio) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatio(), newPoissonRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPoissonRatio() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPoissonRatio() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalExpansionCoefficientMeasure getThermalExpansionCoefficient() {
		return (IfcThermalExpansionCoefficientMeasure) eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalExpansionCoefficient(IfcThermalExpansionCoefficientMeasure newThermalExpansionCoefficient) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient(), newThermalExpansionCoefficient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalExpansionCoefficient() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalExpansionCoefficient() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient());
	}

} //IfcMechanicalMaterialPropertiesImpl
