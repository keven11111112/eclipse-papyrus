/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;


/**
 * Provider extending the {@link LocalPaletteProvider} to reference xml-defined palettes into plugins, using the papyrus palette extension point
 */
public class PluginPaletteProvider extends LocalPaletteProvider {

	/** id of the contributor */
	private String providerID;


	/**
	 * Return the provider ID that declares this provider
	 * 
	 * @return the providerID
	 */
	protected String getProviderID() {
		return providerID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getXmlFile(String path) throws IOException {
		// try to read it in a plugin...
		Bundle bundle = Platform.getBundle(getProviderID());
		if(bundle != null) {
			URL urlFile = bundle.getEntry(path);
			urlFile = FileLocator.resolve(urlFile);
			urlFile = FileLocator.toFileURL(urlFile);
			if("file".equals(urlFile.getProtocol())) { //$NON-NLS-1$
				return new File(urlFile.getFile());
				// file = URIUtil.toFile();
			}
		}
		return null;
	}

	/**
	 * Adds the configuration elements to the list of palette provider XML contributions
	 * 
	 * @param configElement
	 *        the configuration element from which information are retrieved
	 */
	public void setContributions(IConfigurationElement configElement) {
		providerID = configElement.getContributor().getName();
		readXMLDocument(configElement.getAttribute(PATH));
	}
}
