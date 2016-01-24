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


import static org.eclipse.papyrus.moka.fuml.statemachines.Activator.logger;

import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.InvocationActions.CS_SignalInstance;
import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Evaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.StateMachineSemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Values.Expressions.StateMachineOpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.fuml.statemachines.debug.SM_ControlDelegate;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Port;
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
					((StateMachineOpaqueExpressionEvaluation)evaluation).context = this.getExecutionContext() ;
				}
				if(evaluation!=null){
					BooleanValue evaluationResult = (BooleanValue)evaluation.evaluate() ;
					result = evaluationResult.value ;
				}
			}
			
		}
		return result;
	}
	
	public boolean hasTrigger(final SignalInstance signal){
		// Return true if the following transition has a trigger that is reactive
		// to the given signal instance.
		int i = 0;
		Transition transition = (Transition)this.node;
		Trigger trigger = null;
		while(i < transition.getTriggers().size() && trigger==null){
			Trigger currentTrigger = transition.getTriggers().get(i);
			if(currentTrigger.getEvent()!=null && 
					currentTrigger.getEvent() instanceof SignalEvent
					&& ((SignalEvent)currentTrigger.getEvent()).getSignal()==signal.type){
				if(currentTrigger.getPorts().size() > 0) {
					List<Port> portsOfTrigger = currentTrigger.getPorts();
					Port onPort = ((CS_SignalInstance)signal).interactionPoint.definingPort;
					Boolean portMatches = false;
					int j = 1;
					while(!portMatches & j <= portsOfTrigger.size()) {
						portMatches = onPort == portsOfTrigger.get(j - 1);
						j = j + 1;
					}
					if(portMatches){
						trigger = currentTrigger;
					}
				}else{
					trigger = currentTrigger;
				}
			}
			i++;
		}
		return trigger != null;
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
