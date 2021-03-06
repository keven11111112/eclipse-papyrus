/******************************************************************************
 * Copyright (c) 2006, 2020 Eclipse.org, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.ui.dashboard;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.gmf.bridge.ui.dashboard.DashboardAction;
import org.eclipse.swt.graphics.Color;

/**
 * @author dstadnik
 */
public class HyperlinkFigure extends Label {

	private DashboardAction action;

	private boolean underlined;

	public HyperlinkFigure(DashboardAction action) {
		this.action = action;
		hookMouse();
	}

	protected void paintFigure(Graphics graphics) {
		Color color = graphics.getForegroundColor();
		if (action.isEnabled()) {
			graphics.setForegroundColor(ColorConstants.blue);
		} else {
			graphics.setForegroundColor(ColorConstants.gray);
		}
		super.paintFigure(graphics);
		if (underlined) {
			Rectangle bounds = getBounds();
			int y = bounds.y + bounds.height - 1;
			graphics.drawLine(bounds.x, y, bounds.x + bounds.width, y);
		}
		graphics.setForegroundColor(color);
	}

	protected void hookMouse() {
		addMouseListener(new MouseListener() {

			public void mouseDoubleClicked(MouseEvent me) {
			}

			public void mousePressed(MouseEvent me) {
				if (action.isEnabled()) {
					action.run();
				}
			}

			public void mouseReleased(MouseEvent me) {
			}

		});
		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
				setCursor(Cursors.HAND);
				underlined = true;
				repaint();
			}

			public void mouseExited(MouseEvent me) {
				underlined = false;
				setCursor(null);
				repaint();
			}

			public void mouseHover(MouseEvent me) {
			}

			public void mouseMoved(MouseEvent me) {
			}
		});
	}
}
