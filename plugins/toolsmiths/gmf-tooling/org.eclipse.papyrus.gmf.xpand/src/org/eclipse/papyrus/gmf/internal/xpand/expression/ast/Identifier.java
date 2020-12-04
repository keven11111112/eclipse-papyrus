/******************************************************************************
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

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class Identifier extends SyntaxElement {
    private final String value;

    public Identifier(final int start, final int end, final int line, final String value) {
        super(start, end, line);
        this.value = value;
    }

    public Identifier append(final Identifier t) {
    	return new Identifier(this.start, t.end, this.line, value + t.value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
