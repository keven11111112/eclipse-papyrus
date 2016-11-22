/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.component.custom.actions;

import org.eclipse.papyrus.uml.diagram.common.actions.ShowHideContentsAction;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideRelatedContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.component.custom.messages.Messages;

/**
 * The Class ShowHideRelatedContentsAction.
 */
public class ShowHideRelatedContentsAction extends ShowHideContentsAction {

	/**
	 * Constructor.
	 */
	public ShowHideRelatedContentsAction() {
		super(Messages.ShowHideRelatedContentsAction_Title, Messages.ShowHideRelatedContentsAction_Message, ShowHideRelatedContentsEditPolicy.SHOW_HIDE_RELATED_CONTENTS_POLICY);
	}

}
