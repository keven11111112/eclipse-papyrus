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

package org.eclipse.papyrus.infra.editor.welcome.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.infra.editor.welcome.IWelcomePageService;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * Handler for the <em>Set as Default Welcome Page</em> menu command.
 */
public class SaveDefaultWelcomePageHandler extends AbstractWelcomePageHandler {

	public SaveDefaultWelcomePageHandler() {
		super();
	}

	@Override
	protected void doExecute(IMultiDiagramEditor editor, IWelcomePageService welcomeService) {
		try {
			welcomeService.saveWelcomePageAsDefault();
			welcomeService.resetWelcomePage(); // And pick up this new default layout
		} catch (CoreException e) {
			StatusAdapter adapter = new StatusAdapter(e.getStatus());
			adapter.setProperty(IStatusAdapterConstants.TIMESTAMP_PROPERTY, System.currentTimeMillis());
			adapter.setProperty(IStatusAdapterConstants.EXPLANATION_PROPERTY, "The Welcome Page layout could not be saved in the workspace.");
			adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, "Set Default Welcome Page Layout");

			StatusManager.getManager().handle(adapter, StatusManager.SHOW);
		}
	}
}
