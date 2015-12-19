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

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.req.sysml.assistant.command.CommentReqCommand;
import org.eclipse.uml2.uml.Element;

/**
 * Executes the creation of a comment with the annotated element filled
 *
 */
public class CommentReqHandler extends PapyrusAbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		ArrayList<Element> selectedElement = getSelectionSet();
		if (selectedElement.size() != 0) {
			CommentReqCommand commentReqCommand = new CommentReqCommand(transactionalEditingDomain, selectedElement);
			transactionalEditingDomain.getCommandStack().execute(commentReqCommand);
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
		ArrayList<Element> selectedElement = getSelectionSet();
		if (selectedElement.size() != 0) {
			return true;
		} else {
			return false;
		}
	}

}