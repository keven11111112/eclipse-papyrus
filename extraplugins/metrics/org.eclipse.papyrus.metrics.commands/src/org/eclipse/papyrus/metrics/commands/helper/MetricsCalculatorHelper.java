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
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.papyrus.metrics.extensionpoints.IPrinter;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.Result;
import org.eclipse.papyrus.requirements.metrics.library.DefaultQuerySwitch;
import org.eclipse.papyrus.requirements.metrics.library.RecognizerSwitch;
import org.eclipse.uml2.uml.Element;
import org.omg.smm.Measure;
import org.omg.smm.Operation;
import org.omg.smm.Scope;

public class MetricsCalculatorHelper {
	protected ArrayList<Measure> measures = new ArrayList<Measure>();
	protected org.eclipse.uml2.uml.Element observationScope = null;
	protected ArrayList<IPrinter> printers = null;
	protected ArrayList<Result> observationResults = null;
	protected HashMap<Element, ArrayList<Measure>> measurementScopes = null;

	public MetricsCalculatorHelper(ArrayList<Measure> measures2, Element observationScope2,
			ArrayList<IPrinter> printers2) {
		this.measures = measures2;
		this.observationScope = observationScope2;
		this.printers = printers2;
		this.measurementScopes = new HashMap<Element, ArrayList<Measure>>();
		this.observationResults = new ArrayList<Result>();
	}

	public void run() {
		calculateMeasurementScopes(this.observationScope);
		performMeasurementProcess();
		printMeasures();
	}

	/**
	 * Calculates the smmModels that apply to the model itself and its owned
	 * elements. The relationship between an element and its applicable
	 * smmMetrics is saved in
	 * {@link CalculateSmmBasedMeasuresCommand#measurementScopes}.
	 * 
	 * @param element
	 *            The Element to analyze
	 */
	public void calculateMeasurementScopes(Element element) {
		for (Measure measure : measures) {
			if (null == measure.getScope()) {
				System.err.println("There are not scopes associated to the measure " + measure.getName());
				return;
			}
			Scope scope = measure.getScope();
			if (null == scope.getRecognizer()) {
				System.err.println("There are not recognizers associated to the scope " + scope.getName());
				return;
			}
			Operation recognizer = scope.getRecognizer();
			if (recognizer.getLanguage().contentEquals("Java")) {
				String operationName = recognizer.getBody();
				if (RecognizerSwitch.isRecognized(operationName, element)) {
					updateMeasurementScopes(element, measure);
					if (element.allOwnedElements() != null) {
						for (Element currentElement : element.allOwnedElements()) {
							calculateMeasurementScopes(currentElement);
						}
					}
				}
			}
		}
	}

	protected void updateMeasurementScopes(Element element, Measure measure) {
		if (measurementScopes.containsKey(element)) {
			// avoid repeated smmModels by element
			if (!(measurementScopes.get(element)).contains(measure)) {
				measurementScopes.get(element).add(measure);
			}
		} else {
			measurementScopes.put(element, new ArrayList<Measure>());
			measurementScopes.get(element).add(measure);
		}
	}

	/**
	 * Prints the information of the smmModels using all the printers
	 */
	public void printMeasures() {
		for (IPrinter printer : printers) {
			printer.print(observationResults);
		}
	}

	/**
	 * Updates the results of the smmMetrics measurement process.
	 * 
	 * @param metric
	 * @param measurand
	 * @param value
	 */
	protected void updateOpservationResults(Measure metric, Element measurand, Object value) {
		observationResults.add(new Result(metric, measurand, value));
	}

	/**
	 * Perform a process to obtain smmModels based on the map
	 * {@link CalculateSmmBasedMeasuresCommand#measurementScopes} that contains
	 * the Measurand-Metrics tuples.
	 */
	public void performMeasurementProcess() {
		Iterator<Element> elementKeyiterator = measurementScopes.keySet().iterator();
		Object value = null;
		while (elementKeyiterator.hasNext()) {
			Element currentKey = (Element) elementKeyiterator.next();
			Iterator<Measure> measuresIterator = measurementScopes.get(currentKey).iterator();
			while (measuresIterator.hasNext()) {
				Measure measure = measuresIterator.next();
				if (null == measure.getDefaultQuery()) {
					System.err.println("There are not default queries associated to the measure " + measure.getName());
					return;
				}
				Operation operation = measure.getDefaultQuery();
				if (operation.getLanguage().contentEquals("Java")) {
					String methodNameToExecute = operation.getBody();
					value = DefaultQuerySwitch.calculateValue(methodNameToExecute, currentKey);
				}
				updateOpservationResults(measure, currentKey, value);
			}
		}
	}

}
