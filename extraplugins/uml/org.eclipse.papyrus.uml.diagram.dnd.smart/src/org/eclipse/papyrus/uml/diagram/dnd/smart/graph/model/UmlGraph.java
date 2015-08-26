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

package org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The main class dedicated to hold the graph defintion of an uml model 
 * @author flefevre
 *
 */
public class UmlGraph extends AbstractUmlGraph{
	
	public UmlGraph(){
		super();
	}
	
	public void addVertex(NodeEClass nodeEClassEReference){
		source2InEdges.put(nodeEClassEReference,new ArrayList<EdgeEReference>());
		source2OutEdges.put(nodeEClassEReference,new ArrayList<EdgeEReference>());
	}
	
	public boolean addEdge(EdgeEReference edgeEReference, NodeEClass source, NodeEClass target){
		edge2Source.put(edgeEReference, source);
		edge2Target.put(edgeEReference, target);
		
		Collection<EdgeEReference> ins = source2InEdges.get(target);
		if(ins==null){
			ins = new ArrayList<EdgeEReference>();
		}
		ins.add(edgeEReference);
		source2InEdges.put(target,ins);
		
		Collection<EdgeEReference> outs = source2OutEdges.get(source);
		if(outs==null){
			outs = new ArrayList<EdgeEReference>();
		}
		outs.add(edgeEReference);
		source2OutEdges.put(source, outs);
		
		return true;
	}

}
