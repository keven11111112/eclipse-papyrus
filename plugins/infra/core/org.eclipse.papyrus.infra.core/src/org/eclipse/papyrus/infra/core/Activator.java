/*****************************************************************************
 * Copyright (c) 2008, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.core.services.spi.IContextualServiceRegistryTracker;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.core";

	// The shared instance
	private static Activator plugin;

	/** Logging helper */
	public static LogHelper log;

	private ServiceTracker<IContextualServiceRegistryTracker, IContextualServiceRegistryTracker> serviceRegistryTrackerTracker;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		// register the log helper
		log = new LogHelper(this);

		serviceRegistryTrackerTracker = new ServiceTracker<>(context, IContextualServiceRegistryTracker.class, null);
		serviceRegistryTrackerTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		serviceRegistryTrackerTracker.close();
		serviceRegistryTrackerTracker = null;

		plugin = null;
		log = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Obtain the instance of the contextual service-registry tracker service, if any.
	 * 
	 * @return the service-registry tracker service, or {@code null} if none (probably
	 *         because there is no UI and, therefore, no user to be editing any Papyrus models)
	 */
	public IContextualServiceRegistryTracker getContextualServiceRegistryTracker() {
		return serviceRegistryTrackerTracker.getService();
	}
}
