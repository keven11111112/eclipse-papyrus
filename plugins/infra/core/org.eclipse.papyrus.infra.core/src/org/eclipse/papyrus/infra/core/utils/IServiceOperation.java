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

package org.eclipse.papyrus.infra.core.utils;

import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;

/**
 * An operation on an {@link IService} or equivalent POJO service that may throw a
 * {@link ServiceException}.
 */
@FunctionalInterface
public interface IServiceOperation<T, X extends ServiceException> {
	/**
	 * Performs the service operation.
	 * 
	 * @return the result of the operation, if successful
	 * 
	 * @throws X
	 *             if the operation cannot be performed
	 */
	T perform() throws X;

	/**
	 * {@linkplain #perform() Performs} a stream of service
	 * {@code operations}, with accounting for possible exceptions.
	 * The results returned by each operation, if any, are discarded.
	 * 
	 * @param operations
	 *            the stream of operations to perform
	 * 
	 * @throws ServiceException
	 *             aggregation of exceptions thrown (if any) by the {@code operations}
	 */
	static void performEach(
			Stream<? extends IServiceOperation<?, ? extends ServiceException>> operations) throws ServiceException {

		ServiceException[] toThrow = { null };

		operations.forEach(o -> {
			try {
				o.perform();
			} catch (ServiceException exception) {
				toThrow[0] = ServiceException.chain(toThrow[0], exception);
			}
		});

		if (toThrow[0] != null) {
			throw toThrow[0];
		}
	}

	/**
	 * Collects the results of {@linkplain #perform() performing} a stream of service
	 * {@code operations}, with accounting for possible exceptions.
	 * 
	 * @param operations
	 *            the stream of operations to perform
	 * @param collector
	 *            in which to reduce/collect results of each operation
	 * 
	 * @return the reduced/collected result
	 * 
	 * @throws ServiceException
	 *             aggregation of exceptions thrown (if any) by the {@code operations}
	 */
	static <T, R> R collect(
			Stream<? extends IServiceOperation<T, ? extends ServiceException>> operations,
			Collector<? super T, ?, R> collector) throws ServiceException {

		ServiceException[] toThrow = { null };

		Stream<T> intermediate = operations.map(o -> {
			try {
				return o.perform();
			} catch (ServiceException exception) {
				toThrow[0] = ServiceException.chain(toThrow[0], exception);
				return null;
			}
		});

		R result = intermediate.filter(Objects::isNull).collect(collector);

		if (toThrow[0] != null) {
			throw toThrow[0];
		}

		return result;
	}
}
