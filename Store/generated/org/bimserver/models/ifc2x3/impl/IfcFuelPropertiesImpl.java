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
import org.bimserver.models.ifc2x3.IfcFuelProperties;

import org.bimserver.models.ifc2x3.impl.IfcMaterialPropertiesImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fuel Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFuelPropertiesImpl#getCombustionTemperature <em>Combustion Temperature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFuelPropertiesImpl#getCombustionTemperatureAsString <em>Combustion Temperature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFuelPropertiesImpl#getCarbonContent <em>Carbon Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFuelPropertiesImpl#getCarbonContentAsString <em>Carbon Content As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFuelPropertiesImpl#getLowerHeatingValue <em>Lower Heating Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFuelPropertiesImpl#getLowerHeatingValueAsString <em>Lower Heating Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFuelPropertiesImpl#getHigherHeatingValue <em>Higher Heating Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFuelPropertiesImpl#getHigherHeatingValueAsString <em>Higher Heating Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFuelPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcFuelProperties
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
	protected IfcFuelPropertiesImpl()
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
		return Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCombustionTemperature()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCombustionTemperature(float newCombustionTemperature)
	{
		eSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE, newCombustionTemperature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCombustionTemperature()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCombustionTemperature()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCombustionTemperatureAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCombustionTemperatureAsString(String newCombustionTemperatureAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE_AS_STRING, newCombustionTemperatureAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCombustionTemperatureAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCombustionTemperatureAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCarbonContent()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCarbonContent(float newCarbonContent)
	{
		eSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT, newCarbonContent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCarbonContent()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCarbonContent()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCarbonContentAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCarbonContentAsString(String newCarbonContentAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT_AS_STRING, newCarbonContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCarbonContentAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCarbonContentAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLowerHeatingValue()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerHeatingValue(float newLowerHeatingValue)
	{
		eSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE, newLowerHeatingValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerHeatingValue()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerHeatingValue()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLowerHeatingValueAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerHeatingValueAsString(String newLowerHeatingValueAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE_AS_STRING, newLowerHeatingValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerHeatingValueAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerHeatingValueAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHigherHeatingValue()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHigherHeatingValue(float newHigherHeatingValue)
	{
		eSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE, newHigherHeatingValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHigherHeatingValue()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHigherHeatingValue()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHigherHeatingValueAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHigherHeatingValueAsString(String newHigherHeatingValueAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE_AS_STRING, newHigherHeatingValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHigherHeatingValueAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHigherHeatingValueAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE_AS_STRING);
	}

} //IfcFuelPropertiesImpl
