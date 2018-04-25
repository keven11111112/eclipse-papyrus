/*****************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.helper.advice;

import static org.eclipse.gmf.runtime.common.core.command.CompositeCommand.compose;

import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;

/**
 * Edit-helper advice for {@link InteractionOperand}s.
 * 
 * @since 3.1
 */
public class InteractionOperandEditHelperAdvice extends InteractionFragmentContainerEditHelperAdvice {

	/**
	 * Initializes me.
	 */
	public InteractionOperandEditHelperAdvice() {
		super();
	}

	@Override
	protected ICommand getAfterDestroyDependentsCommand(DestroyDependentsRequest request) {
		ICommand result = super.getAfterDestroyDependentsCommand(request);

		if (request.getElementToDestroy() instanceof InteractionOperand) {
			InteractionOperand operand = (InteractionOperand) request.getElementToDestroy();
			CombinedFragment cfrag = (CombinedFragment) operand.getOwner();

			// Are we deleting all of the operands of this combined fragment?
			Optional<InteractionContainerDeletionContext> context = InteractionContainerDeletionContext.get(request);

			result = compose(context.filter(ctx -> deletingAllOperands(ctx, cfrag, request))
					.map(__ -> request.getDestroyDependentCommand(cfrag))
					.orElse(null), result);
		}

		return result;
	}

	static boolean deletingAllOperands(InteractionContainerDeletionContext ctx, CombinedFragment cfrag, DestroyDependentsRequest req) {
		@SuppressWarnings("unchecked")
		Set<? extends EObject> destroying = req.getDependentElementsToDestroy();

		return cfrag.getOperands().stream().allMatch(
				operand -> ctx.isBeingDestroyed(operand) || destroying.contains(operand));
	}

}
