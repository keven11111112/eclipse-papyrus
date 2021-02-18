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
 * A representation of the model object '<em><b>Figure Gallery</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Kind of explicit figure library notion. Bundle of figures. Allows to specify plugin id (allows importing it later from gmfgen code) in addition to figures
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.FigureGallery#getFigures <em>Figures</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.FigureGallery#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.FigureGallery#getBorders <em>Borders</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.FigureGallery#getLayouts <em>Layouts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.FigureGallery#getImplementationBundle <em>Implementation Bundle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureGallery()
 * @model
 * @generated
 */
public interface FigureGallery extends Identity {
	/**
	 * Returns the value of the '<em><b>Figures</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.gmfgraph.RealFigure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figures</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureGallery_Figures()
	 * @model containment="true"
	 * @generated
	 */
	EList<RealFigure> getFigures();

	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.gmfgraph.FigureDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureGallery_Descriptors()
	 * @model containment="true"
	 * @generated
	 */
	EList<FigureDescriptor> getDescriptors();

	/**
	 * Returns the value of the '<em><b>Borders</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.gmfgraph.Border}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Borders for reuse
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Borders</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureGallery_Borders()
	 * @model containment="true"
	 * @generated
	 */
	EList<Border> getBorders();

	/**
	 * Returns the value of the '<em><b>Layouts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.gmfgraph.Layout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Layouts for reuse
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Layouts</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureGallery_Layouts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Layout> getLayouts();

	/**
	 * Returns the value of the '<em><b>Implementation Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Bundle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Bundle</em>' attribute.
	 * @see #setImplementationBundle(String)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getFigureGallery_ImplementationBundle()
	 * @model
	 * @generated
	 */
	String getImplementationBundle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.FigureGallery#getImplementationBundle <em>Implementation Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Bundle</em>' attribute.
	 * @see #getImplementationBundle()
	 * @generated
	 */
	void setImplementationBundle(String value);

} // FigureGallery
