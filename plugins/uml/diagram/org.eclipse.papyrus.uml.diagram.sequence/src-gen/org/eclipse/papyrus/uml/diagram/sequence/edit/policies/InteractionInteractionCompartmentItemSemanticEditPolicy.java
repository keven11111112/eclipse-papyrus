/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CombinedFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConsiderIgnoreFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.InteractionUseCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.LifelineCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class InteractionInteractionCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InteractionInteractionCompartmentItemSemanticEditPolicy() {
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
		IElementType baseElementType = requestElementType;

		if (UMLElementTypes.ConsiderIgnoreFragment_Shape == baseElementType) {
			return getGEFWrapper(new ConsiderIgnoreFragmentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.CombinedFragment_Shape == baseElementType) {
			return getGEFWrapper(new CombinedFragmentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Lifeline_Shape == baseElementType) {
			return getGEFWrapper(new LifelineCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.InteractionUse_Shape == baseElementType) {
			return getGEFWrapper(new InteractionUseCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Constraint_Shape == baseElementType) {
			return getGEFWrapper(new ConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Comment_Shape == baseElementType) {
			return getGEFWrapper(new CommentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
