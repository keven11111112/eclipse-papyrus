/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.extensions;

import java.io.IOException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;

/**
 * Handles the extension point org.eclipse.papyrus.properties.context
 * Registers the given Context models to the Property View framework
 * 
 * @author Camille Letavernier
 */
public class ContextExtensionPoint {

	/**
	 * Constructor
	 */
	public ContextExtensionPoint() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.CONTEXT_EXTENSION);

		for(IConfigurationElement e : config) {
			final String contextResource = e.getAttribute("contextModel"); //$NON-NLS-1$
			String uriString = String.format("ppe:/context/%s/%s", e.getContributor().getName(), contextResource);//$NON-NLS-1$
			URI uri = URI.createURI(uriString);
			try {
				ConfigurationManager.instance.addContext(uri);
			} catch (IOException ex) {
				Activator.log.error(String.format("The plugin %s contributed an invalid extension for %s", e.getContributor(), Activator.CONTEXT_EXTENSION), ex); //$NON-NLS-1$
			}
		}
	}
}
