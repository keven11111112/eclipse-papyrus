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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.req.sysml.assistant.command.InitDecomposeReqCommand;
import org.eclipse.uml2.uml.Element;

/**
 * Executes the decomposition of a parent requirement to create a new child
 * requirement with a name based on its ancestors as defined in the Papyrus Req
 * preferences page.
 *
 */
public class DecomposeReqHandler extends PapyrusAbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		Element selectedElement = getSelection();
		if (selectedElement != null) {
			InitDecomposeReqCommand decomposeReqCommand = new InitDecomposeReqCommand(transactionalEditingDomain,
					selectedElement);
			transactionalEditingDomain.getCommandStack().execute(decomposeReqCommand);
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