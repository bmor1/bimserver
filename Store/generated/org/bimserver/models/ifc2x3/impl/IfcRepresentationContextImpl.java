/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentationContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Representation Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationContextImpl#getContextIdentifier <em>Context Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationContextImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationContextImpl#getRepresentationsInContext <em>Representations In Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRepresentationContextImpl extends IdEObjectImpl implements IfcRepresentationContext
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRepresentationContextImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcRepresentationContext();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContextIdentifier()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentationContext_ContextIdentifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextIdentifier(String newContextIdentifier)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRepresentationContext_ContextIdentifier(), newContextIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetContextIdentifier()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRepresentationContext_ContextIdentifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetContextIdentifier()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRepresentationContext_ContextIdentifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContextType()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentationContext_ContextType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextType(String newContextType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRepresentationContext_ContextType(), newContextType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetContextType()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRepresentationContext_ContextType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetContextType()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRepresentationContext_ContextType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRepresentation> getRepresentationsInContext()
	{
		return (EList<IfcRepresentation>)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentationContext_RepresentationsInContext(), true);
	}

} //IfcRepresentationContextImpl