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
package org.eclipse.papyrus.metrics.commands.helper;

import java.util.ArrayList;

import org.eclipse.papyrus.metrics.commands.Activator;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.BasicMeasuresRegistry;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.SmmMetricsModelHelper;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.SmmModelRegistry;
import org.omg.smm.AbstractMeasureElement;
import org.omg.smm.Measure;
import org.omg.smm.MeasureLibrary;
import org.omg.smm.NamedMeasure;
import org.omg.smm.SmmModel;

/**
 * Reads instances of {@link Measure}
 *
 */
public class MeasuresReaderHelper {

	/**
	 * Reads instances of {@link Measure} defined in a file selected by the user
	 * at runtime
	 * 
	 * @return a list of instances of {@link Measure} whose value should be
	 *         calculated
	 */
	public ArrayList<Measure> getMeasuresFromFile() {
		ArrayList<Measure> measures = new ArrayList<Measure>();
		SmmModel smmModel = null;
		SmmMetricsModelHelper helper = new SmmMetricsModelHelper();
		String smmModelLocation = helper.getSmmModelFileLocation();
		if (smmModelLocation.isEmpty()|| null == smmModelLocation) {
			Activator.log.warn("SMM model location is empty in the extension plugin");
			return null;
		}
		if (helper.getSmmModel(smmModelLocation) == null) {
			Activator.log.warn("Impossible to get SMM model from: "+smmModelLocation);
			return null;
		}
		smmModel = helper.getSmmModel(smmModelLocation);
		for (MeasureLibrary library : smmModel.getLibraries()) {
			for (AbstractMeasureElement abstractMeasureElement : library.getMeasureElements()) {
				if (abstractMeasureElement instanceof NamedMeasure) {
					NamedMeasure measure = (NamedMeasure) abstractMeasureElement;
					measures.add(measure);
				}
			}
		}
		return measures;
	}

	/**
	 * Reads instances of {@link Measure} defined as extensions of the extension
	 * points org.eclipse.papyrus.metrics.extensionpoints.measure and
	 * org.eclipse.papyrus.metrics.extensionpoints.smmmetricsmodel.
	 * 
	 * @return a list of instances of {@link Measure} whose value should be
	 *         calculated
	 */
	public ArrayList<Measure> getMeasuresFromExtensions() {
		ArrayList<Measure> measures = new ArrayList<Measure>();
		boolean existMeasuresFrombasicMeasuresRegistry = false;
		boolean existMeasuresFromSmmModelRegistry = false;

		BasicMeasuresRegistry basicMeasuresRegistry = BasicMeasuresRegistry.getInstance();
		if (null == basicMeasuresRegistry.getMeasures() || basicMeasuresRegistry.getMeasures().isEmpty()) {
			Activator.log.warn("There are not registered implementations of " + Measure.class.toGenericString()
					+ " in the extension point " + BasicMeasuresRegistry.getExtensionPointId());
		} else {
			Activator.log.info("Found registered implementations of " + Measure.class.toGenericString()
					+ " in the extension point " + BasicMeasuresRegistry.getExtensionPointId());
			existMeasuresFrombasicMeasuresRegistry = true;
		}

		SmmModelRegistry smmModelsRegistry = SmmModelRegistry.getInstance();
		if (null == smmModelsRegistry.getMeasures() || smmModelsRegistry.getMeasures().isEmpty()) {
			Activator.log.warn("There are not registered smm models in the extension point "
					+ SmmModelRegistry.getExtensionPointId());
		} else {
			Activator.log.info("Found registered implementations of " + Measure.class.toGenericString()
					+ " in the extension point " + SmmModelRegistry.getExtensionPointId());
			existMeasuresFromSmmModelRegistry = true;
		}

		boolean foundMeasures = (Boolean.TRUE.equals(existMeasuresFrombasicMeasuresRegistry)
				|| Boolean.TRUE.equals(existMeasuresFromSmmModelRegistry)) ? true : false;
		if (!foundMeasures) {
			Activator.log.warn("Failed to find at least one registered measure definition");
			return null;
		}

		measures.addAll(basicMeasuresRegistry.getMeasures());
		measures.addAll(smmModelsRegistry.getMeasures());

		return measures;
	}
}