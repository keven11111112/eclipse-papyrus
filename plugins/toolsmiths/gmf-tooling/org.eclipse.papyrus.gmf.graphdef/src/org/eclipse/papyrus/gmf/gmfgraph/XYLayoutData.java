/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.gmf.gmfgraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XY Layout Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.XYLayoutData#getTopLeft <em>Top Left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.XYLayoutData#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getXYLayoutData()
 * @model
 * @generated
 */
public interface XYLayoutData extends LayoutData {
	/**
	 * Returns the value of the '<em><b>Top Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Left</em>' containment reference.
	 * @see #setTopLeft(Point)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getXYLayoutData_TopLeft()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Point getTopLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.XYLayoutData#getTopLeft <em>Top Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Left</em>' containment reference.
	 * @see #getTopLeft()
	 * @generated
	 */
	void setTopLeft(Point value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' containment reference.
	 * @see #setSize(Dimension)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getXYLayoutData_Size()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Dimension getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.XYLayoutData#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' containment reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Dimension value);

} // XYLayoutData
