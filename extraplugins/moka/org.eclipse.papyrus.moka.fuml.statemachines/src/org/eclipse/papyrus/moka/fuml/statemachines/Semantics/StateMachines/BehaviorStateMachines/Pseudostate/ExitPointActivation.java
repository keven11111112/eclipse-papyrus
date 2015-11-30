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


public class ExitPointActivation extends ConnectionPointReferenceActivation {

	public void enter(TransitionActivation enteringTransition, RegionActivation leastCommonAncestor) {
		// Exit a state through an entry point. 
		RegionActivation newLeastCommonAncestor = this.getLeastCommonAncestor(this.outgoingTransitionActivations.get(0).getTargetActivation());
		super.enter(enteringTransition, leastCommonAncestor);
		VertexActivation vertexActivation = this.getParentState();
		if(vertexActivation!=null){
			vertexActivation.exit(enteringTransition, newLeastCommonAncestor);
		}
		this.outgoingTransitionActivations.get(0).fire(); //FIXME: Just to make sure the test sequence is right
	}
}
