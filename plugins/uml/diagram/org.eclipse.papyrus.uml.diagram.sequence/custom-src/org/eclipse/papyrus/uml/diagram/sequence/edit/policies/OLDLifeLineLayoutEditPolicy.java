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


package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.sequence.command.SetLocationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.figures.DestructionEventFigure;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;

/**
 *
 * This class is manage border item and element inside Lifeline
 * @since 3.0
 *
 */
public class OLDLifeLineLayoutEditPolicy extends DefaultCreationEditPolicy {



	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCreateElementAndViewCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		ViewAndElementDescriptor descriptor=request.getViewAndElementDescriptor();
		if (UMLDIElementTypes.ACTION_EXECUTION_SPECIFICATION_SHAPE.getSemanticHint().equals(descriptor.getSemanticHint())){
			// get the element descriptor
			CreateElementRequestAdapter requestAdapter =
					request.getViewAndElementDescriptor().getCreateElementRequestAdapter();
			// get the semantic request
			CreateElementRequest createElementRequest =
					(CreateElementRequest) requestAdapter.getAdapter(
							CreateElementRequest.class);
			View view = (View)getHost().getModel();
			EObject hostElement = ViewUtil.resolveSemanticElement(view);
			createElementRequest.setContainer(hostElement.eContainer());
			createElementRequest.setParameter(SequenceRequestConstant.COVERED, hostElement);

		}
		return super.getCreateElementAndViewCommand(request);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getSetBoundsCommand(CreateViewRequest request, CreateViewRequest.ViewDescriptor descriptor) {
		ICommand setBoundsCommand = null;
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		// Retrieve parent location
		if( descriptor.getSemanticHint().equals(UMLDIElementTypes.DESTRUCTION_OCCURRENCE_SPECIFICATION_SHAPE.getSemanticHint())){
			Point parentLoc = getHostFigure().getBounds().getLocation().getCopy();
			final Point realWantedLocation;
			Map<?, ?> params = request.getExtendedData();
			Point realLocation = (Point) params.get(AspectUnspecifiedTypeCreationTool.INITIAL_MOUSE_LOCATION_FOR_CREATION);
			if (realLocation != null) {
				realWantedLocation = realLocation.getCopy();
			} else {
				// we use this location to be able to create Port in the corners of the figure
				realWantedLocation = request.getLocation().getCopy();
			}
			// Compute relative creation location
			Point requestedLocation = realWantedLocation.getCopy();

			//The position of the node must be relation form its container
			requestedLocation.translate(parentLoc.negate());
			//In the case of the destruction event we contsider the center as the origin.

			DestructionEventFigure destructionEventFigure= new DestructionEventFigure();
			requestedLocation.y=requestedLocation.y-destructionEventFigure.getDefaultSize().height/2;
			setBoundsCommand = new SetLocationCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, descriptor, requestedLocation);
		}
		else{
			super.getSetBoundsCommand(request, descriptor);
		}



		return setBoundsCommand;
	}


	/**
	 * {@inheritDoc}
	 */
	protected IFigure getHostFigure() {
		return ((GraphicalEditPart) getHost()).getFigure();
	}
}
