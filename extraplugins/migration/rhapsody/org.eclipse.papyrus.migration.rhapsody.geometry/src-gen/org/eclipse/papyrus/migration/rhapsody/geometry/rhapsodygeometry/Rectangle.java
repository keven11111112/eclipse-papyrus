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
 * A representation of the model object '<em><b>Rectangle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopLeft <em>Top Left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopRight <em>Top Right</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomLeft <em>Bottom Left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomRight <em>Bottom Right</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRectangle()
 * @model
 * @generated
 */
public interface Rectangle extends Polygon {
	/**
	 * Returns the value of the '<em><b>Top Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Left</em>' reference.
	 * @see #isSetTopLeft()
	 * @see #unsetTopLeft()
	 * @see #setTopLeft(Point)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRectangle_TopLeft()
	 * @model unsettable="true" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Point getTopLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopLeft <em>Top Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Left</em>' reference.
	 * @see #isSetTopLeft()
	 * @see #unsetTopLeft()
	 * @see #getTopLeft()
	 * @generated
	 */
	void setTopLeft(Point value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopLeft <em>Top Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopLeft()
	 * @see #getTopLeft()
	 * @see #setTopLeft(Point)
	 * @generated
	 */
	void unsetTopLeft();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopLeft <em>Top Left</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Left</em>' reference is set.
	 * @see #unsetTopLeft()
	 * @see #getTopLeft()
	 * @see #setTopLeft(Point)
	 * @generated
	 */
	boolean isSetTopLeft();

	/**
	 * Returns the value of the '<em><b>Top Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Right</em>' reference.
	 * @see #isSetTopRight()
	 * @see #unsetTopRight()
	 * @see #setTopRight(Point)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRectangle_TopRight()
	 * @model unsettable="true" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Point getTopRight();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopRight <em>Top Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Right</em>' reference.
	 * @see #isSetTopRight()
	 * @see #unsetTopRight()
	 * @see #getTopRight()
	 * @generated
	 */
	void setTopRight(Point value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopRight <em>Top Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopRight()
	 * @see #getTopRight()
	 * @see #setTopRight(Point)
	 * @generated
	 */
	void unsetTopRight();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopRight <em>Top Right</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Right</em>' reference is set.
	 * @see #unsetTopRight()
	 * @see #getTopRight()
	 * @see #setTopRight(Point)
	 * @generated
	 */
	boolean isSetTopRight();

	/**
	 * Returns the value of the '<em><b>Bottom Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Left</em>' reference.
	 * @see #isSetBottomLeft()
	 * @see #unsetBottomLeft()
	 * @see #setBottomLeft(Point)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRectangle_BottomLeft()
	 * @model unsettable="true" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Point getBottomLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomLeft <em>Bottom Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Left</em>' reference.
	 * @see #isSetBottomLeft()
	 * @see #unsetBottomLeft()
	 * @see #getBottomLeft()
	 * @generated
	 */
	void setBottomLeft(Point value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomLeft <em>Bottom Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomLeft()
	 * @see #getBottomLeft()
	 * @see #setBottomLeft(Point)
	 * @generated
	 */
	void unsetBottomLeft();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomLeft <em>Bottom Left</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Left</em>' reference is set.
	 * @see #unsetBottomLeft()
	 * @see #getBottomLeft()
	 * @see #setBottomLeft(Point)
	 * @generated
	 */
	boolean isSetBottomLeft();

	/**
	 * Returns the value of the '<em><b>Bottom Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Right</em>' reference.
	 * @see #isSetBottomRight()
	 * @see #unsetBottomRight()
	 * @see #setBottomRight(Point)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRectangle_BottomRight()
	 * @model unsettable="true" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Point getBottomRight();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomRight <em>Bottom Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Right</em>' reference.
	 * @see #isSetBottomRight()
	 * @see #unsetBottomRight()
	 * @see #getBottomRight()
	 * @generated
	 */
	void setBottomRight(Point value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomRight <em>Bottom Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomRight()
	 * @see #getBottomRight()
	 * @see #setBottomRight(Point)
	 * @generated
	 */
	void unsetBottomRight();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomRight <em>Bottom Right</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Right</em>' reference is set.
	 * @see #unsetBottomRight()
	 * @see #getBottomRight()
	 * @see #setBottomRight(Point)
	 * @generated
	 */
	boolean isSetBottomRight();

} // Rectangle
