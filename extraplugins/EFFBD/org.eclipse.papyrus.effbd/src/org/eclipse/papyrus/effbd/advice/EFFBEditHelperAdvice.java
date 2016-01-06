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

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The EditHelperAdvice class used for Actor Part
 *
 */
public class EFFBEditHelperAdvice extends AbstractEditHelperAdvice {



	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		SetCommand configureFunction = new SetCommand(request.getEditingDomain(), request.getElementToConfigure(), UMLPackage.eINSTANCE.getNamedElement_Name(), "EFFB");
		ICommand result = CompositeCommand.compose(super.getAfterConfigureCommand(request), new EMFtoGMFCommandWrapper(configureFunction));
		return result;
	}
}
