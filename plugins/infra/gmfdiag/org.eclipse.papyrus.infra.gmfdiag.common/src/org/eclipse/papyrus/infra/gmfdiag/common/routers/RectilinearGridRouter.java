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
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.RectilinearRouter;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;

/**
 * 
 * A rectilinear router which use the grid, when Snap To Grid is activated on the diagram
 * 
 */
@SuppressWarnings("restriction")
public class RectilinearGridRouter extends RectilinearRouter {

	/**
	 * an edit part of the diagram
	 */
	private final EditPart anEditPart;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param anyEditPart
	 *        an edit part of the diagram
	 */
	public RectilinearGridRouter(final EditPart anyEditPart) {
		this.anEditPart = anyEditPart;
	}

	//	static PointList copy;

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.internal.routers.RectilinearRouter#routeLine(org.eclipse.draw2d.Connection, int,
	 *      org.eclipse.draw2d.geometry.PointList)
	 * 
	 * @param conn
	 * @param nestedRoutingDepth
	 * @param newLine
	 */
	@Override
	public void routeLine(final Connection conn, final int nestedRoutingDepth, PointList newLine) {
		System.out.println("ZOOM = " + DiagramEditPartsUtil.getDiagramZoomLevel(this.anEditPart));
		final IFigure connectionParent = conn.getParent();
		if(connectionParent == null || !(connectionParent instanceof ConnectionLayer) && connectionParent instanceof FreeformLayer) {
			if(connectionParent != null) {
				System.out.println("feedback points------------------------------------------------------");

			} else {
				System.out.println("creation points------------------------------------------------------");
			}

			for(int i = 0; i < newLine.size(); i++) {
				Point t = newLine.getPoint(i);
				//				Point t = GridUtils.getPointFromFeedbackToGridCoordinate(current, this.anEditPart);
				System.out.println("point i=" + i + " " + t);
			}
		}
		super.routeLine(conn, nestedRoutingDepth, newLine);
		//		if(newLine.size() >= 4) {
		//			int i = 0;
		//			i++;
		//		}
		//		boolean cop1y = true;
		//		if(cop1y) {
		//			copy = newLine.getCopy();
		//		} else {
		//			newLine = copy.getCopy();
		//		}
		//		//		System.out.println("initial constraint");
		//		for(int i = 0; i < newLine.size(); i++) {
		//			//			System.out.println(newLine.getPoint(i));
		//		}
		//	
		//
		//		//		System.out.println("obtained constraint");
		//		//		for(int i = 0; i < newLine.size(); i++) {
		//		//			System.out.println(GridUtils.getPointFromFeedbackToGridCoordinate(newLine.getPoint(i), this.anEditPart));
		//		//		}
		//
		//
		//		final IFigure connectionParent = conn.getParent();
		//		if(!(connectionParent instanceof ConnectionLayer) && connectionParent instanceof FreeformLayer) {
		//			if(DiagramEditPartsUtil.isSnapToGridActive(this.anEditPart) && false) {
		//				final double zoom = DiagramEditPartsUtil.getDiagramZoomLevel(this.anEditPart);
		//				final double gridSpacing = DiagramEditPartsUtil.getDiagramGridSpacing(this.anEditPart) * zoom;
		//				final int nbPoints = newLine.size();
		//				//				if(nbPoints >= 3) {
		//				//we don't move the anchor, we only move the intermediate points
		//				PointList newLineCopy = newLine.getCopy();
		//
		//				for(int i = 1; i < newLine.size() - 1; i++) {
		//					Point previousPoint = newLineCopy.getPoint(i - 1);
		//					Point current = newLineCopy.getPoint(i);
		//					Point newPoint = new PrecisionPoint(current.getCopy());
		//					if(i > 0 && i < nbPoints - 1) {
		//						boolean copyX = previousPoint.x == current.x;
		//						boolean copyY = previousPoint.y == current.y;
		//
		//						if(!copyX) {
		//							newPoint.setX((int)MathUtil.getClosestMultiple(current.x, gridSpacing));
		//						} else {
		//							newPoint.setX(newLine.getPoint(i - 1).x);
		//						}
		//						if(!copyY) {
		//							newPoint.setY((int)MathUtil.getClosestMultiple(current.y, gridSpacing));
		//						} else {
		//							newPoint.setY(newLine.getPoint(i - 1).y);
		//						}
		//					}
		//
		//					if(i == nbPoints - 2) {
		//						if(current.x == newLineCopy.getPoint(i + 1).x) {
		//							newPoint.x = current.x;
		//						}
		//						if(current.y == newLineCopy.getPoint(i + 1).y) {
		//							newPoint.y = current.y;
		//						}
		//					}
		//					newLine.setPoint(newPoint, i);
		//				}
		//				//				}
		//
		//				//
		//				//				resetEndPointsToEdge(conn, newLine);
		//
		//				System.out.println("MY NICE POINT");
		//				for(int i = 0; i < newLine.size(); i++) {
		//
		//					Point current = newLine.getPoint(i);
		//					System.out.println(GridUtils.getPointFromFeedbackToGridCoordinate(current, this.anEditPart));;
		//					if(i < newLine.size() - 1 && newLine.size() >= 3) {
		//						Point next = newLine.getPoint(i + 1);
		//
		//						if(current.x != next.x && current.y != next.y) {
		//							System.out.println("ERROR-ERROR-ERROR-ERRORS");
		//							int j = 0;
		//							j++;
		//						}
		//					}
		//				}
		//				System.out.println("MY NICE POINT");
		//			}
		//		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ObliqueRouter#resetEndPointsToEdge(org.eclipse.draw2d.Connection,
	 *      org.eclipse.draw2d.geometry.PointList)
	 * 
	 * @param conn
	 * @param newLine
	 */
	@Override
	protected void resetEndPointsToEdge(final Connection conn, final PointList newLine) {
		final IFigure connectionParent = conn.getParent();
		super.resetEndPointsToEdge(conn, newLine);
		if(connectionParent == null || !(connectionParent instanceof ConnectionLayer) && connectionParent instanceof FreeformLayer) {
			if(DiagramEditPartsUtil.isSnapToGridActive(this.anEditPart)) {
				super.resetEndPointsToEdge(conn, newLine);
				//TODO : move this call to this class
				CustomRouterHelper.getInstance().resetEndPointsToEdgeOnGridUsingGMFCoordinates(conn, newLine, this.anEditPart);
			}
		}
	}
}
