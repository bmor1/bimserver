/**
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 * 
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 * 
 *
 * $Id$
 */
package org.bimserver.ifc.emf.Ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Telecom Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getTelephoneNumbers <em>Telephone Numbers</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getFacsimileNumbers <em>Facsimile Numbers</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getPagerNumber <em>Pager Number</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getElectronicMailAddresses <em>Electronic Mail Addresses</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getWWWHomePageURL <em>WWW Home Page URL</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcTelecomAddress()
 * @model
 * @generated
 */
public interface IfcTelecomAddress extends IfcAddress {
	/**
	 * Returns the value of the '<em><b>Telephone Numbers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.ifc.emf.Ifc2x3.IfcLabel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Telephone Numbers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telephone Numbers</em>' reference list.
	 * @see #isSetTelephoneNumbers()
	 * @see #unsetTelephoneNumbers()
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcTelecomAddress_TelephoneNumbers()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcLabel> getTelephoneNumbers();

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getTelephoneNumbers <em>Telephone Numbers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTelephoneNumbers()
	 * @see #getTelephoneNumbers()
	 * @generated
	 */
	void unsetTelephoneNumbers();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getTelephoneNumbers <em>Telephone Numbers</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Telephone Numbers</em>' reference list is set.
	 * @see #unsetTelephoneNumbers()
	 * @see #getTelephoneNumbers()
	 * @generated
	 */
	boolean isSetTelephoneNumbers();

	/**
	 * Returns the value of the '<em><b>Facsimile Numbers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.ifc.emf.Ifc2x3.IfcLabel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facsimile Numbers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facsimile Numbers</em>' reference list.
	 * @see #isSetFacsimileNumbers()
	 * @see #unsetFacsimileNumbers()
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcTelecomAddress_FacsimileNumbers()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcLabel> getFacsimileNumbers();

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getFacsimileNumbers <em>Facsimile Numbers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFacsimileNumbers()
	 * @see #getFacsimileNumbers()
	 * @generated
	 */
	void unsetFacsimileNumbers();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getFacsimileNumbers <em>Facsimile Numbers</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Facsimile Numbers</em>' reference list is set.
	 * @see #unsetFacsimileNumbers()
	 * @see #getFacsimileNumbers()
	 * @generated
	 */
	boolean isSetFacsimileNumbers();

	/**
	 * Returns the value of the '<em><b>Pager Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pager Number</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pager Number</em>' reference.
	 * @see #isSetPagerNumber()
	 * @see #unsetPagerNumber()
	 * @see #setPagerNumber(IfcLabel)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcTelecomAddress_PagerNumber()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLabel getPagerNumber();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getPagerNumber <em>Pager Number</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pager Number</em>' reference.
	 * @see #isSetPagerNumber()
	 * @see #unsetPagerNumber()
	 * @see #getPagerNumber()
	 * @generated
	 */
	void setPagerNumber(IfcLabel value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getPagerNumber <em>Pager Number</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPagerNumber()
	 * @see #getPagerNumber()
	 * @see #setPagerNumber(IfcLabel)
	 * @generated
	 */
	void unsetPagerNumber();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getPagerNumber <em>Pager Number</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pager Number</em>' reference is set.
	 * @see #unsetPagerNumber()
	 * @see #getPagerNumber()
	 * @see #setPagerNumber(IfcLabel)
	 * @generated
	 */
	boolean isSetPagerNumber();

	/**
	 * Returns the value of the '<em><b>Electronic Mail Addresses</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.ifc.emf.Ifc2x3.IfcLabel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Electronic Mail Addresses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Electronic Mail Addresses</em>' reference list.
	 * @see #isSetElectronicMailAddresses()
	 * @see #unsetElectronicMailAddresses()
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcTelecomAddress_ElectronicMailAddresses()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcLabel> getElectronicMailAddresses();

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getElectronicMailAddresses <em>Electronic Mail Addresses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElectronicMailAddresses()
	 * @see #getElectronicMailAddresses()
	 * @generated
	 */
	void unsetElectronicMailAddresses();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getElectronicMailAddresses <em>Electronic Mail Addresses</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Electronic Mail Addresses</em>' reference list is set.
	 * @see #unsetElectronicMailAddresses()
	 * @see #getElectronicMailAddresses()
	 * @generated
	 */
	boolean isSetElectronicMailAddresses();

	/**
	 * Returns the value of the '<em><b>WWW Home Page URL</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>WWW Home Page URL</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>WWW Home Page URL</em>' reference.
	 * @see #isSetWWWHomePageURL()
	 * @see #unsetWWWHomePageURL()
	 * @see #setWWWHomePageURL(IfcLabel)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcTelecomAddress_WWWHomePageURL()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLabel getWWWHomePageURL();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getWWWHomePageURL <em>WWW Home Page URL</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>WWW Home Page URL</em>' reference.
	 * @see #isSetWWWHomePageURL()
	 * @see #unsetWWWHomePageURL()
	 * @see #getWWWHomePageURL()
	 * @generated
	 */
	void setWWWHomePageURL(IfcLabel value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getWWWHomePageURL <em>WWW Home Page URL</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWWWHomePageURL()
	 * @see #getWWWHomePageURL()
	 * @see #setWWWHomePageURL(IfcLabel)
	 * @generated
	 */
	void unsetWWWHomePageURL();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcTelecomAddress#getWWWHomePageURL <em>WWW Home Page URL</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>WWW Home Page URL</em>' reference is set.
	 * @see #unsetWWWHomePageURL()
	 * @see #getWWWHomePageURL()
	 * @see #setWWWHomePageURL(IfcLabel)
	 * @generated
	 */
	boolean isSetWWWHomePageURL();

} // IfcTelecomAddress
