/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.service.types.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.uml.Classifier;

public class NamespaceOwnedMemberCreateCommand extends EditElementCommand {

	protected final EObject source;

	protected final EObject target;

	public NamespaceOwnedMemberCreateCommand(CreateRelationshipRequest request) {
		super(request.getLabel(), null, request);
		this.source = request.getSource();
		this.target = request.getTarget();
	}

	protected boolean isContainedTransitively(EObject owner, EObject owned) {
		List<EObject> owners = new ArrayList<EObject>();
		EObject it = owner;
		while (it != null)
		{
			owners.add(it);
			it = it.eContainer();
		}

		return owners.contains(owned);
	}

	@Override
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && !(source instanceof org.eclipse.uml2.uml.Package || source instanceof org.eclipse.uml2.uml.Class)) {
			return false;
		}
		if (source instanceof org.eclipse.uml2.uml.Package && !(target instanceof org.eclipse.uml2.uml.Package)) {
			return false;
		}
		if (target != null && !(target instanceof org.eclipse.uml2.uml.Package || target instanceof org.eclipse.uml2.uml.Classifier)) {
			return false;
		}
		if (source instanceof org.eclipse.uml2.uml.Class && !(target instanceof org.eclipse.uml2.uml.Classifier)) {
			return false;
		}
		// No transitive
		if (isContainedTransitively(source, target))
		{
			return false;
		}
		// No reflexivity
		if (source.equals(target))
		{
			return false;
		}
		if (getSource() == null) {
			return true;
		}
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		if (getSource() != null && getTarget() != null) {
			if (getSource() instanceof org.eclipse.uml2.uml.Class) {
				((org.eclipse.uml2.uml.Class) getSource()).getNestedClassifiers().add((Classifier) getTarget());
			} else if (getTarget() instanceof org.eclipse.uml2.uml.Package) {
				((org.eclipse.uml2.uml.Package) getSource()).getPackagedElements().add((org.eclipse.uml2.uml.Package) getTarget());
			}
		}
		return CommandResult.newOKCommandResult();
	}

	@Override
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	protected org.eclipse.uml2.uml.Namespace getSource() {
		return (org.eclipse.uml2.uml.Namespace) source;
	}

	protected org.eclipse.uml2.uml.Namespace getTarget() {
		return (org.eclipse.uml2.uml.Namespace) target;
	}
}
