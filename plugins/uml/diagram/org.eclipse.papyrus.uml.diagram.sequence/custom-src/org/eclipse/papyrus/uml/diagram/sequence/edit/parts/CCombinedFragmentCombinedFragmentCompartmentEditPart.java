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
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling.BoundForEditPart;

/**
 * This class has been modified for 2 reasons:
 * - refresh in order to ensure the refresh about size of children
 * - compute the ratio for each children.
 * 
 * @since 3.0
 *
 */
public class CCombinedFragmentCombinedFragmentCompartmentEditPart extends CombinedFragmentCombinedFragmentCompartmentEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CCombinedFragmentCombinedFragmentCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * this method has been overloaded in order to ensure the refresh about children size
	 */
	protected void refreshBounds() {
		int width = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
		Dimension size = new Dimension(width, height);
		int x = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		Point loc = new Point(x, y);
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(loc, size));

		// this code has been added in order to force the refresh of Sub Combined fragment
		if (children != null) {
			for (Object child : children) {
				if (child instanceof EditPart) {
					((EditPart) child).refresh();
				}
			}
		}
	}

	/**
	 * This code is specific an use to constraint the size of sub compartments.
	 * the ratio has to be recompute in order to have a good display
	 * 
	 * @see GraphicalEditPart#setLayoutConstraint(EditPart, IFigure, Object)
	 */
	public void setLayoutConstraint(EditPart child, IFigure childFigure,
			Object childConstraint) {
		EditPart parentEditPart = this.getParent();
		// compute the ratio for each children
		int parentHeight = BoundForEditPart.getHeightFromView((Node) parentEditPart.getModel());
		if (childConstraint instanceof Rectangle) {
			double ratio = ((double) ((Rectangle) childConstraint).height) / parentHeight;
			if (ratio >= 1.0) {
				ratio = 0.95;
			}
			UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG, "ratio" + ratio); //$NON-NLS-1$
			childFigure.getParent().setConstraint(childFigure, ratio);
		}
	}
}
