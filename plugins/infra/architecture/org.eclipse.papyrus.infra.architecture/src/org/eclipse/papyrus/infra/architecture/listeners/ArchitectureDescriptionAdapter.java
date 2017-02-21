/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.architecture.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescription;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionPreferences;

/**
 * An adapter that is installed in DI models to listen to architecture description changes
 *
 * @since 1.0
 */
public class ArchitectureDescriptionAdapter extends EContentAdapter {

	/**
	 * Listens to changes on ArchitectureDescription* objects
	 */
	@Override
	public void notifyChanged(Notification notification) {
		if (notification.getEventType() == Notification.REMOVING_ADAPTER)
			return;
		Object notifier = notification.getNotifier();
		if (notifier instanceof ArchitectureDescription) {
			ArchitectureDescriptionNotifier.getInstance().fireArchitectureContextChanged(notification);
		} else if (notifier instanceof ArchitectureDescriptionPreferences) {
			ArchitectureDescriptionNotifier.getInstance().fireArchitectureViewpointsChanged(notification);
		}
	}

}
