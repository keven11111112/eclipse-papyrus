/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - 372745: [ActivityDiagram] Major refactoring group framework
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.diagram.common.figures;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.tooling.runtime.draw2d.CenterLayout;
import org.eclipse.gmf.tooling.runtime.draw2d.labels.VerticalLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RoundedCompartmentFigure;

/**
 * Figure an activity partition
 */
public class LaneFigureRoundedCompartmentFigure extends RoundedCompartmentFigure {

	private static final String LANE_CONTENT_COMPARTMENT = "LaneContentCompartment";
	private VerticalLabel nameLabel;
	private Figure nameLabelContainerFigure;
	private Figure laneContentContainerFigure;
	protected final int LABEL_WIDTH = 30;
	
	public LaneFigureRoundedCompartmentFigure(List<String> compartmentFigure) {
		super(compartmentFigure);
		setShadow(false);
		createContents();
		setLayoutManager(new AbstractLayout() {

			public void layout(final IFigure container) {
				final Rectangle clientArea = container.getClientArea();
				final List<?> children = container.getChildren();
				for (int i = 0; i < children.size(); i++) {
					final IFigure child = (IFigure) children.get(i);
					if (child.equals(nameLabelContainerFigure)) {
						child.setBounds(new Rectangle(clientArea.x, clientArea.y, LABEL_WIDTH, clientArea.height));
					} else if (child.equals(laneContentContainerFigure)) {
						child.setBounds(new Rectangle(clientArea.x + LABEL_WIDTH, clientArea.y, clientArea.width - LABEL_WIDTH, clientArea.height));
					}
				}
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return new Dimension(-1, -1);
			}
		});
	}

	private void createContents() {
		this.nameLabelContainerFigure = new RectangleFigure();
		add(this.nameLabelContainerFigure);

		this.nameLabel = new VerticalLabel();
		this.nameLabelContainerFigure.add(this.nameLabel);
		this.nameLabelContainerFigure.setLayoutManager(new CenterLayout());
		
		laneContentContainerFigure = new RectangleFigure();
		add(laneContentContainerFigure);
	}
	
	public LaneFigureRoundedCompartmentFigure() {
		super(Collections.singletonList(LANE_CONTENT_COMPARTMENT));
		getLaneCompartment().setBorder(new OneLineBorder(1, PositionConstants.TOP));
	}

	public RectangleFigure getLaneCompartment() {
		return getCompartment(LANE_CONTENT_COMPARTMENT);
	}

	public WrappingLabel getPartitionLabel() {
		return getNameLabel();
	}
}
