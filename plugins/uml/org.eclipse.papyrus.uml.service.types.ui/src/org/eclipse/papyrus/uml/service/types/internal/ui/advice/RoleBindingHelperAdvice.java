/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.service.types.internal.ui.advice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.service.types.internal.ui.dialogs.CollaborationRoleTreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;


public class RoleBindingHelperAdvice extends AbstractEditHelperAdvice {


	@Override
	protected ICommand getAfterCreateRelationshipCommand(CreateRelationshipRequest request) {
		final EObject reqSource = request.getSource();

		if (reqSource instanceof CollaborationUse) {
			final CollaborationUse source = (CollaborationUse) reqSource;
			final Dependency dependency = (Dependency) request.getNewElement();
			final NamedElement target = (NamedElement) request.getTarget();
			if ((target == null)) {
				return UnexecutableCommand.INSTANCE;
			}


			return new CreateRelationshipCommand(request) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					if (!canExecute()) {
						throw new ExecutionException("Invalid arguments in create link command");
					}


					// Create and open the selection dialog
					ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
					Shell currentShell = new Shell(Display.getCurrent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
					ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(currentShell, new AdapterFactoryLabelProvider(adapterFactory), new CollaborationRoleTreeContentProvider());

					try {
						// Set dialog parameters
						dialog.setTitle("Collaboration role binding");
						dialog.setMessage("Select the role to bind:");
						dialog.setAllowMultiple(false);
						dialog.setHelpAvailable(false);
						// The source CollaborationUse is set as input for the selection dialog,
						// the CollaborationRoleTreeContentProvider provides the roles that can possibly be
						// selected.
						dialog.setInput(source);

						dialog.open();
					} finally {
						adapterFactory.dispose();
					}

					// If a ConnectableElement has been selected, complete command execution
					// using selection as the "newly created" element and make the edited
					// Collaboration reference it in the CollaborationRoles eReference.
					if (dialog.getReturnCode() == Window.OK) {

						ConnectableElement roleToBind = (ConnectableElement) dialog.getFirstResult();
						// Create a Dependency (the binding) between selected role and a ConnectableElement
						// (the target)
						dependency.setName("binding_" + roleToBind.getName() + "_" + target.getName());
						source.getRoleBindings().add(dependency);


						((CreateElementRequest) getRequest()).setNewElement(dependency);

						return CommandResult.newOKCommandResult(dependency);
					}

					// No role selected: abort element creation
					return CommandResult.newCancelledCommandResult();
				}
			};
		}

		return null;

	}



}
