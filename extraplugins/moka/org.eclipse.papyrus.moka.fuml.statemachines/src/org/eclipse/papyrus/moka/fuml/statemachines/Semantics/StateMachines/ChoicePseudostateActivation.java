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
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.Transition;

public class ChoicePseudostateActivation extends PseudostateActivation {

	protected static final String ELSE_OPERATOR = "else";
	
	public void enter(TransitionActivation enteringTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor) {
		// When an choice pseudo-state is reached then guards placed are evaluated dynamically
		// If more than a guard evaluates to true then the selected transition is selected using
		// using the first choice semantic strategy
		super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		TransitionActivation elseTransitionActivation = null;
		List<TransitionActivation> fireableTransitons = new ArrayList<TransitionActivation>();
		for (int i = 0; i < this.outgoingTransitionActivations.size(); i++) {
			TransitionActivation currentTransitionActivation = this.outgoingTransitionActivations.get(i);
			if(this.isElseTransition(currentTransitionActivation)){
				elseTransitionActivation = currentTransitionActivation;
			}else{
				if (currentTransitionActivation.evaluateGuard(eventOccurrence)) {
					fireableTransitons.add(currentTransitionActivation);
				}
			}
		}
		if (fireableTransitons.size() == 1) {
			fireableTransitons.get(0).fire(eventOccurrence);
		} else if (fireableTransitons.size() > 1) {
			ChoiceStrategy strategy =  (ChoiceStrategy)this.getExecutionContext().locus.factory.getStrategy("choice");
			TransitionActivation transitionActivation = fireableTransitons.get(strategy.choose(fireableTransitons.size()-1));
			transitionActivation.fire(eventOccurrence);
		} else if (elseTransitionActivation!=null) {
			elseTransitionActivation.fire(eventOccurrence);
		}
	}
	
	protected boolean isElseTransition(TransitionActivation transitionActivation){
		// Determine if the given transition materialize the else branch of a choice pseudo state.
		// A transition materializes an else branch since it has a guard which specification is
		// an Expression that has no operand(s) and whose symbol is "else"
		boolean isElse = false;
		if(transitionActivation!=null){
			Transition transition = (Transition)transitionActivation.getNode();
			if(transition.getGuard()!=null && transition.getGuard().getSpecification() instanceof Expression){
				Expression expression = (Expression) transition.getGuard().getSpecification();
				isElse = expression.getOperands().isEmpty() && expression.getSymbol() !=null && expression.getSymbol().toLowerCase().equals(ELSE_OPERATOR);
				// TODO: The way we specify else must be specified in the abstract syntax.
			}
		}
		return isElse;
	}
}
