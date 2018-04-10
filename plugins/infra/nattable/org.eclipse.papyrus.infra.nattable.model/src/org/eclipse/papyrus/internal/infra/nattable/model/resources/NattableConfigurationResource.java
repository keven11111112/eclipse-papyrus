/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent LORENZO (CEA LIST) - Initial API and implementation
 *      
 *****************************************************************************/

package org.eclipse.papyrus.internal.infra.nattable.model.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.emf.resources.AbstractEMFResource;

/**
 * @author Vincent LORENZO
 * @since 4.1
 */
public class NattableConfigurationResource extends AbstractEMFResource {

	/**
	 * the extension of the table configuration file
	 */
	public static final String NATTABLE_CONFIGURATION_RESOURCE_FILE_EXTENSION = "nattableconfiguration"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 *
	 * @param uri
	 */
	public NattableConfigurationResource(final URI uri) {
		super(uri);
	}

}
