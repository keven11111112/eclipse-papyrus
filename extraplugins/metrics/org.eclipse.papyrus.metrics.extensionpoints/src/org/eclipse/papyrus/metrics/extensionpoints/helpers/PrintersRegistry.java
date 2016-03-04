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

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.metrics.extensionpoints.IPrinter;

/**
 * Registry to obtain printers implementations
 */
public class PrintersRegistry {
	protected static PrintersRegistry printersRegistry = null;
	protected ArrayList<IPrinter> printers = null;

	public ArrayList<IPrinter> getPrinters() {
		return printers;
	}

	private static final String IPrinter_EP_ID = "org.eclipse.papyrus.metrics.extensionpoints.printer";

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized PrintersRegistry getInstance() {
		if (printersRegistry == null) {
			printersRegistry = new PrintersRegistry();
			printersRegistry.init();
		}
		return printersRegistry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		// 0. Resets values
		printers = null;
		printers = new ArrayList<IPrinter>();
		// 1. creates the list only when registry is acceded for the first time,
		readPrintersFromExtensions();
	}

	protected void readPrintersFromExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(IPrinter_EP_ID);
		try {
			for (IConfigurationElement element : elements) {
				final Object o = element.createExecutableExtension("class");
				if (o instanceof IPrinter) {
					printers.add((IPrinter) o);
				}
			}
		} catch (CoreException ex) {
			System.err.println(ex.getMessage());
		}
	}

}