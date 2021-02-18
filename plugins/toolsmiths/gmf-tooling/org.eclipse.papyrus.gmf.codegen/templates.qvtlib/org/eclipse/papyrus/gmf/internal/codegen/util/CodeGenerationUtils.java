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
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.codegen.util;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.papyrus.gmf.internal.common.codegen.Conversions;

public class CodeGenerationUtils {

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String toStringLiteral(String stringValue) {
		return Conversions.toStringLiteral(stringValue);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String escapeXML(String stringValue) {
		return org.eclipse.papyrus.gmf.internal.common.codegen.Conversions.escapeXML(stringValue);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String safeName(String name) {
		return org.eclipse.emf.codegen.util.CodeGenUtil.safeName(name);
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String validJavaIdentifier(String identifier) {
		return org.eclipse.emf.codegen.util.CodeGenUtil.validJavaIdentifier(identifier);
	}

}
