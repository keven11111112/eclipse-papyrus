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

import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.IPageUtils;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.editor.welcome.IWelcomePageService;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;

/**
 * Handler for the <em>Show Welcome Page</em> menu command.
 */
public class ShowWelcomePageHandler extends AbstractWelcomePageHandler {

	public ShowWelcomePageHandler() {
		super();
	}

	@Override
	protected void doExecute(IMultiDiagramEditor editor, IWelcomePageService welcomeService) {
		welcomeService.openWelcomePage();
	}

	@Override
	protected boolean isEnabled(IMultiDiagramEditor editor, IPage activePage, IWelcomePageService welcomeService) {
		return (activePage == null) || (IPageUtils.getRawModel(activePage) != welcomeService.getWelcome());
	}
}
