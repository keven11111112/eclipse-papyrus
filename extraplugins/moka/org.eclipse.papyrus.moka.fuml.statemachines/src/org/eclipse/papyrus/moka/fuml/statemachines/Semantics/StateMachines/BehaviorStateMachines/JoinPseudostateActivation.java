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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines;

public class JoinPseudostateActivation extends PseudostateActivation {

	public boolean isEnterable(TransitionActivation enteringTransition) {
		// Determine if all incoming transitions except this one already have been traversed
		// If this is the case then this node is ready to be entered
		boolean isReady = true;
		int i = 0;
		while (isReady && i < this.incomingTransitionActivations.size()) {
			TransitionActivation transitionActivation = this.incomingTransitionActivations.get(i);
			if (enteringTransition != transitionActivation && !transitionActivation.isTraversed()) {
				isReady = false;
			}
			i++;
		}
		return isReady;
	}

	@Override
	public void enter(TransitionActivation enteringTransition, RegionActivation leastCommonAncestor) {
		// When entered by the last incoming transition that had not already fired the Fork pseudo state
		// is allowed to continue its execution. The continuation of the execution consist in firing the
		// outgoing transition of the Join. Note that a Fork cannot have more than an outgoing transition
		// (if this is the case then the model is ill-formed).
		// The guard of the outgoing transition is evaluated to verify that the transition can be fired
		// If required parent state is entered first (the rule applies recursively)
		if (leastCommonAncestor != null && this.getParent() != leastCommonAncestor) {
			VertexActivation parentVertexActivation = this.getParentState();
			if (parentVertexActivation != null) {
				parentVertexActivation.enter(enteringTransition, leastCommonAncestor);
			}
		}
		// The Join pseudo state is entered and its outgoing transition is fired (if possible)
		super.enter(enteringTransition, leastCommonAncestor);
		if (!this.outgoingTransitionActivations.isEmpty()) {
			TransitionActivation transitionActivation = this.outgoingTransitionActivations.get(0);
			if (transitionActivation.evaluateGuard()) {
				transitionActivation.fire();
			}
		}
	}

	@Override
	public void exit(TransitionActivation exitingTransition, RegionActivation leastCommonAncestor) {
		// When the join pseudo state is exited then it also provokes the exit of all containing
		// state that not directly belong to the least common ancestor before its outgoing transition
		// fires
		super.exit(exitingTransition, leastCommonAncestor);
		if (leastCommonAncestor != null && this.getParent() != leastCommonAncestor) {
			VertexActivation parentVertexActivation = this.getParentState();
			if (parentVertexActivation != null) {
				parentVertexActivation.exit(exitingTransition, leastCommonAncestor);
			}
		}
	}
}
