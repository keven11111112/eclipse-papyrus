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

package org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.RoundedBorderNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AllowResizeAffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.custom.locators.CustomPortPositionLocator;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortEditPart;


/**
 * 
 * This class just takes care of installing a new policy that calls the resize command of a child item (a port in this case).
 * 
 * @author Trung-Truc Nguyen
 *
 */
public class CustomClassCompositeEditPart extends ClassCompositeEditPart{

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomClassCompositeEditPart(View view) {
		super(view);
		installEditPolicy(AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE, new AllowResizeAffixedNodeAlignmentEditPolicy());
	}

	public void installEditPolicy(Object key, EditPolicy editPolicy) {
		if (AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE.equals(key)) {
			if (editPolicy instanceof AllowResizeAffixedNodeAlignmentEditPolicy)
				super.installEditPolicy(key, editPolicy);
		}
		else 
			super.installEditPolicy(key, editPolicy);
	}
	
	protected boolean addFixedChild(EditPart childEditPart) {
		//Papyrus Gencode :Affixed Port locator
		if(childEditPart instanceof PortEditPart) {
			IBorderItemLocator locator = new CustomPortPositionLocator(getMainFigure(), (RoundedBorderNamedElementEditPart) childEditPart, PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((PortEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		return super.addFixedChild(childEditPart);
	}
}
