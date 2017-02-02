/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadwa TMAR (CEA LIST) fadwa.tmar@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.soaml.diagram.ui;


import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.soaml.diagram.common.commands.CreateSoamlModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.wizards.CreateModelWizard;
import org.eclipse.ui.IWorkbench;

public class NewSoamlModelWizard extends CreateModelWizard {

	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 * 
	 * @param workbench
	 * @param selection
	 */
  
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New SoaML Model");
	}

	/**
	 * Instantiates a new new Proteus model wizard.
	 */
	 public NewSoamlModelWizard()   {
		super();
	}



	@Override
	public String getModelKindName() {
		return "SoaML Model"; //$NON-NLS-1$
	}

	@Override
	protected String[] getDiagramCategoryIds() {
		return new String[]{ CreateSoamlModelCommand.COMMAND_ID };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		// here SoaML is the only available category
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveDiagramCategorySettings() {
		// here SoaML is the only available category
	}

}
