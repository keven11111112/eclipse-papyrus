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
 */
package org.eclipse.papyrus.uml.diagram.communication.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.communication.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.communication.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.communication.edit.commands.DurationObservationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.communication.edit.commands.LifelineCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.communication.edit.commands.TimeObservationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.communication.providers.UMLElementTypes;

/**
 * @generated
 */
public class InteractionCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InteractionCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Interaction_Shape);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}


		if (UMLElementTypes.Lifeline_Shape == requestElementType) {

			return getGEFWrapper(new LifelineCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Comment_Shape == requestElementType) {

			return getGEFWrapper(new CommentCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Constraint_Shape == requestElementType) {

			return getGEFWrapper(new ConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.TimeObservation_Shape == requestElementType) {

			return getGEFWrapper(new TimeObservationCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.DurationObservation_Shape == requestElementType) {

			return getGEFWrapper(new DurationObservationCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		return super.getCreateCommand(req);
	}
}
