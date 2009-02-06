/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.clazz;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.uml2.uml.Element;

/**
 * Define a command to create a new Class Diagram.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreationCommand extends CreateGmfClassDiagramCommandHandler implements ICreationCommand {

	String diagramName = null;

	/**
	 * {@inheritDoc}
	 */
	public void createDiagram(final DiResourceSet diResourceSet, final EObject container, final String name) {
		this.diagramName = name;
		TransactionalEditingDomain transactionalEditingDomain = diResourceSet.getTransactionalEditingDomain();
		RecordingCommand command = new RecordingCommand(transactionalEditingDomain) {

			@Override
			protected void doExecute() {
				runAsTransaction(diResourceSet, (Element) container);
			}
		};
		transactionalEditingDomain.getCommandStack().execute(command);
	}

	@Override
	protected String getDiagramName() {
		return diagramName;
	}

}
