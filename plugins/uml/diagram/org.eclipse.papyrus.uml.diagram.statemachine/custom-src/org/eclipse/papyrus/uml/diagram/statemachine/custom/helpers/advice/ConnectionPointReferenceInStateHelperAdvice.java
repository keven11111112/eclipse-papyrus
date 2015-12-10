/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.State;

public class ConnectionPointReferenceInStateHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		IElementType type = request.getElementType();
		if (type == null || type != UMLElementTypes.ConnectionPointReference_Shape) {
			return null;
		}
		State state = (State) request.getContainer();
		if (!state.getRegions().isEmpty() || (state.getSubmachine() == null)) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getBeforeCreateCommand(request);
	}
	
}
