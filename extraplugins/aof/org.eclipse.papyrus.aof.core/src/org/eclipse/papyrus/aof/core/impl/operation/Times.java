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

import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.ISingleton;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class Times<A> extends Operation<A> {

	private ISingleton<A> a;

	private IOne<Integer> n;

	public Times(ISingleton<A> a, IOne<Integer> n) {
		this.a = a;
		this.n = n;
		a.addObserver(new ObserverA());
		n.addObserver(new ObserverN());
	}

	public boolean isOptional() {
		return true;
	}

	public boolean isSingleton() {
		return false;
	}

	public boolean isOrdered() {
		return true;
	}

	public boolean isUnique() {
		return false;
	}

	protected class ObserverA extends DefaultObserver<A> {

		public void created(Iterable<A> eleements) {
			if ((n.size() > 0) && (a.size() > 0)) {
				for (int i = 0; i < n.get(0); i++)
					getResult().append(a.get(0));
			}
		}

		public void added(int zero, A e) {
			if (n.size() > 0) {
				for (int i = 0; i < n.get(0); i++) {
					getResult().append(e);
				}
			}
		}

		public void removed(int zero, A e) {
			getResult().clear();
		}

		public void replaced(int zero, A p, A e) {
			if (n.size() > 0) {
				for (int i = 0; i < n.get(0); i++) {
					getResult().replace(i, e);
				}
			}
		}

	}

	protected class ObserverN extends DefaultObserver<Integer> {

		public void created(Iterable<Integer> elements) {
		}

		public void added(int zero, Integer i) {
			if (a.size() > 0) {
				for (int j = 0; j < i; j++) {
					getResult().append(a.get(0));
				}
			}
		}

		public void replaced(int zero, Integer i1, Integer i2) {
			if (i2 <= 0) {
				getResult().clear();
			}
			else if (a.size() > 0) {
				if (i1 < i2) {
					for (int j = 0; j < i2 - i1; j++) {
						getResult().append(a.get(0));
					}
				}
				else if (i1 > i2) {
					for (int j = 0; j < i1 - i2; j++) {
						getResult().removeAt(getResult().size() - 1);
					}
				}
			}
		}

	}
}
