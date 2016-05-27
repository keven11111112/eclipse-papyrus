/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.stereotype.migration;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;
import org.eclipse.papyrus.uml.diagram.common.stereotype.migration.commands.StereotypesAppliedCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.migration.commands.StereotypesMigrationCommand;
import org.eclipse.papyrus.uml.diagram.common.util.CommandUtil;

/**
 *
 */
public class StereotypeDisplayDiagramReconciler extends DiagramReconciler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICommand getReconcileCommand(final Diagram diagram) {
		CompositeCommand cc = new CompositeCommand("Migrate diagram from 1.1.0 to 1.2.0"); //$NON-NLS-1$
		TransactionalEditingDomain domain = CommandUtil.resolveEditingDomain(diagram);
		cc.add(new StereotypesAppliedCommand(domain, diagram)); 
		cc.add(new StereotypesMigrationCommand(domain, diagram)); 
		return cc;
	}
}
