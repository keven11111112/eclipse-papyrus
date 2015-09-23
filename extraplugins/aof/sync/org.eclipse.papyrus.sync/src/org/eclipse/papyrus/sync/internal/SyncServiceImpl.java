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

package org.eclipse.papyrus.sync.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.IServiceOperation;
import org.eclipse.papyrus.sync.ISyncListener;
import org.eclipse.papyrus.sync.ISyncProvider;
import org.eclipse.papyrus.sync.ISyncService;
import org.eclipse.papyrus.sync.SyncEvent;
import org.eclipse.papyrus.sync.spi.ISyncDelegate;

/**
 * Implementation of the synchronization service.
 */
public class SyncServiceImpl implements ISyncService {

	private final List<ISyncDelegate> delegates = new ArrayList<>();

	private final CopyOnWriteArrayList<ISyncListener> listeners = new CopyOnWriteArrayList<>();

	private ServicesRegistry serviceRegistry;

	private ISyncListener forwardingListener;

	public SyncServiceImpl() {
		super();
	}

	@Override
	public boolean canSynchronize(Object source, Object target) {
		return getDelegateForSynchronize(source, target).map(d -> d.canSynchronize(source, target)).orElse(false);
	}

	private Optional<? extends ISyncProvider> getDelegateForSynchronize(Object source, Object target) {
		return delegates.stream().filter(d -> d.canSynchronize(source, target)).findFirst();
	}

	private ISyncProvider requireDelegateForSynchronize(Object source, Object target) {
		Optional<? extends ISyncProvider> result = getDelegateForSynchronize(source, target);

		return result.orElseThrow(() -> new IllegalArgumentException(
				String.format("Cannot synchronize source and target: %s, %s", source, target)));
	}

	@Override
	public Object synchronize(Object source, Object target) {
		return requireDelegateForSynchronize(source, target).synchronize(source, target);
	}

	@Override
	public Collection<?> getSynchronizationReferences() {
		return delegates.stream().flatMap(d -> d.getSynchronizationReferences().stream()).collect(Collectors.toList());
	}

	private ISyncProvider requireDelegateForReference(Object synchronizationReference) {
		Optional<? extends ISyncProvider> result = delegates.stream().filter(d -> d.provides(synchronizationReference))
				.findFirst();

		return result.orElseThrow(() -> new IllegalArgumentException(
				String.format("Not a synchronization reference: %s", synchronizationReference)));
	}

	@Override
	public Object getSource(Object synchReference) {
		return requireDelegateForReference(synchReference).getSource(synchReference);
	}

	@Override
	public Object getTarget(Object synchReference) {
		return requireDelegateForReference(synchReference).getTarget(synchReference);
	}

	@Override
	public boolean unsynchronize(Object synchReference) {
		return requireDelegateForReference(synchReference).unsynchronize(synchReference);
	}

	@Override
	public void addSyncListener(ISyncListener listener) {
		listeners.addIfAbsent(listener);
	}

	@Override
	public void removeSyncListener(ISyncListener listener) {
		listeners.remove(listener);
	}

	private void fireSynchronizationChanged(SyncEvent event) {
		listeners.forEach(l -> {
			try {
				l.synchronizationChanged(event);
			} catch (Exception e) {
				Activator.log.error("Uncaught exception in synchronization listener.", e); //$NON-NLS-1$
			}
		});
	}

	private ISyncListener getForwardingListener() {
		if (forwardingListener == null) {
			forwardingListener = new ISyncListener() {

				@Override
				public void synchronizationChanged(SyncEvent event) {
					if (!listeners.isEmpty()) {
						fireSynchronizationChanged(new SyncEvent(event.getEventType(), SyncServiceImpl.this,
								event.getSynchronizationReference(), event.getSyncSource(), event.getSyncTarget()));
					}
				}
			};
		}

		return forwardingListener;
	}

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.serviceRegistry = servicesRegistry;
		delegates.addAll(new SyncDelegateRegistry().getDelegates());
	}

	@Override
	public void startService() throws ServiceException {
		IServiceOperation.performEach(delegates.stream().map(this::installDelegate));
	}

	private IServiceOperation<Void, ServiceException> installDelegate(ISyncDelegate delegate) {
		return () -> {
			delegate.addSyncListener(getForwardingListener());
			delegate.install(serviceRegistry);
			return null;
		};
	}

	@Override
	public void disposeService() throws ServiceException {
		IServiceOperation.performEach(delegates.stream().map(this::uninstallDelegate));
	}

	private IServiceOperation<Void, ServiceException> uninstallDelegate(ISyncDelegate delegate) {
		return () -> {
			try {
				delegate.uninstall(serviceRegistry);
			} finally {
				delegate.removeSyncListener(getForwardingListener());
			}
			return null;
		};
	}

}
