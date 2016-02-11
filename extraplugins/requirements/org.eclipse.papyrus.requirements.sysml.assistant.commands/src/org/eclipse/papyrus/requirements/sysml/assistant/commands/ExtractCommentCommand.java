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
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
/**
 * 
 * Parses the text of the requirement and move some parts as comments
 *
 */
public class ExtractCommentCommand extends RecordingCommand {
	protected ArrayList<Element> selectedElements;
	public ExtractCommentCommand(TransactionalEditingDomain domain, ArrayList<Element> selectedElements) {
		super(domain,"ExtractCommentCommand" );
		this.selectedElements=selectedElements;
	}

	protected void createAnnotatedComment(Element owner,String text){
		Comment comment=owner.createOwnedComment();
		comment.getAnnotatedElements().add(owner);
		comment.setBody(text);
	}

	/**
	 * example [stakeHolder1, stakeHolder2]
	 * 
	 * @param req
	 */
	protected void parseAndExecute(Class req) {
		Stereotype reqStereotype = req.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
		String text = (String) req.getValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT);
		if (text == null)
			return;
		text = text.trim();
		if (text.startsWith("[")) {
			// stakeholders detected
			int index = text.indexOf("]");
			String stakeholders = text.substring(0, index + 1);
			text = text.substring(index + 1);
			text = text.trim();
			createAnnotatedComment(req, "Stakeholders:" + stakeholders);
			req.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT, text);
		}
	}

	@Override
	protected void doExecute() {
		for (Iterator<Element> iterator = selectedElements.iterator(); iterator.hasNext();) {
			Element currentElement = (Element) iterator.next();
			if (currentElement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE) != null) {
				parseAndExecute((Class) currentElement);
			}

		}

	}

}
