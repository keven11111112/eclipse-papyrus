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
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class Apply<A, B> extends Operation<B> {

	private IBox<A> a;

	private IUnaryFunction<A, B> f;

	public Apply(IBox<A> a, IUnaryFunction<A, B> f) {
		this.a = a;
		this.f = f;
		a.addObserver(new ObserverA());
	}

	public boolean isOptional() {
		return a.isOptional();
	}

	public boolean isSingleton() {
		return a.isSingleton();
	}

	public boolean isOrdered() {
		return a.isOrdered();
	}

	public boolean isUnique() {
		return false;
	}

	protected class ObserverA extends DefaultObserver<A> {

		public void added(int i, A e) {
			getResult().add(i, f.apply(e));
		}

		public void removed(int i, A e) {
			getResult().removeAt(i);
		}

	}
}
