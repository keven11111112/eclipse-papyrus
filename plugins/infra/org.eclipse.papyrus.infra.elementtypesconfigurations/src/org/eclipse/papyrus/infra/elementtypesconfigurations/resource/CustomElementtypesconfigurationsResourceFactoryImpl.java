/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.elementtypesconfigurations.util.ElementtypesconfigurationsResourceFactoryImpl;


public class CustomElementtypesconfigurationsResourceFactoryImpl extends ElementtypesconfigurationsResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {
		Resource result = new CustomElementtypesconfigurationsResourceImpl(uri);
		return result;
	}

} // ElementtypesconfigurationsResourceFactoryImpl
