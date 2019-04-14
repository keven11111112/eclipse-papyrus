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

package org.eclipse.papyrus.toolsmiths.validation.elementtypes.internal.checkers;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersService;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.PluginValidationService;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementService;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.Activator;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.constants.ElementTypesPluginValidationConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * This allows to check an element types plug-in (extensions, builds, dependencies, ...).
 */
public class ElementTypesPluginChecker {

	/**
	 * This allows to check the element types plug-in.
	 *
	 * @param project
	 *            The current project to check.
	 */
	public static void checkElementTypesPlugin(final IProject project) {

		// Get the shell to manage the validation in an UI
		final Shell shell = Display.getCurrent().getActiveShell();

		try {
			// Open the progress monitor dialog
			new ProgressMonitorDialog(shell).run(true, true, monitor -> {
				final Collection<IFile> elementTypesFiles = ProjectManagementService.getFilesFromProject(project, "elementtypesconfigurations", true); //$NON-NLS-1$
				monitor.beginTask("Validate Element Types plug-in", 1 + (elementTypesFiles.size() * 3)); // $NON-NLS-1$

				monitor.subTask("Prepare plug-in validation");
				// First of all, delete the existing markers for project
				MarkersService.deleteMarkers(project, ElementTypesPluginValidationConstants.ELEMENTTYPES_PLUGIN_VALIDATION_TYPE);

				// Create the plug-in validation service
				final PluginValidationService pluginValidationService = new PluginValidationService();

				// For all element types files in the plug-in
				for (final IFile elementTypesFile : elementTypesFiles) {
					// TODO : comming with future gerrits
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
