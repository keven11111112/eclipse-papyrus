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


import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Figure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Any figure class provided by some bundle
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.CustomFigure#getCustomChildren <em>Custom Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getCustomFigure()
 * @model
 * @generated
 */
public interface CustomFigure extends RealFigure, CustomClass {
	/**
	 * Returns the value of the '<em><b>Custom Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.gmfgraph.FigureAccessor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Childrent enumerated with this feature are mere 'access points' to actual structure of the CustomFigure. They are not created, unlike those contained in regular Figure#children
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Custom Children</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getCustomFigure_CustomChildren()
	 * @model containment="true"
	 * @generated
	 */
	EList<FigureAccessor> getCustomChildren();

} // CustomFigure
