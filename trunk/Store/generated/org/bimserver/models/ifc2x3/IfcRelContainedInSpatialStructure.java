/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Contained In Spatial Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure#getRelatedElements <em>Related Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure#getRelatingStructure <em>Relating Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelContainedInSpatialStructure()
 * @model
 * @generated
 */
public interface IfcRelContainedInSpatialStructure extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Related Elements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcProduct}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Elements</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelContainedInSpatialStructure_RelatedElements()
	 * @model
	 * @generated
	 */
	EList<IfcProduct> getRelatedElements();

	/**
	 * Returns the value of the '<em><b>Relating Structure</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getContainsElements <em>Contains Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Structure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Structure</em>' reference.
	 * @see #setRelatingStructure(IfcSpatialStructureElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelContainedInSpatialStructure_RelatingStructure()
	 * @see org.bimserver.models.ifc2x3.IfcSpatialStructureElement#getContainsElements
	 * @model opposite="ContainsElements"
	 * @generated
	 */
	IfcSpatialStructureElement getRelatingStructure();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure#getRelatingStructure <em>Relating Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Structure</em>' reference.
	 * @see #getRelatingStructure()
	 * @generated
	 */
	void setRelatingStructure(IfcSpatialStructureElement value);

} // IfcRelContainedInSpatialStructure
