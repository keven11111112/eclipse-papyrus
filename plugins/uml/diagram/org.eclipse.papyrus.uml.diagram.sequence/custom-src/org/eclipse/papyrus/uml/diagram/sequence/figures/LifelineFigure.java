/*****************************************************************************
 * Copyright (c) 2010 - 2017 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 519408
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RoundedCompartmentFigure;
import org.eclipse.swt.graphics.Color;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class LifelineFigure extends RoundedCompartmentFigure {

	/**
	 * Utility figure to get header. Used for selection bounds.
	 * 
	 * @author Mickael ADAM
	 *
	 */
	public final class LifelineHeaderFigure extends RectangleFigure {
		/**
		 * 
		 * @see org.eclipse.draw2d.RectangleFigure#fillShape(org.eclipse.draw2d.Graphics)
		 */
		@Override
		protected void fillShape(Graphics graphics) {
			// do nothing
		}

		/**
		 * @see org.eclipse.draw2d.RectangleFigure#outlineShape(org.eclipse.draw2d.Graphics)
		 */
		@Override
		protected void outlineShape(Graphics graphics) {
			// do nothing
		}
	}

	protected RectangleFigure lifelineHeaderBoundsFigure;

	@Deprecated
	protected RectangleFigure fFigureExecutionsContainerFigure;
	@Deprecated
	protected LifelineDotLineCustomFigure fFigureLifelineDotLineFigure;

	/**
	 * Constructor.
	 */
	public LifelineFigure() {
		super();
		setLayoutManager(new LifeLineLayoutManager());
		// This line has been used in order to display combinedFragment
		setTransparency(100);
		createContents();
	}

	/**
	 * This method has been used in order to display combinedFragment
	 * 
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#setTransparency(int)
	 */
	@Override
	public void setTransparency(int transparency) {
		super.setTransparency(100);
	}

	/**
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getPolygonPoints()
	 */
	@Override
	public PointList getPolygonPoints() {
		PointList points = new PointList(8);
		points.addPoint(new Point(this.getBounds().x, this.getBounds().y));
		points.addPoint(new Point(this.getBounds().x + this.getBounds().width, this.getBounds().y));
		points.addPoint(new Point(this.getBounds().x + this.getBounds().width, ((LifeLineLayoutManager) this.getLifeLineLayoutManager()).getBottomHeader()));
		points.addPoint(new Point(this.getBounds().x + this.getBounds().width / 2, ((LifeLineLayoutManager) this.getLifeLineLayoutManager()).getBottomHeader()));
		points.addPoint(new Point(this.getBounds().x + this.getBounds().width / 2, this.getBounds().y + this.getBounds().height));
		points.addPoint(new Point(this.getBounds().x + this.getBounds().width / 2, ((LifeLineLayoutManager) this.getLifeLineLayoutManager()).getBottomHeader()));
		points.addPoint(new Point(this.getBounds().x, ((LifeLineLayoutManager) this.getLifeLineLayoutManager()).getBottomHeader()));
		points.addPoint(new Point(this.getBounds().x, this.getBounds().y));
		return points;
	}

	/**
	 * {@inheritDoc}
	 */
	public void paint(Graphics graphics) {
		Rectangle rect = this.getBounds();
		graphics.pushState();
		graphics.setForegroundColor(getForegroundColor());
		// do not forget to set line width to 1, if not the color will
		// change because of the anti-aliasing
		graphics.setLineWidth(1);
		graphics.drawRectangle(rect.x, rect.y, rect.width - 1, ((LifeLineLayoutManager) this.getLifeLineLayoutManager()).getBottomHeader() - rect.y);
		// Draw dash line first to be under child
		graphics.setLineDash(new int[] { 5, 5 });
		graphics.drawLine(new Point(rect.x + rect.width / 2, ((LifeLineLayoutManager) this.getLifeLineLayoutManager()).getBottomHeader()), new Point(rect.x + rect.width / 2, rect.y + rect.height - 1));
		graphics.popState();

		// Then finish to draw figure.
		super.paint(graphics);
	}

	/**
	 * [{@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Figure#getLayoutManager()
	 */
	@Override
	public LayoutManager getLayoutManager() {
		return new XYLayout();
	}

	public LayoutManager getLifeLineLayoutManager() {
		return super.getLayoutManager();
	}

	/**
	 * Paint the label rectangle as background instead of the whole figure
	 *
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#paintBackground(org.eclipse.draw2d.Graphics, org.eclipse.draw2d.geometry.Rectangle)
	 * @param graphics
	 *            graphics tool
	 * @param rectangle
	 *            unused
	 */
	@Override
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		super.paintBackground(graphics, getFigureLifelineNameContainerFigure().getBounds());
	}

	/**
	 * Get the figure on which the border must be drawn.
	 *
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#getBorderedFigure()
	 * @return the rectangle containing labels
	 */
	@Override
	protected IFigure getBorderedFigure() {
		return getFigureLifelineNameContainerFigure();
	}

	/**
	 * Construct the appropriate border
	 *
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#getDefaultBorder(org.eclipse.swt.graphics.Color)
	 * @param borderColor
	 *            the color of the border
	 * @return the border
	 */
	@Override
	protected Border getDefaultBorder(Color borderColor) {
		int margin = getMapMode().DPtoLP(7);
		MarginBorder defaultBorder = new MarginBorder(margin, margin, margin, margin);
		return defaultBorder;
	}

	/**
	 * remove label creation, change layout
	 */
	private void createContents() {
		lifelineHeaderBoundsFigure = new LifelineHeaderFigure();
		this.add(lifelineHeaderBoundsFigure);
	}

	protected IMapMode getMapMode() {
		return MapModeUtil.getMapMode();
	}

	/**
	 * get label from super figure
	 */
	public WrappingLabel getFigureLifelineLabelFigure() {
		return getNameLabel();
	}

	@Deprecated
	public RectangleFigure getFigureLifelineNameContainerFigure() {
		return lifelineHeaderBoundsFigure;
	}

	@Deprecated
	public RectangleFigure getFigureExecutionsContainerFigure() {
		return fFigureExecutionsContainerFigure;
	}

	@Deprecated
	public LifelineDotLineCustomFigure getFigureLifelineDotLineFigure() {
		return fFigureLifelineDotLineFigure;
	}
}
