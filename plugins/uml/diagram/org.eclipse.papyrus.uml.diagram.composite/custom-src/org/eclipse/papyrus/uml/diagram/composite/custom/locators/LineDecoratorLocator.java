/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.composite.custom.locators;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.composite.custom.figures.BehaviorFigure;
import org.eclipse.papyrus.uml.diagram.composite.custom.figures.PortFigure;

public class LineDecoratorLocator extends BasePortChildLocator {

	public LineDecoratorLocator(PortFigure port) {
		super(port);
	}

	@Override
	public void relocate(IFigure target) {
		Rectangle portBounds = myPort.getBounds();
		
		Point start = portBounds.getCenter();
		Point end = new Point();
		
		switch (getPortSide()) {
		case PositionConstants.WEST:
			start.x = start.x + portBounds.width / 2;
			end.x = start.x + BehaviorFigure.BEHAVIOR_OFFSET;
			end.y = start.y;
			break;
		case PositionConstants.EAST:
			start.x = start.x - portBounds.width / 2;
			end.x = start.x - BehaviorFigure.BEHAVIOR_OFFSET;
			end.y = start.y;
			break;
		case PositionConstants.SOUTH:
			start.y = start.y - portBounds.height / 2;
			end.y = start.y - BehaviorFigure.BEHAVIOR_OFFSET;
			end.x = start.x;
			break;
		case PositionConstants.NORTH:
			start.y = start.y + portBounds.width / 2;
			end.y = start.y + BehaviorFigure.BEHAVIOR_OFFSET;
			end.x = start.x;
			break;
		default:
			break;
		}
		target.setBounds(new Rectangle(start, end));
	}
}
