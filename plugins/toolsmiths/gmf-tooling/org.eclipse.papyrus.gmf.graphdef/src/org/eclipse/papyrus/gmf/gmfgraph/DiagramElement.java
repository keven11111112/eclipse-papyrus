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
 * A representation of the model object '<em><b>Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.DiagramElement#getFigure <em>Figure</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.DiagramElement#getFacets <em>Facets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getDiagramElement()
 * @model abstract="true"
 * @generated
 */
public interface DiagramElement extends Identity {
	/**
	 * Returns the value of the '<em><b>Figure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figure</em>' reference.
	 * @see #setFigure(FigureDescriptor)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getDiagramElement_Figure()
	 * @model required="true"
	 * @generated
	 */
	FigureDescriptor getFigure();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.DiagramElement#getFigure <em>Figure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Figure</em>' reference.
	 * @see #getFigure()
	 * @generated
	 */
	void setFigure(FigureDescriptor value);

	/**
	 * Returns the value of the '<em><b>Facets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.gmfgraph.VisualFacet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * anything to further specify constraint or any other aspect of the element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Facets</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getDiagramElement_Facets()
	 * @model containment="true"
	 * @generated
	 */
	EList<VisualFacet> getFacets();

} // DiagramElement
