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

package org.eclipse.papyrus.propertylifecycle.helper.advice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.propertylifecycle.Activator;
import org.eclipse.papyrus.propertylifecycle.utils.PropertyLifecycleManager;

/**
 * Advice used to handle the calls for the applications of the {@link org.eclipse.papyrus.propertylifecycle.StrategyElement strategies}
 *
 */
public class PropertyLifecycleHelperAdvice extends AbstractEditHelperAdvice {

	// private HashMap nameMap;

	/**
	 * Access used to edit the contained elements in case of a new container
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterMoveCommand(org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest)
	 *
	 * @param request
	 *            The move request
	 * @return
	 * 		new IStatus.OK command result.
	 */
	@Override
	protected ICommand getAfterMoveCommand(final MoveRequest request) {
		return super.getAfterMoveCommand(request);
		// return new MoveElementsCommand(request) {
		//
		// @Override
		// protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		// Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "moveElements: " + request.getElementsToMove().keySet()
		// + ", in: " + request.getElementsToEdit());
		//
		// for (Object object : request.getElementsToMove().keySet()) {
		// if (!(object instanceof EObject)) {
		// return CommandResult.newOKCommandResult();
		// }
		// EObject element = (EObject) object;
		//
		// if (!(element instanceof NamedElement)) {
		// return CommandResult.newOKCommandResult();
		// }
		// Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "ElementPreviousName: "
		// + element.eGet(element.eClass().getEStructuralFeature("name"), true).toString());
		//
		// NamedElement namedElement = (NamedElement) element;
		// String name = PropertyLifecycleHelper.getAssociatedCreationName(request, element, null);
		//
		// if (name != null) {
		// String initializedName = NamedElementUtil.getDefaultNameWithIncrementFromBase(name, element.eContainer().eContents(), element, "");
		// namedElement.setName(initializedName);
		// Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "ElementNewName: "
		// + element.eGet(element.eClass().getEStructuralFeature("name"), true).toString());
		// } else {
		// Retrieves the default name in case there are no strategy for this (element, container) couple
		// String initializedName = NamedElementUtil.getDefaultNameWithIncrementFromBase(element.eClass().getName(), element.eContainer().eContents());
		// namedElement.setName(initializedName);
		// IElementType umlET = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml." + element.eClass().getName());
		// }
		//
		// }
		//
		// return super.doExecuteWithResult(progressMonitor, info);
		//// return CommandResult.newOKCommandResult();
		// }
		// };
	}


	/**
	 * Access used to edit the values of a reoriented association
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterReorientRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest)
	 *
	 * @param request
	 *            The reorient request
	 * @return
	 * 		new IStatus.OK command result.
	 */
	@Override
	protected ICommand getAfterReorientRelationshipCommand(ReorientRelationshipRequest request) {

		return new EditElementCommand("Lifecycle Reorient Relashionship", request.getRelationship(), request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				PropertyLifecycleManager lifecycleManager = new PropertyLifecycleManager(request, 0);
				ICommand lifecycleStrategyCommand = lifecycleManager.setAssociatedPropertyValues();
				if (lifecycleStrategyCommand != null) {
					if (lifecycleStrategyCommand.canExecute()) {
						lifecycleStrategyCommand.execute(monitor, info);
					}
				}
				return CommandResult.newOKCommandResult(request.getRelationship());
			}
		};

		// ICommand compositeCommand = super.getAfterReorientRelationshipCommand(request);
		// PropertyLifecycleManager lifecycleManager = new PropertyLifecycleManager(request, 0);
		// ICommand lifecycleStrategyCommand = lifecycleManager.setAssociatedPropertyValues();
		// if (lifecycleStrategyCommand != null) {
		// compositeCommand = CompositeCommand.compose(compositeCommand, lifecycleStrategyCommand);
		// }
		//
		// return compositeCommand;
	}


	/**
	 * Access used to edit the values of the currently edited/created element
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 *            The configure request
	 * @return
	 * 		new IStatus.OK command result.
	 */
	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
		// // TEST1 - BEGIN
		// if (element.eResource() instanceof XMIResource) {
		// String xmiID = ((XMIResource) element.eResource()).getID(element);
		// System.err.println(xmiID);
		// }
		// // TEST1 - END

		// The stereotypes are not yet applied at this stage, i.e. wait until execution to filter based on the matchers
		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				PropertyLifecycleManager lifecycleManager = new PropertyLifecycleManager(request, 0);
				ICommand lifecycleStrategyCommand = lifecycleManager.setAssociatedPropertyValues();
				if (lifecycleStrategyCommand != null) {
					if (lifecycleStrategyCommand.canExecute()) {
						lifecycleStrategyCommand.execute(monitor, info);
					}
				}
				return CommandResult.newOKCommandResult(request.getElementToConfigure());
			}
		};
	}


	/**
	 * Access used to edit the values of the currently edited/created element
	 *
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)
	 *
	 * @param request
	 *            The creation request
	 * @return
	 * 		new IStatus.OK command result.
	 */
	@Override
	protected ICommand getAfterCreateCommand(final CreateElementRequest request) {

		// The stereotypes are not yet applied at this stage, i.e. wait until execution to filter based on the matchers
		return new CreateElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				PropertyLifecycleManager lifecycleManager = new PropertyLifecycleManager(request, 0);
				ICommand lifecycleStrategyCommand = lifecycleManager.setAssociatedPropertyValues();
				if (lifecycleStrategyCommand != null) {
					if (lifecycleStrategyCommand.canExecute()) {
						lifecycleStrategyCommand.execute(monitor, info);
					}
				}
				return CommandResult.newOKCommandResult(request.getNewElement());
			}
		};
	}


	/**
	 * Access used to edit the contained elements in case of a modified value of the container
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterSetCommand(org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest)
	 *
	 * @param request
	 *            The editing request
	 * @return
	 * 		The Command wrapping the strategy commands
	 */
	@Override
	protected ICommand getAfterSetCommand(SetRequest request) {
		// EObject element = request.getElementToEdit();
		// if (element instanceof NamedElement) {
		// Activator.log.trace(Activator.PLCSTRATEGY_TRACE, ", name: " + ((NamedElement) element).getName());
		// };

		return new SetValueCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				PropertyLifecycleManager lifecycleManager = new PropertyLifecycleManager(request, 0);
				ICommand lifecycleStrategyCommand = lifecycleManager.setAssociatedPropertyValues();
				if (lifecycleStrategyCommand != null) {
					if (lifecycleStrategyCommand.canExecute()) {
						lifecycleStrategyCommand.execute(monitor, info);
					}
				}
				return CommandResult.newOKCommandResult(request.getElementToEdit());
			};
		};

		// ICommand compositeCommand = super.getAfterSetCommand(request);
		// PropertyLifecycleManager lifecycleManager = new PropertyLifecycleManager(request, 0);
		// ICommand lifecycleStrategyCommand = lifecycleManager.setAssociatedPropertyValues();
		// compositeCommand = CompositeCommand.compose(compositeCommand, lifecycleStrategyCommand);
		// if (lifecycleStrategyCommand != null) {
		// compositeCommand = CompositeCommand.compose(compositeCommand, lifecycleStrategyCommand);
		// }
		//
		// return compositeCommand;
	}

}
