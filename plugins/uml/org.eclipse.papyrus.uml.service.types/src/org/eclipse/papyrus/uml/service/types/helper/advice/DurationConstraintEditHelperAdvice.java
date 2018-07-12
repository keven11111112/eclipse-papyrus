/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) - vincent.lorenzo@cea.fr - bug 527259
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
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @since 3.0
 *
 */
public class DurationConstraintEditHelperAdvice extends AbstractEditHelperAdvice {


	/**
	 * Add Duration value to the created Duration Interval
	 * Set name with prefix
	 * 
	 * @param durationInterval
	 */
	private void initDurationInterval(final DurationInterval durationInterval) {
		// create, add and set the min and max duration of the duration interval
		org.eclipse.uml2.uml.Package parent = durationInterval.getNearestPackage();
		Duration minDuration = UMLFactory.eINSTANCE.createDuration();
		Duration maxDuration = UMLFactory.eINSTANCE.createDuration();

		parent.getPackagedElements().add(minDuration);
		parent.getPackagedElements().add(maxDuration);

		String nameMin = NamedElementUtil.getDefaultNameWithIncrement("Min", minDuration, minDuration.getNearestPackage().getPackagedElements());// $NON-NLS-0$
		String nameMax = NamedElementUtil.getDefaultNameWithIncrement("Max", maxDuration, maxDuration.getNearestPackage().getPackagedElements());// $NON-NLS-0$
		minDuration.setName(nameMin);
		maxDuration.setName(nameMax);

		durationInterval.setMin(minDuration);
		durationInterval.setMax(maxDuration);
		minDuration.setExpr(UMLFactory.eINSTANCE.createLiteralInteger());
		maxDuration.setExpr(UMLFactory.eINSTANCE.createLiteralInteger());
	}


	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	public ICommand getAfterEditCommand(final IEditCommandRequest request) {

		ICommand composite = new CompositeCommand("After Edit Command of DurationConstraint");// $NON-NLS-0$

		if (null != super.getAfterEditCommand(request) && super.getAfterEditCommand(request).canExecute()) {
			composite.compose(super.getAfterEditCommand(request));
		}

		// Create the command to initialize Duration Interval in case of Duration Constraint
		final ICommand command = new AbstractTransactionalCommand(request.getEditingDomain(), "Init DurationConstraint", null) {// $NON-NLS-0$

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				if (request instanceof ConfigureRequest) {
					ConfigureRequest configRequest = (ConfigureRequest) request;
					EObject element = configRequest.getElementToConfigure();
					if (element instanceof DurationConstraint) {
						if (((DurationConstraint) element).getSpecification() instanceof DurationInterval) {
							// initialize Duration Interval
							initDurationInterval((DurationInterval) ((DurationConstraint) element).getSpecification());
						}
					}
				}
				return CommandResult.newOKCommandResult();

			}
		};


		if (command.canExecute()) {
			composite.compose(command);
		}
		return composite;
	}

}
