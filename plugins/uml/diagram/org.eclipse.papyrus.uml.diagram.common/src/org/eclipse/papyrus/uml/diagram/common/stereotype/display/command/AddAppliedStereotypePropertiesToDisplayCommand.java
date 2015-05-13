/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.stereotype.display.command;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeLocationEnum;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayCommandExecution;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayUtil;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class AddAppliedStereotypeToDisplayCommand used to set the list of applied stereotype to
 * display
 */
public class AddAppliedStereotypePropertiesToDisplayCommand extends RecordingCommand {


	private Property property;
	private Stereotype stereotype;
	private View view;
	private TransactionalEditingDomain domain;
	private String location;

	private static StereotypeDisplayUtil helper = StereotypeDisplayUtil.getInstance();
	private static StereotypeDisplayCommandExecution commandHelper = StereotypeDisplayCommandExecution.getInstance();



	/**
	 * add a new sets the applied stereotype properties to display command.
	 *
	 * @param domain
	 *            the domain
	 * @param object
	 *            the object
	 * @param stereotypeList
	 *            the stereotype list
	 */
	public AddAppliedStereotypePropertiesToDisplayCommand(TransactionalEditingDomain domain, View view,
			Property property, Stereotype stereotype, String location) {
		super(domain, "Display a Stereotype Property");
		this.property = property;
		this.stereotype = stereotype;
		this.domain = domain;
		this.view = view;
		this.location = location;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		View propertyView = null;
		if (StereotypeLocationEnum.IN_COMPARTMENT.equals(location)) {
			propertyView = helper.getStereotypeProperty(view, stereotype, property);
		} else if (StereotypeLocationEnum.IN_BRACE.equals(location)) {
			propertyView = helper.getStereotypePropertyInBrace(view, stereotype, property);
		} else if (StereotypeLocationEnum.IN_COMMENT.equals(location)) {
			propertyView = helper.getStereotypePropertyInComment(view, stereotype, property);
		}

		commandHelper.setUserVisibility(domain, propertyView, true);


	}



}
