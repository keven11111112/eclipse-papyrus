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
 * A representation of the model object '<em><b>Standard Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * predefined, like zoom or marquee
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.StandardTool#getToolKind <em>Tool Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getStandardTool()
 * @model
 * @generated
 */
public interface StandardTool extends AbstractTool {

	/**
	 * Returns the value of the '<em><b>Tool Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.gmf.tooldef.StandardToolKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Kind</em>' attribute.
	 * @see org.eclipse.papyrus.gmf.tooldef.StandardToolKind
	 * @see #setToolKind(StandardToolKind)
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getStandardTool_ToolKind()
	 * @model
	 * @generated
	 */
	StandardToolKind getToolKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.StandardTool#getToolKind <em>Tool Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tool Kind</em>' attribute.
	 * @see org.eclipse.papyrus.gmf.tooldef.StandardToolKind
	 * @see #getToolKind()
	 * @generated
	 */
	void setToolKind(StandardToolKind value);

} // StandardTool
