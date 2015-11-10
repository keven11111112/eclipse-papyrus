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

package org.eclipse.papyrus.aof.core.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.papyrus.aof.core.ConstraintsKind;
import org.eclipse.papyrus.aof.core.IBag;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IOption;
import org.eclipse.papyrus.aof.core.IOrderedSet;
import org.eclipse.papyrus.aof.core.ISequence;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.ISingleton;
import org.eclipse.papyrus.aof.core.impl.BaseDelegate;
import org.eclipse.papyrus.aof.core.impl.Box;
import org.eclipse.papyrus.aof.core.impl.ListDelegate;

/**
 * An immutable box.
 */
class ImmutableBox<E> extends Box<E> {
	private final IConstraints constraints;

	ImmutableBox(IFactory factory, IConstraints constraints, Iterable<? extends E> elements) {
		super(factory);

		this.constraints = constraints;

		ListDelegate.Immutable<E> delegate;
		switch (ConstraintsKind.forConstraints(constraints)) {
		case ONE:
			Iterator<? extends E> iter = elements.iterator();
			E defaultElement = (iter.hasNext()) ? iter.next() : null;
			E element = (iter.hasNext()) ? iter.next() : null;
			delegate = new ListDelegate.Immutable.One<>(defaultElement, element);
			break;
		case SET:
		case ORDERED_SET:
			delegate = new ListDelegate.Immutable.Unique<E>(elements);
			break;
		default:
			delegate = new ListDelegate.Immutable<>(elements);
			break;
		}

		this.setDelegate(delegate);
	}

	@Override
	public IConstraints getConstraints() {
		return constraints;
	}

	@SafeVarargs
	static <E> IBox<E> create(IFactory factory, IConstraints constraints, E... elements) {
		return create(factory, constraints, Arrays.asList(elements));
	}

	static <E> IBox<E> create(final IFactory factory, IConstraints constraints, final Iterable<? extends E> elements) {
		return new ConstraintsSwitch<ImmutableBox<E>>() {
			@Override
			public ImmutableBox<E> caseOne(IConstraints one) {
				return new ImmutableOne<E>(factory, elements);
			}

			@Override
			public ImmutableBox<E> caseOption(IConstraints option) {
				return new ImmutableOption<E>(factory, elements);
			}

			@Override
			public ImmutableBox<E> caseSet(IConstraints set) {
				return new ImmutableSet<E>(factory, elements);
			}

			@Override
			public ImmutableBox<E> caseOrderedSet(IConstraints orderedSet) {
				return new ImmutableOrderedSet<E>(factory, elements);
			}

			@Override
			public ImmutableBox<E> caseSequence(IConstraints sequence) {
				return new ImmutableSequence<E>(factory, elements);
			}

			@Override
			public ImmutableBox<E> caseBag(IConstraints bag) {
				return new ImmutableBag<E>(factory, elements);
			}

			@Override
			public ImmutableBox<E> defaultCase(IConstraints constraints) {
				return new ImmutableBox<E>(factory, constraints, elements);
			}

		}.doSwitch(constraints);
	}

	//
	// IWritable API
	//

	@Override
	public final void add(E element) {
		throw new UnsupportedOperationException("add(E)"); //$NON-NLS-1$
	}

	@Override
	public final void add(int index, E element) {
		throw new UnsupportedOperationException("add(int, E)"); //$NON-NLS-1$
	}

	@Override
	public final void assign(Iterable<? extends E> iterable) {
		throw new UnsupportedOperationException("assign(Iterable<? extends E>)"); //$NON-NLS-1$
	}

	@Override
	@SafeVarargs
	public final void assign(E... elements) {
		throw new UnsupportedOperationException("assign(E...)"); //$NON-NLS-1$
	}

	@Override
	public final void remove(E element) {
		throw new UnsupportedOperationException("remove(E)"); //$NON-NLS-1$
	}

	@Override
	public final void removeAt(int index) {
		throw new UnsupportedOperationException("removeAt(int)"); //$NON-NLS-1$
	}

	@Override
	public final void clear() {
		throw new UnsupportedOperationException("clear()"); //$NON-NLS-1$
	}

	@Override
	public final void set(int index, E element) {
		throw new UnsupportedOperationException("set(int, E)"); //$NON-NLS-1$
	}

	@Override
	public final void move(int newIndex, int oldIndex) {
		throw new UnsupportedOperationException("move(int, int)"); //$NON-NLS-1$
	}

	//
	// IObservable API
	//

	@Override
	public final void addObserver(IObserver<? super E> observer) {
		// There will never be changes to observe
	}

	@Override
	public final void removeObserver(IObserver<?> observer) {
		// There will never be changes to observe
	}

	@Override
	public final Iterable<IObserver<? super E>> getObservers() {
		return Collections.emptyList();
	}

	@Override
	public final boolean isObserved() {
		return false;
	}

	//
	// Nested types
	//

	private static class ImmutableSingleton<E> extends ImmutableBox<E>implements ISingleton<E> {
		ImmutableSingleton(IFactory factory, IConstraints constraints, Iterable<? extends E> elements) {
			super(factory, constraints, elements);
		}

		@Override
		public E get() {
			return get(0);
		}

		@Override
		public void set(E element) {
			throw new UnsupportedOperationException("set"); //$NON-NLS-1$
		}
	}

	private static final class ImmutableOne<E> extends ImmutableSingleton<E>implements IOne<E> {
		ImmutableOne(IFactory factory, Iterable<? extends E> elements) {
			super(factory, IConstraints.ONE, elements);
		}

		@SuppressWarnings("unchecked")
		@Override
		public E getDefaultElement() {
			// This cast is safe by construction
			return ((BaseDelegate.IOneDelegate<E>) getDelegate()).getDefaultElement();
		}

		@Override
		public void clear(E newDefaultElement) {
			throw new UnsupportedOperationException("clear"); //$NON-NLS-1$
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean isDefault() {
			// This cast is safe by construction
			return ((BaseDelegate.IOneDelegate<E>) getDelegate()).isDefault();
		}

	}

	private static final class ImmutableOption<E> extends ImmutableSingleton<E>implements IOption<E> {
		ImmutableOption(IFactory factory, Iterable<? extends E> elements) {
			super(factory, IConstraints.OPTION, elements);
		}
	}

	private static final class ImmutableSet<E> extends ImmutableBox<E>implements ISet<E> {
		ImmutableSet(IFactory factory, Iterable<? extends E> elements) {
			super(factory, IConstraints.SET, elements);
		}
	}

	private static final class ImmutableOrderedSet<E> extends ImmutableBox<E>implements IOrderedSet<E> {
		ImmutableOrderedSet(IFactory factory, Iterable<? extends E> elements) {
			super(factory, IConstraints.ORDERED_SET, elements);
		}
	}

	private static final class ImmutableSequence<E> extends ImmutableBox<E>implements ISequence<E> {
		ImmutableSequence(IFactory factory, Iterable<? extends E> elements) {
			super(factory, IConstraints.SEQUENCE, elements);
		}
	}

	private static final class ImmutableBag<E> extends ImmutableBox<E>implements IBag<E> {
		ImmutableBag(IFactory factory, Iterable<? extends E> elements) {
			super(factory, IConstraints.BAG, elements);
		}
	}
}
