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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.LociL3;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Pseudostate.EntryPointActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Pseudostate.ExitPointActivation;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;


/**
 * Common ancestor to state machine semantic visitor
 * (i.e., RegionActivation, TransitionActivation, VertexActivation)
 *
 */
public abstract class StateMachineSemanticVisitor extends SemanticVisitor {

	protected SemanticVisitor parent;

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
		List<SemanticVisitor> contextChain = new ArrayList<SemanticVisitor>();
		if(!(this instanceof ExitPointActivation) && !(this instanceof EntryPointActivation)){
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
	
	public void activate(){
		//By default it does nothing
		return;
	}
	
	public void activateTransitions(){
		//By default it does nothing
		return;
	}
	
	protected Execution getExecutionFor(Behavior behavior){
		Locus locus = this.getExecutionLocus();
		if(behavior==null){
			return null;
		}else{
			return locus.factory.createExecution(behavior, this.getExecutionContext());
		}
	}
	
	public String toString(){
		return this.node.getName();
	}
}
