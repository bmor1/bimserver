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
import org.bimserver.models.ifc2x3.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3.IfcRelAssignsTasks;
import org.bimserver.models.ifc2x3.IfcScheduleTimeControl;
import org.bimserver.models.ifc2x3.Tristate;

import org.bimserver.models.ifc2x3.impl.IfcControlImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Schedule Time Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getActualStart <em>Actual Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getEarlyStart <em>Early Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getLateStart <em>Late Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getScheduleStart <em>Schedule Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getActualFinish <em>Actual Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getEarlyFinish <em>Early Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getLateFinish <em>Late Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getScheduleFinish <em>Schedule Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getScheduleDuration <em>Schedule Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getScheduleDurationAsString <em>Schedule Duration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getActualDuration <em>Actual Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getActualDurationAsString <em>Actual Duration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getRemainingTime <em>Remaining Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getRemainingTimeAsString <em>Remaining Time As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getFreeFloat <em>Free Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getFreeFloatAsString <em>Free Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getTotalFloatAsString <em>Total Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getIsCritical <em>Is Critical</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getStatusTime <em>Status Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getStartFloat <em>Start Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getStartFloatAsString <em>Start Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getFinishFloat <em>Finish Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getFinishFloatAsString <em>Finish Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getCompletion <em>Completion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getCompletionAsString <em>Completion As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl#getScheduleTimeControlAssigned <em>Schedule Time Control Assigned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcScheduleTimeControlImpl extends IfcControlImpl implements IfcScheduleTimeControl
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
	protected IfcScheduleTimeControlImpl()
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
		return Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getActualStart()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualStart(IfcDateTimeSelect newActualStart)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_START, newActualStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActualStart()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActualStart()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getEarlyStart()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEarlyStart(IfcDateTimeSelect newEarlyStart)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_START, newEarlyStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEarlyStart()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEarlyStart()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getLateStart()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLateStart(IfcDateTimeSelect newLateStart)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_START, newLateStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLateStart()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLateStart()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getScheduleStart()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleStart(IfcDateTimeSelect newScheduleStart)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_START, newScheduleStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScheduleStart()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScheduleStart()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getActualFinish()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualFinish(IfcDateTimeSelect newActualFinish)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_FINISH, newActualFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActualFinish()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActualFinish()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getEarlyFinish()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEarlyFinish(IfcDateTimeSelect newEarlyFinish)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_FINISH, newEarlyFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEarlyFinish()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEarlyFinish()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getLateFinish()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLateFinish(IfcDateTimeSelect newLateFinish)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_FINISH, newLateFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLateFinish()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLateFinish()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getScheduleFinish()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleFinish(IfcDateTimeSelect newScheduleFinish)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_FINISH, newScheduleFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScheduleFinish()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScheduleFinish()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getScheduleDuration()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleDuration(float newScheduleDuration)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION, newScheduleDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScheduleDuration()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScheduleDuration()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScheduleDurationAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleDurationAsString(String newScheduleDurationAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION_AS_STRING, newScheduleDurationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScheduleDurationAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScheduleDurationAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getActualDuration()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualDuration(float newActualDuration)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION, newActualDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActualDuration()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActualDuration()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActualDurationAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualDurationAsString(String newActualDurationAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION_AS_STRING, newActualDurationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActualDurationAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActualDurationAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRemainingTime()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemainingTime(float newRemainingTime)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME, newRemainingTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRemainingTime()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRemainingTime()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemainingTimeAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemainingTimeAsString(String newRemainingTimeAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME_AS_STRING, newRemainingTimeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRemainingTimeAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRemainingTimeAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFreeFloat()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreeFloat(float newFreeFloat)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT, newFreeFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFreeFloat()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFreeFloat()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFreeFloatAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreeFloatAsString(String newFreeFloatAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT_AS_STRING, newFreeFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFreeFloatAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFreeFloatAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTotalFloat()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalFloat(float newTotalFloat)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT, newTotalFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalFloat()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalFloat()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTotalFloatAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalFloatAsString(String newTotalFloatAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT_AS_STRING, newTotalFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalFloatAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalFloatAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsCritical()
	{
		return (Tristate)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__IS_CRITICAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCritical(Tristate newIsCritical)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__IS_CRITICAL, newIsCritical);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getStatusTime()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__STATUS_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusTime(IfcDateTimeSelect newStatusTime)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__STATUS_TIME, newStatusTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStatusTime()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__STATUS_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStatusTime()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__STATUS_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getStartFloat()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartFloat(float newStartFloat)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT, newStartFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartFloat()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartFloat()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStartFloatAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartFloatAsString(String newStartFloatAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT_AS_STRING, newStartFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartFloatAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartFloatAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFinishFloat()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinishFloat(float newFinishFloat)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT, newFinishFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFinishFloat()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFinishFloat()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFinishFloatAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinishFloatAsString(String newFinishFloatAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT_AS_STRING, newFinishFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFinishFloatAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFinishFloatAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCompletion()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletion(float newCompletion)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION, newCompletion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompletion()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompletion()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompletionAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionAsString(String newCompletionAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION_AS_STRING, newCompletionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompletionAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompletionAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsTasks getScheduleTimeControlAssigned()
	{
		return (IfcRelAssignsTasks)eGet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_TIME_CONTROL_ASSIGNED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleTimeControlAssigned(IfcRelAssignsTasks newScheduleTimeControlAssigned)
	{
		eSet(Ifc2x3Package.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_TIME_CONTROL_ASSIGNED, newScheduleTimeControlAssigned);
	}

} //IfcScheduleTimeControlImpl
