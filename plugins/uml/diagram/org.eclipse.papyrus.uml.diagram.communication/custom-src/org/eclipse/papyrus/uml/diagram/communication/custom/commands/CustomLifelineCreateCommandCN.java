/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.communication.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.tools.util.TypeUtils;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.CommunicationRequestConstant;
import org.eclipse.papyrus.uml.diagram.communication.edit.commands.LifelineCreateCommandCN;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Lifeline;

/**
 * Custom lifeline creation command.
 */
public class CustomLifelineCreateCommandCN extends LifelineCreateCommandCN {

	public CustomLifelineCreateCommandCN(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
	}

	/**
	 * Extend the superclass implementation to additionally set associate the new lifeline with the connectable
	 * element that it represents, if the request specifies it.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void doConfigure(Lifeline newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		super.doConfigure(newElement, monitor, info);

		ConnectableElement represents = TypeUtils.as(getRequest().getParameters().get(CommunicationRequestConstant.REPRESENTS), ConnectableElement.class);
		if (represents != null) {
			newElement.setRepresents(represents);
		}
	}
}
