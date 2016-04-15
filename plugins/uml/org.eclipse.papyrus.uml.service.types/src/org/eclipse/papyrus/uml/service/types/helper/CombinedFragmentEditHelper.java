/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.command.CombinedFragmentDestroyCommand;
import org.eclipse.papyrus.uml.service.types.command.MoveOperandFragmentsCommand;
import org.eclipse.papyrus.uml.service.types.command.SelectAndDeleteCommand;
import org.eclipse.papyrus.uml.service.types.request.MoveOperandFragmentEditRequest;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.UMLFactory;

public class CombinedFragmentEditHelper extends ElementEditHelper {

	/**
	 * @see org.eclipse.papyrus.uml.service.types.helper.ElementEditHelper#getConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param req
	 * @return
	 */
	@Override
	protected ICommand getConfigureCommand(final ConfigureRequest req) {

		ICommand configureCommand = new ConfigureElementCommand(req) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				CombinedFragment combinedFragment = (CombinedFragment) req.getElementToConfigure();
				InteractionOperand operand = UMLFactory.eINSTANCE.createInteractionOperand();
				combinedFragment.getOperands().add(operand);
				operand.setName(NamedElementUtil.getDefaultNameWithIncrement(operand, operand.getOwner().eContents()));

				return CommandResult.newOKCommandResult(combinedFragment);
			}
		};

		return CompositeCommand.compose(configureCommand, super.getConfigureCommand(req));

	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.helper.DefaultEditHelper#getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest)
	 *
	 * @param req
	 * @return
	 */
	@Override
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		return super.getDestroyElementCommand(req);
//		EObject elementToDestroy = req.getElementToDestroy();
//		if (elementToDestroy instanceof CombinedFragment) {
//			CombinedFragment combinedFragment = (CombinedFragment) elementToDestroy;
//			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToDestroy);
//			if (provider != null) {
//				// Retrieve delete command from the Element Edit service
//				ICommand deleteCommand = super.getDestroyElementCommand(req);
////				if (deleteCommand != null) {
////					if (elementToDestroy instanceof CombinedFragment) {
////
////						CompositeCommand deleteAll = new CompositeCommand(req.getLabel());
////						deleteAll.add(deleteCommand);
////						CompositeCommand deleteCfOnly = new CompositeCommand(req.getLabel());
////
////						// remove children from operands and append to parent combined fragment
////						for (InteractionOperand op : combinedFragment.getOperands()) {
////							deleteCfOnly.add(new MoveOperandFragmentsCommand(combinedFragment, op, new MoveOperandFragmentEditRequest(req.getEditingDomain(), combinedFragment)));
////						}
////						deleteCfOnly.add(new CombinedFragmentDestroyCommand(req.getEditingDomain(), provider, req));
////
////						return new SelectAndDeleteCommand(deleteAll, deleteCfOnly, new String[] { "Delete all", "Keep contents" });
////					} else {
//						return deleteCommand;
////					}
////				}
//			}
//		}
//		return UnexecutableCommand.INSTANCE;


	}

}
