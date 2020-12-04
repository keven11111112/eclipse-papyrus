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
 */
package org.eclipse.papyrus.gmf.internal.xpand.qvtlibraries;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

public class XpandOclAnyOperations {

	@Operation(contextual = true, kind = Kind.HELPER)
	public static Boolean xpandCompareTo(Object self, Object parameter) {
		if (self == null) {
			return parameter == null;
		}
		if (parameter == null) {
			return false;
		}
		if (self instanceof Comparable<?>) {
			@SuppressWarnings("unchecked") Comparable<Object> x = (Comparable<Object>) self;
			return x.compareTo(parameter) == 0;
		}
		return String.valueOf(self).compareTo(String.valueOf(parameter)) == 0;

	}

}
