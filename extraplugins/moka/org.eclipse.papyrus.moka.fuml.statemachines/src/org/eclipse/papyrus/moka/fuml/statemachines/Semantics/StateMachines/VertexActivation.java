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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.TransitionActivation.TransitionMetadata;
import org.eclipse.papyrus.moka.fuml.statemachines.debug.SM_ControlDelegate;
import org.eclipse.uml2.uml.Vertex;

public abstract class VertexActivation extends StateMachineSemanticVisitor {
	
	// ACTIVE = the vertex is currently in the state machine configuration
	// IDLE = the vertex is not in the state machine configuration
	public enum StateMetadata{IDLE, ACTIVE}
	
	// Status of the current vertex
	protected StateMetadata status;
	
	// Incoming transitions of that vertex
	protected List<TransitionActivation> incomingTransitionActivations;
	
	// Outgoing transitions of that vertex
	protected List<TransitionActivation> outgoingTransitionActivations;
	
	public VertexActivation(){
		super();
		this.setStatus(StateMetadata.IDLE);
		this.incomingTransitionActivations = new ArrayList<TransitionActivation>();
		this.outgoingTransitionActivations = new ArrayList<TransitionActivation>();
	}
	
	public VertexActivation getParentState(){
		// The parent state of a vertex is either a StateMachineExecution or a StateActivation
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
	
	public void setStatus(StateMetadata state){
		this.status = state;
	}
	
	public StateMetadata getStatus(){
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

	protected VertexActivation getVertexActivation(Vertex vertex){
		// By default return nothing. Must be overridden by state activation;
		return null;
	}
	
	public final void tagOutgoingTransitions(TransitionMetadata status){
		// Assign the given status to all outgoing transitions of this vertex 
		for(TransitionActivation transitionActivation: this.outgoingTransitionActivations){
			transitionActivation.setStatus(status);
		}
	}
	
	public final void tagIncomingTransitions(TransitionMetadata status){
		// Assign the given status to all incoming transitions of this vertex
		for(TransitionActivation transitionActivation: this.incomingTransitionActivations){
			transitionActivation.setStatus(status);
		}
	}
	
	public List<VertexActivation> getAscendingHierarchy(){
		// Provides the hierarchy of state activations starting from the current
		// element. This list is ordered from the innermost element to the outermost element
		List<VertexActivation> hierarchy = new ArrayList<VertexActivation>();
		List<SemanticVisitor> contextChain = this.getContextChain();
		for(SemanticVisitor element : contextChain){
			if(element instanceof StateActivation){
				hierarchy.add((StateActivation)element);
			}
		}
		return hierarchy;
	}
		
	public void enter(TransitionActivation enteringTransition, EventOccurrence eventOccurrence,  RegionActivation leastCommonAncestor){
		// 1-The vertex becomes active
		// 2-Outgoing transitions of this vertex are tagged as being REACHED
		// 3-The vertex starts to be highlighted
		logger.info(this.getNode().getName()+" => ACTIVE");
		this.setStatus(StateMetadata.ACTIVE);
		this.tagOutgoingTransitions(TransitionMetadata.REACHED);
		FUMLExecutionEngine.eInstance.getControlDelegate().control(this);
	}
	
	public void exit(TransitionActivation exitingTransition, EventOccurrence eventOccurrence, RegionActivation leastCommonAncestor){
		// 1-The representation of the vertex stops to be highlighted
		// 2-The incoming transitions of this vertex get back to the NONE status
		// 3- The vertex becomes IDLE
		((SM_ControlDelegate)FUMLExecutionEngine.eInstance.getControlDelegate()).inactive(this.getNode());
		this.tagIncomingTransitions(TransitionMetadata.NONE);
		this.setStatus(StateMetadata.IDLE);
		logger.info(this.getNode().getName()+" => IDLE");
	}
	
	public boolean isActive(){
		// FIXME: Shall be replaced by a call to the state-machine configuration
		// If a state is active, it is in the state-machine configuration
		return this.status.equals(StateMetadata.ACTIVE);
	}
	
	public RegionActivation getLeastCommonAncestor(VertexActivation targetVertexActivation){
		// Determine the semantic visitor being the least common ancestor between
		// the current vertex activation and the target vertex activation (provided as
		// a parameter). To  compute this common ancestor the both context chain from the
		// the current vertex activation and the target vertex activation are compared. As soon
		// as one different is found between the two context chain is found then it means we are
		// in presence of the least common ancestor. The least common ancestor is always 
		// a region activation.
		List<SemanticVisitor> sourceHierarchy = this.getContextChain();
		List<SemanticVisitor> targetHierarchy = targetVertexActivation.getContextChain();
		int i = sourceHierarchy.size() - 1;
		int j = targetHierarchy.size() - 1;
		SemanticVisitor source = null;
		SemanticVisitor target = null;
		SemanticVisitor ancestor = null;
		RegionActivation leastCommonAncestor = null;
		// Check if the source vertex activation contains the target vertex activation
		boolean isTargetContained = false;
		if(this.getVertexActivation((Vertex)targetVertexActivation.node) != null){
			isTargetContained = true;
		}
		while(leastCommonAncestor == null){
			// Retrieve the current element in the source hierarchy
			// null if index out of bounds
			if(i >= 0){
				source = sourceHierarchy.get(i);
			}else{
				source = null;
			}
			// Retrieve the current element in the target hierarchy
			// null if index out of bounds
			if(j >= 0){
				target = targetHierarchy.get(j);
			}else{
				target = null;
			}
			// Check if source and target are different. In such situation
			// determine the least common ancestor
			if(source != target){
				if(isTargetContained){
					ancestor = sourceHierarchy.get(i+1);
				}else{
					ancestor = sourceHierarchy.get(i);
				}
				if(ancestor instanceof RegionActivation){
					leastCommonAncestor = (RegionActivation) ancestor;
				}else if(ancestor instanceof VertexActivation){
					leastCommonAncestor = (RegionActivation) ((VertexActivation)ancestor).getParent();
				}
			}else if(source == null && target == null){
				// Case where the source and the target are identical
				leastCommonAncestor = (RegionActivation) ((StateMachineSemanticVisitor)sourceHierarchy.get(i+1)).getParent();
			}else{
				i--;
				j--;
			}
		}
		return leastCommonAncestor;
	}
	
	public boolean isEnterable(TransitionActivation enteringTransition){
		// By default a vertex has no prerequisites that need to be full-filled
		// to be entered. Nevertheless some vertex (e.g., join or exit) have such
		// prerequisites. Therefore this method is intended to be overridden in vertex
		// activation sub-classes. 
		return true;
	}
	
	public boolean isExitable(TransitionActivation exitingTransition){
		// By default a vertex has no prerequisites that need to be full-filled to be entered
		// Nevertheless some vertex (e.g., Fork) have such prerequisite. Therefore this method
		// is intended to be overridden in vertex activation sub-classes.
		return true;
	}
	
	public void terminate(){
		// Terminate applied by a vertex activation does nothing by default. However it is intended
		// to be overridden by sub-classe(s)  
		return;
	}
}
