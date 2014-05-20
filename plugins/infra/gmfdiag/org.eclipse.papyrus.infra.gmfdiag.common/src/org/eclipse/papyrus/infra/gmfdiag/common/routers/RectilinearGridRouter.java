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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.RectilinearRouter;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.tools.util.MathUtil;

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
	private final EditPart anyEditPart;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param anyEditPart
	 *        an edit part of the diagram
	 */
	public RectilinearGridRouter(final EditPart anyEditPart) {
		this.anyEditPart = anyEditPart;
	}

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
	public void routeLine(final Connection conn, final int nestedRoutingDepth, final PointList newLine) {
		super.routeLine(conn, nestedRoutingDepth, newLine);
		final double zoom;

		if(conn.getParent() instanceof ConnectionLayer) {
			zoom = 1;
		} else if(conn.getParent() instanceof FreeformLayer || conn.getParent() == null) {
			zoom = DiagramEditPartsUtil.getDiagramZoomLevel(this.anyEditPart);
		} else {
			zoom = 1;
		}
		if(DiagramEditPartsUtil.isSnapToGridActive(this.anyEditPart)) {

			double gridSpacing = DiagramEditPartsUtil.getDiagramGridSpacing(this.anyEditPart) * zoom;
			final int nbPoints = newLine.size();
			if(nbPoints >= 3) {
				//we don't move the anchor, we only move the intermediate points
				PointList newLineCopy = newLine.getCopy();

				for(int i = 1; i < newLine.size() - 1; i++) {
					Point previousPoint = newLineCopy.getPoint(i - 1);
					Point current = newLineCopy.getPoint(i);
					PrecisionPoint newPoint = new PrecisionPoint(current.getCopy());
					if(i > 0 && i < nbPoints - 1) {
						boolean copyX = previousPoint.x == current.x;
						boolean copyY = previousPoint.y == current.y;

						if(!copyX) {
							newPoint.setPreciseX(MathUtil.getClosestMultiple(current.x, gridSpacing));
						} else {
							newPoint.setPreciseX(newLine.getPoint(i - 1).x);
						}
						if(!copyY) {
							newPoint.setPreciseY(MathUtil.getClosestMultiple(current.y, gridSpacing));
						} else {
							newPoint.setPreciseY(newLine.getPoint(i - 1).y);
						}
					}

					if(i == nbPoints - 2) {
						if(current.x == newLineCopy.getPoint(i + 1).x) {
							newPoint.x = current.x;
						}
						if(current.y == newLineCopy.getPoint(i + 1).y) {
							newPoint.y = current.y;
						}
					}
					newLine.setPoint(newPoint, i);
				}
			}

			resetEndPointsToEdge(conn, newLine);
		}
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
		super.resetEndPointsToEdge(conn, newLine);
		if(DiagramEditPartsUtil.isSnapToGridActive(this.anyEditPart)) {
			double spacing = DiagramEditPartsUtil.getDiagramGridSpacing(this.anyEditPart);
			double zoom = DiagramEditPartsUtil.getDiagramZoomLevel(this.anyEditPart);
			CustomRouterHelper.getInstance().resetEndPointsToEdgeOnGrid(conn, newLine, spacing, zoom);
		}
	}
}
