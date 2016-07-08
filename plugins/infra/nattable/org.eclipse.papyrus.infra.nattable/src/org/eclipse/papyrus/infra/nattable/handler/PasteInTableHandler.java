/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 476618
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.nattable.utils.AbstractPasteInsertInTableHandler;
import org.eclipse.papyrus.infra.nattable.utils.PasteInsertUtil;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Paste Handler.
 */
public class PasteInTableHandler extends AbstractPasteInsertInTableHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		return PasteInsertUtil.paste(getCurrentNattableModelManager(), HandlerUtil.getCurrentSelection(event), event.getParameters());
	}

}
