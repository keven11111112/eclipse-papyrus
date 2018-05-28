/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

/**
 * @author Patrick Tessier
 * @since 3.0
 *
 */
public class NoVisibleEditPart extends GraphicalEditPart {

	/**
	 * Constructor.
	 *
	 * @param model
	 */
	public NoVisibleEditPart(EObject model) {
		super(model);
	}

	public static final String VISUAL_ID="NoVisibleEditPart"; 
	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#setVisibility(boolean)
	 *
	 * @param vis
	 */
	@Override
	protected void setVisibility(boolean vis) {
		super.setVisibility(false);
	}
	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#createFigure()
	 *
	 * @return
	 */
	@Override
	protected IFigure createFigure() {
		return new RectangleFigure();
	}
}