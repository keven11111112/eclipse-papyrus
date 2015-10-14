/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.diagram.common.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.bpmn.diagram.common.figures.ActivityHorizontalPartitionFigure;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.CustomActivityPartitionEditPart;


public class LaneEditPart extends CustomActivityPartitionEditPart {

	private ActivityHorizontalPartitionFigure laneFigure;

	public LaneEditPart(View view) {
		super(view);
	}

	@Override
	protected IFigure createNodeShape() {
		laneFigure = new ActivityHorizontalPartitionFigure();
		return primaryShape = laneFigure;

	}
	
	@Override
	protected void refreshLabelDisplay() {
		laneFigure.getVerticalLabel().setText(getNamedElement().getName());;
	}
}
