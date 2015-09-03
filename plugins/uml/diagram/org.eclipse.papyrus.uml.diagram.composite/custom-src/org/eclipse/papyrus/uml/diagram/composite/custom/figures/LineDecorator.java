/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite.custom.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;

public class LineDecorator extends Figure {

	private int myLineWidth = 2;

	public void setLineWidth(int lineWidth) {
		myLineWidth = lineWidth;
	}

	public void paint(Graphics graphics) {
		graphics.pushState();
		graphics.setLineWidth(myLineWidth);
		graphics.drawLine(getBounds().getTopLeft(), getBounds().getBottomRight());
		graphics.popState();
	};
}
