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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomCommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomContextLinkCreateCommand;
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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.ConstraintItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomConstraintItemSemanticEditPolicy extends ConstraintItemSemanticEditPolicy {

	/**
	 * @Override
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(true);
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			List<EObject> todestroy = new ArrayList<EObject>();
			todestroy.add(req.getElementToDestroy());
			// cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));
			cmd.add(new EMFtoGMFCommandWrapper(new org.eclipse.emf.edit.command.DeleteCommand(getEditingDomain(), todestroy)));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
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
	 * @Override
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_SynchEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_AsynchEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_ReplyEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_CreateEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_DeleteEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_LostEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_FoundEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Comment_AnnotatedElementEdge == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.Constraint_ConstrainedElementEdge == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Constraint_ContextEdge == req.getElementType()) {
			return getGEFWrapper(new CustomContextLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @Override
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_SynchEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_AsynchEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_ReplyEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_CreateEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_DeleteEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_LostEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_FoundEdge == req.getElementType()) {
			return getGEFWrapper(new CustomMessage7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Comment_AnnotatedElementEdge == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Constraint_ConstrainedElementEdge == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Constraint_ContextEdge == req.getElementType()) {
			return getGEFWrapper(new CustomContextLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
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
