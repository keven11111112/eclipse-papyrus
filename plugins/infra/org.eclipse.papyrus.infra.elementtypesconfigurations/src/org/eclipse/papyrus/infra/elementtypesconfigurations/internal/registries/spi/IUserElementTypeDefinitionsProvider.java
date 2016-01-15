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

package org.eclipse.papyrus.infra.elementtypesconfigurations.internal.registries.spi;

import java.util.Map;

/**
 * An extension protocol for providers of user-defined element types
 * configuration models.
 */
public interface IUserElementTypeDefinitionsProvider {
	/**
	 * Returns the path for a given elementType local redefinition
	 *
	 * @param elementTypesID
	 *            the unique identifier of the elementType to retrieve
	 * @return the path to the configuration of the elementTypes or <code>null</code> if no customization exists for this elementType
	 *         configuration
	 */
	String getElementTypesRedefinition(String elementTypesID);

	/**
	 * Returns all the paths in the workspace that should be an elementType set to load, with the id as a key
	 *
	 * @return
	 */
	Map<String, String> getLocalElementTypeDefinitions();
}
