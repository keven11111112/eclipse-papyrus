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

public class AstIterator {

	private AstVisitor myVisitor;

	AstIterator(AstVisitor visitor) {
		myVisitor = visitor;
	}

	public void iterate(Template template) {
		if (!myVisitor.visit(template)) {
			return;
		}
		for (XpandDefinition definition : template.getDefinitions()) {
			iterate(definition);
		}

		for (XpandAdvice advice : template.getAdvices()) {
			iterate(advice);
		}
	}

	public void iterate(XpandDefinition definition) {
		if (!myVisitor.visit(definition)) {
			return;
		}
		if (definition instanceof AbstractDefinition) {
			iterate(((AbstractDefinition) definition).getBody());
		}
	}

	public void iterate(XpandAdvice advice) {
		if (!myVisitor.visit(advice)) {
			return;
		}
		if (advice instanceof AbstractDefinition) {
			iterate(((AbstractDefinition) advice).getBody());
		}
	}

	public void iterate(Statement[] body) {
		for (Statement statement : body) {
			if (statement instanceof ErrorStatement) {
				iterate((ErrorStatement) statement);
			} else if (statement instanceof ExpandStatement) {
				iterate((ExpandStatement) statement);
			} else if (statement instanceof ExpressionStatement) {
				iterate((ExpressionStatement) statement);
			} else if (statement instanceof FileStatement) {
				iterate((FileStatement) statement);
			} else if (statement instanceof ForEachStatement) {
				iterate((ForEachStatement) statement);
			} else if (statement instanceof IfStatement) {
				iterate((IfStatement) statement);
			} else if (statement instanceof LetStatement) {
				iterate((LetStatement) statement);
			} else if (statement instanceof ProtectStatement) {
				iterate((ProtectStatement) statement);
			} else if (statement instanceof TextStatement) {
				iterate((TextStatement) statement);
			} else {
				iterate(statement);
			}
		}
	}

	public void iterate(Statement statement) {
		myVisitor.visit(statement);
	}

	public void iterate(TextStatement statement) {
		myVisitor.visit(statement);
	}

	public void iterate(ProtectStatement statement) {
		if (!myVisitor.visit(statement)) {
			return;
		}
		iterate(statement.getBody());
	}

	public void iterate(LetStatement statement) {
		if (!myVisitor.visit(statement)) {
			return;
		}
		iterate(statement.getBody());
	}

	public void iterate(IfStatement statement) {
		if (!myVisitor.visit(statement)) {
			return;
		}
		iterate(statement.getThenPart());
		if (statement.getElseIf() != null) {
			iterate(statement.getElseIf());
		}
	}

	public void iterate(ForEachStatement statement) {
		if (!myVisitor.visit(statement)) {
			return;
		}
		iterate(statement.getBody());
	}

	public void iterate(FileStatement statement) {
		if (!myVisitor.visit(statement)) {
			return;
		}
		iterate(statement.getBody());
	}

	public void iterate(ExpressionStatement statement) {
		myVisitor.visit(statement);
	}

	public void iterate(ExpandStatement statement) {
		myVisitor.visit(statement);
	}

	public void iterate(ErrorStatement statement) {
		myVisitor.visit(statement);
	}

}
