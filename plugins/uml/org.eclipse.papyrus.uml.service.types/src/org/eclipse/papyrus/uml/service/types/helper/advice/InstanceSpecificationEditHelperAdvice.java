package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.InstanceSpecificationLinkCreateCommand;
import org.eclipse.uml2.uml.InstanceSpecification;

public class InstanceSpecificationEditHelperAdvice extends AbstractEditHelperAdvice {

	public static boolean canCreate(EObject source, EObject target) {
		/*
		 * Case 0: Only the target is null
		 */
		if (source != null && target == null) {
			return source instanceof InstanceSpecification && ((InstanceSpecification) source).getClassifiers().size() > 0;
		}
		/*
		 * Case 1 : source and target != null
		 * look for if it exist at least a common association between classifiers referenced between these instances
		 */
		if (source == null || target == null) {
			return false;
		}
		if (false == source instanceof InstanceSpecification) {
			return false;
		}
		if (false == target instanceof InstanceSpecification) {
			return false;
		}
		return true;
	}
	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
	InstanceSpecification linkToEdit=null;
	InstanceSpecification source=null;
	InstanceSpecification target=null;
	if(request.getElementToConfigure() instanceof InstanceSpecification){
		linkToEdit=(InstanceSpecification)(request.getElementToConfigure());
	}
	if(request.getParameter(CreateRelationshipRequest.SOURCE)instanceof InstanceSpecification){
		source=(InstanceSpecification)request.getParameter(CreateRelationshipRequest.SOURCE);
	}
	if(request.getParameter(CreateRelationshipRequest.TARGET)instanceof InstanceSpecification){
		target=(InstanceSpecification)request.getParameter(CreateRelationshipRequest.TARGET);
	}
	if( source!=null && target!= null && linkToEdit !=null){
		return new InstanceSpecificationLinkCreateCommand(request);
	}
		return super.getAfterConfigureCommand(request);
	}


}
