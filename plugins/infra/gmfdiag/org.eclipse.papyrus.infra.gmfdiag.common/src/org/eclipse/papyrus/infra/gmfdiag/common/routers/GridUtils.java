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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;

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
