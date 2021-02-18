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
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards.strategy;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;

/**
 * Simple strategy that filters out metaclasses that are not leaves
 * @author artem
 */
public class LeafNodeStrategy implements Strategy<EClass> {

	public String getID() {
		return "leafNode";
	}

	/**
	 * @param soFar - expects <code>List&lt;EClass&gt;</code>
	 */
	public void filter(Collection<EClass> soFar, Hierarchy hierarchy) {
		for (Iterator<EClass> it = soFar.iterator(); it.hasNext();) {
			if (!hierarchy.isLeaf(it.next())) {
				it.remove();
			}
		}
	}
}
