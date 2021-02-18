/******************************************************************************
 * Copyright (c) 2008, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.ocl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.ocl.parser.OCLParser;

import lpg.runtime.Monitor;

class EmbeddedOCLAnalyzer extends AbstractOCLAnalyzer<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter,
			EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> {

	EmbeddedOCLAnalyzer(EcoreEnvironment environment) {
		// EcoreEnvironment is also BasicEnvironment,
		// and hence #getOCLEnvironment() would return it.
		// The rest of AbstractOCLParser is only that we need to pass anything but null 
		// to superclass's constructor
		super(new OCLParser(new OCLLexer(environment)) {
			
			@Override
			public CSTNode parser(Monitor monitor, int error_repair_count) {
				throw new UnsupportedOperationException("This analyzer is expected to get CST ready for use");
			}
		});
	}

	public OCLExpression analyzeExpression(OCLExpressionCS exprCS) {
		return (OCLExpression) super.oclExpressionCS(exprCS, getOCLEnvironment());
	}

	public EClassifier typeForName(TypeCS typeCS) {
		return super.typeCS(typeCS, getOCLEnvironment());
	}
}
