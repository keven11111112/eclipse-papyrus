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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.papyrus.aof.core.ICollection;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IOne;

/**
 * A delegate that uses a Java list to implements most of the box operations
 *
 * @author obeaudoux
 *
 * @param <E>
 */
public class ListDelegate<E> extends BaseDelegate<E> {

	private final List<E> list;

	public ListDelegate() {
		this(new ArrayList<E>());
	}

	ListDelegate(List<E> list) {
		super();

		this.list = list;
	}

	// Iterable

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	// Readable

	@Override
	public E get(int index) {
		return list.get(index);
	}

	@Override
	public int length() {
		return list.size();
	}

	// Writable

	@Override
	public void add(int index, E element) {
		list.add(index, element);
		fireAdded(index, element);
	}

	@Override
	public void removeAt(int index) {
		E element = list.remove(index);
		fireRemoved(index, element);
	}

	@Override
	public void set(int index, E element) {
		E oldElement = list.set(index, element);
		fireReplaced(index, element, oldElement);
	}

	@Override
	public void move(int newIndex, int oldIndex) {
		E element = list.get(oldIndex);
		if (newIndex != oldIndex) {
			list.remove(oldIndex);
			list.add(newIndex, element);
		}
		fireMoved(newIndex, oldIndex, element);
	}

	//
	// Nested types
	//

	/**
	 * A list delegate specialized for implementation of {@linkplain IOne one}
	 * boxes.
	 */
	public static class One<E> extends ListDelegate<E> implements BaseDelegate.IOneDelegate<E> {
		private E defaultElement;

		public One() {
			super(new ArrayList<E>(1));
		}

		@Override
		public E getDefaultElement() {
			return defaultElement;
		}

		@Override
		public void clear(E newDefaultElement) {
			this.defaultElement = newDefaultElement;
			clear();
		}

		@Override
		public void clear() {
			if (length() == 0) {
				add(getDefaultElement());
			} else {
				set(0, getDefaultElement());
			}
		}
	}

	/**
	 * A list delegate implementing an immutable box. The boxes contents cannot
	 * ever change.
	 */
	public static class Immutable<E> extends ListDelegate<E> {
		public Immutable() {
			this(Collections.<E> emptyList());
		}

		public Immutable(E singleton) {
			this(Arrays.asList(singleton));
		}

		public Immutable(E first, E second) {
			this(Arrays.asList(first, second));
		}

		public Immutable(E first, E second, E third) {
			this(Arrays.asList(first, second, third));
		}

		@SafeVarargs
		public Immutable(E first, E second, E third, E fourth, E... rest) {
			this(asList(first, second, third, fourth, rest));
		}

		public Immutable(Iterable<? extends E> elements) {
			super(Collections.unmodifiableList(asList(elements)));
		}

		@Override
		public final void add(E element) {
			throw new UnsupportedOperationException("add"); //$NON-NLS-1$
		}

		@Override
		public final void add(int index, E element) {
			throw new UnsupportedOperationException("add"); //$NON-NLS-1$
		}

		@Override
		public final void remove(E element) {
			throw new UnsupportedOperationException("remove"); //$NON-NLS-1$
		}

		@Override
		public final void removeAt(int index) {
			throw new UnsupportedOperationException("removeAt"); //$NON-NLS-1$
		}

		@Override
		public final void set(int index, E element) {
			throw new UnsupportedOperationException("set"); //$NON-NLS-1$
		}

		@Override
		public final void move(int newIndex, int oldIndex) {
			throw new UnsupportedOperationException("move"); //$NON-NLS-1$
		}

		@Override
		public final void clear() {
			throw new UnsupportedOperationException("clear"); //$NON-NLS-1$
		}

		@Override
		@SafeVarargs
		public final void assign(E... elements) {
			throw new UnsupportedOperationException("assign"); //$NON-NLS-1$
		}

		@Override
		public void assign(Iterable<E> iterable) {
			throw new UnsupportedOperationException("assign"); //$NON-NLS-1$
		}

		@Override
		public void addObserver(IObserver<? super E> observer) {
			// Immutable boxes cannot change, so there's no point
		}

		@Override
		public void removeObserver(IObserver<?> observer) {
			// Immutable boxes cannot change, so there's no point
		}

		@SafeVarargs
		private static <E> List<E> asList(E first, E second, E third, E fourth, E... rest) {
			List<E> result = new ArrayList<E>(4 + rest.length);

			result.add(first);
			result.add(second);
			result.add(third);
			result.add(fourth);
			result.addAll(Arrays.asList(rest));

			return result;
		}

		private static <E> List<E> asList(Iterable<E> elements) {
			List<E> result;
			if (elements instanceof List<?>) {
				result = (List<E>) elements;
			} else {
				result = new ArrayList<E>();

				for (E next : elements) {
					result.add(next);
				}
			}
			
			return result;
		}

		//
		// Nested types
		//

		/**
		 * A list delegate specialized for implementation of immutable
		 * {@linkplain IOne one} boxes.
		 */
		public static final class One<E> extends Immutable<E> implements BaseDelegate.IOneDelegate<E> {
			private final E defaultElement;
			private final boolean isDefault;

			public One() {
				this(null);
			}

			public One(E defaultElement) {
				super(defaultElement);

				this.defaultElement = defaultElement;
				isDefault = true;
			}

			public One(E defaultElement, E element) {
				super((element == null) ? defaultElement : element);

				this.defaultElement = defaultElement;
				this.isDefault = element == null;
			}

			@Override
			public void clear(E newDefaultElement) {
				throw new UnsupportedOperationException("clear"); //$NON-NLS-1$
			}

			@Override
			public final E getDefaultElement() {
				return defaultElement;
			}
		}

		/**
		 * A list delegate specialized for implementation of immutable unique
		 * {@linkplain ICollection collection} boxes.
		 */
		public static final class Unique<E> extends Immutable<E> {
			public Unique(Iterable<? extends E> elements) {
				super(uniquify(elements));
			}

			static <E> Iterable<E> uniquify(final Iterable<E> iterable) {
				return new Iterable<E>() {
					@Override
					public Iterator<E> iterator() {
						return new Iterator<E>() {
							private final Iterator<E> delegate = iterable.iterator();

							private final Set<E> seen = new java.util.HashSet<E>();
							private boolean prepared;
							private E preparedNext;

							@Override
							public boolean hasNext() {
								if (!prepared) {
									while (delegate.hasNext()) {
										E candidate = delegate.next();
										if (seen.add(candidate)) {
											preparedNext = candidate;
											prepared = true;
											break;
										}
									}
								}

								return prepared;
							}

							@Override
							public E next() {
								if (!hasNext()) {
									throw new NoSuchElementException();
								}

								E result = preparedNext;
								preparedNext = null;
								prepared = false;
								return result;
							}

							@Override
							public void remove() {
								throw new UnsupportedOperationException("remove"); //$NON-NLS-1$
							}
						};
					}
				};
			}
		}
	}

}
