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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.dnd.Activator;

/**
 * An abstract implementation for TransactionalCommandsDropStrategy. Extenders do not
 * need to implement their commands' #undo and #redo methods.
 * The differences with TransactionalDropStrategy is the fact that this class give the priority to the CommandS rather to the Command 
 *
 * @author Camille Letavernier
 */
public abstract class TransactionalCommandsDropStrategy extends AbstractDropStrategy {

	protected boolean isTransactional(EditPart targetEditPart) {
		return getTransactionalEditingDomain(targetEditPart) != null;
	}

	protected TransactionalEditingDomain getTransactionalEditingDomain(EditPart targetEditPart) {
		EditingDomain domain = getEditingDomain(targetEditPart);
		if (domain instanceof TransactionalEditingDomain) {
			return (TransactionalEditingDomain) domain;
		}
		return null;
	}

	protected EditingDomain getEditingDomain(EditPart targetEditPart) {
		return EMFHelper.resolveEditingDomain(targetEditPart);
	}
	
	protected abstract List<Command> doGetCommands(Request request, EditPart targetEditPart);
	
	
	/**
	 * The command to be executed when the strategy is applied.
	 * Should return null if the strategy cannot handle the request.
	 *
	 * @param request
	 *            The drop request
	 * @param targetEditPart
	 *            The target edit part
	 * @return
	 *         A command, or null if the strategy cannot handle the request
	 */
	protected Command doGetCommand(Request request, EditPart targetEditPart) {
		List<Command> commands = doGetCommands(request, targetEditPart);
		if(commands!=null && commands.size()>0){
			return commands.get(0);
		}
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy#getCommands(org.eclipse.gef.Request, org.eclipse.gef.EditPart)
	 *
	 * @param request
	 * @param targetEditPart
	 * @return
	 */
	public List<Command> getCommands(Request request, EditPart targetEditPart) {
		List<Command> commands = new ArrayList<Command>();
		if(doGetCommands(request,targetEditPart)!=null && doGetCommands(request,targetEditPart).size()!=0){
			commands.addAll(doGetCommands(request,targetEditPart));
		}
		return commands;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy#getCommand(org.eclipse.gef.Request, org.eclipse.gef.EditPart)
	 *
	 * @param request
	 * @param targetEditPart
	 * @return
	 */
	public Command getCommand(Request request, EditPart targetEditPart) {
		List<Command> commands = doGetCommands(request,targetEditPart);
		if(commands!=null && commands.size()>0){
			return commands.get(0);
		}
		return null;
	}
}
