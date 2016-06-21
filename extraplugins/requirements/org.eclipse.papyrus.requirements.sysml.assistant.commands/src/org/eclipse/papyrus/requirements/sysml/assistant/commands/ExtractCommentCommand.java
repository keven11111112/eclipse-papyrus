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
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.papyrus.requirements.preferences.PreferenceConstants;
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
		super(domain, "ExtractCommentCommand");
		this.selectedElements = selectedElements;
	}

	protected void createAnnotatedComment(Element owner, String text) {
		Comment comment = owner.createOwnedComment();
		comment.getAnnotatedElements().add(owner);
		comment.setBody(text);
	}

	/**
	 * 
	 * Example: "[stakeHolder1, stakeHolder2] some text" in the text attribute of a requirement,
	 * becomes the text "Stakeholders:[stakeHolder1, stakeHolder2]" in the body of a new comment
	 * of the requirement received as input.
	 * 
	 * @param requirement
	 */
	protected void parseAndExecute(Class requirement) {
		IPreferenceStore store = org.eclipse.papyrus.requirements.preferences.Activator.getDefault().getPreferenceStore();
		String initialChar = store.getString(PreferenceConstants.INITIAL_CHAR);
		String finalChar = store.getString(PreferenceConstants.FINAL_CHAR);
		String meaningOfTextBetweenChars = store.getString(PreferenceConstants.MEANING_OF_TEXT_BETWEEN_CHARS);

		Stereotype reqStereotype = requirement.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
		String text = (String) requirement.getValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT);
		if (text == null)
			return;
		text = text.trim();
		if (text.startsWith(initialChar)) {
			int index = text.indexOf(finalChar);
			String extractedText = text.substring(0, index + 1);
			text = text.substring(index + 1);
			text = text.trim();
			createAnnotatedComment(requirement, meaningOfTextBetweenChars + extractedText);
			requirement.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_TEXT_ATT, text);
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
