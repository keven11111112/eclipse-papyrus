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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This advice add automatically the constrained element (occurrence specification) for a time constraint 
 * @since 3.0
 */
public class GeneralOrderingHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {
		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {


				final GeneralOrdering generalOrdering = (GeneralOrdering) request.getElementToConfigure();
				{//set Before
					Object paramObject = this.getRequest().getParameter(CreateRelationshipRequest.SOURCE);
					if (paramObject instanceof OccurrenceSpecification) {
						generalOrdering.setBefore((OccurrenceSpecification)paramObject);
					}
				}
				{//set After

					Object paramObject =  this.getRequest().getParameter(CreateRelationshipRequest.TARGET);
					if (paramObject instanceof OccurrenceSpecification) {
						generalOrdering.setAfter((OccurrenceSpecification)paramObject);
					}
				}

				return CommandResult.newOKCommandResult(generalOrdering);
			}
		};
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Add a command to related association end during re-orient.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeReorientRelationshipCommand(ReorientRelationshipRequest request) {

		ICommand gmfCommand = super.getBeforeReorientRelationshipCommand(request);
		final GeneralOrdering generalOrdering = (GeneralOrdering) request.getRelationship();

		SetRequest setTypeRequest = null;

		if (request.getDirection() == ReorientRelationshipRequest.REORIENT_SOURCE) {
			Object paramObject =request.getNewRelationshipEnd();
			System.out.println(paramObject);
			if (paramObject instanceof OccurrenceSpecification) {
				setTypeRequest = new SetRequest((OccurrenceSpecification)paramObject, UMLPackage.eINSTANCE.getGeneralOrdering_Before(), generalOrdering);
			}
			else{
				return UnexecutableCommand.INSTANCE;
			}
		}
		else{
			Object paramObject =request.getNewRelationshipEnd();
			if (paramObject instanceof OccurrenceSpecification) {
				setTypeRequest = new SetRequest((OccurrenceSpecification)paramObject, UMLPackage.eINSTANCE.getGeneralOrdering_After(), generalOrdering);
			}
			else{
				return UnexecutableCommand.INSTANCE;
			}

			if (setTypeRequest != null) {
				// Propagate parameters to the set request
				//setTypeRequest.addParameters(request.getParameters());

				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(generalOrdering);
				if (provider != null) {
					ICommand setTypeCommand = provider.getEditCommand(setTypeRequest);
					gmfCommand = CompositeCommand.compose(gmfCommand, setTypeCommand);
				}
			}
		}
		return gmfCommand;
	}
	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#approveRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		if (request instanceof GetEditContextRequest){
			GetEditContextRequest contextRequest= (GetEditContextRequest)request;
			IEditCommandRequest editCommandRequest=contextRequest.getEditCommandRequest();
			if(editCommandRequest instanceof CreateRelationshipRequest){
				CreateRelationshipRequest relationshipRequest= (CreateRelationshipRequest)editCommandRequest;
				if (relationshipRequest.getSource() == null && relationshipRequest.getTarget() == null) {
					return false;
				}
				if (relationshipRequest.getSource() != null && false == relationshipRequest.getSource() instanceof OccurrenceSpecification) {
					return false;
				}
				if (relationshipRequest.getTarget() != null && false == relationshipRequest.getTarget() instanceof OccurrenceSpecification) {
					return false;
				}
			}
		}
		return super.approveRequest(request);
	}
}
