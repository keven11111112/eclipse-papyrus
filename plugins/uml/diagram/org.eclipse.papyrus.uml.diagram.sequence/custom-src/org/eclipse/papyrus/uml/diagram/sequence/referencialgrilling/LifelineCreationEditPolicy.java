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

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

/**
 * This editPolicy has in charge to redirect creation of element to interaction
 *
 */
public class LifelineCreationEditPolicy extends DefaultCreationEditPolicy {
	protected DisplayEvent displayEvent;

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCreateElementAndViewCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		// Used during the drop from the model explorer
		if (request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest req = (CreateViewAndElementRequest) request;
			ViewAndElementDescriptor descriptor = (req).getViewAndElementDescriptor();
			IElementType elementType = (IElementType) descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (isControlledByLifeline(elementType)) {
				// get the element descriptor
				CreateElementRequestAdapter requestAdapter = req.getViewAndElementDescriptor().getCreateElementRequestAdapter();
				// get the semantic request
				CreateElementRequest createElementRequest = (CreateElementRequest) requestAdapter.getAdapter(
						CreateElementRequest.class);
				View view = (View) getHost().getModel();
				EObject hostElement = ViewUtil.resolveSemanticElement(view);
				createElementRequest.setContainer(hostElement.eContainer());
				createElementRequest.setParameter(org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant.COVERED, hostElement);
				// case of Message Occurence Specification
				MessageOccurrenceSpecification mos = displayEvent.getMessageEvent(getHostFigure().getParent().getParent(), ((CreateRequest) request).getLocation());
				if (mos != null) {
					createElementRequest.setParameter(org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant.REPLACE_EXECUTION_SPECIFICATION_START, mos);
				}
			}
		}
		return super.getCreateElementAndViewCommand(request);
	}

	/**
	 * test if the element Type that is normally not a child of the Lifeline should be controlled by the lifeline.
	 * Then The lifeline will be set as the parent editpart, but not as the semantic parent.
	 * 
	 * This is the case of most of the affixed node.
	 * 
	 * @param elementType
	 *            the tested element type
	 * @return true if the Lifeline should be the
	 */
	protected boolean isControlledByLifeline(IElementType elementType) {
		boolean controlledByLifeline = false;

		if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.ACTION_EXECUTION_SPECIFICATION_SHAPE)) {
			controlledByLifeline = true;
		} else if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION_SHAPE)) {
			controlledByLifeline = true;
		} else if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.TIME_CONSTRAINT_SHAPE)) {
			controlledByLifeline = true;
		} else if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.STATE_INVARIANT_SHAPE)) {
			controlledByLifeline = true;
		} else if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.COMBINED_FRAGMENT_CO_REGION_SHAPE)) {
			controlledByLifeline = true;
		} else if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.DURATION_CONSTRAINT_SHAPE)) {
			controlledByLifeline = true;
		}

		return controlledByLifeline;

	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#setHost(org.eclipse.gef.EditPart)
	 *
	 * @param host
	 */
	@Override
	public void setHost(EditPart host) {
		// TODO Auto-generated method stub
		super.setHost(host);
		displayEvent = new DisplayEvent(getHost());
	}

	/**
	 * Return the host's figure.
	 * The super calls getFigure(). This is a problem when used with shapecompartments. Instead,
	 * return getContextPane(). In shape comaprtments this will return the correct containing figure.
	 */
	protected IFigure getHostFigure() {
		return ((GraphicalEditPart) getHost()).getContentPane();
	}
}
