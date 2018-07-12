/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

public class OperationFigure extends org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel {

	static final org.eclipse.swt.graphics.Font THIS_FONT = new org.eclipse.swt.graphics.Font(org.eclipse.swt.widgets.Display.getCurrent(), "Arial", 10, org.eclipse.swt.SWT.NORMAL);

	public OperationFigure() {
		this.setText("");

		this.setFont(THIS_FONT);
	}
}
