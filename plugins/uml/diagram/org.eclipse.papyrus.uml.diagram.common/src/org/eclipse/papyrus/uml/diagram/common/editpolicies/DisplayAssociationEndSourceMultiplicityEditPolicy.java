/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Fanch Bonnabesse (ALL4TEC) fanch.bonnabesse@alltec.net - Bug 468166
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.uml.diagram.common.helper.AssociationEndSourceMultiplicityLabelHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PropertyLabelHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this class enables to refresh the multiplicity label of the association end (source)
 *
 */
public class DisplayAssociationEndSourceMultiplicityEditPolicy extends DisplayAssociationEndSourceEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<String> getDefaultDisplayValue() {
		return Collections.singleton(ICustomAppearance.DISP_MULTIPLICITY_NO_BRACKETS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PropertyLabelHelper createPropertyLabelHelper() {
		return AssociationEndSourceMultiplicityLabelHelper.getInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyChanged(final Notification notification) {
		super.notifyChanged(notification);

		// // Add listeners on this EditPolicy for the first modification of the source multiplicity
		final Object notifier = notification.getNotifier();
		final Property property = getUMLElement();

		if (notifier.equals(property)) {
			switch (notification.getFeatureID(Property.class)) {
			case UMLPackage.PROPERTY__LOWER_VALUE:
			case UMLPackage.PROPERTY__UPPER_VALUE:
				addAdditionalListeners();
			}
		}
	}
}
