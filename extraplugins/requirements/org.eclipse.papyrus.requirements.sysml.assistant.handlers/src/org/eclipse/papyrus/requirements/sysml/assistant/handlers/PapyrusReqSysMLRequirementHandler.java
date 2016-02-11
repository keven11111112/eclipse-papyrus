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
 *     Mauricio Alférez(mauricio.alferez@cea.fr) CEA LIST. - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.requirements.sysml.assistant.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.requirements.sysml.assistant.commands.PapyrusReqSysMLRequirementCreateCommand;
import org.eclipse.papyrus.requirements.common.PapyrusAbstractHandler;
import org.eclipse.uml2.uml.Element;
/**
 * Executes the creation of a new SysML requirement based on the Papyrus Req
 * preferences page.
 *
 */
public class PapyrusReqSysMLRequirementHandler extends PapyrusAbstractHandler {
		public Object execute(ExecutionEvent event) throws ExecutionException {
			super.execute(event);
			Element selectedElement = getSelection();
			if (selectedElement != null) {
				PapyrusReqSysMLRequirementCreateCommand papyrusReqSysMLRequirementCreateCommand = new PapyrusReqSysMLRequirementCreateCommand(
						transactionalEditingDomain, selectedElement);
				transactionalEditingDomain.getCommandStack().execute(papyrusReqSysMLRequirementCreateCommand);
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
