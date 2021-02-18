/******************************************************************************
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
 *    Dmitry Stadnik - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.resolver;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author dstadnik
 */
public class Vocabulary {

	private Set<String> words = new HashSet<String>();

	public void add(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (words[i] != null) {
				this.words.add(words[i].toLowerCase());
			}
		}
	}

	public void add(String word) {
		if (word != null) {
			words.add(word.toLowerCase());
		}
	}

	public boolean containsWords(String s) {
		s = s.toLowerCase();
		for (Iterator<String> it = words.iterator(); it.hasNext();) {
			String word = it.next();
			if (s.indexOf(word) >= 0) {
				return true;
			}
		}
		return false;
	}
}
