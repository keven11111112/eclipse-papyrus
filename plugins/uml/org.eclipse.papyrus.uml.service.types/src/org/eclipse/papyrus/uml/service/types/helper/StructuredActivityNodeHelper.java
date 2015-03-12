/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.UMLPackage;

public class StructuredActivityNodeHelper extends ActivityNodeHelper {

	@Override
	protected ICommand getCreateCommand(CreateElementRequest req) {
		CreateElementRequest createRequest = isStructuredNode(req.getElementType()) ? createStructuredNodeRequest(req) : req;
		return super.getCreateCommand(createRequest);
	}
	
	protected CreateElementRequest createStructuredNodeRequest(CreateElementRequest baseReq) {
		CreateElementRequest req = new CreateElementRequest(baseReq.getEditingDomain(), baseReq.getContainer(), baseReq.getElementType());
		req.addParameters(baseReq.getParameters());
		req.setContainmentFeature(UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
		return req;
	}
	
	protected boolean isStructuredNode(IElementType type) {
		return type.getEClass() != null && UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(type.getEClass());
	}
}
