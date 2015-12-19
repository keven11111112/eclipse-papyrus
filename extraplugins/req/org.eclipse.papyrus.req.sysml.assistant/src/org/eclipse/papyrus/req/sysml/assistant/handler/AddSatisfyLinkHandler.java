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
package org.eclipse.papyrus.req.sysml.assistant.handler;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.req.sysml.assistant.command.AddSatisfyLinkCommand;
import org.eclipse.papyrus.req.sysml.assistant.command.SatisfyCreateCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Executes the addition of Satisfy links
 * 
 */
public class AddSatisfyLinkHandler extends PapyrusAbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		ArrayList<Element> selectedElements = getSelectionSet();
		if (selectedElements.size() == 2) {
			SatisfyCreateCommand addSatisfyCreateCommand = new SatisfyCreateCommand(transactionalEditingDomain,
					(NamedElement) selectedElements.get(1), (NamedElement) selectedElements.get(0));
			transactionalEditingDomain.getCommandStack().execute(addSatisfyCreateCommand);
		} else {

			Element selectedElement = getSelection();
			if (selectedElement != null) {
				AddSatisfyLinkCommand addAddSatisfyLinkCommand = new AddSatisfyLinkCommand(transactionalEditingDomain,
						selectedElement);
				transactionalEditingDomain.getCommandStack().execute(addAddSatisfyLinkCommand);
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