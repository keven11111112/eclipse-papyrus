/*******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal
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

import java.util.List;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.ocl.util.CollectionUtil;

public class XpandIntegerOperations {

	@Operation(contextual = true, kind = Kind.HELPER)
	public static List<Integer> xpandUpTo(Integer self, Integer parameter) {
		List<Integer> result = CollectionUtil.<Integer> createNewSequence();
		for (int l1 = self.intValue(), l2 = parameter.intValue(); l1 <= l2; l1++) {
			result.add(new Integer(l1));
		}
		return result;
	}

}
