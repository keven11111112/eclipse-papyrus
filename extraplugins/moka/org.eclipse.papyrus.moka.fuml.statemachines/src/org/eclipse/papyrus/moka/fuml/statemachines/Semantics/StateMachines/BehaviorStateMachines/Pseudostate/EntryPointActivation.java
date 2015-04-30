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

import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.VertexActivation;

public class EntryPointActivation extends ConnectionPointReferenceActivation {
	
	public void run() {
		super.run();
		/*1. Enters all parent states that are currently not active*/
		this._doEntry(this.getParentState());
		/*2. Takes the outgoing transition (will be fixed)*/
		this.outgoingTransitionActivations.get(0).fire(); //FIXME: should be delegated to transition selection strategy
	}
	
	protected void _doEntry(VertexActivation activation){
		if(activation!=null){
			if(!activation.isActive() && (activation.getParentState()==null || activation.getParentState().isActive())){
				activation.run();
			}else{
				this._doEntry(activation.getParentState());
				if(!activation.isActive()){
					activation.run();
				}
			}
		}
	}
}
