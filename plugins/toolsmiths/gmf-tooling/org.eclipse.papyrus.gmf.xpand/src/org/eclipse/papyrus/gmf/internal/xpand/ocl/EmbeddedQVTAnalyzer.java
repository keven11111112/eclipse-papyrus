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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOLexer;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParser;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.OCLExpression;

import lpg.runtime.Monitor;

/**
 * @author artem
 *
 */
class EmbeddedQVTAnalyzer extends QvtOperationalVisitorCS {

	EmbeddedQVTAnalyzer(EcoreEnvironment env) {
		super(new QVTOParser(new QVTOLexer(env)) {
			@Override
			public String getTokenKindName(int kind) {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public CSTNode parser(Monitor monitor, int error_repair_count) {
				throw new UnsupportedOperationException();
			}
		}, options());
	}

	public OCLExpression<EClassifier> analyzeExpression(OCLExpressionCS oclExpressionCS) {
		return super.oclExpressionCS(oclExpressionCS, getOCLEnvironment());
	}

	private static QvtCompilerOptions options() {
		QvtCompilerOptions options = new QvtCompilerOptions();
		options.setGenerateCompletionData(false);
		options.setShowAnnotations(false);
		return options;
	}
}
