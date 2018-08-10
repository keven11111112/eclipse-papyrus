/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.sequence.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * Specific locator for {@link TimeObservation} or {@link TimeConstraint} on exec spec.
 */
public class TimeElementLocator implements IBorderItemLocator {

	private IFigure parentFigure;
	private Rectangle constraint;

	public TimeElementLocator(IFigure parentFigure) {
		this.setParentFigure(parentFigure);
	}

	@Override
	public void setConstraint(Rectangle constraint) {
		this.constraint = constraint;
	}

	private Rectangle getConstraint() {
		return constraint;
	}

	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		Point newTopLeft = locateOnBorder(realLocation, borderItem);
		realLocation.setLocation(newTopLeft);
		return realLocation;
	}

	@Override
	public int getCurrentSideOfParent() {
		if (getConstraint().y() >= 10) {
			return PositionConstants.SOUTH;
		}
		return PositionConstants.NORTH;
	}

	@Override
	public void relocate(IFigure borderItem) {
		Dimension size = getSize(borderItem);
		Rectangle rectSuggested = new Rectangle(
				getPreferredLocation(borderItem), size);

		// Point ptNewLocation = locateOnBorder(rectSuggested, borderItem);
		borderItem.setBounds(rectSuggested);
	}

	protected Point locateOnBorder(Rectangle rectSuggested, IFigure borderItem) {
		int relativeItemLeft = rectSuggested.x;

		int relativeItemTop = 0;

		if (getConstraint().getTopLeft().y() > 0) {
			relativeItemTop = getParentFigure().getBounds().height;
		} else {
			relativeItemTop = 0;
		}
		Point pt = getAbsoluteToBorder(new Point(relativeItemLeft, relativeItemTop));
		return pt;
	}

	protected IFigure getParentFigure() {
		return parentFigure;
	}

	protected void setParentFigure(IFigure parentFigure) {
		this.parentFigure = parentFigure;
	}

	/**
	 * Gets the size of the border item figure.
	 *
	 * @param borderItem
	 *            the figure on border
	 * @return the size of the border item figure.
	 */
	protected final Dimension getSize(IFigure borderItem) {
		Dimension size = getConstraint().getSize();
		if (size.isEmpty()) {
			size = borderItem.getPreferredSize();
		}
		return size;
	}

	protected Point getPreferredLocation(IFigure borderItem) {
		Point constraintLocation = locateOnBorder(getConstraint(), borderItem);
		return constraintLocation;
	}


	/**
	 * Convert the relative coords in the model to ones that are Relative to the
	 * container (absolute in respect to the main figure)
	 *
	 * @param ptRelativeOffset
	 * @return point
	 */
	protected Point getAbsoluteToBorder(Point ptRelativeOffset) {
		Point parentOrigin = getParentBorder().getTopLeft();
		return parentOrigin.translate(ptRelativeOffset);
	}

	/**
	 * Utility to calculate the parent bounds with consideration for the handle
	 * bounds inset.
	 *
	 * @return <code>Rectangle</code> that is the bounds of the parent.
	 */
	protected Rectangle getParentBorder() {
		Rectangle bounds = getParentFigure().getBounds().getCopy();
		if (getParentFigure() instanceof NodeFigure) {
			bounds = ((NodeFigure) getParentFigure()).getHandleBounds()
					.getCopy();
		}
		return bounds;
	}

}
