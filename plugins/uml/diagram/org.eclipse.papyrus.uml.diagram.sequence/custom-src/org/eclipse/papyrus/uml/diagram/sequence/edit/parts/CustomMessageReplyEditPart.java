/*****************************************************************************
 * Copyright (c) 2010-2016 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *   Patrick Tessier (CEA LIST) rename classes
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomMessageReplyItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.MessageReply;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessageReplyEditPart extends MessageReplyEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomMessageReplyEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomMessageReplyItemSemanticEditPolicy());
	}

	/**
	 * Block message sort modification
	 */
	@Override
	protected void handleNotificationEvent(final Notification notification) {
		SequenceUtil.handleMessageSortChange(getEditingDomain(), notification, (Message) resolveSemanticElement(), MessageSort.REPLY_LITERAL);
		super.handleNotificationEvent(notification);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyEditPart#createConnectionFigure()
	 *
	 * @return
	 */
	@Override
	protected Connection createConnectionFigure() {
		return new MessageReply(getMapMode());
	}
}
