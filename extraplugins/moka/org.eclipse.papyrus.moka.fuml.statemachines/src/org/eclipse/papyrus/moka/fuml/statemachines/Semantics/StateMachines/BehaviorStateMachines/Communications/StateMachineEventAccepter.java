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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection.DefaultTransitionChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection.DefaultTransitionSelectionStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection.TransitionChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection.TransitionSelectionStrategy;

public class StateMachineEventAccepter extends EventAccepter{

	// The execution that actually made the event accepter registered
	// in the object activation. Note this is particularly useful to access the
	// the configured related to the state-machine that registered this event
	// accepter.
	public Execution registrationContext;
	
	// The strategy on which the transition selection process relies.
	protected TransitionSelectionStrategy selectionStrategy;
	
	// The strategy to choose among "selected" transitions which one(s) are
	// actually going to be fired
	protected TransitionChoiceStrategy choiceStrategy;
	
	public StateMachineEventAccepter(StateMachineExecution execution) {
		this.registrationContext = execution;
		this.selectionStrategy = new DefaultTransitionSelectionStrategy();
		this.choiceStrategy = new DefaultTransitionChoiceStrategy();
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
		List<TransitionActivation> fireableTransition = this.selectionStrategy.
				selectTransitions(((StateMachineExecution)this.registrationContext).getConfiguration(), eventOccurrence);
		if(!fireableTransition.isEmpty()){
			List<TransitionActivation> chosenTransition = this.choiceStrategy.choose(fireableTransition);
			int i = 0;
			// **Firing occurs concurrently**
			while(i < chosenTransition.size()){
				chosenTransition.get(i).fire();
				i++;
			}
		}
		Object_ context = this.registrationContext.context;
		if(context!=null && context.objectActivation!=null){
			context.register(new StateMachineEventAccepter((StateMachineExecution)this.registrationContext));
		}
	}

	@Override
	public Boolean match(EventOccurrence eventOccurrence) {
		// The accepter matches only in the case that at least one transition ready is ready to fire on the provided event occurrence
		return !this.selectionStrategy.selectTransitions(((StateMachineExecution)this.registrationContext).getConfiguration(), eventOccurrence).isEmpty();
	}

}
