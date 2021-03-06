/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi  benoit.maggi@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 430701
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.commands.wrappers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.INonDirtying;
import org.eclipse.papyrus.infra.emf.gmf.command.ICommandWrapper;

/**
 * A GEF Command that wraps a GMF command. Each method is redirected to the GMF one.
 */
public class GMFtoGEFCommandWrapper extends Command implements ICommandWrapper<ICommand> {

	/**
	 * The wrapped GMF Command. Package-level visibility so that the command stack wrapper can
	 * access the field.
	 */
	private final ICommand gmfCommand;

	static {
		REGISTRY.registerWrapper(ICommand.class, Command.class,
				GMFtoGEFCommandWrapper::wrap);
		REGISTRY.registerUnwrapper(GMFtoGEFCommandWrapper.class, ICommand.class,
				GMFtoGEFCommandWrapper::getWrappedCommand);
	}


	/**
	 * Constructor.
	 *
	 * @param command
	 *            the wrapped EMF command
	 */
	public GMFtoGEFCommandWrapper(final ICommand command) {
		super(command.getLabel());
		gmfCommand = command;
	}

	/**
	 * Wraps the given {@code command}, accounting for possible non-dirty state.
	 *
	 * @param command
	 *            a command to wrap
	 * @return the best wrapper for the {@code command}
	 */
	public static Command wrap(ICommand command) {
		if (command instanceof INonDirtying) {
			return new NonDirtying(command);
		}
		return new GMFtoGEFCommandWrapper(command);
	}

	/**
	 * Returns the wrapped GMF command.
	 *
	 * @return the GMF command
	 */
	public ICommand getGMFCommand() {
		return gmfCommand;
	}

	@Override
	public ICommand getWrappedCommand() {
		return getGMFCommand();
	}

	/**
	 * Dispose.
	 *
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		gmfCommand.dispose();
	}

	/**
	 * Can execute.
	 *
	 * @return true, if can execute
	 *
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return gmfCommand.canExecute();
	}

	/**
	 * Can undo.
	 *
	 * @return true, if can undo
	 *
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return gmfCommand.canUndo();
	}

	/**
	 * Execute.
	 *
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		try {
			gmfCommand.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	/**
	 * Redo.
	 *
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		try {
			gmfCommand.redo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	/**
	 * Undo.
	 *
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		try {
			gmfCommand.undo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	//
	// Nested types
	//

	/**
	 * A non-dirtying wrapper for non-dirtying commands.
	 */
	public static class NonDirtying extends GMFtoGEFCommandWrapper implements INonDirtying {

		public NonDirtying(ICommand command) {
			super(command);

			if (!(command instanceof org.eclipse.papyrus.infra.emf.gmf.command.INonDirtying)) {
				throw new IllegalArgumentException("Wrapped command is not non-dirtying"); //$NON-NLS-1$
			}
		}

	}
}
