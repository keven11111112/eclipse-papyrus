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
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IRecognizerSwitch;

/**
 * Registry to obtain an implementation of {@link IRecognizerSwitch}
 */
public class RecognizerSwitchRegistry {
	protected static RecognizerSwitchRegistry recognizerSwitchRegistry = null;
	protected IRecognizerSwitch recognizerSwitch = null;

	public IRecognizerSwitch getRecognizerSwitch() {
		return recognizerSwitch;
	}

	private static final String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".recognizerswitch"; //$NON-NLS-1$

	/**
	 * Returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized RecognizerSwitchRegistry getInstance() {
		if (recognizerSwitchRegistry == null) {
			recognizerSwitchRegistry = new RecognizerSwitchRegistry();
			recognizerSwitchRegistry.init();
		}
		return recognizerSwitchRegistry;
	}

	/**
	 * Initializes the registry
	 */
	protected void init() {
		recognizerSwitch = null;
		readExtensions();
	}

	/**
	 * Reads the extensions to find an class that implements
	 * {@link IRecognizerSwitch}
	 */
	protected void readExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXTENSION_POINT_ID);
		if (elements.length > 1) {
			Activator.log.warn("It is not possible to register more than one recognizer operations switch");
			return;
		}
		try {
			for (IConfigurationElement element : elements) {
				final Object o = element.createExecutableExtension("class");
				if (o instanceof IRecognizerSwitch) {
					recognizerSwitch = ((IRecognizerSwitch) o);
					return;
				}
			}
		} catch (CoreException ex) {
			Activator.log.error(ex);
		}
	}

}