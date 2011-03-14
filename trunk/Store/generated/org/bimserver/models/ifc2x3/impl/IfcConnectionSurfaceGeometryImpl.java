/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcConnectionSurfaceGeometry;
import org.bimserver.models.ifc2x3.IfcSurfaceOrFaceSurface;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Surface Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionSurfaceGeometryImpl#getSurfaceOnRelatingElement <em>Surface On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionSurfaceGeometryImpl#getSurfaceOnRelatedElement <em>Surface On Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConnectionSurfaceGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionSurfaceGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionSurfaceGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcConnectionSurfaceGeometry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceOrFaceSurface getSurfaceOnRelatingElement() {
		return (IfcSurfaceOrFaceSurface)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionSurfaceGeometry_SurfaceOnRelatingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurfaceOnRelatingElement(IfcSurfaceOrFaceSurface newSurfaceOnRelatingElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionSurfaceGeometry_SurfaceOnRelatingElement(), newSurfaceOnRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceOrFaceSurface getSurfaceOnRelatedElement() {
		return (IfcSurfaceOrFaceSurface)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionSurfaceGeometry_SurfaceOnRelatedElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurfaceOnRelatedElement(IfcSurfaceOrFaceSurface newSurfaceOnRelatedElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionSurfaceGeometry_SurfaceOnRelatedElement(), newSurfaceOnRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSurfaceOnRelatedElement() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionSurfaceGeometry_SurfaceOnRelatedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSurfaceOnRelatedElement() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionSurfaceGeometry_SurfaceOnRelatedElement());
	}

} //IfcConnectionSurfaceGeometryImpl
