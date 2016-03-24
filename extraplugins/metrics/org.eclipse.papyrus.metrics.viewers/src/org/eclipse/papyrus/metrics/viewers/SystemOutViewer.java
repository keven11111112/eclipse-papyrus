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
import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.metrics.extensionpoints.helpers.Result;
import org.eclipse.papyrus.metrics.extensionpoints.interfaces.IResultsViewer;

public class SystemOutViewer implements IResultsViewer {

	@Override
	public void show(ArrayList<Result> measuresResults) {

		List<List<String>> rows = new ArrayList<List<String>>();
		// Print the labels
		System.out.println();
		Arrays.asList("Metric Name", "Measurand", "Type of element measured", "Value")
				.forEach(columnLabel -> System.out.printf("%-35s|", columnLabel));
		// Obtain the values
		System.out.println();
		measuresResults.forEach(
				result -> rows.add(Arrays.asList(result.getMeasure().getName(), getMeasurandName(result.getMeasurand()),
						result.getMeasurand().eClass().getName(), result.getValue().toString())));
		// Print the values
		rows.forEach(row -> {
			row.forEach(cellValue -> System.out.printf("%-35s|", cellValue));
			System.out.println();
		});
	}
}