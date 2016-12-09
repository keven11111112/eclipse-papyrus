/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polygon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Polygon#getPoints <em>Points</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getPolygon()
 * @model
 * @generated
 */
public interface Polygon extends EObject {
	/**
	 * Returns the value of the '<em><b>Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' containment reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getPolygon_Points()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Point> getPoints();

} // Polygon
