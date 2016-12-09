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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rhapsody Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyPort#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyPort()
 * @model
 * @generated
 */
public interface RhapsodyPort extends RhapsodyShape {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position
	 * @see #setPosition(Position)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyPort_Position()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Position getPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyPort#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Position value);

} // RhapsodyPort
