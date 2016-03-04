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
import org.eclipse.papyrus.metrics.extensionpoints.helpers.BasicMeasuresRegistry;
import org.eclipse.papyrus.metrics.extensionpoints.helpers.PrintersRegistry;
import org.omg.smm.Measure;

/**
 *
 * Calculates the Measures values defined by extensions of the extension point
 * org.eclipse.papyrus.metrics.extensionpoints.metric. Results are shown to the
 * user on all the Printers defined by extensions of the extension point
 * org.eclipse.papyrus.metrics.extensionpoints.printer
 *
 * @author MA244259
 *
 */
public class CalculateBasicMeasuresCommand extends RecordingCommand {
	protected ArrayList<Measure> measures = new ArrayList<Measure>();
	protected ArrayList<IPrinter> printers = new ArrayList<IPrinter>();
	protected org.eclipse.uml2.uml.Element observationScope = null;

	public CalculateBasicMeasuresCommand(TransactionalEditingDomain domain,
			org.eclipse.uml2.uml.Element observationScope) {
		super(domain, "CalculateBasicMeasuresCommand");

		BasicMeasuresRegistry basicMeasuresRegistry = BasicMeasuresRegistry.getInstance();
		if (basicMeasuresRegistry.getMeasures() == null || basicMeasuresRegistry.getMeasures().isEmpty()) {
			System.err.println("There are not registered basic measures");
			return;
		}

		PrintersRegistry printersRegistry = PrintersRegistry.getInstance();
		if (printersRegistry.getPrinters() == null || printersRegistry.getPrinters().isEmpty()) {
			System.err.println("There are not registered printers");
			return;
		}
		this.measures.addAll(basicMeasuresRegistry.getMeasures());
		this.printers = printersRegistry.getPrinters();
		this.observationScope = observationScope;
	}

	@Override
	protected void doExecute() {
		MetricsCalculatorHelper helper = new MetricsCalculatorHelper(measures, observationScope, printers);
		helper.run();
	}
}