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
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Classes.Kernel.SM_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.LociL3.SM_SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.debug.SM_ControlDelegate;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.TransitionKind;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.ValueSpecification;

public class TransitionActivation extends SM_SemanticVisitor {
	
	/**
	 * Provide the status of a specific transition
	 * 
	 * NONE: The transition exists, however its source state was is not yet reached 
	 * REACHED: The source vertex of the transition is reached
	 * TRAVERSED: The transition is being executed
	 * COMPLETED: The source transition was executed and its target state is reached 
	 */
	public enum TransitionMetadata{NONE, REACHED, TRAVERSED, COMPLETED}
	
	protected VertexActivation vertexSourceActivation;
	
	protected VertexActivation vertexTargetActivation;
	
	protected TransitionMetadata status;
	
	public TransitionMetadata getState() {
		return status;
	}

	public void setState(TransitionMetadata state) {
		this.status = state;
	}

	public TransitionActivation(){
		super();
		this.status = TransitionMetadata.NONE;
	}

	public boolean isReached(){
		return this.status.equals(TransitionMetadata.REACHED);
	}
	
	public boolean isTraversed(){
		return this.status.equals(TransitionMetadata.TRAVERSED);
	}
	
	public boolean isCompleted(){
		return this.status.equals(TransitionMetadata.COMPLETED);
	}
	
	/**
	 * A transition that is automatic has no triggers and no guard.  
	 * @return boolean
	 */
	public boolean isAutomatic(){
		Transition transition = (Transition)this.node;
		return transition.getTriggers().isEmpty() && transition.getGuard() == null;
	}
		
	/**
	 * @return true if the guard evaluates to true false in the other case
	 */
	public boolean evaluateGuard(){
		boolean result = true;  
		Transition transition = (Transition) this.node;
		if (transition.getGuard() != null) {
			ValueSpecification specification = transition.getGuard().getSpecification() ;
			if(specification!=null){
				Evaluation evaluation = null;
				if (specification instanceof OpaqueExpression) {
					evaluation = this.getExecutionLocus().factory.createEvaluation(specification);
					((SM_OpaqueExpressionEvaluation)evaluation).context = this.getExecutionContext() ;
				}else if(specification instanceof LiteralBoolean){
					evaluation = this.getExecutionLocus().factory.createEvaluation(specification);
				}
				if(evaluation!=null){
					BooleanValue evaluationResult = (BooleanValue)evaluation.evaluate() ;
					result = evaluationResult.value ;
				}
			}
			
		}
		return result;
	}
	
	/**
	 * True if the transition has a trigger which matches the given signal type 
	 */
	public boolean hasTrigger(final SignalInstance signal){
		int i = 0;
		Transition transition = (Transition)this.node;
		Trigger trigger = null;
		while(i < transition.getTriggers().size() && trigger==null){
			Trigger currentTrigger = transition.getTriggers().get(i);
			/*1. Check that expected signal type and conforms to signal instance type*/
			if(currentTrigger.getEvent()!=null && 
					currentTrigger.getEvent() instanceof SignalEvent
					&& ((SignalEvent)currentTrigger.getEvent()).getSignal()==signal.type){
				/*1.1. The port from which the signal was emitted must be one which is referenced
				 * in the trigger*/
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
	
	/**
	 * A triggered transition means implies event accepters are registered. If one them match
	 * an available signal the transition can be elected to fire
	 * @return boolean
	 */
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
	
	public void executeEffect(){
		// Execute the effect that is on the transition if it exists one
		Transition transition = (Transition) this.getNode();
		Execution execution = this.getExecutionFor(transition.getEffect());
		if(execution!=null){
			execution.execute();
		}
	}
	
	public StateActivation getContainingState(){
		// Get the state containing the region which contains the transition
		RegionActivation regionActivation = (RegionActivation) this.getParent();
		if(regionActivation!=null){
			if(regionActivation.getParent() instanceof StateActivation){
				return (StateActivation) regionActivation.getParent();
			}
		}
		return null;
	}
	
	protected void exitSource(){
		// A source state is exited when the transition fires under the following conditions:
		// 1 - The transition leaving the source state is external
		// 2 - The transition leaving the source state is local but the source state is not the
		//	   state which contains the transition
		Transition node = (Transition) this.getNode();
		boolean exitSourceState = false;
		RegionActivation leastCommonAncestor = null;
		if(node.getKind()==TransitionKind.EXTERNAL_LITERAL){
			exitSourceState = true;
		}else if(node.getKind()==TransitionKind.LOCAL_LITERAL){
			StateActivation stateActivation = this.getContainingState();
			exitSourceState = stateActivation!=null && node.getSource()!=stateActivation.getNode();
		}
		if(exitSourceState){
			if(this.vertexSourceActivation.getParentState()!=this.vertexTargetActivation.getParentState()){
				leastCommonAncestor = this.vertexSourceActivation.getLeastCommonAncestor(this.vertexTargetActivation);
			}
			this.vertexSourceActivation.exit(this, leastCommonAncestor);
		}
	}
	
	protected void enterTarget(){
		Transition node = (Transition) this.getNode();
		RegionActivation leastCommonAncestor = null;
		// A target state is always entered except when the transition reaching this latter
		// has the internal kind
		if(node.getKind()!=TransitionKind.INTERNAL_LITERAL){
			if(this.vertexSourceActivation.getParentState()!=this.vertexTargetActivation.getParentState()){
				leastCommonAncestor = this.vertexSourceActivation.getLeastCommonAncestor(this.vertexTargetActivation);
			}
			this.vertexTargetActivation.enter(this, leastCommonAncestor);
		}
	}
	
	public void fire(){
		this.exitSource();
		// FIXME: specific to the Moka implementation
		FUMLExecutionEngine.eInstance.getControlDelegate().control(this); 
		this.executeEffect();
		// FIXME: specific to the Moka implementation
		((SM_ControlDelegate)FUMLExecutionEngine.eInstance.getControlDelegate()).inactive(this.getNode()); 
		this.setState(TransitionMetadata.TRAVERSED);
		// FIXME: specific to the Moka implementation
		logger.info(this.getNode().getName()+" => TRAVERSED");
		this.enterTarget();
	}
	
	public String toString(){
		return "["+this.getSourceActivation()+"] -> ["+this.getTargetActivation()+"]";
	}
}
