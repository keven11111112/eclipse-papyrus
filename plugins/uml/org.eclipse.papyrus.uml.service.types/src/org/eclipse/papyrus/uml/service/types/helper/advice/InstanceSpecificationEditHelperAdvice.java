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
import org.eclipse.papyrus.uml.service.types.command.InstanceSpecificationLinkCreateCommand;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
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
		return ((InstanceSpecification) source).getClassifiers().size() > 0 && ((InstanceSpecification) target).getClassifiers().size() > 0;
	}

	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		List<ISpecializationType> subs = Arrays.asList(ElementTypeRegistry.getInstance().getSpecializationsOf(UMLElementTypes.INSTANCE_SPECIFICATION.getId()));
		if (!subs.contains(request.getElementType())) {
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
		return new InstanceSpecificationLinkCreateCommand(request);
	}
}
