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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection.TransitionChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection.TransitionSelectionStrategy;

public class SM_EventAccepter extends EventAccepter{

	protected StateMachineExecution execution;
	
	public SM_EventAccepter(StateMachineExecution execution) {
		this.execution = execution;
	}
	
	/**
	 * Among the set of ready to fire transitions select one and fire it. 
	 * The execution continues while there are transition to fire (i.e. run
	 * to completion semantics)  
	 *
	 * @param signalInstance - The signal consumed to trigger a transition 
	 */
	@Override
	public void accept(SignalInstance signalInstance) {
		/*1. Select the transition that will fire according to priority rules*/
		TransitionSelectionStrategy selectionStrategy = (TransitionSelectionStrategy) this.execution.locus.factory.getStrategy(TransitionSelectionStrategy.NAME);
		List<TransitionActivation> fireableTransition = selectionStrategy.selectTriggeredTransitions(this.execution.getConfiguration(), signalInstance);
		TransitionChoiceStrategy choiceStrategy = (TransitionChoiceStrategy)this.execution.locus.factory.getStrategy(TransitionChoiceStrategy.NAME);
		if(!fireableTransition.isEmpty()){
			/*1.1. Fire the choosen transition */
			TransitionActivation transitionActivation = choiceStrategy.choose(fireableTransition);
			transitionActivation.fire();
			/*1.2. Continue to fire transitions (not triggered) while it is possible*/
			fireableTransition = selectionStrategy.selectTransitions(this.execution.getConfiguration());
			while(!fireableTransition.isEmpty()){
				choiceStrategy = (TransitionChoiceStrategy)this.execution.locus.factory.getStrategy(TransitionChoiceStrategy.NAME);
				transitionActivation = choiceStrategy.choose(fireableTransition);  
				transitionActivation.fire();
				fireableTransition = selectionStrategy.selectTransitions(this.execution.getConfiguration());
			}
		}
	}

	@Override
	public Boolean match(SignalInstance signalInstance) {
		// Return true if there is at least one transition that is 
		// ready to fire on this event. Return false otherwise
		TransitionSelectionStrategy selectionStrategy = (TransitionSelectionStrategy) execution.locus.factory.getStrategy(TransitionSelectionStrategy.NAME);
		return !selectionStrategy.selectTriggeredTransitions(execution.getConfiguration(), signalInstance).isEmpty();
	}

}
