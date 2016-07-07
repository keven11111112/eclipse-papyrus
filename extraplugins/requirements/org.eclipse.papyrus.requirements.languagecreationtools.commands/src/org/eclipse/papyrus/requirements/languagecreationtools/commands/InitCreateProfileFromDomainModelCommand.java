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
package org.eclipse.papyrus.requirements.languagecreationtools.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Executes the generation of a profile based on a class diagram according to
 * the preferences page of Papyrus for Requirements
 *
 */
public class InitCreateProfileFromDomainModelCommand extends RecordingCommand {
	protected Element selectedElement;
	TransactionalEditingDomain domain;

	public InitCreateProfileFromDomainModelCommand(TransactionalEditingDomain domain, Element selectedElement) {
		super(domain, "InitCreateProfileFromDomainModelCommand");
		this.selectedElement = selectedElement;
		this.domain = domain;
	}

	@Override
	protected void doExecute() {
		Package sourcePackage = null;
		if (!(selectedElement instanceof Package)) {
			TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());
			dialog.setContentProvider(
					new UMLContentProvider(selectedElement.getModel(), UMLPackage.eINSTANCE.getPackage_NestedPackage()));
			dialog.setLabelProvider(new UMLLabelProvider());
			dialog.setMessage("Choose the domain model");
			dialog.setTitle("Choose the domain model");
			dialog.create();
			dialog.setDescription("Choose the domain model");
			if (dialog.open() == org.eclipse.jface.window.Window.OK) {
				Object[] result = dialog.getResult();
				sourcePackage = ((org.eclipse.uml2.uml.Package) result[0]);
			} else {
				return;
			}
			CreateProfileFromDomainModelCommand createProfileFromDomainModelCommand = new CreateProfileFromDomainModelCommand(
					domain, sourcePackage);
			createProfileFromDomainModelCommand.execute();
		} else {
			sourcePackage = (Package) selectedElement;
			CreateProfileFromDomainModelCommand createProfileFromDomainModelCommand = new CreateProfileFromDomainModelCommand(
					domain, sourcePackage);
			createProfileFromDomainModelCommand.execute();
		}
	}
}