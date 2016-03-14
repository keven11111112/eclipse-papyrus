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

import org.eclipse.papyrus.metrics.extensionpoints.helpers.BasicMeasuresRegistry;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.SmmMetricsModelHelper;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.SmmModelsRegistry;
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
	 * @return a list of {@link Measure} whose value should be calculated
	 */
	public ArrayList<Measure> getMeasuresFromFile() {
		ArrayList<Measure> measures = new ArrayList<Measure>();
		SmmModel smmModel = null;
		SmmMetricsModelHelper helper = new SmmMetricsModelHelper();
		String smmModelLocation = helper.getSmmModelFileLocation();
		if (smmModelLocation.isEmpty()) {
			return null;
		}
		if (helper.getSmmModel(smmModelLocation) == null) {
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
	 *         calculated or null if it does not find at least one type of
	 *         extension that defines measures
	 */
	public ArrayList<Measure> getMeasuresFromExtensions() {
		ArrayList<Measure> measures = new ArrayList<Measure>();
		boolean existMeasuresFrombasicMeasuresRegistry = false;
		boolean existMeasuresFromSmmModelsRegistry = false;
		BasicMeasuresRegistry basicMeasuresRegistry = BasicMeasuresRegistry.getInstance();
		
		if (null == basicMeasuresRegistry.getMeasures() || basicMeasuresRegistry.getMeasures().isEmpty()) {
			System.err.println("There are not registered basic measures in the extension point "
					+ BasicMeasuresRegistry.getExtensionPointId());
		} else {
			existMeasuresFrombasicMeasuresRegistry = true;
		}

		SmmModelsRegistry smmModelsRegistry = SmmModelsRegistry.getInstance();
		if (null == smmModelsRegistry.getMeasures() || smmModelsRegistry.getMeasures().isEmpty()) {
			System.err.println("There are not registered smm xmi models in the extension point "
					+ SmmModelsRegistry.getExtensionPointId());
		} else {
			existMeasuresFromSmmModelsRegistry = true;
		}

		boolean foundMeasures = (Boolean.TRUE.equals(existMeasuresFrombasicMeasuresRegistry)
				|| Boolean.TRUE.equals(existMeasuresFromSmmModelsRegistry)) ? true : false;
		if (!foundMeasures) {
			System.err.println("Failed to find at least one registered measure definitions ");
			return null;
		}

		measures.addAll(basicMeasuresRegistry.getMeasures());
		measures.addAll(smmModelsRegistry.getMeasures());
		
		return measures;
	}
}
