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

public class EntryPointActivation extends ConnectionPointActivation {
	
	public boolean isExitable(TransitionActivation exitingTransition) {
		// An entry point can be exited as soon as every outgoing transition expect
		// the current "exitingTransition" have been traversed.
		int i = 0;
		boolean isExitable = true;
		while(isExitable && i < this.outgoingTransitionActivations.size()){
			TransitionActivation transitionActivation = this.outgoingTransitionActivations.get(i);
			if(transitionActivation != exitingTransition){
				isExitable = transitionActivation.isTraversed();
			}
			i++;
		}
		return isExitable;
	}
	
	public void enter(TransitionActivation enteringTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		// Enter a state through an entry point. The state on which the entry point is
		// placed can be a deeply nested state. Therefore parent state of that state must
		// be entered before if it is not already the case.
		super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		VertexActivation vertexActivation = this.getParentState();
		if(vertexActivation!=null){
			vertexActivation.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		}
		// Fire all transitions originating from the entry point. These transitions
		// are fired under the condition that the guard is true. 
		for(int i = 0; i < this.getOutgoingTransitions().size(); i++){
			TransitionActivation transitionActivation = this.getOutgoingTransitions().get(i);
			if(transitionActivation.evaluateGuard(eventOccurrence)){
				transitionActivation.fire(eventOccurrence);
			}
		}
	}
}
