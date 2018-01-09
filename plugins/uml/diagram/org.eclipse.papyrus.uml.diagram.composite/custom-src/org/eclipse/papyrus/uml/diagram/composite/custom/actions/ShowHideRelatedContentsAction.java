/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.actions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.actions.ShowHideContentsAction;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideRelatedContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.custom.messages.Messages;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

public class ShowHideRelatedContentsAction extends ShowHideContentsAction {

	/**
	 * Constructor.
	 */
	public ShowHideRelatedContentsAction() {
		super(Messages.ShowHideRelatedContentsAction_Title, Messages.ShowHideRelatedContentsAction_Message, ShowHideRelatedContentsEditPolicy.SHOW_HIDE_RELATED_CONTENTS_POLICY);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#initAction()
	 *
	 */
	@Override
	protected void initAction() {
		super.initAction();
		for (IGraphicalEditPart current : this.selectedElements) {
			// the selected elements which aren't Classifier are ignored
			if (((View) current.getModel()).getElement() instanceof Property) {
				Property property = (Property) ((View) current.getModel()).getElement();
				if (property.getType() instanceof Classifier) {
					this.representations.add(new RootEditPartRepresentation(current, (Classifier) property.getType()));
				}
			}
		}
	}
}
