package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Classes.Kernel;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ArrivalSignal;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications.CompletionEventOccurrence;

public class SM_Object extends CS_Object {

	public void sendCompletionEvent(StateActivation stateActivation){
		// A completion event does not have priority over other completion events.
		// Therefore if completion events are already in the event pool then the currently
		// posted completion event will be placed after these latter. In short the FIFO strategy
		// is applied to completion events
		CompletionEventOccurrence completionEventOccurrence = new CompletionEventOccurrence();
		completionEventOccurrence.stateActivation = stateActivation;
		int insertionIndex = 0;
		boolean insertionPointFound = false;
		while(!insertionPointFound && insertionIndex < this.objectActivation.eventPool.size()){
			insertionPointFound = !(this.objectActivation.eventPool.get(insertionIndex) instanceof CompletionEventOccurrence);
			if(!insertionPointFound){
				insertionIndex++;
			}
		}
		this.objectActivation.eventPool.add(insertionIndex, completionEventOccurrence);
		this.objectActivation._send(new ArrivalSignal());
	}
	
}
