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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Pseudostate.PseudostateActivation;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Vertex;

public class StateActivation extends VertexActivation {
	
	protected List<RegionActivation> regionActivation;
	
	protected List<PseudostateActivation> connectionPointActivation;
	
	public List<PseudostateActivation> getConnectionPointActivation(){
		return this.connectionPointActivation;
	}

	public PseudostateActivation getConnectionPointActivation(Vertex vertex){
		PseudostateActivation activation = null;
		int i = 0;
		while(i < this.connectionPointActivation.size() && activation==null){
			if(this.connectionPointActivation.get(i).getNode()==vertex){
				activation = this.connectionPointActivation.get(i);
			}
			i++;
		}
		return activation;
	}
	
	protected VertexActivation getVertexActivation(Vertex vertex){
		VertexActivation vertexActivation = null;
		State state = (State) this.getNode();
		if(state.isComposite()){
			vertexActivation = this.getConnectionPointActivation(vertex);
			if(vertexActivation==null){
				int i = 0;
				while(i < this.regionActivation.size() && vertexActivation==null){
					vertexActivation = this.regionActivation.get(i).getVertexActivation(vertex);
					i++;
				}
			}
		}
		return vertexActivation;
	}
	
	public List<RegionActivation> getRegionActivation() {
		return this.regionActivation;
	}

	public StateActivation(){
		super();
		this.regionActivation = new ArrayList<RegionActivation>();
		this.connectionPointActivation = new ArrayList<PseudostateActivation>();
	}
	
	public void activate(){
		State state = (State) this.getNode();
		/*Contains at least one region*/
		if(state.isComposite()){
			Object_ context = this.getExecutionContext();
			/*Handle pseudo-states*/
			for(Pseudostate connectionPoint : state.getConnectionPoints()){
				PseudostateActivation activation = (PseudostateActivation)context.locus.factory.instantiateVisitor(connectionPoint);
				activation.setParent(this);
				activation.setNode(connectionPoint);
				this.connectionPointActivation.add(activation);
			}
			/*Handle owned regions*/
			for(Region region: state.getRegions()){
				RegionActivation activation = (RegionActivation) context.locus.factory.instantiateVisitor(region);
				activation.setParent(this);
				activation.setNode(region);
				activation.activate();
				this.regionActivation.add(activation);
			}
		}
	}
	
	public void activateTransitions(){
		State state = (State) this.getNode();
		/*Contains at least one region*/
		if(state.isComposite()){
			for(RegionActivation activation : this.regionActivation){
				activation.activateTransitions();
			}
		}
	}
	
	public void doEntry(){
		StateMachineExecution smExecution = (StateMachineExecution)this.getStateMachineExecution();
		smExecution.getConfiguration().register(this);
		/*1. If an entry behavior is specified for that state then it is executed*/
		State state = (State) this.getNode();
		if(state.getEntry()!=null){
			Execution execution = this.getExecutionFor(state.getEntry());
			if(execution!=null){
				execution.execute();
			}
		}
		/*2. Regions become active (i.e. they start their execution)*/
		for(RegionActivation activation: this.regionActivation){
			activation.fireInitialTransition();
		}
	}
	
	protected void doActivity(){
		State state = (State) this.getNode();
		Execution execution = this.getExecutionFor(state.getDoActivity());
		if(execution!=null){
			execution.execute();
		}
	}
	
	protected void doExit(){
		/*1. Execute the exit behavior if any*/
		State state = (State) this.getNode();
		Execution execution = this.getExecutionFor(state.getExit());
		if(execution!=null){
			execution.execute();
		}
		/*2. Make the state idle and unregister if from the StateMachineConfiguration*/
		StateMachineExecution smExecution = (StateMachineExecution)this.getStateMachineExecution();
		smExecution.getConfiguration().unregister(this);
		super.exit(null);
	}
	
	public void exit(TransitionActivation exitingTransition){
		/* In the case we are in a composite state then
		 * sub-states must be exited 
		 * */
		if(!this.regionActivation.isEmpty()){
			for(RegionActivation regionActivation : this.regionActivation){
				regionActivation.exit();
			}
		}
		this.doExit();
	}
	
	@Override
	public void run() {
		if(this.state.equals(StateMetadata.IDLE)){
			super.run();
			this.doEntry();
			this.doActivity();
		}
	}
}
