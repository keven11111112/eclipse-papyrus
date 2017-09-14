/*****************************************************************************
 * Copyright (c) 2010-2017 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 521312, 522305
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 * @since 3.0
 */
public class CustomMessageFoundEditPart extends MessageFoundEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomMessageFoundEditPart(View view) {
		super(view);
	}

	/**
	 * Block message sort modification
	 */
	@Override
	protected void handleNotificationEvent(final Notification notification) {
		SequenceUtil.handleMessageSortChange(getEditingDomain(), notification, (Message) resolveSemanticElement(), MessageSort.ASYNCH_SIGNAL_LITERAL);
		super.handleNotificationEvent(notification);
	}
}
