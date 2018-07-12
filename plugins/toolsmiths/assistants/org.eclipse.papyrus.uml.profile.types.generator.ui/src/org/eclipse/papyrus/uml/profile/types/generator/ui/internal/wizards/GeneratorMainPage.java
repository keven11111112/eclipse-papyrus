/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.types.generator.ui.internal.wizards;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @author damus
 *
 */
public class GeneratorMainPage extends WizardNewFileCreationPage implements IGeneratorWizardPage {

	private final GeneratorWizardModel model;

	private GeneratorParametersBlock parametersBlock;
	private BaseElementTypeSetBlock diagramBlock;

	public GeneratorMainPage(GeneratorWizardModel model, String title, String description, String fileExtension) {
		super("main", model.getDefaultContainerSelection()); //$NON-NLS-1$

		this.model = model;

		setTitle(title);
		setDescription(description);

		setAllowExistingResources(true);
		setFileExtension(fileExtension);
		setFileName(model.getDefaultFileName());
	}

	@Override
	public void createControl(Composite parent) {
		Composite self = new Composite(parent, SWT.NONE);

		self.setLayout(new GridLayout(2, false));

		parametersBlock = new GeneratorParametersBlock(model);
		parametersBlock.createControl(self);
		diagramBlock = new BaseElementTypeSetBlock(model);
		diagramBlock.createControl(self);

		super.createControl(self);
		getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		setControl(self);

		setPageComplete(validatePage());
	}

	@Override
	public void save() {
		parametersBlock.save();
		diagramBlock.save();
	}

	@Override
	public boolean validatePage() {
		model.setContainerPath(getContainerFullPath());
		model.setFileName(getFileName());

		return super.validatePage() && model.validate();
	}
}
