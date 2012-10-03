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


import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.util.CreateCommandUtil;
import org.eclipse.papyrus.uml.diagram.activity.providers.ElementInitializers;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated NOT
 */
public class OpaqueActionCreateCommand extends ActivityNodeCreateCommand {

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
	public OpaqueActionCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static OpaqueActionCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new OpaqueActionCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public OpaqueActionCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}
	
	/**
	 * @generated NOT  set appropriate parents
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		OpaqueAction newElement =UMLFactory.eINSTANCE.createOpaqueAction();
		InitAndExecuteEmfCommand(newElement);
		ElementInitializers.getInstance().init_OpaqueAction_3007(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
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
	 * @generated
	 */
	protected void doConfigure(OpaqueAction newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
