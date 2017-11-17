/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The command to replace execution specification start/finish event when a message is drag to it.
 * 
 * @since 5.0.0
 */
public class ReplaceExecSpecEventAtReconnectCommand extends AbstractTransactionalCommand {
	/**
	 * The reconnect message.
	 */
	private final ReconnectRequest request;

	/**
	 * The {@link OccurrenceSpecification} to be replaced.
	 */
	private final OccurrenceSpecification os;

	/**
	 * Set to true if it is a reconnect source, false for reconnect target.
	 */
	private boolean source;

	/**
	 * Constructor.
	 *
	 * @param domain
	 *            The {@link TransactionalEditingDomain}.
	 * @param request
	 *            The {@link ReconnectRequest}.
	 * @param os
	 *            the {@link OccurrenceSpecification}.
	 * @param source
	 *            True if it is a reconnect source, false for reconnect target.
	 */
	public ReplaceExecSpecEventAtReconnectCommand(final TransactionalEditingDomain domain, final ReconnectRequest request, final OccurrenceSpecification os, final boolean source) {
		super(domain, "replace execution specification event command", null);
		this.request = request;
		this.os = os;
		this.source = source;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		// get the message
		EObject message = ((View) request.getConnectionEditPart().getModel()).getElement();
		if (message instanceof Message) {
			// get the correct event to set
			MessageEnd eventToSet = source ? ((Message) message).getSendEvent() : ((Message) message).getReceiveEvent();

			// get the feature to set of the exec spec
			EReference executionSpecificationFeatureToSet = null;
			if (((ExecutionOccurrenceSpecification) os).getExecution().getStart().equals(os)) {
				executionSpecificationFeatureToSet = UMLPackage.eINSTANCE.getExecutionSpecification_Start();
			} else {
				executionSpecificationFeatureToSet = UMLPackage.eINSTANCE.getExecutionSpecification_Finish();
			}

			// replace the os event by the message event
			SetCommand setCommand = new SetCommand(getEditingDomain(), ((ExecutionOccurrenceSpecification) os).getExecution(), executionSpecificationFeatureToSet, eventToSet);
			setCommand.execute();

			// delete the old os event
			org.eclipse.emf.common.command.Command deleteCommand = DeleteCommand.create(getEditingDomain(), os);
			if (deleteCommand != null && deleteCommand.canExecute()) {
				getEditingDomain().getCommandStack().execute(deleteCommand);
			}
		}
		return CommandResult.newOKCommandResult();
	}
}