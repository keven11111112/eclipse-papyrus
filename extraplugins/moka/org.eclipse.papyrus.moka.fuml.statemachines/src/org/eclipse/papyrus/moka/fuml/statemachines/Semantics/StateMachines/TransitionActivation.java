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


import static org.eclipse.papyrus.moka.fuml.statemachines.Activator.logger;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.InvocationActions.CS_SignalInstance;
import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Evaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.CallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Values.SM_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.fuml.statemachines.debug.SM_ControlDelegate;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class TransitionActivation extends StateMachineSemanticVisitor {
	
	// Provide the status of a specific transition
	// NONE: The transition exists, however its source state was is not yet reached 
	// REACHED: The source vertex of the transition is reached
	// TRAVERSED: The transition was executed
	public enum TransitionMetadata{NONE, REACHED, TRAVERSED}
	
	// The source activation of this transition activation
	protected VertexActivation vertexSourceActivation;
	
	// The target activation of this transition activation
	protected VertexActivation vertexTargetActivation;
	
	// The status (NONE, REACHED, TRAVERSED or COMPLETED) of the transition
	protected TransitionMetadata status;
	
	// Least common ancestor of the source and the target. This is materialized
	// by the region activation that is the common ancestor of the source and the target. 
	private RegionActivation leastCommonAncestor;
	
	public TransitionMetadata getStatus() {
		return status;
	}

	public void setStatus(TransitionMetadata state) {
		this.status = state;
	}

	public TransitionActivation(){
		super();
		this.status = TransitionMetadata.NONE;
	}

	public boolean isReached(){
		/// Convenience operation which returns true if the status of this transition
		// is REACHED; false otherwise.
		return this.status.equals(TransitionMetadata.REACHED);
	}
	
	public boolean isTraversed(){
		// Convenience operation which returns true if the status of this transition
		// is TRAVERSED; false otherwise.
		return this.status.equals(TransitionMetadata.TRAVERSED);
	}
	
	
	public boolean isTriggered(){
		return !((Transition)this.node).getTriggers().isEmpty();
	}
	
	public boolean isGuarded(){
		return ((Transition)this.node).getGuard()!=null;
	}
	
	public VertexActivation getSourceActivation() {
		return vertexSourceActivation;
	}

	public void setSourceActivation(VertexActivation vertexSourceActivation) {
		this.vertexSourceActivation = vertexSourceActivation;
	}

	public VertexActivation getTargetActivation() {
		return vertexTargetActivation;
	}

	public void setTargetActivation(VertexActivation vertexTargetActivation) {
		this.vertexTargetActivation = vertexTargetActivation;
	}
	
	public boolean evaluateGuard(){
		// Evaluate the guard specification thanks to an evaluation.
		// The evaluation does not presume of the type of the guard specification.
		boolean result = true;  
		Transition transition = (Transition) this.node;
		if (transition.getGuard() != null) {
			ValueSpecification specification = transition.getGuard().getSpecification() ;
			if(specification!=null){
				Evaluation evaluation = this.getExecutionLocus().factory.createEvaluation(specification);
				if (specification instanceof OpaqueExpression) {
					((SM_OpaqueExpressionEvaluation)evaluation).context = this.getExecutionContext() ;
				}
				if(evaluation!=null){
					BooleanValue evaluationResult = (BooleanValue)evaluation.evaluate() ;
					result = evaluationResult.value ;
				}
			}
			
		}
		return result;
	}
	
	public boolean hasTrigger(EventOccurrence eventOccurrence){
		// Return true if the event occurrence matches a trigger of this transition.
		// The following cases are supported:
		// 1] If 'onPort' is specified then the event occurrence can only be a signal event occurrence.
		//    **NOTE**: This limitation is related to the fact that PSCS is for the moment not able to
		//    manage event occurrences that are not signal events.   
		// 2] Otherwise, call event occurrence as well signal event occurrence are supported
		int i = 0;
		Transition transition = (Transition) this.node;
		Trigger trigger = null;
		while(trigger==null && i < transition.getTriggers().size()){
			Trigger currentTrigger = transition.getTriggers().get(i);
			if(currentTrigger.getPorts().size() > 0){
				Event event = currentTrigger.getEvent();
				if(event instanceof SignalEvent & eventOccurrence instanceof SignalEventOccurrence){
					if(((SignalEvent)event).getSignal() == ((SignalEventOccurrence)eventOccurrence).signalInstance.type){
						trigger = currentTrigger;
					}
					if(trigger != null){
						int j = 0;
						boolean matchingPort = false; 
						while(j < trigger.getPorts().size() & !matchingPort){
							matchingPort = ((CS_SignalInstance)((SignalEventOccurrence)eventOccurrence).signalInstance).interactionPoint == trigger.getPorts().get(j); 
							j = j + 1;
						}
						if(!matchingPort){
							trigger = null;
						}
					}
				}
			}else{
				Event event = currentTrigger.getEvent();
				if(event instanceof CallEvent & eventOccurrence instanceof CallEventOccurrence){
					if(((CallEvent)event).getOperation() == ((CallEventOccurrence)eventOccurrence).execution.operation){
						trigger = currentTrigger;
					}
				}else if(event instanceof SignalEvent & eventOccurrence instanceof SignalEventOccurrence){
					if(((SignalEvent)event).getSignal() == ((SignalEventOccurrence)eventOccurrence).signalInstance.type){
						trigger = currentTrigger;
					}
				}
			}
			i++;
		}
		return trigger != null;
	}
	
	public boolean canFireOn(EventOccurrence eventOccurrence){
		// A transition is can fire when:
		//
		// A completion event is being dispatched and this transition has no trigger
		// but its eventual guard evaluates to true. Note: the scope of a completion
		// event is the state from which it was generated
		//
		// A signal event is being dispatched and this transition has a trigger
		// that matches the signal and its eventual guard evaluates to true
		boolean reactive = true;
		if(eventOccurrence instanceof CompletionEventOccurrence){
			reactive = !this.isTriggered() &&
						this.getSourceActivation()==((CompletionEventOccurrence)eventOccurrence).stateActivation &&
						this.evaluateGuard();
		}else if(eventOccurrence instanceof SignalEventOccurrence | eventOccurrence instanceof CallEventOccurrence){
			reactive = this.hasTrigger(eventOccurrence) && this.evaluateGuard();
		}else{
			reactive = false;
		}
		return reactive;
	}
	
	public void executeEffect(){
		// Execute the effect that is on the transition if it exists one
		Transition transition = (Transition) this.getNode();
		Execution execution = this.getExecutionFor(transition.getEffect());
		if(execution!=null){
			execution.execute();
		}
	}
	
	public void fire(){
		// The fire sequence is broken into the following set of actions
		// 1 - Exit the source (depends on the kind of transition that is currently used)
		// 2 - Execute the effect (if one exists for that transition)
		// 3 - Enter the target (depends on the kind of transition that is currently used)
		this.exitSource();
		FUMLExecutionEngine.eInstance.getControlDelegate().control(this); 
		this.executeEffect();
		((SM_ControlDelegate)FUMLExecutionEngine.eInstance.getControlDelegate()).inactive(this.getNode()); 
		this.setStatus(TransitionMetadata.TRAVERSED);
		logger.info(this.getNode().getName()+" => TRAVERSED");
		this.enterTarget();
	}
	

	protected RegionActivation getLeastCommonAncestor(){
		// Return the common ancestor of the source and the target. This common ancestor is
		// a region activation
		if(this.vertexSourceActivation.getParentState()!=this.vertexTargetActivation.getParentState()){
			if(this.leastCommonAncestor==null){
				this.leastCommonAncestor = this.vertexSourceActivation.getLeastCommonAncestor(this.vertexTargetActivation);
			}
		}
		return this.leastCommonAncestor;
	}
	
	/*
	 * This operation is intended to be implemented by sub-classes.
	 * Sub-classes capture how the source vertex activation must be exited. 
	 */
	protected abstract void exitSource();
	
	/*
	 * This operation is intended to be implemented by sub-classes.
	 * Sub-classes capture how the target vertex activation must be entered.
	 */
	protected abstract void enterTarget();
	
	public String toString(){
		return "["+this.getSourceActivation()+"] -> ["+this.getTargetActivation()+"]";
	}
}
