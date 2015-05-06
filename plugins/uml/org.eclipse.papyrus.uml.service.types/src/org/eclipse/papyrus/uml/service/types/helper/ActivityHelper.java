/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.papyrus.uml.service.types.command.NotContainmentMoveCommand;
import org.eclipse.uml2.uml.UMLPackage;


public class ActivityHelper extends ElementEditHelper {

	@Override
	protected ICommand getMoveCommand(MoveRequest req) {
		return new NotContainmentMoveCommand(req);
	}
	
	@Override
	protected ICommand getCreateCommand(CreateElementRequest req) {
		CreateElementRequest request;
		boolean isObjectNode = isObjectNode(req.getElementType());
		if (isObjectNode) {
			request = createObjectNodeRequest(req);
		} else {
			boolean isStructureNode = isStructuredNode(req.getElementType());
			if (isStructureNode) {
				request = createStructuredNodeRequest(req);
			} else {
				request = req;
			}
		}
		return super.getCreateCommand(request);
	}
	
	/**
	 * @param elementType
	 * @return
	 */
	private CreateElementRequest createObjectNodeRequest(CreateElementRequest baseReq) {
		CreateElementRequest req = new CreateElementRequest(baseReq.getEditingDomain(), baseReq.getContainer(), baseReq.getElementType());
		req.addParameters(baseReq.getParameters());
		req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_OwnedNode());
		return req;
	}

	/**
	 * @param elementType
	 * @return
	 */
	protected boolean isObjectNode(IElementType type) {
		return type.getEClass() != null && UMLPackage.eINSTANCE.getObjectNode().isSuperTypeOf(type.getEClass());
	}

	protected CreateElementRequest createStructuredNodeRequest(CreateElementRequest baseReq) {
		CreateElementRequest req = new CreateElementRequest(baseReq.getEditingDomain(), baseReq.getContainer(), baseReq.getElementType());
		req.addParameters(baseReq.getParameters());
		req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_StructuredNode());
		return req;
	}
	
	protected boolean isStructuredNode(IElementType type) {
		return type.getEClass() != null && UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(type.getEClass());
	}
	
//	{
//		getDefaultContainmentFeatures().put(UMLPackage.eINSTANCE.getCentralBufferNode(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
//	}
//	
//	@Override
//	protected ICommand getCreateCommand(CreateElementRequest req) {
//		return super.getCreateCommand(req);
//		// return new CreateActivityNode(req);
//	}
//	
//	
//	/**
//	 * this inner class is used to call specific command of UML 
//	 *
//	 */
//	private class CreateActivityNode extends CreateElementCommand{
//
//		protected Command emfcmd=null;
//		public CreateActivityNode(CreateElementRequest request) {
//			super(request);
//		}
//		 @Override
//		protected EObject doDefaultElementCreation() {
//			 EObject result = null;
//				EReference containment = getContainmentFeature();
//				EClass eClass = getElementType().getEClass();
//
//				if (containment != null) {
//					EObject element = getElementToEdit();
//					if (element != null) {
//						result = eClass.getEPackage().getEFactoryInstance().create(eClass);
//						//Command cmd=new CreateChildCommand(getRequest().getEditingDomain(), element,  UMLPackage.eINSTANCE.getActivity_OwnedNode(), UMLFactory.eINSTANCE.createOpaqueAction(), Collections.EMPTY_LIST);
//						emfcmd= new CreateChildCommand(getRequest().getEditingDomain(),element,  containment, result, Collections.EMPTY_LIST);
//						emfcmd.canExecute();
//						emfcmd.execute();
//						if(!emfcmd.getResult().isEmpty()){
//						result=(EObject)emfcmd.getResult().toArray()[0];
//						}
//					}
//				}
//
//				IStatus status = (result != null) ? Status.OK_STATUS
//						: new Status(
//								Status.ERROR,
//								EMFTypePlugin.getPluginId(),
//								EMFTypeCoreMessages
//										.bind(
//												EMFTypeCoreMessages.createElementCommand_noElementCreated,
//												getElementType().getDisplayName()));
//				
//				setDefaultElementCreationStatus(status);
//				
//				return result;
//		}
//		 @Override
//		protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
//			emfcmd.undo();
//			return super.doUndo(monitor, info);
//		}
//		 
//		 @Override
//		protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
//			
//			IStatus status= super.doRedo(monitor, info);
//			 emfcmd.redo();
//			return status;
//		}
//	}
//	
//	
}
