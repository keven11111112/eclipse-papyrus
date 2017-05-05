/*****************************************************************************
 * Copyright (c) 2017 Ericsson Communications and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionNameEditPart;



/**
 * @since 3.0
 */
public class CustomActivityPartitionNameEditPart extends ActivityPartitionNameEditPart {
	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomActivityPartitionNameEditPart(View view) {
		super(view);
	}

	protected void setLabelTextHelper(IFigure figure, String text) {
		if (figure instanceof PapyrusWrappingLabel) {
			return;
		} else {
			super.setLabelTextHelper(figure, text);
		}
	}
}
