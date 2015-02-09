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
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.PackageableElement;

public class NamespaceOwnedMemberReorientCommand extends EditElementCommand {

	private final int reorientDirection;
	private final EObject referenceOwner;
	private final EObject oldEnd;
	private final EObject newEnd;

	public NamespaceOwnedMemberReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	@Override
	public boolean canExecute() {
		if (false == referenceOwner instanceof org.eclipse.uml2.uml.Namespace) {
			return false;
		}
		if (reorientDirection == ReorientRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Element && (newEnd instanceof org.eclipse.uml2.uml.Class || newEnd instanceof org.eclipse.uml2.uml.Package))) {
			return false;
		}
		if (getOldTarget() instanceof Classifier && !(getNewSource() instanceof org.eclipse.uml2.uml.Class))
		{
			return false;
		}
		if (getOldTarget() instanceof Package && !(getNewSource() instanceof org.eclipse.uml2.uml.Package))
		{
			return false;
		}
		// No transitive
		if (isContainedTransitively(getNewSource(), getOldTarget()))
		{
			return false;
		}
		// No reflexivity
		if (getOldTarget().equals(getNewSource()))
		{
			return false;
		}
		return true;
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

	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Element && (newEnd instanceof org.eclipse.uml2.uml.Class || newEnd instanceof org.eclipse.uml2.uml.Package))) {
			return false;
		}
		if (getOldSource() instanceof org.eclipse.uml2.uml.Class && !(getNewTarget() instanceof org.eclipse.uml2.uml.Class))
		{
			return false;
		}
		if (getOldSource() instanceof Package && !(getNewTarget() instanceof org.eclipse.uml2.uml.Package))
		{
			return false;
		}
		// No transitive
		if (isContainedTransitively(getOldSource(), getNewTarget()))
		{
			return false;
		}
		// No reflexivity
		if (getNewTarget().equals(getOldSource()))
		{
			return false;
		}
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	protected CommandResult reorientSource() throws ExecutionException {
		if (getNewSource() instanceof org.eclipse.uml2.uml.Package) {
			((org.eclipse.uml2.uml.Package) getNewSource()).getPackagedElements().add((PackageableElement) getOldTarget());
		}
		else if (getNewSource() instanceof org.eclipse.uml2.uml.Class) {
			((org.eclipse.uml2.uml.Class) getNewSource()).getNestedClassifiers().add((Classifier) getOldTarget());
		}
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	protected CommandResult reorientTarget() throws ExecutionException {

		if (getNewSource() instanceof org.eclipse.uml2.uml.Package) {
			((org.eclipse.uml2.uml.Package) getOldSource()).getPackagedElements().add((PackageableElement) getNewTarget());
		}
		else if (getNewSource() instanceof org.eclipse.uml2.uml.Class) {
			((org.eclipse.uml2.uml.Class) getOldSource()).getNestedClassifiers().add((Classifier) getNewTarget());
		}
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	protected org.eclipse.uml2.uml.Namespace getOldSource() {
		return (org.eclipse.uml2.uml.Namespace) referenceOwner;
	}

	protected org.eclipse.uml2.uml.Namespace getNewSource() {
		return (org.eclipse.uml2.uml.Namespace) newEnd;
	}

	protected org.eclipse.uml2.uml.Namespace getOldTarget() {
		return (org.eclipse.uml2.uml.Namespace) oldEnd;
	}

	protected org.eclipse.uml2.uml.Namespace getNewTarget() {
		return (org.eclipse.uml2.uml.Namespace) newEnd;
	}
}
