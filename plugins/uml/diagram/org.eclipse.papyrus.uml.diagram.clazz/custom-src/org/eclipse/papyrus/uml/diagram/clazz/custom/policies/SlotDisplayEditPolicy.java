/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * It is used to refresh the label the slot
 */
public class SlotDisplayEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static String SLOT_DISPLAY = "SLOT_DISPLAY"; //$NON-NLS-1$

	/**
	 * Stores the semantic element related to the edit policy. If resolveSemanticElement is used, there are problems when the edit part is getting
	 * destroyed, i.e. the link to the semantic element is removed, but the listeners should still be removed
	 */
	protected Element hostSemanticElement;

	/**
	 * Returns the view controlled by the host edit part
	 *
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View) getHost().getModel();
	}

	/**
	 * Sets the semantic element which is linked to the edit policy
	 *
	 * @return the element linked to the edit policy
	 */
	protected Element initSemanticElement() {
		return (Element) getView().getElement();
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 *
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		hostSemanticElement = initSemanticElement();
		if (hostSemanticElement != null) {
			// adds a listener on the view and the element controlled by the editpart
			getDiagramEventBroker().addNotificationListener(view, this);
			getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);
			if (hostSemanticElement != null) {
				Slot slot = (Slot) hostSemanticElement;
				Iterator<ValueSpecification> iterator = slot.getValues().iterator();
				while (iterator.hasNext()) {
					ValueSpecification valueSpecification = iterator.next();
					getDiagramEventBroker().addNotificationListener(valueSpecification, this);
				}
			}
			refreshDisplay();
		} else {
			Activator.log.error("No semantic element was found during activation of the mask managed label edit policy", null); //$NON-NLS-1$
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		getDiagramEventBroker().removeNotificationListener(view, this);
		getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);
		if (hostSemanticElement != null) {
			Slot slot = (Slot) hostSemanticElement;
			Iterator<ValueSpecification> iterator = slot.getValues().iterator();
			while (iterator.hasNext()) {
				ValueSpecification valueSpecification = iterator.next();
				getDiagramEventBroker().removeNotificationListener(valueSpecification, this);
			}
		}
		// removes the reference to the semantic element
		hostSemanticElement = null;
	}

	protected void refreshDisplay() {
		getHost().refresh();
	}

	@Override
	public void notifyChanged(Notification notification) {
		if (notification.getEventType() == Notification.ADD) {
			if (notification.getFeature().equals(UMLPackage.eINSTANCE.getSlot_Value())) {
				getDiagramEventBroker().addNotificationListener(((EObject) notification.getNewValue()), this);
			}
		} else if (notification.getEventType() == Notification.REMOVE) {
			if (notification.getFeature().equals(UMLPackage.eINSTANCE.getSlot_Value())) {
				getDiagramEventBroker().removeNotificationListener(((EObject) notification.getOldValue()), this);
			}
		}
		refreshDisplay();
	}
}
