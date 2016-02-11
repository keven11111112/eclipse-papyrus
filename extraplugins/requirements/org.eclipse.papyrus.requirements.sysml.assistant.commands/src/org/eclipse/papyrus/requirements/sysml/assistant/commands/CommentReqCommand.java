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
package org.eclipse.papyrus.requirements.sysml.assistant.commands;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
/**
 * 
 * Parses the text of the requirement and move some parts as comment
 *
 */
public class CommentReqCommand extends RecordingCommand {
	protected ArrayList<Element> selectedElements;
	public CommentReqCommand(TransactionalEditingDomain domain, ArrayList<Element> selectedElements) {
		super(domain,"CommentReqCommand" );
		this.selectedElements=selectedElements;
	}

	protected void createAnnotatedComment(Element owner,String text){
		Comment comment=owner.createOwnedComment();
		comment.getAnnotatedElements().add(owner);
		comment.setBody(text);
	}

	
	@Override
	protected void doExecute() {
		for (Iterator<Element> iterator = selectedElements.iterator(); iterator.hasNext();) {
			Element currentElement = (Element) iterator.next();
				createAnnotatedComment(currentElement, "COMMENTS:\n");

		}

	}

}
