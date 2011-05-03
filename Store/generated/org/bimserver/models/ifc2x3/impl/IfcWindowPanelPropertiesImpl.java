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
import org.bimserver.models.ifc2x3.IfcShapeAspect;
import org.bimserver.models.ifc2x3.IfcWindowPanelOperationEnum;
import org.bimserver.models.ifc2x3.IfcWindowPanelPositionEnum;
import org.bimserver.models.ifc2x3.IfcWindowPanelProperties;

import org.bimserver.models.ifc2x3.impl.IfcPropertySetDefinitionImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Window Panel Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowPanelPropertiesImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowPanelPropertiesImpl#getPanelPosition <em>Panel Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowPanelPropertiesImpl#getFrameDepth <em>Frame Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowPanelPropertiesImpl#getFrameDepthAsString <em>Frame Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowPanelPropertiesImpl#getFrameThickness <em>Frame Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowPanelPropertiesImpl#getFrameThicknessAsString <em>Frame Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowPanelPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcWindowPanelPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcWindowPanelProperties
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
	protected IfcWindowPanelPropertiesImpl()
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
		return Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowPanelOperationEnum getOperationType()
	{
		return (IfcWindowPanelOperationEnum)eGet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__OPERATION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationType(IfcWindowPanelOperationEnum newOperationType)
	{
		eSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__OPERATION_TYPE, newOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowPanelPositionEnum getPanelPosition()
	{
		return (IfcWindowPanelPositionEnum)eGet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__PANEL_POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPanelPosition(IfcWindowPanelPositionEnum newPanelPosition)
	{
		eSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__PANEL_POSITION, newPanelPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFrameDepth()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameDepth(float newFrameDepth)
	{
		eSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_DEPTH, newFrameDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrameDepth()
	{
		eUnset(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrameDepth()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrameDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameDepthAsString(String newFrameDepthAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_DEPTH_AS_STRING, newFrameDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrameDepthAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrameDepthAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFrameThickness()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameThickness(float newFrameThickness)
	{
		eSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_THICKNESS, newFrameThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrameThickness()
	{
		eUnset(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrameThickness()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrameThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameThicknessAsString(String newFrameThicknessAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_THICKNESS_AS_STRING, newFrameThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrameThicknessAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrameThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__FRAME_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getShapeAspectStyle()
	{
		return (IfcShapeAspect)eGet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__SHAPE_ASPECT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle)
	{
		eSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__SHAPE_ASPECT_STYLE, newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShapeAspectStyle()
	{
		eUnset(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShapeAspectStyle()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_WINDOW_PANEL_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

} //IfcWindowPanelPropertiesImpl
