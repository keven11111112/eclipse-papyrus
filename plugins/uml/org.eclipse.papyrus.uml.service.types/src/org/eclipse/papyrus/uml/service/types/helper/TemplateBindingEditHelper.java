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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.UMLPackage;

public class TemplateBindingEditHelper extends DirectedRelationshipEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getSourceReference() {
		return UMLPackage.eINSTANCE.getTemplateBinding_BoundElement();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EReference getTargetReference() {
		return UMLPackage.eINSTANCE.getTemplateBinding_Signature();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean canCreate(EObject source, EObject target) {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof TemplateableElement) {
			return false;
		}
		if(target != null && false == target instanceof TemplateableElement) {
			return false;
		}
		if(target != null && target instanceof TemplateableElement && ((TemplateableElement)target).getOwnedTemplateSignature() == null) {
			return false;
		}
		if(source == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getConfigureCommand(final ConfigureRequest req) {
		ICommand configureCommand = new ConfigureElementCommand(req) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				DirectedRelationship element = (DirectedRelationship)req.getElementToConfigure();
				if(req.getParameter(CreateRelationshipRequest.SOURCE) != null) {
					element.eSet(getSourceReference(), getSourceObject(req));
				}
				if(req.getParameter(CreateRelationshipRequest.TARGET) != null) {
					element.eSet(getTargetReference(), ((TemplateableElement)getTargetObject(req)).getOwnedTemplateSignature());
				}
				return CommandResult.newOKCommandResult(element);
			}
		};
		return CompositeCommand.compose(configureCommand, super.getConfigureCommand(req));
	}
}
