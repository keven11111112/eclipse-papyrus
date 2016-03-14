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

	private static final String EXTENSION_POINT_ID = "org.eclipse.papyrus.metrics.extensionpoints.recognizerswitch";

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
	 * Initializes the registry.
	 */
	protected void init() {
		// Resets values
		recognizerSwitch = null;
		// Reads only when the registry is acceded for the first time
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
			System.err.println("It is not possible to user more than one recognizer operations switch");
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
			System.err.println(ex.getMessage());
		}
	}

}