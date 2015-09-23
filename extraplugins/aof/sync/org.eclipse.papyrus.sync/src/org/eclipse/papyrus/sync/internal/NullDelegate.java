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
import java.util.Collections;

import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.sync.ISyncListener;
import org.eclipse.papyrus.sync.spi.ISyncDelegate;

/**
 * A synchronization delegate that does nothing. It serves usefully as a
 * placeholder for a failed, absent, or otherwise idle delegate.
 */
public class NullDelegate implements ISyncDelegate {
	public static final NullDelegate INSTANCE = new NullDelegate();

	/**
	 * Not instantiable by clients.
	 */
	private NullDelegate() {
		super();
	}

	@Override
	public boolean canSynchronize(Object source, Object target) {
		return false;
	}

	@Override
	public Object synchronize(Object source, Object target) {
		throw new IllegalArgumentException(
				String.format("Cannot synchronize source and target: %s, %s", source, target)); //$NON-NLS-1$
	}

	@Override
	public Collection<?> getSynchronizationReferences() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public Object getSource(Object synchReference) {
		throw new IllegalArgumentException(String.format("Invalid synchronization reference: %s", synchReference)); //$NON-NLS-1$
	}

	@Override
	public Object getTarget(Object synchReference) {
		throw new IllegalArgumentException(String.format("Invalid synchronization reference: %s", synchReference)); //$NON-NLS-1$
	}

	@Override
	public boolean unsynchronize(Object synchReference) {
		throw new IllegalArgumentException(String.format("Invalid synchronization reference: %s", synchReference)); //$NON-NLS-1$
	}

	@Override
	public void addSyncListener(ISyncListener listener) {
		// I never fire events
	}

	@Override
	public void removeSyncListener(ISyncListener listener) {
		// I never fire events
	}

	@Override
	public String getID() {
		return "org.eclipse.papyrus.sync.null"; //$NON-NLS-1$
	}

	@Override
	public void install(ServicesRegistry serviceRegistry) throws ServiceException {
		// Pass
	}

	@Override
	public void uninstall(ServicesRegistry serviceRegistry) throws ServiceException {
		// Pass
	}

	@Override
	public boolean provides(Object synchronizationReference) {
		return false;
	}

}
