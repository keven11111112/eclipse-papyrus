/*****************************************************************************
 * Copyright (c) 2019 CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.toolsmiths.validation.profile.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementUtils;

/**
 * This allows to test if a selected plug-in contains papyrus profile and its genmodel.
 */
public class ValidateProfilePluginTester extends PropertyTester {

	/**
	 * This allows to test if the project contains papyrus profile and its genmodel.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		boolean result = false;

		if (receiver instanceof IProject) {
			final IProject selectedProject = (IProject) receiver;
			result = ProjectManagementUtils.existFileFromProject(selectedProject, "profile.uml", true) //$NON-NLS-1$
					&& ProjectManagementUtils.existFileFromProject(selectedProject, "genmodel", true); //$NON-NLS-1$
		}
		return expectedValue instanceof Boolean ? ((Boolean) expectedValue).booleanValue() == result : result;
	}

}
