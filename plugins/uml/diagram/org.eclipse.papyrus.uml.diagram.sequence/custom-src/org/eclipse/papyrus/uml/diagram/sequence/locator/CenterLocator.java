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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.BorderItemContainerFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.locator.AdvancedBorderItemLocator;
import org.eclipse.papyrus.uml.diagram.sequence.figures.DestructionEventFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineDotLineCustomFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;

/**
 * This class is used to place all BorderItem node in the middle of the figure for the X but let the position Y
 *
 */
public class CenterLocator extends AdvancedBorderItemLocator {


	/**
	 * Constructor
	 *
	 * @param parentFigure
	 *            the parent figure
	 * @param location
	 *            ContinuationLocator.TOP or ContinuationLocator.BOTTOM
	 */
	public CenterLocator(IFigure parentFigure, int location) {
		super(parentFigure, location);
	}


	/**
	 * Overrides :
	 * - the destructionEventFigure is always drawn at the end of the figure
	 *
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void relocate(IFigure borderItem) {
		Dimension size = getSize(borderItem);
		//get constraint is relative
		Rectangle rectSuggested = getConstraint();
		rectSuggested.setSize(size);
		//GetValid constraint is absolute
		Rectangle suggestedRectIndiagram=rectSuggested.getCopy();
		suggestedRectIndiagram.x=suggestedRectIndiagram.x+getParentFigure().getBounds().x;
		suggestedRectIndiagram.y=suggestedRectIndiagram.y+getParentFigure().getBounds().y;
		suggestedRectIndiagram=getValidLocation(suggestedRectIndiagram, borderItem);
		borderItem.setBounds(suggestedRectIndiagram.getCopy());
		suggestedRectIndiagram.x=suggestedRectIndiagram.x-getParentFigure().getBounds().x;
		suggestedRectIndiagram.y=suggestedRectIndiagram.y-getParentFigure().getBounds().y;
		setConstraint(suggestedRectIndiagram);
		
	}

	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		proposedLocation.setX(getParentFigure().getBounds().x+getParentFigure().getBounds().width/2-borderItem.getBounds().width()/2);
		
		if( proposedLocation.y-proposedLocation.height/2<=getParentFigure().getBounds().y){
			proposedLocation.setY(getParentFigure().getBounds().y);
		}
		if(proposedLocation.y-proposedLocation.height/2 >= getParentFigure().getBounds().getBottomLeft().y){
			proposedLocation.setY(getParentFigure().getBounds().getBottomLeft().y);				
		}
		
		return super.getValidLocation(proposedLocation, borderItem);
	}
	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator#getConstraint()
	 *
	 * @return
	 */
	@Override
	protected Rectangle getConstraint() {
		// TODO Auto-generated method stub
		return super.getConstraint();
	}
	

}
