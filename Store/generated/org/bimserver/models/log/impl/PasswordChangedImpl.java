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
package org.bimserver.models.log.impl;

import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.PasswordChanged;
import org.bimserver.models.store.User;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Password Changed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.log.impl.PasswordChangedImpl#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PasswordChangedImpl extends LogActionImpl implements PasswordChanged
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PasswordChangedImpl()
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
		return LogPackage.Literals.PASSWORD_CHANGED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getUser()
	{
		return (User)eGet(LogPackage.Literals.PASSWORD_CHANGED__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser)
	{
		eSet(LogPackage.Literals.PASSWORD_CHANGED__USER, newUser);
	}

} //PasswordChangedImpl
