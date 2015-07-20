/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.dnd.smart.graph.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.api.AbstractUml2GraphServices;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.NodeEClass;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.Path;

/**
 * One basic implementation to retrieve Path of actions given a set of source/target elements
 * @author flefevre
 *
 */
public class GenericUml2GraphServices extends AbstractUml2GraphServices {

	
	public GenericUml2GraphServices()
	{
		super();
	}
	
	public GenericUml2GraphServices(int depth, int threshold)
	{
		super(depth,threshold);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.dnd.smart.graph.api.Uml2GraphServices#proposedActionsFromDnd(org.eclipse.emf.ecore.EClass, org.eclipse.emf.ecore.EClass)
	 *
	 * @param source
	 * @param target
	 * @return
	 */
	public Set<Path> proposedActionsFromDnd(EClass source, EClass target) {
		//Retrieve the node from the graph
		NodeEClass mySourceNode = uml2Graph.getNodeEClassMap().get(source.getInstanceTypeName());
		NodeEClass myTargetNode = uml2Graph.getNodeEClassMap().get(target.getInstanceTypeName());
		//Compute the paths and filter them
		return proposedActionsFromDnd(mySourceNode, myTargetNode) ;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.dnd.smart.graph.api.Uml2GraphServices#proposedActionsFromDnd(java.lang.String, java.lang.String)
	 *
	 * @param source
	 * @param target
	 * @return
	 */
	public Set<Path> proposedActionsFromDnd(String source, String target) {
		NodeEClass mySourceNode = uml2Graph.getNodeEClassMap().get(source);
		NodeEClass myTargetNode = uml2Graph.getNodeEClassMap().get(target);
		return proposedActionsFromDnd(mySourceNode, myTargetNode);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.dnd.smart.graph.api.Uml2GraphServices#proposedLitteralActionsFromDnd(java.lang.String, java.lang.String)
	 *
	 * @param source
	 * @param target
	 * @return
	 */
	public Collection<String> proposedLitteralActionsFromDnd(String source, String target) {
		Collection<String> result = new ArrayList<String>();
		
		Set<Path> paths= proposedActionsFromDnd(source, target);
		
		for(Path p :paths){
			result.add(p.getName()+"\n");
		}
		return result;
	}

}
