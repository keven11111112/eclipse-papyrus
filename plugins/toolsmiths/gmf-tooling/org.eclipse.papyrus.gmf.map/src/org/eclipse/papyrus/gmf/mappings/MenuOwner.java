/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
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
package org.eclipse.papyrus.gmf.mappings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.gmf.tooldef.ContextMenu;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.MenuOwner#getContextMenu <em>Context Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getMenuOwner()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MenuOwner extends EObject {
	/**
	 * Returns the value of the '<em><b>Context Menu</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Menu</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Menu</em>' reference.
	 * @see #setContextMenu(ContextMenu)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getMenuOwner_ContextMenu()
	 * @model
	 * @generated
	 */
	ContextMenu getContextMenu();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.MenuOwner#getContextMenu <em>Context Menu</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Menu</em>' reference.
	 * @see #getContextMenu()
	 * @generated
	 */
	void setContextMenu(ContextMenu value);

} // MenuOwner
