/**
* Copyright (c) 2018 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.core.architecture.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;

/**
 * This class is used to create the resource to manage architecture files
 *
 */
public class ArchitectureResourceFactory implements Factory {

	public ArchitectureResourceFactory() {
	}

	@Override
	public Resource createResource(final URI uri) {
		return new ArchitectureResource(uri);
	}

}
