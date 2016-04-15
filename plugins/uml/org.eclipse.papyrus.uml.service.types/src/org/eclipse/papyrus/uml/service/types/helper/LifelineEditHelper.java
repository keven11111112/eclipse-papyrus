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
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;

public class LifelineEditHelper extends ElementEditHelper {

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#configureRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 *
	 * @param request
	 */
	@Override
	protected void configureRequest(IEditCommandRequest request) {
		if (request instanceof CreateElementRequest) {
			CreateElementRequest createRequest = (CreateElementRequest) request;

			if (createRequest.getContainer() instanceof Lifeline) {
				createRequest.getParameters().put(SequenceRequestConstant.COVERED, createRequest.getContainer());
			}

			IElementType elementtype = createRequest.getElementType();

			if (UMLPackage.eINSTANCE.getExecutionSpecification().isSuperTypeOf(elementtype.getEClass())) {
				Object containerParam = request.getParameters().get(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER);
				if (containerParam instanceof Interaction || containerParam instanceof InteractionOperand) {


					EObject newContainer = (EObject) containerParam;

					if (newContainer instanceof Interaction) {
						createRequest.setContainer(newContainer);
						createRequest.setContainmentFeature(UMLPackage.eINSTANCE.getInteraction_Fragment());
					} else if (newContainer instanceof InteractionOperand) {
						createRequest.setContainer(newContainer);
						createRequest.setContainmentFeature(UMLPackage.eINSTANCE.getInteractionOperand_Fragment());
					}
				}
			}
		}
		super.configureRequest(request);
	}




	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.helper.DefaultEditHelper#getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest)
	 *
	 * @param req
	 * @return
	 */
	@Override
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		EObject objectToDelete = req.getElementToDestroy();
		if (objectToDelete instanceof Lifeline) {
			Lifeline lifeline = (Lifeline) objectToDelete;

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(objectToDelete);
			if (provider != null) {
				// Retrieve delete command from the Element Edit service
				ICommand deleteCommand = super.getDestroyElementCommand(req);
				if (deleteCommand != null) {

					CompositeCommand deleteElementsCommand = new CompositeCommand(req.getLabel());
					deleteElementsCommand.add(deleteCommand);

					// Destroy all the interactionFragments that cover only the lifeline being deleted
					for (InteractionFragment interactionFragment : lifeline.getCoveredBys()) {
						if (interactionFragment.getCovereds().size() == 1) {
							DestroyElementRequest destroyRequest = new DestroyElementRequest(req.getEditingDomain(), interactionFragment, false);
							deleteElementsCommand.add(new DestroyElementCommand(destroyRequest));
						}
					}

					return deleteElementsCommand;
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}



}
