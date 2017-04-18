/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jeremie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.SM_ObjectActivation;
import org.eclipse.uml2.uml.Trigger;

public class CompletionEventOccurrence extends EventOccurrence {
	
	/*
	 * A completion event is a specific kind of event occurrence.
	 * 
	 * It is placed in the event pool of an active object under the following circumstances:
	 * 	
	 * 1 - The state is simple. As soon as its entry behavior as well as its doActivity behavior 
	 *      finished a completion event is generated.
	 *      
	 *  2 - The state is composite. All internal activities (e.g., entry and doActivity Behaviors) have
	 *      completed execution, and all its orthogonal Regions have reached a FinalState
	 *      
	 */
	
	// A reference to the state from which the completion event was generated
	public StateActivation stateActivation;

	@Override
	public boolean matchAny(List<Trigger> triggers) {
		// A completion event can only trigger transition with no
		// trigger. Hence if the list of trigger that is passed is
		// empty then the completion event occurrence matches. It does match
		// otherwise.
		boolean match = false;
		if(triggers.size() == 0){
			match = true;
		}
		return match;
	}
	
	@Override
	public boolean match(Trigger trigger) {
		// A completion event can only trigger transition with no
		// trigger. Hence it cannot match a trigger so false is returned
		// regardless the trigger provided as parameter.
		return false;
	}

	@Override
	public List<ParameterValue> getParameterValues() {
		// A completion will never have associated values. Hence a
		// empty list is returned.
		return new ArrayList<ParameterValue>();
	}
	
	@Override
	public void sendTo(Reference target) {
		// Do nothing - the completion event is not sent to a target.
		// It is registered during the RTC step of the active object that
		// entered the state from which it was generated. 
	}
	
	@Override
	public void doSend() {
		// Do nothing - the completion event is not sent to a target.
		// It is registered during the RTC step of the active object that
		// entered the state from which it was generated. 
	}
	
	public void register(StateActivation stateActivation){
		// Register this completion event occurrence in the event
		// pool of the context object.
		this.stateActivation = stateActivation;
		SM_ObjectActivation objectActivation = (SM_ObjectActivation)stateActivation.getExecutionContext().objectActivation;
		objectActivation.register(this);
	}

}
