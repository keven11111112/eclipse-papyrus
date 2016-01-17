/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.tools;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.papyrus.infra.tools.spi.IExecutorServiceFactory;
import org.eclipse.papyrus.infra.tools.util.IExecutorService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * An executor service that delegates to the UI executor provided by the
 * registered factory service, if available. Otherwise, it delegates to
 * a default single-thread executor. Reacts to registration changes in
 * the {@link IExecutorServiceFactory} by replacing the default executor
 * with a "real" UI executor when available and replacing the "real" UI
 * executor with a default executor when no longer available.
 */
class DelegatingUIExecutorService implements IExecutorService, ServiceTrackerCustomizer<IExecutorServiceFactory, IExecutorService> {
	private final BundleContext context;
	private final ServiceTracker<IExecutorServiceFactory, IExecutorService> tracker;
	private ExecutorService delegate;

	DelegatingUIExecutorService(BundleContext context) {
		this.context = context;
		this.tracker = new ServiceTracker<>(context, IExecutorServiceFactory.class, this);

		tracker.open();

		delegate = tracker.getService();
		if (delegate == null) {
			delegate = Executors.newSingleThreadExecutor();
		}
	}

	synchronized void shutdown(BundleContext context) {
		if (context == this.context) {
			if (delegate != null) {
				delegate.shutdown();
				delegate = null;
			}

			tracker.close();
		}
	}

	@Override
	public synchronized IExecutorService addingService(ServiceReference<IExecutorServiceFactory> reference) {
		IExecutorService result = context.getService(reference).createExecutor();

		if (delegate != null) {
			delegate.shutdown();
		}

		delegate = result;

		return result;
	}

	@Override
	public synchronized void removedService(ServiceReference<IExecutorServiceFactory> reference, IExecutorService service) {
		context.ungetService(reference);

		if (service == delegate) {
			delegate.shutdown();
			delegate = Executors.newSingleThreadExecutor();
		}
	}

	@Override
	public void modifiedService(ServiceReference<IExecutorServiceFactory> reference, IExecutorService service) {
		// Pass
	}

	//
	// ExecutorService protocol
	//

	@Override
	public void shutdown() {
		throw new IllegalStateException("Executor is shared"); //$NON-NLS-1$
	}

	@Override
	public List<Runnable> shutdownNow() {
		throw new IllegalStateException("Executor is shared"); //$NON-NLS-1$
	}

	@Override
	public void execute(Runnable command) {
		delegate.execute(command);
	}

	@Override
	public boolean isShutdown() {
		return delegate.isShutdown();
	}

	@Override
	public boolean isTerminated() {
		return delegate.isTerminated();
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return delegate.awaitTermination(timeout, unit);
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) {
		return delegate.submit(task);
	}

	@Override
	public <T> Future<T> submit(Runnable task, T result) {
		return delegate.submit(task, result);
	}

	@Override
	public Future<?> submit(Runnable task) {
		return delegate.submit(task);
	}

	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
		return delegate.invokeAll(tasks);
	}

	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
		return delegate.invokeAll(tasks, timeout, unit);
	}

	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
		return delegate.invokeAny(tasks);
	}

	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return delegate.invokeAny(tasks, timeout, unit);
	}

	//
	// IExecutorService protocol
	//

	@Override
	public void syncExec(Runnable task) throws InterruptedException, ExecutionException {
		if (delegate instanceof IExecutorService) {
			((IExecutorService) delegate).syncExec(task);
		} else {
			Future<?> future = delegate.submit(task);
			// Wait for it
			future.get();
		}
	}

	@Override
	public <V> V syncCall(Callable<V> callable) throws InterruptedException, ExecutionException {
		if (delegate instanceof IExecutorService) {
			return ((IExecutorService) delegate).syncCall(callable);
		} else {
			Future<V> future = delegate.submit(callable);
			// Wait for it
			return future.get();
		}
	}
}
