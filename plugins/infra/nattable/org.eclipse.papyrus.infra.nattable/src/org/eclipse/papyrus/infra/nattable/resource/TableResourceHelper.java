/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.infra.nattable.resource;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.nattable.utils.TableResourceConstants;

/**
 * The table resource helper needed to install the table support for the '*.table' files resources.
 * @since 3.0
 */
public class TableResourceHelper {

	/**
	 * This allows to install the correct resource factory corresponding to the table files.
	 * 
	 * @param resourceSet
	 *            The current resource set.
	 */
	public static void installTableSupport(final ResourceSet resourceSet) {
		final TableResourceFactory factory = new TableResourceFactory();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(TableResourceConstants.TABLE_FILE_EXTENSION, factory);
	}

}
