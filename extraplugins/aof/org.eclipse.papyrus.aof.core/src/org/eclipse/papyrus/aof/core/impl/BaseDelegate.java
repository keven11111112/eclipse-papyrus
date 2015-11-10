/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.impl;

import static org.eclipse.papyrus.aof.core.impl.utils.Equality.optionalEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IObservable;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IReadable;
import org.eclipse.papyrus.aof.core.IWritable;
import org.eclipse.papyrus.aof.core.utils.ObserverTracker;
import org.eclipse.papyrus.aof.core.utils.Observers;

public abstract class BaseDelegate<E> implements IReadable<E>, IWritable<E>, IObservable<E> {

	// BaseDelegate

	private IBox<E> delegator; // delegator should be used when invoking methods of interface IWritable

	public IBox<E> getDelegator() {
		return delegator;
	}

	public void setDelegator(IBox<E> delegator) {
		this.delegator = delegator;
	}

	// equality in any order
	public boolean similarTo(BaseDelegate<?> that) {
		if (this.length() == that.length()) {
			for (E element : this) {
				if (count(this, element) != count(that, element)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean sameAs(BaseDelegate<?> that) {
		if (this.length() != that.length()) {
			return false;
		} else {
			for (int i = 0; i < length(); i++) {
				if (!optionalEquals(get(i), that.get(i))) {
					return false;
				}
			}
			return true;
		}
	}

	private int count(Iterable<?> iterable, Object element) {
		int result = 0;
		for (Object e : iterable) {
			if (e == null) {
				if (element == null) {
					result++;
				}
			} else if (e.equals(element)) {
				result++;
			}
		}
		return result;
	}

	// IReadable

	@Override
	public int indexOf(E element) {
		for (int i = 0; i < length(); i++) {
			E e = get(i);
			if (e == null) {
				if (element == null) {
					return i;
				}
			} else if (e.equals(element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E element) {
		return indexOf(element) != -1;
	}

	// IWritable
	// Note for Javadoc: no exception thrown by methods of IWritable (done by the delegator)

	@Override
	public void add(E element) {
		delegator.add(length(), element);
	}

	@Override
	public void assign(Iterable<? extends E> iterable) {
		delegator.clear(); // note that a null iterable represents an empty box
		for (E element : iterable) {
			// note that assign cannot be defined in
			if (!delegator.isUnique() || !contains(element)) {
				delegator.add(element);
			}
		}
	}

	@Override
	public void assign(E... elements) {
		assign(Arrays.asList(elements));
	}

	@Override
	public void remove(E element) {
		int index = indexOf(element);
		if (index >= 0) {
			delegator.removeAt(index);
		}
	}

	@Override
	public void clear() {
		int count = length();
		for (int i = count - 1; i >= 0; i--) {
			delegator.removeAt(i);
			// don't use 'while (size() > 0) remove...' because size()=1 for a One
		}
	}

	// public void set(int index, E element) {
	//// if (index == length()) {
	//// delegator.add(element);
	//// }
	//// else {
	// delegator.set(index, element);
	//// }
	// }

	// IObservable

	private List<IObserver<? super E>> observers = new ArrayList<IObserver<? super E>>();

	@Override
	public void addObserver(IObserver<? super E> observer) {
		if (observer == null) {
			throw new IllegalArgumentException("An observer cannot be null ");
		}
		observer = Observers.intercept(observer);
		if (!observers.contains(observer)) {
			observers.add(observer);
			ObserverTracker.observerAdded(this, observer);
		}
	}

	@Override
	public void removeObserver(IObserver<?> observer) {
		if (observer != null) {
			observer = Observers.intercept(observer);
			if (observers.remove(observer)) {
				ObserverTracker.observerRemoved(this, observer);
			}
		}
	}

	@Override
	public Iterable<IObserver<? super E>> getObservers() {
		return Collections.unmodifiableList(observers);
	}

	/**
	 * Obtains an unique copy of the current observers list for iteration,
	 * to notify them without concurrent modification (as observers may
	 * add/remove observers in these call-backs).
	 * 
	 * @return an unique copy of the current observers
	 */
	public Iterable<IObserver<? super E>> getObserversForNotification() {
		// Observers can add/remove observers in this call-back
		return new ArrayList<IObserver<? super E>>(((java.util.Collection<IObserver<? super E>>)getObservers()));
	}

	@Override
	public boolean isObserved() {
		return !observers.isEmpty();
	}

	protected void fireAdded(int index, E element) {
		for (IObserver<? super E> observer : getObserversForNotification()) {
			if (!observer.isDisabled()) {
				observer.added(index, element);
			}
		}
	}

	protected void fireRemoved(int index, E element) {
		for (IObserver<? super E> observer : getObserversForNotification()) {
			if (!observer.isDisabled()) {
				observer.removed(index, element);
			}
		}
	}

	protected void fireReplaced(int index, E newElement, E oldElement) {
		for (IObserver<? super E> observer : getObserversForNotification()) {
			if (!observer.isDisabled()) {
				observer.replaced(index, newElement, oldElement);
			}
		}
	}

	protected void fireMoved(int newIndex, int oldIndex, E element) {
		for (IObserver<? super E> observer : getObserversForNotification()) {
			if (!observer.isDisabled()) {
				observer.moved(newIndex, oldIndex, element);
			}
		}
	}

	//
	// Nested types
	//

	/**
	 * Protocol for a specific delegator for {@link IOne one}s that provides the
	 * default value.
	 * 
	 * @see BaseDelegate.OneDelegate
	 */
	public interface IOneDelegate<E> {
		/**
		 * Obtains the {@link IOne one}'s default value.
		 * 
		 * @return the default element, or {@code null} if none
		 * 
		 * @see IOne#getDefaultElement()
		 */
		E getDefaultElement();

		/**
		 * <p>
		 * Clears the {@link IOne one} to a new default value.
		 * </p>
		 * <p>
		 * This is an <b>optional operation</b>.
		 * </p>
		 * 
		 * @param newDefaultElement
		 * 
		 * @throws UnsupportedOperationException
		 *             if the setting of a default element is not supported
		 * 
		 * @see IOne#clear(Object)
		 */
		void clear(E newDefaultElement);

		/**
		 * Queries whether the {@link IOne one} is defaulted.
		 * 
		 * @return whether I am in the default (unset) state
		 * 
		 * @see IOne#isDefault()
		 */
		boolean isDefault();
	}

	/**
	 * A specific delegator for {@link IOne one}s that provides the default
	 * value.
	 */
	public static abstract class OneDelegate<E> extends BaseDelegate<E>implements IOneDelegate<E> {
		public OneDelegate() {
			super();
		}
		
		@Override
		public E getDefaultElement() {
			return null;
		}

		@Override
		public void clear(E newDefaultElement) {
			throw new UnsupportedOperationException("clear(E)");
		}
		
		@Override
		public int length() {
			return 1; // Ones always have length 1, even if default- or null-valued
		}
		
		@Override
		public void assign(Iterable<? extends E> iterable) {
			if ((iterable instanceof IOne<?>) && ((IOne<?>)iterable).isDefault()) {
				clear();
			} else {
				super.assign(iterable);
			}
		}

		@Override
		public E get(int index) {
			return read();
		}

		protected abstract E read();

		@Override
		public Iterator<E> iterator() {
			return Collections.singletonList(get(0)).iterator();
		}

		@Override
		public void add(int index, E element) {
			// Only the zero position of a 'one' has significance
			if (index == 0) {
				// All 'one' assignments are semantically set operations
				set(index, element);
			}
		}

		@Override
		public void removeAt(int index) {
			// Only the zero position of a 'one' has significance
			if ((index == 0) && !isDefault()) {
				// All 'one' assignments are semantically set operations
				set(0, getDefaultElement());
			}
		}

		@Override
		public void set(int index, E element) {
			// Only the zero position of a 'one' has significance
			if (index == 0) {
				E oldElement = read();

				if (!Objects.equals(oldElement, element)) {
					write(element);
					fireReplaced(index, element, oldElement);
				}
			}
		}

		protected abstract void write(E element);

		@Override
		public void move(int newIndex, int oldIndex) {
			if (newIndex != 0) {
				// Only the zero position exists in a 'one'
				throw new IndexOutOfBoundsException(String.valueOf(newIndex));
			}
			if (oldIndex != 0) {
				// Only the zero position exists in a 'one'
				throw new IndexOutOfBoundsException(String.valueOf(oldIndex));
			}

			// No-op
		}

		@Override
		public boolean isDefault() {
			return Objects.equals(read(), getDefaultElement());
		}

	}
	
}
