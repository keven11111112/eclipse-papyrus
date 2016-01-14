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
 *  Jeremie Tatibouet (CEA LIST) - Based on Ed Seidewitz remarks
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Classes.Kernel.DoActivityContextObject;

public class DoActivityExecutionEventAccepter extends EventAccepter {

	// The doActivity context object in which this accepter is registered
	public DoActivityContextObject context;
	
	// The actual event accepter (i.e., the one registered by the doActivity execution)
	public EventAccepter encapsulatedAccepter;
	
	@Override
	public void accept(EventOccurrence eventOccurrence) {
		// Execute the RTC step related to the acceptance of this event.
		// Afterwards check if there are remaining accepters registered in
		// the for the object activation which is attached to the do activity
		// context object.
		this.context.unregister(this.encapsulatedAccepter);
		this.encapsulatedAccepter.accept(eventOccurrence);
		if(this.context.objectActivation.waitingEventAccepters.isEmpty()){
			// Make the state to complete if it is ready to do so
			if(this.context.owner!=null){
				this.context.owner.isDoActivityCompleted = true;
				if(this.context.owner.hasCompleted()){
					this.context.owner.notifyCompletion();
				}
			}
		}
	}

	@Override
	public Boolean match(EventOccurrence eventOccurrence) {
		// Simply delegates to the match operation of the encapsulated accepter
		// Note the accepter does not match if the object was destroyed. This can
		// occur when the DoActivity was aborted
		if(this.context.objectActivation==null){
			return false;
		}
		return this.encapsulatedAccepter.match(eventOccurrence);
	}

}
