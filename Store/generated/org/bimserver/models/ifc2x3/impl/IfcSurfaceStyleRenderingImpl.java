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

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcColourOrFactor;
import org.bimserver.models.ifc2x3.IfcReflectanceMethodEnum;
import org.bimserver.models.ifc2x3.IfcSpecularHighlightSelect;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleRendering;

import org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleShadingImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Style Rendering</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl#getTransparency <em>Transparency</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl#getTransparencyAsString <em>Transparency As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl#getDiffuseColour <em>Diffuse Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl#getTransmissionColour <em>Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl#getReflectionColour <em>Reflection Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl#getSpecularColour <em>Specular Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl#getSpecularHighlight <em>Specular Highlight</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl#getReflectanceMethod <em>Reflectance Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSurfaceStyleRenderingImpl extends IfcSurfaceStyleShadingImpl implements IfcSurfaceStyleRendering
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceStyleRenderingImpl()
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
		return Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransparency()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransparency(float newTransparency)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY, newTransparency);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransparency()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransparency()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransparencyAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransparencyAsString(String newTransparencyAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY_AS_STRING, newTransparencyAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransparencyAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransparencyAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getDiffuseColour()
	{
		return (IfcColourOrFactor)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiffuseColour(IfcColourOrFactor newDiffuseColour)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR, newDiffuseColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDiffuseColour()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiffuseColour()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getTransmissionColour()
	{
		return (IfcColourOrFactor)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransmissionColour(IfcColourOrFactor newTransmissionColour)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR, newTransmissionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransmissionColour()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransmissionColour()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getDiffuseTransmissionColour()
	{
		return (IfcColourOrFactor)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiffuseTransmissionColour(IfcColourOrFactor newDiffuseTransmissionColour)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR, newDiffuseTransmissionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDiffuseTransmissionColour()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiffuseTransmissionColour()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getReflectionColour()
	{
		return (IfcColourOrFactor)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflectionColour(IfcColourOrFactor newReflectionColour)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR, newReflectionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReflectionColour()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReflectionColour()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getSpecularColour()
	{
		return (IfcColourOrFactor)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecularColour(IfcColourOrFactor newSpecularColour)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR, newSpecularColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecularColour()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecularColour()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpecularHighlightSelect getSpecularHighlight()
	{
		return (IfcSpecularHighlightSelect)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecularHighlight(IfcSpecularHighlightSelect newSpecularHighlight)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT, newSpecularHighlight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecularHighlight()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecularHighlight()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReflectanceMethodEnum getReflectanceMethod()
	{
		return (IfcReflectanceMethodEnum)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTANCE_METHOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflectanceMethod(IfcReflectanceMethodEnum newReflectanceMethod)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTANCE_METHOD, newReflectanceMethod);
	}

} //IfcSurfaceStyleRenderingImpl
