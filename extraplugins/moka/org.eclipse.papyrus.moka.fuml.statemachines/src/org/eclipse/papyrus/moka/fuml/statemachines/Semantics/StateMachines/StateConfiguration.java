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

public class StateConfiguration {

	// The activation (i.e. the semantic visitor) for which the StateConfiguration
	// represents an element of the state-machine configuration.
	protected VertexActivation vertexActivation;
	
	// The parent state configuration of this node
	protected StateConfiguration parent;
	
	// The children state configuration of this state-machine configuration
	protected List<StateConfiguration> children;
	
	// The level at which the the state configuration is located in the hierarchy.
	private int level;
	
	// A reference to the complete state-machine configuration
	private StateMachineConfiguration completeConfiguration;
	
	public StateConfiguration(StateMachineConfiguration configuration){
		this.level = 0;
		this.vertexActivation = null;
		this.children = new ArrayList<StateConfiguration>();
		this.completeConfiguration = configuration;
	}
	
	public StateConfiguration(VertexActivation activation){
		this.level = 0;
		this.children = new ArrayList<StateConfiguration>();
		this.vertexActivation = activation;
	}
	
	protected int getLevel(){
		return this.level;
	}
	
	public List<StateConfiguration> getChildren(){
		return this.children;
	}
	
	public StateConfiguration getParent(){
		return this.parent;
	}
	
	public VertexActivation getVertexActivation(){
		return this.vertexActivation;
	}
	
	public void setParent(StateConfiguration configuration){
		this.parent = configuration;
	}
	
	public boolean removeChild(VertexActivation activation){
		// Remove a vertex activation from the state machine configuration tree.
		return this.remove(activation, this.getContext(activation));
	}
	
	public boolean addChild(VertexActivation activation){
		// Add a vertex activation in the state machine configuration tree.
		return this.add(activation, this.getContext(activation));	
	}
	
	public boolean isConfigurationFor(VertexActivation activation){
		// Check if the given vertex activation belongs to the 
		// state machine configuration.
		return this.isConfigurationFor(activation, this.getContext(activation));
	}
	
	private boolean isConfigurationFor(VertexActivation activation, List<VertexActivation> context){
		// A vertex activation belongs to the state machine configuration if it is referenced
		// in the state configuration tree. True is returned if a state configuration
		// in that tree references the vertex activation, false otherwise. In order to find the
		// state configuration referencing the activation, a directed search is performed  in the
		// state configuration tree. This directed search relies on the path (ascending hierarchy
		// of vertex activation) provided by the context.
		boolean isConfiguration = false;
		if(!context.isEmpty()){
			int i = 0;
			StateConfiguration selectedStateConfiguration = null; 
			VertexActivation current = context.get(context.size()-1);
			while(selectedStateConfiguration == null && i < this.children.size()){
				if(this.children.get(i).vertexActivation == current){
					selectedStateConfiguration = this.children.get(i);
				}
				i++;
			}
			if(selectedStateConfiguration != null){
				isConfiguration = selectedStateConfiguration.isConfigurationFor(activation, context.subList(0, context.size()-1));
			}
		}else{
			int i = 0;
			while(!isConfiguration && i < this.children.size()){
				if(this.children.get(i).vertexActivation == activation){
					isConfiguration = true;
				}
				i++;
			}
		}
		return isConfiguration;
	}
	
	private List<VertexActivation> getContext(VertexActivation activation){
		// Provide the path from this state configuration to the target state configuration.
		// The path is presented as an ascending hierarchy (nested -> top) of vertex activations.
		// This path is used to perform a directed search through the representation of 
		// state configuration tree.
		List<VertexActivation> context = new ArrayList<VertexActivation>();
		List<VertexActivation> hierarchy = activation.getAscendingHierarchy();
		int i = hierarchy.size();
		int j = 0;
		boolean found = false;
		while(!found && i >= 1){
			while(!found && j < this.children.size()){
				if(this.children.get(j).vertexActivation==hierarchy.get(i-1)){
					found = true;
					// The most nested element in the hierarchy is always discarded.
					// This nested element is the activation
					context = hierarchy.subList(1, i); 
				}
				j++;
			}
			j = 0;
			i--;
		}
		return context;
	}

	private boolean remove(VertexActivation activation, List<VertexActivation> context){
		// Follows the path provided by the context (ascending hierarchy of vertex activations)
		// until the state configuration being the parent of the one referencing the activation
		// is found. When found, the chil state configuration referencing the activation gets
		// removed from the state configuration tree.
		boolean removed = false;
		if(!context.isEmpty()){
			VertexActivation current = context.get(context.size()-1);
			StateConfiguration selectedStateConfiguration = null; 
			int i = 0;
			while(i < this.children.size() && selectedStateConfiguration==null){
				if(this.children.get(i).vertexActivation==current){
					selectedStateConfiguration = this.children.get(i);
				}
				i++;
			}
			if(selectedStateConfiguration!=null){
				removed = selectedStateConfiguration.remove(activation, context.subList(0, context.size()-1));
			}
		}else{
			int i = 0;
			while(i < this.children.size() && !removed){
				if(this.children.get(i).vertexActivation==activation){
					this.children.remove(i);
					removed = true;
				}
				i++;
			}
		}
		return removed;
	}
	
	private boolean add(VertexActivation activation, List<VertexActivation> context){
		// Follows the path provided by the context (ascending hierarchy of vertex activations)
		// until the state configuration referencing the parent vertex activation of the activation
		// is found. When found, a new state configuration is added as a children of the current
		// state configuration. This new state configuration references the activation.
		boolean added = false;
		if(!context.isEmpty()){
			VertexActivation current = context.get(context.size()-1);
			StateConfiguration selectedStateConfiguration = null; 
			int i = 0;
			while(i < this.children.size() && selectedStateConfiguration==null){
				if(this.children.get(i).vertexActivation==current){
					selectedStateConfiguration = this.children.get(i);
				}
				i++;
			}
			if(selectedStateConfiguration!=null){
				added = selectedStateConfiguration.add(activation, context.subList(0, context.size()-1));
			}
		}else{
			int i = 0;
			boolean alreadyAdded = false;
			while(i < this.children.size() && !alreadyAdded){
				if(this.children.get(i).vertexActivation==activation){
					alreadyAdded = true;
				}
				i++;
			}
			if(!alreadyAdded){
				StateConfiguration newConfiguration = new StateConfiguration(activation);
				newConfiguration.level = this.level + 1;
				newConfiguration.completeConfiguration = this.completeConfiguration;
				added = this.children.add(newConfiguration);
			}
		}
		return added;
	}
	
	public String toString(){
		// Return a string representing configuration taking this node as a the root.
		// The string that is obtained is possibly a partial representation of the
		// state-machine configuration.
		String result = "";
		int i = 0;
		result = this.vertexActivation==null ? "ROOT" : this.vertexActivation.getNode().getName();
		result+="(L"+this.level+")";
		if(!this.children.isEmpty()){
			result+="[";
			while(i < this.children.size()){
				result+=this.children.get(i).toString();
				if(i < this.children.size()-1){
					result+=", ";
				}
				i++;
			}
			result+="]";
		}
		return result;
	}
}
