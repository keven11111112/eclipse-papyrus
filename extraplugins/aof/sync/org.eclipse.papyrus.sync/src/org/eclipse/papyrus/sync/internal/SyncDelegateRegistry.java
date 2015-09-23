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

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.sync.ISyncListener;
import org.eclipse.papyrus.sync.spi.ISyncDelegate;

/**
 * Registry of {@link ISyncDelegate} contributed on the extension point.
 */
public class SyncDelegateRegistry {
	private static final int DEFAULT_PRIORITY = 50;

	private static final String EXT_PT = Activator.PLUGIN_ID + ".syncDelegates";

	private final IExtensionRegistry extensionRegistry;

	public SyncDelegateRegistry() {
		this(Platform.getExtensionRegistry());
	}

	public SyncDelegateRegistry(IExtensionRegistry extensionRegistry) {
		super();

		this.extensionRegistry = extensionRegistry;
	}

	SortedSet<? extends ISyncDelegate> getDelegates() {
		return Stream.of(extensionRegistry.getExtensionPoint(EXT_PT).getConfigurationElements()) //
				.map(SyncDelegate::new) //
				.collect(Collectors.toCollection(TreeSet::new));
	}

	static int getPriority(IConfigurationElement config) {
		int result = DEFAULT_PRIORITY;

		String value = config.getAttribute("priority"); //$NON-NLS-1$
		if (value != null) {
			try {
				result = Integer.parseInt(value);
			} catch (Exception e) {
				Activator.log.warn("Invalid sync delegate priority: " + e.getMessage()); //$NON-NLS-1$
			}
		}

		return result;
	}

	//
	// Nested types
	//

	private static final class SyncDelegate implements ISyncDelegate, Comparable<SyncDelegate> {
		private final IConfigurationElement config;
		private final int priority;

		private ISyncDelegate implementation;

		SyncDelegate(IConfigurationElement config) {
			super();

			this.config = config;
			this.priority = SyncDelegateRegistry.getPriority(config);
		}

		public final int getPriority() {
			return priority;
		}

		@Override
		public int compareTo(SyncDelegate o) {
			// Descending order from highest to lowest priority
			return o.getPriority() - getPriority();
		}

		ISyncDelegate getImplementation() {
			if (implementation == null) {
				try {
					implementation = (ISyncDelegate) config.createExecutableExtension("class"); //$NON-NLS-1$
				} catch (Exception e) {
					Activator.log.error("Invalid synchronization delegate extension: " + e.getMessage(), e); //$NON-NLS-1$
				}

				if (implementation == null) {
					implementation = NullDelegate.INSTANCE;
				}
			}

			return implementation;
		}

		//
		// API delegation
		//

		@Override
		public boolean canSynchronize(Object source, Object target) {
			return getImplementation().canSynchronize(source, target);
		}

		@Override
		public String getID() {
			return getImplementation().getID();
		}

		@Override
		public void install(ServicesRegistry serviceRegistry) throws ServiceException {
			getImplementation().install(serviceRegistry);
		}

		@Override
		public void uninstall(ServicesRegistry serviceRegistry) throws ServiceException {
			getImplementation().uninstall(serviceRegistry);
		}

		@Override
		public boolean provides(Object synchronizationReference) {
			return getImplementation().provides(synchronizationReference);
		}

		@Override
		public Object synchronize(Object source, Object target) {
			return getImplementation().synchronize(source, target);
		}

		@Override
		public Collection<?> getSynchronizationReferences() {
			return getImplementation().getSynchronizationReferences();
		}

		@Override
		public Object getSource(Object synchReference) {
			return getImplementation().getSource(synchReference);
		}

		@Override
		public Object getTarget(Object synchReference) {
			return getImplementation().getTarget(synchReference);
		}

		@Override
		public boolean unsynchronize(Object synchReference) {
			return getImplementation().unsynchronize(synchReference);
		}

		@Override
		public void addSyncListener(ISyncListener listener) {
			getImplementation().addSyncListener(listener);
		}

		@Override
		public void removeSyncListener(ISyncListener listener) {
			getImplementation().removeSyncListener(listener);
		}

	}
}
