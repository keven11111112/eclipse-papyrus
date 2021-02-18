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
 * A representation of the model object '<em><b>Layoutable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.Layoutable#getLayoutData <em>Layout Data</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.Layoutable#getLayout <em>Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getLayoutable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Layoutable extends EObject {
	/**
	 * Returns the value of the '<em><b>Layout Data</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.gmfgraph.LayoutData#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Data</em>' containment reference.
	 * @see #setLayoutData(LayoutData)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getLayoutable_LayoutData()
	 * @see org.eclipse.papyrus.gmf.gmfgraph.LayoutData#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	LayoutData getLayoutData();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.Layoutable#getLayoutData <em>Layout Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Data</em>' containment reference.
	 * @see #getLayoutData()
	 * @generated
	 */
	void setLayoutData(LayoutData value);

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' containment reference.
	 * @see #setLayout(Layout)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getLayoutable_Layout()
	 * @model containment="true"
	 * @generated
	 */
	Layout getLayout();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.Layoutable#getLayout <em>Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' containment reference.
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(Layout value);

} // Layoutable
