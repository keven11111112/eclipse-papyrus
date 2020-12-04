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
package org.eclipse.papyrus.gmf.internal.bridge.trace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.papyrus.gmf.internal.bridge.trace.GenCompartmentTrace;
import org.eclipse.papyrus.gmf.internal.bridge.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Compartment Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class GenCompartmentTraceImpl extends MatchingTraceImpl implements GenCompartmentTrace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenCompartmentTraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.GEN_COMPARTMENT_TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setContext(GenCompartment genCompartment) {
		setQueryText("true");
	}
	
	public EClass getQueryContext() {
		return GMFGenPackage.eINSTANCE.getGenCompartment();
	}
	
} //GenCompartmentTraceImpl
