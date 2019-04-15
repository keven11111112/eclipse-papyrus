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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersService;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.constants.ElementTypesPluginValidationConstants;

/**
 * This class allows to check the element types file.
 */
public class ElementTypesFileChecker implements IPluginChecker {

	/**
	 * The file defining the element types.
	 */
	private final IFile elementTypesFile;

	/**
	 * Constructor.
	 *
	 * @param elementTypesFile
	 *            The file defining the element types.
	 */
	public ElementTypesFileChecker(final IFile elementTypesFile) {
		this.elementTypesFile = elementTypesFile;
	}

	/**
	 * This allows to validate the element types file.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.toolsmiths.validation.common.checkers.IPluginChecker#check(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void check(final IProgressMonitor monitor) {

		if (null != monitor) {
			monitor.subTask("Validate element types file '" + elementTypesFile.getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// Get the resource and validate it
		final URI elementTypesFileURI = URI.createPlatformResourceURI(elementTypesFile.getFullPath().toOSString(), true);
		final Resource resource = new ResourceSetImpl().getResource(elementTypesFileURI, true);
		final Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));

		// Create markers if the validation is not OK
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			for (final Diagnostic child : diagnostic.getChildren()) {
				int severity = child.getSeverity() == IStatus.ERROR ? IMarker.SEVERITY_ERROR : child.getSeverity() == IStatus.WARNING ? IMarker.SEVERITY_WARNING : IMarker.SEVERITY_INFO;
				MarkersService.createMarker(
						elementTypesFile,
						ElementTypesPluginValidationConstants.ELEMENTTYPES_PLUGIN_VALIDATION_TYPE,
						child.getMessage(),
						severity);
			}
		}

		if (null != monitor) {
			monitor.worked(1);
		}
	}

}
