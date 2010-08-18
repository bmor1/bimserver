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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc References Value Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getReferencedDocument <em>Referenced Document</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getReferencingValues <em>Referencing Values</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcReferencesValueDocument()
 * @model
 * @generated
 */
public interface IfcReferencesValueDocument extends EObject {
	/**
	 * Returns the value of the '<em><b>Referenced Document</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Document</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Document</em>' reference.
	 * @see #setReferencedDocument(IfcDocumentSelect)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcReferencesValueDocument_ReferencedDocument()
	 * @model
	 * @generated
	 */
	IfcDocumentSelect getReferencedDocument();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getReferencedDocument <em>Referenced Document</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Document</em>' reference.
	 * @see #getReferencedDocument()
	 * @generated
	 */
	void setReferencedDocument(IfcDocumentSelect value);

	/**
	 * Returns the value of the '<em><b>Referencing Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.ifc.emf.Ifc2x3.IfcAppliedValue}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.ifc.emf.Ifc2x3.IfcAppliedValue#getValuesReferenced <em>Values Referenced</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Values</em>' reference list.
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcReferencesValueDocument_ReferencingValues()
	 * @see org.bimserver.ifc.emf.Ifc2x3.IfcAppliedValue#getValuesReferenced
	 * @model opposite="ValuesReferenced"
	 * @generated
	 */
	EList<IfcAppliedValue> getReferencingValues();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' reference.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(IfcLabel)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcReferencesValueDocument_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLabel getName();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getName <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' reference.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(IfcLabel value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getName <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(IfcLabel)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getName <em>Name</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' reference is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(IfcLabel)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' reference.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(IfcText)
	 * @see org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package#getIfcReferencesValueDocument_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcText getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getDescription <em>Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' reference.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(IfcText value);

	/**
	 * Unsets the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getDescription <em>Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(IfcText)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.ifc.emf.Ifc2x3.IfcReferencesValueDocument#getDescription <em>Description</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' reference is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(IfcText)
	 * @generated
	 */
	boolean isSetDescription();

} // IfcReferencesValueDocument
