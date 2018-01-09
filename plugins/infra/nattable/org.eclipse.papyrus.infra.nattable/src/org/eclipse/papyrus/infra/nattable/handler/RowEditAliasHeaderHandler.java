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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.infra.nattable.manager.table.AbstractNattableWidgetManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;

//TODO : this handler should be declare on org.eclipse.ui.edit (or something like this) to be binded on F2

public class RowEditAliasHeaderHandler extends AbstractTableHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		NatEventData eventData = getNatEventData();
		if (eventData!=null) {
			AbstractNattableWidgetManager manager = (AbstractNattableWidgetManager) getCurrentNattableModelManager();
			manager.openEditRowAliasDialog(eventData);
		}
		return null;
	}

	/**
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {// it must be the nattable selection event
		super.setEnabled(evaluationContext);
		final NatEventData eventData = getNatEventData();
		final NattableModelManager manager = (NattableModelManager) getCurrentNattableModelManager();
		if(isEnabled() && eventData!=null && manager!=null ){
			setBaseEnabled(manager.canEditRowHeader(eventData));
		} else {
			setBaseEnabled(false);
		}
	}


}
