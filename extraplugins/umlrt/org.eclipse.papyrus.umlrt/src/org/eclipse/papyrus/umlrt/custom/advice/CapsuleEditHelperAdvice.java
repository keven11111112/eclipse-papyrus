/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Onder Gurcan <onder.gurcan@cea.fr>
 *
 *****************************************************************************/

package org.eclipse.papyrus.umlrt.custom.advice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Class;


/**
 * The helperadvice class used for UMLRealTime::Protocol.
 *
 * @author Onder Gurcan <onder.gurcan@cea.fr>
 *
 */
public class CapsuleEditHelperAdvice extends AbstractEditHelperAdvice {

	private enum Relation {
		CHILD, SIBLING, PARENT;
	}


	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		final Class capsule = (Class) request.getElementToConfigure();
		final String name = NamedElementUtil.getDefaultNameWithIncrementFromBase("Capsule", capsule.eContainer().eContents());

		return new ConfigureElementCommand(request) {
			private IProgressMonitor progressMonitor;
			private IAdaptable info;

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				this.progressMonitor = progressMonitor;
				this.info = info;

				capsule.setIsActive(true);
				capsule.setName(name);

				return CommandResult.newOKCommandResult(capsule);
			}			

		};
	}
}
