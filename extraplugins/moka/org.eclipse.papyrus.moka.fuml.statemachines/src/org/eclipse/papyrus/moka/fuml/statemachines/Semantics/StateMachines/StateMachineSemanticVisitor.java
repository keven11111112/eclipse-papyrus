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
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.CallEventOccurrence;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

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
		// Convenience method to make easier for each semantic visitor of the state-machine
		// the creation of an execution for a particular behavior. This is particularly useful
		// for visitors such as TransitionActivation and StateActivation.
		Execution execution = null;
		Locus locus = this.getExecutionLocus();
		if(behavior==null){
			return null;
		}else{
			// If the behavior that is going to be executed has one or more parameters then
			// take advantage of event occurrence to set parameter values. Otherwise the execution
			// will have no parameter values.
			if(behavior.getOwnedParameters().size() > 0){
				if(eventOccurrence instanceof SignalEventOccurrence){
					// If the triggering EventOccurrence is for a SignalEvent, then the executed behavior
					// must have one parameter.If the behavior has one parameter, then the type of the signal
					// instance associated to the event occurrence must conform to the parameter type. In case
					// no conformance can be established the behavior is not executed.
					SignalEventOccurrence signalEventOccurrence = (SignalEventOccurrence) eventOccurrence;
					if(behavior.getOwnedParameters().size() == 1){
						Parameter parameter = behavior.getOwnedParameters().get(0);
						if((parameter.getDirection() == ParameterDirectionKind.IN_LITERAL 
								|| parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL)
								&& (parameter.getType() == null 
								|| signalEventOccurrence.signalInstance.type.conformsTo(parameter.getType()))){
							execution = locus.factory.createExecution(behavior, this.getExecutionContext());
							ParameterValue parameterValue = new ParameterValue();
							parameterValue.parameter = parameter;
							List<Value> values = new ArrayList<Value>();
							values.add(signalEventOccurrence.signalInstance);
							parameterValue.values = values;
							execution.setParameterValue(parameterValue);
						}
					}
				}else if(eventOccurrence instanceof CallEventOccurrence){
					// Behavior triggered by the call event occurrence must have a signature conforming
					// to the operation for which the call was emitted. The conformance relationship is
					// established according to the following rules:
					// 
					// One signature conforms to another if the first signature has the same number of Parameters
					// as the second signature, and each Parameter of the first signature has a type that conforms
					// to the type of the corresponding Parameter (in order) from the second signature, a multiplicity
					// that is a superset of the second Parameter and the same ordering and uniqueness as the second
					// Parameter. (Note: An “empty type” is considered to conform to any other type, including “empty”,
					// while no non-empty type conforms to an “empty type”.)
					execution = locus.factory.createExecution(behavior, this.getExecutionContext());
					CallEventOccurrence callEventOccurrence = (CallEventOccurrence) eventOccurrence;
					List<Parameter> behaviorInputParameters = behavior.inputParameters();
					List<Parameter> operationInputParameters = callEventOccurrence.execution.operation.inputParameters();
					boolean inputConformance = true;
					if(behaviorInputParameters.size() != operationInputParameters.size()){
						inputConformance = false;
					}
					int i = 1;
					while(inputConformance && i <= behaviorInputParameters.size()){
						Parameter operationParameter = operationInputParameters.get(i - 1);
						Parameter behaviorParameter = behaviorInputParameters.get(i - 1);
						if(behaviorParameter.compatibleWith(operationParameter)){
							if(behaviorParameter.getType()==null
									|| behaviorParameter.getType().conformsTo(operationParameter.getType())){
								ParameterValue parameterValue = new ParameterValue();
								parameterValue.parameter = behaviorParameter;
								parameterValue.values = callEventOccurrence.execution.getInputParameterValues().get(i - 1).values;
								execution.setParameterValue(parameterValue);
							}else{
								inputConformance = false;
								execution = null;
							}
						}
						i++;
					}
				}
			}else{
				execution = locus.factory.createExecution(behavior, this.getExecutionContext());
			}
		}
		return execution;
	}
	
	public String toString(){
		return this.node.getName();
	}
}
