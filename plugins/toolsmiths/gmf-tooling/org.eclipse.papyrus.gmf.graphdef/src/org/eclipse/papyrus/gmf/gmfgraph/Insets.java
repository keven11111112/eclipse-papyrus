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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Insets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.Insets#getTop <em>Top</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.Insets#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.Insets#getBottom <em>Bottom</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.Insets#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getInsets()
 * @model
 * @generated
 */
public interface Insets extends EObject {
	/**
	 * Returns the value of the '<em><b>Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top</em>' attribute.
	 * @see #setTop(int)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getInsets_Top()
	 * @model
	 * @generated
	 */
	int getTop();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.Insets#getTop <em>Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top</em>' attribute.
	 * @see #getTop()
	 * @generated
	 */
	void setTop(int value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' attribute.
	 * @see #setLeft(int)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getInsets_Left()
	 * @model
	 * @generated
	 */
	int getLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.Insets#getLeft <em>Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' attribute.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(int value);

	/**
	 * Returns the value of the '<em><b>Bottom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom</em>' attribute.
	 * @see #setBottom(int)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getInsets_Bottom()
	 * @model
	 * @generated
	 */
	int getBottom();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.Insets#getBottom <em>Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom</em>' attribute.
	 * @see #getBottom()
	 * @generated
	 */
	void setBottom(int value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' attribute.
	 * @see #setRight(int)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getInsets_Right()
	 * @model
	 * @generated
	 */
	int getRight();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.Insets#getRight <em>Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' attribute.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(int value);

} // Insets
