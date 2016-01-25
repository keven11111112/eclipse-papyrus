package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.Behaviors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ArrivalSignal;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ObjectActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.CompletionEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.DeferredEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateActivation;

public class SM_ObjectActivation extends ObjectActivation {

	// Events that have been dispatched but that are actually deferred are placed
	// in this particular event pool. When the state that constrained them to be
	// placed in this pool leaves the state-machine configuration then the deferred
	// events leave this pool and are placed in the regular event pool (to be dispatched
	// again) that is handled by the object activation.
	public List<DeferredEventOccurrence> deferredEventPool;
	
	public SM_ObjectActivation(){
		super();
		this.deferredEventPool = new ArrayList<DeferredEventOccurrence>();
	}
	
	public void registerCompletionEvent(StateActivation stateActivation){
		// A completion event does not have priority over other completion events.
		// Therefore if completion events are already in the event pool then the currently
		// posted completion event will be placed after these latter. In short the FIFO strategy
		// is applied to completion events.
		CompletionEventOccurrence completionEventOccurrence = new CompletionEventOccurrence();
		completionEventOccurrence.stateActivation = stateActivation;
		int insertionIndex = 0;
		boolean insertionPointFound = false;
		while(!insertionPointFound && insertionIndex < this.eventPool.size()){
			insertionPointFound = !(this.eventPool.get(insertionIndex) instanceof CompletionEventOccurrence);
			if(!insertionPointFound){
				insertionIndex++;
			}
		}
		this.eventPool.add(insertionIndex, completionEventOccurrence);
		this._send(new ArrivalSignal());
	}
}
