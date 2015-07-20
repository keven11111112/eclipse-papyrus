/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.sysml14.diagram.common.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.infra.services.edit.utils.GMFCommandUtils;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * Configure a part with the created/selected type
 */
public class ConfigurePartCommand extends ConfigureElementCommand {


	private Type partType;
	private ICommand typeCreationCommand;


	/**
	 * Constructor.
	 *
	 * @param request configuration request
	 * @param partType the featuring type of the part
	 * @param typeCreationCommand if needed create the type
	 */
	public ConfigurePartCommand(ConfigureRequest request, Type partType, ICommand typeCreationCommand) {
		super(request);
		this.partType= partType;
		this.typeCreationCommand = typeCreationCommand;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		Property part = (Property) getElementToEdit();
		if (partType != null) {
			part.setType(partType);
		} else {
			Type newType = (Type) GMFCommandUtils.getCommandEObjectResult(typeCreationCommand);
			part.setType(newType);
		}
		return CommandResult.newOKCommandResult(part);
	}
}
