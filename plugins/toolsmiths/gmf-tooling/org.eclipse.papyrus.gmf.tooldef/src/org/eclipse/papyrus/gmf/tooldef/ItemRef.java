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
 * A representation of the model object '<em><b>Item Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.ItemRef#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getItemRef()
 * @model
 * @generated
 */
public interface ItemRef extends ItemBase {

	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' reference.
	 * @see #setItem(ItemBase)
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getItemRef_Item()
	 * @model required="true"
	 * @generated
	 */
	ItemBase getItem();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.ItemRef#getItem <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(ItemBase value);

} // ItemRef
