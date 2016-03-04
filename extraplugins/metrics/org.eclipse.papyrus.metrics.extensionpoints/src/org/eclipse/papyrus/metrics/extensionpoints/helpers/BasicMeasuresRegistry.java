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
//import org.eclipse.papyrus.metrics.extensionpoints.IAbstractMetric;
import org.omg.smm.Measure;

/**
 * Registry to obtain smmMetrics implementations
 */
public class BasicMeasuresRegistry {
	protected static BasicMeasuresRegistry basicMeasuresRegistry = null;
	protected ArrayList<Measure> measures = null;

	public ArrayList<Measure> getMeasures() {
		return measures;
	}

	private static final String IMeasure_EP_ID = "org.eclipse.papyrus.metrics.extensionpoints.measure";

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized BasicMeasuresRegistry getInstance() {
		if (basicMeasuresRegistry == null) {
			basicMeasuresRegistry = new BasicMeasuresRegistry();
			basicMeasuresRegistry.init();
		}
		return basicMeasuresRegistry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		// 0. Resets values
		measures = null;
		measures = new ArrayList<Measure>();
		// 1. creates the list only when registry is acceded for the first time,
		readExtensions();
	}

	protected ArrayList<?> readExtensions() {
		ArrayList<Object> extensions = new ArrayList<Object>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(IMeasure_EP_ID);
		try {
			for (IConfigurationElement element : elements) {
				final Object o = element.createExecutableExtension("class");
				System.out.println(o.getClass());
				if (o instanceof Measure) {
					measures.add((Measure) o);
				}
			}
		} catch (CoreException ex) {
			System.err.println(ex.getMessage());
		}
		return extensions;
	}
}
