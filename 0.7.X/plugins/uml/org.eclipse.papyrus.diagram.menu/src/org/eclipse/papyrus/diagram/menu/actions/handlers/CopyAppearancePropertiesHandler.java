/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.diagram.menu.actions.handlers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.papyrus.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.papyrus.diagram.menu.actions.CopyAppearancePropertiesAction;

/**
 * 
 * The handler for the action {@link CopyAppearancePropertiesAction}
 * 
 * 
 */
public class CopyAppearancePropertiesHandler extends GraphicalCommandHandler {

	@Override
	protected Command getCommand() throws ExecutionException {
		CopyAppearancePropertiesAction action = new CopyAppearancePropertiesAction(getSelectedElements());
		Command cmd = action.getCommand();
		return (cmd == null) ? UnexecutableCommand.INSTANCE : cmd;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.handlers.GraphicalCommandHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		if(getSelectedElements().isEmpty() || getSelectedElements().size() == 1) {
			return false;
		}
		return super.isEnabled();
	}

}
