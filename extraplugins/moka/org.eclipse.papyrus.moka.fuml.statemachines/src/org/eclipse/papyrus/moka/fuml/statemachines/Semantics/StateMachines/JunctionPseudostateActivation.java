/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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

public class JunctionPseudostateActivation extends PseudostateActivation{
	
	// Transitions that were fireable at the time which the junction
	// pseudo-state was evaluated.
	protected List<TransitionActivation> fireableTransitions;
	
	public JunctionPseudostateActivation(){
		this.fireableTransitions = new ArrayList<TransitionActivation>();
	}
	
	protected void evaluateAllGuards(EventOccurrence eventOccurrence){
		// Evaluate all guards of transitions outgoing this junction pseudo-state.
		// Transitions with a guard evaluating to true are added to the set of fireable
		// transitions (i.e., transitions that may be fired when the junction pseudo-state
		// is entered). Not that at each evaluation of the junction pseudo-state the set
		// of fireable transitions is cleared.
		this.fireableTransitions.clear();
		for(int i=0; i < this.outgoingTransitionActivations.size(); i++){
			TransitionActivation transitionActivation = this.outgoingTransitionActivations.get(i);
			if(transitionActivation.evaluateGuard(eventOccurrence)){
				this.fireableTransitions.add(transitionActivation);
			}
		}
	}
	
	@Override
	public boolean isEnterable(TransitionActivation enteringTransition) {
		// A junction pseudo-state can only be entered if it has at least one
		// transition that was fireable the last time it was evaluated. Note that
		// in practice this there must be not cases in which the execution reaches
		// a jucntion pseudo-state which actually cannot be entered. Indeed such
		// cases are prevented by the compound transitions analysis provided by the
		// state-machine event accepter.
		boolean isEnterable = false;
		if(this.fireableTransitions.size() > 0){
			isEnterable = true;
		}
		return isEnterable;
	}
	
	@Override
	public boolean canPropagateExecution(TransitionActivation enteringTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		// The execution can only be propagated if this pseudo-state has
		// at least on outgoing transition evaluating to true. The propagation
		// consists in:
		// 1. Force guards of outgoing transitions to be evaluated
		// 2. Test if the pseudo-state can then be entered
		// 3. If the pseudo state can be entered then propagate the execution
		//    through the set of fireable transitions
		boolean propagate = super.canPropagateExecution(enteringTransition, eventOccurrence, leastCommonAncestor);
		if(propagate){
			this.evaluateAllGuards(eventOccurrence);
			propagate = false;
			if(this.isEnterable(null)){
				int i = 0;
				while(!propagate && i < this.fireableTransitions.size()){
					propagate = this.fireableTransitions.get(i).canPropagateExecution(eventOccurrence);
					i++;
				}
			}
		}
		return propagate;
	}
	
	@Override
	public void enter(TransitionActivation enteringTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		// When entered, all parent that have not yet been entered are entered first.
		// Next, one transition is chosen in the set of fireable transition to be fired.
		// This transition is fired and the junction pseudo state is exited.
		super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		VertexActivation vertexActivation = this.getParentStateActivation();
		if(vertexActivation!=null){
			vertexActivation.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		}
		TransitionActivation selectedTransition = null;
		if(this.fireableTransitions.size() == 1){
			selectedTransition = this.fireableTransitions.get(0);
		}else{
			ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.getExecutionLocus().factory.getStrategy("choice");
			int index = choiceStrategy.choose(this.fireableTransitions.size()) - 1;
			selectedTransition = this.fireableTransitions.get(index);
		}
		selectedTransition.fire(eventOccurrence);
	}
	
	@Override
	public void exit(TransitionActivation exitingTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		super.exit(exitingTransition, eventOccurrence, leastCommonAncestor);
		if(leastCommonAncestor != null){
			RegionActivation parentRegionActivation = (RegionActivation) this.getParent();
			if(leastCommonAncestor!=parentRegionActivation){
				VertexActivation parentVertexActivation = (VertexActivation) parentRegionActivation.getParent();
				if(parentVertexActivation != null){
					parentVertexActivation.exit(exitingTransition, eventOccurrence, leastCommonAncestor);
				}
			}
		}
	}
}
