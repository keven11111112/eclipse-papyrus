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

package org.eclipse.papyrus.uml.diagram.sequence;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.LinkLFSVGNodePlateFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;

/**
 * This figure is used in order to allow a link to follow the shape of the lifeLine
 * see getPolygonPoints()
 *
 */
public  class LifelineNodePlate extends LinkLFSVGNodePlateFigure {

	/**
	 * Constructor.
	 *
	 * @param hostEP
	 * @param width
	 * @param height
	 * @param lifelineEditPart TODO
	 */
	public	LifelineNodePlate(org.eclipse.gef.GraphicalEditPart hostEP, int width, int height) {
		super(hostEP, width, height);
		withLinkLFEnabled();
		followSVGPapyrusPath=true;
		
	}

	/**
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getPolygonPoints()
	 */
	@Override
	public PointList getPolygonPoints() {
		return ((NodeFigure)this.getChildren().get(0)).getPolygonPoints();
	}

	protected ConnectionAnchor createAnchor(PrecisionPoint p) {
		p.setPreciseX(0.5);// a changer
		return super.createAnchor(p);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConnectionAnchor createConnectionAnchor(Point p) {
		if (p == null) {
			return getConnectionAnchor(szAnchor);
		} else {
			Point temp = p.getCopy();
			translateToRelative(temp);
			PrecisionPoint pt = BaseSlidableAnchor.getAnchorRelativeLocation(temp, getBounds());
			pt.setPreciseX(0.5);// a changer


			return createAnchor(pt);
		}
	}
}