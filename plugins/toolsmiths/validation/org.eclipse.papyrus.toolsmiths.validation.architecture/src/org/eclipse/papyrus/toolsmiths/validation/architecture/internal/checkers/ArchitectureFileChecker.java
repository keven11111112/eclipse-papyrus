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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.papyrus.toolsmiths.validation.architecture.constants.ArchitecturePluginValidationConstants;
import org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersService;

/**
 * This class allows to check the architecture file.
 */
public class ArchitectureFileChecker implements IPluginChecker {

	/**
	 * The file defining the architecture.
	 */
	private final IFile architectureFile;

	/**
	 * The EMF resource of the architecture file.
	 */
	private final Resource resource;

	/**
	 * Constructor.
	 *
	 * @param architectureFile
	 *            The file defining the architecture.
	 * @param resource
	 *            The EMF resource of the architecture file.
	 */
	public ArchitectureFileChecker(final IFile architectureFile, final Resource resource) {
		this.architectureFile = architectureFile;
		this.resource = resource;
	}

	/**
	 * This allows to validate the architecture file.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker#check(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void check(final IProgressMonitor monitor) {

		if (null != monitor) {
			monitor.subTask("Validate architecture file '" + architectureFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		final EObject root = resource.getContents().get(0);
		if (null != root) {
			// Get the resource and validate it
			final Diagnostic diagnostic = Diagnostician.INSTANCE.validate(root);

			// Create markers if the validation is not OK
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				for (final Diagnostic child : diagnostic.getChildren()) {
					int severity = child.getSeverity() == IStatus.ERROR ? IMarker.SEVERITY_ERROR : child.getSeverity() == IStatus.WARNING ? IMarker.SEVERITY_WARNING : IMarker.SEVERITY_INFO;
					MarkersService.createMarker(
							architectureFile,
							ArchitecturePluginValidationConstants.ARCHITECTURE_PLUGIN_VALIDATION_TYPE,
							child.getMessage(),
							severity);
				}
			}
		}

		if (null != monitor) {
			monitor.worked(1);
		}
	}

}
