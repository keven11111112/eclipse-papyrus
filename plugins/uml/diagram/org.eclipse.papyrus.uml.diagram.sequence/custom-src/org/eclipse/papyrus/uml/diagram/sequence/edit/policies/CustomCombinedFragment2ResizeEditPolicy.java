/*****************************************************************************
+ * Copyright (c) 2009 CEA
+ *
+ *    
+ * All rights reserved. This program and the accompanying materials
+ * are made available under the terms of the Eclipse Public License v1.0
+ * which accompanies this distribution, and is available at
+ * http://www.eclipse.org/legal/epl-v10.html
+ *
+ * Contributors:
+ *   CEA LIST - Initial API and implementation
+ *   Alex Paperno - bug 455080
+ *
+ *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.OLDLifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.HighlightUtil;

public class CustomCombinedFragment2ResizeEditPolicy extends ResizableShapeEditPolicy {

 	public CustomCombinedFragment2ResizeEditPolicy() {
		setResizeDirections(PositionConstants.SOUTH | PositionConstants.NORTH);
 	}

 	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		OLDLifelineEditPart lifelineEP = (OLDLifelineEditPart) getHost().getParent();
		request.getMoveDelta().x = 0; // reset offset
		request.getSizeDelta().width = 0; // reset offset
		IFigure feedback = getDragSourceFeedbackFigure();
		PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		IFigure f = getHostFigure();
		Dimension min = f.getMinimumSize().getCopy();
		Dimension max = f.getMaximumSize().getCopy();
		IMapMode mmode = MapModeUtil.getMapMode(f);
		min.height = mmode.LPtoDP(min.height);
		min.width = mmode.LPtoDP(min.width);
		max.height = mmode.LPtoDP(max.height);
		max.width = mmode.LPtoDP(max.width);
		Rectangle originalBounds = rect.getCopy();
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());
		rect.width = Math.min(Math.max(rect.width, min.width), max.width);
		rect.height = Math.min(Math.max(rect.height, min.height), max.height);
		if (rect.height == min.height && request.getSizeDelta().height < 0 && request.getMoveDelta().y > 0) { // can't shrink at north
			Point loc = rect.getLocation();
			loc.y = originalBounds.getBottom().y - min.height;
			rect.setLocation(loc);
			request.getSizeDelta().height = min.height - originalBounds.height;
			request.getMoveDelta().y = loc.y - originalBounds.y;
		}
		if (rect.height == min.height && request.getSizeDelta().height < 0 && request.getMoveDelta().y == 0) { // can't shrink at south
			request.getSizeDelta().height = min.height - originalBounds.height;
		}
		// Bound to dotline top
		IFigure dotlineFigure = ((LifelineFigure)lifelineEP.getPrimaryShape()).getFigureLifelineDotLineFigure();
		Rectangle rectParent = dotlineFigure.getBounds().getCopy();
		lifelineEP.getPrimaryShape().translateToAbsolute(rectParent);
		int minLifelineY = rectParent.y + OLDLifelineXYLayoutEditPolicy.SPACING_HEIGHT;
		if (rect.y < minLifelineY) {
			request.getMoveDelta().y += minLifelineY - rect.y;
			rect.y = minLifelineY;
		}
		feedback.translateToRelative(rect);
		feedback.setBounds(rect);
	}

	@Override
	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		super.eraseChangeBoundsFeedback(request);
		HighlightUtil.unhighlight();
	}
}
