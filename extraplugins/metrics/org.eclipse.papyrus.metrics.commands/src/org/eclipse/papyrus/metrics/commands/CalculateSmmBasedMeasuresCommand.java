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
import org.eclipse.papyrus.metrics.commands.helper.MetricsCalculatorHelper;
import org.eclipse.papyrus.metrics.extensionpoints.IPrinter;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.PrintersRegistry;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.SmmMetricsHelper;
import org.omg.smm.AbstractMeasureElement;
import org.omg.smm.Measure;
import org.omg.smm.MeasureLibrary;
import org.omg.smm.NamedMeasure;
import org.omg.smm.SmmModel;

/**
 *
 * Calculates the Measures values defined in an external smm model. Results are
 * shown to the user on all the Printers defined by extensions of the extension
 * point org.eclipse.papyrus.metrics.extensionpoints.printer
 *
 * @author MA244259
 *
 */
public class CalculateSmmBasedMeasuresCommand extends RecordingCommand {
	protected ArrayList<Measure> measures = new ArrayList<Measure>();
	protected ArrayList<IPrinter> printers = new ArrayList<IPrinter>();
	protected org.eclipse.uml2.uml.Element observationScope = null;
	protected SmmModel smmModel = null;

	public CalculateSmmBasedMeasuresCommand(TransactionalEditingDomain domain,
			org.eclipse.uml2.uml.Element observationScope) {
		super(domain, "CalculateSmmBasedMeasuresCommand");
		
		PrintersRegistry printersRegistry = PrintersRegistry.getInstance();
		if (printersRegistry.getPrinters() == null || printersRegistry.getPrinters().isEmpty()) {
			System.err.println("There are not registered printers");
			return;
		}
		
		this.printers = printersRegistry.getPrinters();
		this.observationScope = observationScope;
	}

	@Override
	protected void doExecute() {
		SmmModel smmModel = null;
		SmmMetricsHelper helper = new SmmMetricsHelper();
		String smmModelLocation = helper.getSmmModelFileLocation();
		if (smmModelLocation.isEmpty()) {
			return;
		}
		if (helper.getSmmModel(smmModelLocation) == null) {
			return;
		}
		smmModel = helper.getSmmModel(smmModelLocation);
		for (MeasureLibrary library : smmModel.getLibraries()) {
			for (AbstractMeasureElement abstractMeasureElement : library.getMeasureElements()) {
				if (abstractMeasureElement instanceof NamedMeasure) {
					NamedMeasure measure = (NamedMeasure) abstractMeasureElement;
					this.measures.add(measure);
				}
			}
		}
		MetricsCalculatorHelper metricsCalculatorHelper = new MetricsCalculatorHelper(measures, observationScope, printers);
		metricsCalculatorHelper.run();
	}
}