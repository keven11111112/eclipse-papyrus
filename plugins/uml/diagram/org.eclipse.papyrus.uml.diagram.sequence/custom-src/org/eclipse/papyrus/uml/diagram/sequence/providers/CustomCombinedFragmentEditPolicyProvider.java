/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.SideAffixedNodesCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;

/**
 * @author Celine JANSSENS
 *
 */
public class CustomCombinedFragmentEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 *
	 * @param operation
	 * @return
	 */
	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			final EditPart editPart = ((CreateEditPoliciesOperation) operation).getEditPart();
			if (editPart instanceof CombinedFragmentEditPart) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider#createEditPolicies(org.eclipse.gef.EditPart)
	 *
	 * @param editPart
	 */
	@Override
	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new SideAffixedNodesCreationEditPolicy());


	}

}
