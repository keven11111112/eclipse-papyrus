/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Vincent Lorenzo(CEA-List) vincent.lorenzo@cea.fr - getCurrentSideOfParent()
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.locator;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.RoundedRectangleNodePlateFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SlidableRoundedRectangleAnchor;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.FigureUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.PortPositionEnum;

/**
 *
 * This class is used to constrain the position of Port when they are added on a Property or a
 * StructuredClassifier.
 *
 * <pre>
 * 	 +-------------------+
 * 	 |    [Class]        |
 * 	 +-------------------+
 * 	 |                   |
 * 	 |                   |
 * 	 |                  +-+ - Expected default position of Port
 * 	 |                  +-+
 * 	 |                   |
 * 	 +-------------------+
 *
 * </pre>
 *
 * <pre>
 * TODO  : The port is not re-sizable
 * </pre>
 */
public class PortPositionLocator implements IBorderItemLocator {

	/** the figure around which this border item appears */
	protected IFigure parentFigure = null;

	String position = PortPositionEnum.INSIDE.toString();

	/** the width of the area surrounding the parent figure where border item can be put */
	protected int borderItemOffset = 10;


	public int getBorderItemOffset() {
		return borderItemOffset;
	}

	public void setBorderItemOffset(int borderItemOffset) {
		this.borderItemOffset = borderItemOffset;
	}

	/**
	 * get the parent figure
	 *
	 * @return the parent figure
	 */
	public IFigure getParentFigure() {
		return parentFigure;
	}

	/** the position constraint */
	protected Rectangle constraint = new Rectangle(0, 0, 0, 0);

	/** the figure */
	private IFigure figure;

	/**
	 * Constructor *.
	 *
	 * @param parentFigure
	 *            the parent figure
	 * @param preferredSide
	 *            the preferred side
	 */
	public PortPositionLocator(IFigure parentFigure, int preferredSide) {
		// The preferredSide parameter is not used, just kept here to ensure compatibility
		// with GMF generated code.
		this.parentFigure = parentFigure;
	}

	/**
	 * Gets the valid location.
	 *
	 * @param proposedLocation
	 *            the proposed location
	 * @param borderItem
	 *            the border item
	 * @return a valid location
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getValidLocation(org.eclipse.draw2d.geometry.Rectangle, org.eclipse.draw2d.IFigure)
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		return getPreferredLocation(proposedLocation);
	}

	/**
	 * Gets the preferred location.
	 *
	 * @param proposedLocation
	 *            the proposed location
	 * @return a possible location on parent figure border
	 */
	public Rectangle getPreferredLocation(Rectangle proposedLocation) {

		// Initialize port location with proposed location
		// and resolve the bounds of it graphical parent

		Rectangle realLocation = new Rectangle(proposedLocation);
		Rectangle parentRec = getParentFigure().getBounds().getCopy();


		// If it's a SVGNodePlate get the anchor to get the position
		if (parentFigure instanceof SVGNodePlateFigure && ((SVGNodePlateFigure) parentFigure).getConnectionAnchor("") instanceof SlidableRoundedRectangleAnchor) {

			// Translate location to absolute before calculate location Point
			parentFigure.translateToAbsolute(proposedLocation);
			parentFigure.translateToAbsolute(parentRec);

			ConnectionAnchor connectionAnchor = ((SVGNodePlateFigure) parentFigure).getConnectionAnchor("");
			// Get the location point, with anchor.

			// get the offset depending of the position of the port (inside, outside or onLine)
			Dimension offset = getPortOffset().getCopy();
			parentFigure.translateToAbsolute(offset);

			((SlidableRoundedRectangleAnchor) connectionAnchor).setOffset(offset);

			Point locationForPort = ((SlidableRoundedRectangleAnchor) connectionAnchor).getLocation(parentRec.getCenter(), proposedLocation.getLocation());
			((SlidableRoundedRectangleAnchor) connectionAnchor).setOffset(new Dimension());
			if (locationForPort != null) {
				proposedLocation.setLocation(locationForPort);
			}

			// Translate to relative the location
			parentFigure.translateToRelative(proposedLocation);
			// Set the location
			realLocation.setLocation(proposedLocation.getLocation());
		} else {

			// Calculate Max position around the graphical parent (1/2 size or the port around
			// the graphical parent bounds.
			int xMin = parentRec.x - borderItemOffset;
			int xMax = parentRec.x - borderItemOffset + parentRec.width;
			int yMin = parentRec.y - borderItemOffset;
			int yMax = parentRec.y - borderItemOffset + parentRec.height;

			// Modify Port location if MAX X or Y are exceeded
			if (realLocation.x < xMin) {
				realLocation.x = xMin;
			}
			if (realLocation.x > xMax) {
				realLocation.x = xMax;
			}
			if (realLocation.y < yMin) {
				realLocation.y = yMin;
			}
			if (realLocation.y > yMax) {
				realLocation.y = yMax;
			}

			final Rectangle maxRect = parentRec.getCopy();
			maxRect.shrink(-borderItemOffset, -borderItemOffset);
			while (maxRect.contains(realLocation.getLocation())) {
				maxRect.shrink(1, 1);
			}
			int pos = maxRect.getPosition(realLocation.getLocation());

			switch (pos) {
			case PositionConstants.NORTH:
				realLocation.y = yMin;
				break;
			case PositionConstants.SOUTH:
				realLocation.y = yMax;
				break;
			case PositionConstants.EAST:
				realLocation.x = xMax;
				break;
			case PositionConstants.WEST:
				realLocation.x = xMin;
				break;
			case PositionConstants.NORTH_EAST:
				realLocation.x = xMax;
				realLocation.y = yMin;
				break;
			case PositionConstants.NORTH_WEST:
				realLocation.x = xMin;
				realLocation.y = yMin;
				break;
			case PositionConstants.SOUTH_EAST:
				realLocation.x = xMax;
				realLocation.y = yMax;
				break;
			case PositionConstants.SOUTH_WEST:
				realLocation.x = xMin;
				realLocation.y = yMax;
				break;
			}
		}
		// Return constrained location
		return realLocation;
	}

	/**
	 * @return
	 */
	private Dimension getPortOffset() {
		Dimension portOffset = new Dimension();
		if (figure != null) {
			if (PortPositionEnum.INSIDE.toString().equals(position)) {
				portOffset.width = -figure.getBounds().width / 2;
				portOffset.height = -figure.getBounds().height / 2;
			} else if (PortPositionEnum.OUTSIDE.toString().equals(position)) {
				portOffset.width = figure.getBounds().width / 2 - 1;
				portOffset.height = figure.getBounds().height / 2 - 1;
			}
			// Else onLine: no offset is applied and the port is on the line.
		}
		return portOffset;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPortPosition(String position) {
		this.position = position;
	}

	/**
	 * @param view
	 *            the view to set
	 * 
	 *            /**
	 *            Gets the current side of parent.
	 *
	 * @return the current side of parent
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getCurrentSideOfParent()
	 *      the position of the port around its parent. This position can be
	 *      <ul>
	 *      <li>{@linkplain PositionConstants#NORTH}</li>
	 *      <li>{@linkplain PositionConstants#SOUTH}</li>
	 *      <li>{@linkplain PositionConstants#EAST}</li>
	 *      <li>{@linkplain PositionConstants#WEST}</li>
	 *      <li>{@linkplain PositionConstants#NORTH_EAST}</li>
	 *      <li>{@linkplain PositionConstants#NORTH_WEST}</li>
	 *      <li>{@linkplain PositionConstants#SOUTH_EAST}</li>
	 *      <li>{@linkplain PositionConstants#SOUTH_WEST}</li>
	 *      </ul>
	 */
	@Override
	public int getCurrentSideOfParent() {
		int defaultSkink =10;
		Rectangle basisRectangle=new Rectangle(0, 0, parentFigure.getBounds().width, (parentFigure.getBounds().height));
		//creation of an internal rectangle in order to compute the position (size divided by 2);
		int skink_width=constraint.width/2;
		int skink_height=constraint.height/2;
		//sometime the size of element in the notation can be negative to explain that he can take the default size code. 
		//The size in this case is inside the draw2D figure but here it is impossible to access to the figure of the port. 
		// in this case , we compute a default internal rectangle minus 10.
		if(skink_width<=0){
			skink_width=defaultSkink;
		}
		if(skink_height<=0){
			skink_height=defaultSkink;
		}
		Rectangle  internalRectangle= basisRectangle.getShrinked(new Insets(skink_height,skink_width, skink_height, skink_width));
		//let draw2D to compute position
		int position=internalRectangle.getPosition(constraint.getTopLeft());
		//use to Debug
		//System.out.println("basisRectangle " +basisRectangle+" internalRectangle"+internalRectangle+ " constraint"+constraint+ " "+position);
		return position;

	}

	/**
	 * Sets the constraint.
	 *
	 * @param constraint
	 *            the new constraint
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#setConstraint(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void setConstraint(Rectangle constraint) {
		this.constraint = constraint;
	}

	public Rectangle getConstraint() {
		return constraint;
	}

	/**
	 * Relocate.
	 *
	 * @param target
	 *            the target
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void relocate(IFigure target) {

		if (figure == null) {
			figure = target;
		}

		Rectangle proposedLocation = constraint.getCopy();
		proposedLocation.setLocation(constraint.getLocation().translate(parentFigure.getBounds().getTopLeft()));

		Point validLocation = getValidLocation(proposedLocation, target).getLocation();
		if (figure instanceof RoundedRectangleNodePlateFigure || FigureUtils.findChildFigureInstance(figure, RoundedRectangleNodePlateFigure.class) != null) {

			Dimension preferredSize = target.getPreferredSize();
			Rectangle rect = new Rectangle(validLocation, preferredSize);
			rect.translate(-preferredSize.width / 2, -preferredSize.height / 2);
			target.setBounds(rect);
		} else {
			target.setBounds(new Rectangle(validLocation, target.getPreferredSize()));
		}
	}
}
