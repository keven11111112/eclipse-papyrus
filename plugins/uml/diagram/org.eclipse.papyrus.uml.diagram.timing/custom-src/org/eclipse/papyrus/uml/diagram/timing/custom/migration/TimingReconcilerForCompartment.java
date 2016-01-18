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
package org.eclipse.papyrus.uml.diagram.timing.custom.migration;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineTimeRulerCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FreeTimeRulerCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineStateDefinitionCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimeRulerCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.LinearTimeRulerCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeRulerCompartmentEditPartCN;

/**
 * Diagram Reconciler for compartment from 1.1.0 to 1.2.0
 */
public class TimingReconcilerForCompartment extends ReconcilerForCompartment {

	/** The compartments visual id. */
	private List<String> compartmentsVisualID = Arrays.asList(
			InteractionCompartmentEditPartTN.VISUAL_ID,
			FullLifelineStateDefinitionCompartmentEditPartCN.VISUAL_ID,
			FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID,
			CompactLifelineCompartmentEditPartCN.VISUAL_ID,
			TimeRulerCompartmentEditPartCN.VISUAL_ID,
			FullLifelineTimeRulerCompartmentEditPartCN.VISUAL_ID,
			CompactLifelineTimeRulerCompartmentEditPartCN.VISUAL_ID,
			FreeTimeRulerCompartmentEditPart.VISUAL_ID,
			LinearTimeRulerCompartmentEditPart.VISUAL_ID);

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
