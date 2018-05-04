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
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.command.SetResizeCommand;


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
