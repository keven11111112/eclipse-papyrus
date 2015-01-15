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
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.aof.core.IObserver;

/**
 * A delegate that uses a Java list to implements most of the box operations
 * 
 * @author obeaudoux
 * 
 * @param <A>
 */
public class ListDelegate<A> extends BaseDelegate<A> {

	private List<A> list = new ArrayList<A>();

	// Iterable

	public Iterator<A> iterator() {
		return list.iterator();
	}

	// Readable

	public A get(int index) {
		return list.get(index);
	}

	public int size() {
		return list.size();
	}

	// Writable

	public void add(int index, A element) {
		list.add(index, element);
		for (IObserver<A> observer : getObservers()) {
			observer.added(index, element);
		}
	}

	public void removeAt(int index) {
		A element = list.remove(index);
		for (IObserver<A> observer : getObservers()) {
			observer.removed(index, element);
		}
	}

	public void replace(int index, A element) {
		A previousElement = list.set(index, element);
		for (IObserver<A> observer : getObservers()) {
			observer.replaced(index, previousElement, element);
		}
	}

}
