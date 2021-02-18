/************************************************************************************************************************************************************
 * Copyright (c) 2006, 2020 Eclipse.org, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors: 
 *     Sven Efftinge - Initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
***********************************************************************************************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.parser;

public class Keyw {
	private final static String SSS = "IMPORT EXTENSION	AROUND ENDAROUND DEFINE ENDDEFINE ERROR EXPAND FOR SEPARATOR AS ITERATOR FOREACH ENDFOREACH	FILE ENDFILE IF ELSEIF ELSE ENDIF LET ENDLET PROTECT CSTART CEND ID DISABLE ENDPROTECT";

	public static void main(String[] args) {
		for (String s : SSS.split("\\s")) {
			System.out.println("\t\t| " + toSeparateChars(s));
			System.out.println("\t\t/.$BeginAction");
			System.out.println("\t\t\t$setResult($_" + s + ");");
			System.out.println("\t\t$EndAction./");
			System.out.println();
		}
	}

	private static String toSeparateChars(String s) {
		StringBuilder sb = new StringBuilder(s.length() * 2 + 1);
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			sb.append(' ');
		}
		sb.setLength(sb.length()-1);
		return sb.toString();
	}
}
