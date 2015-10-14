/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *  Mauricio Alferez (CEA LIST) mauricio.alferez@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.req.bmm.diagram.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.req.bmm.diagram.common.commands.CreateBmmModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.CreateModelWizard;
import org.eclipse.ui.IWorkbench;

/**
 * Wizard to create a new Business Motivation (BMM) model
 *
 */
public class NewBmmModelWizard extends CreateModelWizard {

	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 *
	 * @param workbench
	 * @param selection
	 */

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New BMM Model");
	}

	/**
	 * Instantiates a new new Proteus model wizard.
	 */
	public NewBmmModelWizard() {
		super();

	}

	@Override
	public String getModelKindName() {
		// TODO Auto-generated method stub

		return "BMM Model";
	}

	@Override
	protected String[] getDiagramCategoryIds() {
		return new String[] { CreateBmmModelCommand.COMMAND_ID };
	}

}
