/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corp, CEA LIST, Artal
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
 *******************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.qvtlibraries;

import java.util.Collections;
import java.util.Map;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

public class XpandGlobalVars {

	public Map<String, Object> globalVariables = Collections.emptyMap();

	@Operation(contextual = false, kind = Kind.HELPER)
	public String xpandGetStringGlobalVar(String varName) {
		if (globalVariables.containsKey(varName)) {
			Object varValue = globalVariables.get(varName);
			if (varValue instanceof String) {
				return (String) varValue;
			}
			throw new RuntimeException("Incorrect global variable value - string should present instead: " + varValue);
		}
		return null;
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public Object xpandGetObjectGlobalVar(String varName) {
		if (globalVariables.containsKey(varName)) {
			return globalVariables.get(varName);
		}
		return null;
	}

}
