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

package org.eclipse.papyrus.uml.diagram.statemachine.custom.canonical;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.ICreationTargetStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;

import com.google.common.collect.Iterators;

/**
 * Target edit part strategy for canonical view creation in state machine diagrams.
 */
public class StateMachineCanonicalCreationTargetStrategy implements ICreationTargetStrategy {

	public StateMachineCanonicalCreationTargetStrategy() {
		super();
	}

	@Override
	public EditPart getTargetEditPart(EditPart host, EObject element) {
		EditPart result = null;

		if (element instanceof Transition) {
			// Get the nearest containing shape compartment. It can create the edge view
			for (EditPart candidate = host; (result == null) && (candidate != null); candidate = candidate.getParent()) {
				if (candidate instanceof IResizableCompartmentEditPart) {
					result = candidate;
				} else {
					// TODO: Border items (e.g., connection points)
				}
			}
		} else if (element instanceof Region) {
			// Only the first region can be dropped onto a composite state or state machine's compartment.
			// Additional regions have to be dropped on a previous region because regions fill the entire
			// space of their parent compartment
			for (EditPart candidate = host; (result == null) && (candidate != null); candidate = candidate.getParent()) {
				if ((candidate instanceof StateMachineCompartmentEditPart) || (candidate instanceof StateCompartmentEditPart)) {
					Iterator<RegionCompartmentEditPart> regions = Iterators.filter(DiagramEditPartsUtil.getAllContents(candidate, false), RegionCompartmentEditPart.class);
					result = Iterators.getLast(regions, candidate);
				}
			}
		}

		return result;
	}
}
