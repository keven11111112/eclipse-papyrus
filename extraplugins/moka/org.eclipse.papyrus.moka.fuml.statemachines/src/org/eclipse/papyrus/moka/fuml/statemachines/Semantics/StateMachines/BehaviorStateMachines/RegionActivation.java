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

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.LociL3.StateMachineSemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Pseudostate.InitialPseudostateActivation;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

public class RegionActivation extends StateMachineSemanticVisitor{
		
	protected List<VertexActivation> vertexActivations;
	
	protected List<TransitionActivation> transitionActivations;
	
	public boolean isCompleted;
	
	public List<VertexActivation> getVertexActivations() {
		return vertexActivations;
	}

	public List<TransitionActivation> getTransitionActivations() {
		return transitionActivations;
	}
	
	public RegionActivation(){
		this.node = null;
		this.isCompleted = false;
		this.vertexActivations = new ArrayList<VertexActivation>();
		this.transitionActivations = new ArrayList<TransitionActivation>();
	}
	
	/**
	 * Create visitors for all vertices owned by the region
	 */
	public void activate(){
		Locus locus = this.getExecutionLocus();
		VertexActivation activation = null;
		Region region = (Region)this.getNode();
		for(Vertex vertex : region.getSubvertices()){
			activation = (VertexActivation)locus.factory.instantiateVisitor(vertex);
			activation.setParent(this);
			activation.setNode(vertex);
			activation.activate();
			this.vertexActivations.add(activation);
		}
	}
	
	/**
	 * Create visitors for all transitions owned by the region
	 */
	public void activateTransitions(){
		Region region = (Region)this.getNode();
		VertexActivation sourceActivation = null;
		VertexActivation targetActivation = null;
		TransitionActivation transitionActivation = null;
		StateMachineExecution context = (StateMachineExecution)this.getStateMachineExecution();
		for(Transition transition : region.getTransitions()){
			sourceActivation = context.getVertexActivation(transition.getSource());
			targetActivation = context.getVertexActivation(transition.getTarget());
			transitionActivation = (TransitionActivation) context.locus.factory.instantiateVisitor(transition);
			transitionActivation.setNode(transition);
			transitionActivation.setParent(this);
			transitionActivation.setSourceActivation(sourceActivation);
			transitionActivation.setTargetActivation(targetActivation);
			this.transitionActivations.add(transitionActivation);
			sourceActivation.addOutgoingTransition(transitionActivation);
			targetActivation.addIncomingTransition(transitionActivation);
		}
		for(VertexActivation activation: this.getVertexActivations()){
			activation.activateTransitions();
		}
	}
	
	/**
	 * Search the corresponding visitor in the hierarchy owned by this region
	 * @param vertex - the vertex for which an activation is searched
	 * @return vertexActivation - the corresponding activation
	 */
	protected VertexActivation getVertexActivation(Vertex vertex){
		int i = 0;
		VertexActivation activation = null;
		/*1. Same level search*/
		while(activation==null && i < this.vertexActivations.size()){
			if(vertex==this.vertexActivations.get(i).getNode()){
				activation = this.vertexActivations.get(i);
			}
			i++;
		}
		/*2. Do a descending search*/
		i = 0;
		while(activation==null && i < this.vertexActivations.size()){
			if(vertex==this.vertexActivations.get(i).getNode()){
				activation = this.vertexActivations.get(i);
			}else{
				activation = this.vertexActivations.get(i).getVertexActivation(vertex);
			}
			i++;
		}
		return activation;
	}
	
	protected void enter(TransitionActivation enteringTransition){
		// An implicit entry of a region means the initial transition is searched.
		// If such transition exists then it is fired. An explicit entry as no impact on the region.
		// In case the region is entered implicitly a initial pseudo state shall be found to
		// start its execution. If no such pseudo-state is found and the state containing
		// the region has no other region(s) then the state is treated as a simple leaf state
		int i = 0; 
		VertexActivation initialNodeActivation = null;
		while(initialNodeActivation==null && i < this.vertexActivations.size()){
			if(this.vertexActivations.get(i) instanceof InitialPseudostateActivation){
				initialNodeActivation = this.vertexActivations.get(i);
			}else{
				i++;
			}
		}
		if(initialNodeActivation!=null){
			for(TransitionActivation transitionActivation : initialNodeActivation.getOutgoingTransitions()){
				transitionActivation.fire();
			}
		}else{
			SemanticVisitor parent = this.getParent();
			if(parent != null && parent instanceof StateActivation){
				StateActivation parentState = (StateActivation) parent; 
				parentState.regionActivation.remove(this);
				if(parentState.hasCompleted()){
					parentState.notifyCompletion();
				}
			}
		}
	}
	
	public void exit(TransitionActivation exitingTransition){
		// Exiting a region implies exiting all of is active vertices.
		for(VertexActivation vertexActivation: this.getVertexActivations()){
			if(vertexActivation.isActive()){
				vertexActivation.exit(exitingTransition, null);
			}
		}
	}
	
	public void terminate(){
		// Capture the semantics related to the termination of a region. Regions typically
		// gets terminated when the state-machine which contains it is gets itself terminated.
		for(int i=0; i < this.vertexActivations.size(); i++){
			this.vertexActivations.get(i).terminate();
		}
		this.vertexActivations.clear();
		this.transitionActivations.clear();
	}
}