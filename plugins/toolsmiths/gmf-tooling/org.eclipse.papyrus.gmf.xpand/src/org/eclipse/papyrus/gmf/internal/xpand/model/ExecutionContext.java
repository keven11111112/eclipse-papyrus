/******************************************************************************
 * Copyright (c) 2005, 2020 Sven Efftinge, CEA LIST, Artal and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.model;

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitor;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.papyrus.gmf.internal.xpand.ResourceMarker;
import org.eclipse.papyrus.gmf.internal.xpand.xtend.ast.QvtExtension;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 * XXX would be great to have some cancellation behavior available from environment (i.e. for debuger to be able to stop execution)
 */
public interface ExecutionContext {

	// FIXME replace with Variable constructor without a name
	public final static String IMPLICIT_VARIABLE = "this";

	ExecutionContext cloneWithVariable(Variable... v);

	ExecutionContext cloneWithResource(ResourceMarker ns);

	Variable getImplicitVariable();

	Set<QvtExtension> getAllExtensions();

	// may return null if no definition found
	XpandDefinition findDefinition(String name, EClassifier target, EClassifier[] paramTypes) throws AmbiguousDefinitionException;
	
	EcoreEnvironment getOCLEnvironment();
	QvtOperationalEvaluationVisitor createEvaluationVisitor();

	Scope getScope();

}
