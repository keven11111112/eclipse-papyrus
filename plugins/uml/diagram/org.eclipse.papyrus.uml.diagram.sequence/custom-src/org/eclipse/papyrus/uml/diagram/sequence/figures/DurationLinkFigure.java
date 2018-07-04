/*****************************************************************************
 * Copyright (c) 2018 CEA LIST, EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.swt.SWT;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;

/**
 * <p>
 * A Figure for Durations ({@link DurationObservation Observation} or {@link DurationConstraint Constraint})
 * represented as an arrow between two events. The figure consists of two horizontal dashed lines,
 * with a vertical arrow between them:
 * </p>
 * <img src="./doc-files/DurationLinkFigure.png" />
 * <p>
 * The horizontal lines are <code>anchored</code> to the source/target of the link. By default, the vertical line will
 * be placed in the middle of the bounds formed by these two anchors, although the figure supports a horizontal delta,
 * to position the arrow closer to one or the other anchor.
 * </p>
 *
 * <p>
 * The figure can also be rotated 90° (i.e. vertical dashed lines and horizontal arrow),
 * when the source and target points are on the same Y coordinate (Typically for horizontal messages)
 * </p>
 */
public class DurationLinkFigure extends UMLEdgeFigure {

	/**
	 * The horizontal dashed line will be drawn slightly further
	 * than the arrow, by this amount of pixels.
	 */
	private static final int ARROW_PADDING = 15;
	private Orientation arrowOrientation = Orientation.VERTICAL; // TODO Orientation is not supported yet (Bug 536637)
	private int arrowPositionDelta = 0;

	/**
	 * Thin lines may be difficult to select, so we add a tolerance area around it
	 * to make selection easier.
	 *
	 * @see #containsPoint(int, int)
	 */
	private static final int SELECTION_TOLERANCE = 3;

	@Override
	protected void outlineShape(Graphics graphics) {
		// Skip super; we're not drawing a polyline connection
		paintStartLine(graphics);
		paintEndLine(graphics);
		paintArrow(graphics);
	}

	/**
	 * Paint the line from this figure to the start point/event (Typically a horizontal line)
	 *
	 * @param graphics
	 */
	protected void paintStartLine(Graphics graphics) {
		graphics.pushState();
		graphics.setLineStyle(SWT.LINE_DASH);
		try {
			Point startLineStart = getStart();
			Point startLineEnd = getTopLineEnd();

			graphics.drawLine(startLineStart, startLineEnd);
		} finally {
			graphics.popState();
		}
	}

	/**
	 * @return
	 */
	private int getArrowLineX() {
		if (getPoints().size() < 2) {
			// The connection is not configured yet
			return 0;
		}
		return (getStart().x() + getEnd().x()) / 2 + arrowPositionDelta;
	}

	/**
	 * Paint the line from this figure to the end point/event (Typically a horizontal line)
	 *
	 * @param graphics
	 */
	protected void paintEndLine(Graphics graphics) {
		graphics.pushState();
		graphics.setLineStyle(SWT.LINE_DASH);
		try {
			Point endLineStart = getEnd();
			Point endLineEnd = getBottomLineEnd();

			graphics.drawLine(endLineStart, endLineEnd);
		} finally {
			graphics.popState();
		}
	}

	/**
	 * Paint the arrow between the start line and end line (Typically a vertical arrow)
	 *
	 * @param graphics
	 */
	protected void paintArrow(Graphics graphics) {
		PolylineConnection arrowLine = new PolylineConnection();

		Point arrowStart = getStart().getCopy().setX(getArrowLineX());
		Point arrowEnd = arrowStart.getCopy().setY(getEnd().y());

		arrowLine.setStart(arrowStart);
		arrowLine.setEnd(arrowEnd);

		// FIXME Decorations won't be painted?
		PolylineDecoration source = new PolylineDecoration();
		PolylineDecoration target = new PolylineDecoration();

		source.setForegroundColor(ColorConstants.black);

		source.setLineWidth(1);
		target.setLineWidth(1);

		arrowLine.setSourceDecoration(source);
		arrowLine.setTargetDecoration(target);

		arrowLine.paint(graphics);
	}

	private Point getArrowTop() {
		Rectangle defaultBounds = new Rectangle(getStart(), getEnd());
		return defaultBounds.getTop().getCopy().setX(getArrowLineX());
	}

	private Point getArrowBottom() {
		Rectangle defaultBounds = new Rectangle(getStart(), getEnd());
		return defaultBounds.getBottom().getCopy().setX(getArrowLineX()).translate(0, -1);
	}

	private Point getTopLineEnd() {
		int arrowLinePosition = getArrowLineX();

		Point startLineEnd = getStart().getCopy();
		if (arrowLinePosition > getStart().x()) {
			startLineEnd.setX(arrowLinePosition + ARROW_PADDING);
		} else {
			startLineEnd.setX(arrowLinePosition - ARROW_PADDING);
		}

		return startLineEnd;
	}

	private Point getBottomLineEnd() {
		int arrowLinePosition = getArrowLineX();
		Point endLineEnd = getEnd().getCopy();
		if (arrowLinePosition < getEnd().x()) {
			endLineEnd.setX(arrowLinePosition - ARROW_PADDING);
		} else {
			endLineEnd.setX(arrowLinePosition + ARROW_PADDING);
		}

		return endLineEnd;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Override containsPoint to handle clicks on any of the 3 lines (start, end and arrow line)
	 * </p>
	 */
	@Override
	public boolean containsPoint(int x, int y) {
		Rectangle topLine = new Rectangle(getStart(), getTopLineEnd());
		topLine.expand(SELECTION_TOLERANCE, SELECTION_TOLERANCE);
		if (topLine.contains(x, y)) {
			return true;
		}

		Rectangle bottomLine = new Rectangle(getEnd(), getBottomLineEnd());
		bottomLine.expand(SELECTION_TOLERANCE, SELECTION_TOLERANCE);
		if (bottomLine.contains(x, y)) {
			return true;
		}

		Rectangle arrowLine = new Rectangle(getArrowTop(), getArrowBottom());
		arrowLine.expand(SELECTION_TOLERANCE, SELECTION_TOLERANCE);
		return arrowLine.contains(x, y);
	}

	/**
	 * <p>
	 * By default, the arrow is centered between its start and end point (delta = 0). The position
	 * delta can be used to move it to the right (delta > 0) or to the left (delta < 0).
	 * </p>
	 *
	 * @param delta
	 */
	public void setArrowPositionDelta(int delta) {
		if (delta != this.arrowPositionDelta) {
			this.arrowPositionDelta = delta;
			revalidate();
		}
	}

	@Override
	public Rectangle getBounds() {
		Rectangle bounds = super.getBounds();

		// The arrow may be moved outside of the bounds defined by (start, end).
		// In that case, we need to update the bounds, to make sure we can draw
		// everything
		if (getPoints().size() >= 2) {
			bounds.union(getTopLineEnd());
			bounds.union(getBottomLineEnd());
		}
		return bounds;
	}

	@Override
	public void setConnectionRouter(ConnectionRouter cr) {
		// Skip; this figure doesn't support routers/bendpoints
	}

	/**
	 * <p>
	 * Set the orientation of the arrow (Orientation#VERTICAL or Orientation#HORIZONTAL).
	 * </p>
	 * <p>
	 * By default, the arrow is vertical.
	 * </p>
	 *
	 * @param orientation
	 */
	// TODO Orientation is not supported yet (Bug 536637)
	public void setArrowOrientation(Orientation orientation) {
		this.arrowOrientation = orientation;
	}

	// TODO Orientation is not supported yet (Bug 536637)
	public static enum Orientation {
		VERTICAL, HORIZONTAL;
	}
}
