/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.assistants.generator;

import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.Identifiers;

/**
 * The base Guice injector module for the UML Profile to Modeling Assistants transformation.
 */
public class GeneratorModule extends org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.GeneratorModule {
	public GeneratorModule(Identifiers identifiers) {
		super(identifiers);
	}

	@Override
	protected void configure() {
		super.configure();

		bindModelingAssistantProviderRule();
		bindPopupAssistantRule();
		bindConnectionAssistantRule();
	}

	protected void bindModelingAssistantProviderRule() {
		// pass
	}

	protected void bindPopupAssistantRule() {
		// pass
	}

	protected void bindConnectionAssistantRule() {
		// pass
	}
}
