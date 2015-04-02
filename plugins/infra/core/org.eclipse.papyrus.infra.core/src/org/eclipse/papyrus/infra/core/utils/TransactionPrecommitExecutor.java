/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.core.utils;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomainEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomainListener;
import org.eclipse.emf.transaction.impl.EMFCommandTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalCommandStack;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.core.Activator;

import com.google.common.collect.Maps;

/**
 * An {@link Executor} that executes {@link Runnable}s at the pre-commit phase of the active
 * write transaction of a {@link TransactionalEditingDomain} or at some other time if no
 * write transaction is active.
 */
class TransactionPrecommitExecutor implements Executor, TransactionalEditingDomainListener {
	private final Executor fallback;

	private final AtomicBoolean writeActive = new AtomicBoolean();
	private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
	private final Map<?, ?> options;

	TransactionPrecommitExecutor(TransactionalEditingDomain domain, Executor fallback, Map<?, ?> options) {
		super();

		this.fallback = fallback;
		this.options = ((options != null) && options.isEmpty()) ? null : options;

		TransactionUtil.getAdapter(domain, TransactionalEditingDomain.Lifecycle.class).addTransactionalEditingDomainListener(this);
	}

	@Override
	public void execute(Runnable command) {
		if (writeActive.get()) {
			queue.offer(command);
		} else {
			fallback.execute(command);
		}
	}

	//
	// Editing Domain Lifecycle handling
	//

	@Override
	public void editingDomainDisposing(TransactionalEditingDomainEvent event) {
		queue.clear();
	}

	//
	// Transaction lifecycle handling
	//

	@Override
	public void transactionStarted(TransactionalEditingDomainEvent event) {
		writeActive.set(!event.getTransaction().isReadOnly());
	}

	@Override
	public void transactionClosed(TransactionalEditingDomainEvent event) {
		writeActive.set(false);

		if (queue.peek() != null) {
			// Punt the remaining tasks
			for (Runnable next = queue.poll(); next != null; next = queue.poll()) {
				fallback.execute(next);
			}
		}
	}

	@Override
	public void transactionStarting(TransactionalEditingDomainEvent event) {
		// Pass
	}

	@Override
	public void transactionInterrupted(TransactionalEditingDomainEvent event) {
		// Pass
	}

	@Override
	public void transactionClosing(TransactionalEditingDomainEvent event) {
		if (queue.peek() != null) {
			// Inject tasks into the transaction as a trigger command
			Command trigger = new RecordingCommand(event.getSource(), "Deferred Tasks") {

				@Override
				protected void doExecute() {
					for (Runnable next = queue.poll(); next != null; next = queue.poll()) {
						try {
							next.run();
						} catch (Exception e) {
							Activator.log.error("Uncaught exception in transaction pre-commit task.", e); //$NON-NLS-1$
						}
					}
				}
			};

			final Transaction transaction = event.getTransaction();
			final Command triggeringCommand;
			if (transaction instanceof EMFCommandTransaction) {
				triggeringCommand = ((EMFCommandTransaction) transaction).getCommand();
			} else {
				triggeringCommand = null;
			}

			final InternalTransactionalCommandStack stack = (InternalTransactionalCommandStack) event.getSource().getCommandStack();
			try {
				Map<?, ?> options = transaction.getOptions();
				Map<Object, Object> mergedOptions = null;

				if (this.options != null) {
					options = (mergedOptions == null) ? (mergedOptions = Maps.newHashMap(options)) : mergedOptions;
					mergedOptions.putAll(this.options);
				}
				if (transaction.isReadOnly()) {
					// Must use an unprotected write transaction
					options = (mergedOptions == null) ? (mergedOptions = Maps.newHashMap(options)) : mergedOptions;
					mergedOptions.put(Transaction.OPTION_UNPROTECTED, true);
				}

				stack.executeTriggers(triggeringCommand, Collections.singletonList(trigger), options);
			} catch (Exception e) {
				Activator.log.error("Failed to execute transaction pre-commit tasks.", e); //$NON-NLS-1$
			}
		}
	}

}
