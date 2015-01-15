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

import java.util.ArrayList;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.utils.Boxes;
import org.eclipse.papyrus.aof.core.impl.utils.Cache;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class Path<A, B> extends Operation<B> {

	private IBox<A> a;

	private IUnaryFunction<A, IBox<B>> f;

	private IBox<B> bDefault;

	public Path(IBox<A> a, A aDefault, IUnaryFunction<A, IBox<B>> f) {
		this.a = a;
		this.f = f;
		this.bDefault = f.apply(aDefault);
		a.addObserver(new ObserverA());
	}

	// cache implementation

	private static Cache cache = new Cache();

	public IBox<B> getResult() {
		IBox<B> b = (IBox<B>) cache.getTarget(a, f);
		if (b == null) {
			b = super.getResult();
			cache.addLink(a, f, b);
		}
		return b;
	}

	// active algorithm

	public boolean isOptional() {
		return a.isOptional() && bDefault.isOptional();
	}

	public boolean isSingleton() {
		return a.isSingleton() && bDefault.isSingleton();
	}

	public boolean isOrdered() {
		return a.isOrdered() && bDefault.isOrdered();
	}

	public boolean isUnique() {
		return a.isSingleton() && bDefault.isUnique();
	}

	private ArrayList<InnerObserverB> innerObservers = new ArrayList<InnerObserverB>();

	protected class InnerObserverB extends DefaultObserver<B> {

		// Position of the element to insert/remove/update
		// Note that index i is retrieved from the index of this inner observer within the registered inner
		// observers. It cannot be given by the observation of a (using a.onEach { case Add(i, e) ... })
		// due to function closure.
		private int k(int j) {
			int i = innerObservers.indexOf(this);
			// j + a.elements.slice(0, i).map(e => f(e).elements.size).sum
			IBox<A> slice = Boxes.slice(a, 0, i);
			IBox<Integer> sizes = Boxes.apply(slice, new IUnaryFunction<A, Integer>() {
				public Integer apply(A a) {
					return f.apply(a).size();
				}
			});
			return j + Boxes.sum(sizes);
		}

		public void added(int j, B e) {
			getResult().add(k(j), e);
		}

		public void removed(int j, B e) {
			getResult().removeAt(k(j));

		}

		public void replaced(int j, B p, B e) {
			getResult().replace(k(j), e);
		}
	}

	protected class ObserverA extends DefaultObserver<A> {

		public void added(int i, A e) {
			InnerObserverB observerB = new InnerObserverB();
			innerObservers.add(observerB);
			IBox<B> boxB = f.apply(e);
			boxB.addObserver(observerB);
		}

		public void removed(int i, A e) {
			InnerObserverB observerB = innerObservers.get(i);
			IBox<B> boxB = f.apply(e);
			innerObservers.remove(i);
			boxB.clear();
			boxB.removeObserver(observerB);
		}

	}
}
