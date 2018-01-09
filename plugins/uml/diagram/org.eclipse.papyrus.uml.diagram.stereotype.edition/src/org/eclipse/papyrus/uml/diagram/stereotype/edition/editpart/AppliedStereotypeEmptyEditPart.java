/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Celine JANSSENS (ALL4TEC) - Initial API and implementation
 *   Celine JANSSENS (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 Stereotype Display
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.provider.StereotypePropertiesEditPartProvider;

/**
 * This Edit Part is a dummy edit part with no figure to be linked to a Notation View that is not representing a graphical object.
 * The Views related to this edit Part are Views of type StereotypeBrace, StereotypeLabel and StereotypeBraceProperty
 * 
 * @see StereotypePropertiesEditPartProvider
 * 
 * @author Celine JANSSENS
 *
 */
public class AppliedStereotypeEmptyEditPart
		extends GraphicalEditPart {

	public static final String ID = "AppliedStereotypesEmptyNode";//$NON-NLS-1$
	
	private IFigure figure;

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public AppliedStereotypeEmptyEditPart(View view) {
		super(view);
	}

	@Override
	protected void addNotationalListeners() {
		// no need for Listeners
	}

	@Override
	protected void addSemanticListeners() {
		// no need for Listeners
	}


	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getFigure()
	 *
	 * @return
	 */
	@Override
	public IFigure getFigure() {
		return super.getFigure();
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.internal.editparts.DummyEditPart#createFigure()
	 *
	 * @return An invisible rectangle of size null.
	 */
	@Override
	protected IFigure createFigure() {
		if (figure == null) {
			figure = new Figure() {
				@Override
				public void paint(org.eclipse.draw2d.Graphics graphics) {
					// Nothing to do
				};

				/**
				 * @see org.eclipse.draw2d.Figure#getBounds()
				 *
				 * @return
				 */
				@Override
				public Rectangle getBounds() {
					return new Rectangle();
				}

			};
		}
		return figure;
	}

}
