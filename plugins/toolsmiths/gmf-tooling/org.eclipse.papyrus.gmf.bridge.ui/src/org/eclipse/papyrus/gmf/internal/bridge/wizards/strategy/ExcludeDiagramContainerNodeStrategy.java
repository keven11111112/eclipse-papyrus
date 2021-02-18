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
 * @author artem
 */
public class ExcludeDiagramContainerNodeStrategy implements Strategy<EClass> {

	private final boolean myWithSubclasses;

	public ExcludeDiagramContainerNodeStrategy() {
		this(true);
	}

	public ExcludeDiagramContainerNodeStrategy(boolean withSubclasses) {
		myWithSubclasses = withSubclasses;
	}

	public String getID() {
		return "excludeDiagramContainer";
	}

	public void filter(Collection<EClass> soFar, Hierarchy hierarchy) {
		if (myWithSubclasses && hierarchy.getDiagramContainer() != null) {
			for (Iterator<EClass> it = soFar.iterator(); it.hasNext();) {
				EClass next = it.next();
				if (hierarchy.getDiagramContainer().isSuperTypeOf(next)) {
					it.remove();
				}
			}
		} else {
			soFar.remove(hierarchy.getDiagramContainer());
		}
	}
}
