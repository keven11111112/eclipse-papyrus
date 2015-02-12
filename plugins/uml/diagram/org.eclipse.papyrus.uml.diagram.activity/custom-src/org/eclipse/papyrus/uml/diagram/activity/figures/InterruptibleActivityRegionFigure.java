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

package org.eclipse.papyrus.uml.diagram.activity.figures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.RoundedRectangleShadowBorder;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AutomaticCompartmentLayoutManager;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.SubCompartmentLayoutManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

/**
 * This figure handles a rounded dashed rectangle Papyrus node, with no
 * displayed label.
 *
 * @author madam
 */
public class InterruptibleActivityRegionFigure extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure, IFigure, IRoundedRectangleFigure {

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
	public InterruptibleActivityRegionFigure() {
		this(null, null);
	}

	/**
	 * Constructor.
	 *
	 * @param compartmentFigure
	 *            the compartment figure
	 */
	public InterruptibleActivityRegionFigure(List<String> compartmentFigure) {
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
	public InterruptibleActivityRegionFigure(List<String> compartmentFigure, String taggedLabelValue) {
		super();
		setOpaque(false);
		shadowborder = new RoundedRectangleShadowBorder(getForegroundColor(), cornerDimension);
		setLayoutManager(new AutomaticCompartmentLayoutManager());
		if (compartmentFigure != null) {
			createContentPane(compartmentFigure);
		}
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
		shadowborder.setColor(getForegroundColor());
		graphics.pushState();
		Rectangle rectangle = getBounds().getCopy();

		refreshCornerSizeWhenOval();

		applyTransparency(graphics);
		if (isUsingGradient()) {
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;

			Point startGradientPoint = rectangle.getTopLeft();
			Point endGradientPoint = rectangle.getBottomRight();

			// Place start and end point according to isVertical.
			if (isVertical) {
				startGradientPoint.x = rectangle.getTopLeft().x + rectangle.width() / 2;
				endGradientPoint.x = startGradientPoint.x;
			} else {
				startGradientPoint.y = rectangle.getTopLeft().y + rectangle.height() / 2;
				endGradientPoint.y = startGradientPoint.y;
			}

			// Take zoom into account
			double scale = FigureUtils.getScale(this);
			startGradientPoint.scale(scale);
			endGradientPoint.scale(scale);

			// get alpha with convert transparency from 0 -> 100 to 255 -> 0
			int alpha = (int) ((255.0 / 100.0) * (100.0 - getTransparency()));

			// create pattern to display
			Pattern pattern = new Pattern(Display.getCurrent(), startGradientPoint.x,
					startGradientPoint.y, endGradientPoint.x, endGradientPoint.y,
					ColorRegistry.getInstance().getColor(getGradientColor2()), alpha,
					ColorRegistry.getInstance().getColor(getGradientColor1()), alpha);

			graphics.setBackgroundPattern(pattern);
			graphics.fillRoundRectangle(rectangle, cornerDimension.width, cornerDimension.height);
			graphics.setBackgroundPattern(null);
			pattern.dispose();

		} else {
			graphics.pushState();
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getForegroundColor());
			graphics.fillRoundRectangle(rectangle, cornerDimension.width, cornerDimension.height);
			graphics.popState();
		}
		graphics.popState();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#setShadow(boolean)
	 *
	 * @param shadow
	 */
	@Override
	public void setShadow(boolean shadow) {
		super.setShadow(shadow);
		if (!shadow) {
			// If shadow is set to false we set the border
			if (getBorder() != null) {

				refreshCornerSizeWhenOval();

				RoundedRectangleBorder border = new RoundedRectangleBorder(cornerDimension.width, cornerDimension.height);
				border.setWidth(getLineWidth());
				border.setStyle(borderStyle);
				this.setBorder(border);
			}
		}
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

	@Override
	public void setOval(boolean booleanValue) {
		isOval = booleanValue;
		if (booleanValue) {
			refreshCornerSizeWhenOval();
		}
	}

	@Override
	public boolean isOval() {
		return isOval;
	}

	@Override
	public void setFloatingNameConstrained(boolean booleanValue) {
		isLabelConstrained = booleanValue;
	}

	@Override
	public boolean isFloatingNameConstrained() {
		return isLabelConstrained;
	}

	@Override
	public void setFloatingNameOffset(Dimension offset) {
		this.floatingNameOffset = offset;

	}

	@Override
	public Dimension getFloatingNameOffset() {
		return floatingNameOffset;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String, org.eclipse.swt.graphics.Image)
	 *
	 * @param stereotypes
	 * @param image
	 */
	@Override
	public void setStereotypeDisplay(String stereotypes, Image image) {

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#setStereotypePropertiesInBrace(java.lang.String)
	 *
	 * @param stereotypeProperties
	 */
	@Override
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#setStereotypePropertiesInCompartment(java.lang.String)
	 *
	 * @param stereotypeProperties
	 */
	@Override
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#getStereotypesLabel()
	 *
	 * @return
	 */
	@Override
	public PapyrusWrappingLabel getStereotypesLabel() {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#setHasHeader(boolean)
	 *
	 * @param hasHeader
	 */
	@Override
	public void setHasHeader(boolean hasHeader) {

	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#hasHeader()
	 *
	 * @return
	 */
	@Override
	public boolean hasHeader() {
		return false;
	}


	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#getPackageHeader()
	 *
	 * @return
	 */
	@Override
	public Rectangle getPackageHeader() {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#setShadowWidth(int)
	 *
	 * @param shadowWidth
	 */
	@Override
	public void setShadowWidth(int shadowWidth) {

	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IRoundedRectangleFigure#setIsPackage(boolean)
	 *
	 * @param isPackage
	 */
	@Override
	public void setIsPackage(boolean isPackage) {

	}

}
