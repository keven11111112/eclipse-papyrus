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

package org.eclipse.papyrus.toolsmiths.validation.profile.checkers;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersManagementUtils;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementUtils;
import org.eclipse.papyrus.toolsmiths.validation.profile.Activator;
import org.eclipse.papyrus.toolsmiths.validation.profile.constants.ProfilePluginValidationConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;

/**
 * This allows to check a profile plug-in (extensions, builds, dependencies).
 */
public class ProfilePluginChecker {

	/**
	 * This allows to check the profile plug-in.
	 *
	 * @param project
	 *            The current project to check.
	 */
	public static void checkProfilePlugin(final IProject project) {

		// Get the shell to manage the validation in an UI
		final Shell shell = Display.getCurrent().getActiveShell();

		try {
			// Open the progress monitor dialog
			new ProgressMonitorDialog(shell).run(true, true, monitor -> {
				final Collection<IFile> profileFiles = ProjectManagementUtils.getFilesFromProject(project, "profile.uml", true); //$NON-NLS-1$
				monitor.beginTask("Validate Profile plug-in.", 1 + (profileFiles.size() * 4)); // $NON-NLS-1$

				monitor.subTask("Prepare validation."); //$NON-NLS-1$
				// First of all, delete the existing markers for project
				MarkersManagementUtils.deleteMarkers(project, ProfilePluginValidationConstants.PROFILE_PLUGIN_VALIDATION_TYPE);
				monitor.worked(1);

				// For all profiles files in the plug-in
				for (final IFile profileFile : profileFiles) {

					// get the existing profiles
					final URI profileFileURI = URI.createPlatformResourceURI(profileFile.getFullPath().toOSString(), true);
					final Collection<Profile> profiles = loadProfiles(profileFileURI);

					if (!profiles.isEmpty()) {
						monitor.subTask("Validate 'plugin.xml' file for profile '" + profileFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
						// First, check the extensions
						ProfileExtensionsChecker.checkPluginXMLFile(project, profileFile, profiles);
						monitor.worked(1);

						monitor.subTask("Validate profiles definitions for profile '" + profileFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
						// Check the profile definition (no definition must be done for static profiles)
						ProfileDefinitionChecker.checkProfilesDefinition(project, profileFile, profiles);
						monitor.worked(1);

						monitor.subTask("Validate dependencies for profile '" + profileFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
						// Check the dependencies depending to the external profile references
						ProfileDependenciesChecker.checkDependencies(project, profileFile, profiles.iterator().next().eResource());
						monitor.worked(1);
					} else {
						monitor.worked(3);
					}

					monitor.subTask("Validate 'build.properties' file for profile '" + profileFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
					// Check the build for file
					ProfileBuildChecker.checkBuildFile(project, profileFile);
					monitor.worked(1);
				}
			});
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		} catch (InterruptedException e) {
			// Do nothing, just cancelled by user
		}
	}

	/**
	 * Loads the EObject from the given URI.
	 *
	 * @param uri
	 *            The URI from which the EObject is loaded.
	 * @return
	 *         The profiles available in the model (can be empty if no profile or if an error occurred).
	 */
	private static Collection<Profile> loadProfiles(final URI uri) {
		final Collection<Profile> profiles = new HashSet<>();

		final ResourceSet resourceSet = new ResourceSetImpl();
		try {
			final Resource resource = resourceSet.getResource(uri, true);
			if (null != resource) {
				if (!resource.getContents().isEmpty()) {
					final Iterator<EObject> contentIt = resource.getAllContents();
					while (contentIt.hasNext()) {
						final EObject content = contentIt.next();
						if (content instanceof Profile) {
							profiles.add((Profile) content);
						}
					}
				}
			}
		} catch (final Exception ex) {
			Activator.log.error("Cannot load file: " + uri.toString(), ex); //$NON-NLS-1$
		}

		return profiles;
	}

}
