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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.LociL3.StateMachineSemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation.TransitionMetadata;
import org.eclipse.papyrus.moka.fuml.statemachines.debug.SM_ControlDelegate;
import org.eclipse.uml2.uml.Vertex;

/**
 *	A visitor for a vertex owned by a state-machine 
 */
public abstract class VertexActivation extends StateMachineSemanticVisitor {
	
	public enum StateMetadata{IDLE, ACTIVE}
	
	// Meta-information about the state
	// used by the implementation only for debug
	protected StateMetadata status;
	
	// Incoming transitions of that vertex
	protected List<TransitionActivation> incomingTransitionActivations;
	
	// Outgoing transitions of that vertex
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
		this.status = state;
	}
	
	public StateMetadata getState(){
		return this.status;
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
	
	public List<TransitionActivation> getIncomingTransitions(){
		return this.incomingTransitionActivations;
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
	public void enter(TransitionActivation enteringTransition,  RegionActivation leastCommonAncestor){
		logger.info(this.getNode().getName()+" => ACTIVE");
		/*1. The vertex becomes active*/
		this.setState(StateMetadata.ACTIVE);
		/*2. Vertex outgoing transitions are tag as REACHED*/
		this.tagOutgoingTransitions(TransitionMetadata.REACHED);
		/*3. The vertex starts to be highlighted*/
		FUMLExecutionEngine.eInstance.getControlDelegate().control(this);
	}
	
	/**
	 * Describes the semantics of a vertex when exited
	 */
	public void exit(TransitionActivation exitingTransition, RegionActivation leastCommonAncestor){
		/*1. The representation of the vertex stops to be highlighted*/
		((SM_ControlDelegate)FUMLExecutionEngine.eInstance.getControlDelegate()).inactive(this.getNode());
		/*2. The incoming transitions of this vertex get back to the NONE status*/
		this.tagIncomingTransitions(TransitionMetadata.NONE);
		/*3. The vertex becomes IDLE*/
		this.setState(StateMetadata.IDLE);
		logger.info(this.getNode().getName()+" => IDLE");
	}
	
	/**
	 * Implicit exit consists in exiting a state without using a transition
	 */
	public final void implicitExit(){
		this.exit(null,null);
	}
	
	public boolean isActive(){
		// FIXME: Shall be replaced by a call to the state-machine configuration
		// If a state is active, it is in the state-machine configuration
		return this.status.equals(StateMetadata.ACTIVE);
	}
	
	public RegionActivation getLeastCommonAncestor(VertexActivation targetVertexActivation){
		// Calculate paths from both vertices to the root of the state-machine.
		// Compare the paths, the first difference means the previous item in the
		// path was the least common ancestor.
		List<SemanticVisitor> sourceHierarchy = this.getContextChain();
		List<SemanticVisitor> targetHierachy = targetVertexActivation.getContextChain();
		int i = targetHierachy.size() - 1;
		int j = sourceHierarchy.size() - 1;
		RegionActivation leastCommonAncestor = null;
		while(i >= 0 && j >= 0 && leastCommonAncestor==null){
			if(targetHierachy.get(i)!=sourceHierarchy.get(j)){
				leastCommonAncestor = (RegionActivation) sourceHierarchy.get(j+1);
			}
			i--;
			j--;
		}
		if(leastCommonAncestor==null){
			StateActivation commonAncestor = (StateActivation) sourceHierarchy.get(j+1);
			VertexActivation searchedVertexActivation = sourceHierarchy.size() >= targetHierachy.size() ? this : targetVertexActivation;
			int x = 0;
			while(leastCommonAncestor==null && x < commonAncestor.getRegionActivation().size()){
				RegionActivation regionActivation = commonAncestor.getRegionActivation().get(x);
				if(regionActivation.getVertexActivation((Vertex)searchedVertexActivation.node)!=null){
					leastCommonAncestor = regionActivation;
				}
				x++;
			}
		}
		return leastCommonAncestor;
	}
}
