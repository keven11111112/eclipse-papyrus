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
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.ast;

import org.eclipse.papyrus.gmf.internal.xpand.model.XpandAdvice;
import org.eclipse.papyrus.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.papyrus.gmf.internal.xpand.ocl.ExpressionHelper;

public abstract class AbstractAstVisitor implements AstVisitor {

	public boolean visit(Template template) {
		return true;
	}

	public boolean visit(XpandAdvice advice) {
		if (advice instanceof AbstractDefinition) {
			return visit((AbstractDefinition) advice);
		}
		return true;
	}

	public boolean visit(XpandDefinition definition) {
		if (definition instanceof AbstractDefinition) {
			return visit((AbstractDefinition) definition);
		}
		return true;
	}

	protected boolean visit(AbstractDefinition definition) {
		return true;
	}

	public boolean visit(ErrorStatement statement) {
		visitExpressionHelper(statement.getMessage());
		return true;
	}

	public boolean visit(ExpandStatement statement) {
		for (ExpressionHelper parameter : statement.getParameters()) {
			visitExpressionHelper(parameter);
		}
		if (statement.getSeparator() != null) {
			visitExpressionHelper(statement.getSeparator());
		}
		if (statement.getTarget() != null) {
			visitExpressionHelper(statement.getTarget());
		}
		return true;
	}

	public boolean visit(ExpressionStatement statement) {
		visitExpressionHelper(statement.getExpression());
		return true;
	}

	public boolean visit(FileStatement statement) {
		visitExpressionHelper(statement.getTargetFileName());
		return true;
	}

	public boolean visit(ForEachStatement statement) {
		if (statement.getSeparator() != null) {
			visitExpressionHelper(statement.getSeparator());
		}
		visitExpressionHelper(statement.getTarget());
		return true;
	}

	public boolean visit(IfStatement statement) {
		if (statement.getCondition() != null) {
			visitExpressionHelper(statement.getCondition());
		}
		return true;
	}

	public boolean visit(LetStatement statement) {
		visitExpressionHelper(statement.getVarValue());
		return true;
	}

	public boolean visit(ProtectStatement statement) {
		visitExpressionHelper(statement.getCommentStart());
		visitExpressionHelper(statement.getCommentEnd());
		visitExpressionHelper(statement.getId());
		return true;
	}

	public boolean visit(TextStatement statement) {
		return true;
	}

	public boolean visit(Statement statement) {
		return true;
	}

	protected void visitExpressionHelper(ExpressionHelper expressionHelper) {
	}

}
