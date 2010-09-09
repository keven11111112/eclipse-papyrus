/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.clazz.custom.command.BranchDependenctReorientCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationReorientCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CustomAssociationBranchReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClass2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.policies.SignalItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * this a specialization to manage creation of association and associationClass
 */
public class CustomSignalItemSemanticEditPolicy extends SignalItemSemanticEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case AssociationClass2EditPart.VISUAL_ID:
			return getGEFWrapper(new CAssociationReorientCommand(req));
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new CAssociationReorientCommand(req));
		case DependencyBranchEditPart.VISUAL_ID:
			return getGEFWrapper(new BranchDependenctReorientCommand(req));
		case AssociationBranchEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomAssociationBranchReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		//forbid creation of association branch from it.
		if(UMLElementTypes.Association_4019 == req.getElementType()) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getStartCreateRelationshipCommand(req);
	}
}
