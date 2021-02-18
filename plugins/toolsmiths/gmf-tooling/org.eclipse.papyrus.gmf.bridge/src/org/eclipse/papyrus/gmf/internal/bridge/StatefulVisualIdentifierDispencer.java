/******************************************************************************
 * Copyright (c) 2006, 2020 Eclipse.org, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge;

import org.eclipse.emf.common.util.URI;

/**
 * XXX [artem] perhaps, passing ResourceSet to loadState would make sense provided 
 * implementations that keep links to the map/gen elements are possible? 
 */
public interface StatefulVisualIdentifierDispencer extends VisualIdentifierDispenser {

	/**
	 * Loading internal state model connected with the specified map model URI
	 */
	void loadState(URI genModelFileURI);

	/**
	 * Saving internal state for future loadin by <code>loadState(..)</code>
	 * method
	 */
	void saveState();

}
