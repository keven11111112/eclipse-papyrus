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

package org.eclipse.papyrus.infra.elementtypesconfigurations.internal.ui;

import java.util.Map;

import org.eclipse.papyrus.infra.elementtypesconfigurations.internal.registries.spi.IUserElementTypeDefinitionsProvider;
import org.eclipse.papyrus.infra.elementtypesconfigurations.internal.ui.preferences.ElementTypesPreferences;

/**
 * User element-types definitions provider for compatibility with the 1.x releases.
 */
public class UserElementTypeDefinitionsProvider implements IUserElementTypeDefinitionsProvider {

	public UserElementTypeDefinitionsProvider() {
		super();
	}

	@Override
	public String getElementTypesRedefinition(String elementTypesID) {
		return ElementTypesPreferences.getElementTypesRedefinition(elementTypesID);
	}

	@Override
	public Map<String, String> getLocalElementTypeDefinitions() {
		return ElementTypesPreferences.getLocalElementTypeDefinitions();
	}

}
