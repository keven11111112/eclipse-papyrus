/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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

import java.util.Iterator;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.uml2.uml.State;

public abstract class HistoryActivation extends PseudostateActivation {

	@Override
	public void enter(TransitionActivation enteringTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		// Enclosing states need to be entered before the restoration process start are entered.
		// Then the restoration process start with the region containing the history that
		// is targeted by the entering transition. Finally if needed, the deep history is exited.
		// Situation in which the deep history need to be exited is when the region containing
		// the history node has already been executed.
		super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		StateActivation parentStateActivation = null;
		VertexActivation parentVertexActivation = this.getParentState();
		if(parentVertexActivation != null){
			parentStateActivation = (StateActivation) parentVertexActivation;
			parentStateActivation.status = StateMetadata.ACTIVE;
		}
		if (leastCommonAncestor != null && parentVertexActivation != null && parentVertexActivation.getParent() != leastCommonAncestor) {
			parentVertexActivation = this.getParentState();
			if (parentVertexActivation != null) {
				parentVertexActivation.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
			}
		}
		if(parentStateActivation != null){
			this.restore(parentStateActivation, enteringTransition, eventOccurrence);
		}
		if(this.isActive()){
			this.exit(null, null, null);
		}
	}
	
	public void restore(StateActivation stateActivation, TransitionActivation enteringTransition, EventOccurrence eventOccurrence){
		// Restore the state. Restoring a state consists in :
		// 1. Registering the state to the state-machine configuration
		// 2. Complete the state if needs to be completed
		// 3. If the state cannot be completed then execute its entry and its doActivity. Finally,
		//    if it has regions then these regions are restored (in paralell).
		State state = (State) stateActivation.getNode();
		stateActivation.status = StateMetadata.ACTIVE;
		StateMachineExecution smExecution = (StateMachineExecution)this.getStateMachineExecution();
		smExecution.getConfiguration().register(stateActivation);
		stateActivation.isEntryCompleted = state.getEntry() == null;
		stateActivation.isDoActivityCompleted = state.getDoActivity() == null;
		stateActivation.isExitCompleted = state.getExit() == null;
		if(stateActivation.hasCompleted()){
			stateActivation.notifyCompletion();
		}else{
			stateActivation.tryExecuteEntry(eventOccurrence);
			stateActivation.tryInvokeDoActivity(eventOccurrence);
			for(Iterator<RegionActivation> regionActivationsIterator = stateActivation.regionActivation.iterator(); regionActivationsIterator.hasNext();){
				this.restore(regionActivationsIterator.next(), enteringTransition, eventOccurrence);
			}
		}
	}
	
	public abstract void restore(RegionActivation regionActivation, TransitionActivation enteringTransition, EventOccurrence eventOccurrence);
	
}
