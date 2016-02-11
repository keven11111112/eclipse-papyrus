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
package org.eclipse.papyrus.requirements.languagecreationtools.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.requirements.common.PapyrusAbstractHandler;
import org.eclipse.papyrus.requirements.languagecreationtools.commands.InitCreateProfileFromDomainModelCommand;
import org.eclipse.uml2.uml.Element;

/**
 * Executes the generation of a profile based on a class diagram according to
 * the preferences page of Papyrus Req
 *
 */
public class InitCreateInitialProfileFromDomainModelHandler extends PapyrusAbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		Element selectedElement = getSelection();
		if (selectedElement != null) {
			InitCreateProfileFromDomainModelCommand initCreateProfileFromDomainModelCommand = new InitCreateProfileFromDomainModelCommand(
					transactionalEditingDomain, selectedElement);
			transactionalEditingDomain.getCommandStack().execute(initCreateProfileFromDomainModelCommand);
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