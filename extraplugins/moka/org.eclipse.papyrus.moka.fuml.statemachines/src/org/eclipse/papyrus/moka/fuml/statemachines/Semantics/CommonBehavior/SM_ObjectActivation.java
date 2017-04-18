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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ArrivalSignal;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ObjectActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.CompletionEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.DeferredEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.StateActivation;

public class SM_ObjectActivation extends ObjectActivation {

	// Events that have been dispatched but that are actually deferred are placed
	// in this particular event pool. When the state that constrained them to be
	// placed in this pool leaves the state-machine configuration then the deferred
	// events leave this pool and are placed in the regular event pool (to be dispatched
	// again) that is handled by the object activation.
	public List<DeferredEventOccurrence> deferredEventPool;
	
	public SM_ObjectActivation(){
		super();
		this.deferredEventPool = new ArrayList<DeferredEventOccurrence>();
	}
	
	protected CompletionEventOccurrence getNextCompletionEvent(){
		// Return the next completion event available at the pool.
		int i = 0;
		CompletionEventOccurrence completionEvent = null;
		while(completionEvent == null && i < this.eventPool.size()){
			if(this.eventPool.get(i) instanceof CompletionEventOccurrence){
				completionEvent = (CompletionEventOccurrence) this.eventPool.get(i);
				this.eventPool.remove(i);
			}
			i++;
		}
		return completionEvent;
	}
	
	protected int getDeferredEventInsertionIndex(){
		// Deferred events are always registered after completion events if any.
		// Return the insertion point for deferred events.
		int index = 0;
		int i = 0;
		while(i < this.eventPool.size()){
			if(this.eventPool.get(i) instanceof CompletionEventOccurrence){
				index++;
			}
			i++;
		}
		return index;
	}
	
	public EventOccurrence getNextEvent() {
		// Completion events are always dispatched first. They are dispatched according
		// to their order of arrival in the pool. While completion event are available at
		// the pool no other event is dispatched. If not there is no more completion event
		// to dispatch then regular events are dispatched according to the currently used
		// dispatching policy. Note that if the currently dispatched event occurrence was
		// previously deferred the it is unwrapped and it encapsulated 'deferredEventOccurrence'
		// is actually dispatched.
		EventOccurrence nextEvent = this.getNextCompletionEvent(); 
		if(nextEvent==null){
			nextEvent = super.getNextEvent();
			if(nextEvent instanceof DeferredEventOccurrence){
				nextEvent = ((DeferredEventOccurrence)nextEvent).deferredEventOccurrence;
			}
		}
		return nextEvent;
	}
	
	public void register(CompletionEventOccurrence completionEventOccurrence){
		// A completion event is registered in the completion event pool.
		// Completion events are always registered at the head of the event pool.
		// Its final position in the pool depends on the existence of other completion
		// events already registered in the pool.
		int insertionIndex = 0;
		boolean insertionPointFound = false;
		while(!insertionPointFound && insertionIndex < this.eventPool.size()){
			insertionPointFound = !(this.eventPool.get(insertionIndex) instanceof CompletionEventOccurrence);
			if(!insertionPointFound){
				insertionIndex++;
			}
		}
		this.eventPool.add(insertionIndex, completionEventOccurrence);
		this._send(new ArrivalSignal());
	}
	
	public void register(DeferredEventOccurrence deferredEventOccurrence){
		// Add the deferred event occurrence in deferred event occurrence
		this.deferredEventPool.add(deferredEventOccurrence);
	}
	
	public void releaseDeferredEvents(StateActivation deferringState){
		// The release of event occurrence(s) deferred by the deferring state includes the following step:
		// 1. Deferred events are removed from the deferred event pool 
		// 2. Deferred events return to the regular event pool. They are inserted in the pool
		//    after any existing completion event occurrence but before any other events that
		//    arrived later.
		List<DeferredEventOccurrence> releasedEvents = new ArrayList<DeferredEventOccurrence>();
		for(int i=0; i < this.deferredEventPool.size(); i++){
			DeferredEventOccurrence eventOccurrence = this.deferredEventPool.get(i);
			if(eventOccurrence.constrainingStateActivation == deferringState){
				releasedEvents.add(eventOccurrence);
			}
		}
		int insertionPoint = this.getDeferredEventInsertionIndex();
		int i = 0;
		while(i < releasedEvents.size()){
			this.eventPool.add(insertionPoint, releasedEvents.get(i));
			this._send(new ArrivalSignal());
			insertionPoint++;
			i++;
		}
		releasedEvents.clear();
	}
}
