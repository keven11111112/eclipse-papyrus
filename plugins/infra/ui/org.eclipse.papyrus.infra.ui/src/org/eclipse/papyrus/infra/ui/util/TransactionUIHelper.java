/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bugs 465416, 498140
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.util;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.operation.IRunnableWithProgress;


/**
 * Helper utilities for working with transactions on the UI thread.
 * 
 * @since 1.2
 */
public class TransactionUIHelper {

	/**
	 * <p>
	 * Create a privileged runnable with progress, which is like a regular {@linkplain TransactionalEditingDomain#createPrivilegedRunnable(Runnable)
	 * privileged runnable} except that it is given a progress monitor for progress reporting.
	 * This enables execution of monitored runnables on the modal-context thread using the transaction borrowed from the UI thread.
	 * </p>
	 * <b>Note</b> that a privileged progress-runnable can be used only once. Because it has the
	 * context of a borrowed transaction, repeated execution is invalid because the required
	 * transaction context will have expired. Attempting to run a privileged runnable a second
	 * time will throw an {@link IllegalStateException}.
	 * </p>
	 * 
	 * @param domain
	 *            an editing domain
	 * @param runnable
	 *            a runnable with progress that is to borrow the {@code domain}'s active transaction on the modal context thread
	 * @return the privileged runnable, ready to pass into the progress service or other such API
	 */
	public static IRunnableWithProgress createPrivilegedRunnableWithProgress(TransactionalEditingDomain domain, final IRunnableWithProgress runnable) {
		final IProgressMonitor monitorHolder[] = { null };

		Runnable privileged = domain.createPrivilegedRunnable(new Runnable() {

			@Override
			public void run() {
				try {
					runnable.run(monitorHolder[0]);
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					throw new WrappedException(e);
				} finally {
					monitorHolder[0] = null;
				}
			}
		});

		return new PrivilegedRunnableWithProgress(privileged, m -> monitorHolder[0] = m);
	}

	//
	// Nested types
	//

	private static final class PrivilegedRunnableWithProgress implements IRunnableWithProgress {
		private final Consumer<? super IProgressMonitor> monitorSlot;
		private Runnable privileged;

		PrivilegedRunnableWithProgress(Runnable privileged, Consumer<? super IProgressMonitor> monitorSlot) {
			super();

			this.monitorSlot = monitorSlot;
			this.privileged = privileged;
		}

		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			if (privileged == null) {
				throw new IllegalStateException("Privileged runnable was already run"); //$NON-NLS-1$
			}

			monitorSlot.accept(monitor);

			try {
				privileged.run();
			} catch (OperationCanceledException e) {
				throw new InterruptedException(e.getLocalizedMessage());
			} catch (WrappedException e) {
				Exception unwrapped = e.exception();
				if (unwrapped instanceof InvocationTargetException) {
					throw (InvocationTargetException) unwrapped;
				} else if (unwrapped instanceof InterruptedException) {
					throw (InterruptedException) unwrapped;
				} else {
					throw e;
				}
			} finally {
				// Clear our reference to the runnable, which holds a reference
				// to the transaction which, in turn, holds monitors. If we
				// are run in the ModalContextThread and initialize an Xtext UI
				// bundle, then that thread will be retained forever in its
				// Guice injector as the creating thread, and that thread then
				// will retain me (its runnable). See bug 498140
				privileged = null;
			}
		}
	};
}
