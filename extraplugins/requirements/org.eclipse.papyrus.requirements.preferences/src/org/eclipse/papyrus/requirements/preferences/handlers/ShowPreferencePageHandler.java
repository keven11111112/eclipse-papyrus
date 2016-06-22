/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.preferences.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.handlers.HandlerUtil;

public final class ShowPreferencePageHandler extends AbstractHandler {

	private static final String PREFERENCE_PAGE_ID = "org.eclipse.papyrus.requirements.preferences.PreferencePage"; //$NON-NLS-1$

	public final Object execute(final ExecutionEvent event)
			throws ExecutionException {

		final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);

		final Shell shell = activeWorkbenchWindow.getShell();
		if (shell == null) {
			throw new ExecutionException("No shell for active workbench window"); //$NON-NLS-1$
		}

		final PreferenceDialog dialog = PreferencesUtil
				.createPreferenceDialogOn(shell, PREFERENCE_PAGE_ID, null, null);
		dialog.open();

		return null;
	}

}