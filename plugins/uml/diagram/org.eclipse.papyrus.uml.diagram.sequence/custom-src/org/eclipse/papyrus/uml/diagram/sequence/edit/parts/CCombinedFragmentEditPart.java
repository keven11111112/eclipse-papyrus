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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.CombinedFragment;

/**
 * @author PT202707
 * @since 3.0
 *
 */
public class CCombinedFragmentEditPart extends CombinedFragmentEditPart {
	public static int DEFAULT_HEIGHT=60;
	public static int DEFAULT_WIDTH=40;
	

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CCombinedFragmentEditPart(View view) {
		super(view);
	}
	
	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param event
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		// TODO Auto-generated method stub
		super.handleNotificationEvent(event);
		getPrimaryShape().setName(((CombinedFragment)this.resolveSemanticElement()).getInteractionOperator().getLiteral());
	}
	
	
//	/**
//	 * Modify it to avoid scrollbar
//	 */
//	protected boolean addFixedChild(EditPart childEditPart) {
//
//		if (childEditPart instanceof CCombinedCompartmentEditPart) {
//			IFigure pane = getPrimaryShape().getCompartmentFigure();
//			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
//			pane.add(((CCombinedCompartmentEditPart) childEditPart).getFigure());
//			return true;
//		}
//
//		return false;
//	}
//
//	/**
//	 * @generated
//	 */
//	protected boolean removeFixedChild(EditPart childEditPart) {
//		if (childEditPart instanceof CCombinedCompartmentEditPart) {
//			IFigure pane = getPrimaryShape().getCompartmentFigure();
//			pane.remove(((CCombinedCompartmentEditPart) childEditPart).getFigure());
//			return true;
//		}
//		return false;
//	}
//	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
//		if (editPart instanceof CCombinedCompartmentEditPart) {
//			return getPrimaryShape().getCompartmentFigure();
//		}
//		return getContentPane();
//	}

}
