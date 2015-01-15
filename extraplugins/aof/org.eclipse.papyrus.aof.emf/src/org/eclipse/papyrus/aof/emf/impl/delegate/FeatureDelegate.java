/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.impl.delegate;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IConstrained;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.impl.delegate.BaseDelegate;

/**
 * A delegate bound to an EMF object property.
 * 
 * @author obeaudoux
 * 
 * @param <A>
 */

public abstract class FeatureDelegate<A> extends BaseDelegate<A> implements IConstrained {

	protected EObject object;
	protected EStructuralFeature feature;

	protected FeatureDelegate(EObject object, EStructuralFeature feature) {
		this.object = object;
		this.feature = feature;
	}

	// Constrained

	public boolean isOptional() {
		return feature.getLowerBound() == 0;
	}

	public boolean isSingleton() {
		return (feature.getUpperBound() == 1);
	}

	public boolean isOrdered() {
		return feature.isOrdered() || isSingleton();
	}

	public boolean isUnique() {
		return feature.isUnique() || isSingleton();
	}

	// Observable

	public void addObserver(IObserver<A> observer) {
		super.addObserver(observer);
		Adapter adapter = new NotificationAdapter(observer);
		object.eAdapters().add(adapter);
	}

	public void removeObserver(IObserver<A> observer) {
		super.removeObserver(observer);
		for (Adapter adapter : object.eAdapters()) {
			if ((adapter instanceof FeatureDelegate<?>.NotificationAdapter)
					&& (((FeatureDelegate<?>.NotificationAdapter) adapter).observer == observer)) {
				object.eAdapters().remove(adapter);
				return;
			}
		}
	}

	public class NotificationAdapter extends AdapterImpl {

		private IObserver<A> observer;

		public NotificationAdapter(IObserver<A> observer) {
			this.observer = observer;
		}

		public void notifyChanged(Notification n) {
			if (feature == n.getFeature()) {
				switch (n.getEventType()) {
				case Notification.ADD:
					observer.added(n.getPosition(), (A) n.getNewValue());
					break;
				case Notification.ADD_MANY: {
					Object contents = n.getNewValue();
					int i = n.getPosition();
					for (A element : (Iterable<A>) contents) {
						observer.added(i, element);
						i++;
					}
					break;
				}
				case Notification.REMOVE:
					observer.removed(n.getPosition(), (A) n.getOldValue());
					break;
				case Notification.REMOVE_MANY: {
					Object contents = n.getNewValue();
					int i = n.getPosition();
					for (A element : (Iterable<A>) contents) {
						observer.removed(i, element);
						i++;
					}
					break;
				}
				case Notification.MOVE:
					observer.replaced(n.getPosition(), (A) n.getOldValue(), (A) n.getNewValue());
					break;
				case Notification.SET:
					if (n.wasSet()) {
						observer.replaced(0, (A) n.getOldValue(), (A) n.getNewValue());
					}
					else {
						observer.added(0, (A) n.getNewValue());
					}
					break;
				case Notification.UNSET:
					observer.removed(0, (A) n.getOldValue());
					break;
				default: // REMOVING_ADAPTER | RESOLVE
				}
			}
		}
	}

}
