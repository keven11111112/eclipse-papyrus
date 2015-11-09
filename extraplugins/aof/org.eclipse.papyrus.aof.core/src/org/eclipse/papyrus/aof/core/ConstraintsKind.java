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

package org.eclipse.papyrus.aof.core;

/**
 * An enumeration of the kinds of box constraints recognized by the framework.
 */
public enum ConstraintsKind implements IConstraints {
	/** The {@link IOption} Kind. */
	OPTION(IConstraints.OPTION), //
	/** The {@link IOne} Kind. */
	ONE(IConstraints.ONE), //
	/** The {@link ISet} Kind. */
	SET(IConstraints.SET), //
	/** The {@link IOrderedSet} Kind. */
	ORDERED_SET(IConstraints.ORDERED_SET), //
	/** The {@link ISequence} Kind. */
	SEQUENCE(IConstraints.SEQUENCE), //
	/** The {@link IBag} Kind. */
	BAG(IConstraints.BAG);

	private final IConstraints delegate;

	private ConstraintsKind(IConstraints delegate) {
		this.delegate = delegate;
	}

	@Override
	public boolean isOptional() {
		return delegate.isOptional();
	}

	@Override
	public boolean isSingleton() {
		return delegate.isSingleton();
	}

	@Override
	public boolean isOrdered() {
		return delegate.isOrdered();
	}

	@Override
	public boolean isUnique() {
		return delegate.isUnique();
	}

	@Override
	public boolean isLegal() {
		return delegate.isLegal();
	}

	@Override
	public boolean matches(IConstraints that) {
		return delegate.matches(that);
	}

	/**
	 * Creates a new box of my kind.
	 * 
	 * @param factory
	 *            the factory with which to create the box.
	 * @param elements
	 *            the box's initial elements, if any
	 * 
	 * @return the box
	 */
	@SafeVarargs
	public final <E> IBox<E> createBox(IFactory factory, E... elements) {
		return factory.createBox(this, elements);
	}

	/**
	 * Queries the box constraints that I represent.
	 * 
	 * @return my corresponding constraints
	 */
	public IConstraints getConstraints() {
		return delegate;
	}

	/**
	 * Converts an {@link IConstraints} to its kind.
	 * 
	 * @param constraints
	 *            a box constraints
	 * @return its kind
	 */
	public static ConstraintsKind forConstraints(IConstraints constraints) {
		ConstraintsKind result;

		if (!constraints.isLegal()) {
			throw new IllegalArgumentException("invalid constraints: " + constraints); //$NON-NLS-1$
		}

		if (constraints.isSingleton()) {
			result = constraints.isOptional() ? OPTION : ONE;
		} else if (constraints.isUnique()) {
			result = constraints.isOrdered() ? ORDERED_SET : SET;
		} else {
			result = constraints.isOrdered() ? SEQUENCE : BAG;
		}

		return result;
	}

}
