/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class SetStereotypeValueCommand extends AbstractTransactionalCommand {

	private Element element;
	private Stereotype stereotype;
	private String featureName;
	private Object featureValue;

	/**
	 * Default Constructor
	 * 
	 * @param domain
	 *            editing domain to modify the element
	 * @param element
	 *            the element on which stereotype is applied. Must not be <code>null</code>
	 * @param stereotype
	 *            the stereotype to modify
	 * @param featureName
	 *            name of the stereotype feature to modify
	 * @param featureValue
	 *            the new value for the stereotype feature value
	 */
	public SetStereotypeValueCommand(TransactionalEditingDomain domain, Element element, Stereotype stereotype, String featureName, Object featureValue) {
		super(domain, "Set stereotype  value " + featureName, getWorkspaceFiles(element.getStereotypeApplication(stereotype)));
		this.element = element;
		this.stereotype = stereotype;
		this.featureName = featureName;
		this.featureValue = featureValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			element.setValue(stereotype, featureName, featureValue);
		} catch (Throwable t) {
			Activator.log.error(t);
			return CommandResult.newErrorCommandResult(t.getMessage());
		}

		return CommandResult.newOKCommandResult(element.getValue(stereotype, featureName));
	}

}