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

package org.eclipse.papyrus.toolsmiths.validation.architecture.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.toolsmiths.validation.architecture.checkers.ArchitecturePluginCheckerService;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This handler allows to validate papyrus architecture plug-ins.
 */
public class ValidateArchitecturePluginHandler extends AbstractHandler {

	/**
	 * This allows to validate a plugin which contains papyrus architecture definition.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection == null || !(selection instanceof StructuredSelection) || selection.isEmpty()) {
			return null;
		}

		final StructuredSelection structuredSelection = (StructuredSelection) selection;
		for (final Object selectedElement : structuredSelection.toList()) {
			if (selectedElement instanceof IProject) {
				final IProject project = (IProject) selectedElement;
				ArchitecturePluginCheckerService.checkArchitecturePlugin(project);
			}
		}

		return null;
	}

}
