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
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.InvocationActions.CS_SignalInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ArrivalSignal;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ClassifierBehaviorInvocationEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.InvocationEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.Behaviors.SM_ObjectActivation;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Vertex;

/**
 * This class captures the semantics of a state that can be either simple or composite. 
 */
public class StateActivation extends VertexActivation {
	
	// The visitors for the regions owned by this state
	protected List<RegionActivation> regionActivation;
	
	// The visitors for the connection points (EntryPoint / ExitPoint) owned by this state 
	protected List<PseudostateActivation> connectionPointActivation;
	
	// Boolean flag to know if the entry behavior was completed
	public boolean isEntryCompleted;
	
	// Boolean flag to know if the doActivity behavior was completed
	public boolean isDoActivityCompleted;
	
	// Boolean flag to know if the exit behavior was completed
	public boolean isExitCompleted; 
	
	// The context object in which is executed the doActivity
	// owned by the visited state
	public DoActivityContextObject doActivityContextObject;
	
	public boolean hasCompleted(){
		// A state can only be considered as being completed under the following circumstances
		// 1 - If the state is simple, both its entry and doActivity have finished their execution
		// 2 - If the state is composite, the same rules than used for the simple state, but additionally
		//     all the region of the state must have completed by reaching their final states
		// When the operation returns true then the generation of a completion event is allowed
		// for that particular state
		boolean stateCompleted = this.isEntryCompleted & this.isDoActivityCompleted;
		int i = 0;
		while(stateCompleted && i < this.regionActivation.size()){
			stateCompleted = stateCompleted && this.regionActivation.get(i).isCompleted; 
			i = i + 1;
		}
		return stateCompleted;
	}
	
	public void notifyCompletion(){
		// The notification of a completion event consists in sending in the execution
		// context of the state-machine a completion event occurrence. This event is
		// placed in the pool before any other event
		Object_ context = this.getExecutionContext();
		((SM_ObjectActivation)context.objectActivation).registerCompletionEvent(this);
	}
	
	public List<PseudostateActivation> getConnectionPointActivation(){
		return this.connectionPointActivation;
	}

	public PseudostateActivation getConnectionPointActivation(Vertex vertex){
		PseudostateActivation activation = null;
		int i = 0;
		while(i < this.connectionPointActivation.size() && activation==null){
			if(this.connectionPointActivation.get(i).getNode()==vertex){
				activation = this.connectionPointActivation.get(i);
			}
			i++;
		}
		return activation;
	}
	
	protected VertexActivation getVertexActivation(Vertex vertex){
		VertexActivation vertexActivation = null;
		State state = (State) this.getNode();
		if(state.isComposite()){
			vertexActivation = this.getConnectionPointActivation(vertex);
			if(vertexActivation==null){
				int i = 0;
				while(i < this.regionActivation.size() && vertexActivation==null){
					vertexActivation = this.regionActivation.get(i).getVertexActivation(vertex);
					i++;
				}
			}
		}
		return vertexActivation;
	}
	
	public List<RegionActivation> getRegionActivation() {
		return this.regionActivation;
	}

	public StateActivation(){
		super();
		this.isEntryCompleted = false;
		this.isDoActivityCompleted = false;
		this.regionActivation = new ArrayList<RegionActivation>();
		this.connectionPointActivation = new ArrayList<PseudostateActivation>();
	}
	
	public void activate(){
		// Instantiate visitors for all vertices owned by this region 
		State state = (State) this.getNode();
		if(state.isComposite()){
			Object_ context = this.getExecutionContext();
			for(Pseudostate connectionPoint : state.getConnectionPoints()){
				PseudostateActivation activation = (PseudostateActivation)context.locus.factory.instantiateVisitor(connectionPoint);
				activation.setParent(this);
				activation.setNode(connectionPoint);
				this.connectionPointActivation.add(activation);
			}
			for(Region region: state.getRegions()){
				RegionActivation activation = (RegionActivation) context.locus.factory.instantiateVisitor(region);
				activation.setParent(this);
				activation.setNode(region);
				activation.activate();
				this.regionActivation.add(activation);
			}
		}
	}
	
	public void activateTransitions(){
		// Instantiate visitor for transitions owned by this region
		State state = (State) this.getNode();
		if(state.isComposite()){
			for(RegionActivation activation : this.regionActivation){
				activation.activateTransitions();
			}
		}
	}
	
	public void tryExecuteEntry(){
		// If an entry behavior is specified for that state then it is executed
		State state = (State) this.getNode();
		if(!this.isEntryCompleted){
			Execution execution = this.getExecutionFor(state.getEntry());
			if(execution!=null){
				execution.execute();
				this.isEntryCompleted = true;
			}
			// If state has completed then generate a completion event
			if(this.hasCompleted()){
				this.notifyCompletion();
			}
		}
	}
	
	protected void tryInvokeDoActivity(){
		State state = (State) this.getNode();
		// If an doActivity behavior is specified for that state then it is executed*/
		if(!this.isDoActivityCompleted){
			Behavior doActivity = state.getDoActivity(); 
			if(doActivity!=null){
				// Initialization of the context object used by the doActivity which
				// is going to be invoked.
				this.doActivityContextObject = new DoActivityContextObject();
				Object_ stateMachineExecutionContext = this.getExecutionContext();
				this.doActivityContextObject.initialize(stateMachineExecutionContext);
				this.doActivityContextObject.owner = this;
				Execution doActivityExecution = this.getExecutionFor(doActivity);
				doActivityExecution.context = this.doActivityContextObject;
				// The doActivity is started asynchronously. This is realized by adding an invocation event accepter
				// for this doActivity within the event accepter list of the object activation attached to the currently
				// executed state machine
				ClassifierBehaviorInvocationEventAccepter invocation = new ClassifierBehaviorInvocationEventAccepter();
				invocation.execution = doActivityExecution;
				doActivityExecution.context.register(invocation);
				InvocationEventOccurrence eventOccurence = new InvocationEventOccurrence();
				eventOccurence.execution = doActivityExecution;
				stateMachineExecutionContext.objectActivation.eventPool.add(eventOccurence);
				stateMachineExecutionContext.objectActivation._send(new ArrivalSignal());
			}
		}
	}
	
	protected void tryExecuteExit(){
		// Execute the exit behavior if any
		State state = (State) this.getNode();
		Execution execution = this.getExecutionFor(state.getExit());
		if(execution!=null){
			execution.execute();
		}
		super.exit(null,null);
	}
	
	public void enterRegions(TransitionActivation enteringTransition){
		// Regions can be entered either implicitly or explicitly. 
		// A region is typically entered implicitly when its activation is triggered
		// by a transition terminating on the edge of its containing state.
		// A region is typically entered explicitly when one of its contained
		// state is targeted by a transition coming from the outside.
		// *** Regions are entered concurrently ***
		List<Vertex> targetedVertices = new ArrayList<Vertex>();
		VertexActivation sourceActivation = enteringTransition.getSourceActivation();
		if(sourceActivation instanceof ForkPseudostateActivation){
			Pseudostate fork = (Pseudostate)sourceActivation.getNode(); 
			for(int i = 0; i < fork.getOutgoings().size(); i++){
				targetedVertices.add(fork.getOutgoings().get(i).getTarget());
			}
		}else{
			VertexActivation targetActivation = enteringTransition.getTargetActivation();
			if(targetActivation instanceof EntryPointActivation){
				Pseudostate entryPoint = (Pseudostate)targetActivation.getNode();
				for(int i = 0; i < entryPoint.getOutgoings().size(); i++){
					targetedVertices.add(entryPoint.getOutgoings().get(i).getTarget());
				}
			}else{
				targetedVertices.add((Vertex)targetActivation.getNode());
			}
		}		
		for(int i=0; i < this.regionActivation.size(); i++){
			RegionActivation regionActivation = this.regionActivation.get(i);
			int j = 0;
			boolean found = false;
			while(j < targetedVertices.size() && !found){
				found = regionActivation.getVertexActivation(targetedVertices.get(j)) != null;
				j++;
			}
			if(!found){
				regionActivation.enter(enteringTransition);
			}
		}
	}
	
	public boolean isEnterable(TransitionActivation enteringTransition) {
		// A state can only be entered if it is not part of the state-machine configuration
		// (i.e., the state is not currently active)
		return !((StateMachineExecution)this.getStateMachineExecution()).getConfiguration().isActive(this);
	}
	
	public void enter(TransitionActivation enteringTransition, RegionActivation leastCommonAncestor) {
		if(this.status.equals(StateMetadata.IDLE)){
			// The state is entered via an explicit transition
			// The impact on the execution is that the parent state
			// of the current state is not active then it must be entered
			// the rule applies recursively
			if(leastCommonAncestor!=null){
				RegionActivation parentRegionActivation = (RegionActivation) this.getParent();
				if(leastCommonAncestor!=parentRegionActivation){
					StateActivation stateActivation = (StateActivation) parentRegionActivation.getParent();
					if(stateActivation!=null){
						stateActivation.enter(enteringTransition, leastCommonAncestor);
					}
				}
			}
			// Initialization
			State state = (State) this.getNode();
			super.enter(enteringTransition, leastCommonAncestor);
			this.isEntryCompleted = state.getEntry()==null;
			this.isDoActivityCompleted = state.getDoActivity()==null;
			this.isExitCompleted = state.getExit()==null;
			// When the state is entered it is registered in the current
			// state-machine configuration
			StateMachineExecution smExecution = (StateMachineExecution)this.getStateMachineExecution();
			smExecution.getConfiguration().register(this);
			// If state has completed then generate a completion event*/
			if(this.hasCompleted()){
				this.notifyCompletion();
			}else{
				// Execute the entry behavior if any
				this.tryExecuteEntry();
				// Invoke the doActivity if any
				this.tryInvokeDoActivity();
				// If the state is not completed, then try to start its owned regions.
				// A region is entered implicitly since the is not the 
				this.enterRegions(enteringTransition);
			}
		}
	}
	
	public boolean isExitable(TransitionActivation exitingTransition) {
		// A state can only be be exited if it is part of the state-machine configuration
		// (i.e., the state is currently active)
		return !this.isEnterable(exitingTransition);
	}
	
	public void exit(TransitionActivation exitingTransition, RegionActivation leastCommonAncestor){
		// If we exit a composite state, this provokes the termination of all of its regions 
		if(!this.regionActivation.isEmpty()){
			for(RegionActivation regionActivation : this.regionActivation){
				regionActivation.exit(exitingTransition);
			}
		}
		// If there is a doActivity currently executing then it is aborted
		if(!this.isDoActivityCompleted){
			this.doActivityContextObject.destroy();
			this.doActivityContextObject = null;
		}
		// If there is an exit behavior specified for the state it is executed
		if(!this.isExitCompleted){
			this.tryExecuteExit();
		}
		super.exit(exitingTransition, leastCommonAncestor);
		// When the state is exited then it is removed from the state-machine configuration
		StateMachineExecution smExecution = (StateMachineExecution)this.getStateMachineExecution();
		smExecution.getConfiguration().unregister(this);
		// Re-initialize the boolean flags
		this.isEntryCompleted = false;
		this.isDoActivityCompleted = false;
		this.isExitCompleted = false;
		// The state is exited by a transition that targets a state which is located within 
		// another region. This means parent state must also be exited.  
		if(leastCommonAncestor!=null){
			RegionActivation parentRegionActivation = (RegionActivation) this.getParent();
			if(leastCommonAncestor!=parentRegionActivation){
				StateActivation stateActivation = (StateActivation) parentRegionActivation.getParent();
				if(stateActivation!=null){
					stateActivation.exit(exitingTransition, leastCommonAncestor);
				}
			}
		}
	}
	
	public boolean canDefer(EventOccurrence eventOccurrence){
		// Return true if current state activation is capable of deferring the given
		// event occurrence; false otherwise.
		// 
		// Note: for the moment the evaluation is done with the assumption that the
		// received event occurrence is a signal event occurrence. This will change
		// as soon as other kind of event (e.g. call event) will be supported in fUML.
		boolean deferred = false;
		int i = 0;
		while(!deferred && i < ((State) this.node).getDeferrableTriggers().size()){
			Trigger trigger = ((State) this.node).getDeferrableTriggers().get(i);
			if(eventOccurrence instanceof SignalEventOccurrence
					&& trigger.getEvent() instanceof SignalEvent){
				SignalInstance signalInstance = ((SignalEventOccurrence)eventOccurrence).signalInstance;
				SignalEvent signalEvent = (SignalEvent) trigger.getEvent();
				deferred = signalInstance.type == signalEvent.getSignal();
				if(deferred && !trigger.getPorts().isEmpty() 
						&& signalInstance instanceof CS_SignalInstance){
					int j = 0;
					Port matchingPort = null;
					while(matchingPort==null && j < trigger.getPorts().size()){
						Port currentPort = trigger.getPorts().get(j);
						if(((CS_SignalInstance)signalInstance).interactionPoint.definingPort==currentPort){
							matchingPort = currentPort;
						}
						j++;
					}
					if(matchingPort==null){
						deferred = false;
					}
				}
			}
			i++;
		}
		return deferred;
	}
	
	public void defer(EventOccurrence eventOccurrence){
		// Postpone the time at which this event occurrence will be available at the event pool.
		// The given event occurrence is placed in the deferred event pool and will be released
		// only when the current state activation will leave the state-machine configuration.
		SM_ObjectActivation objectActivation = (SM_ObjectActivation) this.getExecutionContext().objectActivation;
		DeferredEventOccurrence deferredEventOccurrence = new DeferredEventOccurrence();
		deferredEventOccurrence.constrainingStateActivation = this;
		deferredEventOccurrence.deferredEventOccurrence = eventOccurrence;
		objectActivation.deferredEventPool.add(deferredEventOccurrence);
	}
	
	public void releaseDeferredEvents(){
		// If events have been deferred by that state then following set of action takes place:
		// 1 - The events return to the event pool owned by the object activation
		// 2 - The events are removed from the deferred event pool
		// Note: The release of events deferred by that state occurs when this latter
		// leaves the state-machine configuration.
		SM_ObjectActivation objectActivation = (SM_ObjectActivation) this.getExecutionContext().objectActivation;
		List<DeferredEventOccurrence> releasedDeferredEvent = new ArrayList<DeferredEventOccurrence>();
		for(int i=0; i < objectActivation.deferredEventPool.size(); i++){
			DeferredEventOccurrence eventOccurrence = objectActivation.deferredEventPool.get(i);
			if(eventOccurrence.constrainingStateActivation == this){
				releasedDeferredEvent.add(eventOccurrence);
				objectActivation.eventPool.add(eventOccurrence.deferredEventOccurrence);
				objectActivation._send(new ArrivalSignal());
			}
		}
		objectActivation.deferredEventPool.removeAll(releasedDeferredEvent);
	}
	
	public void terminate(){
		// A state gets terminated when the state-machine that contains it gets itself terminated.
		// If the state has an ongoing doActivity behavior then this latter is aborted. In addition,
		// the state is active then it is removed from the active state configuration.
		if(this.isActive()){
			if(!this.regionActivation.isEmpty()){
				for(int i = 0; i < this.regionActivation.size(); i++){
					this.regionActivation.get(i).terminate();
				}
				this.regionActivation.clear();
			}
			if(!this.isDoActivityCompleted){
				this.doActivityContextObject.destroy();
			}
			this.connectionPointActivation.clear();
		}
	}
}
