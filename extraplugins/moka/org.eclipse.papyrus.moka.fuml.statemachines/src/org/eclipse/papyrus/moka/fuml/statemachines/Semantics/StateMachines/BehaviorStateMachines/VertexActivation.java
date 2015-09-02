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

import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.SM_EventAccepter;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.LociL3.SM_SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation.TransitionMetadata;
import org.eclipse.papyrus.moka.fuml.statemachines.debug.SM_ControlDelegate;
import org.eclipse.uml2.uml.Vertex;

import static org.eclipse.papyrus.moka.fuml.statemachines.Activator.logger;

public abstract class VertexActivation extends SM_SemanticVisitor {
	
	public enum StateMetadata{IDLE, ACTIVE}
	
	protected StateMetadata state;
	
	protected List<TransitionActivation> incomingTransitionActivations;
	
	protected List<TransitionActivation> outgoingTransitionActivations;
	
	public VertexActivation(){
		super();
		this.setState(StateMetadata.IDLE);
		this.incomingTransitionActivations = new ArrayList<TransitionActivation>();
		this.outgoingTransitionActivations = new ArrayList<TransitionActivation>();
	}
	
	public VertexActivation getParentState(){
		RegionActivation regionActivation = (RegionActivation)this.getParent();
		if(regionActivation!=null){
			if(regionActivation.getParent() instanceof StateMachineExecution){
				return null;
			}else{
				return (VertexActivation) regionActivation.getParent();
			}
		}
		return null;
	}
	
	public void setState(StateMetadata state){
		this.state = state;
	}
	
	public StateMetadata getState(){
		return this.state;
	}
	
	public void addIncomingTransition(TransitionActivation activation){
		this.incomingTransitionActivations.add(activation);
	}
	
	public void addOutgoingTransition(TransitionActivation activation){
		this.outgoingTransitionActivations.add(activation);
	}
	
	public List<TransitionActivation> getOutgoingTransitions(){
		return this.outgoingTransitionActivations;
	}

	/**
	 * By default return nothing. Must be overridden by state activation;
	 * @param vertex
	 * @return null
	 */
	protected VertexActivation getVertexActivation(Vertex vertex){
		return null;
	}
	
	public final void tagOutgoingTransitions(TransitionMetadata status){
		for(TransitionActivation transitionActivation: this.outgoingTransitionActivations){
			transitionActivation.setState(status);
		}
	}
	
	public final void tagIncomingTransitions(TransitionMetadata status){
		for(TransitionActivation transitionActivation: this.incomingTransitionActivations){
			transitionActivation.setState(status);
		}
	}
	
	/**
	 * Provides the hierarchy of state activations starting from the current
	 * element. This list is ordered from the innermost element to the outermost element
	 * @return List<VertexActivation>
	 */
	public List<VertexActivation> getAscendingHierarchy(){
		List<VertexActivation> hierarchy = new ArrayList<VertexActivation>();
		List<SemanticVisitor> contextChain = this.getContextChain();
		for(SemanticVisitor element : contextChain){
			if(element instanceof StateActivation){
				hierarchy.add((StateActivation)element);
			}
		}
		return hierarchy;
	}
		
	/**
	 * Describes the semantics of a vertex
	 */
	public void run(){
		logger.info(this.getNode().getName()+" => ACTIVE");
		/*1. The vertex becomes active*/
		this.setState(StateMetadata.ACTIVE);
		/*2. Register event accepters for transitions having triggers*/
		this.tryToPlaceEventAccepter();
		/*3. Vertex outgoing transitions are tag as REACHED*/
		this.tagOutgoingTransitions(TransitionMetadata.REACHED);
		/*4. The vertex starts to be highlighted*/
		FUMLExecutionEngine.eInstance.getControlDelegate().control(this);
	}
	
	/**
	 * Describes the semantics of a vertex when exited
	 */
	public void exit(TransitionActivation exitingTransition){
		/*1. The representation of the vertex stops to be highlighted*/
		((SM_ControlDelegate)FUMLExecutionEngine.eInstance.getControlDelegate()).inactive(this.getNode());
		/*2. If there is a event accepter for the state-machine then remove it*/
		this.removeEventAccepter();
		/*3. The incoming transitions of this vertex get back to the NONE status*/
		this.tagIncomingTransitions(TransitionMetadata.NONE);
		/*4. The vertex becomes IDLE*/
		this.setState(StateMetadata.IDLE);
		logger.info(this.getNode().getName()+" => IDLE");
	}
	
	/**
	 * Implicit exit consists in exiting a state without using a transition
	 */
	public final void implicitExit(){
		this.exit(null);
	}
	
	public boolean isActive(){
		return this.state.equals(StateMetadata.ACTIVE);
	}
	
	/**
	 * Determines if the registration of an event accepter is required 
	 * 
	 * @return
	 */
	protected boolean mustRegisterEventAccepter(){
		List<SemanticVisitor> contextChain = this.getContextChain();
		int i = 0;
		boolean accepterRequired = false;
		while(contextChain.get(i) instanceof StateActivation && !accepterRequired){
			StateActivation stateActivation = (StateActivation)contextChain.get(i);
			int t = 0;
			while(!accepterRequired && t < stateActivation.getOutgoingTransitions().size()){
				if(stateActivation.getOutgoingTransitions().get(i).isTriggered()){
					accepterRequired = true;
				}
				t++;
			}
			i++;
		}
		return accepterRequired;
	}
	
	/**
	 * Register event accepters corresponding to the transition within the context object
	 * executing the state-machine
	 */
	protected void tryToPlaceEventAccepter() {
		if(this.mustRegisterEventAccepter()){
			 Execution execution = this.getStateMachineExecution();
			 execution.context.register(new SM_EventAccepter(((StateMachineExecution)execution)));
		}
	}
	
	/**
	 * Remove all event accepters that are registered in the context of the given Vertex
	 */
	public void removeEventAccepter(){
		int i = 0;
		Execution execution = this.getStateMachineExecution();
		EventAccepter accepter = null;
		while(i < execution.context.objectActivation.waitingEventAccepters.size()
				&& accepter==null){
			accepter = execution.context.objectActivation.waitingEventAccepters.get(i);
			if(!(accepter instanceof SM_EventAccepter)){
				accepter = null;
			}
		}
		if(accepter!=null){
			execution.context.objectActivation.unregister(accepter);
		}
	}
}
