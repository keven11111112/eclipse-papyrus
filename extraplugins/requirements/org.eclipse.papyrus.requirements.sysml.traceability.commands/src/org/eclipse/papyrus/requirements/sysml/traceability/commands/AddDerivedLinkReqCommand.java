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
*     CEA LIST. - initial API and implementation
*******************************************************************************/
package org.eclipse.papyrus.requirements.sysml.traceability.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectionDialog;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.requirements.common.Utils;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * Creates a set of DerivedReq links based on a derived requirement
 */
public class AddDerivedLinkReqCommand extends RecordingCommand {
	protected Element selectedElement;
	TransactionalEditingDomain domain;

	public AddDerivedLinkReqCommand(TransactionalEditingDomain domain, Element selectedElement) {
		super(domain, "AddDerivedLinkReqCommand");
		this.selectedElement = selectedElement;
		this.domain = domain;
	}

	@Override
	protected void doExecute() {
		if (selectedElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
			Stereotype reqStereotype = selectedElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
			final IStaticContentProvider provider = new UMLContentProvider(Utils.getToPackage(selectedElement),
					UMLPackage.eINSTANCE.getPackage_PackagedElement(), reqStereotype);
			
			ReferenceSelector selector = new ReferenceSelector();
			selector.setLabelProvider(new UMLLabelProvider());
			selector.setContentProvider(provider);
			MultipleValueSelectionDialog dialog = new MultipleValueSelectionDialog(
					Display.getDefault().getActiveShell(), selector,
					"Choose the requirements from which this requirement was derived");

			dialog.setLabelProvider(new UMLLabelProvider());

			dialog.create();
			if (dialog.open() == org.eclipse.jface.window.Window.OK) {
				Object[] result = dialog.getResult();

				for (int i = 0; i < result.length; i++) {
					Element currentElement = (Element) result[i];
					if (currentElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
						DerivationReqCreateCommand derivationReqCreateCommand = new DerivationReqCreateCommand(domain,
								(NamedElement) selectedElement, (NamedElement) currentElement);
						derivationReqCreateCommand.execute();
					}
				}
			}
		}
	}
}