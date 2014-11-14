package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.CommentAnnotatedElementsCreateCommand;
import org.eclipse.papyrus.uml.service.types.command.CommentAnnotatedElementsReorientCommand;

public class CommentAnnotatedElementsEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest request) {
		return new CommentAnnotatedElementsReorientCommand(request);
	}

	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		return new CommentAnnotatedElementsCreateCommand(request);
	}
}
