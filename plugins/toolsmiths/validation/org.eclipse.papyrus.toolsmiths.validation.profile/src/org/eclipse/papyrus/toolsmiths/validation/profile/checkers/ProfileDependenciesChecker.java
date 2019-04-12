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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersManagementUtils;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementUtils;
import org.eclipse.papyrus.toolsmiths.validation.profile.constants.ProfilePluginValidationConstants;

/**
 * This class allows to check that the plug-in has the correct dependencies depending to the external profile references.
 */
public class ProfileDependenciesChecker {

	/**
	 * The plug-ins to detect as warning instead of errors.
	 * This can be filled.
	 */
	@SuppressWarnings("serial")
	private static Set<String> WARNING_PLUGINS_EXCEPTION = new HashSet<String>() {
		{
			add("org.eclipse.uml2.uml.resources"); //$NON-NLS-1$
		}
	};

	/**
	 * This allows to check that the plug-in has the correct dependencies depending to the external profile references.
	 *
	 * @param project
	 *            The current project to check.
	 * @param profileFile
	 *            The file or the UML profile.
	 * @param resource
	 *            The EMF resource.
	 */
	public static void checkDependencies(final IProject project, final IFile profileFile, final Resource resource) {

		// Get the external reference paths
		final Collection<URI> externalReferencesPaths = getExternalReferencesPaths(project, profileFile, resource);

		// Calculate plug-ins names from URI
		final Collection<String> requiredPlugins = new HashSet<>();
		externalReferencesPaths.stream().forEach(externalReferencePath -> requiredPlugins.add(getPluginNameFromURI(externalReferencePath)));

		// For each external reference, get its plug-in name and search its dependency in the plug-in
		final Collection<String> existingRequiredPlugins = new HashSet<>();
		ProjectManagementUtils.getPluginDependencies(project).stream().forEach(dependency -> existingRequiredPlugins.add(dependency.getName()));
		requiredPlugins.removeIf(requiredPlugin -> existingRequiredPlugins.contains(requiredPlugin));

		// If requiredPlugins is not empty, that means, the dependency is not available in the profile plug-in
		// So, create the warning markers
		if (!requiredPlugins.isEmpty()) {
			final IFile manifestFile = ProjectManagementUtils.getManifestFile(project);

			requiredPlugins.stream().forEach(requiredPlugin -> {
				int severity = IMarker.SEVERITY_ERROR;
				if (WARNING_PLUGINS_EXCEPTION.contains(requiredPlugin)) {
					severity = IMarker.SEVERITY_WARNING;
				}
				MarkersManagementUtils.createMarker(manifestFile,
						ProfilePluginValidationConstants.PROFILE_PLUGIN_VALIDATION_TYPE,
						"The plug-in '" + requiredPlugin + "' must be defined as required plug-in (for profile '" + profileFile.getName() + "').", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						severity);
			});
		}
	}

	/**
	 * This allows to get the external references paths.
	 *
	 * @param project
	 *            The current project.
	 * @param profileFile
	 *            The file or the UML profile.
	 * @param resource
	 *            The resource to get external references paths.
	 * @return The external references paths.
	 */
	public static Collection<URI> getExternalReferencesPaths(final IProject project, final IFile profileFile, final Resource resource) {
		final Collection<URI> externalReferencesPaths = new HashSet<>();

		// First step, resolve all references
		EcoreUtil.resolveAll(resource);

		for (final Resource currentResource : resource.getResourceSet().getResources()) {
			// Check that the resource is not the current one or is not available in the same plugin
			if (isExternalReferenceToManage(project, currentResource)) {
				final URI resourceURI = currentResource.getURI();

				// React differently if this is a pathmap
				if (resourceURI.toString().startsWith("pathmap://")) { //$NON-NLS-1$
					// Try to resolve the pathmap
					final URI correspondingURI = getCorrespondingURIFromPathmap(resourceURI);
					if (null == correspondingURI) {
						// If this case, the pathmap cannot be resolved, so create a marker
						MarkersManagementUtils.createMarker(profileFile,
								ProfilePluginValidationConstants.PROFILE_PLUGIN_VALIDATION_TYPE,
								"The pathmap '" + resourceURI.toString() + "' cannot be resolved.", //$NON-NLS-1$ //$NON-NLS-2$
								IMarker.SEVERITY_ERROR);
					} else {
						externalReferencesPaths.add(correspondingURI);
					}
				} else {
					externalReferencesPaths.add(resourceURI);
				}
			}
		}

		return externalReferencesPaths;
	}

	/**
	 * This allows to determinate if the external reference must be managed or not.
	 * For example, we don't have to manage references of files from the same plug-in.
	 * Moreover, some pathmaps don't need to be include in the dependencies.
	 *
	 * @param project
	 *            The current project.
	 * @param resource
	 *            The resource to check.
	 * @return <code>true</code> if we have to manage reference, <code>false</code> otherwise.
	 */
	private static boolean isExternalReferenceToManage(final IProject project, final Resource resource) {
		final String resourceURI = resource.getURI().toString();

		// We don't have to manage references of files from the same plug-in
		if (resourceURI.startsWith("platform:/plugin/" + project.getName()) || //$NON-NLS-1$
				resourceURI.startsWith("platform:/resource/" + project.getName())) { //$NON-NLS-1$
			return false;
		}

		return true;
	}

	/**
	 * This allows to resolve pathmap. To do this, we trim last segments until we got the correct corresponding URI.
	 * It is possible that we don't find pathmap, in this case, just return null.
	 *
	 * @param uri
	 *            The pathmap URI to search.
	 * @return The corresponding URI to the pathmap.
	 */
	private static URI getCorrespondingURIFromPathmap(final URI uri) {
		URI copiedURI = URI.createURI(uri.toString());
		URI foundCorrespondingURI = null;

		while (null == foundCorrespondingURI) {
			foundCorrespondingURI = URIMappingRegistryImpl.INSTANCE.get(copiedURI);
			if (null == foundCorrespondingURI) {
				if (copiedURI.segmentCount() <= 0) {
					break;
				}
				copiedURI = copiedURI.trimSegments(1);
			}
		}

		return foundCorrespondingURI;
	}

	/**
	 * This allows to get the plug-in name from the URI.
	 *
	 * @param uri
	 *            The initial URI.
	 * @return The plug-in name from URI or <code>null</code> if any problem occurred.
	 */
	private static String getPluginNameFromURI(final URI uri) {
		String pluginName = null;

		// Take we correct segment (without authority)
		final int takenSegment = uri.hasAuthority() ? 0 : 1;
		if (uri.segmentCount() > takenSegment) {
			pluginName = uri.segment(takenSegment);
		}

		return pluginName;
	}
}
