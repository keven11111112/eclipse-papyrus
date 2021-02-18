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
package org.eclipse.papyrus.gmf.internal.xpand.model;

import org.eclipse.papyrus.gmf.internal.xpand.StreamsHolder;
import org.eclipse.papyrus.gmf.internal.xpand.expression.ast.SyntaxElement;

/**
 * @author Sven Efftinge
 */
public interface Output {
    public void write(String text);

    public void enterStatement(SyntaxElement stmt);

    public void exitStatement(SyntaxElement stmt);

    public void openFile(String path, String outletName);

    public void closeFile();

    public StreamsHolder getNamedStreams();
}
