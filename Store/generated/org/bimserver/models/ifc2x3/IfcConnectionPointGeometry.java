/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Connection Point Geometry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionPointGeometry#getPointOnRelatingElement <em>Point On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectionPointGeometry#getPointOnRelatedElement <em>Point On Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointGeometry()
 * @model
 * @generated
 */
public interface IfcConnectionPointGeometry extends IfcConnectionGeometry {
	/**
	 * Returns the value of the '<em><b>Point On Relating Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point On Relating Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point On Relating Element</em>' reference.
	 * @see #setPointOnRelatingElement(IfcPointOrVertexPoint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointGeometry_PointOnRelatingElement()
	 * @model
	 * @generated
	 */
	IfcPointOrVertexPoint getPointOnRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointGeometry#getPointOnRelatingElement <em>Point On Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point On Relating Element</em>' reference.
	 * @see #getPointOnRelatingElement()
	 * @generated
	 */
	void setPointOnRelatingElement(IfcPointOrVertexPoint value);

	/**
	 * Returns the value of the '<em><b>Point On Related Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point On Related Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point On Related Element</em>' reference.
	 * @see #isSetPointOnRelatedElement()
	 * @see #unsetPointOnRelatedElement()
	 * @see #setPointOnRelatedElement(IfcPointOrVertexPoint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectionPointGeometry_PointOnRelatedElement()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPointOrVertexPoint getPointOnRelatedElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointGeometry#getPointOnRelatedElement <em>Point On Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point On Related Element</em>' reference.
	 * @see #isSetPointOnRelatedElement()
	 * @see #unsetPointOnRelatedElement()
	 * @see #getPointOnRelatedElement()
	 * @generated
	 */
	void setPointOnRelatedElement(IfcPointOrVertexPoint value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointGeometry#getPointOnRelatedElement <em>Point On Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPointOnRelatedElement()
	 * @see #getPointOnRelatedElement()
	 * @see #setPointOnRelatedElement(IfcPointOrVertexPoint)
	 * @generated
	 */
	void unsetPointOnRelatedElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcConnectionPointGeometry#getPointOnRelatedElement <em>Point On Related Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Point On Related Element</em>' reference is set.
	 * @see #unsetPointOnRelatedElement()
	 * @see #getPointOnRelatedElement()
	 * @see #setPointOnRelatedElement(IfcPointOrVertexPoint)
	 * @generated
	 */
	boolean isSetPointOnRelatedElement();

} // IfcConnectionPointGeometry
