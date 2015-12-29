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
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection.TransitionChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection.TransitionSelectionStrategy;

/**
 * This class describes an event accepter for state-machines.
 * 
 * The consumption (i.e. acceptance) of a state-machine event accepter is only allowed if there are
 * enabled transition declaring a trigger matching the given signal instance.
 *
 * There always is a single event accepter registered for a given state-machine.
 * 
 * When a signal triggers an acceptance then accepter is removed from the pool. At the
 * end of the RTC step another one is automatically added to the pool.
 */
public class StateMachineEventAccepter extends EventAccepter{

	public StateMachineEventAccepter(StateMachineExecution execution) {
		this.registrationContext = execution;
	}
	
	@Override
	public void accept(EventOccurrence eventOccurrence) {
		// Based on the analysis of the state-machine configuration, a set of transition that are ready to fire are selected.
		// The set of selected transition is reduced.
		// All the transitions within the set provided by the choice strategy are fired **concurrently**
		// A new event accepter is placed in the event accepter list
		// Note: a state-machine has always as single (dedicated) event accepter
		TransitionSelectionStrategy selectionStrategy = (TransitionSelectionStrategy) this.registrationContext.locus.factory.getStrategy(TransitionSelectionStrategy.NAME);
		List<TransitionActivation> fireableTransition = selectionStrategy.selectTransitions(((StateMachineExecution)this.registrationContext).getConfiguration(), eventOccurrence);
		TransitionChoiceStrategy choiceStrategy = (TransitionChoiceStrategy)this.registrationContext.locus.factory.getStrategy(TransitionChoiceStrategy.NAME);
		if(!fireableTransition.isEmpty()){
			List<TransitionActivation> chosenTransition = choiceStrategy.choose(fireableTransition);
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
		// Return true if there is at least one transition that is 
		// ready to fire on this event. Return false otherwise
		TransitionSelectionStrategy selectionStrategy = (TransitionSelectionStrategy) registrationContext.locus.factory.getStrategy(TransitionSelectionStrategy.NAME);
		return !selectionStrategy.selectTransitions(((StateMachineExecution)this.registrationContext).getConfiguration(), eventOccurrence).isEmpty();
	}

}
