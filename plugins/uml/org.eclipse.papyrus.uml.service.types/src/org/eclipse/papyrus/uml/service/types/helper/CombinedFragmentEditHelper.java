/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * {@link ElementEditHelper} for {@link CombinedFragment}.
 */
public class CombinedFragmentEditHelper extends ElementEditHelper {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.helper.ElementEditHelper#getConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getConfigureCommand(final ConfigureRequest req) {

		ICommand configureCommand = new ConfigureElementCommand(req) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				CombinedFragment combinedFragment = (CombinedFragment) req.getElementToConfigure();
				InteractionOperand operand = UMLFactory.eINSTANCE.createInteractionOperand();
				combinedFragment.getOperands().add(operand);
				operand.setName(NamedElementUtil.getDefaultNameWithIncrement(operand, operand.getOwner().eContents()));

				return CommandResult.newOKCommandResult(combinedFragment);
			}
		};

		return CompositeCommand.compose(configureCommand, super.getConfigureCommand(req));
	}

}
