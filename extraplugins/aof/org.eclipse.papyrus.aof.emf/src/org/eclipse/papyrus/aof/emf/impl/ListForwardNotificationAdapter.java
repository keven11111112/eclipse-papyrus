package org.eclipse.papyrus.aof.emf.impl;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class ListForwardNotificationAdapter<E> extends AdapterImpl {
	/**
	 * 
	 */
	private final ListFeatureDelegate<E> listFeatureDelegate;

	/**
	 * @param listFeatureDelegate
	 */
	ListForwardNotificationAdapter(ListFeatureDelegate<E> listFeatureDelegate) {
		this.listFeatureDelegate = listFeatureDelegate;
	}

	@Override
	public void notifyChanged(Notification notification) {
		if (notification.isTouch() || (this.listFeatureDelegate.getFeature() != notification.getFeature())) {
			// No change to propagate
			return;
		}

		if (this.listFeatureDelegate.silentForward) {
			return;
		}

		this.listFeatureDelegate.silentReverse = true;
		try {
			switch (notification.getEventType()) {
			case Notification.ADD: {
				@SuppressWarnings("unchecked")
				E added = (E) notification.getNewValue();
				this.listFeatureDelegate.delegate.add(notification.getPosition(), added);
				break;
			}
			case Notification.ADD_MANY: {
				@SuppressWarnings("unchecked")
				Iterator<E> iter = ((Iterable<E>) notification.getNewValue()).iterator();
				for (int i = notification.getPosition(); iter.hasNext(); i++) {
					this.listFeatureDelegate.delegate.add(i, iter.next());
				}
				break;
			}
			case Notification.REMOVE:
				this.listFeatureDelegate.delegate.removeAt(notification.getPosition());
				break;
			case Notification.REMOVE_MANY: {
				int[] indices = (int[]) notification.getNewValue();
				if (indices == null) {
					this.listFeatureDelegate.delegate.clear();
				} else {
					// Iterate in reverse to avoid invalidating following indices
					for (int i = indices.length - 1; i >= 0; i--) {
						this.listFeatureDelegate.delegate.removeAt(indices[i]);
					}
				}
				break;
			}
			case Notification.MOVE:
				this.listFeatureDelegate.delegate.move(notification.getPosition(), (Integer) notification.getOldValue());
				break;
			case Notification.SET:
				if (this.listFeatureDelegate.getFeature().isMany()) {
					@SuppressWarnings("unchecked")
					E replacement = (E) notification.getNewValue();
					this.listFeatureDelegate.delegate.set(notification.getPosition(), replacement);
				}
				break;
			case Notification.UNSET:
				throw new UnsupportedOperationException("EMF notification " + notification + " can never occur on a list-based feature");
			default: // REMOVING_ADAPTER | RESOLVE (but these are touches, anyways)
				break;
			}
		} finally {
			this.listFeatureDelegate.silentReverse = false;
		}
	}
}