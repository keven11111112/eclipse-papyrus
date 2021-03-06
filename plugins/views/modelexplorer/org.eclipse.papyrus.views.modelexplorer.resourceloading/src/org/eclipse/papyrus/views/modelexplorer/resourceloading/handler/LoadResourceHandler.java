/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos, CEA, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Hemery (Atos) vincent.hemery@atos.net - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 415639
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.resourceloading.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.AbstractCommand.NonDirtying;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.resourceloading.util.LoadingUtils;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;

/**
 * Handler for the load resource action.
 * This actions load a resource in the model set, which is not yet loaded (due to resource loading strategy).
 */
public class LoadResourceHandler extends AbstractCommandHandler {


	/**
	 * Get the command to load resource of selected model object
	 *
	 * @return the command
	 */
	@Override
	protected Command getCommand(final IEvaluationContext context) {
		TransactionalEditingDomain editingDomain = getEditingDomain(context);
		List<EObject> selection = getSelectedElements();
		if (editingDomain != null && editingDomain.getResourceSet() instanceof ModelSet && selection.size() > 0) {
			final ModelSet set = (ModelSet) editingDomain.getResourceSet();
			class NonDirtyingCompound extends CompoundCommand implements NonDirtying {
				// Empty
			}
			CompoundCommand command = new NonDirtyingCompound();
			List<URI> handledURI = new ArrayList<URI>();
			for (EObject sel : selection) {
				if (sel.eIsProxy()) {
					InternalEObject internal = (InternalEObject) sel;
					URI uriProxy = internal.eProxyURI();
					final URI uriTrim = uriProxy.trimFragment().trimFileExtension();
					if (!handledURI.contains(uriTrim)) {
						handledURI.add(uriTrim);
						class LoadCommand extends AbstractCommand implements NonDirtying {

							public void redo() {
								LoadingUtils.loadResourcesInModelSet(set, uriTrim);
							}

							public void execute() {
								redo();
							}

							@Override
							public boolean canExecute() {
								return true;
							}
						}
						;
						command.append(new LoadCommand());
					}
				}
			}
			return command;
		}
		return UnexecutableCommand.INSTANCE;
	}

}
