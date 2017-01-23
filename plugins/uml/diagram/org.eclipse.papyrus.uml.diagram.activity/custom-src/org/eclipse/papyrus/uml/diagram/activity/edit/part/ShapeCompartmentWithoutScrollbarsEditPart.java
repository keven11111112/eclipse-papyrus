/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.linklf.LinkLFShapeCompartmentEditPart;

public class ShapeCompartmentWithoutScrollbarsEditPart extends LinkLFShapeCompartmentEditPart {

	public ShapeCompartmentWithoutScrollbarsEditPart(View view) {
		super(view);
	}

	/**
	 * remove the bottom border, remove scrollbars
	 */
	@Override
	public IFigure createFigure() {
		return setupNoScrolls((ShapeCompartmentFigure) super.createFigure());
	}

	private IFigure setupNoScrolls(ShapeCompartmentFigure figure) {
		figure.setTitleVisibility(false);
		// remove the top border
		figure.setBorder(null);
		// remove scrollbars
		figure.getScrollPane().setHorizontalScrollBar(null);
		figure.getScrollPane().setVerticalScrollBar(null);
		figure.getScrollPane().setScrollBarVisibility(ScrollPane.NEVER);
		return figure;
	}

}
