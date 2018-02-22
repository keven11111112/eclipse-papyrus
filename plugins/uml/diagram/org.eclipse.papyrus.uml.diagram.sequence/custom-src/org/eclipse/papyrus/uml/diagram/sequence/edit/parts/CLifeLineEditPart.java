/*****************************************************************************
 * Copyright (c) 2017, 2018 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 519621, 526803
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Bug 531520
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.draw2d.anchors.FixedAnchor;
import org.eclipse.papyrus.uml.diagram.sequence.LifelineNodePlate;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifeLineRestorePositionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UpdateNodeReferenceEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UpdateWeakReferenceForExecSpecEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UpdateWeakReferenceForMessageSpecEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.ILifelineInternalFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifeLineLayoutManager;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.locator.MessageCreateLifelineAnchor;

/**
 * @author PT202707
 * @since 3.0
 *
 */
public class CLifeLineEditPart extends LifelineEditPart {

	/** The default height of the figure. */
	public static int DEFAUT_HEIGHT = 700;

	/** The default width of the figure. */
	public static int DEFAUT_WIDTH = 100;

	/**
	 * The minimum height of the figure.
	 * 
	 * @since 4.0
	 */
	public static int MIN_HEIGHT = 100;



	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CLifeLineEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart#createSVGNodePlate()
	 */
	@Override
	protected NodeFigure createSVGNodePlate() {
		if (null == svgNodePlate) {
			svgNodePlate = new LifelineNodePlate(this, -1, -1).withLinkLFEnabled();
			svgNodePlate.setDefaultNodePlate(createNodePlate());
		}
		return svgNodePlate;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart#refresh()
	 *
	 */
	@Override
	public void refresh() {
		if (getPrimaryShape() instanceof LifelineFigure) {
			//Bug 531520: we redefine the border of the lifeline, in order to include the children
			//the message are connected to the middle line of the Lifeline, but they must be drawn as connected on the ExecutionSpeficiation
			final List<NodeFigure> childrenFigure = new ArrayList<NodeFigure>();
			for (final Object current : getChildren()) {
				if (current instanceof AbstractExecutionSpecificationEditPart) {
					NodeFigure figure = ((AbstractExecutionSpecificationEditPart) current).getPrimaryShape();
					childrenFigure.add(figure);
				}
			}
			((LifelineFigure) getPrimaryShape()).setChildrenFigure(childrenFigure);
		}

		super.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new LifelineSelectionEditPolicy());
		installEditPolicy(LifeLineRestorePositionEditPolicy.KEY, new LifeLineRestorePositionEditPolicy());
		installEditPolicy(UpdateNodeReferenceEditPolicy.UDPATE_NODE_REFERENCE, new UpdateNodeReferenceEditPolicy());
		installEditPolicy(UpdateWeakReferenceForMessageSpecEditPolicy.UDPATE_WEAK_REFERENCE_FOR_MESSAGE, new UpdateWeakReferenceForMessageSpecEditPolicy());
		installEditPolicy(UpdateWeakReferenceForExecSpecEditPolicy.UDPATE_WEAK_REFERENCE_FOR_EXECSPEC, new UpdateWeakReferenceForExecSpecEditPolicy());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.UMLNodeEditPart#setLayoutConstraint(org.eclipse.gef.EditPart, org.eclipse.draw2d.IFigure, java.lang.Object)
	 */
	@Override
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		if (!(childFigure instanceof ILifelineInternalFigure)) {
			getPrimaryShape().setConstraint(childFigure, constraint);
		}
	}

	/**
	 * @return the size of the header height
	 *         if the layout is null return -1
	 * @since 4.0
	 */
	public int getStickerHeight() {
		if (getPrimaryShape().getLifeLineLayoutManager() != null) {
			return ((LifeLineLayoutManager) getPrimaryShape().getLifeLineLayoutManager()).getBottomHeader() - getPrimaryShape().getBounds().y();
		}
		return -1;
	}

	/**
	 * Create specific anchor to handle connection on top, on center and on bottom of the lifeline
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		if (connEditPart instanceof MessageCreateEditPart) {
			// Create message anchor
			return new MessageCreateLifelineAnchor(getPrimaryShape(), this);

		} else if (connEditPart instanceof MessageDeleteEditPart) {
			// delete message anchor
			return new FixedAnchor(getPrimaryShape(), FixedAnchor.BOTTOM);
		}
		// if (connEditPart instanceof MessageAsyncEditPart) {// TODO_MIA test it
		// String terminal = AnchorHelper.getAnchorId(getEditingDomain(), connEditPart, false);
		// if (terminal.length() > 0) {
		// int start = terminal.indexOf("{") + 1;
		// PrecisionPoint pt = BaseSlidableAnchor.parseTerminalString(terminal);
		// boolean rightHand = true;
		// if (start > 0) {
		// if (terminal.charAt(start) == 'L') {
		// rightHand = false;
		// }
		// } else {
		// Connection c = (Connection) connEditPart.getFigure();
		// PointList list = c.getPoints();
		// if (list.getPoint(0).x > list.getPoint(1).x) {
		// rightHand = false;
		// }
		// }
		// return new AnchorHelper.SideAnchor(getNodeFigure(), pt, rightHand);
		// }
		// }
		return super.getTargetConnectionAnchor(connEditPart);
	}

}
