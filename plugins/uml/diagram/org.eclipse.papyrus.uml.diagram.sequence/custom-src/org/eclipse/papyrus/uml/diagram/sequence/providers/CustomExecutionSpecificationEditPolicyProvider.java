/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling.CustomExecutionSpecificationXYLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling.CustomExecutionSpecificationCreationEditPolicy;

/**
 * The edit policy provider for the execution specifications.
 */
public class CustomExecutionSpecificationEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public boolean provides(final IOperation operation) {

		if (operation instanceof CreateEditPoliciesOperation) {
			final EditPart editPart = ((CreateEditPoliciesOperation) operation).getEditPart();
			if (editPart instanceof AbstractExecutionSpecificationEditPart) {
				return true;
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider#createEditPolicies(org.eclipse.gef.EditPart)
	 */
	@Override
	public void createEditPolicies(final EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CustomExecutionSpecificationCreationEditPolicy());
		editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, new CustomExecutionSpecificationXYLayoutEditPolicy());
	}

}
