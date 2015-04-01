/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.creation;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.widgets.creation.IAtomicOperationExecutor;

/**
 * Executes Atomic Operations in the CommandStack of the TransactionalEditingDomain
 */
public class EMFAtomicOperationExecutor extends IAtomicOperationExecutor.Default {

	private final TransactionalEditingDomain domain;

	public EMFAtomicOperationExecutor(TransactionalEditingDomain domain) {
		this.domain = domain;
	}

	@Override
	public void execute(final Runnable operation, String label) {
		domain.getCommandStack().execute(new RecordingCommand(domain, label) {

			@Override
			protected void doExecute() {
				operation.run();
			}
		});
	}
}