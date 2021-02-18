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
import org.eclipse.papyrus.gmf.tooldef.AbstractTool;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ToolOwner#getTool <em>Tool</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getToolOwner()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ToolOwner extends EObject {
	/**
	 * Returns the value of the '<em><b>Tool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Way to create this element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tool</em>' reference.
	 * @see #setTool(AbstractTool)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getToolOwner_Tool()
	 * @model
	 * @generated
	 */
	AbstractTool getTool();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.ToolOwner#getTool <em>Tool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tool</em>' reference.
	 * @see #getTool()
	 * @generated
	 */
	void setTool(AbstractTool value);

} // ToolOwner
