/**
 * Copyright (c) 2015 CEA LIST.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Benoit Maggi benoit.maggi@cea.fr - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.viewpoints.configuration.util;

import org.eclipse.emf.common.util.URI;


/**
 * Custom configuration resource to enforce the use of UUIDS
 * @author Benoit Maggi
 */
public class ConfigurationResourceCustomImpl extends ConfigurationResourceImpl {


	/**
	 * Constructor.
	 *
	 * @param uri
	 */
	public ConfigurationResourceCustomImpl(URI uri) {
		super(uri);
	}

	/**
	 * use UUIDs instead of positions
	 */
	@Override
	protected boolean useUUIDs() {
		return true;
	}

} 
