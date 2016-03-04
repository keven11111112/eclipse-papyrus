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
package org.eclipse.papyrus.metrics.view;

import java.util.ArrayList;

import org.eclipse.papyrus.metrics.extensionpoints.helpers.Result;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public class MetricsView extends ViewPart {
	private ArrayList<Result> measuresResults = null;
	private static Table table;

	public MetricsView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		this.setTitleToolTip("Metrics");
		table = new Table(parent, SWT.SINGLE);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn column1 = new TableColumn(table, SWT.LEFT);
		TableColumn column2 = new TableColumn(table, SWT.LEFT);
		TableColumn column3 = new TableColumn(table, SWT.LEFT);
		TableColumn column4 = new TableColumn(table, SWT.LEFT);
		column1.setWidth(200);
		column1.setText("Measure Name");
		column2.setWidth(150);
		column2.setText("Measure Value");
		column3.setWidth(200);
		column3.setText("Type of element measured");
		column4.setWidth(200);
		column4.setText("Name of element measured");
		clearTable();
		if (this.getResults() != null) {
			for (Result line : this.getResults()) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(new String[] { line.getMeasure().getName(), line.getValue().toString(),
						line.getMeasurand().eClass().getName(), getMeasurandName(line.getMeasurand()) });
			}
		}
	}

	@Override
	public void setFocus() {
		table.setFocus();
	}

	public void updateInformation(ArrayList<Result> measuresResults) {
		this.measuresResults = measuresResults;
		// Update the user interface asynchronously
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				clearTable();
				if (getResults() != null) {
					for (Result line : getResults()) {
						TableItem item = new TableItem(table, SWT.NONE);
						item.setText(new String[] { line.getMeasure().getName(), line.getValue().toString(),
								line.getMeasurand().eClass().getName(), getMeasurandName(line.getMeasurand()) });
					}
				}
			}

		});
	}

	public ArrayList<Result> getResults() {
		return measuresResults;
	}

	/**
	 * Clear previous measures
	 */
	protected void clearTable() {
		table.removeAll();
	}

	public static String getMeasurandName(Element measurand) {
		return (String) ((measurand instanceof NamedElement) ? ((NamedElement) measurand).getQualifiedName()
				: measurand);
	}
}
