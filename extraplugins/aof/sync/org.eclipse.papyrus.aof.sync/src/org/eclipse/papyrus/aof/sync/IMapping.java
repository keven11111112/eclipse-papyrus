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

package org.eclipse.papyrus.aof.sync;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IPair;

/**
 * A directed (one-to-one but not becessarily bijective) mapping between two objects.
 * This is effectively a live, incremental, model-to-model transformation that synchronizes
 * the "to" object with the "from" object. The features of the "to" object that are
 * synchronized under this mapping may be changed independently, in which case it ceases to be
 * maintained by the mapping.
 * 
 * @param <F>
 *            the type on the source or "from" side of the mapping
 * @param <T>
 *            the type on the target or "to" side of the mapping
 */
@FunctionalInterface
public interface IMapping<F, T> {
	/**
	 * Establishes a live transformation of some features of an object {@code from} another.
	 * 
	 * @param from
	 *            the object that is the source of the mapping
	 * @param to
	 *            the object to which selected properties of the {@code from} object are
	 *            mapped, under possibly arbitrary transformation
	 * 
	 * @return boxes encapsulating the observable states of the {@code from} (the
	 *         {@linkplain IPair#getLeft() left}) and {@code to} (the
	 *         {@linkplain IPair#getRight() right} objects
	 */
	Instance<F, T> map(F from, T to);

	/**
	 * Drills into {@linkplain IBox boxes} encapsulating mapped objects to establish
	 * their live transformation as an <i>Active Operation</i>.
	 * 
	 * @param from
	 *            a box of (possibly multiple) source objects of the mapping
	 * @param to
	 *            a box containing the same number of target objects of the mapping
	 * 
	 * @return a box containing the same number of mapping pairs, per the
	 *         {@link #map(Object, Object)} primitive operation
	 */
	default <G extends F, U extends T> IBox<Instance<F, T>> map(IBox<G> from, IBox<U> to) {
		return to.zipWith(from, (U t, G f) -> map(f, t));
	}

	//
	// Nested types
	//

	/**
	 * An instance of the mapping that I describe, which is an association of a boxed
	 * source and a boxed target, together with a collection of consequents (sub-mappings).
	 */
	interface Instance<F, T> extends IPair<IOne<F>, IOne<T>>, Iterable<Instance<?, ?>> {
		/**
		 * Obtains the mapping of which I am an instance.
		 * 
		 * @return my (mapping) type
		 */
		IMapping<F, T> getType();

		/**
		 * Adds a down-stream mapping that is a consequence of myself.
		 * 
		 * @param consequent
		 *            a down-stream mapping
		 */
		void addConsequent(Instance<?, ?> consequent);

		/**
		 * Destroys me, removing all active operations that implement me and my consequents,
		 * recursively.
		 */
		void destroy();

		default Stream<Instance<?, ?>> stream() {
			return StreamSupport.stream(spliterator(), false);
		}
	}
}
