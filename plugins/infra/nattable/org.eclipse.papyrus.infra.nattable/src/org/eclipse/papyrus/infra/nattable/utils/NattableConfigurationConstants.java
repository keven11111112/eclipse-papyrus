/*****************************************************************************
 * Copyright (c) 2016, 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.papyrus.internal.infra.nattable.model.resources.NattableConfigurationResource;

/**
 * @author Vincent Lorenzo
 *
 */
public class NattableConfigurationConstants {

	/**
	 * The extension for the nattable configuration file.
	 * @deprecated since 6.0.0, use NattableConfigurationResource.NATTABLE_CONFIGURATION_RESOURCE_FILE_EXTENSION instead
	 * 
	 */
	@Deprecated 
	public static final String NATTABLE_CONFIGURATION_EXTENSION_FILE = NattableConfigurationResource.NATTABLE_CONFIGURATION_RESOURCE_FILE_EXTENSION;
}
