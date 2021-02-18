/*******************************************************************************
 * Copyright (c) 2005-2020 Sven Efftinge, CEA LIST, Artal and others.
 * All rights reserved.   This program and the accompanying materials
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
package org.eclipse.papyrus.gmf.internal.xpand.expression.ast;

public abstract class SyntaxElement {
    protected final int start;

    protected final int end;

    protected final int line;

    public SyntaxElement(final int start, final int end, final int line) {
        this.start = start;
        this.end = end;
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    private String fileName;

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
