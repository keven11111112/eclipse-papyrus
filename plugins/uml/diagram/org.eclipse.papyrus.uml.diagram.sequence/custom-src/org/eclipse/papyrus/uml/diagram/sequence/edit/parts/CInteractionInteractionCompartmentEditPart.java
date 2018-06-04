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

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;

/**
 * @author Celine JANSSENS
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
		if (request instanceof CreateViewAndElementRequest && request.getType().equals(REQ_CREATE)) {
			CreateViewAndElementRequest createrequest = (CreateViewAndElementRequest) request;
			ViewAndElementDescriptor descriptor = createrequest.getViewAndElementDescriptor();
			IElementType elementType = descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.DURATION_CONSTRAINT_SHAPE)) {
				return null;
			}
		}

		// ExecutionSpecification can't be drop into Interaction
		if (request instanceof ChangeBoundsRequest) {
			List<?> editParts = ((ChangeBoundsRequest) request).getEditParts();
			if(null != editParts && !editParts.isEmpty()) {
				for (Object part : editParts) {
					if (part instanceof AbstractExecutionSpecificationEditPart) {
						return UnexecutableCommand.INSTANCE;
					}
				}
			}
		}
		return super.getCommand(request);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart#getTargetEditPart(org.eclipse.gef.Request)
	 *
	 * @param request
	 * @return
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof ReconnectRequest) {
			return this.getParent();
		}
		return super.getTargetEditPart(request);
	}
}
