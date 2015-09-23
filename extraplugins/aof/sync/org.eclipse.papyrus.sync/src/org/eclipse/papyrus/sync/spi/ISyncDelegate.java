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

package org.eclipse.papyrus.sync.spi;

import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.sync.ISyncProvider;
import org.eclipse.papyrus.sync.ISyncService;

/**
 * Protocol for a pluggable strategy to which the {@linkplain ISyncService sync
 * service} delegates to implement synchronization. Implementations of this
 * interface are registered on the
 * <tt>org.eclipse.papyrus.sync.syncDelegates</tt> extension point.
 */
public interface ISyncDelegate extends ISyncProvider {
	/**
	 * Obtains my unique identifier.
	 * 
	 * @return an unique identifier of this synchronization delegate extension
	 */
	String getID();

	/**
	 * Installs me on the given Papyrus editor context. Effectively starts me
	 * up.
	 * 
	 * @param serviceRegistry
	 *            the Papyrus editor's service registry
	 * 
	 * @throws ServiceException
	 *             on failure to install for any reason
	 */
	void install(ServicesRegistry serviceRegistry) throws ServiceException;

	/**
	 * Removes me from the given Papyrus editor context. Effectively shuts me
	 * down.
	 * 
	 * @param serviceRegistry
	 *            the Papyrus editor's service registry
	 * 
	 * @throws ServiceException
	 *             on failure to uninstall for any reason
	 */
	void uninstall(ServicesRegistry serviceRegistry) throws ServiceException;

	/**
	 * Queries whether a synchronization reference was originally provided by
	 * me.
	 * 
	 * @param synchronizationReference
	 *            a synchronization reference
	 * 
	 * @return whether it is one of mine
	 */
	boolean provides(Object synchronizationReference);
}
