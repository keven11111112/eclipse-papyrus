/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.propertylifecycle.processors;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.propertylifecycle.utils.CommandValueProcessor;
import org.eclipse.uml2.uml.Dependency;

/**
 *
 */
public class RoleBindingProcessor implements CommandValueProcessor {

	@Override
	public ICommand setValueFromRequest(String featureLabel, boolean isImmutable, AbstractEditCommandRequest request) {
		return setName(request);
	}

	public RoleBindingProcessor() {

	}

	public ICommand setName(final AbstractEditCommandRequest request) {
		if (!(request instanceof CreateRelationshipRequest)) {
		}

		CreateRelationshipRequest relRequest = (CreateRelationshipRequest) request;

		Dependency dependency = (Dependency) (relRequest).getNewElement();
		// NamedElement target = (NamedElement) request.getTarget();
		// ConnectableElement roleToBind = (ConnectableElement) dialog.getFirstResult();
		// // Create a Dependency (the binding) between selected role and a ConnectableElement (the target)
		// dependency.setName("binding_" + roleToBind.getName() + "_" + target.getName());


		return null;
	}

}
