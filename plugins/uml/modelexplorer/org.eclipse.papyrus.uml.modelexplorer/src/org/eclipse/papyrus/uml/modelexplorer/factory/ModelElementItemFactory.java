/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.factory;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;


public class ModelElementItemFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		return EMFHelper.getEObject(adaptableObject);
	}

	public Class<?>[] getAdapterList() {
		return null;
	}

}
