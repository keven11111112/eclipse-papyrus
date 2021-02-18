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
 * A representation of the model object '<em><b>Border Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Border reuse mechanism
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.BorderRef#getActual <em>Actual</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getBorderRef()
 * @model
 * @generated
 */
public interface BorderRef extends Border {
	/**
	 * Returns the value of the '<em><b>Actual</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * constraint: actual should not be another BorderRef
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actual</em>' reference.
	 * @see #setActual(Border)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getBorderRef_Actual()
	 * @model required="true"
	 * @generated
	 */
	Border getActual();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.BorderRef#getActual <em>Actual</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual</em>' reference.
	 * @see #getActual()
	 * @generated
	 */
	void setActual(Border value);

} // BorderRef
