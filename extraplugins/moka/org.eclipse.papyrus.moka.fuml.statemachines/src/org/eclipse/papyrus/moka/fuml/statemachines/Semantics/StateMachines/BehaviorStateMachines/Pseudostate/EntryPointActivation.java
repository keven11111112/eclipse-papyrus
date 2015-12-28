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
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.VertexActivation;

public class EntryPointActivation extends ConnectionPointActivation {
	
	public void enter(TransitionActivation enteringTransition, RegionActivation leastCommonAncestor) {
		// Enter a state through an entry point. The state on which the entry point is
		// placed can be a deeply nested state. Therefore parent state of that state must
		// be entered before if it is not already the case.
		super.enter(enteringTransition, leastCommonAncestor);
		VertexActivation vertexActivation = this.getParentState();
		if(vertexActivation!=null){
			vertexActivation.enter(enteringTransition, leastCommonAncestor);
		}
		// Fire all transitions originating from the entry point. These transitions
		// are fired under the condition that the guard is true. 
		for(int i = 0; i < this.getOutgoingTransitions().size(); i++){
			TransitionActivation transitionActivation = this.getOutgoingTransitions().get(i);
			if(transitionActivation.evaluateGuard()){
				transitionActivation.fire();
			}
		}
	}
}
