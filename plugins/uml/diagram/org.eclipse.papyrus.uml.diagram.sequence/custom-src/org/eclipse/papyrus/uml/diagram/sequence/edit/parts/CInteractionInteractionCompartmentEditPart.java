/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;

/**
 * @author C�line JANSSENS
 *
 */
public class CInteractionInteractionCompartmentEditPart extends InteractionInteractionCompartmentEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CInteractionInteractionCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getCommand(org.eclipse.gef.Request)
	 *
	 * @param _request
	 * @return
	 */
	@Override
	public Command getCommand(Request request) {
		if ( request instanceof CreateViewAndElementRequest && request.getType().equals(REQ_CREATE)) {
			CreateViewAndElementRequest createrequest = (CreateViewAndElementRequest) request;
			ViewAndElementDescriptor descriptor = createrequest.getViewAndElementDescriptor();
			IElementType elementType = (IElementType) descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.DURATION_CONSTRAINT_SHAPE)) {
				return null;
			}


		}
		return super.getCommand(request);
	}

}
