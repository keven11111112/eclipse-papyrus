/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.uml2.uml.InstanceSpecification;

public class InstanceSpecificationEditHelper extends ElementEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		// Delegate to advices
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(req.getSource() instanceof InstanceSpecification) {
			// Delegate to advices
			return null;
		}
		return UnexecutableCommand.INSTANCE;
	}
}
