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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.IPageUtils;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.editor.welcome.IWelcomePageService;
import org.eclipse.papyrus.infra.editor.welcome.Welcome;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler for the <em>Reset Welcome Page</em> menu command.
 */
public class ResetWelcomePageHandler extends AbstractHandler {

	public ResetWelcomePageHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);

		if (editor instanceof IMultiDiagramEditor) {
			try {
				IWelcomePageService welcomeService = ((IMultiDiagramEditor) editor).getServicesRegistry().getService(IWelcomePageService.class);
				welcomeService.resetWelcomePage();
			} catch (ServiceException e) {
				throw new ExecutionException("Could not obtain the welcome-page service.", e); //$NON-NLS-1$
			}
		}

		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		boolean enable = false;

		Object editor = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_EDITOR_NAME);

		if (editor instanceof IMultiDiagramEditor) {
			ISashWindowsContainer sashContainer = ((IMultiDiagramEditor) editor).getAdapter(ISashWindowsContainer.class);
			if ((sashContainer != null) && !sashContainer.isDisposed()) {
				IPage activePage = sashContainer.getActiveSashWindowsPage();
				enable = (activePage != null) && (IPageUtils.getRawModel(activePage) instanceof Welcome);
			}
		}

		setBaseEnabled(enable);
	}
}
