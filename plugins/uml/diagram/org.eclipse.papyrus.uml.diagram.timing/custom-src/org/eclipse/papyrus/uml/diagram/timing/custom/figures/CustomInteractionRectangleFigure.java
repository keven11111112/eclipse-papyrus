/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.draw2d.InteractionFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LeftToolbarLayout;
import org.eclipse.papyrus.uml.diagram.common.figure.node.InteractionRectangleFigure;

public class CustomInteractionRectangleFigure extends InteractionRectangleFigure {

	private RectangleFigure timeRulerCompartment;

	public CustomInteractionRectangleFigure() {
		setLayoutManager(new ToolbarLayout());
	}

	@Override
	protected void createContentPane(final List<String> compartmentFigure) {
		final int childrenSize = getChildren().size();
		add(createTimeRulerCompartment(), childrenSize);
	}

	protected IFigure createTimeRulerCompartment() {
		return this.timeRulerCompartment = new TimeRulerFigure();
	}

	



	public RectangleFigure getTimeRulerContainerFigure() {
		return this.timeRulerCompartment;
	}

}
