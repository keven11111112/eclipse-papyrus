/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration;

import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.IMatcherFactory;


/**
 * Factory to create matcher based on stereotypes applied on the element
 */
public class StereotypeApplicationMatcherFactory implements IMatcherFactory<StereotypeApplicationMatcherConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	public IElementMatcher createElementMatcher(StereotypeApplicationMatcherConfiguration configuration) {
		return new StereotypeApplicationMatcher(configuration);
	}
}
