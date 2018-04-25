/*****************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.List;
import java.util.function.Supplier;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.papyrus.infra.emf.gmf.util.GMFUnsafe;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.RetryingDeferredAction;

/**
 * A command that posts its execution asynchronously on the UI thread
 * and captures its undoable action in the original context to support
 * undo/redo.
 * 
 * @since 5.0
 */
public class AsynchronousCommand extends AbstractCommand {

	private final TransactionalEditingDomain editingDomain;
	private Supplier<ICommand> futureCommand;
	private ICommand actualCommand;

	/**
	 * Initializes me with my label and an asynchronous supplier of the command
	 * to be executed.
	 *
	 * @param label
	 *            my label
	 * @param editingDomain
	 *            my contextual editing domain
	 * @param futureCommand
	 *            a supplier of the command. It will be invoked later on
	 *            the UI thread to compute the command to be executed then and captured
	 *            back into the original context of this GMF command. If the supplied
	 *            command is {@code null}, then it will be asynchronously re-tried
	 *            up to three times
	 */
	public AsynchronousCommand(String label, TransactionalEditingDomain editingDomain, Supplier<ICommand> futureCommand) {
		super(label);

		this.editingDomain = editingDomain;
		this.futureCommand = futureCommand;
	}

	/**
	 * Initializes me with my label, affected filesm, and an asynchronous supplier of the command
	 * to be executed.
	 *
	 * @param label
	 *            my label
	 * @param affectedFiles
	 *            my affected files
	 * @param editingDomain
	 *            my contextual editing domain
	 * @param futureCommand
	 *            a supplier of the command. It will be invoked later on
	 *            the UI thread to compute the command to be executed then and captured
	 *            back into the original context of this GMF command. If the supplied
	 *            command is {@code null}, then it will be asynchronously re-tried
	 *            up to three times
	 */
	public AsynchronousCommand(String label, @SuppressWarnings("rawtypes") List affectedFiles, TransactionalEditingDomain editingDomain, Supplier<ICommand> futureCommand) {
		super(label, affectedFiles);

		this.editingDomain = editingDomain;
		this.futureCommand = futureCommand;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		RetryingDeferredAction.defer(this::captureCommand);
		return CommandResult.newOKCommandResult();
	}

	private boolean captureCommand() {
		this.actualCommand = futureCommand.get();

		if (actualCommand != null) {
			if (!actualCommand.canExecute()) {
				// Don't try again
				actualCommand = UnexecutableCommand.INSTANCE;
			} else {
				try {
					// Execute it, now
					GMFUnsafe.write(editingDomain, actualCommand);
				} catch (InterruptedException | RollbackException | ExecutionException e) {
					UMLDiagramEditorPlugin.log.error("Asynchronous command failed.", e);
					// Don't try again
					actualCommand = UnexecutableCommand.INSTANCE;
				}
			}
		}

		return actualCommand != null;
	}

	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		if (actualCommand == null) {
			return CommandResult.newErrorCommandResult("Command execution was not captured"); //$NON-NLS-1$
		} else if (!actualCommand.canRedo()) {
			return CommandResult.newCancelledCommandResult();
		}
		actualCommand.redo(progressMonitor, info);
		return actualCommand.getCommandResult();
	}

	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		if (actualCommand == null) {
			return CommandResult.newErrorCommandResult("Command execution was not captured"); //$NON-NLS-1$
		} else if (!actualCommand.canUndo()) {
			return CommandResult.newCancelledCommandResult();
		}

		actualCommand.undo(progressMonitor, info);
		return actualCommand.getCommandResult();
	}

}
