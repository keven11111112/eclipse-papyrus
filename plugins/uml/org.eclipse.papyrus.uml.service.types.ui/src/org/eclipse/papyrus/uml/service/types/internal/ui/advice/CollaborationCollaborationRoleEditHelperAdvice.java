package org.eclipse.papyrus.uml.service.types.internal.ui.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.service.types.internal.ui.commands.CollaborationRoleCreateCommand;


public class CollaborationCollaborationRoleEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		return new CollaborationRoleCreateCommand(request);
	}
}
