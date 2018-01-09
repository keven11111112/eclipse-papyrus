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

package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.awt.Rectangle;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;

/**
 * @author Patrick Tessier
 * @since 3.0
 * This class is used to set location and dimension for the InteractionOperand
 *
 */
public class CombinedCreationEditPolicy extends DefaultCreationEditPolicy {
	
	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy#getSetBoundsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest, org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor)
	 *
	 * @param request
	 * @param descriptor
	 * @return
	 */
	@Override
	protected ICommand getSetBoundsCommand(CreateViewRequest request, ViewDescriptor descriptor) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		Node node=(Node)((GraphicalEditPart)getHost()).getNotationView();
		int labelHeight=27;
		Node combinedFragmentNode = (Node)((GraphicalEditPart)(getHost().getParent())).getNotationView();
		int y=0;
		int height=((Bounds)combinedFragmentNode.getLayoutConstraint()).getHeight()-labelHeight;
		for(int i=0; i<getHost().getChildren().size();i++) {
			
			Node currentNode=(Node)(((GraphicalEditPart)getHost().getChildren().get(i))).getNotationView();
			int previousheight=((Bounds)currentNode.getLayoutConstraint()).getHeight();
			y=y+previousheight;
			height=height-previousheight;
		}
		org.eclipse.draw2d.geometry.Rectangle rect= new org.eclipse.draw2d.geometry.Rectangle(0,y ,-1,height);
		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(editingDomain, "Set dimension", descriptor, rect);
		return setBoundsCommand;
	}

}
