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
 * A representation of the model object '<em><b>Ifc Structural Analysis Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getLoadedBy <em>Loaded By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getHasResults <em>Has Results</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralAnalysisModel()
 * @model
 * @generated
 */
public interface IfcStructuralAnalysisModel extends IfcSystem {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcAnalysisModelTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcAnalysisModelTypeEnum
	 * @see #setPredefinedType(IfcAnalysisModelTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralAnalysisModel_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcAnalysisModelTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcAnalysisModelTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcAnalysisModelTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Orientation Of2 DPlane</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientation Of2 DPlane</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation Of2 DPlane</em>' reference.
	 * @see #isSetOrientationOf2DPlane()
	 * @see #unsetOrientationOf2DPlane()
	 * @see #setOrientationOf2DPlane(IfcAxis2Placement3D)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralAnalysisModel_OrientationOf2DPlane()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement3D getOrientationOf2DPlane();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation Of2 DPlane</em>' reference.
	 * @see #isSetOrientationOf2DPlane()
	 * @see #unsetOrientationOf2DPlane()
	 * @see #getOrientationOf2DPlane()
	 * @generated
	 */
	void setOrientationOf2DPlane(IfcAxis2Placement3D value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOrientationOf2DPlane()
	 * @see #getOrientationOf2DPlane()
	 * @see #setOrientationOf2DPlane(IfcAxis2Placement3D)
	 * @generated
	 */
	void unsetOrientationOf2DPlane();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Orientation Of2 DPlane</em>' reference is set.
	 * @see #unsetOrientationOf2DPlane()
	 * @see #getOrientationOf2DPlane()
	 * @see #setOrientationOf2DPlane(IfcAxis2Placement3D)
	 * @generated
	 */
	boolean isSetOrientationOf2DPlane();

	/**
	 * Returns the value of the '<em><b>Loaded By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getLoadGroupFor <em>Load Group For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loaded By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loaded By</em>' reference list.
	 * @see #isSetLoadedBy()
	 * @see #unsetLoadedBy()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralAnalysisModel_LoadedBy()
	 * @see org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getLoadGroupFor
	 * @model opposite="LoadGroupFor" unsettable="true"
	 * @generated
	 */
	EList<IfcStructuralLoadGroup> getLoadedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getLoadedBy <em>Loaded By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLoadedBy()
	 * @see #getLoadedBy()
	 * @generated
	 */
	void unsetLoadedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getLoadedBy <em>Loaded By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Loaded By</em>' reference list is set.
	 * @see #unsetLoadedBy()
	 * @see #getLoadedBy()
	 * @generated
	 */
	boolean isSetLoadedBy();

	/**
	 * Returns the value of the '<em><b>Has Results</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcStructuralResultGroup}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcStructuralResultGroup#getResultGroupFor <em>Result Group For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Results</em>' reference list.
	 * @see #isSetHasResults()
	 * @see #unsetHasResults()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralAnalysisModel_HasResults()
	 * @see org.bimserver.models.ifc2x3.IfcStructuralResultGroup#getResultGroupFor
	 * @model opposite="ResultGroupFor" unsettable="true"
	 * @generated
	 */
	EList<IfcStructuralResultGroup> getHasResults();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getHasResults <em>Has Results</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasResults()
	 * @see #getHasResults()
	 * @generated
	 */
	void unsetHasResults();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getHasResults <em>Has Results</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Results</em>' reference list is set.
	 * @see #unsetHasResults()
	 * @see #getHasResults()
	 * @generated
	 */
	boolean isSetHasResults();

} // IfcStructuralAnalysisModel
