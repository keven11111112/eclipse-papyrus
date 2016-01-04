/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.dnd.strategy;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

/**
 * @author Francois Le Fevre
 *
 */
public interface MultipleDropStrategy extends DropStrategy {

	/**
	 * The list of candidates commandes to be executed when the strategy is applied.
	 * Should return null if the strategy cannot handle the request.
	 *
	 * @param request
	 *            The drop request
	 * @param targetEditPart
	 *            The target edit part
	 * @return
	 *         A list of commands, or null if the strategy cannot handle the request
	 */
	public List<Command> getCommands(Request request, EditPart targetEditPart);

}
