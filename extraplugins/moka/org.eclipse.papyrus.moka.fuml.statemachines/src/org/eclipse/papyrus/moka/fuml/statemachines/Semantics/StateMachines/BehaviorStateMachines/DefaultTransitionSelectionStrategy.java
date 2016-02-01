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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ChoiceStrategy;

public class DefaultTransitionSelectionStrategy extends TransitionSelectionStrategy {
	
	public DefaultTransitionSelectionStrategy(StateMachineExecution execution) {
		super(execution);
	}
	
	public boolean isDeferred(EventOccurrence eventOccurrence){
		// Returns true when at least one state within the configuration can defers the given
		// event occurrence. The evaluation starts from the innermost part of the state-machine
		// configuration. If no state can defer the given event occurrence false is returned.
		boolean isDeferred = false;
		boolean isTriggered = false;
		Map<Integer, List<VertexActivation>> cartography = this.execution.getConfiguration().getCartography();
		int i = cartography.size();
		while(i >= 1 && (!isDeferred && !isTriggered)){
			List<VertexActivation> verticesActivations = cartography.get(i);
			int j = 0;
			while(j < verticesActivations.size() && (!isDeferred && !isTriggered)){
				StateActivation currentStateActivation = (StateActivation) verticesActivations.get(j);
				isTriggered = !currentStateActivation.getFireableTransitions(eventOccurrence).isEmpty();
				if(!isTriggered && currentStateActivation.canDefer(eventOccurrence)){
					isDeferred = true;
				}
				j++;
			}
			i--;
		}
		return isDeferred;
	}
	
	public void defer(EventOccurrence eventOccurrence){
		// The state indicating that the given event occurrence is deferred defers the given event
		// occurrence. When deferred the event occurrence is placed within the deferred event pool.
		// This operation is intended to be called only and only if the "isDeferred" operation
		// returned true.
		boolean isDeferred = false;
		Map<Integer, List<VertexActivation>> cartography = this.execution.getConfiguration().getCartography();
		int i = cartography.size();
		while(i >= 1 && !isDeferred){
			int j = 0;
			List<VertexActivation> verticesActivations = cartography.get(i);
			while(j < verticesActivations.size() && !isDeferred){
				StateActivation currentStateActivation = (StateActivation) verticesActivations.get(j);
				if(currentStateActivation.canDefer(eventOccurrence)){
					currentStateActivation.defer(eventOccurrence);
					isDeferred = true;
				}
				j++;
			}
			i--;
		}
	}

	public boolean isTriggering(EventOccurrence eventOccurrence){
		// Returns true when one or more transition are ready to be fired using this event
		// occurrence; false otherwise.
		return !this.select(eventOccurrence).isEmpty();
	}
	
	public List<TransitionActivation> select(EventOccurrence eventOccurrence) {
		// Find for the given configuration the set of transition that can fire. The search
		// starts from the deepest level. If no transition enabled are found at this level then
		// the search continue in the upper level. The search stops when at given level a not empty
		// set of enabled transition is calculated. Transition returned are only those that are not
		// triggered by an event (i.e. Transitions that are automatic or only guarded).
		List<TransitionActivation> selectedTransitions = new ArrayList<TransitionActivation>();
		Map<Integer, List<VertexActivation>> cartography = this.execution.getConfiguration().getCartography();
		int i = cartography.size();
		boolean nextLevel = true;
		while(i >= 1 && nextLevel){
			for(VertexActivation vertexActivation : cartography.get(i)){
				StateActivation currentStateActivation = (StateActivation) vertexActivation;
				List<TransitionActivation> fireableTransitions = new ArrayList<TransitionActivation>();
				for(TransitionActivation transitionActivation : currentStateActivation.getOutgoingTransitions()){
					if(transitionActivation.canFireOn(eventOccurrence)){
						fireableTransitions.add(transitionActivation);
					}
				}
				selectedTransitions.addAll(fireableTransitions);
			}
			if(!selectedTransitions.isEmpty()){
				nextLevel = false;
			}else{
				i--;
			}
		}
		List<List<TransitionActivation>> groups = this.group(selectedTransitions);
		ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.execution.locus.factory.getStrategy("choice");
		int choice = choiceStrategy.choose(groups.size()) - 1;
		return groups.get(choice);
	}
	
	protected List<List<TransitionActivation>> group(List<TransitionActivation> fireableTransitions) {
		// The purpose here is to choose among a set of fireable transitions a subset that will
		// effectively be fired. This subset can contain in the most trivial case a single
		// transition. In the case of orthogonal region it can contain several transitions
		// that will be fired using the same event occurrence
		Map<VertexActivation, List<TransitionActivation>> transitionGroups = new HashMap<VertexActivation, List<TransitionActivation>>();
		List<List<TransitionActivation>> groupingResults = new ArrayList<List<TransitionActivation>>();
		if(fireableTransitions.isEmpty()){
			groupingResults.add(new ArrayList<TransitionActivation>());
		}else{
			int i = 0;
			while(i < fireableTransitions.size()){
				TransitionActivation transitionActivation = fireableTransitions.get(i);
				List<TransitionActivation> group = transitionGroups.get(transitionActivation.getSourceActivation().getParentState());
				if(group==null){
					group = new ArrayList<TransitionActivation>();
					group.add(transitionActivation);
					transitionGroups.put(transitionActivation.getSourceActivation().getParentState(), group);
				}else{
					group.add(transitionActivation);
				}
				i++;
			}
			for(VertexActivation vertexActivation: transitionGroups.keySet()){
				List<TransitionActivation> group = transitionGroups.get(vertexActivation);
				List<TransitionActivation> conflictingTransitions = this.getConflictingTransitions(group);
				if(!conflictingTransitions.isEmpty()){
					this.resolveConflitcs(group, conflictingTransitions);
				}
				groupingResults.add(group);
				i++;
			}
		}
		return groupingResults;
	}

	
	protected List<TransitionActivation> getConflictingTransitions(List<TransitionActivation> group){
		// Detect conflicting transitions located in a group of transitions. Conflicting transitions
		// are transitions which are in the firing set but which originate from the same source vertex.
		List<TransitionActivation> conflictingTransitions = new ArrayList<TransitionActivation>();
		int i = 0;
		while(i < group.size()){
			TransitionActivation referenceTransition = group.get(i);
			for(int j=0; j < group.size(); j++){
				TransitionActivation currentTransition = group.get(j);
				if(referenceTransition!=currentTransition 
						&& !conflictingTransitions.contains(currentTransition)
						&& referenceTransition.getSourceActivation()==currentTransition.getSourceActivation()){
						if(!conflictingTransitions.contains(referenceTransition)){
							conflictingTransitions.add(referenceTransition);
						}
						conflictingTransitions.add(currentTransition);
				}
			}
			i++;
		}
		return conflictingTransitions;
	}
	
	protected void resolveConflitcs(List<TransitionActivation> group, List<TransitionActivation> conflictingTransitions){
		// The conflict resolution consist in the following set of actions:
		// 1 - Conflicting transitions are grouped in different set. The grouping criteria is the origin of a transition
		// 2 - For each set a transition is elected (the selection is a semantic variation point) to stay in the firing set.
		//     Other transitions are  removed from the firing set.
		Map<VertexActivation,List<TransitionActivation>> transitionsPerOrigin = new HashMap<VertexActivation, List<TransitionActivation>>();
		// 1 - Grouping phase
		for(int i=0; i < conflictingTransitions.size(); i++){
			TransitionActivation currentTransitionActivation = conflictingTransitions.get(i);
			List<TransitionActivation> transitionGroup = transitionsPerOrigin.get(currentTransitionActivation.getSourceActivation());
			if(transitionGroup==null){
				transitionGroup = new ArrayList<TransitionActivation>();
				transitionGroup.add(currentTransitionActivation);
				transitionsPerOrigin.put(currentTransitionActivation.getSourceActivation(), transitionGroup);
			}else{
				transitionGroup.add(currentTransitionActivation);
			}
		}
		// 2 - Conflict resolution
		ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.execution.locus.factory.getStrategy("choice");
		for(VertexActivation origin: transitionsPerOrigin.keySet()){
			List<TransitionActivation> transitionGroup = transitionsPerOrigin.get(origin);
			int electedIndex = choiceStrategy.choose(transitionGroup.size()) - 1;
			for(int i=0; i < transitionGroup.size(); i++){
				if(i!=electedIndex){
					group.remove(transitionGroup.get(i));
				}
			}
		}
	}
}
