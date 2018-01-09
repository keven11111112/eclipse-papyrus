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

import java.util.EventObject;

import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.papyrus.uml.diagram.common.helper.NotificationHelper;

/**
 * @author Patrick Tessier
 *
 */
public class GridCommandStackListener implements CommandStackListener {

	protected GridManagementEditPolicy gridManagementEditPolicy;
	/**
	 * Constructor.
	 *
	 */
	public GridCommandStackListener(GridManagementEditPolicy gridManagementEditPolicy) {
		this.gridManagementEditPolicy= gridManagementEditPolicy;
	}
	/**
	 * @see org.eclipse.emf.common.command.CommandStackListener#commandStackChanged(java.util.EventObject)
	 *
	 * @param event
	 */
	@Override
	public void commandStackChanged(EventObject event) {
		gridManagementEditPolicy.notifyChanged(new CommandExecutionNotification(Notification.ADD, true,true));
	}

}
