/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.graphics.Image;

/**
 * A drop strategy which delegates to the hard-coded Drop edit policy
 * Called when no other strategy is available (Lowest priority)
 *
 * @author Camille Letavernier
 *
 */
public class DefaultDropStrategy implements DropStrategy {

	protected EditPolicy baseDropEditPolicy;

	protected EditPolicy baseCreationEditPolicy;

	/**
	 * Constructs a generic instance of DefaultDropStrategy.
	 * This instance can only be used as a descriptor.
	 */
	public DefaultDropStrategy() {

	}

	/**
	 * Constructs an instance of DefaultDropStrategy for a specific edit policy
	 *
	 * @param baseDropEditPolicy
	 * @param baseCreationEditPolicy
	 */
	public DefaultDropStrategy(EditPolicy baseDropEditPolicy, EditPolicy baseCreationEditPolicy) {
		this.baseDropEditPolicy = baseDropEditPolicy;
		this.baseCreationEditPolicy = baseCreationEditPolicy;
	}

	public String getLabel() {
		return "Default";
	}

	public String getID() {
		return "default";
	}

	public String getDescription() {
		return "Default drop strategy";
	}

	public List<Command> getCommands(Request request, final EditPart targetEditPart) {
		ArrayList<Command> c = new ArrayList<Command>();
		if (baseDropEditPolicy == null) {
			if (baseCreationEditPolicy == null) {
				return null;
			}
			c.add(baseCreationEditPolicy.getCommand(request));
			return c;
		}

		Command command = baseDropEditPolicy.getCommand(request);

		if (command == null && baseCreationEditPolicy != null) {
			command = baseCreationEditPolicy.getCommand(request);
		}
		c.add(command);

		return c;
	}
	
	/**
	 * The default command to be executed when the strategy is applied.
	 * Should return null if the strategy cannot handle the request.
	 *
	 * @param request
	 *            The drop request
	 * @param targetEditPart
	 *            The target edit part
	 * @return
	 *         A command, or null if the strategy cannot handle the request
	 */
	public Command getCommand(Request request, EditPart targetEditPart){
		List<Command> commands =  getCommands( request, targetEditPart);
		if(commands != null && commands.size()>0){
			return commands.get(0);
		}
		else{
			return null;
		}
		
	}

	public Image getImage() {
		return null;
	}

	public int getPriority() {
		return 100; // Low priority
	}

	public void setOptions(Map<String, Object> options) {
		// Nothing
	}

}
