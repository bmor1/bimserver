/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.impl;

import org.bimserver.database.store.GuidClash;
import org.bimserver.database.store.StorePackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guid Clash</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.impl.GuidClashImpl#getGuid1 <em>Guid1</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.GuidClashImpl#getGuid2 <em>Guid2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuidClashImpl extends ClashImpl implements GuidClash {
	/**
	 * The default value of the '{@link #getGuid1() <em>Guid1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuid1()
	 * @generated
	 * @ordered
	 */
	protected static final String GUID1_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getGuid2() <em>Guid2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuid2()
	 * @generated
	 * @ordered
	 */
	protected static final String GUID2_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuidClashImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.GUID_CLASH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuid1() {
		return (String)eVirtualGet(StorePackage.GUID_CLASH__GUID1, GUID1_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuid1(String newGuid1) {
		String guid1 = newGuid1;
		Object oldGuid1 = eVirtualSet(StorePackage.GUID_CLASH__GUID1, guid1);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.GUID_CLASH__GUID1, oldGuid1 == EVIRTUAL_NO_VALUE ? GUID1_EDEFAULT : oldGuid1, guid1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuid2() {
		return (String)eVirtualGet(StorePackage.GUID_CLASH__GUID2, GUID2_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuid2(String newGuid2) {
		String guid2 = newGuid2;
		Object oldGuid2 = eVirtualSet(StorePackage.GUID_CLASH__GUID2, guid2);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.GUID_CLASH__GUID2, oldGuid2 == EVIRTUAL_NO_VALUE ? GUID2_EDEFAULT : oldGuid2, guid2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StorePackage.GUID_CLASH__GUID1:
				return getGuid1();
			case StorePackage.GUID_CLASH__GUID2:
				return getGuid2();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StorePackage.GUID_CLASH__GUID1:
				setGuid1((String)newValue);
				return;
			case StorePackage.GUID_CLASH__GUID2:
				setGuid2((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StorePackage.GUID_CLASH__GUID1:
				setGuid1(GUID1_EDEFAULT);
				return;
			case StorePackage.GUID_CLASH__GUID2:
				setGuid2(GUID2_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StorePackage.GUID_CLASH__GUID1:
				String guid1 = (String)eVirtualGet(StorePackage.GUID_CLASH__GUID1, GUID1_EDEFAULT);
				return GUID1_EDEFAULT == null ? guid1 != null : !GUID1_EDEFAULT.equals(guid1);
			case StorePackage.GUID_CLASH__GUID2:
				String guid2 = (String)eVirtualGet(StorePackage.GUID_CLASH__GUID2, GUID2_EDEFAULT);
				return GUID2_EDEFAULT == null ? guid2 != null : !GUID2_EDEFAULT.equals(guid2);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (guid1: ");
		result.append(eVirtualGet(StorePackage.GUID_CLASH__GUID1, GUID1_EDEFAULT));
		result.append(", guid2: ");
		result.append(eVirtualGet(StorePackage.GUID_CLASH__GUID2, GUID2_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //GuidClashImpl
