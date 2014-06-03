/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import java.util.List;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.copy.ConnectionLineSegEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.IdentityAnchorHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.routers.GridUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;


/**
 * 
 * This edit policy saves the new anchors after moving a LineSeg on the diagram
 * 
 */
@SuppressWarnings("restriction")
public class CustomConnectionLineSegEditPolicy extends ConnectionLineSegEditPolicy {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CustomConnectionLineSegEditPolicy() {
		super();
	}


	/**
	 * Method getBendpointsChangedCommand
	 * Different signature method that allows a command to constructed for changing the bendpoints
	 * without requiring the original Request.
	 * 
	 * @param connection
	 *        Connection to generate the bendpoints changed command from
	 * @param edge
	 *        notation element that the command will operate on.
	 * @return Command SetBendpointsCommand that contains the point changes for the connection.
	 */
	@Override
	protected Command getBendpointsChangedCommand(Connection connection, Edge edge) {
		final CompoundCommand cc = new CompoundCommand("Update bendpoints And Anchors"); //$NON-NLS-1$

		final IFigure sourceFigure = connection.getSourceAnchor().getOwner();
		final IFigure targetFigure = connection.getTargetAnchor().getOwner();
		final Point sourcePoint = connection.getPoints().getFirstPoint();
		final Point targetPoint = connection.getPoints().getLastPoint();

		final PointList points = connection.getPoints();
		final Point secondPoint = points.getPoint(1);
		final Point beforeLastPoint = points.getPoint(points.size() - 2);


		//build the command to update the source and the target anchor
		//we must calculate it like in the showOutsideSource/TargetFeedback in the case where we don't have the feedback
		double gridSpacing = DiagramEditPartsUtil.getDiagramGridSpacing(getHost());
		final Rectangle sourceNodeBounds = GridUtils.getRealAbsoluteCoordinateFromGrid(sourceFigure, getHost());
		final Rectangle targetNodeBounds = GridUtils.getRealAbsoluteCoordinateFromGrid(targetFigure, getHost());

		final LineSeg sourceSegment = new LineSeg(sourcePoint, secondPoint);
		final LineSeg targetSegment = new LineSeg(targetPoint, beforeLastPoint);

		//find the real points on a side of the rectangle
		Point sourcePointRef = GridUtils.getPointOnGrid(sourceNodeBounds, sourceSegment, gridSpacing);
		Point targetPointRef = GridUtils.getPointOnGrid(targetNodeBounds, targetSegment, gridSpacing);


		PrecisionPoint relativeSourceAnchorLocation = BaseSlidableAnchor.getAnchorRelativeLocation(sourcePointRef, sourceNodeBounds);
		PrecisionPoint relativeTargetAnchorLocation = BaseSlidableAnchor.getAnchorRelativeLocation(targetPointRef, targetNodeBounds);

		final String newSourceTerminal = IdentityAnchorHelper.createNewAnchorIdValue(relativeSourceAnchorLocation.preciseX(), relativeSourceAnchorLocation.preciseY());
		final String newTargetTerminal = IdentityAnchorHelper.createNewAnchorIdValue(relativeTargetAnchorLocation.preciseX(), relativeTargetAnchorLocation.preciseY());

		final SetConnectionAnchorsCommand setAnchorCommand = new SetConnectionAnchorsCommand(getEditingDomain(), "Update Anchor"); //$NON-NLS-1$
		setAnchorCommand.setEdgeAdaptor(new EObjectAdapter((View)getHost().getModel()));
		setAnchorCommand.setNewSourceTerminal(newSourceTerminal);
		setAnchorCommand.setNewTargetTerminal(newTargetTerminal);

		cc.add(new ICommandProxy(setAnchorCommand));




		Point ptRef1 = connection.getSourceAnchor().getReferencePoint();
		getConnection().translateToRelative(ptRef1);

		Point ptRef2 = connection.getTargetAnchor().getReferencePoint();
		getConnection().translateToRelative(ptRef2);


		ptRef1 = sourcePointRef;
		ptRef2 = targetPointRef;

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();

		SetConnectionBendpointsCommand sbbCommand = new SetConnectionBendpointsCommand(editingDomain);
		sbbCommand.setEdgeAdapter(new EObjectAdapter(edge));

		PointList list = connection.getPoints().getCopy();
		list.setPoint(ptRef1, 0);
		list.setPoint(ptRef2, connection.getPoints().size() - 1);

		sbbCommand.setNewPointList(list, ptRef1, ptRef2);
		cc.add(new ICommandProxy(sbbCommand));

		return cc;
	}

	/**
	 * Shows feedback when a line segment is being moved. Also checks to see if the bendpoint
	 * should be deleted and then calls {@link #showDeleteBendpointFeedback(BendpointRequest)} if needed. The original figure is used for feedback and
	 * the original constraint is
	 * saved, so that it can be restored when feedback is erased.
	 */
	@Override
	protected void showMoveLineSegFeedback(BendpointRequest request) {
		//TODO probably something to do for oblique and tree routing
		super.showMoveLineSegFeedback(request);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.copy.GMF_GEF_ConnectionBendpointEditPolicy#showMoveOrthogonalBenspointFeedback(org.eclipse.gef.requests.BendpointRequest)
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void showMoveOrthogonalBenspointFeedback(BendpointRequest request) {
		if(getFeedbackState().originalConstraint == null) {
			saveOriginalConstraint();
		}

		Point ptLoc = new Point(request.getLocation());
		@SuppressWarnings("rawtypes")
		List constraint = (List)getConnection().getRoutingConstraint();

		getConnection().translateToRelative(ptLoc);

		int index = getFeedbackState().isOutsideSource ? request.getIndex() + 1 : request.getIndex();

		Point previous = ((Bendpoint)constraint.get(index - 1)).getLocation();
		Point moving = ((Bendpoint)constraint.get(index)).getLocation();
		Point next = ((Bendpoint)constraint.get(index + 1)).getLocation();

		LineSeg originalFirst = new LineSeg(previous.getCopy(), moving.getCopy());
		LineSeg originalSecond = new LineSeg(moving.getCopy(), next.getCopy());

		Dimension diff = ptLoc.getDifference(moving);

		if(originalFirst.isHorizontal()) {
			previous.y += diff.height;
			next.x += diff.width;
		} else {
			previous.x += diff.width;
			next.y += diff.height;
		}

		LineSeg movedFirst = new LineSeg(previous, ptLoc.getCopy());
		LineSeg movedSecond = new LineSeg(ptLoc.getCopy(), next);

		index = adjustOutsideBoundsLineFeedback(movedFirst, index - 1, constraint, originalFirst);
		constraint.set(index, new AbsoluteBendpoint(movedFirst.getOrigin()));
		constraint.set(index + 1, new AbsoluteBendpoint(movedFirst.getTerminus()));

		index = adjustOutsideBoundsLineFeedback(movedSecond, index + 1, constraint, originalSecond);
		constraint.set(index + 1, new AbsoluteBendpoint(movedSecond.getTerminus()));

		getConnection().setRoutingConstraint(constraint);

		final Connection connection = getConnection();
		final Point ptRef1 = (Point)constraint.get(0);

		final Point ptRef2 = (Point)constraint.get(constraint.size() - 1);
		connection.getPoints().setPoint(ptRef1, 0);
		connection.getPoints().setPoint(ptRef2, connection.getPoints().size() - 1);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.copy.GMF_GEF_ConnectionBendpointEditPolicy#showMoveBendpointFeedback(org.eclipse.gef.requests.BendpointRequest)
	 * 
	 * @param request
	 */
	@Override
	protected void showMoveBendpointFeedback(BendpointRequest request) {
		// TODO Auto-generated method stub
		super.showMoveBendpointFeedback(request);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.copy.GMF_GEF_ConnectionBendpointEditPolicy#showCreateBendpointFeedback(org.eclipse.gef.requests.BendpointRequest)
	 * 
	 * @param request
	 */
	@Override
	protected void showCreateBendpointFeedback(BendpointRequest request) {
		//TODO probably something to do for oblique and tree routing
		super.showCreateBendpointFeedback(request);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.copy.GMF_GEF_ConnectionBendpointEditPolicy#adjustOutsideBoundsLineFeedback(org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg,
	 *      int, java.util.List, org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg)
	 * 
	 * @param newLine
	 * @param index
	 * @param constraint
	 * @param moveLine
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected int adjustOutsideBoundsLineFeedback(LineSeg newLine, int index, List constraint, LineSeg moveLine) {
		int returnValue = super.adjustOutsideBoundsLineFeedback(newLine, index, constraint, moveLine);

		final Connection connection = getConnection();
		final Point ptRef1 = connection.getSourceAnchor().getReferencePoint();
		getConnection().translateToRelative(ptRef1);

		final Point ptRef2 = connection.getTargetAnchor().getReferencePoint();
		getConnection().translateToRelative(ptRef2);

		connection.getPoints().setPoint(ptRef1, 0);
		connection.getPoints().setPoint(ptRef2, connection.getPoints().size() - 1);

		return returnValue;
	}




	/**
	 * Method showOutsideSourceFeedback.
	 * Adds a bendpoint to the beginning of the constraint.
	 * Also adjusts the new segment with respect to added constraint
	 * 
	 * @param constraint
	 *        List of bendpoints that the source point will be added too.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void showOutsideSourceFeedback(LineSeg newLine, LineSeg moveLine, List constraint) {
		Connection conn = (Connection)getHostFigure();
		ConnectionAnchor anchor = conn.getSourceAnchor();
		PrecisionPoint startPoint = new PrecisionPoint(anchor.getOwner().getBounds().getCenter());
		anchor.getOwner().translateToAbsolute(startPoint);
		conn.translateToRelative(startPoint);
		PrecisionRectangle bounds = new PrecisionRectangle(anchor.getOwner().getBounds());
		anchor.getOwner().translateToAbsolute(bounds);
		conn.translateToRelative(bounds);



		Point origin = new Point(newLine.getOrigin());
		if(moveLine.isHorizontal()) {
			origin.x = startPoint.x;
		} else {
			origin.y = startPoint.y;
		}

		//----adapted
		LineSeg segment = new LineSeg(startPoint, origin);
		final double spacing = DiagramEditPartsUtil.getDiagramGridSpacing(getHost());
		final Point res = GridUtils.getPointOnGrid(bounds, segment, spacing);

		Point initialPoint = (Point)constraint.get(0);
		if(origin.x == startPoint.x) {
			initialPoint.x = res.x;
			origin.x = res.x;
		}
		if(origin.y == startPoint.y) {
			initialPoint.y = res.y;
			origin.y = res.y;
		}
		newLine.setOrigin(origin);
		constraint.set(0, origin);
		constraint.add(0, new AbsoluteBendpoint(res));

		//update source anchor location
		final Point pt = GridUtils.getFeedBackPointFromGridCoordinate((Point)constraint.get(0), getHost());
		final ConnectionAnchor newSourceAnchor = ((IAnchorableFigure)conn.getSourceAnchor().getOwner()).getSourceConnectionAnchorAt(pt);
		conn.setSourceAnchor(newSourceAnchor);
	}


	/**
	 * Method showOutsideTargetFeedback.
	 * Adds a bendpoint to the end of the constraint.
	 * Also adjusts the new segment with respect to added constraint
	 * 
	 * @param constraint
	 *        List of bendpoints that the target point will be added too.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void showOutsideTargetFeedback(LineSeg newLine, LineSeg moveLine, List constraint) {
		Connection conn = (Connection)getHostFigure();
		ConnectionAnchor anchor = conn.getTargetAnchor();
		PrecisionPoint endPoint = new PrecisionPoint(anchor.getOwner().getBounds().getCenter());
		anchor.getOwner().translateToAbsolute(endPoint);
		conn.translateToRelative(endPoint);
		PrecisionRectangle bounds = new PrecisionRectangle(anchor.getOwner().getBounds());
		anchor.getOwner().translateToAbsolute(bounds);
		conn.translateToRelative(bounds);
		Point terminus = new Point(newLine.getTerminus());

		if(moveLine.isHorizontal()) {
			terminus.x = endPoint.x;
		} else {
			terminus.y = endPoint.y;
		}

		//----adapted
		LineSeg segment = new LineSeg(endPoint, terminus);
		final double spacing = DiagramEditPartsUtil.getDiagramGridSpacing(getHost());
		final Point res = GridUtils.getPointOnGrid(bounds, segment, spacing);

		Point initialPoint = (Point)constraint.get(0);
		if(terminus.x == endPoint.x) {
			initialPoint.x = res.x;
			terminus.x = res.x;
		}
		if(terminus.y == endPoint.y) {
			initialPoint.y = res.y;
			terminus.y = res.y;
		}
		newLine.setTerminus(terminus);
		constraint.set(constraint.size() - 1, terminus);
		constraint.add(new AbsoluteBendpoint(res));

		//update target anchor location
		final Point pt = GridUtils.getFeedBackPointFromGridCoordinate((Point)constraint.get(constraint.size() - 1), getHost());
		final ConnectionAnchor newSourceAnchor = ((IAnchorableFigure)conn.getSourceAnchor().getOwner()).getSourceConnectionAnchorAt(pt);
		conn.setSourceAnchor(newSourceAnchor);

		final ConnectionAnchor newTargetAnchor = ((IAnchorableFigure)conn.getTargetAnchor().getOwner()).getTargetConnectionAnchorAt((Point)constraint.get(constraint.size() - 1));
		conn.setTargetAnchor(newTargetAnchor);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.copy.GMF_GEF_ConnectionBendpointEditPolicy#restoreOriginalConstraint()
	 * 
	 */
	@Override
	protected void restoreOriginalConstraint() {
		super.restoreOriginalConstraint();
		Point ref1 = getFeedbackState().ref1;
		Point ref2 = getFeedbackState().ref2;
		ConnectionAnchor newSourceAnchor = ((IAnchorableFigure)getConnection().getSourceAnchor().getOwner()).getSourceConnectionAnchorAt(ref1);
		getConnection().setSourceAnchor(newSourceAnchor);
		ConnectionAnchor newTargetAnchor = ((IAnchorableFigure)getConnection().getTargetAnchor().getOwner()).getTargetConnectionAnchorAt(ref2);
		getConnection().setTargetAnchor(newTargetAnchor);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.copy.GMF_GEF_ConnectionBendpointEditPolicy#saveOriginalConstraint()
	 * 
	 */
	@Override
	protected void saveOriginalConstraint() {
		super.saveOriginalConstraint();
		getFeedbackState().ref1 = getConnection().getSourceAnchor().getReferencePoint().getCopy();
		getFeedbackState().ref2 = getConnection().getTargetAnchor().getReferencePoint().getCopy();
	}


	/**
	 * 
	 * @return
	 *         the editing domain to use
	 */
	protected final TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

}
