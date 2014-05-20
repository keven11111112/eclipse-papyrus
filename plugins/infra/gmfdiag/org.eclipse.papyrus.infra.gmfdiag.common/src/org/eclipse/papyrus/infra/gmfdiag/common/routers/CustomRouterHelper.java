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
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
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
	 * @param zoomFactor
	 *        zoom factor
	 */
	public void resetEndPointsToEdgeOnGrid(final Connection conn, final PointList newLine, double gridSpacing, double zoomFactor) {
		final IFigure connectionParent = conn.getParent();
		if(newLine.size() >= 2) {
			Point newSourcePoint = null;
			Point newTargetPoint = null;

			if(connectionParent instanceof ConnectionLayer) {
				//source anchor
				newSourcePoint = getGridPoint(conn, conn.getSourceAnchor(), newLine.getFirstPoint(), newLine.getPoint(1), null);

				//target anchor
				newTargetPoint = getGridPoint(conn, conn.getTargetAnchor(), newLine.getLastPoint(), newLine.getPoint(newLine.size() - 2), null);
			} else if(connectionParent instanceof FreeformLayer || connectionParent == null) {//null when we are doing routing creating the link
				//source anchor
				newSourcePoint = getGridPointFromAbsoluteLocation(conn, conn.getSourceAnchor(), newLine.getFirstPoint(), newLine.getPoint(1), gridSpacing, zoomFactor);

				//target anchor
				newTargetPoint = getGridPointFromAbsoluteLocation(conn, conn.getTargetAnchor(), newLine.getLastPoint(), newLine.getPoint(newLine.size() - 2), gridSpacing, zoomFactor);
			}
			newLine.setPoint(newSourcePoint, 0);
			newLine.setPoint(newTargetPoint, newLine.size() - 1);

		}

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
	 * @param zoomFactor
	 *        zoom factor
	 */
	public void resetEndPointsToEdgeOnGrid(final Connection conn, final PointList newLine, final EditPart anEditPart) {
		final IFigure connectionParent = conn.getParent();
		if(newLine.size() >= 2) {
			Point newSourcePoint = null;
			Point newTargetPoint = null;

			if(connectionParent instanceof ConnectionLayer) {
				double gridSpacing = 2;
				double zoomFactor = 2;
				//source anchor
				newSourcePoint = getGridPoint(conn, conn.getSourceAnchor(), newLine.getFirstPoint(), newLine.getPoint(1), null);

				//target anchor
				newTargetPoint = getGridPoint(conn, conn.getTargetAnchor(), newLine.getLastPoint(), newLine.getPoint(newLine.size() - 2), null);
			} else if(connectionParent instanceof FreeformLayer || connectionParent == null) {//null when we are doing routing creating the link
				//source anchor
				newSourcePoint = getAnchorPointLocationUsingGMFCoordinates(conn, conn.getSourceAnchor(), newLine.getFirstPoint(), newLine.getPoint(1), anEditPart);

				//target anchor
				newTargetPoint = getAnchorPointLocationUsingGMFCoordinates(conn, conn.getTargetAnchor(), newLine.getLastPoint(), newLine.getPoint(newLine.size() - 2), anEditPart);
			}
			newLine.setPoint(newSourcePoint, 0);
			newLine.setPoint(newTargetPoint, newLine.size() - 1);

		}

	}



	/**
	 * 
	 * @param anchor
	 *        a connection anchor
	 * @param anEditPart
	 *        TODO
	 * @return
	 *         the point on which snap
	 */
	public Point getGridPoint(final Connection conn, final ConnectionAnchor anchor, Point calculatedPoint, Point secondPoint, EditPart anEditPart) {

		final IFigure figure = anchor.getOwner();
		if(figure == null) {
			return calculatedPoint;
		}
		double spacing = DiagramEditPartsUtil.getDiagramGridSpacing(anEditPart);

		double zoomFactor = DiagramEditPartsUtil.getDiagramZoomLevel(anEditPart);
		spacing = spacing * zoomFactor;
		double zoom = zoomFactor;
		double x1 = calculatedPoint.x * zoom;
		double y1 = calculatedPoint.y * zoom;

		double x2 = secondPoint.preciseX() * zoom;
		double y2 = secondPoint.preciseY() * zoom;

		calculatedPoint = new PrecisionPoint(x1, y1);
		secondPoint = new PrecisionPoint(x2, y2);

		//		calculatedPoint.
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
		result.setPreciseX(result.preciseX() / zoom);
		result.setPreciseY(result.preciseY() / zoom);
		return result;
	}


	/**
	 * 
	 * @param anchor
	 *        a connection anchor
	 * @param spacing
	 *        the grid spacing
	 * @param zoomFactor
	 *        the zoom factor t apply for the calculus
	 * @return
	 *         the point on which snap
	 */
	public Point getGridPointFromAbsoluteLocation(final Connection conn, final ConnectionAnchor anchor, final Point calculatedPoint, final Point secondPoint, double spacing, double zoomFactor) {
		final IFigure figure = anchor.getOwner();
		if(figure == null) {
			return calculatedPoint;
		}

		conn.getSourceAnchor().getOwner().translateToRelative(calculatedPoint);
		//
		//		IFigure parentFigure = figure.getParent();
		//		Viewport lastViewport = null;
		//		while(parentFigure != null) {
		//			if(parentFigure instanceof Viewport) {
		//				lastViewport = (Viewport)parentFigure;
		//				parentFigure = parentFigure.getParent();
		//			} else {
		//				parentFigure = parentFigure.getParent();
		//			}
		//		}

		//		conn.getSourceAnchor().getOwner().translateToRelative(calculatedPoint);
		//		System.out.println("calcultatedPoint" + calculatedPoint);
		//		conn.getSourceAnchor().getOwner().translateToRelative(secondPoint);
		//		calculatedPoint.translate(lastViewport.getHorizontalRangeModel().getValue(), lastViewport.getVerticalRangeModel().getValue());
		//		secondPoint.translate(-lastViewport.getHorizontalRangeModel().getValue(), -lastViewport.getVerticalRangeModel().getValue());
		final LineSeg seg1 = new LineSeg(calculatedPoint.getCopy(), secondPoint.getCopy());
		final Rectangle bounds = figure.getBounds().getCopy();

		//we translate the bounds of the figure to the absolute bounds

		//required!
		//		bounds.translate(lastViewport.getHorizontalRangeModel().getValue(), lastViewport.getVerticalRangeModel().getValue());
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
		//		result.setPreciseX(result.preciseX() / zoom);
		//		result.setPreciseY(result.preciseY() / zoom);

		//		System.out.println("result" + result);
		conn.getSourceAnchor().getOwner().translateToAbsolute(result);
		//		System.out.println("result after translation" + result);
		return result;
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
	 * @param zoomFactor
	 *        zoom factor
	 */
	public void resetEndPointsToEdgeOnGridUsingGMFCoordinates(final Connection conn, final PointList newLine, final EditPart anEditPart) {
		//		final IFigure connectionParent = conn.getParent();
		//		if(newLine.size() >= 2) {
		//			Point newSourcePoint = null;
		//			Point newTargetPoint = null;

		//			if(connectionParent instanceof ConnectionLayer) {
		//				double gridSpacing = 2;
		//				double zoomFactor = 2;
		//source anchor
		//				newSourcePoint = getGridPoint(conn, conn.getSourceAnchor(), newLine.getFirstPoint(), newLine.getPoint(1), null);
		//
		//target anchor
		//				newTargetPoint = getGridPoint(conn, conn.getTargetAnchor(), newLine.getLastPoint(), newLine.getPoint(newLine.size() - 2), null);
		//			} else if(connectionParent instanceof FreeformLayer || connectionParent == null) {//null when we are doing routing creating the link
		//source anchor
		final PointList oldNewLine = newLine.getCopy();
		Point newSourcePoint = getAnchorPointLocationUsingGMFCoordinates(conn, conn.getSourceAnchor(), newLine.getFirstPoint(), newLine.getPoint(1), anEditPart);

		//target anchor
		Point newTargetPoint = getAnchorPointLocationUsingGMFCoordinates(conn, conn.getTargetAnchor(), newLine.getLastPoint(), newLine.getPoint(newLine.size() - 2), anEditPart);
		//			}
		newLine.setPoint(newSourcePoint, 0);
		newLine.setPoint(newTargetPoint, newLine.size() - 1);


		//test test test
		//to force rectilinear -> OK , but not always on the grid!
		//		for(int i = 1; i < oldNewLine.size() - 2; i++) {
		//			boolean copyX = oldNewLine.getPoint(i - 1).x == oldNewLine.getPoint(i).x;
		//			boolean copyY = oldNewLine.getPoint(i - 1).y == oldNewLine.getPoint(i).y;
		//
		//			if(copyX) {
		//				Point previousPoint = newLine.getPoint(i - 1);
		//				Point currentPoint = newLine.getPoint(i);
		//				newLine.setPoint(new Point(previousPoint.x, currentPoint.y), i);
		//			}
		//			if(copyY) {
		//				Point previousPoint = newLine.getPoint(i - 1);
		//				Point currentPoint = newLine.getPoint(i);
		//				newLine.setPoint(new Point(currentPoint.x, previousPoint.y), i);
		//			}
		//		}
		//
		//		int size = oldNewLine.size();
		//		boolean copyX = oldNewLine.getPoint(size - 2).x == oldNewLine.getPoint(size - 1).x;
		//		boolean copyY = oldNewLine.getPoint(size - 2).y == oldNewLine.getPoint(size - 1).y;
		//
		//		if(copyX) {
		//			Point previousPoint = newLine.getPoint(size - 1);
		//			Point currentPoint = newLine.getPoint(size - 2);
		//			newLine.setPoint(new Point(previousPoint.x, currentPoint.y), size - 2);
		//		}
		//		if(copyY) {
		//			Point previousPoint = newLine.getPoint(size - 1);
		//			Point currentPoint = newLine.getPoint(size - 2);
		//			newLine.setPoint(new Point(currentPoint.x, previousPoint.y), size - 2);
		//		}
		//



	}


	/**
	 * 
	 * @param conn
	 *        the connection
	 * @param anchor
	 *        an anchor
	 * @param anchorPointInAbsoluteGMFCoordinates
	 *        the anchor location obtains during the creation of the link, so zoom impact it
	 * @param secondPointInGMFCoordinates
	 *        the next point of the link, so zoom impact it
	 * @param anEditPart
	 *        an edit part of the edited diagram
	 * @return
	 *         the best point to push the anchor in the GMF Coordinates (zoom impact it!)
	 */
	public Point getAnchorPointLocationUsingGMFCoordinates(final Connection conn, final ConnectionAnchor anchor, final Point anchorPointInAbsoluteGMFCoordinates, final Point secondPointInGMFCoordinates, EditPart anEditPart) {
		final IFigure figure = anchor.getOwner();
		if(figure == null) {
			return anchorPointInAbsoluteGMFCoordinates;
		}
		final double spacing = DiagramEditPartsUtil.getDiagramGridSpacing(anEditPart);
		final Point anchorPoint = GridUtils.getPointFromFeedbackToGridCoordinate(anchorPointInAbsoluteGMFCoordinates, anEditPart);
		final Point secondPoint = GridUtils.getPointFromFeedbackToGridCoordinate(secondPointInGMFCoordinates, anEditPart);

		final Rectangle bounds = GridUtils.getRealAbsoluteCoordinateFromGrid(anchor.getOwner(), anEditPart);

		final LineSeg seg1 = new LineSeg(anchorPoint.getCopy(), secondPoint.getCopy());

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

		final PrecisionPoint result = new PrecisionPoint(anchorPoint);

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
				double x = MathUtil.getClosestMultiple(anchorPoint.x, spacing);

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
						x = anchorPoint.x;
					}
				}
				result.setPreciseX(x);
				break;
			case PositionConstants.EAST:
			case PositionConstants.WEST:
				double y = MathUtil.getClosestMultiple(anchorPoint.y, spacing);

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
						y = anchorPoint.y;
					}
				}
				result.setPreciseY(y);
				break;

			default:
				break;
			}
		}

		//we translate the result of the calculus in the initial GMF system coordinate
		final Point res = GridUtils.getFeedBackPointFromGridCoordinate(result, anEditPart);
		return res;
	}

	/**
	 * this method is nicest than {@link #getGridPoint(Connection, ConnectionAnchor, Point, Point, EditPart)} and should give the same result
	 * than the previous one, but the result have less precision, so we don't use it currently
	 * 
	 * To see the difference between the other version of this method :
	 * - 1 Create a package with 2 Blocks (you need to be inside a container)
	 * - create an association between these block
	 * 
	 * -> change the zoom level...
	 * 
	 * @param anchor
	 *        a connection anchor
	 * @param spacing
	 *        the grid spacing
	 * @param zoomFactor
	 *        the zoom factor to apply for the calculus
	 * @return
	 *         the point on which snap
	 */
	public Point getGridPointV2(final Connection conn, final ConnectionAnchor anchor, Point calculatedPoint, Point secondPoint, double spacing, double zoomFactor) {
		spacing = spacing / zoomFactor;
		PrecisionPoint first = new PrecisionPoint(calculatedPoint);
		PrecisionPoint second = new PrecisionPoint(secondPoint);
		conn.translateToAbsolute(first);
		conn.translateToAbsolute(second);




		final IFigure sourceFig = anchor.getOwner();
		if(sourceFig == null) {
			return calculatedPoint;
		}


		final Rectangle boundsRect = sourceFig.getBounds();

		sourceFig.getParent().translateToRelative(first);
		sourceFig.getParent().translateToRelative(second);

		LineSeg seg_2 = new LineSeg(first, second);

		//north intersection
		final LineSeg northSeg1 = new LineSeg(boundsRect.getTopLeft(), boundsRect.getTopRight());
		final Point northIntersection1 = seg_2.intersect(northSeg1, 1);

		//south intersection
		final LineSeg southSeg1 = new LineSeg(boundsRect.getBottomLeft(), boundsRect.getBottomRight());
		final Point southIntersection1 = seg_2.intersect(southSeg1, 1);

		//east intersection
		final LineSeg eastSeg1 = new LineSeg(boundsRect.getTopRight(), boundsRect.getBottomRight());
		final Point eastIntersection1 = seg_2.intersect(eastSeg1, 1);

		//west intersection
		final LineSeg westSeg1 = new LineSeg(boundsRect.getTopLeft(), boundsRect.getBottomLeft());
		final Point westIntersection1 = seg_2.intersect(westSeg1, 1);

		int nbIntersection1 = 0;
		int position1 = PositionConstants.NONE;
		if(northIntersection1 != null) {
			nbIntersection1++;
			position1 = PositionConstants.NORTH;
		}
		if(eastIntersection1 != null) {
			nbIntersection1++;
			position1 = PositionConstants.EAST;
		}

		if(westIntersection1 != null) {
			nbIntersection1++;
			position1 = PositionConstants.WEST;
		}

		if(southIntersection1 != null) {
			nbIntersection1++;
			position1 = PositionConstants.SOUTH;
		}

		PrecisionPoint result1 = new PrecisionPoint(calculatedPoint);

		if(nbIntersection1 > 2) {
			//no obvious case
		}
		if(nbIntersection1 == 2) {
			if(northIntersection1 == eastIntersection1 || northIntersection1 == westIntersection1) {
				//arbitrary choice
				position1 = PositionConstants.NORTH;
				nbIntersection1 = 1;
			}
			if(southIntersection1 == eastIntersection1 || southIntersection1 == westIntersection1) {
				position1 = PositionConstants.SOUTH;
				nbIntersection1 = 1;
			}
			if(nbIntersection1 == 2) {
				//no obvious case
			}
		}
		if(nbIntersection1 == 1) {
			//determine first coordinate
			switch(position1) {
			case PositionConstants.NORTH:
				result1.setPreciseY(boundsRect.getTop().y);
				break;

			case PositionConstants.SOUTH:
				result1.setPreciseY(boundsRect.getBottom().y);
				break;
			case PositionConstants.EAST:
				result1.setPreciseX(boundsRect.getRight().x);
				break;

			case PositionConstants.WEST:
				result1.setPreciseX(boundsRect.getLeft().x);
				break;
			default:
				break;
			}

			//determine second coordinate
			switch(position1) {
			case PositionConstants.NORTH:
			case PositionConstants.SOUTH:
				double x = getClosestMultiple(first.preciseX(), spacing);

				//verify that x value is included inside the figure
				if(!(x >= boundsRect.getLeft().x && x <= boundsRect.getRight().x)) {
					while(x < boundsRect.getLeft().x) {
						x = x + spacing;
					}
					while(x > boundsRect.getRight().x) {
						x = x - spacing;
					}
					if(!(x >= boundsRect.getLeft().x && x <= boundsRect.getRight().x)) {
						//the figure width<spacing && there is no grid point on the witdh
						x = first.preciseX();
					}
				}
				result1.setPreciseX(x);
				break;
			case PositionConstants.EAST:
			case PositionConstants.WEST:
				double y = getClosestMultiple(first.preciseY(), spacing);

				//verify that y value is inside the figure
				if(!(y >= boundsRect.getTop().y && y <= boundsRect.getBottom().y)) {
					while(y <= boundsRect.getTop().y) {
						y = y + spacing;
					}
					while(y >= boundsRect.getBottom().y) {
						y = y - spacing;
					}
					if(!(y >= boundsRect.getTop().y && y <= boundsRect.getBottom().y)) {
						//the figure height<spacing && there is no grid point on the height
						y = first.preciseY();
					}
				}
				result1.setPreciseY(y);
				break;

			default:
				break;
			}
		}
		result1.setPreciseX(result1.preciseX());
		result1.setPreciseY(result1.preciseY());

		sourceFig.getParent().translateToAbsolute(result1);
		conn.translateToRelative(result1);

		return result1;
	}

	/**
	 * 
	 * @param aValue
	 *        a value
	 * @param base
	 *        the base to use to find closest multiple
	 * @return
	 *         the closed multiple
	 */
	private static final double getClosestMultiple(final double aValue, final double base) {
		double div = aValue / base;
		double remainder = aValue % base;
		if(remainder * 2 > base) {
			div++;
		}
		return div * base;
	}
}
