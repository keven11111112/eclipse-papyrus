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

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;

public class JoinPseudostateActivation extends PseudostateActivation {

	public boolean isEnterable(TransitionActivation enteringTransition) {
		// Determine if all incoming transitions except this one already have been traversed
		// If this is the case then this node is ready to be entered
		int i = 0;
		boolean isReady = true;
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
	public void enter(TransitionActivation enteringTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		// A join pseudo-state is only allowed to bentered  if all is incoming transitions (except the one
		// currently used to perform the entry) were traversed. When the join pseudo-state is finally entered
		// is traversal is straightforward : its outgoing transition is fired.  This transition is registered
		// in the set of fireable transitions owned by this pseudo-state activation.
		super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		if (this.fireableTransitions.size() == 1) {
			this.fireableTransitions.get(0).fire(eventOccurrence);
		}
	}
}
