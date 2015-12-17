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

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ArrivalSignal;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.InvocationEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications.DoActivityExecutionEventAccepter;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;

public class DoActivityExecution extends Execution{

	// The actual execution
	public Execution execution;
	
	// The state from which initiated the execution of the doActivity
	public StateActivation owner;
	
	public void invoke(){
		// At invocation time an accepter is registered for the DoActivity execution
		// as well as a invocation event occurrence referencing this execution.
		DoActivityExecutionEventAccepter accepter = new DoActivityExecutionEventAccepter(this);
		this.context.objectActivation.register(accepter);
		InvocationEventOccurrence eventOccurrence = new InvocationEventOccurrence();
		eventOccurrence.execution = this;
		this.context.objectActivation.eventPool.add(eventOccurrence);
		this.context.objectActivation._send(new ArrivalSignal());
	}
	
	public void execute() {
		// Execute the actual execution. Complete the state that initiated the execution
		// if it is required (i.e., it has already completed other requirements)
		if(this.execution!=null){
			this.execution.encapsulatingExecution = this;
			this.execution.execute();
		}
	}
	
	public void terminate() {
		// Terminate the actual execution. When the execution terminate then
		// if the owner is ready to complete then, a completion event is generated
		if(this.execution!=null){
			this.execution.terminate();
			if(this.owner!=null){
				this.owner.isDoActivityCompleted = true;
				if(this.owner.hasCompleted()){
					this.owner.notifyCompletion();
				}
			}
		}
	}
	
	public void destroy() {
		// Destroy the actual execution 
		if(this.execution!=null){
			this.execution.destroy();
		}
	}
	
	public Behavior getBehavior() {
		// Get behavior of the actual execution
		Behavior behavior = null;
		if(this.execution!=null){
			behavior = this.execution.getBehavior();
		}
		return behavior;
	}
	
	public List<ParameterValue> getOutputParameterValues() {
		// Retrieve the output parameter values of the actual execution
		List<ParameterValue> outputParameterValues = null; 
		if(this.execution!=null){
			outputParameterValues = this.execution.getOutputParameterValues();
		}
		return outputParameterValues;
	}

	public ParameterValue getParameterValue(Parameter parameter) {
		// Retrieve the parameter value of the parameter of the actual execution
		ParameterValue parameterValue = null;
		if(this.execution!=null){
			parameterValue = this.execution.getParameterValue(parameter);
		}
		return parameterValue;
	}
	
	public ParameterValue getReturnParameterValue() {
		// Return the return parameter value of the actual execution
		ParameterValue returnParameterValue = null;
		if(this.execution!=null){
			this.execution.getReturnParameterValue();
		}
		return returnParameterValue;
	}
	
	public void setParameterValue(ParameterValue parameterValue) {
		// Set the parameter value of the actual execution
		if(this.execution!=null){
			this.execution.setParameterValue(parameterValue);
		}
	}
	
	public Value new_() {
		DoActivityExecution doActivityExecution = new DoActivityExecution();
		doActivityExecution.execution = (Execution)this.execution.new_();
		doActivityExecution.owner = this.owner;
		return doActivityExecution;
	}
	
	public void encapsulate(Execution execution){
		// Encapsulate the actual execution
		if(execution!=null){
			this.context = execution.context;
			this.objectActivation = execution.objectActivation;
			this.locus = execution.locus;
			for(int i = 0; i < execution.types.size(); i++){
				this.types.add(execution.types.get(i));
			}
			for(int i = 0; i < execution.featureValues.size(); i++){
				this.featureValues.add(execution.featureValues.get(i));
			}
			for(int i = 0; i < execution.parameterValues.size(); i++){
				this.parameterValues.add(execution.parameterValues.get(i));
			}
			this.execution = execution;
		}
	}
}
