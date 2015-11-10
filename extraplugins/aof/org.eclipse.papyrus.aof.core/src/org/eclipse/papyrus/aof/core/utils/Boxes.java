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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBag;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IOption;
import org.eclipse.papyrus.aof.core.IOrderedSet;
import org.eclipse.papyrus.aof.core.ISequence;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.impl.BaseDelegate;
import org.eclipse.papyrus.aof.core.impl.BaseFactory;
import org.eclipse.papyrus.aof.core.impl.Box;

/**
 * Utility operations for working with {@link IBox}es.
 */
public class Boxes {

	private static final Boxes INSTANCE = new Boxes(AOFFactory.INSTANCE);

	/** An immutable empty option box. */
	public static final IOption<?> EMPTY_OPTION = INSTANCE.immutableOption();

	/** An immutable empty one box. */
	public static final IOne<?> EMPTY_ONE = INSTANCE.immutableOne();

	/** An immutable empty set box. */
	public static final ISet<?> EMPTY_SET = INSTANCE.immutableSet();

	/** An immutable empty ordered set box. */
	public static final IOrderedSet<?> EMPTY_ORDERED_SET = INSTANCE.immutableOrderedSet();

	/** An immutable empty sequence box. */
	public static final ISequence<?> EMPTY_SEQUENCE = INSTANCE.immutableSequence();

	/** An immutable empty bag box. */
	public static final IBag<?> EMPTY_BAG = INSTANCE.immutableBag();

	/** An immutable box of the boolean negative. */
	public static final IOne<Boolean> FALSE = INSTANCE.immutableOne(false);

	/** An immutable box of the boolean positive. */
	public static final IOne<Boolean> TRUE = INSTANCE.immutableOne(true);

	private final IFactory factory;

	/**
	 * Not instantiable by clients.
	 */
	private Boxes(IFactory factory) {
		super();

		this.factory = factory;
	}

	/**
	 * Obtains an utility instance that uses the default {@linkplain AOFFactory
	 * factory} to create boxes.
	 * 
	 * @return the box utility
	 */
	public static Boxes with() {
		return INSTANCE;
	}

	/**
	 * Obtains an utility instance that uses the given {@link factory} to create
	 * boxes.
	 * 
	 * @param factory
	 *            a box factory
	 * 
	 * @return the box utility
	 */
	public static Boxes with(IFactory factory) {
		return (factory == AOFFactory.INSTANCE) ? INSTANCE : new Boxes(factory);
	}

	/** An immutable empty option box. */
	@SuppressWarnings("unchecked")
	public static <E> IOption<E> emptyOption() {
		// Cast is safe because the box is empty and immutable
		return (IOption<E>) EMPTY_OPTION;
	}

	/** An immutable empty one box. */
	@SuppressWarnings("unchecked")
	public static <E> IOne<E> emptyOne() {
		// Cast is safe because the box is empty and immutable
		return (IOne<E>) EMPTY_ONE;
	}

	/** An immutable empty set box. */
	@SuppressWarnings("unchecked")
	public static <E> ISet<E> emptySet() {
		// Cast is safe because the box is empty and immutable
		return (ISet<E>) EMPTY_SET;
	}

	/** An immutable empty ordered set box. */
	@SuppressWarnings("unchecked")
	public static <E> IOrderedSet<E> emptyOrderedSet() {
		// Cast is safe because the box is empty and immutable
		return (IOrderedSet<E>) EMPTY_ORDERED_SET;
	}

	/** An immutable empty sequence box. */
	@SuppressWarnings("unchecked")
	public static <E> ISequence<E> emptySequence() {
		// Cast is safe because the box is empty and immutable
		return (ISequence<E>) EMPTY_SEQUENCE;
	}

	/** An immutable empty bag box. */
	@SuppressWarnings("unchecked")
	public static <E> IBag<E> emptyBag() {
		// Cast is safe because the box is empty and immutable
		return (IBag<E>) EMPTY_BAG;
	}

	/** An immutable option box. */
	public static <E> IOption<E> immutableOption(IBox<? extends E> box) {
		return (IOption<E>) ImmutableBox.create(box.getFactory(), IConstraints.OPTION, box);
	}

	/** An immutable option box. */
	public final <E> IOption<E> immutableOption(Iterable<? extends E> box) {
		return (IOption<E>) ImmutableBox.create(factory, IConstraints.OPTION, box);
	}

	/** An immutable option box. */
	@SafeVarargs
	public final <E> IOption<E> immutableOption(E... elements) {
		return (IOption<E>) ImmutableBox.create(factory, IConstraints.OPTION, elements);
	}

	/** An immutable one box. */
	public static <E> IOne<E> immutableOne(IBox<? extends E> box) {
		return (IOne<E>) ImmutableBox.create(box.getFactory(), IConstraints.ONE, box);
	}

	/** An immutable one box. */
	public final <E> IOne<E> immutableOne(Iterable<? extends E> box) {
		return (IOne<E>) ImmutableBox.create(factory, IConstraints.ONE, box);
	}

	/** An immutable one box. */
	@SafeVarargs
	public final <E> IOne<E> immutableOne(E... elements) {
		return (IOne<E>) ImmutableBox.create(factory, IConstraints.ONE, elements);
	}

	/** An immutable set box. */
	public static <E> ISet<E> immutableSet(IBox<? extends E> box) {
		return (ISet<E>) ImmutableBox.create(box.getFactory(), IConstraints.SET, box);
	}

	/** An immutable set box. */
	public final <E> ISet<E> immutableSet(Iterable<? extends E> box) {
		return (ISet<E>) ImmutableBox.create(factory, IConstraints.SET, box);
	}

	/** An immutable set box. */
	@SafeVarargs
	public final <E> ISet<E> immutableSet(E... elements) {
		return (ISet<E>) ImmutableBox.create(factory, IConstraints.SET, elements);
	}

	/** An immutable ordered set box. */
	public static <E> IOrderedSet<E> immutableOrderedSet(IBox<? extends E> box) {
		return (IOrderedSet<E>) ImmutableBox.create(box.getFactory(), IConstraints.ORDERED_SET, box);
	}

	/** An immutable ordered set box. */
	public final <E> IOrderedSet<E> immutableOrderedSet(Iterable<? extends E> box) {
		return (IOrderedSet<E>) ImmutableBox.create(factory, IConstraints.ORDERED_SET, box);
	}

	/** An immutable ordered set box. */
	@SafeVarargs
	public final <E> IOrderedSet<E> immutableOrderedSet(E... elements) {
		return (IOrderedSet<E>) ImmutableBox.create(factory, IConstraints.ORDERED_SET, elements);
	}

	/** An immutable sequence box. */
	public static <E> ISequence<E> immutableSequence(IBox<? extends E> box) {
		return (ISequence<E>) ImmutableBox.create(box.getFactory(), IConstraints.SEQUENCE, box);
	}

	/** An immutable sequence box. */
	public final <E> ISequence<E> immutableSequence(Iterable<? extends E> box) {
		return (ISequence<E>) ImmutableBox.create(factory, IConstraints.SEQUENCE, box);
	}

	/** An immutable sequence box. */
	@SafeVarargs
	public final <E> ISequence<E> immutableSequence(E... elements) {
		return (ISequence<E>) ImmutableBox.create(factory, IConstraints.SEQUENCE, elements);
	}

	/** An immutable bag box. */
	public static <E> IBag<E> immutableBag(IBox<? extends E> box) {
		return (IBag<E>) ImmutableBox.create(box.getFactory(), IConstraints.BAG, box);
	}

	/** An immutable bag box. */
	public final <E> IBag<E> immutableBag(Iterable<? extends E> box) {
		return (IBag<E>) ImmutableBox.create(factory, IConstraints.BAG, box);
	}

	/** An immutable bag box. */
	@SafeVarargs
	public final <E> IBag<E> immutableBag(E... elements) {
		return (IBag<E>) ImmutableBox.create(factory, IConstraints.BAG, elements);
	}

	/** Create a delegating option box. */
	public final <E> IOption<E> createOption(final BaseDelegate<E> delegate) {
		return (IOption<E>) ((BaseFactory) factory).createBox(IConstraints.OPTION, delegate);
	}

	/** Create a delegating one box. */
	public final <E> IOne<E> createOne(final BaseDelegate<E> delegate) {
		return (IOne<E>) ((BaseFactory) factory).createBox(IConstraints.ONE, delegate);
	}

	/** Create a delegating set box. */
	public final <E> ISet<E> createSet(final BaseDelegate<E> delegate) {
		return (ISet<E>) ((BaseFactory) factory).createBox(IConstraints.SET, delegate);
	}

	/** Create a delegating ordered set box. */
	public final <E> IOrderedSet<E> createOrderedSet(final BaseDelegate<E> delegate) {
		return (IOrderedSet<E>) ((BaseFactory) factory).createBox(IConstraints.ORDERED_SET, delegate);
	}

	/** Create a delegating sequence box. */
	public final <E> ISequence<E> createSequence(final BaseDelegate<E> delegate) {
		return (ISequence<E>) ((BaseFactory) factory).createBox(IConstraints.SEQUENCE, delegate);
	}

	/** Create a delegating bag box. */
	public final <E> IBag<E> createBag(final BaseDelegate<E> delegate) {
		return (IBag<E>) ((BaseFactory) factory).createBox(IConstraints.BAG, delegate);
	}

	/**
	 * <p>
	 * Wrap a box in a pass-through delegate (proxy). This is useful for
	 * providing multiple distinct identities for something that in reality is
	 * just one box. The result implements the same box sub-interface (
	 * {@link IOne}, {@link ISet}, etc.) as the original box.
	 * </p>
	 * <p>
	 * <b>Note</b> that the returned wrapper is not registered with the
	 * {@linkplain Box#factoryObserver factory observer}, if there is one,
	 * because it is simply a proxy that delegates to the real {@code box},
	 * which would have been observed.
	 * </p>
	 */
	public static <E> IBox<E> wrap(final IBox<E> box) {
		final Class<?> class_ = box.getClass();

		// There aren't so many that can simultaneously be implemented
		List<Class<?>> allBoxInterfaces = new ArrayList<>(3);
		// Always have this one and should have it first
		allBoxInterfaces.add(IBox.class);
		for (Class<?> next = class_; next != null; next = next.getSuperclass()) {
			for (Class<?> interface_ : next.getInterfaces()) {
				if (IBox.class.isAssignableFrom(interface_) && !allBoxInterfaces.contains(interface_)) {
					allBoxInterfaces.add(interface_);
				}
			}
		}

		@SuppressWarnings("unchecked")
		IBox<E> result = (IBox<E>) Proxy.newProxyInstance(class_.getClassLoader(),
				allBoxInterfaces.toArray(new Class<?>[allBoxInterfaces.size()]), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (method.getDeclaringClass() == Object.class) {
							return method.invoke(Proxy.getInvocationHandler(proxy), args);
						} else {
							return method.invoke(box, args);
						}
					}
				});

		return result;
	}
}
