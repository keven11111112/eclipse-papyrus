package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.NamespaceOwnedMemberCreateCommand;
import org.eclipse.papyrus.uml.service.types.command.NamespaceOwnedMemberReorientCommand;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

public class NamespaceOwnedMemberEditHelperAdvice extends AbstractEditHelperAdvice {

	protected boolean canCreate(EObject source, EObject target) {
		if ((source != null) && !(source instanceof org.eclipse.uml2.uml.Namespace)) {
			return false;
		}

		if ((target != null) && !(target instanceof org.eclipse.uml2.uml.Namespace)) {
			return false;
		}

		return true;
	}

	@Override
	protected ICommand getBeforeReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest request) {
		return new NamespaceOwnedMemberReorientCommand(request);
	}

	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		// Be careful, This advice is binded to Namespace elementtype directly
		List<ISpecializationType> subs = Arrays.asList(ElementTypeRegistry.getInstance().getSpecializationsOf(UMLElementTypes.NAMESPACE_OWNEDMEMBER.getId()));
		if (!subs.contains(request.getElementType()))
		{
			return IdentityCommand.INSTANCE;
		}

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
		return new NamespaceOwnedMemberCreateCommand(request);
	}
}