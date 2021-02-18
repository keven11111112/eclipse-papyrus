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
 * A representation of the model object '<em><b>Custom Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.CustomPin#getCustomOperationName <em>Custom Operation Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.CustomPin#getCustomOperationType <em>Custom Operation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getCustomPin()
 * @model
 * @generated
 */
public interface CustomPin extends Pin {
	/**
	 * Returns the value of the '<em><b>Custom Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Operation Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Operation Name</em>' attribute.
	 * @see #setCustomOperationName(String)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getCustomPin_CustomOperationName()
	 * @model
	 * @generated
	 */
	String getCustomOperationName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.CustomPin#getCustomOperationName <em>Custom Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Operation Name</em>' attribute.
	 * @see #getCustomOperationName()
	 * @generated
	 */
	void setCustomOperationName(String value);

	/**
	 * Returns the value of the '<em><b>Custom Operation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Operation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Operation Type</em>' attribute.
	 * @see #setCustomOperationType(String)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getCustomPin_CustomOperationType()
	 * @model
	 * @generated
	 */
	String getCustomOperationType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.CustomPin#getCustomOperationType <em>Custom Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Operation Type</em>' attribute.
	 * @see #getCustomOperationType()
	 * @generated
	 */
	void setCustomOperationType(String value);

} // CustomPin
