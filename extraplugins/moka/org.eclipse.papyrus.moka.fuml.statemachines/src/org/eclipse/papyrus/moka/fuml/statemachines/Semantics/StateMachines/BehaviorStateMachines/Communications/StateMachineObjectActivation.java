package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ArrivalSignal;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ObjectActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateActivation;

public class StateMachineObjectActivation extends ObjectActivation {

	public void registerCompletionEvent(StateActivation stateActivation){
		// A completion event does not have priority over other completion events.
		// Therefore if completion events are already in the event pool then the currently
		// posted completion event will be placed after these latter. In short the FIFO strategy
		// is applied to completion events
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
