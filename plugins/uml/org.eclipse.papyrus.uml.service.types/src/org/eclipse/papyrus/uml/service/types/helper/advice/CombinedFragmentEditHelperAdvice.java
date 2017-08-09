/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This allows to manage the combined fragment creation with an interaction operand at the same moment.
 * 
 * @since 3.0
 */
public class CombinedFragmentEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {
		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				final CombinedFragment combinedFragment = (CombinedFragment) request.getElementToConfigure();

				// Create InteractionOperand
				final InteractionOperand interactionOperand = createInteractionOperand();
				interactionOperand.setName(NamedElementUtil.getDefaultNameWithIncrement(interactionOperand, combinedFragment.eContents()));
				combinedFragment.getOperands().add(interactionOperand);

				return CommandResult.newOKCommandResult(combinedFragment);
			}

		};
	}

	/**
	 * Create an interaction operand.
	 */
	public static InteractionOperand createInteractionOperand() {
		final InteractionOperand interactionOperand = UMLFactory.eINSTANCE.createInteractionOperand();
		interactionOperand.createGuard("guard"); //$NON-NLS-1$
		return interactionOperand;
	}

}
