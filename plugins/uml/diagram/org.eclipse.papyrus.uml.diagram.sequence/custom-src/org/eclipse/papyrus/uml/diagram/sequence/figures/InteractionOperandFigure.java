/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RoundedCompartmentFigure;

public class InteractionOperandFigure extends RoundedCompartmentFigure {

	/**
	 * True if line separator is printed
	 */
	private boolean lineSeparator = true;

	/**
	 * True if this Edit Part is the first Operand of his CombinedFragment's parent
	 */
	private boolean firstOperand = false;

	private WrappingLabel fInteractionConstraintLabel;

	public InteractionOperandFigure() {
		this.setLayoutManager(new XYLayout());
		this.setLineStyle(Graphics.LINE_DASH);
		this.setBorder(null);
		this.setLineSeparator(!firstOperand);
		createContents();
	}

	public WrappingLabel getInteractionConstraintLabel() {
		return fInteractionConstraintLabel;
	}

	@Override
	public void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		if (lineSeparator) {
			graphics.setLineStyle(getLineStyle());
			graphics.setLineWidth(getLineWidth());
			graphics.drawLine(getBounds().getTopLeft(), getBounds().getTopRight());
		}
	}

	/**
	 * Set the line separator
	 *
	 * @param lineSeparator
	 */
	public void setLineSeparator(boolean lineSeparator) {
		this.lineSeparator = lineSeparator;
	}

	private void createContents() {
		IMapMode mapMode = SequenceMapModeUtil.getMapModel(this);
		fInteractionConstraintLabel = new WrappingLabel();
		fInteractionConstraintLabel.setText("");
		this.add(fInteractionConstraintLabel, new Rectangle(10,10,200,20));
	}
}
