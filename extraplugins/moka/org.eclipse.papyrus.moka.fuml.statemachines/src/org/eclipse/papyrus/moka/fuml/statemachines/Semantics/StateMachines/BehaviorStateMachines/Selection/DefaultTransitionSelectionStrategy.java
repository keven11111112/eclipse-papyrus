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
import java.util.Set;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.VertexActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Configuration.StateMachineConfiguration;

public class DefaultTransitionSelectionStrategy extends TransitionSelectionStrategy {
	
	/**
	 * Find for the given configuration the set of transition that can fire.
	 * The search starts from the deepest level. If no transition enabled are found at this level
	 * then the search continue in the upper level. The search stops when at given level a not empty
	 * set of enabled transition is calculated. Transition returned are only those that are not triggered by an event 
	 * (i.e. Transitions that are automatic or only guarded).
	 */
	@Override
	public List<TransitionActivation> selectTransitions(StateMachineConfiguration configuration) {
		List<TransitionActivation> fireableTransition = new ArrayList<TransitionActivation>();
		Map<Integer, Set<VertexActivation>> cartography = configuration.getCartography();
		int i = cartography.size();
		boolean nextLevel = true;
		while(i >= 1 && nextLevel){
			for(VertexActivation vertexActivation : cartography.get(i)){
				for(TransitionActivation transitionActivation : vertexActivation.getOutgoingTransitions()){
					if(transitionActivation.isAutomatic() ^ 
							(transitionActivation.isGuarded() && 
									!transitionActivation.isTriggered()
									 	&& transitionActivation.evaluateGuard())){
						fireableTransition.add(transitionActivation);
					}
				}
			}
			if(!fireableTransition.isEmpty()){
				nextLevel = false;
			}else{
				i--;
			}
		}
		return fireableTransition;
	}

	/**
	 * Find for the given configuration the set of triggered transitions that can fire regarding the signal instance
	 * provided in parameter.
	 */
	@Override
	public List<TransitionActivation> selectTriggeredTransitions(StateMachineConfiguration configuration,
			SignalInstance signal) {
		List<TransitionActivation> fireableTransition = new ArrayList<TransitionActivation>();
		Map<Integer, Set<VertexActivation>> cartography = configuration.getCartography();
		int i = cartography.size();
		boolean nextLevel = true;
		while(i >= 1 && nextLevel){
			for(VertexActivation vertexActivation : cartography.get(i)){
				for(TransitionActivation transitionActivation : vertexActivation.getOutgoingTransitions()){
					if(transitionActivation.isTriggered() && 
							transitionActivation.hasTrigger(signal)){
						fireableTransition.add(transitionActivation);
					}
				}
			}
			if(!fireableTransition.isEmpty()){
				nextLevel = false;
			}else{
				i--;
			}
		}
		return fireableTransition;
	}
}
