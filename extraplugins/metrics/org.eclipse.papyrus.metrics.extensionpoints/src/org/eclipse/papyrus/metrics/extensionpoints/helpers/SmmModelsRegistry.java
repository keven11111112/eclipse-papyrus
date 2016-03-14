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
import org.omg.smm.AbstractMeasureElement;
import org.omg.smm.Measure;
import org.omg.smm.MeasureLibrary;
import org.omg.smm.NamedMeasure;
import org.omg.smm.SmmModel;

/**
 * Registry to obtain smmMetrics implementations
 */
public class SmmModelsRegistry {
	protected static SmmModelsRegistry smmModelsRegistry = null;
	protected ArrayList<Measure> measures = null;

	public ArrayList<Measure> getMeasures() {
		return measures;
	}

	private static final String EXTENSION_POINT_ID = "org.eclipse.papyrus.metrics.extensionpoints.smmmetricsmodel";

	public static String getExtensionPointId() {
		return EXTENSION_POINT_ID;
	}

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized SmmModelsRegistry getInstance() {
		if (smmModelsRegistry == null) {
			smmModelsRegistry = new SmmModelsRegistry();
			smmModelsRegistry.init();
		}
		return smmModelsRegistry;
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
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXTENSION_POINT_ID);
		SmmModel smmModel = null;
		SmmMetricsModelHelper helper = new SmmMetricsModelHelper();
		for (IConfigurationElement element : elements) {
			String elementName = element.getName();
			System.out.println(elementName);
			String fileLocation = element.getAttribute("xmiFile");
			if (null == helper.getSmmModel(fileLocation)) {
				System.err.println("Imposible to obtain an SMM model from " + element.getValue());
				return null;
			}
			smmModel = helper.getSmmModel(element.getAttribute("xmiFile"));
			for (MeasureLibrary library : smmModel.getLibraries()) {
				for (AbstractMeasureElement abstractMeasureElement : library.getMeasureElements()) {
					if (abstractMeasureElement instanceof NamedMeasure) {
						NamedMeasure measure = (NamedMeasure) abstractMeasureElement;
						this.measures.add(measure);
					}
				}
			}
		}
		return extensions;
	}

}
