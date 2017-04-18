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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.EventTriggeredExecution;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;

public abstract class StateMachineSemanticVisitor extends SemanticVisitor {

	// Each semantic visitor for a state-machine know its parent visitor 
	protected SemanticVisitor parent;

	// Each semantic visitor traverse a particular node of a state-machine
	protected NamedElement node;
	
	public NamedElement getNode() {
		return node;
	}

	public void setNode(NamedElement node) {
		this.node = node;
	}

	public SemanticVisitor getParent() {
		return parent;
	}

	public void setParent(SemanticVisitor parent) {
		this.parent = parent;
	}

	public StateMachineSemanticVisitor(){
		this.parent = null;
	}
	
	public List<SemanticVisitor> getContextChain(){
		// Return the hierarchy of visitors that need to be traversed to access
		// the visitor that called context chain. The caller is part of the returned
		// context chain.
		List<SemanticVisitor> contextChain = new ArrayList<SemanticVisitor>();
		if(!(this instanceof ExitPointPseudostateActivation) && !(this instanceof EntryPointPseudostateActivation)){
			contextChain.add(this);
		}
		if(this.parent!=null){
			if(this.parent instanceof StateMachineExecution){
				contextChain.add(this.parent);
			}else{
				contextChain.addAll(((StateMachineSemanticVisitor)this.parent).getContextChain());
			}
		}
		return contextChain;
	}
		
	public Execution getStateMachineExecution(){
		// Return the state-machine execution from which the caller of this operation belongs
		if(this.parent!=null && this.parent instanceof StateMachineExecution){
			return (Execution)this.parent;
		}else{
			return ((StateMachineSemanticVisitor)this.parent).getStateMachineExecution();
		}
	}
	
	public Locus getExecutionLocus(){
		return this.getStateMachineExecution().locus;
	}
	
	public Object_ getExecutionContext(){
		return this.getStateMachineExecution().context;
	}
	
	public boolean isVisitorFor(NamedElement node){
		// A visitor is the interpreter for a model if the node given as parameter is the
		// this model element.
		return this.node == node;
	}
	
	public void activate(){
		// This operation is intended to be overridden by sub-classes. For required sub-classes
		// (e.g., RegionActivation, StateActivation) it will initiate the instantiation phase of
		// child semantic visitors. By default activate does nothing.
		return;
	}
	
	public void activateTransitions(){
		// ActivateTransition is intended to be overridden by sub-classes. It will capture the instantiation
		// of transitions visitors as well as the linking between these visitors and the required vertices
		// activation. By default activate does nothing.
		return;
	}
	
	protected Execution getExecutionFor(Behavior behavior, EventOccurrence eventOccurrence){
		// Create an Execution for the specified behavior. In addition to the creation of this
		// Execution, if the behavior execution is triggered by the dispatching of an event (i.e.
		// a CallEvent or a SignalEvent) then an EventTriggeredExecution is provided. This
		// execution wraps the original execution and ensures passing of event data to the
		// wrapped execution.
		Execution execution = null;
		if(behavior != null){
			Execution originalExecution = this.getExecutionLocus().factory.createExecution(behavior, this.getExecutionContext());
			if(eventOccurrence != null){
				EventTriggeredExecution containerExecution = new EventTriggeredExecution();
				containerExecution.triggeringEventOccurrence = eventOccurrence;
				containerExecution.wrappedExecution = originalExecution;
				containerExecution.context = originalExecution.context;
				execution = containerExecution;
			}else{
				execution = originalExecution;
			}
		}
		return execution;
	}
	
	public String toString(){
		return this.node.getName();
	}
}
