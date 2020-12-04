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
 * A representation of the model object '<em><b>Border Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.BorderLayout#getSpacing <em>Spacing</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getBorderLayout()
 * @model
 * @generated
 */
public interface BorderLayout extends Layout {
	/**
	 * Returns the value of the '<em><b>Spacing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spacing</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spacing</em>' containment reference.
	 * @see #setSpacing(Dimension)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getBorderLayout_Spacing()
	 * @model containment="true"
	 * @generated
	 */
	Dimension getSpacing();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.BorderLayout#getSpacing <em>Spacing</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spacing</em>' containment reference.
	 * @see #getSpacing()
	 * @generated
	 */
	void setSpacing(Dimension value);

} // BorderLayout
