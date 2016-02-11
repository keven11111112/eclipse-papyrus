/*****************************************************************************
 * Copyright (c) 2011, 2016 Atos, CEA, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos) - Initial API and implementation
 *  Arthur Daussy (Atos) - 363826: [Model Explorer] Drag and drop and undo, incorrect behavior
 *  Christian W. Damus (CEA) - 404220: Add contexts for tracking objects changed by operations (CDO)
 *  Christian W. Damus (CEA) - bugs 402525, 430648, 431023, 384169
 *  Christian W. Damus - bugs 459746, 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.commands;

import org.eclipse.core.commands.operations.IOperationHistory;

/**
 * @deprecated Use the {@link org.eclipse.papyrus.infra.emf.gmf.command.NotifyingWorkspaceCommandStack} API, instead.
 */
@Deprecated
public class NotifyingWorkspaceCommandStack extends org.eclipse.papyrus.infra.emf.gmf.command.NotifyingWorkspaceCommandStack {

	/**
	 * Initializes me with the operation history to which I delegate command
	 * execution.
	 *
	 * @param history
	 *            my operation history
	 */
	public NotifyingWorkspaceCommandStack(IOperationHistory history) {
		super(history);
	}

}
