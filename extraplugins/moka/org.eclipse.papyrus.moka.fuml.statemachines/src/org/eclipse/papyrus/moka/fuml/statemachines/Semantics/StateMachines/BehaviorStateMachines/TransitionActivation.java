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

import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Evaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Classes.Kernel.SM_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.LociL3.SM_SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.debug.SM_ControlDelegate;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.TransitionKind;
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
	
	protected TransitionMetadata state;
	
	public TransitionMetadata getState() {
		return state;
	}

	public void setState(TransitionMetadata state) {
		this.state = state;
	}

	public TransitionActivation(){
		super();
		this.state = TransitionMetadata.NONE;
	}

	public boolean isReached(){
		return this.state.equals(TransitionMetadata.REACHED);
	}
	
	public boolean isTraversed(){
		return this.state.equals(TransitionMetadata.TRAVERSED);
	}
	
	public boolean isCompleted(){
		return this.state.equals(TransitionMetadata.COMPLETED);
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
			if (specification instanceof OpaqueExpression) {
				Evaluation evaluation = this.getExecutionLocus().factory.createEvaluation(specification) ;
				((SM_OpaqueExpressionEvaluation)evaluation).context = this.getExecutionContext() ;
				BooleanValue evaluationResult = (BooleanValue)evaluation.evaluate() ;
				result = evaluationResult.value ;
			}
		}
		return result;
	}
	
	/**
	 * @return true if a trigger of this transition is enabled by an event in the event pool false in the other case
	 */
	public boolean hasTriggerEnabled(final SignalInstance signal){
		boolean result = false;
		Object_ context = this.getExecutionContext();
		int i = 0;
		while(i < context.objectActivation.waitingEventAccepters.size() && !result){
			EventAccepter accepter = context.objectActivation.waitingEventAccepters.get(i);
			if(((TransitionEventAccepter)accepter).getTransition()==this){
				result = accepter.match(signal);
			}
			i++;
		}
		return result;
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
	
	public void effect(){
		Transition transition = (Transition) this.getNode();
		Execution execution = this.getExecutionFor(transition.getEffect());
		if(execution!=null){
			execution.execute();
		}
	}
	
	public void fire(){
		Transition node = (Transition) this.getNode();
		logger.info(this.getNode().getName()+" => TRAVERSED");
		this.setState(TransitionMetadata.TRAVERSED);
		/*1. Exit the source state (if transition is local or external)*/
		if(node.getKind()!=TransitionKind.INTERNAL_LITERAL){
			this.vertexSourceActivation.exit(this);
		}
		FUMLExecutionEngine.eInstance.getControlDelegate().control(this);
		/*2. Execute the effect on the transition if present*/
		this.effect();
		/*3. Run the target state (if transition is local or external)*/
		((SM_ControlDelegate)FUMLExecutionEngine.eInstance.getControlDelegate()).inactive(this.getNode());
		if(node.getKind()!=TransitionKind.INTERNAL_LITERAL){
			this.vertexTargetActivation.run();
		}
	}
	
	public String toString(){
		return "["+this.getSourceActivation()+"] -> ["+this.getTargetActivation()+"]";
	}
}
