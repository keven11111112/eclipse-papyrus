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
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IResultsViewer;

/**
 * Registry to obtain implementations of {@link IResultsViewer} 
 */
public class ResultsViewersRegistry {
	protected static ResultsViewersRegistry resultsViewersRegistry = null;
	protected ArrayList<IResultsViewer> resultsViewers = null;

	public ArrayList<IResultsViewer> getMeasuringResultsViewers() {
		return resultsViewers;
	}

	private static final String EXTENSION_POINT_ID = "org.eclipse.papyrus.metrics.extensionpoints.measuringresultsviewer";

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized ResultsViewersRegistry getInstance() {
		if (resultsViewersRegistry == null) {
			resultsViewersRegistry = new ResultsViewersRegistry();
			resultsViewersRegistry.init();
		}
		return resultsViewersRegistry;
	}

	/**
	 * Initializes the registry.
	 */
	protected void init() {
		// 0. Resets values
		resultsViewers = null;
		resultsViewers = new ArrayList<IResultsViewer>();
		// 1. creates the list only when the registry is acceded for the first time
		readExtensions();
	}

	/**
	 * Reads the extensions to find classes that implement
	 * {@link IResultsViewer}
	 */
	protected void readExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXTENSION_POINT_ID);
		try {
			for (IConfigurationElement element : elements) {
				final Object o = element.createExecutableExtension("class");
				if (o instanceof IResultsViewer) {
					resultsViewers.add((IResultsViewer) o);
				}
			}
		} catch (CoreException ex) {
			System.err.println(ex.getMessage());
		}
	}

}