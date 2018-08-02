/*****************************************************************************
 * Copyright (c) 2010, 2018 CEA LIST, EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 * 		EclipseSource - Bug 537562
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;


import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * @since 3.0
 */
public class GeneralOrderingHelperAdvice extends AbstractOccurrenceLinkEditHelperAdvice {

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		ICommand composite = new CompositeCommand("After Configure Command of GeneralOrdering");// $NON-NLS-0$
		ICommand afterConfigureCommand = super.getAfterConfigureCommand(request);
		if (null != afterConfigureCommand && afterConfigureCommand.canExecute()) {
			composite.compose(afterConfigureCommand);
		}

		EObject toConfigure = request.getElementToConfigure();
		if (false == toConfigure instanceof GeneralOrdering) {
			return composite;
		}

		GeneralOrdering generalOrdering = (GeneralOrdering) toConfigure;

		// Create the command to initialize the Before and After values
		Element source = getSourceElement(request);
		Element target = getTargetElement(request);

		if (source instanceof OccurrenceSpecification && target instanceof OccurrenceSpecification) {
			final ICommand initOrderedElements = new AbstractTransactionalCommand(request.getEditingDomain(), "Init GeneralOrdering ordered elements", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					generalOrdering.setBefore((OccurrenceSpecification) source);
					generalOrdering.setAfter((OccurrenceSpecification) target);
					return CommandResult.newOKCommandResult();
				}
			};

			composite.compose(initOrderedElements);
		}

		return composite;
	}

	@Override
	protected Element getCreationContainer(Element targetElement) {
		return findInteraction(targetElement);
	}

	protected Interaction findInteraction(Element source) {
		Element element = source;
		while (element != null) {
			if (element instanceof Interaction) {
				return (Interaction) element;
			}
			element = element.getOwner();
		}
		return null;
	}


}
