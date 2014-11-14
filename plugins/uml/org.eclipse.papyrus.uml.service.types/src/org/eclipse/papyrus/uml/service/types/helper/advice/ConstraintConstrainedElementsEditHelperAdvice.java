package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.ConstraintConstrainedElementsCreateCommand;
import org.eclipse.papyrus.uml.service.types.command.ConstraintConstrainedElementsReorientCommand;

public class ConstraintConstrainedElementsEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest request) {
		return new ConstraintConstrainedElementsReorientCommand(request);
	}

	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		return new ConstraintConstrainedElementsCreateCommand(request);
	}
}
