package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

public class CustomExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy extends ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy {

	@Override
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateViewRequest) { 
			// for create request of expansion nodes (input & output elements, delegates to parent)
			CreateViewRequest createViewRequest = (CreateViewRequest)request;
			String semanticHint = createViewRequest.getViewDescriptors().get(0).getSemanticHint();
			if("3074".equals(semanticHint) || "3075".equals(semanticHint)) {
				return getHost().getParent();	
			}
		}
		return super.getTargetEditPart(request);
	}
	
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		// handled by CreateActionLocalConditionEditPolicy, return null
		if(CreateActionLocalConditionEditPolicy.LOCAL_CONDITION_TYPES.contains(req.getElementType())) {
			return null;
		}
		
		return super.getCreateCommand(req);
	}
}
