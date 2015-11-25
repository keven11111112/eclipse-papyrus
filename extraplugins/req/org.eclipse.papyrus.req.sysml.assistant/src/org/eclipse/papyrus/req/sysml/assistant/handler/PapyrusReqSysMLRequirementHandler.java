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
 *     Patrick Tessier (patrick.tessier@cea.fr) CEA LIST. - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.req.sysml.assistant.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.req.sysml.assistant.command.PapyrusReqSysMLRequirementCreateCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * Executes the creation of a new SysML requirement based on the Papyrus Req
 * preferences page.
 *
 */
public class PapyrusReqSysMLRequirementHandler extends PapyrusAbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		Element selectedElement = getSelection();
		if (selectedElement instanceof Package) {
			PapyrusReqSysMLRequirementCreateCommand darwinRequirementCommand = new PapyrusReqSysMLRequirementCreateCommand(
					transactionalEditingDomain, selectedElement);
			transactionalEditingDomain.getCommandStack().execute(darwinRequirementCommand);
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
		}

		else {
			return false;
		}
	}

}