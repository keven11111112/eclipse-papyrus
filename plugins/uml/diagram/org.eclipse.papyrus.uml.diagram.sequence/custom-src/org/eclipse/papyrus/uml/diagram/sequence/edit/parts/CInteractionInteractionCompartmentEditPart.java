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
 * @author Céline JANSSENS
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getCommand(org.eclipse.gef.Request)
	 *
	 * @param _request
	 * @return
	 */
	@Override
	public Command getCommand(Request request) {
		Command cmd = null;
		if (understandsRequest(request)) {
			cmd = super.getCommand(request);
		}
		return cmd;
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#understandsRequest(org.eclipse.gef.Request)
	 *
	 * @param req
	 * @return
	 */
	@Override
	public boolean understandsRequest(Request req) {
		boolean understand = super.understandsRequest(req);
		if (understand && req instanceof CreateViewAndElementRequest && req.getType().equals(REQ_CREATE)) {
			CreateViewAndElementRequest request = (CreateViewAndElementRequest) req;
			ViewAndElementDescriptor descriptor = request.getViewAndElementDescriptor();
			IElementType elementType = (IElementType) descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.DURATION_CONSTRAINT_SHAPE)) {
				understand = false;
			}


		}
		return understand;
	}
}
