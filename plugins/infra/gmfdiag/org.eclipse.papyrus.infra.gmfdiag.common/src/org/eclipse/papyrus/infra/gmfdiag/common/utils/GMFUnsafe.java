/*
 * Copyright (c) 2014, 2016 CEA, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *
 */
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;


/**
 * Utilities for operations in the GMF context that we might consider as "unsafe" or exceptional cases.
 * 
 * @deprecated use the {@link org.eclipse.papyrus.infra.emf.gmf.util.GMFUnsafe} API, instead.
 */
@Deprecated
public class GMFUnsafe {

	/**
	 * Not instantiable by clients.
	 */
	private GMFUnsafe() {
		super();
	}

	/**
	 * Performs an unsafe write to the model. The editing domain may or may not already have an active transaction, which may or may not be read-only;
	 * it does not matter. In any case, the changes performed will not be recorded for undo/redo or roll-back. Thus, this is appropriate only for use
	 * cases such as synchronization of canonical views, which are not considered logically as abstract model edits (though they be concrete changes).
	 *
	 * @param domain
	 *            an editing domain that may or may not have a transaction in progress
	 * @param writeOperation
	 *            an operation that will make unchecked/unsafe changes to the editing {@code domain}
	 *
	 * @throws RollbackException
	 *             if the unprotected write transaction fails to commit. Note that this could occlude an uncaught exception thrown by the {@code writeOperation} runnable
	 * @throws InterruptedException
	 *             if the current thread is interrupted while waiting for the unprotected write transaction to start
	 */
	public static void write(TransactionalEditingDomain domain, Runnable writeOperation) throws InterruptedException, RollbackException {
		org.eclipse.papyrus.infra.emf.gmf.util.GMFUnsafe.write(domain, writeOperation);
	}

	/**
	 * Executes an unsafe command on the model. The editing domain may or may not already have an active transaction, which may or may not be
	 * read-only; it does not matter. In any case, the changes performed will not be recorded for undo/redo or roll-back. Thus, this is appropriate
	 * only for use cases such as synchronization of canonical views, which are not considered logically as abstract model edits (though they be
	 * concrete changes).
	 *
	 * @param domain
	 *            an editing domain that may or may not have a transaction in progress
	 * @param command
	 *            a command that will make unchecked/unsafe changes to the editing {@code domain}
	 *
	 * @throws RollbackException
	 *             if the unprotected write transaction fails to commit. Note that this could occlude an uncaught exception thrown by the {@code writeOperation} runnable
	 * @throws InterruptedException
	 *             if the current thread is interrupted while waiting for the unprotected write transaction to start
	 *
	 * @see #write(TransactionalEditingDomain, Runnable)
	 */
	public static void write(TransactionalEditingDomain domain, Command command) throws InterruptedException, RollbackException {
		org.eclipse.papyrus.infra.emf.gmf.util.GMFUnsafe.write(domain, command);
	}

	/**
	 * Executes an unsafe command on the model. The editing domain may or may not already have an active transaction, which may or may not be
	 * read-only; it does not matter. In any case, the changes performed will not be recorded for undo/redo or roll-back. Thus, this is appropriate
	 * only for use cases such as synchronization of canonical views, which are not considered logically as abstract model edits (though they be
	 * concrete changes).
	 *
	 * @param domain
	 *            an editing domain that may or may not have a transaction in progress
	 * @param command
	 *            a command that will make unchecked/unsafe changes to the editing {@code domain}
	 *
	 * @throws RollbackException
	 *             if the unprotected write transaction fails to commit. Note that this could occlude an uncaught exception thrown by the {@code writeOperation} runnable
	 * @throws InterruptedException
	 *             if the current thread is interrupted while waiting for the unprotected write transaction to start
	 * @throws ExecutionException
	 *             if the {@code command} fails to execute
	 *
	 * @see #write(TransactionalEditingDomain, Runnable)
	 */
	public static void write(TransactionalEditingDomain domain, ICommand command) throws InterruptedException, RollbackException, ExecutionException {
		org.eclipse.papyrus.infra.emf.gmf.util.GMFUnsafe.write(domain, command);
	}

	/**
	 * Wraps a command for unprotected execution, undo, and redo on the command stack.
	 *
	 * @param domain
	 *            a transactional editing domain on which the {@code command} operates
	 * @param command
	 *            a command to wrap
	 * @return the wrapped command
	 */
	public static Command wrap(TransactionalEditingDomain domain, Command command) {
		return new UnsafeCommandWrapper(domain, command);
	}

	//
	// Nested types
	//

	/**
	 * A useful base class for commands that need to execute, undo, and redo in unprotected mode on the command stack.
	 * 
	 * @deprecated Use the {@link org.eclipse.papyrus.infra.emf.gmf.util.GMFUnsafe.UnsafeCommand} API, instead.
	 */
	@Deprecated
	public static abstract class UnsafeCommand extends org.eclipse.papyrus.infra.emf.gmf.util.GMFUnsafe.UnsafeCommand {

		protected UnsafeCommand(TransactionalEditingDomain domain) {
			super(domain);
		}

		protected UnsafeCommand(TransactionalEditingDomain domain, String label, String description) {
			super(domain, label, description);
		}

		protected UnsafeCommand(TransactionalEditingDomain domain, String label) {
			super(domain, label);
		}
	}

	private static class UnsafeCommandWrapper extends UnsafeCommand {

		private final Command command;

		UnsafeCommandWrapper(TransactionalEditingDomain domain, Command command) {
			super(domain, command.getLabel(), command.getDescription());

			this.command = command;
		}

		@Override
		public void dispose() {
			command.dispose();
		}

		@Override
		public boolean canExecute() {
			return command.canExecute();
		}

		@Override
		protected void doExecute() {
			command.execute();
		}

		@Override
		public boolean canUndo() {
			return command.canUndo();
		}

		@Override
		protected void doUndo() {
			command.undo();
		}

		@Override
		protected void doRedo() {
			command.redo();
		}

		@Override
		public Collection<?> getAffectedObjects() {
			return command.getAffectedObjects();
		}

		@Override
		public Collection<?> getResult() {
			return command.getResult();
		}

		@Override
		public String toString() {
			return String.format("Unsafe(%s)", command.toString()); //$NON-NLS-1$
		}
	}

}
