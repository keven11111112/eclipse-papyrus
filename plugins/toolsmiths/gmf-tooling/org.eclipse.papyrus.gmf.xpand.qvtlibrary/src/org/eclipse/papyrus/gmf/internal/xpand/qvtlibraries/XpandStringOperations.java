/******************************************************************************
 * Copyright (c) 2008, 2020 Borland Software Corporation, CEA LIST, Artal and others
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

import java.util.Arrays;
import java.util.List;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.ocl.util.CollectionUtil;

public class XpandStringOperations {

	@Operation(contextual = true, kind = Kind.HELPER)
	public static String xpandToFirstLower(String self) {
		if ((self == null) || (self.length() == 0)) {
			return self;
		}
		char[] arr = self.toCharArray();
		arr[0] = Character.toLowerCase(arr[0]);
		return new String(arr);
	}

	@Operation(contextual = true, kind = Kind.HELPER)
	public static List<String> xpandToCharList(String self) {
		List<String> rv = CollectionUtil.<String> createNewSequence();
		for (int i = 0; i < self.length(); i++) {
			rv.add(self.substring(i, i + 1));
		}
		return rv;
	}

	/*
	 * Not in use in current templates, however kept for migration simplicity
	 */
	@Operation(contextual = true, kind = Kind.HELPER)
	public static String xpandSubstring(String self, Integer beginIndex) {
		return self.substring(beginIndex);
	}

	@Operation(contextual = true, kind = Kind.HELPER)
	public static String xpandReplaceAll(String self, String regex, String replacement) {
		return self.replaceAll(regex, replacement);
	}

	@Operation(contextual = true, kind = Kind.HELPER)
	public static String xpandReplaceFirst(String self, String regex, String replacement) {
		return self.replaceFirst(regex, replacement);
	}

	@Operation(contextual = true, kind = Kind.HELPER)
	public static List<String> xpandSplit(String self, String regex) {
		return CollectionUtil.createNewSequence(Arrays.asList(self.split(regex)));
	}

	@Operation(contextual = true, kind = Kind.HELPER)
	public static Boolean xpandMatches(String self, String regex) {
		return self.matches(regex);
	}
}
