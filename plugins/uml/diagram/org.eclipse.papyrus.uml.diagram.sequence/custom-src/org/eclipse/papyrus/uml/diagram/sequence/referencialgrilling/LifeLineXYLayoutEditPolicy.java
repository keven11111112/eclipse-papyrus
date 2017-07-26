/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.XYLayoutWithConstrainedResizedEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.command.SetMoveAllLineAtSamePositionCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CLifeLineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.ExecutionSpecificationUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.LogOptions;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;

/**
 * This class is used to manage node element in the compartment by using grill system.
 * this class has been customized to prevent the strange feedback of lifeline during the move
 * 
 */
public class LifeLineXYLayoutEditPolicy extends XYLayoutWithConstrainedResizedEditPolicy implements IGrillingEditpolicy {

	protected DisplayEvent displayEvent;

	/**
	 * Constructor.
	 *
	 */
	public LifeLineXYLayoutEditPolicy() {
		super();

	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#setHost(org.eclipse.gef.EditPart)
	 *
	 * @param host
	 */
	@Override
	public void setHost(EditPart host) {
		super.setHost(host);
		displayEvent = new DisplayEvent(getHost());
	}

	/*
	 * Override to use to deal with causes where the point is UNDERFINED
	 * we will ask the layout helper to find a location for us
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#getConstraintFor(org.eclipse.gef.requests.CreateRequest)
	 */
	protected Object getConstraintFor(CreateRequest request) {
		// Used during the creation from the palette
		Object constraint = super.getConstraintFor(request);
		if (request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest req = (CreateViewAndElementRequest) request;
			ViewAndElementDescriptor descriptor = (req).getViewAndElementDescriptor();
			IElementType elementType = (IElementType) descriptor.getElementAdapter().getAdapter(IElementType.class);
			if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.ACTION_EXECUTION_SPECIFICATION_SHAPE) ||
					ElementUtil.isTypeOf(elementType, UMLDIElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION_SHAPE)) {
				Rectangle parentBound = getHostFigure().getBounds();
				if (constraint instanceof Rectangle) {
					Rectangle constraintRect = (Rectangle) constraint;
					RootEditPart drep = getHost().getRoot();
					if (drep instanceof DiagramRootEditPart) {

						double spacing = ((DiagramRootEditPart) drep).getGridSpacing();
						if (constraintRect.height == -1) {
							constraintRect.height = AbstractExecutionSpecificationEditPart.DEFAUT_HEIGHT;
						}
						constraintRect.width = AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH;
						constraintRect.x = (parentBound.width / 2) - (constraintRect.width / 2);

						constraintRect = ExecutionSpecificationUtil.calculateExecutionSpecificationCorrectLocation(((CLifeLineEditPart) getHost()), constraintRect, null);

						if (DiagramEditPartsUtil.isSnapToGridActive(getHost())) {
							int modulo = AbstractExecutionSpecificationEditPart.DEFAUT_HEIGHT / (int) spacing;
							constraintRect.height = modulo * (int) spacing;
						}
						
						constraint = constraintRect;
					}
				}
			}
		}
		return constraint;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy#getConstraintFor(org.eclipse.gef.requests.ChangeBoundsRequest, org.eclipse.gef.GraphicalEditPart)
	 *
	 * @param request
	 * @param child
	 * @return
	 */
	@Override
	protected Object getConstraintFor(ChangeBoundsRequest request, GraphicalEditPart child) {


		if (child instanceof BorderedBorderItemEditPart) {
			Rectangle constraint = new Rectangle(child.getFigure().getBounds());

			return constraint;

		}
		return super.getConstraintFor(request, child);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#showLayoutTargetFeedback(org.eclipse.gef.Request)
	 *
	 * @param request
	 */
	@Override
	protected void showLayoutTargetFeedback(Request request) {


		// feed back during the creation from the palette
		RootEditPart drep = getHost().getRoot();
		Rectangle parentBound = getHostFigure().getBounds().getCopy();
		getHostFigure().getParent().translateToAbsolute(parentBound);
		UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG_REFERENCEGRID, "LifeLineBounds On Screen:" + parentBound); //$NON-NLS-1$
		if (drep instanceof DiagramRootEditPart) {
			double spacing = ((DiagramRootEditPart) drep).getGridSpacing();
			if (request instanceof org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeCreationTool.CreateAspectUnspecifiedTypeRequest) {
				IElementType elementType = (IElementType) ((org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeCreationTool.CreateAspectUnspecifiedTypeRequest) request).getElementTypes().get(0);
				if (ElementUtil.isTypeOf(elementType, UMLDIElementTypes.ACTION_EXECUTION_SPECIFICATION_SHAPE) ||
						ElementUtil.isTypeOf(elementType, UMLDIElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION_SHAPE)) {
					((CreateRequest) request).setLocation(new Point((parentBound.x + (parentBound.width / 2) - AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH / 2), ((CreateRequest) request).getLocation().y));
					int modulo = AbstractExecutionSpecificationEditPart.DEFAUT_HEIGHT / (int) spacing;
					((CreateRequest) request).setSize(new Dimension(AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH, modulo * (int) spacing));


					displayEvent.addFigureEvent(getHostFigure().getParent().getParent(), ((CreateRequest) request).getLocation());
				}

			}

			if (request instanceof ChangeBoundsRequest) {
				// test
				((ChangeBoundsRequest) request).setMoveDelta(new Point(0, ((ChangeBoundsRequest) request).getMoveDelta().y));
			}
		}

		super.showLayoutTargetFeedback(request);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.GraphicalEditPolicy#addFeedback(org.eclipse.draw2d.IFigure)
	 *
	 * @param figure
	 */
	@Override
	protected void addFeedback(IFigure figure) {
		super.addFeedback(figure);



	}


	/**
	 * @see org.eclipse.gef.editpolicies.GraphicalEditPolicy#removeFeedback(org.eclipse.draw2d.IFigure)
	 *
	 * @param figure
	 */
	@Override
	protected void removeFeedback(IFigure figure) {

		displayEvent.removeFigureEvent(getHostFigure().getParent().getParent());
		super.removeFeedback(figure);

	}

	/**
	 * Called in response to a <tt>REQ_RESIZE_CHILDREN</tt> request.
	 * 
	 * This implementation creates a <tt>SetPropertyCommand</i> and sets
	 * the <tt>ID_BOUNDS</tt> property value to the supplied constraints.
	 * 
	 * @param child
	 *            the element being resized.
	 * @param constraint
	 *            the elements new bounds.
	 * @return {@link SetBoundsCommand}
	 */
	protected Command createChangeConstraintCommand(
			EditPart child,
			Object constraint) {
		
		Rectangle newBounds = (Rectangle) constraint;
		View shapeView = (View) child.getModel();
		
		final CompoundCommand subCommand = new CompoundCommand("Edit Execution Specification positions"); //$NON-NLS-1$

		if (child instanceof AbstractExecutionSpecificationEditPart) {
			RootEditPart drep = getHost().getRoot();
			if (drep instanceof DiagramRootEditPart) {
				
				// Get the initial Rectangle from the edit part
				Rectangle initialRectangle = null;
				final Object view = ((AbstractExecutionSpecificationEditPart) child).getModel();
				if (view instanceof Node) {
					final Bounds bounds = BoundForEditPart.getBounds((Node) view);
					initialRectangle = new Rectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
				}
				
				double spacing = ((DiagramRootEditPart) drep).getGridSpacing();
				Rectangle parentBound = getHostFigure().getBounds();
				// Initial default x and y positions
				newBounds.setLocation(new Point((parentBound.width / 2) - (AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH / 2), newBounds.getLocation().y));

				final CLifeLineEditPart lifeLineEditPart = (CLifeLineEditPart) getHost();
				final Map<AbstractExecutionSpecificationEditPart, Rectangle> executionSpecificationRectangles = ExecutionSpecificationUtil.getRectangles(lifeLineEditPart);
				
				Rectangle boundsToRectangle = null;
				CompoundCommand compoundCommand = null;
				
				// Loop until found command for the execution specifications bounds (because by moving other execution specification, the first one can be moved another time).
				do {
					// Calculate the moved execution specification bounds
					boundsToRectangle = ExecutionSpecificationUtil.calculateExecutionSpecificationCorrectLocation(
							lifeLineEditPart, executionSpecificationRectangles, new Rectangle(newBounds.x, newBounds.y, newBounds.width, newBounds.height), child);

					if (boundsToRectangle.height == -1) {
						boundsToRectangle.height = AbstractExecutionSpecificationEditPart.DEFAUT_HEIGHT;
					}
					if (DiagramEditPartsUtil.isSnapToGridActive(getHost())) {
						int modulo = boundsToRectangle.height / (int) spacing;
						boundsToRectangle.setSize(new Dimension(AbstractExecutionSpecificationEditPart.DEFAUT_WIDTH, modulo * (int) spacing));
					}
					
					// Get the possible command of execution specification bounds modification
					compoundCommand = ExecutionSpecificationUtil.getExecutionSpecificationToMove(lifeLineEditPart, executionSpecificationRectangles, initialRectangle, boundsToRectangle, child);
					if(null != compoundCommand && !compoundCommand.isEmpty()) {
						subCommand.add(compoundCommand);
					}
				}while(compoundCommand != null && !compoundCommand.isEmpty());
				
				newBounds.setBounds(boundsToRectangle);
			}
		}

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		ICommand boundsCommand = new SetBoundsCommand(editingDomain,
				DiagramUIMessages.SetLocationCommand_Label_Resize,
				new EObjectAdapter(shapeView),
				newBounds);
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.add(new ICommandProxy(boundsCommand));

		if(!subCommand.isEmpty()) {
			compoundCommand.add(subCommand);
		}
		
		return compoundCommand;
	}


	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.XYLayoutWithConstrainedResizedEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {

		request.setLocation(displayEvent.getRealEventLocation(request.getLocation()));

		DiagramEditPart diagramEditPart = getDiagramEditPart(getHost());

		GridManagementEditPolicy grid = (GridManagementEditPolicy) diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRID_MANAGEMENT);
		if (grid != null) {
			CompoundCommand cmd = new CompoundCommand();
			SetMoveAllLineAtSamePositionCommand setMoveAllLineAtSamePositionCommand = new SetMoveAllLineAtSamePositionCommand(grid, false);
			cmd.add(setMoveAllLineAtSamePositionCommand);
			cmd.add(super.getCreateCommand(request));
			setMoveAllLineAtSamePositionCommand = new SetMoveAllLineAtSamePositionCommand(grid, true);
			cmd.add(setMoveAllLineAtSamePositionCommand);
			return cmd;
		}
		return super.getCreateCommand(request);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createAddCommand(org.eclipse.gef.requests.ChangeBoundsRequest, org.eclipse.gef.EditPart, java.lang.Object)
	 *
	 * @param request
	 * @param child
	 * @param constraint
	 * @return
	 */
	@Override
	protected Command createAddCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
		if (child instanceof LifelineEditPart) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.createAddCommand(request, child, constraint);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#showTargetFeedback(org.eclipse.gef.Request)
	 *
	 * @param request
	 */
	@Override
	public void showTargetFeedback(Request request) {
		if (request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;

			if (changeBoundsRequest.getEditParts().get(0) instanceof LifelineEditPart) {
				changeBoundsRequest.setMoveDelta(new Point(changeBoundsRequest.getMoveDelta().x, 0));
			}
		}
		super.showTargetFeedback(request);
	}
}
