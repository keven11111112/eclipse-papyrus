/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.uml.diagram.activity.canonical;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.ICreationTargetStrategy;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityCNContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPartCN;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExpansionRegionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExpansionRegionStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InterruptibleActivityRegionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SequenceNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SequenceNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StructuredActivityNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.uml2.uml.ActivityEdge;

import com.google.common.collect.ImmutableMap;

/**
 * Target edit part strategy for canonical view creation in activity diagrams.
 */
public class ActivityCanonicalCreationTargetStrategy implements ICreationTargetStrategy {
	private static final Map<String, String> CONTENT_COMPARTMENT_VISUAL_IDS = ImmutableMap.<String, String> builder()
			.put(Integer.toString(ActivityEditPart.VISUAL_ID), Integer.toString(ActivityActivityContentCompartmentEditPart.VISUAL_ID))
			.put(Integer.toString(ActivityEditPartCN.VISUAL_ID), Integer.toString(ActivityCNContentCompartmentEditPart.VISUAL_ID))
			.put(Integer.toString(ConditionalNodeEditPart.VISUAL_ID), Integer.toString(ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID))
			.put(Integer.toString(ExpansionRegionEditPart.VISUAL_ID), Integer.toString(ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID))
			.put(Integer.toString(LoopNodeEditPart.VISUAL_ID), Integer.toString(LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID))
			.put(Integer.toString(SequenceNodeEditPart.VISUAL_ID), Integer.toString(SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID))
			.put(Integer.toString(StructuredActivityNodeEditPart.VISUAL_ID), Integer.toString(StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID))
			.put(Integer.toString(ActivityPartitionEditPart.VISUAL_ID), Integer.toString(ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID))
			.put(Integer.toString(InterruptibleActivityRegionEditPart.VISUAL_ID), Integer.toString(InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID)).build();

	public ActivityCanonicalCreationTargetStrategy() {
		super();
	}

	@Override
	public EditPart getTargetEditPart(EditPart host, EObject element) {
		EditPart result = null;

		// We only need to worry about activity edges (for now)
		if (element instanceof ActivityEdge) {
			// Get the nearest containing shape compartment. It can create the edge view
			for (EditPart candidate = host; (result == null) && (candidate != null); candidate = candidate.getParent()) {
				if (candidate instanceof IResizableCompartmentEditPart) {
					result = candidate;
				} else {
					// Could be a border-item (e.g., pin) on an activity-group or activity
					View view = (View) host.getModel();
					String visualID = (view == null) ? null : view.getType();
					String compartmentID = CONTENT_COMPARTMENT_VISUAL_IDS.get(visualID);
					if (compartmentID != null) {
						// Only graphical edit parts are in the map, so this cast is safe
						result = ((IGraphicalEditPart) host).getChildBySemanticHint(compartmentID);
					}
				}
			}
		}

		return result;
	}
}
