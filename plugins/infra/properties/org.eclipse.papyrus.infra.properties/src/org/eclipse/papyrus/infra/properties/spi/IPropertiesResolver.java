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

package org.eclipse.papyrus.infra.properties.spi;

import org.eclipse.emf.common.util.URI;

/**
 * A protocol for a <em>service</em> that resolves <tt>ppe:</tt> scheme URIs
 * to some kind of less abstract URI.
 */
@FunctionalInterface
public interface IPropertiesResolver {
	/** Resolves a <tt>ppe:</tt> URI. The result needs not exist. */
	URI resolve(URI ppeURI);
}
