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

import org.eclipse.papyrus.infra.editor.welcome.IWelcomePageService;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;

/**
 * Handler for the <em>Reset Welcome Page</em> menu command.
 */
public class ResetWelcomePageHandler extends AbstractWelcomePageHandler {

	public ResetWelcomePageHandler() {
		super();
	}

	@Override
	protected void doExecute(IMultiDiagramEditor editor, IWelcomePageService welcomeService) {
		welcomeService.resetWelcomePage();
	}
}
