package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.papyrus.uml.service.types.command.CollaborationRoleCreateCommand;


public class CollaborationCollaborationRoleEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeEditContextCommand(final GetEditContextRequest request) {

		GetEditContextCommand command = new GetEditContextCommand(request);
		command.setEditContext(request.getEditHelperContext());
		return command;

	}


	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		return new CollaborationRoleCreateCommand(request);
	}
}
