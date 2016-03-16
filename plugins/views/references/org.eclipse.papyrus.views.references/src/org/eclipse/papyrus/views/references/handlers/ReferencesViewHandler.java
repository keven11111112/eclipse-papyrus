/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.views.references.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.views.references.utils.HandleReferences;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler used to show the 'References' view.
 */
public class ReferencesViewHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		HandleReferences.INSTANCE.openViewAndLaunchSearch(HandlerUtil.getCurrentStructuredSelection(event));
		return null;
	}
}
