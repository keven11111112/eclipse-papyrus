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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.metrics.commands.helper.MeasuresReaderHelper;
import org.eclipse.papyrus.metrics.commands.helper.MetricsCalculatorHelper;
import org.eclipse.papyrus.metrics.commands.helper.RegistersHelper;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IDefaultQuerySwitch;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IRecognizerSwitch;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IResultsViewer;
import org.omg.smm.Measure;
import org.omg.smm.SmmModel;

/**
 *
 * Calculates the Measures values defined in an external smm model. Results are
 * shown to the user on all the Printers defined by extensions of the extension
 * point org.eclipse.papyrus.metrics.extensionpoints.printer
 *
 */
public class CalculateSmmBasedMeasuresCommand extends RecordingCommand {
	protected ArrayList<Measure> measures = new ArrayList<Measure>();
	protected ArrayList<IResultsViewer> resultsViewers = new ArrayList<IResultsViewer>();
	protected org.eclipse.uml2.uml.Element observationScope = null;
	protected SmmModel smmModel = null;
	protected IRecognizerSwitch recognizerSwitch = null;
	protected IDefaultQuerySwitch defaultQuerySwitch = null;

	public CalculateSmmBasedMeasuresCommand(TransactionalEditingDomain domain,
			org.eclipse.uml2.uml.Element observationScope) {
		super(domain, "CalculateSmmBasedMeasuresCommand");
		RegistersHelper registersHelper = new RegistersHelper();
		this.resultsViewers = registersHelper.getViewers();
		this.recognizerSwitch = registersHelper.getRecognizerSwitch();
		this.defaultQuerySwitch = registersHelper.getDefaultQuerySwitch();
		this.observationScope = observationScope;
	}

	@Override
	protected void doExecute() {
		MeasuresReaderHelper measuresReaderHelper = new MeasuresReaderHelper();
		this.measures = measuresReaderHelper.getMeasuresFromFile();
		MetricsCalculatorHelper helper = new MetricsCalculatorHelper(measures, observationScope, resultsViewers,
				recognizerSwitch, defaultQuerySwitch);
		helper.run();
	}

}