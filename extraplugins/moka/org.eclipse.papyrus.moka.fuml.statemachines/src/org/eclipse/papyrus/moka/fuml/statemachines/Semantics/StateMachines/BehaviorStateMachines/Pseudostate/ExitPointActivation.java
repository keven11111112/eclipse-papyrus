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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ChoiceStrategy;
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

	protected List<TransitionActivation> getFireableTransitions() {
		// Determine the list of transitions originating from this pseudo-state that can be fired.
		// A transition is considered as being fireable as soon as its guard evaluates to true.
		List<TransitionActivation> fireableTransitions = new ArrayList<TransitionActivation>();
		for (int i = 0; i < this.outgoingTransitionActivations.size(); i++) {
			TransitionActivation transitionActivation = this.outgoingTransitionActivations.get(i);
			if (transitionActivation.evaluateGuard()) {
				fireableTransitions.add(transitionActivation);
			}
		}
		return fireableTransitions;
	}

	public void enter(TransitionActivation enteringTransition, RegionActivation leastCommonAncestor) {
		List<TransitionActivation> fireableTransitions = this.getFireableTransitions();
		if (this.isEnterable() && !fireableTransitions.isEmpty()) {
			ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.getExecutionLocus().factory.getStrategy("choice");
			int chosenIndex = choiceStrategy.choose(fireableTransitions.size());
			TransitionActivation selectedTransition = fireableTransitions.get(chosenIndex - 1);
			RegionActivation newLeastCommonAncestor = this.getLeastCommonAncestor(selectedTransition.getTargetActivation());
			super.enter(enteringTransition, leastCommonAncestor);
			VertexActivation vertexActivation = this.getParentState();
			if (vertexActivation != null) {
				vertexActivation.exit(enteringTransition, newLeastCommonAncestor);
			}
			selectedTransition.fire();
		}
	}
}
