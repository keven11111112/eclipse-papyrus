/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.figures.CustomStateCompartmentFigure;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.uml2.uml.State;

public class CustomStateCompartmentEditPart extends StateCompartmentEditPart {

	public CustomStateCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);

	}

	@Override
	public IFigure createFigure() {
		CustomStateCompartmentFigure result = new CustomStateCompartmentFigure(getCompartmentName(), getMapMode());
		return result;
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		// TODO Auto-generated method stub
		super.handleNotificationEvent(notification);
		refreshVisuals();
	}

	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		super.refreshVisuals();

		View stateView = (View) ((View) getModel()).eContainer();
		if (stateView != null) {
			State state = (State) stateView.getElement();

			((CustomStateCompartmentFigure) getFigure()).setToolTip(UMLLabelInternationalization.getInstance().getLabel(state));
		}
	}

}
