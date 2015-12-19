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

package org.eclipse.papyrus.bpmn.diagram.common.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.tooling.runtime.draw2d.CenterLayout;
import org.eclipse.gmf.tooling.runtime.draw2d.labels.VerticalLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;

/**
 * @author Juan Cadavid
 *
 */
public class LaneFigure extends PapyrusNodeFigure {
	private VerticalLabel nameLabel;
	private Figure nameLabelContainerFigure;
	private Figure laneContentContainerFigure;
	protected final int LABEL_WIDTH = 30;
	private boolean selected;

	public LaneFigure() {
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
		// TODO Auto-generated method stub
		this.nameLabelContainerFigure = new RectangleFigure();
		add(this.nameLabelContainerFigure);

		this.nameLabel = new VerticalLabel();
		this.nameLabelContainerFigure.add(this.nameLabel);
		this.nameLabelContainerFigure.setLayoutManager(new CenterLayout());
		
		laneContentContainerFigure = new RectangleFigure();
//		laneContentContainerFigure.setLayoutManager(new AbstractLayout() {
//
//			public void layout(final IFigure container) {
//				final Rectangle clientArea = container.getClientArea();
//				final List<?> children = container.getChildren();
//				for (int i = 0; i < children.size(); i++) {
//					final IFigure child = (IFigure) children.get(i);
//					if (child == getChronogramContainerFigure()) {
//						child.setBounds(new Rectangle(clientArea.x, clientArea.y, clientArea.width, clientArea.height - Constants.TIME_RULER_HEIGHT));
//					} else if (child == getTimeRulerContainerFigure()) {
//						child.setBounds(new Rectangle(clientArea.x, clientArea.y + clientArea.height - Constants.TIME_RULER_HEIGHT, clientArea.width, Constants.TIME_RULER_HEIGHT));
//					}
//				}
//			}
//
//			@Override
//			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
//				return new Dimension(-1, -1);
//			}
//		});
		
		add(laneContentContainerFigure);
	}
	
	@Override
	public void setPreferredSize(final Dimension size) {
		final IFigure container = getParent();
		final int childrenSize = container.getChildren().size();
		final Rectangle containerRectangle = container.getBounds();
		final Rectangle resultBounds = new Rectangle(0, 0, containerRectangle.width(), containerRectangle.height() / childrenSize);
		this.prefSize = resultBounds.getSize();
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

	@Override
	public void paintFigure(final Graphics graphics) {
		super.paintFigure(graphics);
		if (this.selected) {
			graphics.pushState();
			graphics.setForegroundColor(ColorConstants.black);
			graphics.setLineWidth(1);
			graphics.drawRectangle(getBounds().getShrinked(1, 1).resize(-1, -1));
			graphics.popState();
		}
	}
}
