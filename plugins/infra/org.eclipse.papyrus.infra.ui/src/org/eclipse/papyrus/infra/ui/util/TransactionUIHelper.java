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
 *  Christian W. Damus - bug 465416
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.util;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.operation.IRunnableWithProgress;


/**
 * Helper utilities for working with transactions on the UI thread.
 */
public class TransactionUIHelper {

	/**
	 * Create a privileged runnable with progress, which is like a regular {@linkplain TransactionalEditingDomain#createPrivilegedRunnable(Runnable)
	 * privileged runnable} except that it is given a progress monitor for progress reporting.
	 * This enables execution of monitored runnables on the modal-context thread using the transaction borrowed from the UI thread.
	 *
	 * @param domain
	 *            an editing domain
	 * @param runnable
	 *            a runnable with progress that is to borrow the {@code domain}'s active transaction on the modal context thread
	 * @return the privileged runnable, ready to pass into the progress service or other such API
	 */
	public static IRunnableWithProgress createPrivilegedRunnableWithProgress(TransactionalEditingDomain domain, final IRunnableWithProgress runnable) {
		final IProgressMonitor monitorHolder[] = { null };

		final Runnable privileged = domain.createPrivilegedRunnable(new Runnable() {

			@Override
			public void run() {
				try {
					runnable.run(monitorHolder[0]);
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					throw new WrappedException(e);
				}
			}
		});

		return new IRunnableWithProgress() {

			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				monitorHolder[0] = monitor;

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
				}
			}
		};
	}
}
