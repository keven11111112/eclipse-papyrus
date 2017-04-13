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
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.InteractionOperatorKind;

/**
 * {@link ElementEditHelper} for {@link ConsiderIgnoreFragment}.
 */
public class ConsiderIgnoreFragmentEditHelper extends CombinedFragmentEditHelper {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.helper.CombinedFragmentEditHelper#getConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	protected ICommand getConfigureCommand(final ConfigureRequest req) {
		ICommand configureCommand = new ConfigureElementCommand(req) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				ConsiderIgnoreFragment element = (ConsiderIgnoreFragment) req.getElementToConfigure();
				element.setInteractionOperator(InteractionOperatorKind.IGNORE_LITERAL);

				return CommandResult.newOKCommandResult(element);
			}
		};

		return CompositeCommand.compose(configureCommand, super.getConfigureCommand(req));
	}

}
