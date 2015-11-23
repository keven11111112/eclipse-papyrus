/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.figure.node;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

/**
 * A slideable anchor for rounded rectangle figures.
 * 
 * @author mri
 * @author Mickael ADAM - ALL4TEC - mickael.adam@all4tec.net - Integration and adaptation for Papyrus API
 */
public class SlidableRoundedRectangleAnchor extends PapyrusSlidableSnapToGridAnchor {
	/** the offset applied to the size of the rectangle */
	private Dimension offset = new Dimension();

	/**
	 * Constructs a SlidableRoundedRectangleAnchor without a desired anchor
	 * point.
	 * 
	 * @param figure
	 *            the anchorable figure
	 */
	public SlidableRoundedRectangleAnchor(final NodeFigure figure) {
		super(figure, new PrecisionPoint(0, 0));
	}

	/**
	 * Constructs a SlidableRoundedRectangleAnchor with a desired anchor
	 * point.
	 *
	 * @param figure
	 *            the anchorable figure
	 * @param p
	 *            the anchor precision point
	 */
	public SlidableRoundedRectangleAnchor(final NodeFigure figure, final PrecisionPoint p) {
		super(figure, p);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Rectangle getBox() {
		PrecisionRectangle rBox = null;
		Object figure = getFigure();
		if (figure instanceof IRoundedRectangleFigure) {
			rBox = new PrecisionRectangle(((IRoundedRectangleFigure) ((IFigure) figure)).getRoundedRectangleBounds());
		} else if (figure instanceof IFigure) {
			rBox = new PrecisionRectangle(getOwner().getBounds());
		}

		if (rBox != null) {
			((IFigure) figure).translateToAbsolute(rBox);
			return rBox.expand(offset.width, offset.height);
		}

		return null;
	}

	/**
	 * Gets the figure.
	 *
	 * @return the figure
	 */
	private Object getFigure() {
		Object result = null;
		if (getOwner().getChildren().size() > 0) {
			result = getOwner().getChildren().get(0);
		}
		return result;
	}

	/**
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor#getPolygonPoints()
	 *
	 * @return
	 */
	@Override
	public PointList getPolygonPoints() {
		if (getFigure() instanceof IRoundedRectangleFigure) {
			// return the polygon in the case of package shape

			IRoundedRectangleFigure packageFigure = ((IRoundedRectangleFigure) ((IFigure) getFigure()));

			Rectangle packageHeader = packageFigure.getPackageHeader().getCopy();

			packageFigure.translateToAbsolute(packageHeader);
			if (!packageHeader.isEmpty()) {

				PointList points = new PointList(5);
				Rectangle anchorableRectangle = getBox();

				points.addPoint(anchorableRectangle.x, anchorableRectangle.y);

				// take in account the header of the package
				points.addPoint(anchorableRectangle.x + packageHeader.width, anchorableRectangle.y);
				points.addPoint(anchorableRectangle.x + packageHeader.width, anchorableRectangle.y + packageHeader.height);
				points.addPoint(anchorableRectangle.x + anchorableRectangle.width, anchorableRectangle.y + packageHeader.height);

				points.addPoint(anchorableRectangle.x + anchorableRectangle.width, anchorableRectangle.y + anchorableRectangle.height);
				points.addPoint(anchorableRectangle.x, anchorableRectangle.y + anchorableRectangle.height);
				points.addPoint(anchorableRectangle.x, anchorableRectangle.y);
				return points;
			} else {
				return super.getPolygonPoints();
			}
		} else {
			return super.getPolygonPoints();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PointList getIntersectionPoints(final Point ownReference, final Point foreignReference) {

		PointList pointList = null;
		Object figure = getFigure();

		if (figure instanceof IRoundedRectangleFigure) {

			// case of package
			if (!((IRoundedRectangleFigure) figure).getPackageHeader().isEmpty()) {
				final PointList polygon = getPolygonPoints();
				pointList = (new LineSeg(ownReference, foreignReference)).getLineIntersectionsWithLineSegs(polygon);

			} else {
				// Case of RoundedRectangle
				Rectangle rect = getBox();
				Dimension dimension = null;
				// Get the dimension of the owner figure
				if (figure instanceof IRoundedRectangleFigure) {
					// Force the Refresh of the Corner Dimension in case of resize(figure.paintFigure called after)
					((IRoundedRectangleFigure) figure).setOval(((IRoundedRectangleFigure) figure).isOval());
					// Get the Dimension of the figure
					dimension = ((IRoundedRectangleFigure) figure).getCornerDimensions().getCopy();
				} else {
					dimension = new Dimension();
				}
				// Adapt dimension according to the rectangle
				if (rect.height < dimension.height)
					dimension.height = rect.height;
				if (rect.width < dimension.width)
					dimension.width = rect.width;
				PrecisionRectangle corner = new PrecisionRectangle(new Rectangle(0, 0, dimension.width, dimension.height));
				((IFigure) figure).translateToAbsolute(corner);

				pointList = getLineIntersectionsWithRoundedRectangle(new LineSeg(ownReference, foreignReference), rect.x, rect.y, rect.width, rect.height, corner.width, corner.height);
			}
		} else {
			pointList = super.getIntersectionPoints(ownReference, foreignReference);
		}
		return pointList;
	}

	/**
	 * Computes the intersections of a line segment with a rounded rectangle.
	 * 
	 * @param line
	 *            the line segment
	 * @param rectX
	 *            the x-coordinate of the rounded rectangle
	 * @param rectY
	 *            the y-coordinate of the rounded rectangle
	 * @param rectW
	 *            the width of the rounded rectangle
	 * @param rectH
	 *            the height of the rounded rectangle
	 * @param arcW
	 *            the arc width of the rounded rectangle
	 * @param arcH
	 *            the arc height of the rounded rectangle
	 * @return the intersections
	 */
	private PointList getLineIntersectionsWithRoundedRectangle(final LineSeg line, final int rectX, final int rectY, final int rectW, final int rectH, final int arcW, final int arcH) {
		PointList intersections = new PointList();
		PointList rect;
		PointList rectIntersections;
		// intersection with top line segment
		rect = new PointList();
		rect.addPoint(new PrecisionPoint(rectX + arcW / 2, rectY));
		rect.addPoint(new PrecisionPoint(rectX + rectW - arcW / 2, rectY));
		rectIntersections = line.getLineIntersectionsWithLineSegs(rect);
		if (rectIntersections.size() > 0) {
			intersections.addPoint(rectIntersections.getFirstPoint());
		}
		// intersection with bottom line segment
		rect = new PointList();
		rect.addPoint(new PrecisionPoint(rectX + arcW / 2, rectY + rectH));
		rect.addPoint(new PrecisionPoint(rectX + rectW - arcW / 2, rectY + rectH));
		rectIntersections = line.getLineIntersectionsWithLineSegs(rect);
		if (rectIntersections.size() > 0) {
			intersections.addPoint(rectIntersections.getFirstPoint());
		}
		// intersection with left line segment
		rect = new PointList();
		rect.addPoint(new PrecisionPoint(rectX, rectY + arcH / 2));
		rect.addPoint(new PrecisionPoint(rectX, rectY + rectH - arcH / 2));
		rectIntersections = line.getLineIntersectionsWithLineSegs(rect);
		if (rectIntersections.size() > 0) {
			intersections.addPoint(rectIntersections.getFirstPoint());
		}
		// intersection with right line segment
		rect = new PointList();
		rect.addPoint(new PrecisionPoint(rectX + rectW, rectY + arcH / 2));
		rect.addPoint(new PrecisionPoint(rectX + rectW, rectY + rectH - arcH / 2));
		rectIntersections = line.getLineIntersectionsWithLineSegs(rect);
		if (rectIntersections.size() > 0) {
			intersections.addPoint(rectIntersections.getFirstPoint());
		}
		PointList ellipseIntersections;
		// intersection with top left ellipse
		ellipseIntersections = line.getLineIntersectionsWithEllipse(new Rectangle(rectX, rectY, arcW, arcH));
		for (int i = 0; i < ellipseIntersections.size(); ++i) {
			Point point = ellipseIntersections.getPoint(i);
			if (point.x <= rectX + arcW / 2 && point.y <= rectY + arcH / 2) {
				intersections.addPoint(point);
			}
		}
		// intersection with top right ellipse
		ellipseIntersections = line.getLineIntersectionsWithEllipse(new Rectangle(rectX + rectW - arcW, rectY, arcW, arcH));
		for (int i = 0; i < ellipseIntersections.size(); ++i) {
			Point point = ellipseIntersections.getPoint(i);
			if (point.x >= rectX + rectW - arcW / 2 && point.y <= rectY + arcH / 2) {
				intersections.addPoint(point);
			}
		}
		// intersection with bottom left ellipse
		ellipseIntersections = line.getLineIntersectionsWithEllipse(new Rectangle(rectX, rectY + rectH - arcH, arcW, arcH));
		for (int i = 0; i < ellipseIntersections.size(); ++i) {
			Point point = ellipseIntersections.getPoint(i);
			if (point.x <= rectX + arcW / 2 && point.y >= rectY + rectH - arcH / 2) {
				intersections.addPoint(point);
			}
		}
		// intersection with bottom right ellipse
		ellipseIntersections = line.getLineIntersectionsWithEllipse(new Rectangle(rectX + rectW - arcW, rectY + rectH - arcH, arcW, arcH));
		for (int i = 0; i < ellipseIntersections.size(); ++i) {
			Point point = ellipseIntersections.getPoint(i);
			if (point.x >= rectX + rectW - arcW / 2 && point.y >= rectY + rectH - arcH / 2) {
				intersections.addPoint(point);
			}
		}
		// this should always be true
		if (intersections.size() == 2) {
			// order the list so the point that is closer to the origin comes
			// first
			Point point1 = intersections.getLastPoint();
			Point point2 = intersections.getFirstPoint();
			int deltaX1 = point1.x - line.getTerminus().x;
			int deltaY1 = point1.y - line.getTerminus().y;
			int deltaX2 = point2.x - line.getTerminus().x;
			int deltaY2 = point2.y - line.getTerminus().y;
			if (deltaX1 * deltaX1 + deltaY1 * deltaY1 < deltaX2 * deltaX2 + deltaY2 * deltaY2) {
				intersections.removePoint(0);
			} else {
				intersections.removePoint(1);
			}
		}
		return intersections;
	}

	// get the location on the border with a specific ownReference point
	// Used for the PortEditPart
	@Override
	public Point getLocation(Point refParent, Point refPort) {
		return super.getLocation(refParent, refPort);
	}

	/**
	 * @param portOffset
	 */
	public void setOffset(Dimension portOffset) {
		offset.height = portOffset.height;
		offset.width = portOffset.width;
	}
}
