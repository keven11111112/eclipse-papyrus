/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.migration;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment;

/**
 * Diagram Reconciler for compartment from 1.1.0 to 1.2.0
 */
public class SequenceReconcilerForCompartment extends ReconcilerForCompartment {

	private static final String InteractionInteractionCompartmentEditPart_VISUAL_ID = "7001";
	private static final String CombinedFragmentCombinedFragmentCompartmentEditPart_VISUAL_ID = "7004";

	/** The compartments visual id. */
	private List<String> compartmentsVisualID = Arrays.asList(
			InteractionInteractionCompartmentEditPart_VISUAL_ID,
			CombinedFragmentCombinedFragmentCompartmentEditPart_VISUAL_ID);

	/**
	 * Gets the compartments visual id.
	 *
	 * @return the compartments visual id
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment#getCompartmentsVisualID()
	 */
	@Override
	public List<String> getCompartmentsVisualID() {
		return compartmentsVisualID;
	}

}
