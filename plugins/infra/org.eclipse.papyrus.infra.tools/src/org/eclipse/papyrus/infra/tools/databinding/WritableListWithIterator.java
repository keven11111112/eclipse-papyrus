/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.tools.databinding;

import static org.eclipse.core.databinding.observable.Diffs.createListDiff;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.core.databinding.observable.list.WritableList;

/**
 * A specialization of the core Databindings {@link WritableList} providing
 * iterators that support modification.
 */
public class WritableListWithIterator<E> extends WritableList<E> {

	public WritableListWithIterator() {
		super();
	}

	public WritableListWithIterator(Realm realm) {
		super(realm);
	}

	public WritableListWithIterator(List<E> toWrap, Object elementType) {
		super(toWrap, elementType);
	}

	public WritableListWithIterator(Collection<E> collection, Object elementType) {
		super(collection, elementType);
	}

	public WritableListWithIterator(Realm realm, List<E> toWrap, Object elementType) {
		super(realm, toWrap, elementType);
	}

	public WritableListWithIterator(Realm realm, Collection<E> collection, Object elementType) {
		super(realm, collection, elementType);
	}

	@Override
	public Iterator<E> iterator() {
		getterCalled();
		return new Iter();
	}

	@Override
	public ListIterator<E> listIterator() {
		getterCalled();
		return new ListIter(0);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		getterCalled();
		return new ListIter(index);
	}

	static <E> ListDiffEntry<E> added(E element, int position) {
		return Diffs.createListDiffEntry(position, true, element);
	}

	static <E> ListDiffEntry<E> removed(E element, int position) {
		return Diffs.createListDiffEntry(position, false, element);
	}

	//
	// Nested types
	//

	private class Iter implements Iterator<E> {

		final ListIterator<E> delegate;
		int lastReturned = -1;

		Iter() {
			this(0);
		}

		Iter(int index) {
			super();

			this.delegate = wrappedList.listIterator(index);
		}

		@Override
		public boolean hasNext() {
			return delegate.hasNext();
		}

		@Override
		public E next() {
			E result = delegate.next();
			lastReturned = delegate.previousIndex();
			return result;
		}

		E lastReturned() {
			return ((lastReturned >= 0) && (lastReturned < size()))
					? get(lastReturned)
					: null;
		}

		@Override
		public void remove() {
			E removed = lastReturned();

			delegate.remove();

			// We only get this far if remove succeeded
			fireListChange(createListDiff(removed(removed, lastReturned)));
		}
	}

	private class ListIter extends Iter implements ListIterator<E> {

		ListIter(int index) {
			super(index);
		}

		@Override
		public boolean hasPrevious() {
			return delegate.hasPrevious();
		}

		@Override
		public int nextIndex() {
			return delegate.nextIndex();
		}

		@Override
		public int previousIndex() {
			return delegate.previousIndex();
		}

		@Override
		public E previous() {
			E result = delegate.previous();
			lastReturned = delegate.nextIndex();
			return result;
		}

		@Override
		public void set(E e) {
			E removed = lastReturned();

			delegate.set(e);

			// We only get this far if remove succeeded
			fireListChange(createListDiff(removed(removed, lastReturned), added(e, lastReturned)));
		}

		@Override
		public void add(E e) {
			delegate.add(e);

			// We only get this far if add succeeded
			fireListChange(createListDiff(added(e, previousIndex())));
		}

	}
}
