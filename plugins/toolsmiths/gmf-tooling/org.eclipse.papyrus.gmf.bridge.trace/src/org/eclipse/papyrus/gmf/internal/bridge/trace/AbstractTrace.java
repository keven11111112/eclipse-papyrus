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
package org.eclipse.papyrus.gmf.internal.bridge.trace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.internal.bridge.trace.AbstractTrace#getVisualID <em>Visual ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.internal.bridge.trace.AbstractTrace#isProcessed <em>Processed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.internal.bridge.trace.TracePackage#getAbstractTrace()
 * @model abstract="true"
 * @generated
 */
public interface AbstractTrace extends EObject {
	/**
	 * Returns the value of the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visual ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visual ID</em>' attribute.
	 * @see #setVisualID(int)
	 * @see org.eclipse.papyrus.gmf.internal.bridge.trace.TracePackage#getAbstractTrace_VisualID()
	 * @model id="true"
	 * @generated
	 */
	int getVisualID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.internal.bridge.trace.AbstractTrace#getVisualID <em>Visual ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual ID</em>' attribute.
	 * @see #getVisualID()
	 * @generated
	 */
	void setVisualID(int value);

	/**
	 * Returns the value of the '<em><b>Processed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processed</em>' attribute.
	 * @see #setProcessed(boolean)
	 * @see org.eclipse.papyrus.gmf.internal.bridge.trace.TracePackage#getAbstractTrace_Processed()
	 * @model default="false" transient="true"
	 * @generated
	 */
	boolean isProcessed();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.internal.bridge.trace.AbstractTrace#isProcessed <em>Processed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processed</em>' attribute.
	 * @see #isProcessed()
	 * @generated
	 */
	void setProcessed(boolean value);

} // AbstractTrace
