/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.e4.ui.css.core.css2.CSS2ColorHelper;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SlidableRoundedRectangleAnchor;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.FigureUtils;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.w3c.dom.css.RGBColor;

/**
 * A rectangular figure that supports compartment.
 */
public class RoundedCompartmentFigure extends NodeNamedElementFigure implements IRoundedRectangleFigure {

	/** The container figures. */
	private Map<String, RectangleFigure> containerFigures;

	/** The corner dimension. */
	protected Dimension cornerDimension = new Dimension();

	/** True if the figure is oval. */
	protected boolean isOval = false;

	/** The is label constrained. */
	protected boolean isLabelConstrained = false;

	/** The floating name offset. */
	protected Dimension floatingNameOffset = new Dimension();

	/** The border style. */
	protected int borderStyle = Graphics.LINE_SOLID;

	/** True if the figure has header. */
	private boolean hasHeader = false;

	/** The cached border. */
	private Border cachedBorder;

	/** The cached transparency. */
	private int cachedTransparency;

	/** The shadow width. */
	private int shadowWidth = 4;

	/** The shadow color. */
	String shadowColor = null;

	/**
	 * Gets the shadow color.
	 *
	 * @return the shadowColor
	 */
	public String getShadowColor() {
		return shadowColor;
	}

	/**
	 * Sets the shadow color.
	 *
	 * @param shadowColor
	 *            the shadowColor to set
	 */
	public void setShadowColor(String shadowColor) {
		this.shadowColor = shadowColor;
	}

	/**
	 * @param borderStyle
	 *            the borderStyle to set
	 */
	@Override
	public void setBorderStyle(int borderStyle) {
		this.borderStyle = borderStyle;
		if (shadowborder != null) {
			shadowborder.setStyle(borderStyle);
		}
	}

	/**
	 * Instantiates a new rounded compartment figure.
	 */
	public RoundedCompartmentFigure() {
		this(null, null);
	}

	/**
	 * Constructor.
	 *
	 * @param compartmentFigure
	 *            the compartment figure
	 */
	public RoundedCompartmentFigure(List<String> compartmentFigure) {
		this(compartmentFigure, null);
	}

	/**
	 * Constructor with a tagged value.
	 * 
	 * @param compartmentFigure
	 *            a list of id for the compartment figure
	 * @param taggedLabelValue
	 *            the value to display as tagged value
	 */
	public RoundedCompartmentFigure(List<String> compartmentFigure, String taggedLabelValue) {
		super(taggedLabelValue);
		setOpaque(false);
		setLayoutManager(new AutomaticCompartmentLayoutManager());
		if (compartmentFigure != null) {
			createContentPane(compartmentFigure);
		}
	}

	/**
	 * @param shadowWidth
	 *            the shadowWidth to set
	 */
	public void setShadowWidth(int shadowWidth) {
		this.shadowWidth = shadowWidth;
	}

	/**
	 * @param isPackage
	 *            the isPackage to set
	 */
	public void setIsPackage(boolean isPackage) {
		this.isPackage = isPackage;
	}

	/**
	 * Creates the content pane.
	 *
	 * @param compartmentFigure
	 *            the compartment figure
	 */
	protected void createContentPane(List<String> compartmentFigure) {
		containerFigures = new HashMap<String, RectangleFigure>();
		for (String id : compartmentFigure) {
			RectangleFigure newFigure = new RectangleFigure();
			newFigure.setLayoutManager(new SubCompartmentLayoutManager());
			// to debug graphically: newFigure.setFill(true);
			newFigure.setFill(false);
			newFigure.setBorder(null);
			newFigure.setOutline(false);
			newFigure.setOpaque(false);
			this.add(newFigure);
			containerFigures.put(id, newFigure);
		}
	}

	/**
	 * Get the RectangleFigure containing the wanted compartment.
	 * 
	 * @param id
	 *            the id to find the right compartment
	 * @return the RectangleFigure
	 */
	public RectangleFigure getCompartment(String id) {
		return containerFigures.get(id);
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#getCornerDimensions()
	 *
	 * @return
	 */
	@Override
	public Dimension getCornerDimensions() {
		return cornerDimension;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#getRoundedRectangleBounds()
	 *
	 * @return
	 */
	@Override
	public Rectangle getRoundedRectangleBounds() {
		return getBounds();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void paintFigure(Graphics graphics) {

		graphics.pushState();
		Rectangle rectangle = getBounds().getCopy();
		Rectangle clipRectangle = getBounds().getCopy();
		refreshCornerSizeWhenOval();

		applyTransparency(graphics);

		// in case of package polygon
		if (isPackage) {
			SVGNodePlateFigure mainFigure = FigureUtils.findParentFigureInstance(this, SVGNodePlateFigure.class);
			// Get the connection anchor
			ConnectionAnchor connectionAnchor = ((SVGNodePlateFigure) mainFigure).getConnectionAnchor("");

			if (connectionAnchor instanceof SlidableRoundedRectangleAnchor) {

				// get the polygon points with the Anchor.
				PointList polygonPoints = ((SlidableRoundedRectangleAnchor) connectionAnchor).getPolygonPoints();
				this.translateToRelative(polygonPoints);

				// setClip
				graphics.getClip(clipRectangle);
				graphics.setClip(clipRectangle.expand(1, 1));

				// Draw shadow
				if (isShadow()) {
					// Set the transparency for shadow
					setShadowTransparency(graphics, true);

					polygonPoints.translate(shadowWidth, shadowWidth);

					// expand clip for draw shadow
					clipRectangle.width += shadowWidth;
					clipRectangle.height += shadowWidth;

					graphics.setClip(clipRectangle);

					// set the background color
					setShadowBackgroundColor(graphics);

					// Draw the shadow
					graphics.fillPolygon(polygonPoints);

					// reposition clip
					polygonPoints.translate(-shadowWidth, -shadowWidth);
					clipRectangle.width -= shadowWidth;
					clipRectangle.height -= shadowWidth;
					graphics.setClip(clipRectangle);

					// Reset the transparency for shadow
					setShadowTransparency(graphics, false);
				}

				// Fill figure
				if (isUsingGradient()) {

					fillPolygonWithGradient(graphics, polygonPoints);

				} else {
					graphics.fillPolygon(polygonPoints);
				}

				graphics.setLineWidth(getLineWidth());
				// set the lineStyle: not compatible with custom style
				graphics.setLineStyle(borderStyle);

				// border draw trough graphics
				if (cachedBorder == null) {
					cachedBorder = getBorder();
				}

				// no used of the border of figure
				if (getBorder() != null) {
					setBorder(null);
				}

				// Draw lines
				graphics.drawPolyline(polygonPoints);
			}

		} else {

			// Retrieve the border when was be set to null for package
			if (cachedBorder != null) {
				setBorder(cachedBorder);
				cachedBorder = null;
			}

			// Draw shadow
			if (isShadow()) {

				// Set the transparency for shadow
				setShadowTransparency(graphics, true);

				rectangle.translate(shadowWidth, shadowWidth);

				// expand clip for draw shadow
				graphics.getClip(clipRectangle);
				clipRectangle.width += shadowWidth;
				clipRectangle.height += shadowWidth;
				graphics.setClip(clipRectangle);

				// set the background color
				setShadowBackgroundColor(graphics);

				// draw the shadow
				graphics.fillRoundRectangle(rectangle, cornerDimension.width, cornerDimension.height);

				rectangle.translate(-shadowWidth, -shadowWidth);

				// reposition clip
				clipRectangle.width -= shadowWidth;
				clipRectangle.height -= shadowWidth;
				graphics.setClip(clipRectangle);

				// Reset the transparency for shadow
				setShadowTransparency(graphics, false);
			}

			if (isUsingGradient()) {
				fillRoundedRectangleWithGradient(graphics, rectangle, cornerDimension.width, cornerDimension.height);
			} else {
				graphics.pushState();
				graphics.setBackgroundColor(getBackgroundColor());
				graphics.setForegroundColor(getForegroundColor());
				graphics.fillRoundRectangle(rectangle, cornerDimension.width, cornerDimension.height);
				graphics.popState();
			}

			// Draw header if needed
			if (hasHeader) {
				graphics.drawPolyline(getHeader());
			}
		}
		graphics.popState();
	}

	/**
	 * Fill polygon with gradient.
	 *
	 * @param graphics
	 *            the graphics
	 * @param polygonPoints
	 *            the polygon points
	 */
	protected void fillPolygonWithGradient(final Graphics graphics, final PointList polygonPoints) {
		graphics.pushState();

		Path path = new Path(null);
		path.moveTo(polygonPoints.getPoint(0).x, polygonPoints.getPoint(0).y);
		for (int i = 1; i < polygonPoints.size(); i++) {
			path.lineTo(polygonPoints.getPoint(i).x, polygonPoints.getPoint(i).y);
		}
		path.close();
		graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
		graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
		graphics.clipPath(path);
		graphics.fillGradient(getBounds(), getGradientStyle() == 0);
		path.dispose();

		graphics.popState();
	}


	/**
	 * Fill rounded rectangle with gradient.
	 *
	 * @param graphics
	 *            the graphics
	 * @param rect
	 *            the rectangle
	 * @param arcWidth
	 *            the arc width
	 * @param arcHeight
	 *            the arc height
	 */
	protected void fillRoundedRectangleWithGradient(final Graphics graphics, final Rectangle rectangle, final int arcWidths, final int arcHeights) {
		graphics.pushState();
		Rectangle rect = rectangle.getCopy();
		Dimension arc = new Dimension(arcWidths, arcHeights);

		rect.setWidth(rect.width - 1);
		rect.setHeight(rect.height - 1);
		Path path = new Path(null);

		if (isOval) {
			arc.width = rect.width;
			arc.height = rect.height;
		} else {
			if (rect.width < arc.width) {
				arc.width = rect.width;
			}
			if (rect.height < arc.height) {
				arc.height = rect.height;
			}
		}

		path.moveTo(rect.x + arc.width / 2, rect.y);
		path.lineTo(rect.x + rect.width - arc.width / 2, rect.y);
		path.addArc(rect.x + rect.width - arc.width, rect.y, arc.width, arc.height, 90, -90);
		path.lineTo(rect.x + rect.width, rect.y + rect.height - arc.height / 2);
		path.addArc(rect.x + rect.width - arc.width, rect.y + rect.height - arc.height, arc.width, arc.height, 0, -90);
		path.lineTo(rect.x + arc.width / 2, rect.y + rect.height);
		path.addArc(rect.x, rect.y + rect.height - arc.height, arc.width, arc.height, -90, -90);
		path.lineTo(rect.x, rect.y + arc.height / 2);
		path.addArc(rect.x, rect.y, arc.width, arc.height, 180, -90);

		graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
		graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));

		graphics.clipPath(path);

		graphics.fillGradient(getBounds(), getGradientStyle() == 0);

		path.dispose();

		graphics.popState();
	}


	/**
	 * Sets the shadow backgroud color.
	 *
	 * @param graphics
	 *            the new shadow backgroud color
	 */
	private void setShadowBackgroundColor(Graphics graphics) {

		if (shadowColor != null) {
			// get the the RGBColor from string
			RGBColor rgbColor = CSS2ColorHelper.getRGBColor(shadowColor);

			// extract RGB
			int red = Integer.parseInt(rgbColor.getRed().toString());
			int green = Integer.parseInt(rgbColor.getGreen().toString());
			int blue = Integer.parseInt(rgbColor.getBlue().toString());

			// get the the Color from RGB
			Color color = new Color(Display.getCurrent(), new RGB(red, green, blue));
			graphics.setBackgroundColor(color);
		} else {
			graphics.setBackgroundColor(getForegroundColor());
		}
	}

	/**
	 * Sets the shadow transparency.
	 *
	 * @param graphics
	 *            the graphics
	 * @param toApplied
	 *            the to applied
	 */
	private void setShadowTransparency(final Graphics graphics, final boolean toApplied) {
		// Set transparency to be used for the shadow
		if (toApplied) {
			cachedTransparency = getTransparency();
			// Set Shadow transparency
			int transparency = cachedTransparency + (100 - cachedTransparency) / 2;
			if (transparency > 100) {
				transparency = 100;
			}
			setTransparency((int) (transparency));
			applyTransparency(graphics);
		} else {
			// Reset Shadow transparency
			setTransparency(cachedTransparency);
			applyTransparency(graphics);
		}
	}


	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#setShadow(boolean)
	 *
	 * @param shadow
	 */
	@Override
	public void setShadow(boolean shadow) {
		super.setShadow(shadow);

		refreshCornerSizeWhenOval();

		RoundedRectangleBorder border = new RoundedRectangleBorder(cornerDimension.width, cornerDimension.height) {
			/**
			 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder#paint(org.eclipse.draw2d.IFigure, org.eclipse.draw2d.Graphics, org.eclipse.draw2d.geometry.Insets)
			 *
			 * @param figure
			 * @param graphics
			 * @param insets
			 */
			@Override
			public void paint(IFigure figure, Graphics graphics, Insets insets) {
				int transparency = 255 - ((NodeFigure) figure).getTransparency() * 255 / 100;
				graphics.setAlpha(transparency);
				super.paint(figure, graphics, insets);
			}
		};

		border.setWidth(getLineWidth());
		border.setStyle(borderStyle);
		setBorder(border);
		setLineStyle(borderStyle);
	}

	/**
	 * Refresh corner size when oval.
	 */
	private void refreshCornerSizeWhenOval() {
		// Set the corner dimension if is oval in case of resizing
		if (isOval) {
			if (cornerDimension.width != getBounds().width || cornerDimension.height != getBounds().height) {
				cornerDimension.width = getBounds().width;
				cornerDimension.height = getBounds().height;
				// Force to repaint the border thought setShadow()
				setShadow(isShadow());
			}
		}
	}

	/**
	 * Sets the corner dimension.
	 *
	 * @param cornerDimension
	 *            the new corner dimension
	 */
	@Override
	public void setCornerDimensions(Dimension cornerDimension) {
		this.cornerDimension = cornerDimension;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#setOval(boolean)
	 *
	 * @param booleanValue
	 */
	@Override
	public void setOval(boolean booleanValue) {
		isOval = booleanValue;
		if (booleanValue) {
			refreshCornerSizeWhenOval();
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#isOval()
	 *
	 * @return
	 */
	@Override
	public boolean isOval() {
		return isOval;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#setFloatingNameConstrained(boolean)
	 *
	 * @param booleanValue
	 */
	@Override
	public void setFloatingNameConstrained(boolean booleanValue) {
		isLabelConstrained = booleanValue;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#isFloatingNameConstrained()
	 *
	 * @return
	 */
	@Override
	public boolean isFloatingNameConstrained() {
		return isLabelConstrained;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#setFloatingNameOffset(org.eclipse.draw2d.geometry.Dimension)
	 *
	 * @param offset
	 */
	@Override
	public void setFloatingNameOffset(Dimension offset) {
		this.floatingNameOffset = offset;

	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#getFloatingNameOffset()
	 *
	 * @return
	 */
	@Override
	public Dimension getFloatingNameOffset() {
		return floatingNameOffset;
	}


	/**
	 * @return the point list to draw an header. its width is set to the width of the name and it's position to the left.
	 */
	protected PointList getHeader() {

		Rectangle labelBounds = nameLabel.getBounds().getCopy();
		PointList points = new PointList();

		int labelWidth = -1;
		labelWidth = Math.max(labelWidth, nameLabel.getPreferredSize().width);

		// case the size of the label is 0 or -1 (no label)
		if (labelWidth <= 0) {
			labelWidth = getBounds().width / 4;
		}

		Point verticalStart = new Point();
		Point verticalEnd = new Point();
		Point diagonalStart = new Point();
		Point diagonalEnd = new Point();
		Point horizontalStart = new Point();
		Point horizontalEnd = new Point();

		verticalStart.x = labelBounds.x + labelWidth + 4;
		verticalStart.y = getBounds().y; // labelBounds.y;
		points.addPoint(verticalStart);

		verticalEnd.x = verticalStart.x;
		verticalEnd.y = verticalStart.y + labelBounds.height / 2 + 3;
		points.addPoint(verticalEnd);

		diagonalStart.x = verticalEnd.x;
		diagonalStart.y = verticalEnd.y;
		points.addPoint(diagonalStart);

		diagonalEnd.x = diagonalStart.x - labelBounds.height / 2 + 3;
		diagonalEnd.y = labelBounds.y + labelBounds.height - 1;
		points.addPoint(diagonalEnd);

		horizontalStart.x = diagonalEnd.x;
		horizontalStart.y = diagonalEnd.y;
		points.addPoint(horizontalStart);

		horizontalEnd.x = labelBounds.x;
		horizontalEnd.y = horizontalStart.y;
		points.addPoint(horizontalEnd);
		return points;
	}

	/** set to true to define the figure as a package. */
	private boolean isPackage = false;

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#getPackageHeader()
	 *
	 * @return
	 */
	public Rectangle getPackageHeader() {
		Rectangle headerBound = new Rectangle();
		if (isPackage) {

			ResizableCompartmentFigure firstCompartment = FigureUtils.findChildFigureInstance(this, ResizableCompartmentFigure.class);
			if (firstCompartment != null) {
				int labelWidth = 60;
				labelWidth = Math.max(labelWidth, nameLabel.getPreferredSize().width);
				if (stereotypesLabel != null) {
					labelWidth = Math.max(labelWidth, stereotypesLabel.getPreferredSize().width);
				}

				// If the width of the figure is < to the label width
				labelWidth = Math.min(labelWidth, getBounds().width);

				headerBound.x = getBounds().x;
				headerBound.y = getBounds().y;
				headerBound.height = firstCompartment.getBounds().y - getBounds().y;
				headerBound.width = labelWidth;
			} else {
				headerBound = nameLabel.getBounds().getCopy();
			}
		}

		return headerBound;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#setHasHeader(boolean)
	 *
	 * @param hasHeader
	 */
	@Override
	public void setHasHeader(boolean hasHeader) {
		this.hasHeader = hasHeader;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#hasHeader()
	 *
	 * @return
	 */
	@Override
	public boolean hasHeader() {
		return hasHeader;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure#add(org.eclipse.draw2d.IFigure, java.lang.Object, int)
	 *
	 * @param figure
	 * @param constraint
	 * @param index
	 */
	@Override
	public void add(IFigure figure, Object constraint, int index) {
		// TODO Auto-generated method stub
//		if(figure instanceof ResizableCompartmentFigure){
//			System.err.println("Detection d'ajout de Compartiment dans Compartiment");
//			RectangleFigure rectFigure= new RectangleFigure();
//			rectFigure.add(figure);
//			rectFigure.setLayoutManager(new SubCompartmentLayoutManager());
//			super.add(rectFigure, constraint, index);
//		}else{
		
			super.add(figure, constraint, index);
//		}
	}
}
