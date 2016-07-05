/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.preferences;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.propertylifecycle.preferences"; //$NON-NLS-1$

	/** The shared instance */
	private static Activator plugin;

	/** Logging helper */
	public static LogHelper log;

	/** The tag to identify the trace when activating the messages in the .options file */
	public static String STRATEGY_PREFERENCES_TRACE = "lifecyclepreferences";

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
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
	 * Get the image from its path in the current plugin
	 * 
	 * @param path
	 * @return
	 * 		The {@link #org.eclipse.swt.graphics.Image image}
	 */
	public Image getImage(String path) {
		return getImage(PLUGIN_ID, path);
	}

	/**
	 * Get the image from its path in the specified plugin
	 * 
	 * @param pluginId
	 * @param path
	 * @return
	 * 		The {@link #org.eclipse.swt.graphics.Image image}
	 */
	public Image getImage(String pluginId, String path) {
		final ImageRegistry registry = getImageRegistry();
		String key = pluginId + "/" + path; //$NON-NLS-1$
		Image image = registry.get(key);
		if (image == null) {
			registry.put(key, AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, path));
			image = registry.get(key);
		}
		return image;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 *
	 * @param path
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

}
