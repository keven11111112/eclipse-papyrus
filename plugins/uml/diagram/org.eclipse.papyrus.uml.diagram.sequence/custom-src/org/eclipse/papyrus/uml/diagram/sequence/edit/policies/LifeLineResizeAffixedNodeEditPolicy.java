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

package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AllowResizeAffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;

/**
 * @author Céline JANSSENS
 *
 */
public class LifeLineResizeAffixedNodeEditPolicy extends AllowResizeAffixedNodeAlignmentEditPolicy {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.ConstrainedItemBorderLayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
	 *
	 * @param child
	 * @return
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child instanceof StateInvariantEditPart) {
			return new StateInvariantResizableEditPolicy();
		}
		return super.createChildEditPolicy(child);
			
	}
	
}
