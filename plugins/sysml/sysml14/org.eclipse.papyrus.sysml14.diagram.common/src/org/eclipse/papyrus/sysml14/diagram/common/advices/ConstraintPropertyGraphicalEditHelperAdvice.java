/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.diagram.common.advices;



import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.services.edit.utils.GMFCommandUtils;
import org.eclipse.papyrus.sysml14.diagram.common.dialog.CreateOrSelectConstraintPropertyTypeDialog;
import org.eclipse.papyrus.sysml14.service.types.advice.ConstraintPropertyEditHelperAdvice;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;


/**
 * The helperadvice class used for ConstraintPropertyGraphical
 *
 */
public class ConstraintPropertyGraphicalEditHelperAdvice extends AbstractEditHelperAdvice {
	
	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		configureRequest(request);
		return super.getBeforeConfigureCommand(request);		
	}
	
	/**
	 * @param request
	 */
	private void configureRequest(ConfigureRequest request) {
		Map<String, Object> newParameters = new HashMap<String, Object>();
		
		ICommand configureCommand = null;

		Shell shell = Display.getDefault().getActiveShell();
		// Start dialog to identify the new part type
		Property part = (Property) request.getElementToConfigure();
		Package partPkg = part.getNearestPackage();

		
		CreateOrSelectConstraintPropertyTypeDialog dialog = new CreateOrSelectConstraintPropertyTypeDialog(shell, partPkg);
		dialog.open();
		if (dialog.getReturnCode() == Window.OK) {

			final ICommand typeCreationCommand = dialog.getNewTypeCreateCommand();
			final Type partType = (Type) dialog.getExistingType();

			// Abort if type creation command exists but is not executable
			if ((typeCreationCommand != null) && (!typeCreationCommand.canExecute())) {
				configureCommand = UnexecutableCommand.INSTANCE;
				// FIXME : Cancel not working throw new OperationCanceledException("Operation Cnacelled by user");
			} else {
				configureCommand = CompositeCommand.compose(configureCommand, typeCreationCommand);
			}

			// Create the configure command that will set the constraint property type
			ICommand setTypeCommand = new ConfigurePartCommand(request,partType,typeCreationCommand) ;
			configureCommand = CompositeCommand.compose(configureCommand, setTypeCommand);
			
			
		}
		newParameters.put(ConstraintPropertyEditHelperAdvice.SET_CONSTRAINT_ICOMMAND, configureCommand);
		request.addParameters(newParameters);
	}
}

class ConfigurePartCommand extends ConfigureElementCommand {


	private Type partType;
	private ICommand typeCreationCommand;

	/**
	 * Constructor.
	 *
	 * @param request
	 * @param partType
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
