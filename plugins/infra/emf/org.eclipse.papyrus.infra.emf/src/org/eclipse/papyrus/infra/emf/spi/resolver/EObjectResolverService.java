/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.emf.spi.resolver;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * A resolver that delegates to registered OSGi services in a <em>Chain of Command</em>
 * pattern to provide the first available service result.
 */
public class EObjectResolverService extends ServiceTracker<IEObjectResolver, IEObjectResolver> implements IEObjectResolver {
	private final AtomicReference<IEObjectResolver> delegate = new AtomicReference<>(IEObjectResolver.identity());

	/**
	 * Initializes me with the bundle context in which I track resolver services.
	 * 
	 * @param context
	 *            the bundle context
	 */
	public EObjectResolverService(BundleContext context) {
		super(context, IEObjectResolver.class, null);
	}

	@Override
	public Object resolve(Object object) {
		IEObjectResolver delegate = this.delegate.get();
		if (delegate == null) {
			// Recompute
			delegate = Stream.of(getServices(new IEObjectResolver[getTrackingCount()]))
					.filter(Objects::nonNull) // If the array has more slots than we have services
					.reduce(IEObjectResolver.identity(), IEObjectResolver::compose);
			this.delegate.set(delegate);
		}

		return delegate.resolve(object);
	}

	@Override
	public IEObjectResolver addingService(ServiceReference<IEObjectResolver> reference) {
		IEObjectResolver result = super.addingService(reference);

		// We will have to recompute our delegates
		delegate.set(null);

		return result;
	}

	@Override
	public void removedService(ServiceReference<IEObjectResolver> reference, IEObjectResolver service) {
		super.removedService(reference, service);

		// We will have to recompute our delegates
		delegate.set(null);
	}
}
