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
import java.util.Iterator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.toolsmiths.validation.common.Activator;

/**
 * This allows to define utils methods and functions corresponding to project.
 */
public class ProjectManagementUtils {

	/**
	 * This allows to get the file corresponding to the file name in parameter.
	 *
	 * @param container
	 *            The container resource.
	 * @param foundFile
	 *            The name of the found file.
	 * @param isExtensionCheck
	 *            <code>true</code> if the found file is an extension to find, <code>false</code> otherwise.
	 * @return The corresponding file or <code>null</code>.
	 */
	public static IFile getFileFromProject(final IContainer container, final String foundFile, final boolean isExtensionCheck) {
		IFile result = null;

		try {
			final Iterator<IResource> members = Arrays.asList(container.members()).iterator();
			while (members.hasNext() && null == result) {
				final IResource member = members.next();
				if (member instanceof IFile && isCorrespondingFile((IFile) member, foundFile, isExtensionCheck)) {
					result = (IFile) member;
				} else if (member instanceof IContainer) {
					result = getFileFromProject((IContainer) member, foundFile, isExtensionCheck);
				}
			}
		} catch (final CoreException e) {
			Activator.log.error(e);
		}

		return result;
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
		return isExtensionCheck ? file.getName().endsWith("." + foundFile) : file.getName().equals(foundFile);
	}

}
