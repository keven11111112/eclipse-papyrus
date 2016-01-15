/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.extensionpoints;

import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;

public interface IUserElementTypeDefinitionsExtensionPoint {

	/** ID of the extension point */
	String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".userDefinitions";

	/** element: provider of user definitions */
	String E_PROVIDER = "provider";

	/** attribute: class implementing the provider */
	String A_CLASS = "class";
}
