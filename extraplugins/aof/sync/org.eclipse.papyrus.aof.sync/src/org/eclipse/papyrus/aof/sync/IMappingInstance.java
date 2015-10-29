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

import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IPair;

/**
 * An instance of a {@linkplain IMapping mapping}, which is an association of a boxed
 * source and a boxed target, together with a collection of consequents (sub-mappings).
 * 
 * @see IMapping
 * @see #getType()
 */
public interface IMappingInstance<F, T> extends IPair<IOne<F>, IOne<T>>, Iterable<IMappingInstance<?, ?>> {
	/**
	 * Obtains the mapping of which I am an instance.
	 * 
	 * @return my (mapping) type
	 */
	IMapping<F, T> getType();

	/**
	 * Adds a down-stream mapping that is a consequence of myself. Usually, this is an
	 * instance of a sub-mapping that is established by {@linkplain #getType() my mapping}.
	 * 
	 * @param consequent
	 *            a down-stream mapping
	 */
	void addConsequent(IMappingInstance<?, ?> consequent);

	/**
	 * Destroys me, removing all active operations that implement me and my consequents,
	 * recursively.
	 */
	void destroy();

	default Stream<IMappingInstance<?, ?>> stream() {
		return StreamSupport.stream(spliterator(), false);
	}
}
