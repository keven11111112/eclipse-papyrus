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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.RegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.VertexActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications.CompletionEventOccurrence;

public class DefaultTransitionSelectionStrategy extends TransitionSelectionStrategy {
	
	public DefaultTransitionSelectionStrategy(StateMachineExecution execution) {
		super(execution);
	}

	public List<TransitionActivation> selectTransitions(EventOccurrence eventOccurrence) {
		// Find for the given configuration the set of transition that can fire.
		// The search starts from the deepest level. If no transition enabled are found at this level
		// then the search continue in the upper level. The search stops when at given level a not empty
		// set of enabled transition is calculated. Transition returned are only those that are not triggered by an event 
		// (i.e. Transitions that are automatic or only guarded).
		List<TransitionActivation> selectedTransitions = new ArrayList<TransitionActivation>();
		Map<Integer, List<VertexActivation>> cartography = this.execution.getConfiguration().getCartography();
		int i = cartography.size();
		boolean nextLevel = true;
		while(i >= 1 && nextLevel){
			for(VertexActivation vertexActivation : cartography.get(i)){
				StateActivation currentStateActivation = (StateActivation) vertexActivation;
				List<TransitionActivation> fireableTransitions = new ArrayList<TransitionActivation>();
				for(TransitionActivation transitionActivation : currentStateActivation.getOutgoingTransitions()){
					if(this.isFireable(transitionActivation, eventOccurrence)){
						fireableTransitions.add(transitionActivation);
					}
				}
				// If no transition can fire was found for this particular state but this latter
				// indicates that it defers the given event occurrence the event occurrence is placed
				// in the deferred event pool
				if(fireableTransitions.isEmpty() && currentStateActivation.canDefer(eventOccurrence)){
					currentStateActivation.defer(eventOccurrence);
					nextLevel = false;
				}
				selectedTransitions.addAll(fireableTransitions);
			}
			if(!selectedTransitions.isEmpty()){
				nextLevel = false;
			}else{
				i--;
			}
		}
		return this.choose(selectedTransitions);
	}
	
	protected List<TransitionActivation> choose(List<TransitionActivation> transitionActivations) {
		// The purpose here is to choose among a set of fireable transitions a subset that will
		// effectively be fired. This subset can contain in the most trivial case a single
		// transition. In the case of orthogonal region it can contain several transitions
		// that will be fired using the same event occurrence
		if(transitionActivations.isEmpty()){
			return new ArrayList<TransitionActivation>();
		}else{
			List<List<TransitionActivation>> chosenTransitions = new ArrayList<List<TransitionActivation>>();
			int i = 0;
			while(i < transitionActivations.size()){
				TransitionActivation transition = transitionActivations.get(i);
				List<TransitionActivation> targetSet = this.getTargetSet(transitionActivations.get(i), chosenTransitions);
				if(targetSet==null){
					targetSet = new ArrayList<TransitionActivation>();
					targetSet.add(transition);
					chosenTransitions.add(targetSet);
				}else{
					targetSet.add(transition);
				}
				i++;
			}
			ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.execution.locus.factory.getStrategy("choice");
			int choice = choiceStrategy.choose(chosenTransitions.size()) - 1;
			return chosenTransitions.get(choice);
		}
	}
	
	private List<TransitionActivation> getTargetSet(TransitionActivation transition, List<List<TransitionActivation>> targetSet){
		// Determine the set of transition is which a given transition  must be added.
		// The set of transition is the one which already contain transitions that have
		// the same common ancestor. 
		if(targetSet==null || targetSet.isEmpty()){
			return null;
		}else{
			int i = 0;
			List<TransitionActivation> transitionSet = null; 
			while(transitionSet==null && i < targetSet.size()){
				List<TransitionActivation> currentSet = targetSet.get(i);
				TransitionActivation selectedTransition = currentSet.get(0);
				RegionActivation owningRegion_transition = (RegionActivation) transition.getParent();
				RegionActivation owningRegion_selectedTransition = (RegionActivation) selectedTransition.getParent();
				// Region which transition are located should be different. However all of the regions
				// must belong to the same state.
				if(owningRegion_transition!=owningRegion_selectedTransition &&
						owningRegion_selectedTransition.getParent()==owningRegion_transition.getParent()){
					transitionSet = currentSet;
				}
				i++;
			}
			return transitionSet;
		}
	}
	
	private boolean isFireable(TransitionActivation transitionActivation, EventOccurrence eventOccurrence){
		// A transition is can fire when:
		//
		// 	- A completion event is being dispatched and this transition has no trigger
		// 	  but its eventual guard evaluates to true.
		//	  Note: the scope of a completion event is the state from which it was 
		//
		//  - A signal event is being dispatched and this transition has a trigger
		//    that matches the signal and its eventual guard evaluates to true
		boolean reactive = true;
		if(eventOccurrence instanceof CompletionEventOccurrence){
			reactive = !transitionActivation.isTriggered() && // The transition declares not explicit trigger(s)
						transitionActivation.getSourceActivation()==((CompletionEventOccurrence)eventOccurrence).stateActivation && // The event was generated by a state activation which is the source ot this transition
						transitionActivation.evaluateGuard(); // The guard of the transition evaluates to true
		}else if(eventOccurrence instanceof SignalEventOccurrence){
			reactive = transitionActivation.hasTrigger(((SignalEventOccurrence)eventOccurrence).signalInstance) && // the transition declares a trigger that matches the event
					   transitionActivation.evaluateGuard(); // The guard of the transition evaluates to true
		}else{
			reactive = false;
		}
		return reactive;
	}
}
