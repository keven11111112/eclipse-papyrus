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
 *  Jeremie Tatibouet (CEA LIST) - Based on Ed Seidewitz remarks
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Classes.Kernel;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ObjectActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.StateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications.DoActivityExecutionEventAccepter;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.StructuralFeature;

public class DoActivityContextObject extends Object_ {
	
	// The state activation that initiated the execution of the
	// do activity behavior
	public StateActivation owner;
	
	// The context of the state-machine that lead to the invocation of the
	// doActivity behavior.
	public Object_ context;
	
	public void initialize(Object_ context){
		// Create the object activation and reference the context of the executing state-machine
		this.objectActivation = new ObjectActivation();
		this.objectActivation.object = this;
		if(context!=null){
			this.context = context;
		}
	}
	
	@Override
	public void register(EventAccepter accepter) {
		// The accepter is registered in the object activation event accepter list.
		// In addition the accepter is also registered in the object activation of
		// the context object of state machine to which the state activation belongs
		super.register(accepter);
		if(this.owner!=null){
			Object_ stateMachineExecutionContext =  this.owner.getExecutionContext();
			DoActivityExecutionEventAccepter encapsulatingAccepter = new DoActivityExecutionEventAccepter();
			encapsulatingAccepter.encapsulatedAccepter = accepter;
			encapsulatingAccepter.context = this;
			stateMachineExecutionContext.register(encapsulatingAccepter);
		}
	}
	
	@Override
	public FeatureValue getFeatureValue(StructuralFeature feature) {
		// Delegate read of a particular feature to the state-machine context
		FeatureValue featureValue = null;
		if(this.context!=null){
			featureValue = this.context.getFeatureValue(feature);
		}
		return featureValue;
	}
	
	@Override
	public void setFeatureValue(StructuralFeature feature, List<Value> values, Integer position) {
		// Delegate write of particular feature to the state-machine context
		if(this.context!=null){
			this.context.setFeatureValue(feature, values, position);
		}
	}
	
	@Override
	public Execution dispatch(Operation operation) {
		// Delegate operation call to the state-machine context
		Execution execution = null;
		if(this.context!=null){
			execution = this.context.dispatch(operation);
		}
		return execution;
	}
	
	@Override
	public void send(SignalInstance signalInstance) {
		// Delegate the reception of a signal to the state-machine context
		if(this.context!=null){
			this.context.send(signalInstance);
		}
	}
	
	@Override
	public void destroy() {
		// When destroyed in addition to the usual behavior, the do activity context object
		// has to remove the encapsulating accepters it may have registered.
		for(int i=0; i < this.objectActivation.waitingEventAccepters.size(); i++){
			this.unregisterFromContext(this.objectActivation.waitingEventAccepters.get(i));
		}
		super.destroy();
	}
	
	protected void unregisterFromContext(EventAccepter encapsulatedAccepter){
		// Unregister in the context of this do activity context the encapsulating
		// event accepter.
		ObjectActivation contextObjectActivation = this.context.objectActivation;
		if(contextObjectActivation!=null){
			DoActivityExecutionEventAccepter encapsulatingAccepter = null;
			int i = 0;
			while(encapsulatingAccepter==null && i < contextObjectActivation.waitingEventAccepters.size()){
				EventAccepter currentAccepter = contextObjectActivation.waitingEventAccepters.get(i);
				if(currentAccepter instanceof DoActivityExecutionEventAccepter
						&& ((DoActivityExecutionEventAccepter)currentAccepter).encapsulatedAccepter==encapsulatedAccepter){
					encapsulatingAccepter = (DoActivityExecutionEventAccepter) currentAccepter;
				}
				i++;
			}
			if(encapsulatingAccepter!=null){
				contextObjectActivation.unregister(encapsulatingAccepter);
			}
		}
	}
}
