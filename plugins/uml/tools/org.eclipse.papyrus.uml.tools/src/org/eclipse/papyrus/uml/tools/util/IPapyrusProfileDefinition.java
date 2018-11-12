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
 * Interface for Papyrus Definition of Profile.
 * 
 * @since 4.2
 */
public interface IPapyrusProfileDefinition {

	/**
	 * Gets the papyrus annotation.
	 *
	 * @return the papyrus annotation
	 */
	public PapyrusDefinitionAnnotation getPapyrusAnnotation();

	/**
	 * Save constraint.
	 *
	 * @return true, if successful
	 */
	public boolean saveConstraintDefinition();
}
