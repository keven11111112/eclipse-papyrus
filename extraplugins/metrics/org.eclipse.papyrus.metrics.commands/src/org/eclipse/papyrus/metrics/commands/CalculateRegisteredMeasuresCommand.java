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
package org.eclipse.papyrus.metrics.commands;

import java.util.ArrayList;

import org.eclipse.papyrus.metrics.commands.helper.MeasuresReaderHelper;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IResultsViewer;
import org.eclipse.uml2.uml.Element;
import org.omg.smm.Measure;

/**
 * Calculates the values of registered Measures. Results are shown to the users
 * by means of the all the registered viewers implementing
 * {@link IResultsViewer}
 *
 */
public class CalculateRegisteredMeasuresCommand extends AbstractCalculateMeasuresCommand {

	public CalculateRegisteredMeasuresCommand(Element observationScope) {
		super(observationScope);
	}

	@Override
	protected ArrayList<Measure> getMeasures() {
		MeasuresReaderHelper measuresReaderHelper = new MeasuresReaderHelper();
		return measuresReaderHelper.getMeasuresFromExtensions();
	}

}