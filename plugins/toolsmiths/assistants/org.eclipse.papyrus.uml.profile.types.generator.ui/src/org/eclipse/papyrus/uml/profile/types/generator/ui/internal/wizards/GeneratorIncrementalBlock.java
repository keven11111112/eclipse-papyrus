/*****************************************************************************
 * Copyright (c) 2020 EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Camille Letavernier - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.types.generator.ui.internal.wizards;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * Block presenting the incremental generation options.
 */
class GeneratorIncrementalBlock {

	private GeneratorWizardModel model;

	public GeneratorIncrementalBlock(GeneratorWizardModel model) {
		this.model = model;
	}

	void createControl(Composite parent) {

		Group incrementalGroup = new Group(parent, SWT.NONE);
		incrementalGroup.setText("Incremental Generation");
		incrementalGroup.setLayout(new GridLayout(1, true));
		incrementalGroup.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).span(2, 1).create());

		Button isIncremental = new Button(incrementalGroup, SWT.CHECK);
		isIncremental.setText("Incremental updates");
		isIncremental.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setIncremental(isIncremental.getSelection());
				model.validatePage();
			}
		});
		isIncremental.setSelection(model.isIncremental());

		Button removeDeleted = new Button(incrementalGroup, SWT.CHECK);
		removeDeleted.setText("Delete obsolete element type configurations");
		removeDeleted.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setDeleteObsoleteTypes(removeDeleted.getSelection());
				model.validatePage();
			}
		});
		removeDeleted.setSelection(model.isDeleteObsoleteTypes());
	}

}
