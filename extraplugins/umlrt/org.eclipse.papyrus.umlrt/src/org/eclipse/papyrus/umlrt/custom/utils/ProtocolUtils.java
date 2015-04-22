/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.umlrt.custom.utils;

import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Package;

/**
 * Utility class for UMLRT::Protocols
 */
public class ProtocolUtils {

	/**
	 * Returns the package that corresponds to the protocol container. There should be a check here for the applied stereotype on the package.
	 * 
	 * @param protocol
	 *            the collaboration for which the protocol container is searched
	 * @return the collaboration for which the protocol container is searched or <code>null</code> if none is found
	 */
	public static Package getPackageContainer(Collaboration protocol) {
		return protocol.getNearestPackage();
	}

}
