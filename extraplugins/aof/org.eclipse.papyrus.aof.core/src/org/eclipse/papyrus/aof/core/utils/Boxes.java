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

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBag;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IOption;
import org.eclipse.papyrus.aof.core.IOrderedSet;
import org.eclipse.papyrus.aof.core.ISequence;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.impl.BaseDelegate;
import org.eclipse.papyrus.aof.core.impl.BaseFactory;

/**
 * Static utility operations for working with {@link IBox}es.
 */
public class Boxes {

	/** An immutable empty option box. */
	public static final IOption<?> EMPTY_OPTION = (IOption<?>) ImmutableBox.create(IConstraints.OPTION);

	/** An immutable empty one box. */
	public static final IOne<?> EMPTY_ONE = (IOne<?>) ImmutableBox.create(IConstraints.ONE);

	/** An immutable empty set box. */
	public static final ISet<?> EMPTY_SET = (ISet<?>) ImmutableBox.create(IConstraints.SET);

	/** An immutable empty ordered set box. */
	public static final IOrderedSet<?> EMPTY_ORDERED_SET = (IOrderedSet<?>) ImmutableBox
			.create(IConstraints.ORDERED_SET);

	/** An immutable empty sequence box. */
	public static final ISequence<?> EMPTY_SEQUENCE = (ISequence<?>) ImmutableBox.create(IConstraints.SEQUENCE);

	/** An immutable empty bag box. */
	public static final IBag<?> EMPTY_BAG = (IBag<?>) ImmutableBox.create(IConstraints.BAG);

	/**
	 * Not instantiable by clients.
	 */
	private Boxes() {
		super();
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
	public static <E> IOption<E> immutableOption(Iterable<? extends E> box) {
		return (IOption<E>) ImmutableBox.create(IConstraints.OPTION, box);
	}

	/** An immutable option box. */
	@SafeVarargs
	public static <E> IOption<E> immutableOption(E... elements) {
		return (IOption<E>) ImmutableBox.create(IConstraints.OPTION, elements);
	}

	/** An immutable one box. */
	public static <E> IOne<E> immutableOne(Iterable<? extends E> box) {
		return (IOne<E>) ImmutableBox.create(IConstraints.ONE, box);
	}

	/** An immutable one box. */
	@SafeVarargs
	public static <E> IOne<E> immutableOne(E... elements) {
		return (IOne<E>) ImmutableBox.create(IConstraints.ONE, elements);
	}

	/** An immutable set box. */
	public static <E> ISet<E> immutableSet(Iterable<? extends E> box) {
		return (ISet<E>) ImmutableBox.create(IConstraints.SET, box);
	}

	/** An immutable set box. */
	@SafeVarargs
	public static <E> ISet<E> immutableSet(E... elements) {
		return (ISet<E>) ImmutableBox.create(IConstraints.SET, elements);
	}

	/** An immutable ordered set box. */
	public static <E> IOrderedSet<E> immutableOrderedSet(Iterable<? extends E> box) {
		return (IOrderedSet<E>) ImmutableBox.create(IConstraints.ORDERED_SET, box);
	}

	/** An immutable ordered set box. */
	@SafeVarargs
	public static <E> IOrderedSet<E> immutableOrderedSet(E... elements) {
		return (IOrderedSet<E>) ImmutableBox.create(IConstraints.ORDERED_SET, elements);
	}

	/** An immutable sequence box. */
	public static <E> ISequence<E> immutableSequence(Iterable<? extends E> box) {
		return (ISequence<E>) ImmutableBox.create(IConstraints.SEQUENCE, box);
	}

	/** An immutable sequence box. */
	@SafeVarargs
	public static <E> ISequence<E> immutableSequence(E... elements) {
		return (ISequence<E>) ImmutableBox.create(IConstraints.SEQUENCE, elements);
	}

	/** An immutable bag box. */
	public static <E> IBag<E> immutableBag(Iterable<? extends E> box) {
		return (IBag<E>) ImmutableBox.create(IConstraints.BAG, box);
	}

	/** An immutable bag box. */
	@SafeVarargs
	public static <E> IBag<E> immutableBag(E... elements) {
		return (IBag<E>) ImmutableBox.create(IConstraints.BAG, elements);
	}

	/** Create a delegating option box. */
	public static <E> IOption<E> createOption(final BaseDelegate<E> delegate) {
		return (IOption<E>) ((BaseFactory) AOFFactory.INSTANCE).createBox(IConstraints.OPTION, delegate);
	}

	/** Create a delegating one box. */
	public static <E> IOne<E> createOne(final BaseDelegate<E> delegate) {
		return (IOne<E>) ((BaseFactory) AOFFactory.INSTANCE).createBox(IConstraints.ONE, delegate);
	}

	/** Create a delegating set box. */
	public static <E> ISet<E> createSet(final BaseDelegate<E> delegate) {
		return (ISet<E>) ((BaseFactory) AOFFactory.INSTANCE).createBox(IConstraints.SET, delegate);
	}

	/** Create a delegating ordered set box. */
	public static <E> IOrderedSet<E> createOrderedSet(final BaseDelegate<E> delegate) {
		return (IOrderedSet<E>) ((BaseFactory) AOFFactory.INSTANCE).createBox(IConstraints.ORDERED_SET, delegate);
	}

	/** Create a delegating sequence box. */
	public static <E> ISequence<E> createSequence(final BaseDelegate<E> delegate) {
		return (ISequence<E>) ((BaseFactory) AOFFactory.INSTANCE).createBox(IConstraints.SEQUENCE, delegate);
	}

	/** Create a delegating bag box. */
	public static <E> IBag<E> createBag(final BaseDelegate<E> delegate) {
		return (IBag<E>) ((BaseFactory) AOFFactory.INSTANCE).createBox(IConstraints.BAG, delegate);
	}
}
