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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author dstadnik
 */
public class SeparatorFigure extends Shape {

	protected void outlineShape(Graphics graphics) {
		Rectangle r = getBounds();
		int x = r.x + lineWidth / 2;
		int y = r.y + lineWidth / 2;
		int w = r.width - Math.max(1, lineWidth);
		int h = r.height - Math.max(1, lineWidth);
		graphics.drawLine(x, y + h / 2, x + w, y + h / 2);
	}

	protected void fillShape(Graphics graphics) {
	}
}
