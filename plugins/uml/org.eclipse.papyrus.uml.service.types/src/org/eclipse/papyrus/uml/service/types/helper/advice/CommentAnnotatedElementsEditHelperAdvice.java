package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.CommentAnnotatedElementsCreateCommand;
import org.eclipse.papyrus.uml.service.types.command.CommentAnnotatedElementsReorientCommand;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

public class CommentAnnotatedElementsEditHelperAdvice extends AbstractEditHelperAdvice {


	@Override
	protected ICommand getBeforeReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest request) {
		return new CommentAnnotatedElementsReorientCommand(request);
	}

	protected boolean canCreate(EObject source, EObject target) {

		if ((source != null) && !(source instanceof Comment)) {
			return false;
		}

		if ((target != null) && !(target instanceof Element)) {
			return false;
		}

		return true;
	}


	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		EObject source = request.getSource();
		EObject target = request.getTarget();

		boolean noSourceOrTarget = (source == null || target == null);
		boolean noSourceAndTarget = (source == null && target == null);

		if (!noSourceAndTarget && !canCreate(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}

		if (noSourceOrTarget && !noSourceAndTarget) {
			// The request isn't complete yet. Return the identity command so
			// that the create relationship gesture is enabled.
			return IdentityCommand.INSTANCE;
		}

		return new CommentAnnotatedElementsCreateCommand(request);
	}
}
