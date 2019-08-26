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

package org.eclipse.papyrus.toolsmiths.validation.architecture.internal.checkers;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.toolsmiths.validation.architecture.Activator;
import org.eclipse.papyrus.toolsmiths.validation.architecture.constants.ArchitecturePluginValidationConstants;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersService;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.PluginValidationService;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementService;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * This allows to check an architecture plug-in (extensions, builds, dependencies, ...).
 */
public class ArchitecturePluginChecker {

	/**
	 * This allows to check the architecture plug-in.
	 *
	 * @param project
	 *            The current project to check.
	 */
	public static void checkArchitecturePlugin(final IProject project) {

		// Get the shell to manage the validation in an UI
		final Shell shell = Display.getCurrent().getActiveShell();

		try {
			// Open the progress monitor dialog
			new ProgressMonitorDialog(shell).run(true, true, monitor -> {
				final Collection<IFile> architectureFiles = ProjectManagementService.getFilesFromProject(project, "architecture", true); //$NON-NLS-1$
				monitor.beginTask("Validate Architecture plug-in", 1 + (architectureFiles.size() * 3)); // $NON-NLS-1$

				monitor.subTask("Prepare plug-in validation"); //$NON-NLS-1$
				// First of all, delete the existing markers for project
				MarkersService.deleteMarkers(project, ArchitecturePluginValidationConstants.ARCHITECTURE_PLUGIN_VALIDATION_TYPE);

				// Create the plug-in validation service
				final PluginValidationService pluginValidationService = new PluginValidationService();

				// First, check the dependencies needed
				pluginValidationService.addPluginChecker(new ArchitectureDependenciesChecker(project));

				// For all architecture files in the plug-in
				for (final IFile architectureFile : architectureFiles) {

					// Get the resource
					final URI architectureFileURI = URI.createPlatformResourceURI(architectureFile.getFullPath().toOSString(), true);
					final Resource resource = new ResourceSetImpl().getResource(architectureFileURI, true);

					// Check the validation of the architecture file
					pluginValidationService.addPluginChecker(new ArchitectureFileChecker(architectureFile, resource));

					// Check the extension point
					pluginValidationService.addPluginChecker(new ArchitectureExtensionsChecker(project, architectureFile));

					// Check the external dependencies needed
					pluginValidationService.addPluginChecker(new ArchitectureExternalDependenciesChecker(project, architectureFile, resource));

					// Create the build checker
					pluginValidationService.addPluginChecker(new ArchitectureBuildChecker(project, architectureFile));
				}

				monitor.worked(1);

				// Call the validate
				pluginValidationService.validate(monitor);

			});
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		} catch (InterruptedException e) {
			// Do nothing, just cancelled by user
		}
	}

}
