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
package org.eclipse.papyrus.requirements.sysml.traceability.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.requirements.common.PapyrusAbstractHandler;
import org.eclipse.papyrus.requirements.sysml.traceability.commands.AddSatisfiesLinkCommand;
import org.eclipse.papyrus.requirements.sysml.traceability.commands.SatisfyCreateCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Executes the addition of Satisfy links based on a selected model element
 * 
 */
public class AddSatisfiesLinkHandler extends PapyrusAbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		ArrayList<Element> selectedElements = getSelectionSet();
		if (selectedElements.size() == 2) {
			SatisfyCreateCommand addSatisfyCreateCommand = new SatisfyCreateCommand(transactionalEditingDomain,
					(NamedElement) selectedElements.get(0), (NamedElement) selectedElements.get(1));
			transactionalEditingDomain.getCommandStack().execute(addSatisfyCreateCommand);
		} else {
			Element selectedElement = getSelection();
			if (selectedElement != null) {
				AddSatisfiesLinkCommand addSatisfiesLinkCommand = new AddSatisfiesLinkCommand(
						transactionalEditingDomain, selectedElement);
				transactionalEditingDomain.getCommandStack().execute(addSatisfiesLinkCommand);
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return true if the handler is possible
	 */
	@Override
	public boolean isEnabled() {
		Element selectedElement = getSelection();
		if (selectedElement != null) {
			return true;
		} else {
			return false;
		}
	}

}