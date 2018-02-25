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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;

/**
 * @author Vincent LORENZO
 * @since 4.1
 */
public class NattableConfigurationResourceFactory implements Factory {

	@Override
	public Resource createResource(final URI uri) {
		return new NattableConfigurationResource(uri);
	}

}
