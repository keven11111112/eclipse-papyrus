package org.eclipse.papyrus.properties.uml.databinding;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagram.common.editparts.PapyrusStereotypeListener;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.uml2.uml.Element;

public abstract class AbstractStereotypeListener implements Adapter {

	private Element umlElement;

	private Notifier target;

	public AbstractStereotypeListener(Element umlElement) {
		this.umlElement = umlElement;
		umlElement.eAdapters().add(this);
		for(EObject eObject : umlElement.getStereotypeApplications()) {
			eObject.eAdapters().add(this);
		}
	}

	public void notifyChanged(Notification notification) {
		final int eventType = notification.getEventType();

		if(eventType == PapyrusStereotypeListener.APPLIED_STEREOTYPE) {
			// a stereotype was applied to the notifier
			// then a new listener should be added to the stereotype application
			((EObject)notification.getNewValue()).eAdapters().add(this);
			handleAppliedStereotype((EObject)notification.getNewValue());
		} else if(eventType == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE) {
			((EObject)notification.getNewValue()).eAdapters().remove(this);
			handleUnappliedStereotype((EObject)notification.getNewValue());
		}
	}

	protected abstract void handleUnappliedStereotype(EObject newValue);

	protected abstract void handleAppliedStereotype(EObject newValue);

	public void addChangeListener(Listener listener) {

	}

	public void removeChangeListener(Listener listener) {

	}

	public Notifier getTarget() {
		return target;
	}

	public void setTarget(Notifier newTarget) {
		this.target = newTarget;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

	public void dispose() {
		umlElement.eAdapters().remove(this);
		for(EObject eObject : umlElement.getStereotypeApplications()) {
			eObject.eAdapters().remove(this);
		}
	}
}