/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcLinearVelocityMeasure;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Linear Velocity Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLinearVelocityMeasureImpl#getWrappedValue <em>Wrapped Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLinearVelocityMeasureImpl#getWrappedValueAsString <em>Wrapped Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLinearVelocityMeasureImpl extends WrappedValueImpl implements IfcLinearVelocityMeasure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLinearVelocityMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcLinearVelocityMeasure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWrappedValue() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLinearVelocityMeasure_WrappedValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrappedValue(float newWrappedValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLinearVelocityMeasure_WrappedValue(), newWrappedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWrappedValueAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLinearVelocityMeasure_WrappedValueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrappedValueAsString(String newWrappedValueAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLinearVelocityMeasure_WrappedValueAsString(), newWrappedValueAsString);
	}

} //IfcLinearVelocityMeasureImpl
