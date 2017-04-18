package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.SM_ObjectActivation;
import org.eclipse.uml2.uml.Trigger;

public class DeferredEventOccurrence extends EventOccurrence {
	
	// The state activation that was constraint the event occurrence 
	// to remain deferred.
	public StateActivation constrainingStateActivation;
	
	// The event occurrence that is actually deferred
	public EventOccurrence deferredEventOccurrence;

	@Override
	public boolean match(Trigger trigger) {
		// Delegate to the match operation of the encapsulated event
		// occurrence which is the one being deferred.
		boolean match = false;
		if(this.deferredEventOccurrence != null){
			match = this.deferredEventOccurrence.match(trigger);
		}
		return match;
	}

	@Override
	public List<ParameterValue> getParameterValues() {
		// Delegate to the getParameterValues operation of the encapsulated event
		// occurrence which is the one being deferred.
		List<ParameterValue> parameterValues = new ArrayList<ParameterValue>();
		if(this.deferredEventOccurrence != null){
			parameterValues = this.deferredEventOccurrence.getParameterValues();
		}
		return parameterValues;
	}
	
	public void register(StateActivation stateActivation){
		// Register this deferred event occurrence in the deffered
		// event pool of the context object.
		this.constrainingStateActivation = stateActivation;
		SM_ObjectActivation objectActivation = (SM_ObjectActivation)stateActivation.getExecutionContext().objectActivation;
		objectActivation.register(this);
	}
	
	@Override
	public void sendTo(Reference target) {
		// Do nothing - the deferred event is not sent to a target.
		// It is registered during the RTC step of the active object that
		// entered the state from which it was generated. 
		super.sendTo(target);
	}
	
	@Override
	public void doSend() {
		// Do nothing - the deferred event is not sent to a target.
		// It is registered during the RTC step of the active object that
		// entered the state from which it was generated. 
		super.doSend();
	}

}
