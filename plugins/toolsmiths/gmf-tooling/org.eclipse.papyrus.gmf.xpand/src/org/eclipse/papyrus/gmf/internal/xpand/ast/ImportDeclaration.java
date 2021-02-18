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

import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.papyrus.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.papyrus.gmf.internal.xpand.ocl.TypeHelper;

/**
 * @author Sven Efftinge
 */
public class ImportDeclaration extends SyntaxElement {

    private final String importString;

    public ImportDeclaration(final int start, final int end, final int line, final PathNameCS importString) {
        super(start, end, line);
        this.importString = TypeHelper.toString(importString);
    }

    public String getImportString() {
        return importString;
    }
}
