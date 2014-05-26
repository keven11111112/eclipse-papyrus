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
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ObliqueRouter;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;

/**
 * 
 * Oblique Router snapping to grid anchor when snap to grid is activated
 * 
 */
@SuppressWarnings("restriction")
public class ObliqueGridRouter extends ObliqueRouter {

	/**
	 * an editpart of the diagram
	 */
	private final EditPart anyEditPart;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param anyEditPart
	 *        an editpart of the diagram
	 */
	public ObliqueGridRouter(final EditPart anyEditPart) {
		this.anyEditPart = anyEditPart;
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
	protected void resetEndPointsToEdge(Connection conn, PointList newLine) {
		super.resetEndPointsToEdge(conn, newLine);
		final IFigure connectionParent = conn.getParent();
		if(DiagramEditPartsUtil.isSnapToGridActive(this.anyEditPart)) {
			if(connectionParent == null || !(connectionParent instanceof ConnectionLayer) && connectionParent instanceof FreeformLayer) {
				double spacing = DiagramEditPartsUtil.getDiagramGridSpacing(this.anyEditPart);
				double zoom = DiagramEditPartsUtil.getDiagramZoomLevel(this.anyEditPart);
				CustomRouterHelper.getInstance().resetEndPointsToEdgeOnGrid(conn, newLine, spacing, zoom);
			}
		}
	}
}
