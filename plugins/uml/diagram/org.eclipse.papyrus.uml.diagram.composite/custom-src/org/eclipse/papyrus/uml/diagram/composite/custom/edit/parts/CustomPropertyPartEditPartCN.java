/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AllowResizeAffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;

public class CustomPropertyPartEditPartCN extends PropertyPartEditPartCN {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomPropertyPartEditPartCN(View view) {
		super(view);
		installEditPolicy(AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE, new AllowResizeAffixedNodeAlignmentEditPolicy());
	}

	@Override
	public void installEditPolicy(Object key, EditPolicy editPolicy) {
		if (AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE.equals(key)) {
			if (editPolicy instanceof AllowResizeAffixedNodeAlignmentEditPolicy)
				super.installEditPolicy(key, editPolicy);
		} else
			super.installEditPolicy(key, editPolicy);
	}

}
