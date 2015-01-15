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
package org.eclipse.papyrus.aof.core.impl.delegate;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.aof.core.IObservable;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IReadable;
import org.eclipse.papyrus.aof.core.IWritable;

public abstract class BaseDelegate<A> implements IReadable<A>, IWritable<A>, IObservable<A> {

	// Readable

	public int indexOf(A element) {
		for (int i = 0; i < size(); i++) {
			if (get(i).equals(element)) {
				return i;
			}
		}
		return -1;
	}

	// Writable

	public void append(A element) {
		add(size(), element);
	}

	public void remove(A element) {
		removeAt(indexOf(element));
	}

	public void clear() {
		while (size() > 0)
			removeAt(size() - 1);
	}

	public void assign(Iterable<A> iterable) {
		for (A element : iterable) {
			append(element);
		}
	}

	// Observable

	private List<IObserver<A>> observers = new ArrayList<IObserver<A>>();

	public void addObserver(IObserver<A> observer) {
		observers.add(observer);
		observer.created(this);
	}

	public void removeObserver(IObserver<A> observer) {
		observers.remove(observer);
	}

	public List<IObserver<A>> getObservers() {
		return observers;
	}

	// Object

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("(");
		for (int i = 0; i < size(); i++) {
			if (i > 0) {
				buffer.append(", ");
			}
			buffer.append(get(i).toString());
		}
		buffer.append(")");
		return buffer.toString();
	}

}
