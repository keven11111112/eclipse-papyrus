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

import java.text.MessageFormat;
import java.util.Set;

import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.papyrus.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.papyrus.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.papyrus.gmf.internal.xpand.ocl.ExpressionHelper;

/**
 * @author Sven Efftinge
 */
public class ErrorStatement extends Statement {

	private final ExpressionHelper message;

    public ErrorStatement(final int start, final int end, final int line, final OCLExpressionCS msg) {
        super(start, end, line);
        message = new ExpressionHelper(msg, this);
    }

    public void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
    	message.analyze(ctx, issues);
    }

    @Override
    public void evaluateInternal(final ExecutionContext ctx) {
		String result = String.valueOf(message.evaluate(ctx));
        throw new RuntimeException(MessageFormat.format("Error in {0}:{1}: {2}", getFileName(), getLine(), result));
    }

    ExpressionHelper getMessage() {
    	return message;
    }
    
}
