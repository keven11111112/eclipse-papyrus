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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.gmf.internal.bridge.trace.TracePackage
 * @generated
 */
public interface TraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TraceFactory eINSTANCE = org.eclipse.papyrus.gmf.internal.bridge.trace.impl.TraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	TraceModel createTraceModel();

	/**
	 * Returns a new object of class '<em>Gen Node Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Node Trace</em>'.
	 * @generated
	 */
	GenNodeTrace createGenNodeTrace();

	/**
	 * Returns a new object of class '<em>Gen Child Node Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Child Node Trace</em>'.
	 * @generated
	 */
	GenChildNodeTrace createGenChildNodeTrace();

	/**
	 * Returns a new object of class '<em>Gen Node Label Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Node Label Trace</em>'.
	 * @generated
	 */
	GenNodeLabelTrace createGenNodeLabelTrace();

	/**
	 * Returns a new object of class '<em>Gen Link Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Link Trace</em>'.
	 * @generated
	 */
	GenLinkTrace createGenLinkTrace();

	/**
	 * Returns a new object of class '<em>Gen Compartment Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Compartment Trace</em>'.
	 * @generated
	 */
	GenCompartmentTrace createGenCompartmentTrace();

	/**
	 * Returns a new object of class '<em>Gen Link Label Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Link Label Trace</em>'.
	 * @generated
	 */
	GenLinkLabelTrace createGenLinkLabelTrace();

	/**
	 * Returns a new object of class '<em>Tool Group Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tool Group Trace</em>'.
	 * @generated
	 */
	ToolGroupTrace createToolGroupTrace();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TracePackage getTracePackage();

} //TraceFactory
