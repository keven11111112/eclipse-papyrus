/*****************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 461629
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.dom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations;

/**
 * A Listener for notation and semantic properties changes
 *
 * @author Camille Letavernier
 */
public class StyleListener extends AdapterImpl {

	private final GMFElementAdapter elementAdapter;

	/**
	 * Constructor
	 *
	 * @param elementAdapter
	 *            The GMFElementAdapter to listen to
	 */
	public StyleListener(GMFElementAdapter elementAdapter) {
		this.elementAdapter = elementAdapter;
	}

	@Override
	public void notifyChanged(Notification notification) {
		if (notification.isTouch()) {
			return;
		}

		if (notification.getFeature() == NotationPackage.eINSTANCE.getView_Element()) {
			if (notification.getNewValue() == null) {
				elementAdapter.notationElementDisposed();
			} else {
				elementAdapter.semanticElementChanged();
			}
			return;
		}

		if (notification.getNotifier() == elementAdapter.getNotationElement()) {
			if (shouldPropagateNotationEvent(notification)) {
				elementAdapter.notationPropertyChanged();
			}
			return;
		}

		if (notification.getNotifier() == elementAdapter.getSemanticElement()) {
			elementAdapter.semanticPropertyChanged();
			return;
		}
	}

	/**
	 * Queries whether a {@code notification} from the notation model should be propagated to my element adapter.
	 * The default implementation propagates all but
	 * <ul>
	 * <li>changes to the {@link NotationPackage.Literals#VIEW__MUTABLE View::mutable} attribute</li>
	 * <li>addition of or changes to the {@linkplain CSSAnnotations#CSS_FORCE_VALUE force-value} annotation</li>
	 * </ul>
	 * 
	 * @param notification
	 *            a notification from the notation model
	 * @return whether it should be propagated
	 */
	protected boolean shouldPropagateNotationEvent(Notification notification) {
		boolean result = notification.getFeature() != NotationPackage.Literals.VIEW__MUTABLE;

		if (result) {
			if (notification.getFeature() == EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS) {
				// We never add/remove multiple annotations nor do we use SET to replace them.
				// However, if we did, all that would happen is an unnecessary refresh
				switch (notification.getEventType()) {
				case Notification.ADD:
					result = !CSSAnnotations.CSS_FORCE_VALUE.equals(((EAnnotation) notification.getNewValue()).getSource());
					break;
				case Notification.REMOVE:
					result = !CSSAnnotations.CSS_FORCE_VALUE.equals(((EAnnotation) notification.getOldValue()).getSource());
					break;
				}
			}
		}

		return result;
	}

	private String getEventType(Notification notification) {
		switch (notification.getEventType())
		{
		case Notification.SET:
			return ("SET");
		case Notification.UNSET:
			return ("UNSET");
		case Notification.ADD:
			return ("ADD");
		case Notification.ADD_MANY:
			return ("ADD_MANY");
		case Notification.REMOVE:
			return ("REMOVE");
		case Notification.REMOVE_MANY:
			return ("REMOVE_MANY");
		case Notification.MOVE:
			return ("MOVE");
		case Notification.REMOVING_ADAPTER:
			return ("REMOVING_ADAPTER");
		case Notification.RESOLVE:
			return ("RESOLVE");
		default:
			return Integer.toString(notification.getEventType());
		}
	}
}
