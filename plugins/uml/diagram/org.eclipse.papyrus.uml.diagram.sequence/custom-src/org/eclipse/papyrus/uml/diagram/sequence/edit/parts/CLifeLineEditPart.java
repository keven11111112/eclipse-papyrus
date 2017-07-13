/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 519621
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.LifelineNodePlate;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifeLineRestorePositionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.ILifelineInternalFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifeLineLayoutManager;

/**
 * @author PT202707
 * @since 3.0
 *
 */
public class CLifeLineEditPart extends LifelineEditPart {

	public static int DEFAUT_HEIGHT = 250;
	public static int DEFAUT_WIDTH = 100;

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CLifeLineEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart#createSVGNodePlate()
	 */
	@Override
	protected NodeFigure createSVGNodePlate() {
		svgNodePlate = new LifelineNodePlate(this, -1, -1).withLinkLFEnabled();
		svgNodePlate.setDefaultNodePlate(createNodePlate());

		return svgNodePlate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(LifeLineRestorePositionEditPolicy.KEY, new LifeLineRestorePositionEditPolicy());
		super.createDefaultEditPolicies();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.UMLNodeEditPart#setLayoutConstraint(org.eclipse.gef.EditPart, org.eclipse.draw2d.IFigure, java.lang.Object)
	 */
	@Override
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		if (!(childFigure instanceof ILifelineInternalFigure)) {
			getPrimaryShape().setConstraint(childFigure, constraint);
		}
	}

	/**
	 * @return the size of the header height
	 *         if the layout is null return -1
	 * @since 3.0
	 */
	public int getStickerHeight() {
		if (getPrimaryShape().getLifeLineLayoutManager() != null) {
			return ((LifeLineLayoutManager) getPrimaryShape().getLifeLineLayoutManager()).getBottomHeader();
		}
		return -1;
	}

}
