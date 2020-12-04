/*******************************************************************************
 * Copyright (c) 2009, 2020 Borland Software Corp, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Alexander Shatalin (Borland) - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.ast;

import org.eclipse.papyrus.gmf.internal.xpand.model.XpandAdvice;
import org.eclipse.papyrus.gmf.internal.xpand.model.XpandDefinition;

public interface AstVisitor {

	boolean visit(Template template);

	boolean visit(XpandAdvice advice);

	boolean visit(XpandDefinition definition);

	boolean visit(ErrorStatement statement);

	boolean visit(ExpandStatement statement);

	boolean visit(ExpressionStatement statement);

	boolean visit(FileStatement statement);

	boolean visit(ForEachStatement statement);

	boolean visit(IfStatement statement);

	boolean visit(LetStatement statement);

	boolean visit(ProtectStatement statement);

	boolean visit(TextStatement statement);

	boolean visit(Statement statement);

}
