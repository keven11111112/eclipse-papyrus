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
package org.eclipse.papyrus.uml.diagram.activity.migration;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityParametersCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityPostConditionsCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityPreConditionsCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityCNContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityCNParametersCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityCNPostConditionsCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityCNPreConditionsCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExpansionRegionStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SequenceNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;

/**
 * Class Diagram Reconciler for compartment from 1.1.0 to 1.2.0
 */
public class ActivityReconcilerForCompartment extends ReconcilerForCompartment {

	/** The compartments visual id. */
	private List<String> compartmentsVisualID = Arrays.asList(
			ActivityActivityParametersCompartmentEditPart.VISUAL_ID,
			ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID,
			ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID,
			ActivityActivityContentCompartmentEditPart.VISUAL_ID,
			ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID,
			ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID,
			LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID,
			SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID,
			StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID,
			ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID,
			InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID,
			ActivityCNParametersCompartmentEditPart.VISUAL_ID,
			ActivityCNPreConditionsCompartmentEditPart.VISUAL_ID,
			ActivityCNPostConditionsCompartmentEditPart.VISUAL_ID,
			ActivityCNContentCompartmentEditPart.VISUAL_ID);

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
