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

import org.eclipse.papyrus.metrics.extensionpoints.helpers.DefaultQuerySwitchRegistry;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.ResultsViewersRegistry;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IDefaultQuerySwitch;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IRecognizerSwitch;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IResultsViewer;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.RecognizerSwitchRegistry;

/**
 * Helper class for obtaining contributions from extensions
 *
 */
public class RegistersHelper {

	/**
	 * @return the switch class that calls operations to obtain measures'
	 *         values.
	 */
	public IDefaultQuerySwitch getDefaultQuerySwitch() {
		DefaultQuerySwitchRegistry defaultQuerySwitchRegistry = DefaultQuerySwitchRegistry.getInstance();
		if (defaultQuerySwitchRegistry.getDefaultQuerySwitch() == null) {
			System.err.println("There is not a registered default query switch");
			return null;
		} else
			return defaultQuerySwitchRegistry.getDefaultQuerySwitch();
	}

	/**
	 * @return the switch class that calls operations that identify if an
	 *         element is part of the scope of a measure.
	 */
	public IRecognizerSwitch getRecognizerSwitch() {
		RecognizerSwitchRegistry recognizerSwitchRegistry = RecognizerSwitchRegistry.getInstance();
		if (recognizerSwitchRegistry.getRecognizerSwitch() == null) {
			System.err.println("There is not a registered scope recognizer switch");
			return null;
		} else
			return recognizerSwitchRegistry.getRecognizerSwitch();
	}

	/**
	 * @return a list of viewers that will show measurement results
	 */
	public ArrayList<IResultsViewer> getViewers() {
		ResultsViewersRegistry resultsViewersRegistry = ResultsViewersRegistry.getInstance();
		if (resultsViewersRegistry.getMeasuringResultsViewers() == null
				|| resultsViewersRegistry.getMeasuringResultsViewers().isEmpty()) {
			System.err.println("There are not registered measuring results viewers");
			return null;
		} else
			return resultsViewersRegistry.getMeasuringResultsViewers();
	}
}
