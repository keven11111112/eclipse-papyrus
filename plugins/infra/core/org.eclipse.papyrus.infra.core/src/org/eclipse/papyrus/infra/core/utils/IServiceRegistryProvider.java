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

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * A protocol for any object that can provide the context of a Papyrus
 * {@link ServicesRegistry} in which it is exists.
 * 
 * @since 2.0
 */
@FunctionalInterface
public interface IServiceRegistryProvider {
	/**
	 * Obtains my contextual service registry.
	 * 
	 * @return my service registry
	 */
	ServicesRegistry getServiceRegistry();
}
