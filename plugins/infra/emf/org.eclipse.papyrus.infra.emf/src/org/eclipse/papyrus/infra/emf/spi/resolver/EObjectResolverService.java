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

import org.eclipse.papyrus.infra.tools.util.CompositeServiceTracker;
import org.osgi.framework.BundleContext;

/**
 * A resolver that delegates to registered OSGi services in a <em>Chain of Command</em>
 * pattern to provide the first available service result.
 * 
 * @since 2.0
 */
public class EObjectResolverService implements IEObjectResolver {
	private final CompositeServiceTracker<IEObjectResolver> tracker;

	/**
	 * Initializes me with the bundle context in which I track resolver services.
	 * 
	 * @param context
	 *            the bundle context
	 */
	public EObjectResolverService(BundleContext context) {
		super();

		tracker = new CompositeServiceTracker<>(context,
				IEObjectResolver.class,
				IEObjectResolver.identity(),
				IEObjectResolver::compose);
		tracker.open();
	}

	public void dispose() {
		tracker.close();
	}

	@Override
	public Object resolve(Object object) {
		return tracker.getService().resolve(object);
	}
}
