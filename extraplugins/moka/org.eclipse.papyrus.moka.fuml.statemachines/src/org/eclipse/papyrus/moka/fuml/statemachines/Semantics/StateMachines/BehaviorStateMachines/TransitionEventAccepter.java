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

import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.InvocationActions.CS_SignalInstance;
import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;

public class TransitionEventAccepter extends EventAccepter {

	protected TransitionActivation transitionActivation;
	
	public TransitionEventAccepter(TransitionActivation activation){
		this.transitionActivation = activation;
	}
	
	public TransitionActivation getTransition(){
		return this.transitionActivation;
	}
	
	@Override
	public void accept(SignalInstance signalInstance) {
		this.transitionActivation.fire();
	}

	@Override
	public Boolean match(SignalInstance signalInstance) {
		if (FUMLExecutionEngine.eInstance.isTerminated())
			return false ;
		Transition transition = (Transition)(this.transitionActivation.getNode());
		List<Trigger> triggers = transition.getTriggers();
		Signal signal = signalInstance.type;

		Boolean matches = false;
		Integer i = 1;
		while(!matches & i <= triggers.size()) {
			Trigger t = triggers.get(i - 1);
			matches = ((SignalEvent)t.getEvent()).getSignal() == signal;
			if(matches && t.getPorts().size() > 0) {
				List<Port> portsOfTrigger = t.getPorts();
				Port onPort = ((CS_SignalInstance)signalInstance).interactionPoint.definingPort;
				Boolean portMatches = false;
				Integer j = 1;
				while(!portMatches & j <= portsOfTrigger.size()) {
					portMatches = onPort == portsOfTrigger.get(j - 1);
					j = j + 1;
				}
				matches = portMatches;
			}
			i = i + 1;
		}
		boolean guardEvaluation = this.transitionActivation.evaluateGuard() ;
		return matches && guardEvaluation ;
	}
}
