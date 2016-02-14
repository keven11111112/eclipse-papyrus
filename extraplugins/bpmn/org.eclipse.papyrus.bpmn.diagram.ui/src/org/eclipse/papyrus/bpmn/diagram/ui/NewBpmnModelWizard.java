/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.diagram.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.bpmn.diagram.common.commands.CreateBpmnModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.wizards.CreateModelWizard;
import org.eclipse.ui.IWorkbench;

public class NewBpmnModelWizard extends CreateModelWizard {

	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 *
	 * @param workbench
	 * @param selection
	 */

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New Bpmn Model");
	}

	/**
	 * Instantiates a new new Proteus model wizard.
	 */
	public NewBpmnModelWizard() {
		super();

	}



	@Override
	public String getModelKindName() {
		// TODO Auto-generated method stub

		return "Bpmn Model";
	}

	@Override
	protected String[] getDiagramCategoryIds() {
		return new String[] { CreateBpmnModelCommand.COMMAND_ID };
	}



}
