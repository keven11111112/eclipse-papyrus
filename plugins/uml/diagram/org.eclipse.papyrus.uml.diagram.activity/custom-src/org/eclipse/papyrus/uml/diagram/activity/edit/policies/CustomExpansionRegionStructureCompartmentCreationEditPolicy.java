/**
 * 
 */
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;

/**
 * 
 */
public class CustomExpansionRegionStructureCompartmentCreationEditPolicy extends PapyrusCreationEditPolicy {
	
	@Override
	public boolean understandsRequest(Request request) {
		if(request instanceof CreateViewRequest) {
			String hint = ((CreateViewRequest)request).getViewDescriptors().get(0).getSemanticHint();
			if("3074".equals(hint) || "3075".equals(hint)) {
				return true;
			}
		}
		return super.understandsRequest(request);
	}
	
	@Override
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateViewRequest) {
			String hint = ((CreateViewRequest)request).getViewDescriptors().get(0).getSemanticHint();
			if("3074".equals(hint) || "3075".equals(hint)) {
				return getHost().getParent();
			}
		}
		return super.getTargetEditPart(request);
	}
	
}