/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AffixedNamedElementFigure;


/**
 * Figure for Port representation.
 */
public class PortFigure extends AffixedNamedElementFigure {

	/**
	 * @see org.eclipse.draw2d.Figure#paint(org.eclipse.draw2d.Graphics)
	 *
	 * @param graphics
	 */
	@Override
	public void paint(Graphics graphics) {
		graphics.setClip(new Rectangle(0, 0, 101, 100));
		graphics.drawOval(new Rectangle(0, 0, 101, 100));
		graphics.restoreState();
		super.paint(graphics);
	}



	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#paintBorder(org.eclipse.draw2d.Graphics)
	 *
	 * @param graphics
	 */
	@Override
	protected void paintBorder(Graphics graphics) {
		graphics.drawOval(new Rectangle(0, 0, 101, 100));
		super.paintBorder(graphics);
	}
}
