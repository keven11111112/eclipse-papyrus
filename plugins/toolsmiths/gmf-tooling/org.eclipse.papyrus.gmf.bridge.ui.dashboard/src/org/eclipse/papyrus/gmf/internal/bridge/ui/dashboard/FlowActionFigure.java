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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;

/**
 * @author dstadnik
 */
public class FlowActionFigure extends RectangleFigure implements ActionContainer {

	public FlowActionFigure() {
		setLayoutManager(new ToolbarLayout());
	}

	public void addAction(IFigure actionFigure) {
		add(actionFigure);
	}

	public void addAction(IFigure actionFigure, boolean std) {
		add(actionFigure);
	}

	public void removeAction(IFigure actionFigure, boolean std) {
		remove(actionFigure);
	}
}
