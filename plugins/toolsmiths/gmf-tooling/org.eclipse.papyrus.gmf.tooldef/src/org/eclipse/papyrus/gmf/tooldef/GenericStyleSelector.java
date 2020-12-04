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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Style Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.GenericStyleSelector#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getGenericStyleSelector()
 * @model
 * @generated
 */
public interface GenericStyleSelector extends StyleSelector {

	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.tooldef.AppearanceStyle}.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.gmf.tooldef.AppearanceStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see org.eclipse.papyrus.gmf.tooldef.AppearanceStyle
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getGenericStyleSelector_Values()
	 * @model required="true"
	 * @generated
	 */
	EList<AppearanceStyle> getValues();

} // GenericStyleSelector
