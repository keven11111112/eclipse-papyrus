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

package org.eclipse.papyrus.infra.extendedtypes.internal.ui;

import java.util.Map;

import org.eclipse.papyrus.infra.extendedtypes.internal.spi.IUserExtendedTypesProvider;
import org.eclipse.papyrus.infra.extendedtypes.internal.ui.preferences.ExtendedTypesPreferences;

/**
 * User element-types definitions provider for compatibility with the 1.x releases.
 */
public class UserExtendedTypesProvider implements IUserExtendedTypesProvider {

	public UserExtendedTypesProvider() {
		super();
	}

	@Override
	public String getExtendedTypesRedefinition(String extendedTypesID) {
		return ExtendedTypesPreferences.getExtendedTypesRedefinition(extendedTypesID);
	}

	@Override
	public Map<String, String> getLocalExtendedTypesDefinitions() {
		return ExtendedTypesPreferences.getLocalExtendedTypesDefinitions();
	}

}
