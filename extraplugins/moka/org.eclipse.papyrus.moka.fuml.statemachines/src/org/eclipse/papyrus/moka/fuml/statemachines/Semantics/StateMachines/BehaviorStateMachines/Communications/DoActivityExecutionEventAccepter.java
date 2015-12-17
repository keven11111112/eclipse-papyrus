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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.InvocationEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.DoActivityExecution;

public class DoActivityExecutionEventAccepter extends EventAccepter {

	// DoActivity that need to be executed
	protected DoActivityExecution execution;
	
	public DoActivityExecutionEventAccepter(DoActivityExecution execution){
		this.execution = execution;
	}
	
	@Override
	public void accept(EventOccurrence eventOccurrence) {
		// Execute the DoActivity for which the invocation event occurence was accepted
		if(eventOccurrence instanceof InvocationEventOccurrence){
			this.execution.execute();
		}
	}

	@Override
	public Boolean match(EventOccurrence eventOccurrence) {
		// Make sure the event occurrence matches the DoActivity execution registered
		// for this accepter
		if(eventOccurrence instanceof InvocationEventOccurrence){
			return ((InvocationEventOccurrence)eventOccurrence).execution==this.execution;
		}
		return false;
	}

}
