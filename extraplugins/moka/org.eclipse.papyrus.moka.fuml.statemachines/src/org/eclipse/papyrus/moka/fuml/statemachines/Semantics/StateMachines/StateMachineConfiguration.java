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

import org.eclipse.papyrus.moka.fuml.statemachines.debug.Debug;

public class StateMachineConfiguration {
		
	// The state-machine that is executed and for which this object
	// represents the hierarchy of active states.
	protected StateMachineExecution execution;
	
	// The root node of the state machine configuration. It represents
	// the top level active state.
	protected StateConfiguration rootConfiguration;
	
	public StateConfiguration getRoot(){
		return this.rootConfiguration;
	}
	
	public StateMachineExecution getExecution(){
		return this.execution;
	}
	
	public StateMachineConfiguration(StateMachineExecution execution){
		this.rootConfiguration = new StateConfiguration(this);
		this.execution = execution;
	}
		
	public boolean register(StateActivation stateActivation){
		// Register the given state activation in the state-machine configuration.
		// This occurs when the state activation is entered.
		boolean added = this.rootConfiguration.addChild(stateActivation);
		if(added){
			Debug.log(this.toString());
		}
		return added;
	}
	
	public boolean unregister(StateActivation stateActivation){
		// Unregister the given state activation from the state-machine configuration
		// This occurs when the state activation is exited. When the removal process
		// is successful the last action is to release possibly deferred events related
		// to that state activation.
		boolean removed = this.rootConfiguration.removeChild(stateActivation);
		Debug.log(this.toString());
		if(removed){
			stateActivation.releaseDeferredEvents();
		}
		return removed;
	}
	
	public boolean isActive(VertexActivation activation){
		// A vertex that is currently active is part of the state-machine configuration
		return this.rootConfiguration.isConfigurationFor(activation);
	}
	
	public String toString(){
		// Return a string representing the current state-machine configuration.
		// This representation takes the following form:
		// [ROOT(L0)[S1(L1)[S1.X(L2), S.2.X(L2)]]]
		return "["+this.rootConfiguration.toString()+"]";
	}
}
