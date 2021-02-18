/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Borland - initial API and implementation
 *    AurÃ©lien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *******************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand;

import org.eclipse.papyrus.gmf.internal.xpand.ast.TextStatement;
import org.eclipse.papyrus.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.papyrus.gmf.internal.xpand.model.Output;

public abstract class AbstractOutput implements Output {
	private boolean deleteLine = false;

	public void enterStatement(SyntaxElement stmt) {
		if (stmt instanceof TextStatement) {
			deleteLine = ((TextStatement) stmt).isDeleteLine();
		}
	}

	public void exitStatement(SyntaxElement stmt) {
		deleteLine = false;
	}

	public void write(String text) {
		if (deleteLine) {
			int i = 0;
			while (i < text.length()) {
				char charAt = text.charAt(i);
				if (Character.isWhitespace(charAt)) {
					if ((charAt == '\r' || charAt == '\n') && (i+1 < text.length())) {
						char nextToLF = text.charAt(++i);
						if (nextToLF != charAt && (nextToLF == '\n' || nextToLF == '\r')) {
							i++;
						}
						break;
					}
				}
				i++;
			}
			doAppend(text.substring(i));
			deleteLine = false;
		} else {
			doAppend(text);
		}
	}

	protected abstract void doAppend(String text);
}
