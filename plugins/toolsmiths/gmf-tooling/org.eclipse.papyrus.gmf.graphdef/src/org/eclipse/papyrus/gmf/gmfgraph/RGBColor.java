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
 * A representation of the model object '<em><b>RGB Color</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.RGBColor#getRed <em>Red</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.RGBColor#getGreen <em>Green</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.RGBColor#getBlue <em>Blue</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getRGBColor()
 * @model
 * @generated
 */
public interface RGBColor extends Color {
	/**
	 * Returns the value of the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Red</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Red</em>' attribute.
	 * @see #setRed(int)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getRGBColor_Red()
	 * @model required="true"
	 * @generated
	 */
	int getRed();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.RGBColor#getRed <em>Red</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Red</em>' attribute.
	 * @see #getRed()
	 * @generated
	 */
	void setRed(int value);

	/**
	 * Returns the value of the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Green</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Green</em>' attribute.
	 * @see #setGreen(int)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getRGBColor_Green()
	 * @model required="true"
	 * @generated
	 */
	int getGreen();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.RGBColor#getGreen <em>Green</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Green</em>' attribute.
	 * @see #getGreen()
	 * @generated
	 */
	void setGreen(int value);

	/**
	 * Returns the value of the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blue</em>' attribute.
	 * @see #setBlue(int)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getRGBColor_Blue()
	 * @model required="true"
	 * @generated
	 */
	int getBlue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.RGBColor#getBlue <em>Blue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blue</em>' attribute.
	 * @see #getBlue()
	 * @generated
	 */
	void setBlue(int value);

} // RGBColor
