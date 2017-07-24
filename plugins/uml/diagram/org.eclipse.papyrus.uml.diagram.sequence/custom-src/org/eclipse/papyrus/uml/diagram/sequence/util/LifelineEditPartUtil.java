/*****************************************************************************
 * Copyright (c) 2010,2017 CEA LIST, ALL4TEC and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 519621
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 519756
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CCombinedCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineDotLineCustomFigure;
import org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling.GridManagementEditPolicy;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class LifelineEditPartUtil {

	/**
	 * Constructor.
	 */
	private LifelineEditPartUtil() {
	}

	/**
	 * This operation returns the ExecutionSpecification EditParts contained in the Lifeline
	 * EditPart
	 *
	 * @return the list of ExecutionSpecification EditParts
	 */
	public static List<ShapeNodeEditPart> getChildShapeNodeEditPart(LifelineEditPart lifeline) {
		if (lifeline == null) {
			return Collections.emptyList();
		}
		List<ShapeNodeEditPart> executionSpecificationList = new ArrayList<ShapeNodeEditPart>();
		for (Object obj : lifeline.getChildren()) {
			if (obj instanceof BehaviorExecutionSpecificationEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart) obj);
			} else if (obj instanceof CCombinedCompartmentEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart) obj);
			}
		}
		return executionSpecificationList;
	}

	/**
	 * This operation returns the InnerConnectableElement EditParts contained in the Lifeline
	 * EditPart
	 *
	 * @return the list of InnerConnectableElement EditParts
	 */
	public static List<LifelineEditPart> getInnerConnectableElementList(LifelineEditPart lifeline) {
		if (lifeline == null) {
			return Collections.emptyList();
		}
		List<LifelineEditPart> propertyList = new ArrayList<LifelineEditPart>();
		for (Object obj : lifeline.getChildren()) {
			if (obj instanceof LifelineEditPart) {
				propertyList.add((LifelineEditPart) obj);
			}
		}
		return propertyList;
	}

	public static NodeFigure getNodeFigure(LifelineEditPart lifelineEditPart) {
		if (lifelineEditPart == null) {
			return null;
		}
		IFigure contentPane = lifelineEditPart.getContentPane();

		if (contentPane instanceof LifelineDotLineCustomFigure) {
			return ((LifelineDotLineCustomFigure) contentPane).getDashLineRectangle();
		}
		return null;
	}

	/**
	 * @param editPart
	 *            the remove {@link MessageCreateEditPart}
	 * @return the command when the last create message is remove to a lifeline to move it up and resize it.
	 * @since 3.0
	 * 
	 */
	public static Command getRestoreLifelinePositionOnMessageCreateRemovedCommand(final ConnectionEditPart editPart) {
		Command commands = null;
		if (editPart instanceof MessageCreateEditPart) {
			MessageCreateEditPart part = (MessageCreateEditPart) editPart;
			if (part.getTarget() instanceof LifelineEditPart && 1 == LifelineMessageCreateHelper.getIncomingMessageCreate(part.getTarget()).size()) {
				LifelineEditPart target = (LifelineEditPart) part.getTarget();
				if (target.getModel() instanceof Shape) {
					Shape view = (ShapeImpl) target.getModel();
					if (view.getLayoutConstraint() instanceof Bounds) {
						Bounds bounds = (Bounds) view.getLayoutConstraint();
						// get the set bounds command
						Point newLocation = new Point(bounds.getX(), SequenceUtil.LIFELINE_VERTICAL_OFFSET);
						Dimension newDimension = new Dimension(bounds.getWidth(), bounds.getHeight() + (bounds.getY() - SequenceUtil.LIFELINE_VERTICAL_OFFSET));
						Rectangle newBounds = new Rectangle(newLocation, newDimension);

						ICommand boundsCommand = new SetBoundsCommand(target.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(view), newBounds);

						commands = new ICommandProxy(boundsCommand);
					}
				}
			}
		}
		return commands;
	}

	/**
	 * Get the list of previous {@link MessageEnd} on the {@link LifelineEditPart} according to the position.
	 * 
	 * @param position
	 *            The reference position.
	 * @param lifelineEditPart
	 *            The lifeline edit part
	 */
	public static List<MessageEnd> getPreviousEventsFromPosition(final Point position, final LifelineEditPart lifelineEditPart) {
		List<MessageEnd> previous = new ArrayList<MessageEnd>();
		DiagramEditPart diagramEditPart = getDiagramEditPart(lifelineEditPart);
		Lifeline lifeline = (Lifeline) lifelineEditPart.resolveSemanticElement();
		try {
			GridManagementEditPolicy grilling = (GridManagementEditPolicy) diagramEditPart.getEditPolicy(GridManagementEditPolicy.GRID_MANAGEMENT);
			if (grilling != null) {
				for (DecorationNode row : grilling.rows) {
					Point currentPoint = GridManagementEditPolicy.getLocation(row);
					if (currentPoint.y < position.y) {
						if (row.getElement() != null) {
							EObject referedElement = row.getElement();
							if (referedElement instanceof MessageEnd) {
								if (lifeline.getCoveredBys().contains(referedElement)) {
									previous.add((MessageEnd) referedElement);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
		}
		return previous;
	}

	/**
	 * Walks up the editpart hierarchy to find and return the
	 * <code>TopGraphicEditPart</code> instance.
	 */
	public static DiagramEditPart getDiagramEditPart(EditPart editPart) {
		while (editPart instanceof IGraphicalEditPart) {
			if (editPart instanceof DiagramEditPart) {
				return (DiagramEditPart) editPart;
			}

			editPart = editPart.getParent();
		}
		if (editPart instanceof DiagramRootEditPart) {
			return (DiagramEditPart) ((DiagramRootEditPart) editPart).getChildren().get(0);
		}
		return null;
	}
}
