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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersService;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementService;
import org.eclipse.papyrus.toolsmiths.validation.profile.constants.ProfilePluginValidationConstants;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.uml2.uml.Profile;

/**
 * This class allows to check the extensions of the 'plugin.xml' needed for the profiles.
 */
public class ProfileExtensionsChecker implements IPluginChecker {

	/**
	 * The current project resource.
	 */
	private final IProject project;

	/**
	 * The file of the UML profile.
	 */
	private final IFile profileFile;

	/**
	 * The existing profiles in the UML file.
	 */
	private final Collection<Profile> existingProfiles;

	/**
	 * Constructor.
	 *
	 * @param project
	 *            The current project to check.
	 * @param profileFile
	 *            The file of the UML profile.
	 * @param existingProfiles
	 *            The existing profiles in the UML file.
	 */
	public ProfileExtensionsChecker(final IProject project, final IFile profileFile, final Collection<Profile> existingProfiles) {
		this.project = project;
		this.profileFile = profileFile;
		this.existingProfiles = existingProfiles;
	}

	/**
	 * This allows to check the extensions of the profile.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker#check(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void check(final IProgressMonitor monitor) {

		if (null != monitor) {
			monitor.subTask("Validate 'plugin.xml' file for profile '" + profileFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// Create the conditions:
		// - Copy of existing profiles (that will be removed if there are found in uml generated package extension points)
		// - Boolean to check if the UMLProfile is defined for the profile
		final Collection<Profile> profiles = new HashSet<>(existingProfiles);
		boolean foundExtensionUMLProfile = false;

		// Get all the extensions of the plug-in to check
		final Iterator<IPluginExtension> extensions = ProjectManagementService.getPluginExtensions(project).iterator();
		while (extensions.hasNext()) {
			final IPluginExtension extension = extensions.next();
			// Check if the UML profile extension point is managed (warning because this one can be managed outside of this plug-in)
			if (!foundExtensionUMLProfile && extension.getPoint().equals(ProfilePluginValidationConstants.UMLPROFILE_EXTENSION_POINT)) {
				for (final IPluginObject pluginObject : extension.getChildren()) {
					if (pluginObject instanceof IPluginElement && pluginObject.getName().equals("profile")) { //$NON-NLS-1$
						for (final IPluginAttribute pluginAtttribute : ((IPluginElement) pluginObject).getAttributes()) {
							if (pluginAtttribute.getName().equals("path")) { //$NON-NLS-1$
								final String locationValue = pluginAtttribute.getValue();
								if (locationValue.endsWith(profileFile.getName())) {
									foundExtensionUMLProfile = true;
								}
							}
						}
					}
				}
			}

			// Manage the uml profile registration (check only if
			if (!profiles.isEmpty() && extension.getPoint().equals(ProfilePluginValidationConstants.UML_GENERATED_PACKAGE_EXTENSION_POINT)) {
				for (final IPluginObject pluginObject : extension.getChildren()) {
					if (pluginObject instanceof IPluginElement && pluginObject.getName().equals("profile")) { //$NON-NLS-1$
						for (final IPluginAttribute pluginAtttribute : ((IPluginElement) pluginObject).getAttributes()) {
							if (pluginAtttribute.getName().equals("location")) { //$NON-NLS-1$
								final String locationValue = pluginAtttribute.getValue();

								final Iterator<Profile> profilesIt = profiles.iterator();
								while (profilesIt.hasNext()) {
									final Profile currentProfile = profilesIt.next();
									final String profileId = ((XMIResource) currentProfile.eResource()).getID(currentProfile);
									if (locationValue.endsWith(profileFile.getName() + "#" + profileId)) { //$NON-NLS-1$
										profilesIt.remove();
										break;
									}
								}
							}
						}
					}
				}
			}
		}

		// If there is a problem, get the plugin.xml file to mark the correct file for problems
		if (!foundExtensionUMLProfile || !profiles.isEmpty()) {
			final IFile pluginXMLFile = ProjectManagementService.getPluginXMLFile(project);

			// Create marker for UMLProfile extension point if needed
			if (!foundExtensionUMLProfile) {
				MarkersService.createMarker(
						pluginXMLFile,
						ProfilePluginValidationConstants.PROFILE_PLUGIN_VALIDATION_TYPE,
						"The extension point '" + ProfilePluginValidationConstants.UMLPROFILE_EXTENSION_POINT + "' should be created for profile '" + profileFile.getName() + "'", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						IMarker.SEVERITY_WARNING);
			}
			// Create markers (one by missing profile) for uml generated package extension point if needed
			if (!profiles.isEmpty()) {
				for (final Profile profile : profiles) {
					MarkersService.createMarker(
							pluginXMLFile,
							ProfilePluginValidationConstants.PROFILE_PLUGIN_VALIDATION_TYPE,
							"There is no extension point '" + ProfilePluginValidationConstants.UML_GENERATED_PACKAGE_EXTENSION_POINT + "' for profile '" + profile.getName() + "'.", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							IMarker.SEVERITY_ERROR);
				}
			}
		}

		if (null != monitor) {
			monitor.worked(1);
		}
	}

}
