/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Céline JANSSENS (All4tec.net) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Céline JANSSENS
 *
 */
public class StateInvariantLocator extends CenterLocator {

	public StateInvariantLocator(IFigure parentFigure, int location) {
		super(parentFigure, location);
	}

	@Override
	public void relocate(IFigure borderItem) {
		Point constraintLocation = getConstraint().getLocation();
		Dimension size = getSize(borderItem);
		Point ptNewLocation = new Point(getParentBorder().getCenter().x - size.width / 2, constraintLocation.y);
		borderItem.setBounds(new Rectangle(ptNewLocation, size));
	}

	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		Point point = new Point(getParentBorder().getCenter().x - realLocation.getSize().width / 2, realLocation.y);
		realLocation.setLocation(point);
		return realLocation;
	}
}
