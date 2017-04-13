/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.uml.CombinedFragment;

/**
 * Get the command to destroy {@link CombinedFragment}.
 */
public class CombinedFragmentDestroyCommand extends AbstractTransactionalCommand {

	/** The element edit service. */
	private IElementEditService provider;

	/** The request to destroy the element. */
	private DestroyElementRequest req;

	/**
	 * 
	 * Constructor.
	 *
	 * @param domain
	 *            the editing domain
	 * @param provider
	 *            the element edit service
	 * @param req
	 *            the destroy element request
	 */
	public CombinedFragmentDestroyCommand(TransactionalEditingDomain domain, IElementEditService provider, DestroyElementRequest req) {
		super(domain, null, null);
		this.provider = provider;
		this.req = req;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ICommand deleteCommand = provider.getEditCommand(req);
		try {
			deleteCommand.execute(monitor, info);
		} catch (ExecutionException e) {
			Activator.log.error(e);
		}
		return CommandResult.newOKCommandResult();
	}
}
