/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.sysml.assistant.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * This class creates a "Decompose" link between requirements
 *
 */
public class DecomposeReqCommand extends RecordingCommand {
	private org.eclipse.uml2.uml.Class parent;
	private org.eclipse.uml2.uml.Class child;

	/**
	 * Makes a decomposition
	 * 
	 * @param domain
	 *            the domain to execute a transaction
	 * @param child
	 *            element that will be nested by the parent
	 * @param parent
	 *            element that will nest the child
	 * 
	 */
	public DecomposeReqCommand(TransactionalEditingDomain domain, org.eclipse.uml2.uml.Class child,
			org.eclipse.uml2.uml.Class parent) {
		super(domain, "Create a Decompositon");
		this.parent = parent;
		this.child = child;
	}

	@Override
	protected void doExecute() {
		parent.getNestedClassifiers().add(child);
	}

}
