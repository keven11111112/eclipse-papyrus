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
public class SM_EventAccepter extends EventAccepter{

	public SM_EventAccepter(StateMachineExecution execution) {
		this.registrationContext = execution;
	}
	
	/**
	 * Among the set of ready to fire transitions select one and fire it. 
	 * The execution continues while there are transition to fire (i.e. run
	 * to completion semantics)  
	 *
	 * @param signalInstance - The signal consumed to trigger a transition 
	 */
	@Override
	public void accept(EventOccurrence eventOccurrence) {
		/*1. Select the transition that will fire according to priority rules and fire it*/
		TransitionSelectionStrategy selectionStrategy = (TransitionSelectionStrategy) this.registrationContext.locus.factory.getStrategy(TransitionSelectionStrategy.NAME);
		List<TransitionActivation> fireableTransition = selectionStrategy.selectTransitions(((StateMachineExecution)this.registrationContext).getConfiguration(), eventOccurrence);
		TransitionChoiceStrategy choiceStrategy = (TransitionChoiceStrategy)this.registrationContext.locus.factory.getStrategy(TransitionChoiceStrategy.NAME);
		if(!fireableTransition.isEmpty()){
			TransitionActivation transitionActivation = choiceStrategy.choose(fireableTransition);
			transitionActivation.fire();
		}
		/*2. Register an event accepter for the executed state-machine*/
		Object_ context = this.registrationContext.context;
		if(context!=null && context.objectActivation!=null){
			context.register(new SM_EventAccepter((StateMachineExecution)this.registrationContext));
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
