/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Francois Le Fevre (CEA LIST) francois.le-fevre@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.dnd;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * A generic class to gather shared code for Drag and Drop functionality
 *
 *
 */
//TODO to move in dnd plugin and rename the variable 
public abstract class GenericCreateTAndUpdateCommand<T extends EObject ,E extends EObject, S extends EObject> extends AbstractCommand implements InterfaceCreateTAndUpdateCommand{

	protected final EditPart targetEditPart;
	protected final boolean headless;
	protected final Class<T> typeParameterClass;
	protected final E targetElementDiagram;
	protected final S sourceElement;
	private final IHintedType typeToCreate;

	public GenericCreateTAndUpdateCommand(EditPart targetEditPart,  Class<T> typeParameterClass, E targetElementDiagram, S sourceElement, boolean headless, IHintedType typeToCreate) {
		super("Create");

		this.targetEditPart = targetEditPart;
		this.headless = headless;
		this.typeParameterClass = typeParameterClass;
		
		this.targetElementDiagram = targetElementDiagram;
		this.sourceElement = sourceElement;
		this.typeToCreate = typeToCreate;
		
	}

	protected T getNewEObject(CreateElementRequest request) {
		if(typeParameterClass.isAssignableFrom(request.getNewElement().getClass())){
			return (T) request.getNewElement();
		}
		return null;
	}

	/**
	 * Retrieves the new object from a CommandResult
	 * @param commandResult
	 * @return
	 */
	public T getNewEObject(CommandResult commandResult) {
		Object objectResult = commandResult.getReturnValue();
		if (objectResult instanceof List) {
			// Result of the semantic + graphical creation command
			List<?> listResult = (List<?>) objectResult;
			for (Object elementResult : listResult) {
				if (elementResult instanceof CreateElementRequestAdapter) {
					CreateElementRequest request = (CreateElementRequest) ((CreateElementRequestAdapter) elementResult).getAdapter(CreateElementRequest.class);
					if (request != null) {
						EObject newElement = request.getNewElement();
						if(typeParameterClass.isAssignableFrom(newElement.getClass())){
							T newObject = (T) newElement;
							return newObject;
						}
					}
				}
			}
		} else if(typeParameterClass.isAssignableFrom(commandResult.getReturnValue().getClass())){
			// Result of the semantic creation command
			return (T) commandResult.getReturnValue();
		}

		return null;
	}


	/**
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		// Creates the slot
		TransactionalEditingDomain domain = (TransactionalEditingDomain) EMFHelper.resolveEditingDomain(targetEditPart);
		CreateElementRequest createElementRequest = new CreateElementRequest(domain, targetElementDiagram, typeToCreate);
		ICommand creationElementCommand;

		creationElementCommand = new CreateElementCommand(createElementRequest);

		creationElementCommand.execute(new NullProgressMonitor(), null);

		CommandResult commandResult = creationElementCommand.getCommandResult();
		if (commandResult != null) {
			if (!commandResult.getStatus().isOK()) {
				return commandResult;
			}
		}

		// Retrieve the created slot, and update its properties
		T newCallBehaviorAction = getNewEObject(commandResult);
		if (newCallBehaviorAction == null) {
			newCallBehaviorAction = getNewEObject(createElementRequest);
		}

		if (newCallBehaviorAction != null) {
			updateNewlyCreatedEObjectWithEObjectDragged(newCallBehaviorAction, sourceElement);
		} else {
			return CommandResult.newErrorCommandResult("Could not create the calloperation for operation");
		}

		return CommandResult.newOKCommandResult();
	}

	/**
	 * Sets the slot's property (definingFeature) and initialize its value (property#defaultValue)
	 * @param slot
	 * @param property
	 * @throws ExecutionException
	 */
	protected abstract void updateNewlyCreatedEObjectWithEObjectDragged(T slot, S property) throws ExecutionException;
	
	/**
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doRedoWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		
		throw new ExecutionException("not implemented");
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doUndoWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		
		throw new ExecutionException("not implemented");
	}

}
