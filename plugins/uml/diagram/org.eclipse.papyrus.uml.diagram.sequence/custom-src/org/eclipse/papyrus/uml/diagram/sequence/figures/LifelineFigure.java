/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.papyrus.infra.core.sasheditor.editor.SashWindowsEventsProvider.SashWindowsContainerChangedListeners;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RectangularShadowBorder;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RoundedCompartmentFigure;
import org.eclipse.swt.graphics.Color;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class LifelineFigure extends RoundedCompartmentFigure {
	@Deprecated
	protected RectangleFigure fFigureLifelineNameContainerFigure;
	@Deprecated
	protected RectangleFigure fFigureExecutionsContainerFigure;
	@Deprecated
	protected LifelineDotLineCustomFigure fFigureLifelineDotLineFigure;

	/**
	 * Constructor.
	 *
	 */
	public LifelineFigure() {
		super();
		setLayoutManager(new LifeLineLayoutManager());
		// This line has been used in order to display combinedFragment
		setTransparency(100);
	}

	/**
	 * This method has been used in order to display combinedFragment
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
		points.addPoint(new Point(this.getBounds().x+this.getBounds().width, this.getBounds().y));
		points.addPoint(new Point(this.getBounds().x+this.getBounds().width,((LifeLineLayoutManager)this.getLifeLineLayoutManager()).getBottomHeader()));
		points.addPoint(new Point(this.getBounds().x+this.getBounds().width/2,((LifeLineLayoutManager)this.getLifeLineLayoutManager()).getBottomHeader()));
		points.addPoint(new Point(this.getBounds().x+this.getBounds().width/2, this.getBounds().y+this.getBounds().height));
		points.addPoint(new Point(this.getBounds().x+this.getBounds().width/2,((LifeLineLayoutManager)this.getLifeLineLayoutManager()).getBottomHeader()));
		points.addPoint(new Point(this.getBounds().x,((LifeLineLayoutManager)this.getLifeLineLayoutManager()).getBottomHeader()));
		points.addPoint(new Point(this.getBounds().x, this.getBounds().y));
		return points;
	}
	/**
	 * {@inheritDoc}
	 */
	public void paint(Graphics graphics) {
		super.paint(graphics);
		Rectangle rect = this.getBounds();
		graphics.pushState();
		graphics.setForegroundColor(getForegroundColor());
		// do not forget to set line width to 1, if not the color will
		// change because of the anti-aliasing
		graphics.setLineWidth(1);

		//graphics.setLineStyle(Graphics.LINE_DASH);
		graphics.drawRectangle(rect.x,rect.y, rect.width-1,((LifeLineLayoutManager)this.getLifeLineLayoutManager()).getBottomHeader()- rect.y);
		graphics.setLineDash(new int[] { 5, 5 });
		graphics.drawLine(new Point(rect.x + rect.width/2,((LifeLineLayoutManager)this.getLifeLineLayoutManager()).getBottomHeader()), new Point(rect.x + rect.width/2, rect.y + rect.height - 1));
		graphics.popState();
	}

	/**
	 * @see org.eclipse.draw2d.Figure#getLayoutManager()
	 *
	 * @return
	 */
	@Override
	public LayoutManager getLayoutManager() {

		// TODO Auto-generated method stub
		return new XYLayout();
	}

	public LayoutManager getLifeLineLayoutManager() {
		// TODO Auto-generated method stub
		return super.getLayoutManager();
	}
	//	public int getNameContainerPreferredHeight(int wHint) {
	//		return fFigureLifelineNameContainerFigure.getPreferredSize(wHint, -1).height;
	//	}

	//	/**
	//	 * Get the rectangle which contains all labels
	//	 *
	//	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure#getDefaultLabelsContainer()
	//	 * @return lifeline labels rectangle
	//	 */
	//	@Override
	//	protected IFigure getDefaultLabelsContainer() {
	//		return getFigureLifelineNameContainerFigure();
	//	}

	/**
	 * Create the composite structure.
	 *
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#createCompositeFigureStructure()
	 */
	@Override
	protected void createCompositeFigureStructure() {
		super.createCompositeFigureStructure();
		//		BorderLayout layoutThis = new BorderLayout();
		//		this.setLayoutManager(layoutThis);
		//		this.setOpaque(false);
		//		this.setPreferredSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(200)));
		//		createContents();
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
	 * Get layout to display content of properties compartment.
	 *
	 * @return the layout
	 */
	@Override
	protected LayoutManager getPropertiesCompartmentLayout() {
		//		ToolbarLayout layout = new ToolbarLayout(false);
		//		layout.setStretchMinorAxis(true);
		//		return layout;
		return super.getPropertiesCompartmentLayout();
	}

	//	/**
	//	 * Create the name label with width wrap
	//	 *
	//	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure#createNameLabel()
	//	 */
	//	@Override
	//	protected void createNameLabel() {
	//		super.createNameLabel();
	//	}

	/**
	 * remove label creation, change layout
	 */
	private void createContents() {
		//		fFigureLifelineNameContainerFigure = new RectangleFigure() {
		//
		//			@Override
		//			protected void fillShape(Graphics graphics) {
		//				graphics.pushState();
		//				applyTransparency(graphics);
		//				graphics.fillRectangle(getBounds());
		//				graphics.popState();
		//			}
		//		};
		//		// do not fill to enable gradient
		//		fFigureLifelineNameContainerFigure.setFill(false);
		//		fFigureLifelineNameContainerFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7)));
		//		fFigureLifelineNameContainerFigure.setPreferredSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(30)));
		//		//this.add(fFigureLifelineNameContainerFigure, BorderLayout.TOP);
		//		// change layout
		//		ToolbarLayout layout = new ToolbarLayout(false);
		//		layout.setMinorAlignment(OrderedLayout.ALIGN_CENTER);
		//		fFigureLifelineNameContainerFigure.setLayoutManager(layout);
		//		// remove label creation (created by parent figure)
		//		// fFigureLifelineLabelFigure = new WrappingLabel();
		//		//
		//		//
		//		//
		//		//
		//		// fFigureLifelineLabelFigure.setText("<...>");
		//		//
		//		//
		//		//
		//		//
		//		// fFigureLifelineLabelFigure.setTextWrap(true);
		//		//
		//		//
		//		//
		//		//
		//		// fFigureLifelineLabelFigure.setAlignment(PositionConstants.CENTER);
		//		//
		//		//
		//		//
		//		// fFigureLifelineNameContainerFigure.add(fFigureLifelineLabelFigure);
		//		fFigureExecutionsContainerFigure = new RectangleFigure();
		//		fFigureExecutionsContainerFigure.setFill(false);
		//		fFigureExecutionsContainerFigure.setOutline(false);
		//		fFigureExecutionsContainerFigure.setLineWidth(1);
		//		//this.add(fFigureExecutionsContainerFigure, BorderLayout.CENTER);
		//		fFigureExecutionsContainerFigure.setLayoutManager(new StackLayout());
		//		fFigureLifelineDotLineFigure = new LifelineDotLineCustomFigure();
		//		fFigureExecutionsContainerFigure.add(fFigureLifelineDotLineFigure);
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
		return fFigureLifelineNameContainerFigure;
	}
	@Deprecated
	public RectangleFigure getFigureExecutionsContainerFigure() {
		return fFigureExecutionsContainerFigure;
	}
	@Deprecated
	public LifelineDotLineCustomFigure getFigureLifelineDotLineFigure() {
		return fFigureLifelineDotLineFigure;
	}

	@Override
	public void setLineWidth(int w) {
		if (w < 0) {
			return;
		}
		super.setLineWidth(w);
	}

	
}
