/*****************************************************************************
 * Copyright (c) 2018 CEA LIST, EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.IntValueStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.DurationLinkSelectionHandlesEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.DurationLinkFigure;

public class CustomDurationObservationLinkEditPart extends DurationObservationLinkEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomDurationObservationLinkEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new DurationLinkSelectionHandlesEditPolicy(this, getEditingDomain()));
	}

	@Override
	protected void refreshVisuals() {
		Connector connector = (Connector) getNotationView();
		NamedStyle namedStyle = connector.getNamedStyle(NotationPackage.Literals.INT_VALUE_STYLE, "delta");
		if (namedStyle instanceof IntValueStyle) {
			refreshArrowDelta((IntValueStyle) namedStyle);
		}
		super.refreshVisuals();
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() instanceof IntValueStyle
				&& "delta".equals(((IntValueStyle) event.getNotifier()).getName())) {
			refreshArrowDelta((IntValueStyle) event.getNotifier());
		} else if (event.getNotifier() == getNotationView()
				&& event.getFeature() == NotationPackage.Literals.VIEW__STYLES) {
			refreshVisuals();
		}
		super.handleNotificationEvent(event);
	}

	private void refreshArrowDelta(IntValueStyle deltaStyle) {
		int delta = deltaStyle.getIntValue();
		((DurationLinkFigure) getFigure()).setArrowPositionDelta(delta);
	}

}
