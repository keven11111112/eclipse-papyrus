package org.eclipse.papyrus.aof.emf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.papyrus.aof.core.IObserver;

public class GetSetFeatureNotificationAdapter<E> extends AdapterImpl {

	/**
	 * 
	 */
	private final GetSetFeatureDelegate<E> getSetFeatureDelegate;

	/**
	 * @param getSetFeatureDelegate
	 */
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
				case Notification.ADD:
					observer.added(notification.getPosition(), (E) notification.getNewValue());
					break;
				case Notification.REMOVE:
					observer.removed(notification.getPosition(), (E) notification.getOldValue());
					break;
				case Notification.SET:
					if (notification.wasSet() || !this.getSetFeatureDelegate.isOptional()) {
						observer.replaced(0, (E) notification.getNewValue(), (E) notification.getOldValue());
					} else {
						observer.added(0, (E) notification.getNewValue());
					}
					break;
				case Notification.UNSET:
					observer.removed(0, (E) notification.getOldValue());
					break;
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