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

package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.LifelineNodePlate;
import org.eclipse.papyrus.uml.diagram.sequence.figures.ILifelineInternalFigure;

/**
 * @author PT202707
 * @since 3.0
 *
 */
public class CLifeLineEditPart extends LifelineEditPart {

	public static int DEFAUT_HEIGHT=250;
	public static int DEFAUT_WIDTH=100;
	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CLifeLineEditPart(View view) {
		super(view);
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart#createSVGNodePlate()
	 *
	 * @return
	 */
	@Override
	protected NodeFigure createSVGNodePlate() {
		svgNodePlate = new LifelineNodePlate(this, -1, -1).withLinkLFEnabled();
		svgNodePlate.setDefaultNodePlate(createNodePlate());

		return svgNodePlate;
	}
	
	
	
	@Override
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		if (!(childFigure instanceof ILifelineInternalFigure)) {
			getPrimaryShape().setConstraint(childFigure, constraint);
		}
	}
}
