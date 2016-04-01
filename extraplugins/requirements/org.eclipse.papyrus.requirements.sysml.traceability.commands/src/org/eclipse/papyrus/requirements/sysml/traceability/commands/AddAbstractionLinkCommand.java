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
 * 		Patrick.Tessier (patrick.tessier@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.sysml.traceability.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectionDialog;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.requirements.common.Utils;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * Creates a set of Verify links base on a selected model element
 */
public class AddAbstractionLinkCommand extends RecordingCommand {
	protected Element selectedElement;
	TransactionalEditingDomain domain;

	public AddAbstractionLinkCommand(TransactionalEditingDomain domain, Element selectedElement) {
		super(domain, "Add Abstraction Link Command");
		this.selectedElement = selectedElement;
		this.domain = domain;
	}

	@Override
	protected void doExecute() {
		// open Tree selection dialog
		final IStaticContentProvider provider = new UMLContentProvider(Utils.getToPackage(selectedElement), UMLPackage.eINSTANCE.getPackage_PackagedElement());
		ReferenceSelector selector = new ReferenceSelector();
		selector.setLabelProvider(new UMLLabelProvider());
		selector.setContentProvider(provider);
		MultipleValueSelectionDialog dialog = new MultipleValueSelectionDialog(Display.getDefault().getActiveShell(), selector, "Choose the NamedElement that this model element realize");

		dialog.setLabelProvider(new UMLLabelProvider());
		dialog.create();
		if (dialog.open() == org.eclipse.jface.window.Window.OK) {
			Object[] result = dialog.getResult();

			for (int i = 0; i < result.length; i++) {
				Element currentElement = (Element) result[i];
				AbstractionCreateCommand verifyCreateCommand = new AbstractionCreateCommand(domain, (NamedElement) selectedElement, (NamedElement) currentElement);
				verifyCreateCommand.execute();
			}
		}
	}
}