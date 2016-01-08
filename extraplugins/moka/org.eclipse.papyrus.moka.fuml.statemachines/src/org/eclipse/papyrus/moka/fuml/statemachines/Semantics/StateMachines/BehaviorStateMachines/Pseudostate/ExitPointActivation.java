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
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.VertexActivation;


public class ExitPointActivation extends ConnectionPointActivation {

	public boolean isReady(TransitionActivation enteringTransition) {
		// Determine if this exit point satisfied its requirement to be exited.
		// The requirement is: all incoming transitions must have been fired once
		// if they originate from sub-states located in orthogonal regions
		int i = 0;
		boolean isReady = true;
		while (isReady && i < this.incomingTransitionActivations.size()) {
			TransitionActivation transitionActivation = this.incomingTransitionActivations.get(i);
			if(enteringTransition!=transitionActivation && !transitionActivation.isTraversed()){
				isReady = false;
			}
			i++;
		}
		return isReady;
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
		// When the ExitPoint is entered then the state on which it is placed is exited.
		// One outgoing transition is chosen non-deterministically in set of transition
		// that can be used to leave the ExitPoint. This transition is fired. This lead
		// to exit and parent states in cascade if required.
		List<TransitionActivation> fireableTransitions = this.getFireableTransitions();
		if (this.isReady(enteringTransition) && !fireableTransitions.isEmpty()) {
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
