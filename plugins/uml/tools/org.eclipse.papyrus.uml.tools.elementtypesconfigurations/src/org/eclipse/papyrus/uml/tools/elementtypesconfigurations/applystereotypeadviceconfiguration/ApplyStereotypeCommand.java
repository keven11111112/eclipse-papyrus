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
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

public class ApplyStereotypeCommand extends AbstractTransactionalCommand {

	private Stereotype stereotype;

	private Element element;

	private boolean rename;

	/**
	 * @param domain
	 *            editing domain to modify the element
	 * @param element
	 *            the element on which stereotype is applied. Must not be <code>null</code>
	 * @param stereotype
	 *            the stereotype to modify
	 * @param rename
	 */
	public ApplyStereotypeCommand(TransactionalEditingDomain domain, Element element, Stereotype stereotype, boolean rename) {
		super(domain, "Apply Stereotype " + stereotype.getLabel(), getWorkspaceFiles(element));
		this.element = element;
		this.stereotype = stereotype;
		this.rename = rename;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			Object stereotypeApplication = element.applyStereotype(stereotype);
			if (rename && element instanceof NamedElement) {
				if (((NamedElement) element).getNamespace() != null) {
					String newName = NamedElementUtil.getDefaultNameWithIncrementFromBase(stereotype.getName(), ((NamedElement) element).getNamespace().getMembers());
					((NamedElement) element).setName(newName);
				}
			}
			return CommandResult.newOKCommandResult(stereotypeApplication);
		} catch (Throwable t) {
			Activator.log.error(t);
			return CommandResult.newErrorCommandResult(t.getMessage());
		}
	}
}