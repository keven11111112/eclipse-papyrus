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

package org.eclipse.papyrus.propertylifecycle.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;

/**
 * End command used to set the value of the edited element through the propertylifecycle strategies
 */
public class LifecycleSetCommand extends AbstractCommand {

	private TransactionalEditingDomain editingDomain;
	private EObject eObject;
	private EStructuralFeature feature;
	private Object value;

	private SetRequest setRequest;
	private GMFtoEMFCommandWrapper emfCommand;

	/**
	 * Constructor.
	 *
	 * @param editingDomain
	 *            The editing domain
	 * @param label
	 *            The label of the command
	 * @param eObject
	 *            The object to edit
	 * @param feature
	 *            The feature to edit
	 * @param value
	 *            The new value to set
	 */
	public LifecycleSetCommand(TransactionalEditingDomain editingDomain, String label,
			EObject eObject, EStructuralFeature feature, Object value) {
		super(label);
		this.editingDomain = editingDomain;
		this.eObject = eObject;
		this.feature = feature;
		this.value = value;
	}

	/**
	 * Constructor.
	 *
	 * @param label
	 *            The label of the command
	 * @param eObject
	 *            The object to edit
	 * @param feature
	 *            The feature to edit
	 * @param value
	 *            The new value to set
	 */
	public LifecycleSetCommand(String label, EObject eObject, EStructuralFeature feature, Object value) {
		this(null, label, eObject, feature, value);
	}


	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		if (editingDomain != null) {
			setRequest = new SetRequest(editingDomain, eObject, feature, value);
		} else {
			setRequest = new SetRequest(eObject, feature, value);
		}

		/** Final ! Should never call the service edit again or else risk a StackOverflow because of it will loop on itself */
		// IElementEditService provider = ElementEditServiceUtils.getCommandProvider(eObject);
		// ICommand createGMFCommand = provider.getEditCommand(setRequest);

		ICommand gmfCommand = new SetValueCommand(setRequest);
		if (gmfCommand == null || gmfCommand instanceof UnexecutableCommand) {
			throw new OperationCanceledException();
		}

		emfCommand = new GMFtoEMFCommandWrapper(gmfCommand);
		emfCommand.execute();

		return gmfCommand.getCommandResult();
	}


	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		emfCommand.redo();
		return null;
	}

	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		emfCommand.undo();
		return null;
	}

	@Override
	public boolean canRedo() {
		return emfCommand != null;
	}

	@Override
	public boolean canUndo() {
		return emfCommand != null;
	}

}
