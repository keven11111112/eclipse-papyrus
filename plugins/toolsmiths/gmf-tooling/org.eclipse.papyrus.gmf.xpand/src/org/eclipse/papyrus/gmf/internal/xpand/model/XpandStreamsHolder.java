/******************************************************************************
 * Copyright (c) 2008, 2020 Borland Software Corporation, CEA LIST, Artal
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors: 
 *     Boris Blajer (Borland)
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.gmf.internal.xpand.StreamsHolder;

/**
 * Holder for named streams. 
 */
public class XpandStreamsHolder implements StreamsHolder {
	private HashMap<String, StringBuilder> myStreams;
	private HashSet<String> myStreamsAccessed;

	public String getStreamContents(String slotName) {
		if (myStreams == null) {
			throw new EvaluationException("Undefined stream " + slotName);
		}
		StringBuilder result = myStreams.get(slotName);
		if (result == null) {
			throw new EvaluationException("Undefined stream " + slotName);
		}
		setAccessed(slotName);
		if (result.length() == 0) {
			return null;
		}
		return result.toString();
	}

	public List<String> getSlotNames() {
		if (myStreams == null) {
			return Collections.emptyList();
		}
		//Filter streams that have no content
		ArrayList<String> result = new ArrayList<String>(myStreams.size());
		for (Map.Entry<String, StringBuilder> next : myStreams.entrySet()) {
			if (next.getValue().length() == 0) {
				continue;
			}
			result.add(next.getKey());
		}
		return Collections.unmodifiableList(result);
	}

	public void addNamedStream(String name, StringBuilder stream) {
		if (myStreams == null) {
			myStreams = new HashMap<String, StringBuilder>();
		}
		assert !myStreams.containsKey(name);
		myStreams.put(name, stream);
	}

	private void setAccessed(String slotName) {
		if (myStreamsAccessed == null) {
			myStreamsAccessed = new HashSet<String>();
		}
		myStreamsAccessed.add(slotName);
	}

	public boolean isAccessed(String slotName) {
		return myStreamsAccessed != null && myStreamsAccessed.contains(slotName);
	}
}
