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
 * A representation of the model object '<em><b>Border Layout Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.BorderLayoutData#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.BorderLayoutData#isVertical <em>Vertical</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getBorderLayoutData()
 * @model
 * @generated
 */
public interface BorderLayoutData extends LayoutData {
	/**
	 * Returns the value of the '<em><b>Alignment</b></em>' attribute.
	 * The default value is <code>"CENTER"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.gmf.gmfgraph.Alignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alignment</em>' attribute.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.Alignment
	 * @see #setAlignment(Alignment)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getBorderLayoutData_Alignment()
	 * @model default="CENTER" required="true"
	 * @generated
	 */
	Alignment getAlignment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.BorderLayoutData#getAlignment <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alignment</em>' attribute.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.Alignment
	 * @see #getAlignment()
	 * @generated
	 */
	void setAlignment(Alignment value);

	/**
	 * Returns the value of the '<em><b>Vertical</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertical</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertical</em>' attribute.
	 * @see #setVertical(boolean)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getBorderLayoutData_Vertical()
	 * @model default="false"
	 * @generated
	 */
	boolean isVertical();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.BorderLayoutData#isVertical <em>Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertical</em>' attribute.
	 * @see #isVertical()
	 * @generated
	 */
	void setVertical(boolean value);

} // BorderLayoutData
