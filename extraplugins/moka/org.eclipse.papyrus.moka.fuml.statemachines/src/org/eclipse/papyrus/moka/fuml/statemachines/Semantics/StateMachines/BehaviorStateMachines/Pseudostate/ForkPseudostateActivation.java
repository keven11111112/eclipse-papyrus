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

public class ForkPseudostateActivation extends PseudostateActivation {

	@Override
	public void enter(TransitionActivation enteringTransition, RegionActivation leastCommonAncestor) {
		// Fires all outgoing transitions of the for **concurrently**
		// Transitions outgoing from a fork are not guarded nor triggered
		super.enter(enteringTransition, leastCommonAncestor);
		for(int i=0; i < this.outgoingTransitionActivations.size(); i++){
			this.outgoingTransitionActivations.get(i).fire();
		}
	}
	
	@Override
	public void exit(TransitionActivation exitingTransition, RegionActivation leastCommonAncestor) {
		// A fork will only be allowed to exit when all other transitions outgoing
		//this pseudo state have already been traversed
		boolean isExitable = true;
		int i = 0;
		while(isExitable && i < this.outgoingTransitionActivations.size()){
			TransitionActivation transitionActivation = this.outgoingTransitionActivations.get(i);
			if(exitingTransition!=transitionActivation){
				isExitable =  transitionActivation.isTraversed();
			}
			i++;
		}
		if(isExitable){
			super.exit(exitingTransition, leastCommonAncestor);
		}
	}
	
}
