/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Pseudostate;

import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.RegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation.TransitionMetadata;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.VertexActivation;


public class ExitPointActivation extends ConnectionPointActivation {

	protected boolean isEnterable() {
		// Determine if this exit point satisfied its requirement to be exited.
		// The requirement is: all incoming transitions must have been fired once
		// if they originate from sub-states located in orthogonal regions
		int i = 0;
		boolean enterable = true;
		while (enterable && i < this.getIncomingTransitions().size()) {
			enterable = TransitionMetadata.TRAVERSED == this.getIncomingTransitions().get(i).getState();
			i++;
		}
		return enterable;
	}

	public void enter(TransitionActivation enteringTransition, RegionActivation leastCommonAncestor) {
		// Exit a state through an entry point.
		if (this.isEnterable() && !this.outgoingTransitionActivations.isEmpty()) {
			RegionActivation newLeastCommonAncestor = this.getLeastCommonAncestor(this.outgoingTransitionActivations.get(0).getTargetActivation());
			super.enter(enteringTransition, leastCommonAncestor);
			VertexActivation vertexActivation = this.getParentState();
			if (vertexActivation != null) {
				vertexActivation.exit(enteringTransition, newLeastCommonAncestor);
			}
			// FIXME: Can this transition have guards and triggers ?
			this.outgoingTransitionActivations.get(0).fire();
		}
	}
}
