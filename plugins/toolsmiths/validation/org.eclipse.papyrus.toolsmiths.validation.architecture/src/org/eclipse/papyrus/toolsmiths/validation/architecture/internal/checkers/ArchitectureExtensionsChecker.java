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

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.toolsmiths.validation.architecture.constants.ArchitecturePluginValidationConstants;
import org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersService;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementService;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginObject;

/**
 * This class allows to check the extensions of the 'plugin.xml' needed for the architecture file.
 */
public class ArchitectureExtensionsChecker implements IPluginChecker {

	/**
	 * The current project resource.
	 */
	private final IProject project;

	/**
	 * The file defining the architecture.
	 */
	private final IFile architectureFile;

	/**
	 * Constructor.
	 *
	 * @param project
	 *            The current project to check.
	 * @param architectureFile
	 *            The file defining the architecture.
	 */
	public ArchitectureExtensionsChecker(final IProject project, final IFile architectureFile) {
		this.project = project;
		this.architectureFile = architectureFile;
	}

	/**
	 * This allows to check the extensions of the architecture file.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker#check(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void check(final IProgressMonitor monitor) {

		if (null != monitor) {
			monitor.subTask("Validate 'plugin.xml' file for architecture '" + architectureFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// Create the conditions:
		// - Boolean to check if the extension point of architecture configuration file exists
		boolean foundExtension = false;

		// Get all the extensions of the plug-in to check
		final Iterator<IPluginExtension> extensions = ProjectManagementService.getPluginExtensions(project).iterator();
		while (extensions.hasNext() && !foundExtension) {
			final IPluginExtension extension = extensions.next();
			// Check if the extension point of architecture file is available
			if (ArchitecturePluginValidationConstants.ARCHITECTURE_EXTENSION_POINT_IDENTIFIER.equals(extension.getPoint())) {
				for (final IPluginObject pluginObject : extension.getChildren()) {
					if (pluginObject instanceof IPluginElement && "model".equals(pluginObject.getName())) { //$NON-NLS-1$
						for (final IPluginAttribute pluginAtttribute : ((IPluginElement) pluginObject).getAttributes()) {
							if ("path".equals(pluginAtttribute.getName())) { //$NON-NLS-1$
								final String locationValue = pluginAtttribute.getValue();
								foundExtension = locationValue.endsWith(architectureFile.getName());
							}
						}
					}
				}
			}
		}

		// If there is a problem, get the plugin.xml file to mark the correct file for problems
		if (!foundExtension) {
			final IFile pluginXMLFile = ProjectManagementService.getPluginXMLFile(project);

			// Create marker for extension point if needed
			MarkersService.createMarker(
					pluginXMLFile,
					ArchitecturePluginValidationConstants.ARCHITECTURE_PLUGIN_VALIDATION_TYPE,
					"The extension point '" + ArchitecturePluginValidationConstants.ARCHITECTURE_EXTENSION_POINT_IDENTIFIER + "' should be created for profile '" + architectureFile.getName() + "'", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					IMarker.SEVERITY_ERROR);
		}

		if (null != monitor) {
			monitor.worked(1);
		}
	}

}
