/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.tools.notify;

import org.eclipse.papyrus.infra.tools.Activator;

/**
 * A simple notification that just emits a message to the log.
 * 
 * @since 2.0
 */
public class LogNotification implements INotification {

	public LogNotification(Type type, String message) {
		super();

		// No message? No log
		if (message != null) {
			if (type == null) {
				type = Type.WARNING;
			}
			switch (type) {
			case ERROR:
				Activator.log.error(message, null);
				break;
			case WARNING:
				Activator.log.warn(message);
				break;
			default:
				Activator.log.info(message);
				break;
			}
		}
	}

	@Override
	public void delete() {
		// A log message is not presented in the UI, so it is always deleted
	}

	@Override
	public boolean isDeleted() {
		// A log message is not presented in the UI, so it is always deleted
		return true;
	}

}
