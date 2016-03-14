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
package org.eclipse.papyrus.metrics.viewers;

import java.util.ArrayList;

import org.eclipse.papyrus.metrics.extensionpoints.helpers.Result;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IResultsViewer;

public class DebugConsoleViewer implements IResultsViewer {

	@Override
	public void show(ArrayList<Result> measuresResults) {
		for (Result line : measuresResults) {
		System.out.printf(
				"Metric Name: " + line.getMeasure().getName() + "%n" 
				+ "Measurand: " + getMeasurandName(line.getMeasurand()) + "%n" 
				+ "Type of element measured: " + line.getMeasurand().eClass().getName() 
				+ "%n" + "Value: " + line.getValue().toString() 
				+ "%n%n");
		}
	}
}