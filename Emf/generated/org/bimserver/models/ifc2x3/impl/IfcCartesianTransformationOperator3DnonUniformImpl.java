/**
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3DnonUniform;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cartesian Transformation Operator3 Dnon Uniform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator3DnonUniformImpl#getScale2 <em>Scale2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator3DnonUniformImpl#getScale2AsString <em>Scale2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator3DnonUniformImpl#getScale3 <em>Scale3</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator3DnonUniformImpl#getScale3AsString <em>Scale3 As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCartesianTransformationOperator3DnonUniformImpl extends IfcCartesianTransformationOperator3DImpl implements IfcCartesianTransformationOperator3DnonUniform {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCartesianTransformationOperator3DnonUniformImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3DnonUniform();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getScale2() {
		return (Float) eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3DnonUniform_Scale2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale2(float newScale2) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3DnonUniform_Scale2(), newScale2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScale2AsString() {
		return (String) eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3DnonUniform_Scale2AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale2AsString(String newScale2AsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3DnonUniform_Scale2AsString(), newScale2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getScale3() {
		return (Float) eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3DnonUniform_Scale3(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale3(float newScale3) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3DnonUniform_Scale3(), newScale3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScale3AsString() {
		return (String) eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3DnonUniform_Scale3AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale3AsString(String newScale3AsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3DnonUniform_Scale3AsString(), newScale3AsString);
	}

} //IfcCartesianTransformationOperator3DnonUniformImpl
