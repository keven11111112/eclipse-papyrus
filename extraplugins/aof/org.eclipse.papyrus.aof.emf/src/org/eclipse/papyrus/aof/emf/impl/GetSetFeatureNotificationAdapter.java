/*******************************************************************************
 *  Copyright (c) 2015 Christian W. Damus and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Christian W. Damus - initial API and implementation
 *     
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.papyrus.aof.core.IObserver;

class GetSetFeatureNotificationAdapter<E> extends AdapterImpl {

	private final GetSetFeatureDelegate<E> getSetFeatureDelegate;

	GetSetFeatureNotificationAdapter(GetSetFeatureDelegate<E> getSetFeatureDelegate) {
		this.getSetFeatureDelegate = getSetFeatureDelegate;
	}

	@Override
	public void notifyChanged(Notification notification) {
		if (notification.isTouch()) {
			// No change to propagate
			return;
		}

		for (IObserver<? super E> observer : this.getSetFeatureDelegate.getObserversForNotification()) {
			if (!observer.isDisabled() && (this.getSetFeatureDelegate.getFeature() == notification.getFeature())) {
				switch (notification.getEventType()) {
				case Notification.SET:
					// Can't treat unset as removal because it can trigger removal in another IOne
					// which, if they have different default values, will result in the two IOnes
					// having different values: a binding that propoagates default-ness instead
					// of the actual value
				case Notification.UNSET:
					if (notification.wasSet() || !this.getSetFeatureDelegate.isOptional()) {
						observer.replaced(0, (E) notification.getNewValue(), (E) notification.getOldValue());
					} else {
						observer.added(0, (E) notification.getNewValue());
					}
					break;
				case Notification.ADD:
				case Notification.REMOVE:
				case Notification.ADD_MANY:
				case Notification.REMOVE_MANY:
				case Notification.MOVE:
					throw new UnsupportedOperationException("EMF notification " + notification + " can never occur on a scalar feature");
				default: // REMOVING_ADAPTER | RESOLVE
					break;
				}
			}
		}
	}

}