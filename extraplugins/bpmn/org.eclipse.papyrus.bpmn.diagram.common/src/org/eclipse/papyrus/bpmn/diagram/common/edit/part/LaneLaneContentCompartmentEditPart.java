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
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;

public class LaneLaneContentCompartmentEditPart extends ActivityPartitionActivityPartitionContentCompartmentEditPart{
	/**
	 * remove the bottom border, remove scrollbars
	 */
	@Override
	public IFigure createFigure() {
		IFigure figure = super.createFigure();
		figure.setBorder(null);
		return figure;
	}

	public LaneLaneContentCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	public String getCompartmentName() {
		return "LaneContentCompartment";
	}


}
