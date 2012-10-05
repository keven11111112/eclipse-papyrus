/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.commands;

import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.util.CreateCommandUtil;
import org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateCallOperationActionDialog;
import org.eclipse.papyrus.uml.diagram.activity.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IFeatureSetterAspectAction.IFeatureSetterAspectActionUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class CallOperationActionCreateCommand extends  ActivityNodeCreateCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public CallOperationActionCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static CallOperationActionCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new CallOperationActionCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public CallOperationActionCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * @generated NOT check that there is a correct model container.
	 */
	public boolean canExecute() {
		//check that there is a correct model container
		return CreateCommandUtil.canCreateNode(getRequest(), getElementToEdit());
	}

	/**
	 * @generated NOT use the initialization popup, set appropriate parents
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// get the activity containing the new element
		Activity parentActivity = null;
		EObject parent = getElementToEdit();
		while(parent != null && parentActivity == null) {
			if(parent instanceof Activity) {
				parentActivity = (Activity)parent;
			}
			parent = parent.eContainer();
		}
		CallOperationAction newElement = UMLFactory.eINSTANCE.createCallOperationAction();
		if(isOperationAlreadyManaged()) {
			CreateCallOperationActionDialog dialog = new CreateCallOperationActionDialog(Display.getDefault().getActiveShell(), parentActivity,newElement);
			getRequest();
			if(IDialogConstants.OK_ID == dialog.open()) {
				// initialize the invoked element (no need to use a command, since action is being created)
				EObject operation = dialog.getSelectedInvoked();
				if(operation instanceof Operation) {
					newElement.setOperation((Operation)operation);
				}
				// initialize synchronous
				newElement.setIsSynchronous(dialog.getIsSynchronous());
			} else {
				return CommandResult.newCancelledCommandResult();
			}
		}
		initAndExecuteEmfCommand(newElement);
		//		Activity owner = (Activity)getElementToEdit();
		//		owner.getNodes().add(newElement);
		ElementInitializers.getInstance().init_CallOperationAction_3010(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	private boolean isOperationAlreadyManaged() {
		IEditCommandRequest aRequest = getRequest();
		Map map = aRequest.getParameters();
		return !IFeatureSetterAspectActionUtil.areFeaturesManaged(getRequest(), UMLPackage.Literals.CALL_OPERATION_ACTION__OPERATION);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(CallOperationAction newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}
}
