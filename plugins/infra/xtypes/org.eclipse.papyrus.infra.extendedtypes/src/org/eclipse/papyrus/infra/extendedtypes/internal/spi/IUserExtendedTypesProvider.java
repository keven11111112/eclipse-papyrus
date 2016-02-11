/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.extendedtypes.internal.spi;

import java.util.Map;

/**
 * An extension protocol for providers of user-defined extended types models.
 */
public interface IUserExtendedTypesProvider {
	/**
	 * Returns the path for a given extended type local redefinition
	 *
	 * @param extendedTypesID
	 *            the unique identifier of the extended type to retrieve
	 * @return the path to the configuration of the extended types or <code>null</code> if no customization exists for this extended type
	 *         configuration
	 */
	String getExtendedTypesRedefinition(String extendedTypesID);

	/**
	 * Returns all the paths in the workspace that should be an extended type set to load, with the id as a key
	 *
	 * @return
	 */
	Map<String, String> getLocalExtendedTypesDefinitions();
}
