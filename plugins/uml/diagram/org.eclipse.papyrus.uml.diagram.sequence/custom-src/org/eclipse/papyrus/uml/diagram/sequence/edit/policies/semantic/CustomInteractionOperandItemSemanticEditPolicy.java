/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomCombinedFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomCommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomConsiderIgnoreFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomContinuationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomInteractionUseCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage2CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage2ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage3CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage3ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage4CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage4ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage5CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage5ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage6CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage6ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage7CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage7ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessageCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessageReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContextLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionOperandItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.OperandBoundsComputeHelper;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionOperandItemSemanticEditPolicy extends InteractionOperandItemSemanticEditPolicy {

	/**
	 * @Override
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.InteractionUse_Shape == req.getElementType()) {
			return getGEFWrapper(new CustomInteractionUseCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.ConsiderIgnoreFragment_Shape == req.getElementType()) {
			return getGEFWrapper(new CustomConsiderIgnoreFragmentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.CombinedFragment_Shape == req.getElementType()) {
			return getGEFWrapper(new CustomCombinedFragmentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Continuation_Shape == req.getElementType()) {
			return getGEFWrapper(new CustomContinuationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.InteractionOperand_Shape == req.getElementType()) {
			// delegate to parent
			return UnexecutableCommand.INSTANCE;
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @Override
	 */
	@Override
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest) request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if (connectionEditPart instanceof ContextLinkEditPart) {
				return super.getCommand(request);
			}
		}
		if (request instanceof ReconnectRequest) {
			EditPart combinedFragment = getHost().getParent().getParent();
			((ReconnectRequest) request).setTargetEditPart(combinedFragment);
			return combinedFragment.getCommand(request);
		}
		return super.getCommand(request);
	}

	/**
	 * @Override
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
		if (provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);
			if (deleteCommand != null) {
				if (deleteCommand instanceof ICompositeCommand) {
					OperandBoundsComputeHelper.addUpdateBoundsCommandForOperandDelelete(this.getHost(), (ICompositeCommand) deleteCommand);
				}
				return new ICommandProxy(deleteCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @Override
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @Override redirect message creation to CF
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_SynchEdge == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart) combinedFragmentPart).resolveSemanticElement();
			if (((IGraphicalEditPart) getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new CustomMessageCreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;// return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_AsynchEdge == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart) combinedFragmentPart).resolveSemanticElement();
			if (((IGraphicalEditPart) getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new CustomMessage2CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;// return getGEFWrapper(new CustomMessage2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_ReplyEdge == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart) combinedFragmentPart).resolveSemanticElement();
			if (((IGraphicalEditPart) getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new CustomMessage3CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;// return getGEFWrapper(new CustomMessage3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_CreateEdge == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart) combinedFragmentPart).resolveSemanticElement();
			if (((IGraphicalEditPart) getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new CustomMessage4CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;// return getGEFWrapper(new CustomMessage4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_DeleteEdge == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart) combinedFragmentPart).resolveSemanticElement();
			if (((IGraphicalEditPart) getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new CustomMessage5CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;// return getGEFWrapper(new CustomMessage5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_LostEdge == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart) combinedFragmentPart).resolveSemanticElement();
			if (((IGraphicalEditPart) getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new CustomMessage6CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;// return getGEFWrapper(new CustomMessage6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_FoundEdge == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart) combinedFragmentPart).resolveSemanticElement();
			if (((IGraphicalEditPart) getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new CustomMessage7CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;// return getGEFWrapper(new CustomMessage7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Comment_AnnotatedElementEdge == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.Constraint_ConstrainedElementEdge == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @Override let InteractionOperandLayoutEditPolicy redirect messages
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_SynchEdge == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;// return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_AsynchEdge == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;// return getGEFWrapper(new CustomMessage2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_ReplyEdge == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;// return getGEFWrapper(new CustomMessage3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_CreateEdge == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;// return getGEFWrapper(new CustomMessage4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_DeleteEdge == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;// return getGEFWrapper(new CustomMessage5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_LostEdge == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;// return getGEFWrapper(new CustomMessage6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_FoundEdge == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;// return getGEFWrapper(new CustomMessage7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Comment_AnnotatedElementEdge == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Constraint_ConstrainedElementEdge == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain
	 * model element associated with this node.
	 *
	 * @Override
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case MessageSyncEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessageReorientCommand(req));
		case MessageAsyncEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage2ReorientCommand(req));
		case MessageReplyEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage3ReorientCommand(req));
		case MessageCreateEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage4ReorientCommand(req));
		case MessageDeleteEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage5ReorientCommand(req));
		case MessageLostEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage6ReorientCommand(req));
		case MessageFoundEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage7ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 *
	 * @Override
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomCommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}
}
