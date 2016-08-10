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

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.metrics.commands.helper.MetricsCalculatorHelper;
import org.eclipse.papyrus.metrics.commands.helper.RegistersHelper;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IDefaultQuerySwitch;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IRecognizerSwitch;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IResultsViewer;
import org.eclipse.swt.widgets.Display;
import org.omg.smm.Measure;
import org.omg.smm.SmmModel;

/**
 * Calculates the values of Measures.
 *
 */
public abstract class AbstractCalculateMeasuresCommand extends AbstractCommand {

	protected ArrayList<Measure> measures = new ArrayList<Measure>();
	protected ArrayList<IResultsViewer> resultsViewers = new ArrayList<IResultsViewer>();
	protected org.eclipse.uml2.uml.Element observationScope = null;
	protected SmmModel smmModel = null;
	protected IRecognizerSwitch recognizerSwitch = null;
	protected IDefaultQuerySwitch defaultQuerySwitch = null;

	{
		// This ensures that these state variables reflect the right value.
		isPrepared = true;
		isExecutable = true;
	}

	public AbstractCalculateMeasuresCommand(org.eclipse.uml2.uml.Element observationScope) {
		super("AbstractCalculateMeasuresCommand",
				"Abstract command to calculate Measures according to the SMM metamodel");
		RegistersHelper registersHelper = new RegistersHelper();
		this.resultsViewers = registersHelper.getViewers();
		this.recognizerSwitch = registersHelper.getRecognizerSwitch();
		this.defaultQuerySwitch = registersHelper.getDefaultQuerySwitch();
		this.observationScope = observationScope;
	}

	abstract protected ArrayList<Measure> getMeasures();

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	@Override
	public void redo() {
	    // Do nothing.
	}

	@Override
	public void execute() {
		this.measures = getMeasures();
		if (null == measures || null == resultsViewers || null == observationScope || null == resultsViewers
				|| null == recognizerSwitch || null == defaultQuerySwitch) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error",
					"Imposible to start metrics calculation\n Please read the details in the log.");
			return;
		} else if (measures.isEmpty()) {
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Information",
					"There are no measures to calculate");
			return;
		}
		MetricsCalculatorHelper helper = new MetricsCalculatorHelper(measures, observationScope, resultsViewers,
				recognizerSwitch, defaultQuerySwitch);
		helper.run();
	}
}