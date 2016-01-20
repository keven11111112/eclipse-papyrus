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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.VertexActivation;

public class StateConfiguration {

	protected VertexActivation vertexActivation;
	
	protected StateConfiguration parent;
	
	protected List<StateConfiguration> children;
	
	private int level;
	
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
	
	private List<VertexActivation> getContext(VertexActivation activation){
		List<VertexActivation> context = new ArrayList<VertexActivation>();
		List<VertexActivation> hierarchy = activation.getAscendingHierarchy();
		int i = hierarchy.size();
		int j = 0;
		boolean found = false;
		while(i >= 1 && !found){
			while(j < this.children.size() && !found){
				if(this.children.get(j).vertexActivation==hierarchy.get(i-1)){
					found = true;
					context = hierarchy.subList(1, i);
				}
				j++;
			}
			j = 0;
			i--;
		}
		return context;
	}
	
	/**
	 * 
	 * @param activation
	 * @return
	 */
	public boolean removeChild(VertexActivation activation){
		return this.remove(activation, this.getContext(activation));
	}
	
	/**
	 * Remove the activation from the given configuration
	 * @param activation - the activation to be removed
	 * @param context - the path to the activation
	 * @return true if the activation was removed false in the other case
	 */
	private boolean remove(VertexActivation activation, List<VertexActivation> context){
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
					/*1. Remove its reference from the cartography*/
					this.completeConfiguration.deleteFromCartography(this.children.get(i));
					/*2. Remove the configuration from the tree*/
					this.children.remove(i);
					removed = true;
				}
				i++;
			}
		}
		return removed;
	}
	
	/**
	 * 
	 * @param activation
	 * @return
	 */
	public boolean addChild(VertexActivation activation){
		return this.add(activation, this.getContext(activation));	
	}
	
	/**
	 * 
	 * @param activation
	 * @param context
	 * @return
	 */
	private boolean add(VertexActivation activation, List<VertexActivation> context){
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
				/*1. Build the new StateConfiguration to add in the tree*/
				StateConfiguration newConfiguration = new StateConfiguration(activation);
				newConfiguration.level = this.level + 1;
				newConfiguration.completeConfiguration = this.completeConfiguration;
				/*2. Add it to the cartography*/
				this.completeConfiguration.addToCartography(newConfiguration);
				/*3. Add it to the tree */
				added = this.children.add(newConfiguration);
			}
		}
		return added;
	}
	
	public String toString(){
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
