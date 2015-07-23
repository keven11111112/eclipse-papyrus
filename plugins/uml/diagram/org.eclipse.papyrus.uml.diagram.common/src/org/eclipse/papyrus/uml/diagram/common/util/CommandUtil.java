/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Enrich Execution Command
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.diagram.common.Activator;

/**
 * Utility to execute command inside an action.
 *
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CommandUtil {


	private static final String DOMAIN_FORMAT = "The transactional Domain cannot be retrived from the object %s";

	/**
	 * Executes the supplied command inside an <code>unchecked action</code>
	 *
	 * Taken from the CanonicalEditPolicy class
	 *
	 * @param cmd
	 *            command that can be executed (i.e., cmd.canExecute() == true)
	 * @param part
	 */
	public static void executeCommand(final org.eclipse.gef.commands.Command cmd, IGraphicalEditPart part) {
		Map<String, Boolean> options = null;
		boolean isActivating = true;
		// use the viewer to determine if we are still initializing the diagram
		// do not use the DiagramEditPart.isActivating since
		// ConnectionEditPart's parent will not be a diagram edit part
		EditPartViewer viewer = part.getViewer();
		if (viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer) viewer).isInitializing();
		}

		if (isActivating || !EditPartUtil.isWriteTransactionInProgress(part, false, false)) {
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
		}

		AbstractEMFOperation operation = new AbstractEMFOperation((part).getEditingDomain(), StringStatics.BLANK, options) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				cmd.execute();

				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Execute a command as unsafe.
	 * Consequence: the command doesn't appear in the Command Stack and does not make the diagram dirty.
	 *
	 * @param command
	 *            The command to execute unsafe
	 * @param object
	 *            The EObject that is required to define the Transactional domain.
	 * @param synch
	 *            Define if the command should be execute synchronously or not.
	 * @see {@link #resolveEditingDomain}
	 */
	public static void executeUnsafeCommand(final ICommand command, final Object object) {

		TransactionalEditingDomain domain = resolveEditingDomain(object);
		if (domain != null) {
			executeCommand(command, domain);
		}

	}

	/**
	 * Execute a command as unsafe.
	 * Consequence: the command doesn't appear in the Command Stack and does not make the diagram dirty.
	 *
	 * @param command
	 *            The command to execute unsafe
	 * @param object
	 *            The EObject that is required to define the Transactional domain.
	 * @param synch
	 *            Define if the command should be execute synchronously or not.
	 * @see {@link #resolveEditingDomain}
	 */
	public static void executeUnsafeCommand(final Command command, final Object object) {

		TransactionalEditingDomain domain = resolveEditingDomain(object);
		if (domain != null) {
			executeCommand(command, domain);
		}
	}

	/**
	 * Execute a command as unsafe.
	 * Consequence: the command doesn't appear in the Command Stack and does not make the diagram dirty.
	 *
	 * @param command
	 *            The command to execute unsafe
	 * @param object
	 *            The EObject that is required to define the Transactional domain.
	 * @param synch
	 *            Define if the command should be execute synchronously or not.
	 * @see {@link #resolveEditingDomain}
	 */
	public static void executeUnsafeCommand(final Runnable command, final Object object) {

		TransactionalEditingDomain domain = resolveEditingDomain(object);
		if (domain != null) {
			executeCommand(command, domain);
		}

	}

	/**
	 * Execute a command as unsafe.
	 * Consequence: the command doesn't appear in the Command Stack and does not make the diagram dirty.
	 *
	 * @param command
	 *            The command to execute unsafe
	 * @param object
	 *            The EObject that is required to define the Transactional domain.
	 *
	 * @see {@link #resolveEditingDomain}
	 */
	public static void executeCommandInStack(final org.eclipse.emf.common.command.Command command, final Object object) {

		TransactionalEditingDomain domain = resolveEditingDomain(object);
		domain.getCommandStack().execute(command);

	}

	/**
	 * Retrieve Editing Domain from an object.
	 * The Object treated can be a {@link TransactionalEditingDomain}, an {@link EObject} or a {@link IGraphicalEditPart}.
	 *
	 * @param object
	 *            The object used to find the Transactional Editing Domain.
	 *
	 * @return The associated Editing Domain, or null if not found.
	 */
	public static TransactionalEditingDomain resolveEditingDomain(Object object) {
		TransactionalEditingDomain domain = null;
		try {
			if (object instanceof TransactionalEditingDomain) {
				domain = (TransactionalEditingDomain) object;
			} else if (object instanceof IGraphicalEditPart) {
				domain = ((IGraphicalEditPart) object).getEditingDomain();
			} else if (object instanceof EObject) {
				domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain((EObject) object);
			} else {
				Activator.log.error(String.format(DOMAIN_FORMAT, object.toString()), null);
			}
		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		return domain;
	}

	/**
	 * Run the Command Asynchronously
	 *
	 * @param command
	 *            The command to execute
	 * @param domain
	 *            The Transactional Editing Domain
	 *
	 */
	public static void executeCommand(final Command command, final TransactionalEditingDomain domain) {

		try {
			GMFUnsafe.write(domain, command);
		} catch (Exception e) {
			Activator.log.error(e);
		}

	}

	/**
	 * Run the Command Asynchronously
	 *
	 * @param command
	 *            The command to execute
	 * @param domain
	 *            The Transactional Editing Domain
	 *
	 */
	private static void executeCommand(final ICommand command, final TransactionalEditingDomain domain) {
		try {
			GMFUnsafe.write(domain, command);
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Run the Command Asynchronously
	 *
	 * @param command
	 *            The command to execute
	 * @param domain
	 *            The Transactional Editing Domain
	 *
	 */
	private static void executeCommand(final Runnable command, final TransactionalEditingDomain domain) {
		// use to avoid to put it in the command stack
		try {
			GMFUnsafe.write(domain, command);
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}


}
