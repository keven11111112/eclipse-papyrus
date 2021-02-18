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

import java.util.Set;

import org.eclipse.papyrus.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.papyrus.gmf.internal.xpand.model.ExecutionContext;

/**
 * @author Sven Efftinge
 */
public class TextStatement extends Statement {
    private final String value;

    private final boolean deleteLine;

    public TextStatement(final int start, final int end, final int line, final String text, final boolean nonl) {
        super(start, end, line);
        deleteLine = nonl;
        value = text;
    }

    public String getValue() {
        return value;
    }

    public boolean isDeleteLine() {
        return deleteLine;
    }

    public void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        // Nothing to check here
    }

    @Override
    public void evaluateInternal(final ExecutionContext ctx) {
        ctx.getScope().getOutput().write(getValue());
    }

}
