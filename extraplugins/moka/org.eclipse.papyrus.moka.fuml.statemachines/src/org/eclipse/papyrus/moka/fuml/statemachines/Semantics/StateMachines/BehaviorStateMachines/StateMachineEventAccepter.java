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
 *  Jeremie Tatibouet (CEA LIST) - Based on Ed Seidewitz remarks
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;

public class StateMachineEventAccepter extends EventAccepter{

	// The execution that actually made the event accepter registered
	// in the object activation. Note this is particularly useful to access the
	// the configured related to the state-machine that registered this event
	// accepter.
	public StateMachineExecution registrationContext;
	
	// The strategy on which the transition selection process relies.
	protected TransitionSelectionStrategy selectionStrategy;
	
	public StateMachineEventAccepter(StateMachineExecution execution) {
		this.registrationContext = execution;
		this.selectionStrategy = new DefaultTransitionSelectionStrategy(execution);
	}
	
	@Override
	public void accept(EventOccurrence eventOccurrence) {
		// When an event occurrence is accepted this marks the beginning of a new RTC step for
		// the executed state-machine. The following set of actions takes place:
		// 1 - The list of transition that can be fired using the given event occurrence is computed
		// 2 - This list is organized as a different sub-set of transitions that can be fired. One of the
		//     subset is chosen to be fired. Each transition fires **Concurrently**
		// 3 - When the RTC step is about to complete a new event accepter for the state-machine
		//     is registered at the waiting event accepter list handled by the object activation
		// Note that there always is a single event accepter for a state-machine (this works differently
		// than for activities).
		if(this.selectionStrategy.isDeferred(eventOccurrence)){
			this.selectionStrategy.defer(eventOccurrence);
		}else{
			List<TransitionActivation> fireableTransition = this.selectionStrategy.select(eventOccurrence);
			if(!fireableTransition.isEmpty()){
				int i = 0;
				while(i < fireableTransition.size()){
					fireableTransition.get(i).fire();
					i++;
				}
			}
		}
		Object_ context = this.registrationContext.context;
		if(context!=null && context.objectActivation!=null){
			context.register(new StateMachineEventAccepter(this.registrationContext));
		}
	}

	@Override
	public Boolean match(EventOccurrence eventOccurrence) {
		// There are two cases in which the state machine event accepter can match
		// 1 - In the current state machine configuration the event can be deferred
		// 2 - In the current state machine configuration the current event can trigger one or more transitions
		return this.selectionStrategy.isDeferred(eventOccurrence) | this.selectionStrategy.isTriggering(eventOccurrence);
	}

}
