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

public class FinalStateActivation extends StateActivation {

	public void enter(TransitionActivation enteringTransition, RegionActivation leastCommonAncestor) {
		// The final state completes the region in which it is located*/
		RegionActivation regionActivation = (RegionActivation) this.getParent();
		regionActivation.isCompleted = true;
		// If this region is the last of this state to complete through its final
		// state then it leads to the generation of a completion event
		if(regionActivation.getParent() instanceof StateActivation){
			 StateActivation stateActivation = (StateActivation) regionActivation.getParent();
			 if(stateActivation.hasCompleted()){
				 stateActivation.notifyCompletion();
			 }
		}
	}

}
