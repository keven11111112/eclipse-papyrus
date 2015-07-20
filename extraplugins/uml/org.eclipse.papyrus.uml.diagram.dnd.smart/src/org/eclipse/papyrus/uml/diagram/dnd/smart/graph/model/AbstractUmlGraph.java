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

import java.util.Collection;
import java.util.HashMap;

/**
 * The main class dedicated to hold the graph defintion of an uml model 
 * @author flefevre
 *
 */
public abstract class AbstractUmlGraph implements IUmlGraph{
	
	protected HashMap<EdgeEReference, NodeEClass> edge2Source;
	protected HashMap<EdgeEReference, NodeEClass> edge2Target;
	
	protected HashMap<NodeEClass, Collection<EdgeEReference>> source2InEdges;
	protected HashMap<NodeEClass, Collection<EdgeEReference>> source2OutEdges;
	
	public AbstractUmlGraph(){
		edge2Source = new HashMap<EdgeEReference, NodeEClass>(); 
		edge2Target = new HashMap<EdgeEReference, NodeEClass>(); 
		
		source2InEdges = new HashMap<NodeEClass, Collection<EdgeEReference>>() ;
		source2OutEdges =  new HashMap<NodeEClass, Collection<EdgeEReference>>() ;
	}

	public NodeEClass getSource(EdgeEReference myEdgeEReference){
		return edge2Source.get(myEdgeEReference);
	}
	
	public NodeEClass getDest(EdgeEReference myEdgeEReference){
		return edge2Target.get(myEdgeEReference);
	}
	
	
	public Collection<EdgeEReference> getOutEdges(NodeEClass nodeEClassEReference){
		return source2OutEdges.get(nodeEClassEReference);
	}
	
	public Collection<EdgeEReference> getInEdges(NodeEClass nodeEClassEReference){
		return source2InEdges.get(nodeEClassEReference);
	}

}
