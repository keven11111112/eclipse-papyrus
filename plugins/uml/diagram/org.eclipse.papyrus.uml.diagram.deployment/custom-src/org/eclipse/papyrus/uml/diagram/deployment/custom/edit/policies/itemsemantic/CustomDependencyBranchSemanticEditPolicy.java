/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.custom.edit.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;


/**
 * this class is used to forbid the creation of a dependency branch on a dependency branch.
 *
 */
public class CustomDependencyBranchSemanticEditPolicy extends DefaultSemanticEditPolicy {

	@Override
	protected Command getSemanticCommand(IEditCommandRequest request) {
		if (request instanceof CreateRelationshipRequest) {
			IElementType type = ((CreateRelationshipRequest) request).getElementType();
			if (UMLElementTypes.Dependency_BranchEdge == type) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.getSemanticCommand(request);
	}

}
