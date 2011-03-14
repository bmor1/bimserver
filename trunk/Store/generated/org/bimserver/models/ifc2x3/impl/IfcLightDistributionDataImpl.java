/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcLightDistributionData;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Distribution Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getMainPlaneAngle <em>Main Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getSecondaryPlaneAngle <em>Secondary Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getSecondaryPlaneAngleAsString <em>Secondary Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getLuminousIntensity <em>Luminous Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getLuminousIntensityAsString <em>Luminous Intensity As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLightDistributionDataImpl extends IdEObjectImpl implements IfcLightDistributionData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightDistributionDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcLightDistributionData();
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
	public float getMainPlaneAngle() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLightDistributionData_MainPlaneAngle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainPlaneAngle(float newMainPlaneAngle) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightDistributionData_MainPlaneAngle(), newMainPlaneAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMainPlaneAngleAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightDistributionData_MainPlaneAngleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainPlaneAngleAsString(String newMainPlaneAngleAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightDistributionData_MainPlaneAngleAsString(), newMainPlaneAngleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Float> getSecondaryPlaneAngle() {
		return (EList<Float>)eGet(Ifc2x3Package.eINSTANCE.getIfcLightDistributionData_SecondaryPlaneAngle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getSecondaryPlaneAngleAsString() {
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcLightDistributionData_SecondaryPlaneAngleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Float> getLuminousIntensity() {
		return (EList<Float>)eGet(Ifc2x3Package.eINSTANCE.getIfcLightDistributionData_LuminousIntensity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getLuminousIntensityAsString() {
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcLightDistributionData_LuminousIntensityAsString(), true);
	}

} //IfcLightDistributionDataImpl
