/*****************************************************************************
 * Copyright (c) 2012, 2016 CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 488965
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.util;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 *
 * a helper for the Editor
 * 
 * @since 1.2
 *
 */
public class EditorHelper {

	private EditorHelper() {
		// nothing to do
	}


	/**
	 *
	 * @return
	 * 		the current workbench window or <code>null</code> if not found
	 */
	public static final Shell getActiveShell() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench != null) {
			return workbench.getActiveWorkbenchWindow().getShell();
		}
		return Display.getCurrent().getActiveShell();
	}

	/**
	 *
	 * @return
	 * 		the current workbench window or <code>null</code> if not found
	 */
	public static final IWorkbenchWindow getActiveWindow() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench != null) {
			return workbench.getActiveWorkbenchWindow();
		}
		return null;
	}

	/**
	 *
	 * @return
	 * 		the current editor or <code>null</code> if not found
	 */
	public static final IEditorPart getCurrentEditor() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench != null) {
			final IWorkbenchWindow activeWorkbench = workbench.getActiveWorkbenchWindow();
			if (activeWorkbench != null) {
				final IWorkbenchPage activePage = activeWorkbench.getActivePage();
				if (activePage != null) {
					return activePage.getActiveEditor();
				}
			}
		}
		return null;
	}

	/**
	 *
	 * @return
	 * 		the current active part or <code>null</code> if not found
	 */
	public static final IWorkbenchPart getActivePart() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench != null) {
			final IWorkbenchWindow activeWorkbench = workbench.getActiveWorkbenchWindow();
			if (activeWorkbench != null) {
				final IWorkbenchPage activePage = activeWorkbench.getActivePage();
				if (activePage != null) {
					return activePage.getActivePart();
				}
			}
		}
		return null;
	}
}
