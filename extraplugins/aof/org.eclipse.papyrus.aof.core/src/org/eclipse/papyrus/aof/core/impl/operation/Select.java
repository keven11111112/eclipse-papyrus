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
package org.eclipse.papyrus.aof.core.impl.operation;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class Select<A> extends Operation<A> {

	private IBox<IPair<A, Boolean>> a;

	public Select(IBox<IPair<A, Boolean>> a) {
		this.a = a;
		a.addObserver(new ObserverA());
	}

	public boolean isOptional() {
		return true;
	}

	public boolean isSingleton() {
		return a.isSingleton();
	}

	public boolean isOrdered() {
		return a.isOrdered();
	}

	public boolean isUnique() {
		return a.isUnique();
	}

	protected class ObserverA extends DefaultObserver<IPair<A, Boolean>> {

		public void added(int i, IPair<A, Boolean> e) {
			if (e.getSecond()) {
				getResult().add(countTrue(i), e.getFirst());
			}
		}

		public void removed(int i, IPair<A, Boolean> e) {
			if (e.getSecond()) {
				getResult().removeAt(countTrue(i));
			}
		}

		public void replaced(int i, IPair<A, Boolean> p, IPair<A, Boolean> e) {
			if (p.getSecond() && e.getSecond()) {
				getResult().replace(countTrue(i), e.getFirst());
			}
			else if (!p.getSecond() && e.getSecond()) {
				getResult().add(countTrue(i), e.getFirst());
			}
			else if (p.getSecond() && !e.getSecond()) {
				getResult().removeAt(countTrue(i));
			}
		}

		private int countTrue(int untilIndex) {
			int count = 0;
			for (int i = 0; i < untilIndex; i++) {
				if (a.get(i).getSecond()) {
					count++;
				}
			}
			return count;
		}
	}
}