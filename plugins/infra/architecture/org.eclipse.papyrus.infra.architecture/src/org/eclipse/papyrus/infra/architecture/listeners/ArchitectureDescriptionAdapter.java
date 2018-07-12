/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
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
		if (notification.getNotifier() instanceof ArchitectureDescription ||
			notification.getNewValue() instanceof ArchitectureDescription ||
			notification.getOldValue() instanceof ArchitectureDescription) {
			ArchitectureDescriptionNotifier.getInstance().fireArchitectureContextChanged(notification);
		} else if (notification.getNotifier() instanceof ArchitectureDescriptionPreferences ||
			notification.getNewValue() instanceof ArchitectureDescriptionPreferences ||
			notification.getOldValue() instanceof ArchitectureDescriptionPreferences) {
			ArchitectureDescriptionNotifier.getInstance().fireArchitectureViewpointsChanged(notification);
		}
	}

}
