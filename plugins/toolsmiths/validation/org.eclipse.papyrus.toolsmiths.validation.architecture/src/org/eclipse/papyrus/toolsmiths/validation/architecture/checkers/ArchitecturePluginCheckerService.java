/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.toolsmiths.validation.architecture.checkers;

import org.eclipse.core.resources.IProject;
import org.eclipse.papyrus.toolsmiths.validation.architecture.internal.checkers.ArchitecturePluginChecker;

/**
 * This allows to check an architecture plug-in (extensions, builds, dependencies).
 */
public class ArchitecturePluginCheckerService {

	/**
	 * This allows to check the architecture plug-in.
	 *
	 * @param project
	 *            The current project to check.
	 */
	public static void checkArchitecturePlugin(final IProject project) {
		ArchitecturePluginChecker.checkArchitecturePlugin(project);
	}

}
