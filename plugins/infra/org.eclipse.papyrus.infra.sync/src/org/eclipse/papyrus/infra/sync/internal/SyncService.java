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

package org.eclipse.papyrus.infra.sync.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ResourceAdapter;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.sync.Activator;
import org.eclipse.papyrus.infra.sync.EMFDispatch;
import org.eclipse.papyrus.infra.sync.EMFDispatchManager;
import org.eclipse.papyrus.infra.sync.EMFListener;
import org.eclipse.papyrus.infra.sync.SyncRegistry;
import org.eclipse.papyrus.infra.sync.service.ISyncAction;
import org.eclipse.papyrus.infra.sync.service.ISyncService;
import org.eclipse.papyrus.infra.sync.service.ISyncTrigger;
import org.eclipse.papyrus.infra.sync.service.SyncServiceRunnable;
import org.eclipse.papyrus.infra.tools.util.TypeUtils;

import com.google.common.collect.Maps;

/**
 * Default implementation of the synchronization service.
 */
public class SyncService implements ISyncService {

	private static final ThreadLocal<SyncService> currentService = new ThreadLocal<SyncService>();

	private ServicesRegistry services;

	private TransactionalEditingDomain editingDomain;

	private RootTrigger rootTrigger = new RootTrigger();

	private EMFListener emfListener;

	private final Map<Class<? extends SyncRegistry<?, ?, ?>>, SyncRegistry<?, ?, ?>> syncRegistries = Maps.newHashMap();

	public SyncService() {
		super();
	}

	public static SyncService getCurrent() {
		return currentService.get();
	}

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.services = servicesRegistry;
	}

	@Override
	public void startService() throws ServiceException {
		editingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(services);
		rootTrigger.install(editingDomain);
	}

	@Override
	public void disposeService() throws ServiceException {
		// No disposal protocol for these
		syncRegistries.clear();

		if (emfListener != null) {
			editingDomain.removeResourceSetListener(emfListener);
			emfListener = null;
		}

		if (editingDomain != null) {
			rootTrigger.uninstall(editingDomain);
		}
		editingDomain = null;
	}

	@Override
	public boolean isActive() {
		return editingDomain != null;
	}

	EMFListener getEMFListener() {
		if (emfListener == null) {
			emfListener = new EMFListener(editingDomain);
		}
		return emfListener;
	}

	@Override
	public <D extends EMFDispatch> EMFDispatchManager<D> createSingleDispatchManager() {
		return new SyncServiceOperation<EMFDispatchManager<D>>(this) {
			@Override
			protected EMFDispatchManager<D> doCall() throws Exception {
				return EMFDispatchManager.createSingle(getEMFListener());
			}
		}.safeCall();
	}

	@Override
	public <D extends EMFDispatch> EMFDispatchManager<D> createMultipleDispatchManager() {
		return new SyncServiceOperation<EMFDispatchManager<D>>(this) {
			@Override
			protected EMFDispatchManager<D> doCall() throws Exception {
				return EMFDispatchManager.createMultiple(getEMFListener());
			}
		}.safeCall();
	}

	@Override
	public <M, T, X, R extends SyncRegistry<M, T, X>> R getSyncRegistry(final Class<R> registryType) {
		try {
			return new SyncServiceOperation<R>(this) {
				@Override
				protected R doCall() throws Exception {
					R result = TypeUtils.as(syncRegistries.get(registryType), registryType);

					if (result == null) {
						try {
							result = registryType.newInstance();
						} catch (InstantiationException e) {
							throw new ServiceException("Failed to instantiate sync registry.", e);
						} catch (IllegalAccessException e) {
							throw new ServiceException("Insufficient permission to instantiate sync registry.", e);
						}
						syncRegistries.put(registryType, result);
					}

					return result;
				}
			}.safeCall(ServiceException.class);
		} catch (ServiceException e) {
			Activator.log.error("Failed to access sync registry of type " + registryType.getName(), e);
			return null;
		}
	}

	@Override
	public IStatus evaluateTriggers(final Object object) {
		return new SyncServiceOperation<IStatus>(this) {
			@Override
			protected IStatus doCall() {
				IStatus result = Status.OK_STATUS;

				for (ISyncTrigger trigger : SyncTriggerRegistry.getInstance().getSyncTriggers(object)) {
					ISyncAction action = trigger.trigger(SyncService.this, object);
					if (action != null) {
						IStatus nextResult = action.perform(SyncService.this, object);
						if ((nextResult != null) && !nextResult.isOK()) {
							if (result.isOK()) {
								result = nextResult;
							} else if (result.isMultiStatus()) {
								((MultiStatus) result).merge(nextResult);
							} else {
								result = new MultiStatus(Activator.PLUGIN_ID, 0, new IStatus[] { result, nextResult }, "Multiple sync trigger evaluation problems occurred.", null);
							}
						}
					}
				}

				return result;
			}
		}.safeCall();
	}

	@Override
	public <V, X extends Exception> V run(final SyncServiceRunnable<V, X> operation) throws X {
		return new SyncServiceOperation<V>(this) {
			@Override
			protected V doCall() throws Exception {
				try {
					return operation.run(getCurrent());
				} catch (Throwable t) {
					throw new InvocationTargetException(t);
				}
			}
		}.safeCall(operation.getExceptionType());
	}

	@Override
	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}

	<V> V perform(SyncServiceOperation<V> operation) throws Exception {
		V result;

		final SyncService restore = currentService.get();
		currentService.set(this);
		try {
			result = operation.doCall();
		} finally {
			if (restore == null) {
				currentService.remove();
			} else {
				currentService.set(restore);
			}
		}

		return result;
	}

	//
	// Nested types
	//

	private class RootTrigger extends ResourceAdapter.Transactional {
		RootTrigger() {
			super();
		}

		@Override
		protected void handleResourceLoaded(Resource resource) {
			IStatus status = Status.OK_STATUS;

			// Process existing roots
			for (EObject root : resource.getContents()) {
				IStatus nextResult = processRoot(resource, root);
				if ((nextResult != null) && !nextResult.isOK()) {
					if (status.isOK()) {
						status = nextResult;
					} else if (status.isMultiStatus()) {
						((MultiStatus) status).merge(nextResult);
					} else {
						status = new MultiStatus(Activator.PLUGIN_ID, 0, new IStatus[] { status, nextResult }, "Multiple sync trigger evaluation problems occurred.", null);
					}
				}
			}

			if (!status.isOK()) {
				Activator.log.log(status);
			}
		}

		@Override
		protected void handleRootAdded(Resource resource, EObject root) {
			IStatus status = processRoot(resource, root);
			if (!status.isOK()) {
				Activator.log.log(status);
			}
		}

		protected IStatus processRoot(Resource resource, EObject root) {
			return evaluateTriggers(root);
		}
	}
}