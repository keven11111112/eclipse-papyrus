/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.internationalization.helper;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.internationalization.resource.InternationalizationResourceFactory;
import org.eclipse.papyrus.infra.internationalization.utils.PropertiesFilesUtils;

/**
 * The internationalization resource helper needed to install the
 * internationalization support for the properties files resources.
 */
public class InternationalizationResourceHelper {

	/**
	 * This allows to install the correct resource fatory corresponding to the
	 * properties files.
	 * 
	 * @param resourceSet
	 *            The current resource set.
	 */
	public static void installUMLInternationalizationSupport(final ResourceSet resourceSet) {
		final InternationalizationResourceFactory factory = new InternationalizationResourceFactory();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(PropertiesFilesUtils.PROPERTIES_FILE_EXTENSION, factory);
	}

}
