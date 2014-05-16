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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.papyrus.infra.tools.util.MathUtil;


/**
 * 
 * @author VL222926
 * 
 */
public class CustomRouterHelper {

	static private CustomRouterHelper sprm = new CustomRouterHelper();

	/**
	 * @return the <code>CustomRouterHelper</code> singleton instance
	 */
	static public CustomRouterHelper getInstance() {
		return sprm;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	private CustomRouterHelper() {
		//to prevent instanciation
	}


	/**
	 * We developer must call RouterHelper.getInstance.resetEndPointsToEdge before to call this method
	 * 
	 * @param conn
	 *        the connection
	 * @param newLine
	 *        the point list
	 * @param gridSpacing
	 *        the grid spacing
	 */
	public void resetEndPointsToEdgeOnGrid(final Connection conn, final PointList newLine, final double gridSpacing) {
		if(newLine.size() >= 2) {
			//source anchor
			Point newSourcePoint = getGridPoint(conn, conn.getSourceAnchor(), newLine.getFirstPoint(), newLine.getPoint(1), gridSpacing);
			newLine.setPoint(newSourcePoint, 0);

			//target anchor
			Point newTargetPoint = getGridPoint(conn, conn.getTargetAnchor(), newLine.getLastPoint(), newLine.getPoint(newLine.size() - 2), gridSpacing);
			newLine.setPoint(newTargetPoint, newLine.size() - 1);
		}

	}

	/**
	 * 
	 * @param anchor
	 *        a connection anchor
	 * @param spacing
	 *        the grid spacing
	 * @return
	 *         the point on which snap
	 */
	public Point getGridPoint(final Connection conn, final ConnectionAnchor anchor, final Point calculatedPoint, final Point secondPoint, final double spacing) {
		final IFigure figure = anchor.getOwner();
		if(figure == null) {
			return calculatedPoint;
		}

		final LineSeg seg1 = new LineSeg(calculatedPoint.getCopy(), secondPoint.getCopy());
		final Rectangle bounds = figure.getBounds().getCopy();

		//we translate the bounds of the figure to the absolute bounds
		figure.getParent().translateToAbsolute(bounds);
		IFigure parentFigure = figure.getParent();
		Viewport lastViewport = null;
		while(parentFigure != null) {
			if(parentFigure instanceof Viewport) {
				lastViewport = (Viewport)parentFigure;
				parentFigure = parentFigure.getParent();
			} else {
				parentFigure = parentFigure.getParent();
			}
		}
		//required!
		bounds.translate(lastViewport.getHorizontalRangeModel().getValue(), lastViewport.getVerticalRangeModel().getValue());

		int tolerance = 1;

		//north intersection
		final LineSeg northSeg = new LineSeg(bounds.getTopLeft(), bounds.getTopRight());
		final Point northIntersection = seg1.intersect(northSeg, tolerance);

		//south intersection
		final LineSeg southSeg = new LineSeg(bounds.getBottomLeft(), bounds.getBottomRight());
		final Point southIntersection = seg1.intersect(southSeg, tolerance);

		//east intersection
		final LineSeg eastSeg = new LineSeg(bounds.getTopRight(), bounds.getBottomRight());
		final Point eastIntersection = seg1.intersect(eastSeg, tolerance);

		//west intersection
		final LineSeg westSeg = new LineSeg(bounds.getTopLeft(), bounds.getBottomLeft());
		final Point westIntersection = seg1.intersect(westSeg, tolerance);

		int nbIntersection = 0;
		int position = PositionConstants.NONE;
		if(northIntersection != null) {
			nbIntersection++;
			position = PositionConstants.NORTH;
		}
		if(eastIntersection != null) {
			nbIntersection++;
			position = PositionConstants.EAST;
		}

		if(westIntersection != null) {
			nbIntersection++;
			position = PositionConstants.WEST;
		}

		if(southIntersection != null) {
			nbIntersection++;
			position = PositionConstants.SOUTH;
		}

		final PrecisionPoint result = new PrecisionPoint(calculatedPoint);

		if(nbIntersection > 2) {
			//no obvious case
		}
		if(nbIntersection == 2) {
			if(northIntersection == eastIntersection || northIntersection == westIntersection) {
				//arbitrary choice
				position = PositionConstants.NORTH;
				nbIntersection = 1;
			}
			if(southIntersection == eastIntersection || southIntersection == westIntersection) {
				position = PositionConstants.SOUTH;
				nbIntersection = 1;
			}
			if(nbIntersection == 2) {
				//no obvious case
			}
		}
		if(nbIntersection == 1) {
			//determine first coordinate
			switch(position) {
			case PositionConstants.NORTH:
				result.setPreciseY(bounds.getTop().y);
				break;

			case PositionConstants.SOUTH:
				result.setPreciseY(bounds.getBottom().y);
				break;
			case PositionConstants.EAST:
				result.setPreciseX(bounds.getRight().x);
				break;

			case PositionConstants.WEST:
				result.setPreciseX(bounds.getLeft().x);
				break;
			default:
				break;
			}

			//determine second coordinate
			switch(position) {
			case PositionConstants.NORTH:
			case PositionConstants.SOUTH:
				double x = MathUtil.getClosestMultiple(calculatedPoint.x, spacing);

				//verify that x value is included inside the figure
				if(!(x >= bounds.getLeft().x && x <= bounds.getRight().x)) {
					while(x < bounds.getLeft().x) {
						x = x + spacing;
					}
					while(x > bounds.getRight().x) {
						x = x - spacing;
					}
					if(!(x >= bounds.getLeft().x && x <= bounds.getRight().x)) {
						//the figure width<spacing && there is no grid point on the witdh
						x = calculatedPoint.x;
					}
				}
				result.setPreciseX(x);
				break;
			case PositionConstants.EAST:
			case PositionConstants.WEST:
				double y = MathUtil.getClosestMultiple(calculatedPoint.y, spacing);

				//verify that y value is inside the figure
				if(!(y >= bounds.getTop().y && y <= bounds.getBottom().y)) {
					while(y <= bounds.getTop().y) {
						y = y + spacing;
					}
					while(y >= bounds.getBottom().y) {
						y = y - spacing;
					}
					if(!(y >= bounds.getTop().y && y <= bounds.getBottom().y)) {
						//the figure height<spacing && there is no grid point on the height
						y = calculatedPoint.y;
					}
				}
				result.setPreciseY(y);
				break;

			default:
				break;
			}
		}
		return result;
	}

}
