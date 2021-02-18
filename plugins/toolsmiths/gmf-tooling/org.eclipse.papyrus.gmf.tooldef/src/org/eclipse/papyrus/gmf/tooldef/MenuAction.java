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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.MenuAction#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.MenuAction#getHotKey <em>Hot Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getMenuAction()
 * @model
 * @generated
 */
public interface MenuAction extends ContributionItem {

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.gmf.tooldef.ActionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.gmf.tooldef.ActionKind
	 * @see #setKind(ActionKind)
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getMenuAction_Kind()
	 * @model
	 * @generated
	 */
	ActionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.MenuAction#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.gmf.tooldef.ActionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ActionKind value);

	/**
	 * Returns the value of the '<em><b>Hot Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hot Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hot Key</em>' attribute.
	 * @see #setHotKey(String)
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getMenuAction_HotKey()
	 * @model
	 * @generated
	 */
	String getHotKey();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.MenuAction#getHotKey <em>Hot Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hot Key</em>' attribute.
	 * @see #getHotKey()
	 * @generated
	 */
	void setHotKey(String value);

} // MenuAction
