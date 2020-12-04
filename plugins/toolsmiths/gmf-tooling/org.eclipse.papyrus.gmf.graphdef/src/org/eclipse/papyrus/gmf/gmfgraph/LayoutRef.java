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
 * A representation of the model object '<em><b>Layout Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Layout reuse mechanism
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.LayoutRef#getActual <em>Actual</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getLayoutRef()
 * @model
 * @generated
 */
public interface LayoutRef extends Layout {
	/**
	 * Returns the value of the '<em><b>Actual</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * constraint: actual should not be another LayoutRef
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actual</em>' reference.
	 * @see #setActual(Layout)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getLayoutRef_Actual()
	 * @model required="true"
	 * @generated
	 */
	Layout getActual();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.LayoutRef#getActual <em>Actual</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual</em>' reference.
	 * @see #getActual()
	 * @generated
	 */
	void setActual(Layout value);

} // LayoutRef
