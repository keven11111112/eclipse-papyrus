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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.toolsmiths.validation.architecture.constants.ArchitecturePluginValidationConstants;
import org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersService;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementService;

/**
 * This class allows to check that the plug-in has the correct dependencies depending to the external profile references.
 */
public class ArchitectureExternalDependenciesChecker implements IPluginChecker {

	/**
	 * The current project resource.
	 */
	private final IProject project;

	/**
	 * The file defining the architecture.
	 */
	private final IFile architectureFile;

	/**
	 * The EMF resource.
	 */
	private final Resource resource;

	/**
	 * Constructor.
	 *
	 * @param project
	 *            The current project resource.
	 * @param architectureFile
	 *            The file defining the architecture.
	 * @param resource
	 *            The EMF resource.
	 */
	public ArchitectureExternalDependenciesChecker(final IProject project, final IFile architectureFile, final Resource resource) {
		this.project = project;
		this.architectureFile = architectureFile;
		this.resource = resource;
	}

	/**
	 * This allows to check that the plug-in has the correct dependencies depending to the external architecture references.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker#check(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void check(final IProgressMonitor monitor) {

		if (null != monitor) {
			monitor.subTask("Validate dependencies for architecture '" + architectureFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// Get the external reference paths
		final Collection<URI> externalReferencesPaths = getExternalReferencesPaths(project, architectureFile, resource);

		// Calculate plug-ins names from URI
		final Collection<String> requiredPlugins = new HashSet<>();
		externalReferencesPaths.stream().forEach(externalReferencePath -> requiredPlugins.add(getPluginNameFromURI(externalReferencePath)));

		// For each external reference, get its plug-in name and search its dependency in the plug-in
		final Collection<String> existingRequiredPlugins = new HashSet<>();
		ProjectManagementService.getPluginDependencies(project).stream().forEach(dependency -> existingRequiredPlugins.add(dependency.getName()));
		requiredPlugins.removeIf(requiredPlugin -> existingRequiredPlugins.contains(requiredPlugin));

		// If requiredPlugins is not empty, that means, the dependency is not available in the profile plug-in
		// So, create the warning markers
		if (!requiredPlugins.isEmpty()) {
			final IFile manifestFile = ProjectManagementService.getManifestFile(project);

			requiredPlugins.stream().forEach(requiredPlugin -> {

				MarkersService.createMarker(manifestFile,
						ArchitecturePluginValidationConstants.ARCHITECTURE_PLUGIN_VALIDATION_TYPE,
						"The plug-in '" + requiredPlugin + "' must be defined as required plug-in (for architecture file '" + architectureFile.getName() + "').", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						IMarker.SEVERITY_WARNING);
			});
		}

		if (null != monitor) {
			monitor.worked(1);
		}
	}

	/**
	 * This allows to get the external references paths.
	 *
	 * @param project
	 *            The current project.
	 * @param architectureFile
	 *            The file defining the architecture.
	 * @param resource
	 *            The resource to get external references paths.
	 * @return The external references paths.
	 */
	private Collection<URI> getExternalReferencesPaths(final IProject project, final IFile architectureFile, final Resource resource) {
		final Collection<URI> externalReferencesPaths = new HashSet<>();

		// First step, resolve all references
		EcoreUtil.resolveAll(resource);

		for (final Resource currentResource : resource.getResourceSet().getResources()) {
			// Check that the resource is not the current one or is not available in the same plugin
			if (!isCurrentProjectReference(project, currentResource)) {
				final URI resourceURI = currentResource.getURI();

				if (null != resourceURI && (resourceURI.toString().startsWith("platform:/") || resourceURI.toString().startsWith("../"))) { //$NON-NLS-1$ //$NON-NLS-2$
					externalReferencesPaths.add(resourceURI);
				}
			}
		}

		return externalReferencesPaths;
	}

	/**
	 * This allows to determinate if the external reference must be managed or not.
	 * For example, we don't have to manage references of files from the same plug-in.
	 *
	 * @param project
	 *            The current project.
	 * @param resource
	 *            The resource to check.
	 * @return <code>true</code> if we have to manage reference, <code>false</code> otherwise.
	 */
	private boolean isCurrentProjectReference(final IProject project, final Resource resource) {
		final String resourceURI = resource.getURI().toString();

		// We don't have to manage references of files from the same plug-in
		if (resourceURI.startsWith("platform:/plugin/" + project.getName() + "/") || //$NON-NLS-1$ //$NON-NLS-2$
				resourceURI.startsWith("platform:/resource/" + project.getName() + "/")) { //$NON-NLS-1$ //$NON-NLS-2$
			return true;
		}

		return false;
	}

	/**
	 * This allows to get the plug-in name from the URI.
	 *
	 * @param uri
	 *            The initial URI.
	 * @return The plug-in name from URI or <code>null</code> if any problem occurred.
	 */
	private String getPluginNameFromURI(final URI uri) {
		String pluginName = null;

		// Take we correct segment (without authority)
		final int takenSegment = uri.hasAuthority() ? 0 : 1;
		if (uri.segmentCount() > takenSegment) {
			pluginName = uri.segment(takenSegment);
		}

		return pluginName;
	}
}
