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
package org.eclipse.papyrus.infra.gmfdiag.common.routers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.edge.CustomRelativeBendpoint;

/**
 * 
 * A util class for routing connnection
 * 
 */
public class RouterUtil {

	private RouterUtil() {
		//to prevent instanciation
	}


	/**
	 * This method creates a temporary connection (not visible on the diagram) from @param connection and route it with
	 * the same conditions
	 * 
	 * 
	 * @param connection
	 *        an existing connection
	 * @param pointListBeforeMoving
	 *        a copy of the point list of the moved connection
	 * @param isMovingSource
	 *        <code>true</code> if we are moving the source of the connection and <code>false</code> if we are moving the target of the connection
	 * @return
	 *         the final PointList of the connection
	 */
	public static PointList routeDummyConnection(final Connection connection, final PointList pointListBeforeMoving, final boolean isMovingSource) {
		//TODO : is it useful to create a dummy connection?

		//2. we create a dummy connection from current connection, with new informations to determine real anchor point
		final PointList initialPointList = pointListBeforeMoving.getCopy();
		final Point first = initialPointList.getFirstPoint();
		final Point last = initialPointList.getLastPoint();
		int size = initialPointList.size();

		final List<RelativeBendpoint> relatedBendpoints = new ArrayList<RelativeBendpoint>();
		final Connection dummyConnection = new PolylineConnectionEx();
		for(int i = 0; i < initialPointList.size(); i++) {
			final Point current = initialPointList.getPoint(i);
			final Dimension s = current.getDifference(first);
			final Dimension t = current.getDifference(last);
			final CustomRelativeBendpoint relatedBendpoint = new CustomRelativeBendpoint(connection);//connection and not dummyConnection! it is OK!
			relatedBendpoint.setRelativeDimensions(s, t);
			relatedBendpoints.add(relatedBendpoint);
			if(isMovingSource) {
				if(i > 1) {
					//all points must follow the target -> they must not move
					relatedBendpoint.setWeight(CustomRelativeBendpoint.FOLLOW_TARGET);
				} else {
					if(i == 0) {
						//the first point (the source point) must move!
						relatedBendpoint.setWeight(CustomRelativeBendpoint.FOLLOW_SOURCE);
					} else if(current.y == first.y) {//the second point 
						//if the segment is horizontal, its x follow the source and its y follow the target point
						relatedBendpoint.setWeight(CustomRelativeBendpoint.FOLLOW_TARGET, CustomRelativeBendpoint.FOLLOW_SOURCE);
					} else if(current.x == first.x) {
						//if the segment is vertical, its x follow the target and its y follow the source point
						relatedBendpoint.setWeight(CustomRelativeBendpoint.FOLLOW_SOURCE, CustomRelativeBendpoint.FOLLOW_TARGET);
					}
				}
			} else {
				if(i < size - 2) {
					//all points must follow the source -> they must not  move
					relatedBendpoint.setWeight(CustomRelativeBendpoint.FOLLOW_SOURCE);
				} else {
					if(i == size - 1) {
						//the  last point (the target point) must  move!
						relatedBendpoint.setWeight(CustomRelativeBendpoint.FOLLOW_TARGET);
					} else if(current.y == last.y) {//the point before the last point
						//if the segment is horizontal, its x follow the source and its y follow the target point
						relatedBendpoint.setWeight(CustomRelativeBendpoint.FOLLOW_SOURCE, CustomRelativeBendpoint.FOLLOW_TARGET);
					} else if(current.x == last.x) {
						//if the segment is vertical, its x follow the target and its y follow the source point
						relatedBendpoint.setWeight(CustomRelativeBendpoint.FOLLOW_TARGET, CustomRelativeBendpoint.FOLLOW_SOURCE);
					}
				}
			}
		}
		final IFigure sourceFigure = connection.getSourceAnchor().getOwner();
		final IFigure targetFigure = connection.getTargetAnchor().getOwner();

		final ConnectionAnchor sourceAnchor;
		final ConnectionAnchor targetAnchor;
		if(isMovingSource) {
			sourceAnchor = ((IAnchorableFigure)sourceFigure).getSourceConnectionAnchorAt(connection.getSourceAnchor().getReferencePoint());
			targetAnchor = ((IAnchorableFigure)targetFigure).getTargetConnectionAnchorAt(connection.getTargetAnchor().getReferencePoint());
		} else {
			sourceAnchor = ((IAnchorableFigure)sourceFigure).getSourceConnectionAnchorAt(connection.getSourceAnchor().getReferencePoint());
			targetAnchor = ((IAnchorableFigure)targetFigure).getTargetConnectionAnchorAt(connection.getTargetAnchor().getReferencePoint());

		}
		dummyConnection.setSourceAnchor(sourceAnchor);
		dummyConnection.setTargetAnchor(targetAnchor);

		final IFigure parent = connection.getParent();
		final IFigure layer = parent;
		dummyConnection.setParent(layer);
		dummyConnection.setPoints(initialPointList.getCopy());//required?


		//configure the router for the dummy connection
		final ConnectionRouter router = connection.getConnectionRouter();
		router.setConstraint(dummyConnection, relatedBendpoints);
		dummyConnection.setConnectionRouter(router);
		router.route(dummyConnection);

		final PointList res = dummyConnection.getPoints();
		dummyConnection.setRoutingConstraint(null);
		dummyConnection.setConnectionRouter(null);
		dummyConnection.setParent(null);
		return res;
	}

}
