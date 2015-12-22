/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
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

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Region;

/**
 * Edit helper class for {@link FinalState}
 * 
 * Expected behavior:
 * - Avoid to create a {@link Region} as child node of the {@link FinalState} 
 * 
 * @since 4.1
 */
public class FinalStateHelper extends ElementEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getCreateCommand(final CreateElementRequest req) {
		if (!(req.getContainer() instanceof FinalState)) {
			return null;
		}
		IElementType elementToCreate = req.getElementType();
		if (UMLElementTypes.REGION == elementToCreate) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getCreateCommand(req);
	}
	
}
