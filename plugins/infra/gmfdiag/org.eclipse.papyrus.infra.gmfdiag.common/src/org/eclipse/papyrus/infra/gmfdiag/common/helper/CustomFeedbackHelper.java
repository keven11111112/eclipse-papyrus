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
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.editpolicies.FeedbackHelper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;


/**
 * 
 * This class allows to have a feedback which doesn't move bendpoints when it is not necessary
 * 
 */
public class CustomFeedbackHelper extends FeedbackHelper {

	/**
	 * Constructs a new FeedbackHelper.
	 */
	public CustomFeedbackHelper() {
		super();
	}

	/**
	 * 
	 * @return
	 *         the current constraints for the connection
	 */
	protected List<RelativeBendpoint> getCurrentConnectionConstraint() {
		Object value = getConnection().getConnectionRouter().getConstraint(getConnection());
		final List<RelativeBendpoint> contraints = new ArrayList<RelativeBendpoint>();
		if(value instanceof Collection<?>) {
			final Iterator<?> iter = ((Collection<?>)value).iterator();
			while(iter.hasNext()) {
				Object current = iter.next();
				if(current instanceof RelativeBendpoint) {
					contraints.add((RelativeBendpoint)current);
				}
			}
		}
		return contraints;
	}

	/**
	 * 
	 * @param newConstraint
	 *        the new constraint to use to do the routing
	 */
	protected void setNewConnectionConstraint(final List<RelativeBendpoint> newConstraint) {
		getConnection().getConnectionRouter().setConstraint(getConnection(), newConstraint);
	}

	/**
	 * Sets the anchor for the end being moved.
	 * 
	 * @param anchor
	 *        the new anchor
	 */
	@Override
	protected void setAnchor(ConnectionAnchor anchor) {
		//TODO : this calculus should be done in PapyrusConnectionEndEditPolicy 
		//1. find the old anchor location
		final Point oldPoint;
		if(isMovingStartAnchor()) {
			oldPoint = getConnection().getSourceAnchor().getReferencePoint();
		} else {
			oldPoint = getConnection().getTargetAnchor().getReferencePoint();
		}


		//2. we create a dummy connection from current connection, with new informations to determine real anchor point
		final Connection dummyConnection = new PolylineConnectionEx();
		if(isMovingStartAnchor()) {
			dummyConnection.setSourceAnchor(anchor);
			final Point targetPoint = getConnection().getTargetAnchor().getReferencePoint();
			final ConnectionAnchor targetAnchor = ((IAnchorableFigure)getConnection().getTargetAnchor().getOwner()).getTargetConnectionAnchorAt(targetPoint);
			dummyConnection.setTargetAnchor(targetAnchor);
		} else {
			final Point sourcePoint = getConnection().getSourceAnchor().getReferencePoint();
			final ConnectionAnchor sourceAnchor = ((IAnchorableFigure)getConnection().getSourceAnchor().getOwner()).getSourceConnectionAnchorAt(sourcePoint);
			dummyConnection.setSourceAnchor(sourceAnchor);
			dummyConnection.setTargetAnchor(anchor);
		}

		dummyConnection.setPoints(getConnection().getPoints().getCopy());
		final ConnectionRouter router = getConnection().getConnectionRouter();
		router.route(dummyConnection);

		//3. determine move between old anchor and new anchor
		final Dimension move;
		if(isMovingStartAnchor()) {
			move = dummyConnection.getPoints().getFirstPoint().getDifference(oldPoint);
		} else {
			move = dummyConnection.getPoints().getLastPoint().getDifference(oldPoint);
		}

		//4. do something only when necessary
		if(move.width != 0 || move.height != 0) {
			final List<RelativeBendpoint> currentBendpoints = getCurrentConnectionConstraint();
			final List<Point> newBendpoints = new ArrayList<Point>();
			int nbBendpoints = currentBendpoints.size();
			for(int i = 0; i < currentBendpoints.size(); i++) {
				final Point realPoint = currentBendpoints.get(i).getLocation();
				if(i == 0 && isMovingStartAnchor()) {
					realPoint.translate(move);
				}
				if(i == 1 && nbBendpoints > 3 && isMovingStartAnchor()) {
					realPoint.translate(move);
				}
				if(i == currentBendpoints.size() - 1 && nbBendpoints > 3 && !isMovingStartAnchor()) {
					realPoint.translate(move);
				}
				if(i == currentBendpoints.size() - 2 && !isMovingStartAnchor()) {
					realPoint.translate(move);
				}
				newBendpoints.add(realPoint);
			}

			//5. get new bendpoints
			final List<RelativeBendpoint> newConstraints = convertToRelativeBendpoints(getConnection(), newBendpoints);


			//6. fix the anchor location
			if(isMovingStartAnchor()) {
				if(anchor.getOwner() == null && anchor instanceof XYAnchor) {
					((XYAnchor)anchor).setLocation(dummyConnection.getPoints().getFirstPoint());
				} else {
					anchor = ((IAnchorableFigure)anchor.getOwner()).getSourceConnectionAnchorAt(dummyConnection.getPoints().getFirstPoint());
				}
			} else {
				if(anchor.getOwner() == null && anchor instanceof XYAnchor) {
					((XYAnchor)anchor).setLocation(dummyConnection.getPoints().getLastPoint());
				} else {
					anchor = ((IAnchorableFigure)anchor.getOwner()).getTargetConnectionAnchorAt(dummyConnection.getPoints().getLastPoint());
				}

			}

			//7. 
			if(isMovingStartAnchor()) {
				getConnection().setSourceAnchor(anchor);
			} else {
				getConnection().setTargetAnchor(anchor);
			}

			//we change the constraints associated to the connection in the router to get wanted feedback (bendpoints points must not move)
			getConnection().getConnectionRouter().setConstraint(getConnection(), newConstraints);

			//clear the router
			getConnection().getConnectionRouter().remove(dummyConnection);
		}
	}

	/**
	 * Updates the feedback based on the given anchor or point. The anchor is
	 * used unless <code>null</code>. The point is used when there is no anchor.
	 * 
	 * @param anchor
	 *        <code>null</code> or an anchor
	 * @param p
	 *        the point to use when there is no anchor
	 */
	@Override
	public void update(ConnectionAnchor anchor, Point p) {
		if(anchor != null) {
			setAnchor(anchor);
		} else {
			super.update(anchor, p);
		}
	}

	/**
	 * 
	 * @param connection
	 *        a connection
	 * @param points
	 *        a list of points representing bendpoints for this connection
	 * @return
	 *         the list of bendpoints
	 */
	public static final List<RelativeBendpoint> convertToRelativeBendpoints(final Connection connection, final List<Point> points) {
		int size = points.size();
		final List<RelativeBendpoint> relatedBendpoints = new ArrayList<RelativeBendpoint>(points.size());
		if(size > 0) {
			final Point first = points.get(0);
			final Point last = points.get(size - 1);
			for(int i = 0; i < size; i++) {
				final Point current = points.get(i);
				final Dimension s = current.getDifference(first);
				final Dimension t = current.getDifference(last);
				final RelativeBendpoint relatedBendpoint = new org.eclipse.draw2d.RelativeBendpoint(connection);
				relatedBendpoint.setRelativeDimensions(s, t);
				relatedBendpoints.add(relatedBendpoint);
			}
		}
		return relatedBendpoints;
	}
}
