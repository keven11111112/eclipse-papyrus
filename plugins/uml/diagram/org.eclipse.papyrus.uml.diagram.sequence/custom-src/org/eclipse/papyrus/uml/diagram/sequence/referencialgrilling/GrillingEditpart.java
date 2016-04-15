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

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

/**
 * @author PT202707
 * @since 3.0
 *
 */
public class GrillingEditpart extends GraphicalEditPart {

	/**
	 * Constructor.
	 *
	 * @param model
	 */
	public GrillingEditpart(EObject model) {
		super(model);
	}

	public static final String VISUAL_ID="GRILLING"; 
	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#setVisibility(boolean)
	 *
	 * @param vis
	 */
	@Override
	protected void setVisibility(boolean vis) {
		// TODO Auto-generated method stub
		super.setVisibility(false);
	}
	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#createFigure()
	 *
	 * @return
	 */
	@Override
	protected IFigure createFigure() {
		// TODO Auto-generated method stub
		return new RectangleFigure();
	}
}
