/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram Implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.draw2d;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractionFigure.
 * 
 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin</a>
 */
public class InteractionFigure extends Shape {

	/**
	 * Fill shape.
	 * 
	 * @param graphics
	 *            the graphics
	 * 
	 * @see Shape#fillShape(Graphics)
	 */
	@Override
	protected void fillShape(Graphics graphics) {
	}

	/**
	 * Outline shape.
	 * 
	 * @param graphics
	 *            the graphics
	 * 
	 * @see Shape#outlineShape(Graphics)
	 */
	@Override
	protected void outlineShape(Graphics graphics) {

		Rectangle r = getBounds();

		int labelWidth = -1;
		// The interaction figure must contain inside a Label
		List childList = this.getChildren();
		for (Iterator it = childList.iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof WrappingLabel || o instanceof Label || o instanceof WrapLabel) {
				WrappingLabel wLabel = (WrappingLabel) o;
				labelWidth = wLabel.getBounds().width;
			}

		}

		// case the size of the label is 0 or -1 (no label)
		if (labelWidth <= 0)
			labelWidth = r.width / 4;

		PointList points = new PointList();

		Point verticalStart = new Point();
		Point verticalEnd = new Point();
		Point diagonalStart = new Point();
		Point diagonalEnd = new Point();
		Point horizontalStart = new Point();
		Point horizontalEnd = new Point();

		verticalStart.x = r.x + labelWidth + 4;
		verticalStart.y = r.y;
		points.addPoint(verticalStart);

		verticalEnd.x = verticalStart.x;
		verticalEnd.y = verticalStart.y + r.height / 2 + 3;
		points.addPoint(verticalEnd);

		diagonalStart.x = verticalEnd.x;
		diagonalStart.y = verticalEnd.y;
		points.addPoint(diagonalStart);

		diagonalEnd.x = diagonalStart.x - r.height / 2 + 3;
		diagonalEnd.y = r.y + r.height - 1;
		points.addPoint(diagonalEnd);

		horizontalStart.x = diagonalEnd.x;
		horizontalStart.y = diagonalEnd.y;
		points.addPoint(horizontalStart);

		horizontalEnd.x = r.x;
		horizontalEnd.y = horizontalStart.y;
		points.addPoint(horizontalEnd);

		graphics.drawPolyline(points);
	}

}
