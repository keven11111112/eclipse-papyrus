package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Classes.Kernel;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ArrivalSignal;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications.CompletionEventOccurrence;

public class SM_Object extends CS_Object {

	public void sendCompletionEvent(StateActivation stateActivation){
		// A completion event is always added in front off any other events
		// placed in the event pool.
		CompletionEventOccurrence completionEventOccurrence = new CompletionEventOccurrence();
		completionEventOccurrence.stateActivation = stateActivation;
		this.objectActivation.eventPool.add(0, completionEventOccurrence);
		this.objectActivation._send(new ArrivalSignal());
	}
	
}
