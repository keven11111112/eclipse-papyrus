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

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;

/**
 * @author Patrick Tessier
 *
 */
public class CommandExecutionNotification extends NotificationImpl {

	/**
	 * Constructor.
	 *
	 * @param eventType
	 * @param oldBooleanValue
	 * @param newBooleanValue
	 */
	public CommandExecutionNotification(int eventType, boolean oldBooleanValue, boolean newBooleanValue) {
		super(eventType, oldBooleanValue, newBooleanValue);
	}


}
