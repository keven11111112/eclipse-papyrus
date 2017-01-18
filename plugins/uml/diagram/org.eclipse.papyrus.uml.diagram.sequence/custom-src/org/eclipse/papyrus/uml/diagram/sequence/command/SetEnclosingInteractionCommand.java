/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Céline Janssens (cej@all4tec.net) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;

import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

/**
 * @author Céline JANSSENS
 * Command in charge of setting the interaction container of an ExecutionSpecification and its Occurrence specifications
 */
public class SetEnclosingInteractionCommand extends AbstractTransactionalCommand {

	/**
	 * the current Interaction Fragment: Can be {@link ExecutionSpecification} or {@link ExecutionOccurrenceSpecification}
	 */
	private InteractionFragment ift;
	
	/**
	 * The target Interaction which is the new container of ift. Usually is {@link Interaction} or {@link InteractionOperand}.
	 */
	private EObject interactionTarget;


	public SetEnclosingInteractionCommand(final TransactionalEditingDomain ed, final InteractionFragment ift, final EObject interactionTarget) {
		super(ed, "Set enclosing interaction command", null);
		this.ift = ift;
		this.interactionTarget = interactionTarget;
	}

	/**
	 * Set the interaction or interaction operand which contains a fragment
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 *
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		setEnclosingInteraction(ift, interactionTarget, false);
		return CommandResult.newOKCommandResult();
	}


	/**
	 * Set the interaction or interaction operand which contains a fragment
	 *
	 * @param ift
	 *            fragment to update container
	 * @param interaction
	 *            new containing interaction or interaction operand
	 * @param forceIfCoregion
	 *            force the set even if fragment belong to a coregion. Use true only when you are sure the fragment no longer belongs to a coregion's
	 *            operand.
	 */
	protected static void setEnclosingInteraction(InteractionFragment ift, EObject interaction, boolean forceIfCoregion) {
		if (ift != null) {
			if (interaction instanceof Interaction) {
				if (!interaction.equals(ift.getEnclosingInteraction())) {
					// check case when mos looks outside but is in a coregion.
					if (!(ift instanceof MessageOccurrenceSpecification)) {
						ift.setEnclosingOperand(null);
						ift.setEnclosingInteraction((Interaction) interaction);
					} else {
						// If ift is a message check if we have to force the coregion if so, do nothing
						if (!messageOccurenceSpecIsCoregion(ift, forceIfCoregion)) {

							ift.setEnclosingOperand(null);
							ift.setEnclosingInteraction((Interaction) interaction);
						}
					}
				}
			} else if (interaction instanceof InteractionOperand) {
				if (!interaction.equals(ift.getEnclosingOperand())) {
					ift.setEnclosingInteraction(null);
					ift.setEnclosingOperand((InteractionOperand) interaction);
				}
			}
		}
	}

	/**
	 * Check case when Message Occurence Specification (mos) looks outside but is in a coregion
	 * 
	 * @param ift
	 *            Current Interaction Fragment
	 * @param forceIfCoregion
	 *            define if we have to force the modification in case of Coregion
	 */
	protected static boolean messageOccurenceSpecIsCoregion(InteractionFragment ift, boolean forceIfCoregion) {
		boolean coRegion = false;

		if (!forceIfCoregion && ift instanceof MessageOccurrenceSpecification) {
			InteractionOperand operand = ift.getEnclosingOperand();
			if (operand != null) {
				Element cf = operand.getOwner();
				if (cf instanceof CombinedFragment && InteractionOperatorKind.PAR_LITERAL.equals(((CombinedFragment) cf).getInteractionOperator())) {
					// was in a coregion. Check whether other mos is still in the coregion
					Message mess = ((MessageOccurrenceSpecification) ift).getMessage();
					// find other mos
					MessageOccurrenceSpecification otherMos = null;
					if (ift.equals(mess.getSendEvent()) && mess.getReceiveEvent() instanceof MessageOccurrenceSpecification) {
						otherMos = (MessageOccurrenceSpecification) mess.getReceiveEvent();
					} else if (ift.equals(mess.getReceiveEvent()) && mess.getSendEvent() instanceof MessageOccurrenceSpecification) {
						otherMos = (MessageOccurrenceSpecification) mess.getSendEvent();
					}
					if (otherMos != null) {
						// check that it is in a coregion (specific code is in charge of taking it out in ReconnectMessageHelper)
						if (operand.equals(otherMos.getEnclosingOperand())) {
							coRegion = true;
						}
					}
				}
			}
		}
		return coRegion;
	}
}
