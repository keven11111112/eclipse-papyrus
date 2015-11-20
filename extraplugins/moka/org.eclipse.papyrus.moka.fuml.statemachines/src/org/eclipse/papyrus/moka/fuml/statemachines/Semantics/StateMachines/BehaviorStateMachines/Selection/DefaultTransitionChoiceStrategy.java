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

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.FirstChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.RegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;

public class DefaultTransitionChoiceStrategy extends TransitionChoiceStrategy {

	@Override
	public List<TransitionActivation> choose(List<TransitionActivation> transitionActivations) {
		// The purpose here is to choose among a set of transition that a subset that will
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
			ChoiceStrategy choiceStrategy = new FirstChoiceStrategy();
			int choice = choiceStrategy.choose(chosenTransitions.size()) - 1;
			return chosenTransitions.get(choice);
		}
	}

	protected List<TransitionActivation> getTargetSet(TransitionActivation transition, List<List<TransitionActivation>> targetSet){
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
}
