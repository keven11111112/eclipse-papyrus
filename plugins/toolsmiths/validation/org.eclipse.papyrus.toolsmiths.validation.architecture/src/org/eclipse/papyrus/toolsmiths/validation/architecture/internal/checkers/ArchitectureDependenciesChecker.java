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

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.papyrus.toolsmiths.validation.architecture.constants.ArchitecturePluginValidationConstants;
import org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersService;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementService;

/**
 * This class allows to check that the plug-in has the correct dependencies for architecture management.
 */
public class ArchitectureDependenciesChecker implements IPluginChecker {

	/**
	 * The needed required plug-ins for the architecture management.
	 */
	@SuppressWarnings("serial")
	private static final Collection<String> NEEDED_REQUIRED_PLUGINS = new HashSet<String>() {
		{
			add("org.eclipse.papyrus.infra.architecture"); //$NON-NLS-1$
		}
	};

	/**
	 * The current project resource.
	 */
	private final IProject project;

	/**
	 * Constructor.
	 *
	 * @param project
	 *            The current project resource.
	 */
	public ArchitectureDependenciesChecker(final IProject project) {
		this.project = project;
	}

	/**
	 * This allows to check that the plug-in has the correct dependencies for architecture management.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker#check(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void check(final IProgressMonitor monitor) {

		if (null != monitor) {
			monitor.subTask("Validate dependencies for architecture."); //$NON-NLS-1$
		}

		// Manage a list of required plug-ins to check
		final Collection<String> requiredPlugins = new HashSet<>();
		NEEDED_REQUIRED_PLUGINS.stream().forEach(needRequiredPlugin -> requiredPlugins.add(needRequiredPlugin));

		// For each external reference, get its plug-in name and search its dependency in the plug-in
		final Collection<String> existingRequiredPlugins = new HashSet<>();
		final List<BundleSpecification> dependencies = ProjectManagementService.getPluginDependencies(project);
		if (null != dependencies && !dependencies.isEmpty()) {
			dependencies.stream().forEach(dependency -> existingRequiredPlugins.add(dependency.getName()));
			requiredPlugins.removeIf(requiredPlugin -> existingRequiredPlugins.contains(requiredPlugin));
		}

		// If requiredPlugins is not empty, that means, the dependency is not available in the profile plug-in
		// So, create the warning markers
		if (!requiredPlugins.isEmpty()) {
			final IFile manifestFile = ProjectManagementService.getManifestFile(project);

			requiredPlugins.stream().forEach(requiredPlugin -> {
				MarkersService.createMarker(manifestFile,
						ArchitecturePluginValidationConstants.ARCHITECTURE_PLUGIN_VALIDATION_TYPE,
						"The plug-in '" + requiredPlugin + "' must be defined as required plug-in.", //$NON-NLS-1$ //$NON-NLS-2$
						IMarker.SEVERITY_ERROR);
			});
		}

		if (null != monitor) {
			monitor.worked(1);
		}
	}
}
