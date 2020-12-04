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
package org.eclipse.papyrus.gmf.internal.xpand.ast;

import org.eclipse.papyrus.gmf.internal.xpand.eval.EvaluationListener;
import org.eclipse.papyrus.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.papyrus.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.papyrus.gmf.internal.xpand.model.XpandAnalyzable;
import org.eclipse.papyrus.gmf.internal.xpand.model.XpandEvaluatable;

public abstract class Statement extends SyntaxElement implements XpandAnalyzable, XpandEvaluatable {
    public Statement(final int start, final int end, final int line) {
        super(start, end, line);
    }

    public final void evaluate(final ExecutionContext ctx) {
        try {
        	notifyEnter(ctx);
            ctx.getScope().getOutput().enterStatement(this);
        	evaluateInternal(ctx);
            ctx.getScope().getOutput().exitStatement(null);
        } finally {
        	notifyLeave(ctx);
        }
    }

    protected abstract void evaluateInternal(ExecutionContext ctx);

    private void notifyEnter(ExecutionContext ctx) {
    	EvaluationListener l = ctx.getScope().getEvaluationListener();
    	if (l != null) {
    		l.enter(this, ctx);
    	}
    }

    private void notifyLeave(ExecutionContext ctx) {
    	EvaluationListener l = ctx.getScope().getEvaluationListener();
    	if (l != null) {
    		l.leave(this, ctx);
    	}
    }
}
