/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.types.generator;

import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.uml2.uml.Profile;

import com.google.inject.Inject;

/**
 * The generator facade for the UML Profile to Element Types Set Configuration transformation.
 */
public class ElementTypesGenerator extends AbstractGenerator<Profile, ElementTypeSetConfiguration> {

	@Inject
	private ConfigurationSetRule mainRule;

	public ElementTypesGenerator(Identifiers identifiers) {
		this(new GeneratorModule(identifiers));
	}

	public ElementTypesGenerator(GeneratorModule module) {
		super(module);
	}

	@Override
	protected ElementTypeSetConfiguration generate(Profile profile) {
		return mainRule.toConfigurationSet(profile);
	}
}
