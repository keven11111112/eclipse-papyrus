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

package org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.Activator;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.sync.ISyncService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * Command handler that configures diagram-to-diagram synchronization, with special
 * consideration for the redefinition correspondence semantics of state machines
 * in the UML-RT style.
 */
public class SynchronizeDiagramsHandler extends AbstractHandler {

	public SynchronizeDiagramsHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection sel = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);

		List<?> selection = sel.toList();
		if (selection.size() == 2) {
			EObject first = EMFHelper.getEObject(selection.get(0));
			EObject second = EMFHelper.getEObject(selection.get(1));

			try {
				ISyncService syncService = ServiceUtilsForHandlers.getInstance().getService(ISyncService.class, event);
				if (!syncService.canSynchronize(first, second)) {
					StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot synchronize selected diagrams."), StatusManager.SHOW);
				} else {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(first);
					domain.getCommandStack().execute(new RecordingCommand(domain, event.getCommand().getName()) {
						@Override
						protected void doExecute() {
							syncService.synchronize(first, second);
						}
					});
				}
			} catch (ServiceException e) {
				StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Synchronization service not available.", e), StatusManager.SHOW);
			} catch (NotDefinedException e) {
				StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Command not defined in command handler.", e), StatusManager.SHOW);
			}
		}

		return null;
	}
}
