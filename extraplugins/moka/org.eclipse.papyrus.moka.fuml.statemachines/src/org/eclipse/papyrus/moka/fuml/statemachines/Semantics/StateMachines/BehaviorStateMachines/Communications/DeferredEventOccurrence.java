package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateActivation;

public class DeferredEventOccurrence extends EventOccurrence {
	
	// The state activation that was constraint the event occurrence 
	// to remain deferred.
	public StateActivation constrainingStateActivation;
	
	// The event occurrence that is actually deferred
	public EventOccurrence deferredEventOccurrence;

}
