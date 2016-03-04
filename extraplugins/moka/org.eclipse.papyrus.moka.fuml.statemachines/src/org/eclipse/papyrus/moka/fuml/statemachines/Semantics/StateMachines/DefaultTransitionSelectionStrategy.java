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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ChoiceStrategy;

public class DefaultTransitionSelectionStrategy extends TransitionSelectionStrategy {
	
	public DefaultTransitionSelectionStrategy(StateMachineExecution execution) {
		super(execution);
	}
	
	public boolean isDeferred(EventOccurrence eventOccurrence){
		// Determine if the dispatched event occurrence is deferred in the
		// current state machine configuration. An event occurrence can only be deferred
		// if the following conditions are fulfilled:
		// 1 - One active state in the hierarchy declares the event types as being deferred.
		// 2 - No transitions (ready to fire) with a higher priority than the deferring state
		//     could be found.
		return this._isDeferred(eventOccurrence, this.execution.getConfiguration().rootConfiguration);
	}
	
	public boolean _isDeferred(EventOccurrence eventOccurrence, StateConfiguration stateConfiguration){
		// Determine if the given state configuration is capable of deferring the given event occurrence.
		int i = 0;
		boolean deferred = false;
		while(!deferred && i < stateConfiguration.children.size()){
			deferred = this._isDeferred(eventOccurrence, stateConfiguration.children.get(i));
			i++;
		}
		if(!deferred && 
				stateConfiguration.vertexActivation != null && 
				this._select(eventOccurrence, stateConfiguration).isEmpty() &&
				((StateActivation)stateConfiguration.vertexActivation).canDefer(eventOccurrence)){
				deferred = true;
		}
		return deferred;
	}
	
	public void defer(EventOccurrence eventOccurrence){
		// Defers the given event occurrence. A deferred event occurrence is registered in
		// the deferred event pool. This latter refers to the deferred event as well as to the
		// the deferring state.
		this._defer(eventOccurrence, this.execution.getConfiguration().rootConfiguration);
	}
	
	protected boolean _defer(EventOccurrence eventOccurrence, StateConfiguration stateConfiguration){
		// Defers the given event occurrence in the context of the given state configuration.
		int i = 0;
		boolean deferred = false;
		while(!deferred && i < stateConfiguration.children.size()){
			deferred = this._defer(eventOccurrence, stateConfiguration.children.get(i));
			i++;
		}
		if(!deferred &&
				stateConfiguration.vertexActivation != null &&
				((StateActivation)stateConfiguration.vertexActivation).canDefer(eventOccurrence)){
			((StateActivation)stateConfiguration.vertexActivation).defer(eventOccurrence);
			deferred = true;
		}
		return deferred;
	}

	public boolean isTriggering(EventOccurrence eventOccurrence){
		// Returns true when one or more transition are ready to be fired using this event
		// occurrence; false otherwise.
		return !this.select(eventOccurrence).isEmpty();
	}
	
	public List<TransitionActivation> select(EventOccurrence eventOccurrence) {
		// Find for the given configuration the set of transition that can fire.
		return this._select(eventOccurrence, this.execution.getConfiguration().rootConfiguration);
	}
	
	protected List<TransitionActivation> _select(EventOccurrence eventOccurrence, StateConfiguration stateConfiguration){
		// Find for the given state configuration all transition that can actually fire.
		// The set of transition only contains transitions with the highest priority. In addition
		// no conflicting transitions are added to that set.
		List<TransitionActivation> selectedTransitions = new ArrayList<TransitionActivation>();
		for(int i = 0; i < stateConfiguration.children.size(); i++){
			selectedTransitions.addAll(this._select(eventOccurrence, stateConfiguration.children.get(i)));
		}
		if(selectedTransitions.isEmpty() && stateConfiguration.vertexActivation != null){
			for(int i = 0; i < stateConfiguration.vertexActivation.getOutgoingTransitions().size(); i++){
				TransitionActivation transitionActivation = stateConfiguration.vertexActivation.getOutgoingTransitions().get(i);
				if(transitionActivation.canFireOn(eventOccurrence)){
					selectedTransitions.add(transitionActivation);
				}
			}
			if(selectedTransitions.size() > 1){
				ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.execution.locus.factory.getStrategy("choice");
				TransitionActivation electedTransition = selectedTransitions.get(choiceStrategy.choose(selectedTransitions.size()) - 1);
				selectedTransitions.clear();
				selectedTransitions.add(electedTransition);
			}
		}
		return selectedTransitions;
	}
}
