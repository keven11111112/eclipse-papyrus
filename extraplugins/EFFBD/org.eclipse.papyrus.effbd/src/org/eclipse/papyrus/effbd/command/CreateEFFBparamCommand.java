/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier(CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.effbd.command;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ParameterDirectionKind;

public class CreateEFFBparamCommand extends RecordingCommand {
	protected ActivityParameterNode activityParameterNode;
	protected ParameterDirectionKind direction;

	public CreateEFFBparamCommand(TransactionalEditingDomain domain, ActivityParameterNode activityParameterNode, ParameterDirectionKind direction) {
		super(domain);
		this.activityParameterNode = activityParameterNode;
		this.direction = direction;
	}

	@Override
	protected void doExecute() {
		Activity activity = activityParameterNode.getActivity();
		org.eclipse.uml2.uml.Parameter parameter = activity.createOwnedParameter(direction.getLiteral(), null);
		parameter.setDirection(this.direction);
		activityParameterNode.setParameter(parameter);
		activityParameterNode.setName(direction.getLiteral());

	}

}
