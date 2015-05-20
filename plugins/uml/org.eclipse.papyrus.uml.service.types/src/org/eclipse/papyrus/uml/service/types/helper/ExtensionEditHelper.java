package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.helper.advice.ExtensionEditHelperAdvice;

public class ExtensionEditHelper extends ElementEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean defaultApproveCreateRelationshipRequest(CreateRelationshipRequest request) {
		if (!ExtensionEditHelperAdvice.canCreate(request.getSource(), request.getTarget())) {
			return false;
		}
		return super.defaultApproveCreateRelationshipRequest(request);
	}
}
