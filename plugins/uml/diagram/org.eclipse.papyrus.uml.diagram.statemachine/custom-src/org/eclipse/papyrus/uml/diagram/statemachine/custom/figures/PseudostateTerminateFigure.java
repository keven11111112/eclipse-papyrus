/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * PseudostateTerminateFigure.
 *
 */
public class PseudostateTerminateFigure extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Border getDefaultBorder(Color borderColor) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		return new Dimension(20, 20);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Label getStereotypesLabel() {
		return new Label();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		graphics.setForegroundColor(getForegroundColor());
		Rectangle r = getBounds().getCopy().shrink(new Insets(0, 0, 1, 1));
		if (isUsingGradient()) {
			graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
			// graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
		} else {
			graphics.setBackgroundColor(getBackgroundColor());
			// graphics.setForegroundColor(getForegroundColor());
		}
		graphics.setLineWidth(1);
		// intersection coordinates.
		int x = (int) (r.width / (2 * Math.sqrt(2)));
		int y = (int) (r.height / (2 * Math.sqrt(2)));
		// cross.
		graphics.drawLine(r.getCenter().translate(x, -y), r.getCenter().translate(-x, y));
		graphics.drawLine(r.getCenter().translate(-x, -y), r.getCenter().translate(x, y));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStereotypeDisplay(String stereotypes, Image image) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
	}
}
