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

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.tools.util.MathUtil;

/**
 * 
 * @author VL222926
 * 
 */
public class GridUtils {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public GridUtils() {
		//to prevent instanciation
	}


	/**
	 * 
	 * @param bounds
	 *        a rectangle
	 * @param lineSeg
	 *        a segment to fix on the rectangle
	 * @param gridSpacing
	 *        the spacing of the grid
	 * @return
	 *         the best point to anchor the segment
	 */
	public static final Point getPointOnGrid(final Rectangle bounds, final LineSeg lineSeg, final double gridSpacing) {
		//		final LineSeg seg1 = new LineSeg(first.getCopy(), second.getCopy());
		final Point first = lineSeg.getOrigin();
		int tolerance = 1;

		//north intersection
		final LineSeg northSeg = new LineSeg(bounds.getTopLeft(), bounds.getTopRight());
		final Point northIntersection = lineSeg.intersect(northSeg, tolerance);

		//south intersection
		final LineSeg southSeg = new LineSeg(bounds.getBottomLeft(), bounds.getBottomRight());
		final Point southIntersection = lineSeg.intersect(southSeg, tolerance);

		//east intersection
		final LineSeg eastSeg = new LineSeg(bounds.getTopRight(), bounds.getBottomRight());
		final Point eastIntersection = lineSeg.intersect(eastSeg, tolerance);

		//west intersection
		final LineSeg westSeg = new LineSeg(bounds.getTopLeft(), bounds.getBottomLeft());
		final Point westIntersection = lineSeg.intersect(westSeg, tolerance);

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

		final PrecisionPoint result = new PrecisionPoint(first);

		if(nbIntersection > 2) {
			//no obvious case
		}
		if(nbIntersection == 2) {

			if(northIntersection != null && (northIntersection == eastIntersection || northIntersection == westIntersection)) {
				//arbitrary choice
				position = PositionConstants.NORTH;
				nbIntersection = 1;
			}
			if(southIntersection != null && (southIntersection == eastIntersection || southIntersection == westIntersection)) {
				position = PositionConstants.SOUTH;
				nbIntersection = 1;
			}
			if(nbIntersection == 2) {
				//segment is probably // to a side of the rectangle
				if(northIntersection != null && westIntersection != null) {
					if(northIntersection.preciseX() == westIntersection.preciseX()) {
						position = PositionConstants.NORTH;
						nbIntersection = 1;
					}
					if(northIntersection.preciseY() == westIntersection.preciseY()) {
						position = PositionConstants.WEST;
						nbIntersection = 1;
					}
				} else if(northIntersection != null && eastIntersection != null) {
					if(northIntersection.preciseX() == eastIntersection.preciseX()) {
						position = PositionConstants.NORTH;
						nbIntersection = 1;
					}
					if(northIntersection.preciseY() == eastIntersection.preciseY()) {
						position = PositionConstants.EAST;
						nbIntersection = 1;
					}
				} else if(southIntersection != null && westIntersection != null) {
					if(southIntersection.preciseX() == westIntersection.preciseX()) {
						position = PositionConstants.SOUTH;
						nbIntersection = 1;
					}
					if(southIntersection.preciseY() == westIntersection.preciseY()) {
						position = PositionConstants.WEST;
						nbIntersection = 1;
					}
				} else if(southIntersection != null && eastIntersection != null) {
					if(southIntersection.preciseX() == eastIntersection.preciseX()) {
						position = PositionConstants.SOUTH;
						nbIntersection = 1;
					}
					if(southIntersection.preciseY() == eastIntersection.preciseY()) {
						position = PositionConstants.EAST;
						nbIntersection = 1;
					}
				} else {
					//no obvious case
				}
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
				double x = MathUtil.getClosestMultiple(first.x, gridSpacing);

				//verify that x value is included inside the figure
				if(!(x >= bounds.getLeft().x && x <= bounds.getRight().x)) {
					while(x < bounds.getLeft().x) {
						x = x + gridSpacing;
					}
					while(x > bounds.getRight().x) {
						x = x - gridSpacing;
					}
					if(!(x >= bounds.getLeft().x && x <= bounds.getRight().x)) {
						//the figure width<spacing && there is no grid point on the witdh
						x = first.x;
					}
				}
				result.setPreciseX(x);
				break;
			case PositionConstants.EAST:
			case PositionConstants.WEST:
				double y = MathUtil.getClosestMultiple(first.y, gridSpacing);

				//verify that y value is inside the figure
				if(!(y >= bounds.getTop().y && y <= bounds.getBottom().y)) {
					while(y <= bounds.getTop().y) {
						y = y + gridSpacing;
					}
					while(y >= bounds.getBottom().y) {
						y = y - gridSpacing;
					}
					if(!(y >= bounds.getTop().y && y <= bounds.getBottom().y)) {
						//the figure height<spacing && there is no grid point on the height
						y = first.y;
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

	/**
	 * 
	 * @param point
	 * @param anEditPart
	 * @return
	 */
	public static final Point getPointFromFeedbackToGridCoordinate(final Point point, final EditPart anEditPart) {
		final Point result = point.getCopy();
		double zoomLevel = DiagramEditPartsUtil.getDiagramZoomLevel(anEditPart);
		result.scale(1 / zoomLevel);
		boolean debug = false;
		if(debug) {
			System.out.println("initialPoint/convertedPoint");
			System.out.println(point + "/" + result);
		}
		return result;
	}

	public static final Point getFeedBackPointFromGridCoordinate(final Point point, final EditPart anEditPart) {
		final Point result = point.getCopy();
		double zoomLevel = DiagramEditPartsUtil.getDiagramZoomLevel(anEditPart);
		result.scale(zoomLevel);
		boolean debug = false;
		if(debug) {
			System.out.println("initialPoint/convertedPoint");
			System.out.println(point + "/" + result);
		}
		return result;
	}

	public static final Rectangle getRealAbsoluteCoordinateFromGrid(final IFigure figure, final EditPart anEditPart) {
		final Rectangle initialBounds = figure.getBounds().getCopy();
		final Rectangle result = initialBounds.getCopy();
		figure.translateToAbsolute(result); //in case of zoom the location and the dimension are not correct
		double zoomFactor = DiagramEditPartsUtil.getDiagramZoomLevel(anEditPart);
		result.scale(1 / zoomFactor);//we find the real size, but not the real location in case of scrollbar
		final IDiagramGraphicalViewer viewer = DiagramEditPartsUtil.getActiveDiagramGraphicalViewer();
		final FigureCanvas figureCanvas = (FigureCanvas)viewer.getControl();
		Point location = figureCanvas.getViewport().getViewLocation();
		location.scale(1 / zoomFactor);//translation to get the absolute location with the scrollbar
		result.translate(location);
		boolean debug = false;
		if(debug) {
			System.out.println("initialBounds/convertedBounds : zoomLevel = " + zoomFactor + " scollbar = " + location);
			System.out.println(initialBounds + "/" + result);
		}

		return result;
	}

	public static final Rectangle getGridCoordinateFromRealAbsoluteCoordinate(final IFigure figure, final EditPart anEditPart) {
		throw new UnsupportedOperationException();
		//		final Rectangle initialBounds = figure.getBounds();
		//		final Rectangle result = initialBounds.getCopy();
		//		figure.translateToAbsolute(result); //in case of zoom the location and the dimension are not correct
		//		double zoomFactor = DiagramEditPartsUtil.getDiagramZoomLevel(anEditPart);
		//		result.scale(1 / zoomFactor);//we find the real size, but not the real location in case of scrollbar
		//		final IDiagramGraphicalViewer viewer = DiagramEditPartsUtil.getActiveDiagramGraphicalViewer();
		//		final FigureCanvas figureCanvas = (FigureCanvas)viewer.getControl();
		//		Point location = figureCanvas.getViewport().getViewLocation();
		//		location.scale(1 / zoomFactor);//translation to get the absolute location with the scrollbar
		//		result.translate(location);
		//		boolean debug = true;
		//		if(debug) {
		//			System.out.println("initialBounds/convertedBounds : zoomLevel = " + zoomFactor + " scollbar = " + location);
		//			System.out.println(initialBounds + "/" + result);
		//		}

		//		return result;
	}

}
