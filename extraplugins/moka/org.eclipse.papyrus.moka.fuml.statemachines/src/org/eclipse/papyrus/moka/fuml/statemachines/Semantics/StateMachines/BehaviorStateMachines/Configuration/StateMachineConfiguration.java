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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Configuration;

import static org.eclipse.papyrus.moka.fuml.statemachines.Activator.logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.VertexActivation;

public class StateMachineConfiguration {
		
	/**
	 * The state machine execution for which this object plays the role configuration 
	 */
	protected StateMachineExecution execution;
	
	/**
	 * The root configuration has no associated activation 
	 */
	protected StateConfiguration rootConfiguration;
	
	/**
	 * Cartography of the state-machine configuration
	 */
	private Map<Integer, List<VertexActivation>> cartorgraphy;
	
	public StateConfiguration getRoot(){
		return this.rootConfiguration;
	}
	
	public StateMachineExecution getExecution(){
		return this.execution;
	}
	
	public Map<Integer, List<VertexActivation>> getCartography(){
		return this.cartorgraphy;
	}
	
	public StateMachineConfiguration(StateMachineExecution execution){
		this.rootConfiguration = new StateConfiguration(this);
		this.execution = execution;
		this.cartorgraphy = new HashMap<Integer, List<VertexActivation>>();
	}
	
	protected void addToCartography(StateConfiguration configuration){
		if(this.cartorgraphy.containsKey(configuration.getLevel())){
			this.cartorgraphy.get(configuration.getLevel()).add(configuration.vertexActivation);
		}else{
			List<VertexActivation> activation = new ArrayList<VertexActivation>();
			activation.add(configuration.getVertexActivation());
			this.cartorgraphy.put(configuration.getLevel(), activation);
		}
	}
	
	protected void deleteFromCartography(StateConfiguration configuration){
		if(this.cartorgraphy.containsKey(configuration.getLevel())){
			this.cartorgraphy.get(configuration.getLevel()).remove(configuration.vertexActivation);
		}
	}
		
	public boolean register(StateActivation stateActivation){
		return this.add(stateActivation);
	}
	
	public boolean unregister(StateActivation stateActivation){
		return this.remove(stateActivation);
	}
	
	public boolean isActive(VertexActivation activation){
		// A vertex that is currently active is part of the state-machine configuration
		boolean found = false;
		Iterator<Integer> levelsIterator = this.cartorgraphy.keySet().iterator();
		while(!found && levelsIterator.hasNext()){
			found = this.cartorgraphy.get(levelsIterator.next()).contains(activation);
		}
		return found;
	}
	
	protected boolean remove(VertexActivation activation){
		boolean removed = this.rootConfiguration.removeChild(activation);
		logger.info(this.toString());
		return removed; 
	}
	
	protected boolean add(VertexActivation activation){
		boolean added = this.rootConfiguration.addChild(activation);
		logger.info(this.toString());
		return added;
	}
	
	public String toString(){
		return "["+this.rootConfiguration.toString()+"]";
	}
}
