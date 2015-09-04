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

package org.eclipse.papyrus.infra.tools.util;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Utilities for working with {@link Stream}s.
 */
public class StreamUtil {

	/**
	 * Not instantiable by clients.
	 */
	private StreamUtil() {
		super();
	}

	/**
	 * Filters a {@code stream} for elements of a given {@code type}.
	 * 
	 * @param stream
	 *            a stream to filter
	 * @param type
	 *            the type of elements to select
	 * 
	 * @return the stream of elements of the requested {@code type}
	 */
	public static <E> Stream<E> select(Stream<?> stream, Class<E> type) {
		return stream.filter(type::isInstance).map(type::cast);
	}

	/**
	 * Wraps an iterator in a stream. Note that this is potentially dangerous, as the stream's
	 * consumption of the iterator is lazy: if elements are taken from the iterator before a
	 * terminal operation is applied to the resulting stream, then the stream will miss those
	 * elements.
	 * 
	 * @param iterator
	 *            an iterator
	 * @return a stream on the iterator
	 */
	public static <E> Stream<E> asStream(Iterator<E> iterator) {
		Iterable<E> iterable = () -> iterator;
		return StreamSupport.stream(iterable.spliterator(), false);
	}
}
