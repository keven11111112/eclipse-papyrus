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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ChoiceStrategy;

import org.eclipse.uml2.uml.Transition;

public class ExitPointActivation extends ConnectionPointActivation {

	public boolean isEnterable(TransitionActivation enteringTransition) {
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

	protected List<TransitionActivation> getFireableTransitions(EventOccurrence eventOccurrence) {
		// Determine the list of transitions originating from this pseudo-state that can be fired.
		// A transition is considered as being fireable as soon as its guard evaluates to true.
		List<TransitionActivation> fireableTransitions = new ArrayList<TransitionActivation>();
		for (int i = 0; i < this.outgoingTransitionActivations.size(); i++) {
			TransitionActivation transitionActivation = this.outgoingTransitionActivations.get(i);
			if (transitionActivation.evaluateGuard(eventOccurrence)) {
				fireableTransitions.add(transitionActivation);
			}
		}
		return fireableTransitions;
	}

	public boolean canPropagateExecution(TransitionActivation enteringTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		// Propagate execution through all outgoing transitions of the exit point.
		boolean propagate = false;
		int i = 0;
		while(!propagate && i < this.outgoingTransitionActivations.size()){
			propagate = this.outgoingTransitionActivations.get(i).canPropagateExecution(eventOccurrence);
			i++;
		}
		return propagate;
	}
	
	public void enter(TransitionActivation enteringTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		// When the ExitPoint is entered then the state on which it is placed is exited.
		// One outgoing transition is chosen non-deterministically in set of transition
		// that can be used to leave the ExitPoint. This transition is fired. This lead
		// to exit parent states in cascade if required.
		List<TransitionActivation> fireableTransitions = this.getFireableTransitions(eventOccurrence);
		if (!fireableTransitions.isEmpty()) {
			ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.getExecutionLocus().factory.getStrategy("choice");
			int chosenIndex = choiceStrategy.choose(fireableTransitions.size());
			TransitionActivation selectedTransition = fireableTransitions.get(chosenIndex - 1);
			RegionActivation newLeastCommonAncestor = this.getLeastCommonAncestor(selectedTransition.getTargetActivation(), ((Transition)selectedTransition.getNode()).getKind());
			super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
			VertexActivation vertexActivation = this.getParentStateActivation();
			if (vertexActivation != null) {
				vertexActivation.exit(enteringTransition, eventOccurrence, newLeastCommonAncestor);
			}
			selectedTransition.fire(eventOccurrence);
		}
	}
}
