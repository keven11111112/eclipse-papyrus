/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.customization.nattableconfiguration;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.customization.nattableconfiguration"; //$NON-NLS-1$

	/**
	 * The shared instance
	 */
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
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
	 * Logs a warning message in the plugin log
	 *
	 * @param message
	 *            the message to log
	 */
	public static void logWarning(final String message) {
		getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, message));
	}

	/**
	 * Logs an error message in the plugin log
	 *
	 * @param message
	 *            the message to log
	 */
	public static void logError(final String message) {
		getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
	}

	/**
	 * Logs an information message in the plugin log
	 *
	 * @param message
	 *            the message to log
	 */
	public static void logInfo(final String message) {
		getDefault().getLog().log(new Status(IStatus.INFO, Activator.PLUGIN_ID, message));
	}

	/**
	 * Logs an error message in the plugin log
	 *
	 * @param exception
	 *            the exception to log
	 */
	public static void logException(final Exception exception) {
		getDefault().getLog().log(
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, exception.getLocalizedMessage(), exception));
	}

}
