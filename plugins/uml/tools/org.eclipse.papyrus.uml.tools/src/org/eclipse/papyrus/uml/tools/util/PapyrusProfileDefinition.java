/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.util;

import org.eclipse.papyrus.uml.tools.profile.definition.PapyrusDefinitionAnnotation;

/**
 * Class for Papyrus Profile definition.
 * 
 * @since 4.2
 */
public class PapyrusProfileDefinition implements IPapyrusProfileDefinition {

	/** The annotation. */
	private final PapyrusDefinitionAnnotation annotation;

	/** The save constraint definition. */
	private final boolean saveConstraintDefinition;


	/**
	 * Instantiates a new papyrus profile definition.
	 *
	 * @param papyrusDefinitionAnnotation
	 *            the papyrus definition annotation.
	 * @param saveConstraint
	 *            the save constraint.
	 */
	public PapyrusProfileDefinition(final PapyrusDefinitionAnnotation papyrusDefinitionAnnotation, final boolean saveConstraint) {
		annotation = papyrusDefinitionAnnotation;
		saveConstraintDefinition = saveConstraint;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.uml.tools.util.IPapyrusProfileDefinition#getPapyrusAnnotation()
	 */
	@Override
	public PapyrusDefinitionAnnotation getPapyrusAnnotation() {
		return annotation;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.uml.tools.util.IPapyrusProfileDefinition#saveConstraintDefinition()
	 */
	@Override
	public boolean saveConstraintDefinition() {
		return saveConstraintDefinition;
	}

}
