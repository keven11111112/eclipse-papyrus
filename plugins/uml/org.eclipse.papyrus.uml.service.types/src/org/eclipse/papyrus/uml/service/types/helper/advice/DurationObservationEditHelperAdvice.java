/*****************************************************************************
 * Copyright (c) 2018 CEA LIST, EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation
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
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.NamedElement;

public class DurationObservationEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		ICommand composite = new CompositeCommand("After Configure Command of DurationObservation");// $NON-NLS-0$
		ICommand afterConfigureCommand = super.getAfterConfigureCommand(request);
		if (null != afterConfigureCommand && afterConfigureCommand.canExecute()) {
			composite.compose(afterConfigureCommand);
		}

		EObject toConfigure = request.getElementToConfigure();
		if (false == toConfigure instanceof DurationObservation) {
			return composite;
		}

		DurationObservation observation = (DurationObservation) toConfigure;

		// Create the command to initialize the Events (Multiplicity [1..2]
		NamedElement source = getSourceElement(request);
		NamedElement target = getTargetElement(request);

		if (source != null && target != null) {
			final ICommand initConstrainedElements = new AbstractTransactionalCommand(request.getEditingDomain(), "Init DurationObservation events", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					observation.getEvents().add(0, source);
					observation.getEvents().add(1, target);
					return CommandResult.newOKCommandResult();
				}
			};

			composite.compose(initConstrainedElements);
		}

		return composite;
	}

	protected NamedElement getSourceElement(ConfigureRequest request) {
		Object paramObject = request.getParameter(CreateRelationshipRequest.SOURCE);
		if (paramObject instanceof NamedElement) {
			return (NamedElement) paramObject;
		}

		return null;
	}

	protected NamedElement getTargetElement(ConfigureRequest request) {
		Object paramObject = request.getParameter(CreateRelationshipRequest.TARGET);
		if (paramObject instanceof NamedElement) {
			return (NamedElement) paramObject;
		}

		return null;
	}

}
