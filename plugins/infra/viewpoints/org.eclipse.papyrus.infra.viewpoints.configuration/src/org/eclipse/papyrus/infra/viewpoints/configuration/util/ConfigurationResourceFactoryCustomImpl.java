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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;


/**
 * Custom configuration resource factory to enforce the use of UUIDS
 * @author Benoit Maggi
 */
public class ConfigurationResourceFactoryCustomImpl extends ConfigurationResourceFactoryImpl {
	

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.util.ConfigurationResourceFactoryImpl#createResource(org.eclipse.emf.common.util.URI)
	 *
	 * @param uri
	 * @return
	 */
	@Override
	public Resource createResource(URI uri) {
		XMIResource result = new ConfigurationResourceCustomImpl(uri);
		result.getDefaultSaveOptions().put(XMIResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
		return result;
	}

}
