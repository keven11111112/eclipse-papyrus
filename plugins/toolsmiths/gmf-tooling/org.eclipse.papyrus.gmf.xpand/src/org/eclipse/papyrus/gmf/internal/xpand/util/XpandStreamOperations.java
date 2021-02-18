/******************************************************************************
 * Copyright (c) 2008, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Boris Blajer (Borland) - initial API and implementation
 *     AurÃ©lien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *******************************************************************************/

package org.eclipse.papyrus.gmf.internal.xpand.util;

import java.util.List;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.papyrus.gmf.internal.xpand.StreamsHolder;

/**
 * Stream-related operations that should be accessible from within QVT environment.
 */
public class XpandStreamOperations {
	public StreamsHolder streamsHolder;

	@Operation(contextual = false, kind = Kind.HELPER)
	public List<String> xpandGetStreamNames() {
		List<String> result = CollectionUtil.<String> createNewSequence();
		if (streamsHolder != null) {
			result.addAll(streamsHolder.getSlotNames());
		}
		return result;
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public String xpandGetStreamContents(String streamName) {
		if (streamsHolder == null) {
			return null;
		}
		return streamsHolder.getStreamContents(streamName);
	}
}
