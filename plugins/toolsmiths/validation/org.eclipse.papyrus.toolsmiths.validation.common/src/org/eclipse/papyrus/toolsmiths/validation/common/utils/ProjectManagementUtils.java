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

package org.eclipse.papyrus.toolsmiths.validation.common.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.toolsmiths.validation.common.Activator;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

/**
 * This allows to define utils methods and functions corresponding to project.
 */
public class ProjectManagementUtils {

	/**
	 * This allows to get the plugin model base from the project.
	 * This allows to manipulate the 'plugin.xml' and 'MANIFEST.MF' files content.
	 *
	 * @param project
	 *            The current project.
	 * @return The {@link IPluginModelBase} representing the plug-in project content.
	 */
	public static IPluginModelBase getPluginModelBase(final IProject project) {
		return PluginRegistry.findModel(project);
	}

	/**
	 * This allows to get the list of extensions in the 'plugin.xml' file.
	 *
	 * @param project
	 *            The current project.
	 * @return The list of extensions (can be empty).
	 */
	public static List<IPluginExtension> getPluginExtensions(final IProject project) {
		final IPluginModelBase pluginModelBase = ProjectManagementUtils.getPluginModelBase(project);
		return null != pluginModelBase ? Arrays.asList(pluginModelBase.getExtensions().getExtensions()) : Collections.emptyList();
	}

	/**
	 * This allows to check the file corresponding to the file name in parameter exists.
	 *
	 * @param container
	 *            The container resource.
	 * @param foundFile
	 *            The name of the found file.
	 * @param isExtensionCheck
	 *            <code>true</code> if the found file is an extension to find, <code>false</code> otherwise.
	 * @return The corresponding file or <code>null</code>.
	 */
	public static boolean existFileFromProject(final IContainer container, final String foundFile, final boolean isExtensionCheck) {
		boolean result = false;

		try {
			final Iterator<IResource> members = Arrays.asList(container.members()).iterator();
			while (members.hasNext() && !result) {
				final IResource member = members.next();
				if (member instanceof IFile && isCorrespondingFile((IFile) member, foundFile, isExtensionCheck)) {
					result = true;
				} else if (member instanceof IContainer) {
					result = existFileFromProject((IContainer) member, foundFile, isExtensionCheck);
				}
			}
		} catch (final CoreException e) {
			Activator.log.error(e);
		}

		return result;
	}

	/**
	 * This allows to get the files corresponding to the file name in parameter.
	 *
	 * @param container
	 *            The container resource.
	 * @param foundFile
	 *            The name of the found file.
	 * @param isExtensionCheck
	 *            <code>true</code> if the found file is an extension to find, <code>false</code> otherwise.
	 * @return The corresponding file or <code>null</code>.
	 */
	public static Collection<IFile> getFilesFromProject(final IContainer container, final String foundFile, final boolean isExtensionCheck) {
		final Collection<IFile> result = new HashSet<>();

		try {
			final Iterator<IResource> members = Arrays.asList(container.members()).iterator();
			while (members.hasNext()) {
				final IResource member = members.next();
				if (member instanceof IFile && isCorrespondingFile((IFile) member, foundFile, isExtensionCheck)) {
					result.add((IFile) member);
				} else if (member instanceof IContainer) {
					result.addAll(getFilesFromProject((IContainer) member, foundFile, isExtensionCheck));
				}
			}
		} catch (final CoreException e) {
			Activator.log.error(e);
		}

		return result;
	}

	/**
	 * This allows to get the 'plugin.xml' file.
	 *
	 * @param container
	 *            The container.
	 * @return The found file 'plugin.xml' or <code>null</code>.
	 */
	public static IFile getPluginXMLFile(final IContainer container) {
		final Collection<IFile> pluginXMLFiles = ProjectManagementUtils.getFilesFromProject(container, "plugin.xml", false); //$NON-NLS-1$
		return pluginXMLFiles.isEmpty() ? null : pluginXMLFiles.iterator().next();
	}

	/**
	 * This allows to get the 'build.properties' file.
	 *
	 * @param container
	 *            The container.
	 * @return The found file 'build.properties' or <code>null</code>.
	 */
	public static IFile getBuildFile(final IContainer container) {
		final Collection<IFile> buildPropertiesFiles = ProjectManagementUtils.getFilesFromProject(container, "build.properties", false); //$NON-NLS-1$
		return buildPropertiesFiles.isEmpty() ? null : buildPropertiesFiles.iterator().next();
	}

	/**
	 * This allows to check if the current file is corresponding to the find one.
	 *
	 * @param file
	 *            The current file.
	 * @param foundFile
	 *            The name of the found file.
	 * @param isExtensionCheck
	 *            <code>true</code> if the found file is an extension to find, <code>false</code> otherwise.
	 * @return <code>true</code> if the file is corresponding to the found file, <code>false</code> otherwise.
	 */
	private static boolean isCorrespondingFile(final IFile file, final String foundFile, final boolean isExtensionCheck) {
		return isExtensionCheck ? file.getName().endsWith("." + foundFile) : file.getName().equals(foundFile); //$NON-NLS-1$
	}
}
