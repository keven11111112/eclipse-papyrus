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
 * A representation of the model object '<em><b>Figure Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The thing describes structure of a figure
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.FigureDescriptor#getActualFigure <em>Actual Figure</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.FigureDescriptor#getAccessors <em>Accessors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureDescriptor()
 * @model
 * @generated
 */
public interface FigureDescriptor extends Identity {
	/**
	 * Returns the value of the '<em><b>Actual Figure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Figure</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Figure</em>' containment reference.
	 * @see #setActualFigure(Figure)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureDescriptor_ActualFigure()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Figure getActualFigure();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.FigureDescriptor#getActualFigure <em>Actual Figure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Figure</em>' containment reference.
	 * @see #getActualFigure()
	 * @generated
	 */
	void setActualFigure(Figure value);

	/**
	 * Returns the value of the '<em><b>Accessors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.gmfgraph.ChildAccess}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.gmfgraph.ChildAccess#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessors</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureDescriptor_Accessors()
	 * @see org.eclipse.papyrus.gmf.gmfgraph.ChildAccess#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<ChildAccess> getAccessors();

} // FigureDescriptor
