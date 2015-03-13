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
package org.eclipse.papyrus.aof.core.impl;

import org.eclipse.papyrus.aof.core.IPair;

public class Pair<A, B> implements IPair<A, B> {

	private A first;

	private B second;

	public Pair(A first, B second) {
		super();
		this.first = first;
		this.second = second;
	}

	public A getFirst() {
		return first;
	}

	public B getSecond() {
		return second;
	}

	// Object

	@Override
	public String toString() {
		return "(" + first.toString() + ", " + second.toString() + ")";
	}
	@Override
	public boolean equals(Object other) {
		if (other instanceof Pair<?, ?>) {
			Pair<A, B> that = (Pair<A, B>) other;
			return this.first.equals(that.first) && this.second.equals(that.second);
		}
		else
			return false;
	}
}
