/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling.BoundForEditPart;

/**
 * This class has been modified 
 * because the container is used to manipulate as a list
 * the refresh has been modified to take the size of the operand.
 *
 */
public class CInteractionOperandEditPart extends InteractionOperandEditPart {

	public static int DEFAULT_HEIGHT=40;
	public static int DEFAULT_WIDHT=100;

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CInteractionOperandEditPart(View view) {
		super(view);
	}

	/**
	 * this method has been overloaded in order to set InteractionOperand transparent
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart#refreshVisuals()
	 *
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		getPrimaryShape().setTransparency(100);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart#refresh()
	 *
	 */
	@Override
	public void refresh() {
		if( children!=null){
			for (Object object : children) {
				if( object instanceof GraphicalEditPart){
					//((GraphicalEditPart)object).refresh();
				}
			}
		}
		super.refresh();

	}
	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#removeEditPartListener(org.eclipse.gef.EditPartListener)
	 *
	 * @param listener
	 */
	@Override
	public void removeEditPartListener(EditPartListener listener) {
		// TODO Auto-generated method stub
		super.removeEditPartListener(listener);
	}
	/**
	 * this method method has been overloaded because of a mistake in the gmfgen.
	 * so we has to implement addition of sub-figures inside the primary figure...
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#getContentPaneFor(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 *
	 * @param editPart
	 * @return
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		} else {
			return getPrimaryShape();
		}
	}

	/**
	 * because the container is used to manipulate as a list
	 * the refresh has been modified to take the size of the operand.
	 */
	protected void refreshBounds() {
		int width = BoundForEditPart.getWidthFromView((Node)getNotationView());
		int height = BoundForEditPart.getHeightFromView((Node)getNotationView());
		Dimension size = new Dimension(width, height);
		int x = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		Point loc = new Point(x, y);
		((GraphicalEditPart) getParent()).setLayoutConstraint(this,	getFigure(),new Rectangle(loc, size));
	}
}
