/*****************************************************************************
 * Copyright (c) 2017, 2018 CEA LIST, EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   EclipseSource - Bug 533770
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.command.SetResizeCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CInteractionOperandEditPart;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;


/**
 * This class is used to allow the resize and adding of children of the combined Fragment
 *
 */
public class ResizeOperandEditPolicy extends GraphicalEditPolicy {


	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 *
	 */
	@Override
	public void activate() {
		super.activate();
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 *
	 */
	@Override
	public void deactivate() {
		super.activate();
	}

	/**
	 * Factors incoming requests into various specific methods.
	 *
	 * @see org.eclipse.gef.EditPolicy#getCommand(Request)
	 */
	@Override
	public Command getCommand(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest req = (CreateViewAndElementRequest) request;
			ViewAndElementDescriptor descriptor = (req).getViewAndElementDescriptor();
			IElementType elementType = descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.INTERACTION_OPERAND_SHAPE)) {
				Node combinedFragmentNode = (Node) ((GraphicalEditPart) (getHost().getParent())).getNotationView();
				// we add a new Operand so we add the default height
				int height = ((Bounds) combinedFragmentNode.getLayoutConstraint()).getHeight();
				if (getHost().getChildren().size() > 0) {
					int newHeight = height + CInteractionOperandEditPart.DEFAULT_HEIGHT;

					return new ICommandProxy(new SetResizeCommand(getEditingDomain(), "set dimension", new EObjectAdapter(combinedFragmentNode), new Dimension(BoundForEditPart.getWidthFromView(combinedFragmentNode), newHeight)));
				}
			}
		}
		if (RequestConstants.REQ_RESIZE_CHILDREN.equals(request.getType())) {
			CompositeCommand compositeCommand = new CompositeCommand("Resize Operands");
			ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;
			List<?> editParts = changeBoundsRequest.getEditParts();
			// the user can resize only one InteractionOperand
			if (editParts.size() > 1) {
				return null;
			}

			TransactionalEditingDomain editingDomain = getEditingDomain();

			Object currentEditPart = editParts.get(0);
			updateCurrentChildSize(compositeCommand, changeBoundsRequest, editingDomain, currentEditPart);
			return new ICommandProxy(compositeCommand);
		}
		return null;
	}

	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return editingDomain;
	}

	private void updateCurrentChildSize(CompositeCommand compositeCommand, ChangeBoundsRequest changeBoundsRequest, TransactionalEditingDomain editingDomain, Object currentEditPart) {
		GraphicalEditPart operandPart = (GraphicalEditPart) currentEditPart;
		View shapeView = NotationHelper.findView(operandPart);
		Dimension size = operandPart.getFigure().getSize();

		size.expand(changeBoundsRequest.getSizeDelta().width, changeBoundsRequest.getSizeDelta().height);

		ICommand setBoundsCommand = new SetResizeCommand(editingDomain, "Resize Operands", new EObjectAdapter(shapeView), size);
		compositeCommand.add(setBoundsCommand);
	}

}
