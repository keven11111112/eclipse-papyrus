/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.dev.tests.framework.internal.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.dev.tests.framework.internal.PapyrusDiagramTestProjectNature;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.collect.Iterables;

/**
 * Toggles the Papyrus Diagram Tests Framework nature on a project.
 */
public class ToggleNatureHandler extends AbstractHandler {

	public ToggleNatureHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (sel instanceof IStructuredSelection) {
			Iterable<IAdaptable> projects = Iterables.filter(((IStructuredSelection) sel).toList(), IAdaptable.class);
			for (IAdaptable next : projects) {
				IProject project = next.getAdapter(IProject.class);
				if (project != null) {
					try {
						toggleNature(project);
					} catch (CoreException e) {
						throw new ExecutionException("Failed to toggle project nature", e);
					}
				}
			}
		}
		return null;
	}

	protected void toggleNature(IProject project) throws CoreException {
		PapyrusDiagramTestProjectNature nature = new PapyrusDiagramTestProjectNature(project);
		if (nature.hasNature()) {
			nature.deconfigure();
		} else {
			nature.configure();
		}
	}
}
