/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 460356 : Refactor Stereotype Display
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.stereotype;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * @author Céline JANSSENS
 *
 */
public class CreateAppliedStereotypeCommentContentCommand extends RecordingCommand {

	private StereotypeDisplayHelper helper = StereotypeDisplayHelper.getInstance();

	private Node appliedStereotypeComment;
	private GraphicalEditPart host;
	private Node originalCompartment;

	/**
	 * Constructor.
	 *
	 */
	public CreateAppliedStereotypeCommentContentCommand(TransactionalEditingDomain domain, String name) {
		super(domain, name);
	}

	/**
	 * Constructor.
	 * 
	 * @param stereotypeApplication
	 *
	 */
	public CreateAppliedStereotypeCommentContentCommand(String name, Node appliedStereotypeComment, GraphicalEditPart host, Node compartment) {
		super(host.getEditingDomain(), name);
		this.appliedStereotypeComment = appliedStereotypeComment;
		this.host = host;
		this.originalCompartment = compartment;

	}


	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {

		// if it has to be displayed into the comment

		BasicCompartment compartmentComment = helper.getStereotypeCompartment(appliedStereotypeComment, originalCompartment.getElement());

		if (helper.isStereotypeCompartment(originalCompartment)) {

			if (compartmentComment == null) {

				boolean visibility = !isCommentEmpty((BasicCompartment) originalCompartment);
				BasicCompartment compartmentCopy = EcoreUtil.copy((BasicCompartment) originalCompartment); // Copy the compartment into the Comment EditPart
				compartmentCopy.setVisible(visibility);
				ViewUtil.insertChildView(appliedStereotypeComment, compartmentCopy, ViewUtil.APPEND, true);

			}
		}

	}

	/**
	 * Define if the Comment is empty and should be displayed.
	 * 
	 * @param compartment
	 *            The Compartment view
	 * @return false by default, true if properties displayed in Brace and in Compartment Comment are empty
	 */
	private boolean isCommentEmpty(BasicCompartment compartment) {
		boolean commentEmpty = false;

		if ((helper.isEmpty(compartment, StereotypeLocationEnum.IN_COMMENT_BRACE))
				&& (helper.isEmpty(compartment, StereotypeLocationEnum.IN_COMMENT_COMPARTMENT))) {
			commentEmpty |= true;

		}
		return commentEmpty;
	}


}
