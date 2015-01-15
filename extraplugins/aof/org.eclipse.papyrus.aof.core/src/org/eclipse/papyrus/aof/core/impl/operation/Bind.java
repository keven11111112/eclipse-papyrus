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
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class Bind<A> {

	private IBox<A> a;

	// a ::= b
	// Binds b *TO* a
	public Bind(IBox<A> a, IBox<A> b) {
		this.a = a;
		b.addObserver(new ObserverB());
	}

	protected class ObserverB extends DefaultObserver<A> {

		public void added(int i, A e) {
			a.add(i, e);
		}

		public void removed(int i, A e) {
			a.removeAt(i);
		}

		public void replaced(int i, A p, A e) {
			a.replace(i, e);
		}

	}
}
