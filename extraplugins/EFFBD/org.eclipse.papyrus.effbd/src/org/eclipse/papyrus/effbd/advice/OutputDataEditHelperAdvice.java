/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier(CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.effbd.advice;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.effbd.command.CreateEFFBparamCommand;
import org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * The EditHelperAdvice class used for Actor Part
 *
 */
public class OutputDataEditHelperAdvice extends AbstractEditHelperAdvice {



	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		CreateEFFBparamCommand createEFFBparam = new CreateEFFBparamCommand(request.getEditingDomain(), (ActivityParameterNode) request.getElementToConfigure(), ParameterDirectionKind.OUT_LITERAL);
		ICommand result = CompositeCommand.compose(super.getAfterConfigureCommand(request), new EMFtoGMFCommandWrapper(createEFFBparam));
		return result;
	}
}
