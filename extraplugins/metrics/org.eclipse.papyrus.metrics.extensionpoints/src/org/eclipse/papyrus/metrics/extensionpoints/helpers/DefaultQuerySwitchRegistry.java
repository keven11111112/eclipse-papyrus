/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.metrics.extensionpoints.helpers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.metrics.extensionpoints.Activator;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IDefaultQuerySwitch;

/**
 * Registry to obtain an implementation of {@link IDefaultQuerySwitch}
 */
public class DefaultQuerySwitchRegistry {
	protected static DefaultQuerySwitchRegistry defaultQuerySwitchRegistry = null;
	protected IDefaultQuerySwitch defaultQuerySwitch = null;

	public IDefaultQuerySwitch getDefaultQuerySwitch() {
		return defaultQuerySwitch;
	}

	private static final String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".defaultqueryswitch"; //$NON-NLS-1$
	/**
	 * Returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized DefaultQuerySwitchRegistry getInstance() {
		if (defaultQuerySwitchRegistry == null) {
			defaultQuerySwitchRegistry = new DefaultQuerySwitchRegistry();
			defaultQuerySwitchRegistry.init();
		}
		return defaultQuerySwitchRegistry;
	}

	/**
	 * Initializes the registry
	 */
	protected void init() {
		defaultQuerySwitch = null;
		readExtensions();
	}

	/**
	 * Reads the extensions to find a class that implements
	 * {@link IDefaultQuerySwitch}
	 */
	protected void readExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXTENSION_POINT_ID);
		if (elements.length > 1) {
			Activator.log.warn("It is not possible to register more than one default query operations switch");
			return;
		}
		try {
			for (IConfigurationElement element : elements) {
				final Object o = element.createExecutableExtension("class");
				if (o instanceof IDefaultQuerySwitch) {
					defaultQuerySwitch = ((IDefaultQuerySwitch) o);
					return;
				}
			}
		} catch (CoreException ex) {
			Activator.log.error(ex);
		}
	}

}