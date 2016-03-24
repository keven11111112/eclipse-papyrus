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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.metrics.extensionpoints.Activator;
import org.omg.smm.AbstractMeasureElement;
import org.omg.smm.Measure;
import org.omg.smm.MeasureLibrary;
import org.omg.smm.NamedMeasure;
import org.omg.smm.SmmModel;

/**
 * Registry to obtain a SMM model saved in an xmi file chosen by a user
 */
public class SmmModelRegistry {
	protected static SmmModelRegistry namedMeasuresRegistry = null;
	protected ArrayList<Measure> measures = null;

	public ArrayList<Measure> getMeasures() {
		return measures;
	}

	private static final String EXTENSION_POINT_ID =  Activator.PLUGIN_ID + ".smmmetricsmodel"; //$NON-NLS-1$

	public static String getExtensionPointId() {
		return EXTENSION_POINT_ID;
	}

	/**
	 * Returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized SmmModelRegistry getInstance() {
		if (namedMeasuresRegistry == null) {
			namedMeasuresRegistry = new SmmModelRegistry();
			namedMeasuresRegistry.init();
		}
		return namedMeasuresRegistry;
	}

	/**
	 * Initializes the registry.
	 */
	protected void init() {
		measures = null;
		measures = new ArrayList<Measure>();
		readExtensions();
	}

	/**
	 * Reads the extensions to find instances of {@link NamedMeasure}
	 */
	protected void readExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXTENSION_POINT_ID);
		SmmModel smmModel = null;
		SmmMetricsModelHelper helper = new SmmMetricsModelHelper();
		for (IConfigurationElement element : elements) {
			String fileLocation = element.getAttribute("xmiFile");
			smmModel = helper.getSmmModel(fileLocation);
			if (null != smmModel) {
				for (MeasureLibrary library : smmModel.getLibraries()) {
					for (AbstractMeasureElement abstractMeasureElement : library.getMeasureElements()) {
						if (abstractMeasureElement instanceof NamedMeasure) {
							NamedMeasure measure = (NamedMeasure) abstractMeasureElement;
							this.measures.add(measure);
						}
					}
				}
			} else {
				Activator.log.warn(String.format("It was imposible to obtain an SMM model from %s", element.getValue()));
			}
		}
	}

}
