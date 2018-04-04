/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent LORENZO (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.emf.resources;

import org.eclipse.emf.common.util.URI;

/**
 * @author Vincent LORENZO
 *         Abstract XMI Resource to extends for EMF model Resource. The goal is to provides the same options (save and load) for the Papyrus EMF models:
 *         <ul>
 *         <li>use ID, instead of position to reference element</li>
 *         <li>common formating rules (ignoring the options given by the editors)</li>
 *         <li>encoding : UTF-8</li>
 *         <li>default values are saved (allow to prevent troubles when default value changed)</li>
 *         <li>...</li>
 *         </ul>
 */
public abstract class AbstractEMFResourceWithUUID extends AbstractEMFResource {

	/**
	 * 
	 * Constructor.
	 *
	 * @param uri
	 */
	public AbstractEMFResourceWithUUID(final URI uri) {
		super(uri);
	}

	/**
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#useUUIDs()
	 *
	 * @return
	 */

	@Override
	protected boolean useUUIDs() {
		return true;
	}

}
