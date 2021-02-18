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
 * A representation of the model object '<em><b>Polyline Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * org.eclipse.draw2d.PolylineConnection
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.PolylineConnection#getSourceDecoration <em>Source Decoration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.PolylineConnection#getTargetDecoration <em>Target Decoration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getPolylineConnection()
 * @model
 * @generated
 */
public interface PolylineConnection extends Polyline, ConnectionFigure {
	/**
	 * Returns the value of the '<em><b>Source Decoration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Decoration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Decoration</em>' reference.
	 * @see #setSourceDecoration(DecorationFigure)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getPolylineConnection_SourceDecoration()
	 * @model
	 * @generated
	 */
	DecorationFigure getSourceDecoration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.PolylineConnection#getSourceDecoration <em>Source Decoration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Decoration</em>' reference.
	 * @see #getSourceDecoration()
	 * @generated
	 */
	void setSourceDecoration(DecorationFigure value);

	/**
	 * Returns the value of the '<em><b>Target Decoration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Decoration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Decoration</em>' reference.
	 * @see #setTargetDecoration(DecorationFigure)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getPolylineConnection_TargetDecoration()
	 * @model
	 * @generated
	 */
	DecorationFigure getTargetDecoration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.PolylineConnection#getTargetDecoration <em>Target Decoration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Decoration</em>' reference.
	 * @see #getTargetDecoration()
	 * @generated
	 */
	void setTargetDecoration(DecorationFigure value);

} // PolylineConnection
