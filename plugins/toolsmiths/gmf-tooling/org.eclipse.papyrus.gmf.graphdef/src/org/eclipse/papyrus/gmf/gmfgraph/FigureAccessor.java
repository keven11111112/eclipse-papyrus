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

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Figure Accessor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.FigureAccessor#getAccessor <em>Accessor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.FigureAccessor#getTypedFigure <em>Typed Figure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureAccessor()
 * @model
 * @generated
 */
public interface FigureAccessor extends EObject {
	/**
	 * Returns the value of the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessor</em>' attribute.
	 * @see #setAccessor(String)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureAccessor_Accessor()
	 * @model required="true"
	 * @generated
	 */
	String getAccessor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.FigureAccessor#getAccessor <em>Accessor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accessor</em>' attribute.
	 * @see #getAccessor()
	 * @generated
	 */
	void setAccessor(String value);

	/**
	 * Returns the value of the '<em><b>Typed Figure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Figure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Figure</em>' containment reference.
	 * @see #setTypedFigure(RealFigure)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureAccessor_TypedFigure()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RealFigure getTypedFigure();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.FigureAccessor#getTypedFigure <em>Typed Figure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Figure</em>' containment reference.
	 * @see #getTypedFigure()
	 * @generated
	 */
	void setTypedFigure(RealFigure value);

} // FigureAccessor
