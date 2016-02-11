/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.dev.project.management.handlers.plugins;

import java.util.Map;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.papyrus.dev.project.management.internal.operations.OptimizeDependenciesOperation;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;

/**
 * Handler for the "optimize dependencies" command, which ensures re-exports of dependencies
 * that contribute types to the exported API and removes redundancies (except where they are
 * re-exported).
 */
public class OptimizeDependenciesHandler extends AbstractManifestUpdateHandler {

	public OptimizeDependenciesHandler() {
		super();
	}

	@Override
	protected IUndoableOperation createUpdateOperation(Map<? extends IFile, ? extends IManifestEditor> manifests) {
		return new OptimizeDependenciesOperation(manifests);
	}
}
