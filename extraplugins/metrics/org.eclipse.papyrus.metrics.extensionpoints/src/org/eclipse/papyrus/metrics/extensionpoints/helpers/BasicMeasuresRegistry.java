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
import org.eclipse.papyrus.metrics.extensionpoints.Activator;
import org.omg.smm.Measure;

/**
 * Registry to obtain implementations of {@link Measure}
 */
public class BasicMeasuresRegistry {
	protected static BasicMeasuresRegistry basicMeasuresRegistry = null;
	protected ArrayList<Measure> measures = null;

	public ArrayList<Measure> getMeasures() {
		return measures;
	}

	private static final String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".measure"; //$NON-NLS-1$

	public static String getExtensionPointId() {
		return EXTENSION_POINT_ID;
	}

	/**
	 * Returns the singleton instance of this registry
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
	 * Initializes the registry
	 */
	protected void init() {
		measures = null;
		measures = new ArrayList<Measure>();
		readExtensions();
	}

	/**
	 * Reads the extensions to find classes that implement {@link Measure}
	 */
	protected void readExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXTENSION_POINT_ID);
		try {
			for (IConfigurationElement element : elements) {
				final Object o = element.createExecutableExtension("class");
				if (o instanceof Measure) {
					this.measures.add((Measure) o);
				}
			}
		} catch (CoreException ex) {
			Activator.log.error(ex);
		}
	}

}
