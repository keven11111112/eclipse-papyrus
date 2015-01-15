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

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class BinaryZip<A, B> extends Operation<IPair<A, B>> {

	private IBox<A> a;

	private IBox<B> b;

	public BinaryZip(IBox<A> a, IBox<B> b) {
		this.a = a;
		this.b = b;
		a.addObserver(new ObserverA());
		b.addObserver(new ObserverB());
	}

	public boolean isOptional() {
		return a.isOptional() || b.isOptional();
	}

	public boolean isSingleton() {
		return a.isSingleton() || b.isSingleton();
	}

	public boolean isOrdered() {
		return a.isOrdered() && b.isOrdered();
	}

	public boolean isUnique() {
		return a.isUnique() || b.isUnique();
	}

	private int minSize() {
		return Math.min(a.size(), b.size());
	}

	private IPair<A, B> createPair(int i) {
		return AOFFactory.INSTANCE.createTuple(a.get(i), b.get(i));
	}

	protected class ObserverA extends DefaultObserver<A> {

		public void created(Iterable<A> elements) {
			for (int i = 0; i < minSize(); i++) {
				getResult().append(createPair(i));
			}
		}

		public void added(int i, A e) {
			if (i < b.size())
				if (a.size() <= b.size()) {
					for (int j = i; j < minSize() - 1; j++) {
						getResult().replace(j, createPair(j));
					}
					if (getResult().size() < minSize()) {
						getResult().append(createPair(minSize() - 1));
					}
				}
				else
					for (int j = i; j < minSize(); j++) {
						getResult().replace(j, createPair(j));
					}
		}

		public void removed(int i, A e) {
			if (i < b.size()) {
				for (int j = i; j < minSize(); j++) {
					getResult().replace(j, createPair(j));
				}
				if ((a.size() < b.size()) || (getResult().size() > minSize())) {
					getResult().removeAt(getResult().size() - 1);
				}
			}
		}

		public void replaced(int i, A e) {
			if (i < b.size()) {
				getResult().replace(i, createPair(i));
			}
		}

	}

	protected class ObserverB extends DefaultObserver<B> {

		public void created(Iterable<B> elements) {
		}

		public void added(int i, B e) {
			if (i < a.size())
				if (b.size() <= a.size()) {
					for (int j = i; j < minSize() - 1; j++) {
						getResult().replace(j, createPair(j));
					}
					if (getResult().size() < minSize()) {
						getResult().append(createPair(minSize() - 1));
					}
				}
				else
					for (int j = i; j < minSize(); j++) {
						getResult().replace(j, createPair(j));
					}
		}

		public void removed(int i, B e) {
			if (i < a.size()) {
				for (int j = i; j < minSize(); j++) {
					getResult().replace(j, createPair(j));
				}
				if ((b.size() < a.size()) || (getResult().size() > minSize())) {
					getResult().removeAt(getResult().size() - 1);
				}
			}
		}

		public void replaced(int i, B e) {
			if (i < a.size()) {
				getResult().replace(i, createPair(i));
			}
		}

	}
}