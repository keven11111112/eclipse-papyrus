/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Mauricio Alférez (mauricio.alferez@cea.fr) CEA LIST. - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.req.sysml.assistant.command;

import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.req.domainModel2Profile.command.CreateProfileFromDomainModelCommand;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Executes the wizard to create specializations of SysML
 *
 */
public class InitDefineDomainSpecificRequirementsConceptsCommand extends RecordingCommand {
	protected Element selectedElement;
	TransactionalEditingDomain domain;

	public InitDefineDomainSpecificRequirementsConceptsCommand(TransactionalEditingDomain domain, Element selectedElement) {
		super(domain, "InitDefineDomainSpecificRequirementsConceptsCommand");
		this.selectedElement = selectedElement;
		this.domain = domain;
	}

	@Override
	protected void doExecute() {
		org.eclipse.uml2.uml.Package sourcePackage = null;
		if (selectedElement instanceof Package) {
			org.eclipse.uml2.uml.Package _package = (Package) selectedElement;

			TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());
			dialog.setContentProvider(
					new UMLContentProvider(_package, UMLPackage.eINSTANCE.getPackage_NestedPackage()));
			dialog.setLabelProvider(new UMLLabelProvider());
			dialog.setMessage("Choose the source model");
			dialog.setTitle("Choose the source model");
			dialog.create();
			dialog.setDescription("Choose the source model");
			if (dialog.open() == org.eclipse.jface.window.Window.OK) {
				Object[] result = dialog.getResult();
				sourcePackage = ((org.eclipse.uml2.uml.Package) result[0]);
			} else
				return;
			CreateProfileFromDomainModelCommand createProfileFromDomainModelCommand = new CreateProfileFromDomainModelCommand(
					domain, sourcePackage);
			createProfileFromDomainModelCommand.execute();

		}
	}
}