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
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.req.domainModel2Profile.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.req.domainModel2Profile.command.CreateProfileFromDomainModelCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * Executes the generation of an UML profile based on a UML domain model
 * according to the Papyrus Req Preferences
 */
public class CreateProfileFromDomainModelHandler extends PapyrusAbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		Element selectedElement = getSelection();
		if (selectedElement instanceof Package) {
			CreateProfileFromDomainModelCommand createProfileFromDomainModelCommand = new CreateProfileFromDomainModelCommand(
					transactionalEditingDomain, selectedElement);
			transactionalEditingDomain.getCommandStack().execute(createProfileFromDomainModelCommand);
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
		if (selectedElement instanceof Package) {
			return true;
		} else {
			return false;
		}
	}
}