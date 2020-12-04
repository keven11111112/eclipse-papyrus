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
 * A representation of the model object '<em><b>Constant Color</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.ConstantColor#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getConstantColor()
 * @model
 * @generated
 */
public interface ConstantColor extends Color {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.gmf.gmfgraph.ColorConstants}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.ColorConstants
	 * @see #setValue(ColorConstants)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getConstantColor_Value()
	 * @model required="true"
	 * @generated
	 */
	ColorConstants getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.ConstantColor#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.ColorConstants
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ColorConstants value);

} // ConstantColor
