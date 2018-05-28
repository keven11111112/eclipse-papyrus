/*******************************************************************************
 * Copyright (c) 2018 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.infra.tools.file;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Manage the deletion of code that has not been access in the code generation
 * process and can be removed.
 * @since 3.0
 */
public interface ICleanUntouched {

	/**
	 * Remove files for which no code has been generated. This enables the
	 * removal of old code e.g. after a suppression or renaming of elements
	 * in the model.
	 *
	 * @param folder
	 *            a folder from which cleaning should start
	 * @param monitor
	 *            a progress monitor
	 * @throws CoreException
	 *             a possible exception during file operations
	 */
	public void cleanUntouched(IFolder folder, IProgressMonitor monitor) throws CoreException;
}
