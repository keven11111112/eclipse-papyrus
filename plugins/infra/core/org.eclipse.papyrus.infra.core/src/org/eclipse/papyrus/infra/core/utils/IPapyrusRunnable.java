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

package org.eclipse.papyrus.infra.core.utils;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.tools.util.IProgressRunnable;

/**
 * Protocol for a runnable in the Papyrus context.
 * 
 * @since 2.0
 */
@FunctionalInterface
public interface IPapyrusRunnable extends IProgressRunnable, IServiceRegistryProvider {

	@Override
	default ServicesRegistry getServiceRegistry() {
		try {
			return ServiceUtils.getInstance().getServiceRegistry(null);
		} catch (ServiceException e) {
			return null;
		}
	}

	static IPapyrusRunnable inContext(ServicesRegistry registry, IPapyrusRunnable runnable) {
		return new IPapyrusRunnable() {
			@Override
			public void run(IProgressMonitor monitor) {
				runnable.run(monitor);
			}

			@Override
			public ServicesRegistry getServiceRegistry() {
				return registry;
			}
		};
	}
}
