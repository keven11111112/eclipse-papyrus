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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Pseudostate;

import static org.eclipse.papyrus.moka.fuml.statemachines.Activator.logger;

import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;

public class InitialPseudostateActivation extends PseudostateActivation{
	
	public void enter(TransitionActivation enteringTransition, boolean explicit) {
		/*1. The vertex becomes active*/
		logger.info(this.getNode().getName()+" => ACTIVE");
		this.setState(StateMetadata.ACTIVE);
		/*2. The vertex starts to be highlighted*/
		FUMLExecutionEngine.eInstance.getControlDelegate().control(this);
		/*3. Its only outgoing transition do have a guard and triggers*/
		this.outgoingTransitionActivations.get(0).fire();
	}

}
