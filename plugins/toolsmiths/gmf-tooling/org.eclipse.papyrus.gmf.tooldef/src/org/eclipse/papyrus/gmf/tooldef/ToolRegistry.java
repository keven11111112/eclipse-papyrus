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
package org.eclipse.papyrus.gmf.tooldef;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.ToolRegistry#getSharedActions <em>Shared Actions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.ToolRegistry#getAllMenus <em>All Menus</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.ToolRegistry#getPalette <em>Palette</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getToolRegistry()
 * @model
 * @generated
 */
public interface ToolRegistry extends EObject {

	/**
	 * Returns the value of the '<em><b>Shared Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.tooldef.MenuAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Instead of placing	common actions somewhere in menu hierarchy and referencing them in (2..n) cases, keep them in this central registry and use ItemRef everywhere (i.e. in 1..n cases)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shared Actions</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getToolRegistry_SharedActions()
	 * @model containment="true"
	 * @generated
	 */
	EList<MenuAction> getSharedActions();

	/**
	 * Returns the value of the '<em><b>All Menus</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.tooldef.Menu}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Menus</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Menus</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getToolRegistry_AllMenus()
	 * @model containment="true"
	 * @generated
	 */
	EList<Menu> getAllMenus();

	/**
	 * Returns the value of the '<em><b>Palette</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Palette</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Palette</em>' containment reference.
	 * @see #setPalette(Palette)
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getToolRegistry_Palette()
	 * @model containment="true"
	 * @generated
	 */
	Palette getPalette();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.ToolRegistry#getPalette <em>Palette</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Palette</em>' containment reference.
	 * @see #getPalette()
	 * @generated
	 */
	void setPalette(Palette value);

} // ToolRegistry
