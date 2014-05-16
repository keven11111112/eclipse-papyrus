/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.figure.layer;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.papyrus.infra.gmfdiag.common.routers.ObliqueGridRouter;
import org.eclipse.papyrus.infra.gmfdiag.common.routers.RectilinearGridRouter;

/**
 * 
 * A Custom Connnection Layer to use to change the router used by diagrams
 * 
 */
@SuppressWarnings("restriction")
public class CustomConnectionLayerEx extends ConnectionLayerEx {

	/**
	 * RectilinearRouter using diagram Grid
	 */
	protected ConnectionRouter rectilinearGridRouter;

	/**
	 * ObliqueRouter using Diagram Grid
	 */
	protected ConnectionRouter obliqueGridRouter;

	/**
	 * An edit part
	 */
	protected final EditPart anyEditPart;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param anyEditPart
	 *        an edit part of the diagram
	 */
	public CustomConnectionLayerEx(final EditPart anyEditPart) {
		this.anyEditPart = anyEditPart;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx#getRectilinearRouter()
	 * 
	 * @return
	 */
	@Override
	public ConnectionRouter getRectilinearRouter() {
		if(this.rectilinearGridRouter == null) {
			this.rectilinearGridRouter = new RectilinearGridRouter(this.anyEditPart);
		}
		return this.rectilinearGridRouter;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx#getObliqueRouter()
	 * 
	 * @return
	 */
	@Override
	public ConnectionRouter getObliqueRouter() {
		if(this.obliqueGridRouter == null) {
			this.obliqueGridRouter = new ObliqueGridRouter(this.anyEditPart);
		}
		return this.obliqueGridRouter;
	}
}
