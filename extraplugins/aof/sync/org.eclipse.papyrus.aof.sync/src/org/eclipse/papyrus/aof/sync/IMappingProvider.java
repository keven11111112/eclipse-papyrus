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

import java.lang.reflect.Type;

/**
 * Protocol for a provider of synchronization {@linkplain IMapping mappings}.
 */
public interface IMappingProvider {

	/**
	 * Obtains a mapping relation between objects of the specified
	 * {@code fromType} and {@code toType}.
	 * 
	 * @param fromType
	 *            the mapping source type
	 * @param toType
	 *            the mapping target type
	 * 
	 * @return the mapping
	 */
	<F, T> IMapping<F, T> getMapping(Type fromType, Type toType);

	boolean hasMapping(Type fromType, Type toType);

	/**
	 * Obtains a mapping relation between objects of the specified {@code type}.
	 * 
	 * @param type
	 *            the mapping type
	 * 
	 * @return the mapping
	 */
	default <E> IMapping<E, E> getMapping(Type type) {
		return getMapping(type, type);
	}

	default boolean hasMapping(Type type) {
		return hasMapping(type, type);
	}

}
