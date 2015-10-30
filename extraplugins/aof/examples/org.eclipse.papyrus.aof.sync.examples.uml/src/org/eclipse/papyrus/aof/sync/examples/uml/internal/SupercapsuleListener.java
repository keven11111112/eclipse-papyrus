/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.aof.sync.examples.uml.internal;

import static org.eclipse.papyrus.aof.sync.examples.uml.internal.CapsuleSyncDelegate.isCapsule;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.sync.ISyncService;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A listener for changes in Capsule generalization relationships, to set up and
 * tear down synchronization of capsules.
 */
public class SupercapsuleListener implements IPapyrusListener {

	public SupercapsuleListener() {
		super();
	}

	@Override
	public void notifyChanged(Notification msg) {
		if (!msg.isTouch()) {
			Object notifier = msg.getNotifier();

			if ((notifier instanceof Classifier) && isCapsule((Classifier) notifier)) {
				handleCapsule((Classifier) notifier, msg);
			} else if (notifier instanceof Generalization) {
				handleGeneralization((Generalization) notifier, msg);
			}
		}
	}

	protected void handleCapsule(Classifier capsule, Notification msg) {
		if (msg.getFeature() == UMLPackage.Literals.CLASSIFIER__GENERALIZATION) {
			switch (msg.getEventType()) {
			case Notification.ADD:
				Generalization added = (Generalization) msg.getNewValue();
				if (isCapsule(added.getGeneral())) {
					synchronize(added.getGeneral(), capsule);
				}
				break;
			case Notification.REMOVE:
				Generalization removed = (Generalization) msg.getOldValue();
				if (isCapsule(removed.getGeneral())) {
					unsynchronize(removed.getGeneral(), capsule);
				}
				break;
			}
		}
	}

	protected void handleGeneralization(Generalization generalization, Notification msg) {
		if (msg.getFeature() == UMLPackage.Literals.GENERALIZATION__GENERAL) {
			if (isCapsule(generalization.getSpecific())) {
				switch (msg.getEventType()) {
				case Notification.SET:
				case Notification.UNSET:
					Classifier newGeneral = (Classifier) msg.getNewValue();
					if (isCapsule(newGeneral)) {
						synchronize(newGeneral, generalization.getSpecific());
					}
					Classifier oldGeneral = (Classifier) msg.getOldValue();
					if (isCapsule(oldGeneral)) {
						unsynchronize(oldGeneral, generalization.getSpecific());
					}
					break;
				}
			}
		} // The specific case is handled by the specific classifier
	}

	private void synchronize(Classifier supercapsule, Classifier subcapsule) {
		ISyncService service = ServiceUtilsForEObject.getInstance().getService(ISyncService.class, subcapsule, null);
		if (service != null) {
			service.synchronize(supercapsule, subcapsule);
		}
	}

	private void unsynchronize(Classifier supercapsule, Classifier subcapsule) {
		ISyncService service = ServiceUtilsForEObject.getInstance().getService(ISyncService.class, subcapsule, null);
		if (service != null) {
			// TODO: Implement unsynchronization
		}
	}
}
