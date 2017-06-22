/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.figure.edge;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;

/**
 * {@link PapyrusEdgeFigure} for references.
 * 
 * @author Mickael ADAM
 * @since 3.1
 */
public final class ReferenceEdgeFigure extends PapyrusEdgeFigure {

	/**
	 * Creates a new DashEdgeFigure.
	 */
	public ReferenceEdgeFigure() {
		super();
		setArrow(true);
		setupDefaultStyle();
		createContents();
	}

	/**
	 * Dashes used to paint line.
	 */
	private final int[] dashes = new int[10];
	/**
	 * use to if the arrow will be displayed
	 */
	protected boolean arrow = false;

	/**
	 * The name label.
	 */
	private WrappingLabel nameLabel;

	/**
	 * Get the name label.
	 */
	public WrappingLabel getEdgeLabel() {
		return nameLabel;
	}

	/**
	 * use to display the arrow of the edge
	 *
	 * @param arrow
	 *            true if the arrow will be displayed
	 */
	public void setArrow(final Boolean arrow) {
		this.arrow = arrow;
	}

	/**
	 * Create the content.
	 */
	protected void createContents() {
		nameLabel = new PapyrusWrappingLabel();
		nameLabel.setText("");//$NON-NLS-1$
		this.add(nameLabel);
	}

	/**
	 * Resets the style of this figure to its default implementation
	 */
	@Override
	public void resetStyle() {
		setupDefaultStyle();
	}

	/**
	 * Sets initial Style for the figure. It does not give any special Color for
	 * Background and Foreground. This is the style used for classic arrows:
	 * ------>
	 * This method should not be overridden as it defines the default style for the arrow.
	 * Instead, custom styles should be defined by overriding the resetStyle method.
	 */
	protected final void setupDefaultStyle() {
		if (arrow) {
			PolylineDecoration dec = new PolylineDecoration();
			dec.setScale(15, 5);
			dec.setLineWidth(1);
			this.setTargetDecoration(dec);
		} else {
			this.setTargetDecoration(null);
		} // arrow at target endpoint
		this.setLineStyle(Graphics.LINE_CUSTOM); // line drawing style

		// set dashes
		for (int i = 0; i < 10; i++) {
			dashes[i] = 5;
		}
		setLineDash(dashes);
	}
}