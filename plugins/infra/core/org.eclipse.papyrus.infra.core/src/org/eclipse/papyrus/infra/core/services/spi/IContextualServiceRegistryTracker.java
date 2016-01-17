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

package org.eclipse.papyrus.infra.core.services.spi;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * Protocol for a service that can provide the {@link ServicesRegistry}
 * that is associated with the user's current editing context, if any.
 * When the user is not editing any Papyrus model, then presumably there
 * is no need for any service registry.
 */
@FunctionalInterface
public interface IContextualServiceRegistryTracker {
	/**
	 * Obtains the contextual service registry, if any.
	 * 
	 * @return the contextual service registry, or {@code null} if none
	 */
	ServicesRegistry getServiceRegistry();
}
