/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.lang;

import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.impl.ListDelegate;
import org.eclipse.papyrus.aof.core.impl.One;

/**
 * A {@link ConstantOne} is a special case of {@link One} box that does not mutate.
 *
 * It is especially useful to turn immutable predicates into seemingly mutable ones that
 * can be composed with actual predicates (see {@link ComposableUnaryFunction#boxOutput()}).
 *
 * @author Frederic Jouault
 *
 * @param <E>
 *            the type of the element this {@link ConstantOne} contains.
 */
public final class ConstantOne<E> extends One<E> {
	@Override
	public void clear(E newDefaultElement) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeAt(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void move(int newIndex, int oldIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void assign(Iterable<E> iterable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void assign(E... elements) {
		throw new UnsupportedOperationException();
	}

	public ConstantOne(E value) {
		setDelegate(new ListDelegate<E>());
		// super.clear(value); // cannot use clear because we make it throw UnsupporedOperationException
		getDelegate().add(0, value);
	}

	// The two following method: addObserver and removeObserver can be commented out without causing any functional problem.
	// However, if we do not remember observers, then we cannot easily trace their users when debugging.
	@Override
	public void addObserver(IObserver<E> observer) {
		// a constant has no change to notify
	}

	@Override
	public void removeObserver(IObserver<E> observer) {
		// a constant has no change to notify
	}

	@Override
	public E getDefaultElement() {
		return get(0);
	}
}