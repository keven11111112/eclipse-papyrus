/*****************************************************************************
 * Copyright (c) 2015 CEA LIST, Montages AG and others
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Michael Golubev (Montages) - initial 
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.linklf.policy.graphicalnode;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.CreateViewCommand;

/**
 * For SysML diagrams (and for inherited diagrams in general) the default
 * connection view creation command {@link CreateCommand} has to be replaced by
 * {@link CreateViewCommand}, with different implementation of the
 * CreateViewCommand#canExecute() method.
 * <p/>
 * 
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=346739 as an root case
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=477440 for a LinkLF case
 */
public class SysmlLinkLFGraphicalNodeEditPolicy extends DefaultLinksLFEditPolicy {

	/**
	 * @return {@link CreateViewCommand} with the
	 *         {@link CreateViewCommand#canExecute()} method tweaked for
	 *         inherited diagrams
	 */
	protected CreateViewCommand createCreateConnectionViewCommand(CreateConnectionViewRequest req) {
		TransactionalEditingDomain editingDomain = getHost().getEditingDomain();
		Diagram diagramView = getHost().getNotationView().getDiagram();
		CreateViewCommand createCommand = new CreateViewCommand(editingDomain, req.getConnectionViewDescriptor(),
				diagramView.getDiagram());
		return createCommand;
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

}
