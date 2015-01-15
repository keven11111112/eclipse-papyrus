/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.impl.utils;

import java.util.ArrayList;
import java.util.List;

public class Cache {

	private List<Object> sources = new ArrayList<Object>();
	private List<Object> links = new ArrayList<Object>();
	private List<Object> targets = new ArrayList<Object>();

	public Object getTarget(Object source, Object link) {
		for (int i = 0; i < sources.size(); i++) {
			if ((sources.get(i) == source) && (links.get(i) == link)) {
				return targets.get(i);
			}
		}
		return null;
	}

	public Object getSource(Object target) {
		for (int i = 0; i < sources.size(); i++) {
			if (this.targets.get(i) == target) {
				return this.sources.get(i);
			}
		}
		return null;
	}

	public void addLink(Object source, Object link, Object target) {
		sources.add(source);
		links.add(link);
		targets.add(target);
	}

	public void removeSource(Object source) {
		int i = this.sources.indexOf(source);
		while (i != -1) {
			sources.remove(i);
			links.remove(i);
			targets.remove(i);
			i = sources.indexOf(source);
		}
	}

}
