/*****************************************************************************
 * Copyright (c) 2018 EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation (Bug 533770)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.RelativeHandleLocator;
import org.eclipse.gef.handles.SquareHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.layout.SwimlanesCompartmentLayout;
import org.eclipse.papyrus.uml.diagram.sequence.requests.MoveSeparatorRequest;
import org.eclipse.papyrus.uml.diagram.sequence.tools.SeparatorResizeTracker;
import org.eclipse.uml2.uml.CombinedFragment;

/**
 * <p>
 * An edit policy to resize the {@link CombinedFragment} and its operands.
 * This policy works together with {@link SwimlanesCompartmentLayout},
 * and is allowed to resize the entire {@link CombinedFragmentEditPart},
 * as well as to change the Size of its {@link InteractionOperandEditPart InteractionOperandEditParts}
 * </p>
 *
 * @since 5.0
 */
public class CombinedFragmentResizeEditPolicy extends ResizableEditPolicy {

	/**
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#createSelectionHandles()
	 *
	 * @return
	 */
	@Override
	protected List<Handle> createSelectionHandles() {
		@SuppressWarnings("unchecked")
		List<Handle> handles = super.createSelectionHandles();

		List<GraphicalEditPart> operands = getOperands();
		int separators = operands.size() - 1;

		if (getHost().getSelected() == EditPart.SELECTED_PRIMARY) {
			for (int i = 0; i < separators; i++) {
				handles.add(createSeparatorHandle(i, operands));
			}
		}

		return handles;
	}

	@Override
	public GraphicalEditPart getHost() {
		return (GraphicalEditPart) super.getHost();
	}

	private Handle createSeparatorHandle(int separatorIndex, List<GraphicalEditPart> operands) {
		GraphicalEditPart resizedOperand = operands.get(separatorIndex + 1);
		Locator locator = new RelativeHandleLocator(resizedOperand.getFigure(), PositionConstants.NORTH);
		Handle handle = new SquareHandle(getHost(), locator, Cursors.SIZENS) {

			@Override
			protected DragTracker createDragTracker() {
				return new SeparatorResizeTracker(CombinedFragmentResizeEditPolicy.this.getHost(), PositionConstants.NORTH, separatorIndex);
			}

		};
		return handle;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#getCommand(org.eclipse.gef.Request)
	 *
	 * @param request
	 * @return
	 */
	@Override
	public Command getCommand(Request request) {
		if (request instanceof MoveSeparatorRequest) {
			return getMoveSeparatorCommand((MoveSeparatorRequest) request);
		}
		return super.getCommand(request);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#getResizeCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		Command resizeCFCommand = super.getResizeCommand(request);
		if (resizeCFCommand != null && resizeCFCommand.canExecute()) {
			CompoundCommand command = new CompoundCommand(resizeCFCommand.getLabel());
			command.setDebugLabel("Resize CF & Operand");

			@SuppressWarnings("unchecked")
			List<Command> commands = command.getCommands();
			commands.add(resizeCFCommand);

			ChangeBoundsRequest cbr = request;
			int direction = cbr.getResizeDirection();

			List<GraphicalEditPart> operands = getOperands();
			if (!operands.isEmpty() && ((direction & PositionConstants.NORTH) != 0 || (direction & PositionConstants.SOUTH) != 0)) {
				ChangeBoundsRequest resizeFirstOrLastOperand = new ChangeBoundsRequest();
				GraphicalEditPart operand;
				if ((direction & PositionConstants.NORTH) != 0) {
					operand = operands.get(0);
					resizeFirstOrLastOperand.setResizeDirection(PositionConstants.NORTH);
				} else {
					operand = operands.get(operands.size() - 1);
					resizeFirstOrLastOperand.setResizeDirection(PositionConstants.SOUTH);
				}

				resizeFirstOrLastOperand.setMoveDelta(cbr.getMoveDelta());
				resizeFirstOrLastOperand.setLocation(cbr.getLocation());
				resizeFirstOrLastOperand.setEditParts(operand);
				resizeFirstOrLastOperand.setSizeDelta(new Dimension(0, cbr.getSizeDelta().height));
				resizeFirstOrLastOperand.setType(RequestConstants.REQ_RESIZE);
				commands.add(operand.getCommand(resizeFirstOrLastOperand));
			} else {
				// Width change only; nothing is required.
				// XXX Optionally, we may force the new width to all operands. That's not required, as the layout
				// will take care of that anyway.
				return resizeCFCommand;
			}

			return command;
		}

		return resizeCFCommand;
	}

	protected Command getMoveSeparatorCommand(MoveSeparatorRequest request) {
		int separatorIndex = request.getSeparatorIndex();
		if (separatorIndex < 0 || separatorIndex > getOperands().size() - 1) {
			return UnexecutableCommand.INSTANCE;
		}

		double moveDistance = request.getMoveDelta().getDistance(new Point(0, 0));
		if (moveDistance < 5) {
			return UnexecutableCommand.INSTANCE;
		}


		ChangeBoundsRequest requestAbove = getResizeAboveRequest(request);
		ChangeBoundsRequest requestBelow = getResizeBelowRequest(request);

		CompoundCommand moveSeparatorCommand = new CompoundCommand("Move Operands Separator");
		moveSeparatorCommand.add(getOperandAbove(request).getCommand(requestAbove));
		moveSeparatorCommand.add(getOperandBelow(request).getCommand(requestBelow));

		return moveSeparatorCommand;
	}

	protected GraphicalEditPart getOperandAbove(MoveSeparatorRequest request) {
		return getOperandAbove(request.getSeparatorIndex());
	}

	protected GraphicalEditPart getOperandAbove(int separatorIndex) {
		return getOperands().get(separatorIndex);
	}

	protected GraphicalEditPart getOperandBelow(MoveSeparatorRequest request) {
		return getOperandBelow(request.getSeparatorIndex());
	}

	protected GraphicalEditPart getOperandBelow(int separatorIndex) {
		return getOperands().get(separatorIndex + 1);
	}

	protected ChangeBoundsRequest getResizeAboveRequest(MoveSeparatorRequest request) {
		ChangeBoundsRequest requestAbove = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		requestAbove.setMoveDelta(request.getMoveDelta());
		requestAbove.setSizeDelta(new Dimension(request.getMoveDelta().x, request.getMoveDelta().y));
		requestAbove.setResizeDirection(PositionConstants.SOUTH);
		requestAbove.setLocation(request.getLocation());
		requestAbove.setEditParts(getOperandAbove(request.getSeparatorIndex()));
		return requestAbove;
	}

	protected ChangeBoundsRequest getResizeBelowRequest(MoveSeparatorRequest request) {
		ChangeBoundsRequest requestBelow = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		requestBelow.setMoveDelta(request.getMoveDelta());
		requestBelow.setSizeDelta(new Dimension(-request.getMoveDelta().x, -request.getMoveDelta().y));
		requestBelow.setResizeDirection(PositionConstants.NORTH);
		requestBelow.setLocation(request.getLocation());
		requestBelow.setEditParts(getOperandBelow(request.getSeparatorIndex()));
		return requestBelow;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#showSourceFeedback(org.eclipse.gef.Request)
	 *
	 * @param request
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if (request instanceof MoveSeparatorRequest) {
			showMoveSeparatorFeedback((MoveSeparatorRequest) request);
		}
		super.showSourceFeedback(request);
	}

	protected void showMoveSeparatorFeedback(MoveSeparatorRequest request) {
		// TODO Feedback
	}

	/**
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#eraseSourceFeedback(org.eclipse.gef.Request)
	 *
	 * @param request
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if (request instanceof MoveSeparatorRequest) {
			eraseMoveSeparatorFeedback((MoveSeparatorRequest) request);
		}
		super.eraseSourceFeedback(request);
	}

	protected void eraseMoveSeparatorFeedback(MoveSeparatorRequest request) {
		// TODO Feedback
	}

	/**
	 * @return
	 * 		The host's children edit parts (Excluding border items)
	 */
	private List<GraphicalEditPart> getOperands() {
		List<?> children = getHost().getChildren();

		CompartmentEditPart cfCompartment = children.stream()
				.filter(CombinedFragmentCombinedFragmentCompartmentEditPart.class::isInstance)
				.map(CombinedFragmentCombinedFragmentCompartmentEditPart.class::cast)
				.findFirst().orElse(null);

		if (cfCompartment == null) {
			return Collections.emptyList();
		}

		List<?> compartmentChildren = cfCompartment.getChildren();

		return compartmentChildren.stream()
				.filter(part -> !(part instanceof IBorderItemEditPart))
				.filter(GraphicalEditPart.class::isInstance)
				.map(GraphicalEditPart.class::cast)
				.collect(Collectors.toList());
	}

}
