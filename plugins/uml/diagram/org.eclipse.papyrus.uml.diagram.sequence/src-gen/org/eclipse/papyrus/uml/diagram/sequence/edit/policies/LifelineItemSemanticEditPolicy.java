/*****************************************************************************
 * Copyright (c) 2009 CEA
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ActionExecutionSpecificationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.BehaviorExecutionSpecificationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CombinedFragment2CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.DestructionOccurrenceSpecificationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.DurationConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message2CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message2ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message3CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message3ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message4CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message4ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message5CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message5ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message6CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message6ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message7CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message7ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.MessageCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.StateInvariantCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.TimeConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.TimeObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class LifelineItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LifelineItemSemanticEditPolicy() {
		super(UMLElementTypes.Lifeline_Shape);
	}

	/**
	 * Generated not for add lifelines on lifeline
	 *
	 * @generated
	 * 			(update at each lifeline modification) add lifelines, add DurationObservation/Constraint
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		IElementType baseElementType = requestElementType;

		if (UMLElementTypes.ActionExecutionSpecification_Shape == baseElementType) {
			return getGEFWrapper(new ActionExecutionSpecificationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.BehaviorExecutionSpecification_Shape == baseElementType) {
			return getGEFWrapper(new BehaviorExecutionSpecificationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.StateInvariant_Shape == baseElementType) {
			return getGEFWrapper(new StateInvariantCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.CombinedFragment_CoRegionShape == baseElementType) {
			return getGEFWrapper(new CombinedFragment2CreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.TimeConstraint_Shape == baseElementType) {
			return getGEFWrapper(new TimeConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.TimeObservation_Shape == baseElementType) {
			return getGEFWrapper(new TimeObservationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DurationConstraint_Shape == baseElementType) {
			return getGEFWrapper(new DurationConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DestructionOccurrenceSpecification_Shape == baseElementType) {
			return getGEFWrapper(new DestructionOccurrenceSpecificationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
		if (provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);
			if (deleteCommand != null) {
				return new ICommandProxy(deleteCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 * 			(update at each lifeline modification) add general ordering
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return null;
		}
		IElementType baseElementType = requestElementType;

		if (UMLElementTypes.Message_SynchEdge == baseElementType) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_AsynchEdge == baseElementType) {
			return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_ReplyEdge == baseElementType) {
			return getGEFWrapper(new Message3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_CreateEdge == baseElementType) {
			return getGEFWrapper(new Message4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_DeleteEdge == baseElementType) {
			return getGEFWrapper(new Message5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_LostEdge == baseElementType) {
			return getGEFWrapper(new Message6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_FoundEdge == baseElementType) {
			return getGEFWrapper(new Message7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Comment_AnnotatedElementEdge == baseElementType) {
			return null;
		}
		if (UMLElementTypes.Constraint_ConstrainedElementEdge == baseElementType) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 * 			(update at each lifeline modification) add general ordering
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return null;
		}
		IElementType baseElementType = requestElementType;

		if (UMLElementTypes.Message_SynchEdge == baseElementType) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_AsynchEdge == baseElementType) {
			return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_ReplyEdge == baseElementType) {
			return getGEFWrapper(new Message3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_CreateEdge == baseElementType) {
			return getGEFWrapper(new Message4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_DeleteEdge == baseElementType) {
			return getGEFWrapper(new Message5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_LostEdge == baseElementType) {
			return getGEFWrapper(new Message6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_FoundEdge == baseElementType) {
			return getGEFWrapper(new Message7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Comment_AnnotatedElementEdge == baseElementType) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Constraint_ConstrainedElementEdge == baseElementType) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain
	 * model element associated with this node.
	 *
	 * @generated
	 * 			(update at each lifeline modification) add general ordering
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case MessageSyncEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReorientCommand(req));
		case MessageAsyncEditPart.VISUAL_ID:
			return getGEFWrapper(new Message2ReorientCommand(req));
		case MessageReplyEditPart.VISUAL_ID:
			return getGEFWrapper(new Message3ReorientCommand(req));
		case MessageCreateEditPart.VISUAL_ID:
			return getGEFWrapper(new Message4ReorientCommand(req));
		case MessageDeleteEditPart.VISUAL_ID:
			return getGEFWrapper(new Message5ReorientCommand(req));
		case MessageLostEditPart.VISUAL_ID:
			return getGEFWrapper(new Message6ReorientCommand(req));
		case MessageFoundEditPart.VISUAL_ID:
			return getGEFWrapper(new Message7ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 *
	 * @generated
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}
}
