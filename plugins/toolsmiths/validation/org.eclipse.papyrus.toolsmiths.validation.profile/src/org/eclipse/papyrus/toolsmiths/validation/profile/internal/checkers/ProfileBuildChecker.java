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

package org.eclipse.papyrus.toolsmiths.validation.profile.internal.checkers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersService;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementService;
import org.eclipse.papyrus.toolsmiths.validation.profile.constants.ProfilePluginValidationConstants;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;

/**
 * This class allows to check the 'build.properties' needed for the profile file.
 */
public class ProfileBuildChecker implements IPluginChecker {

	/**
	 * The current project resource.
	 */
	private final IProject project;

	/**
	 * The file of the UML profile.
	 */
	private final IFile profileFile;

	/**
	 * Constructor.
	 *
	 * @param project
	 *            The current project resource.
	 * @param profileFile
	 *            The file of the UML profile.
	 */
	public ProfileBuildChecker(final IProject project, final IFile profileFile) {
		this.project = project;
		this.profileFile = profileFile;
	}


	/**
	 * This allows to check the build of the profile file.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker#check(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void check(final IProgressMonitor monitor) {

		if (null != monitor) {
			monitor.subTask("Validate 'build.properties' file for profile '" + profileFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// Get the build.properties entries from the project
		final IBuildModel buildModel = ProjectManagementService.getPluginBuild(project);
		if (null != buildModel) {

			// Create the conditions:
			// - Boolean to determinate if the build contains folder containing the profile
			boolean containsProfile = false;

			// Calculate the profile path
			final String profilePath = profileFile.getProjectRelativePath().toString();

			final IBuild build = buildModel.getBuild();
			final IBuildEntry buildEntry = build.getEntry(IBuildEntry.BIN_INCLUDES);

			// Iterate on existing tokens
			final String[] tokens = buildEntry.getTokens();
			for (int i = 0; i < tokens.length && !containsProfile; i++) {
				containsProfile = profilePath.startsWith(tokens[i]);
			}

			// Create marker for UMLProfile extension point if needed
			if (!containsProfile) {
				final IFile buildPropertiesFile = ProjectManagementService.getBuildFile(project);

				MarkersService.createMarker(
						buildPropertiesFile,
						ProfilePluginValidationConstants.PROFILE_PLUGIN_VALIDATION_TYPE,
						"The build does not contains entry for file '" + profilePath + "'", //$NON-NLS-1$ //$NON-NLS-2$
						IMarker.SEVERITY_ERROR);
			}
		}

		if (null != monitor) {
			monitor.worked(1);
		}
	}

}
