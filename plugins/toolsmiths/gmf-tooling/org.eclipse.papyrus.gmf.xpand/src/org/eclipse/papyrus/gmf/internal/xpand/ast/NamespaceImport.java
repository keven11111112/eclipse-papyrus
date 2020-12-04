/******************************************************************************
 * Copyright (c) 2006, 2020 committers of openArchitectureWare, CEA LIST, Artal and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *     Sven Efftinge - Initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/

package org.eclipse.papyrus.gmf.internal.xpand.ast;

import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.papyrus.gmf.internal.xpand.expression.ast.SyntaxElement;

// XXX XpandAnalyzable to check if metamodel is accessible
public class NamespaceImport extends SyntaxElement {
	private final String importString;

	public NamespaceImport(int start, int end, int line, StringLiteralExpCS importCS) {
		super(start, end, line);
		// FIXME for complete care, look at AbstractOCLAnalyzer#processStringEscapes
		importString = importCS.getUnescapedStringSymbol();
	}

	public String getImportString() {
		return importString;
	}

}
