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

/**
 * Interface defining the contracts to add edge or vertex and the getter methods
 * @author flefevre
 *
 */
public interface IUmlGraph{
	
	/**
	 * @param nodeEClassEReference non-null
	 */
	public void addVertex(NodeEClass nodeEClassEReference);
	
	/**
	 * @param edgeEReference non-null ecore ereference between the source and the target
	 * @param source non-null
	 * @param target non-null 
	 * @return
	 */
	public boolean addEdge(EdgeEReference edgeEReference, NodeEClass source, NodeEClass target);
	
	/**
	 * given an Edge it should return the source NodeEClass
	 * @param myEdgeEReference
	 * @return
	 */
	public NodeEClass getSource(EdgeEReference myEdgeEReference);
	
	
	/**
	 * given an Edge it should return the target NodeEClass
	 * @param myEdgeEReference
	 * @return
	 */
	public NodeEClass getDest(EdgeEReference myEdgeEReference);
	
	/**
	 * given a nodeEClass, return the collection of outgoing edges
	 * @param nodeEClassEReference
	 * @return
	 */
	public Collection<EdgeEReference> getOutEdges(NodeEClass nodeEClassEReference);
	
	/**
	 * given a nodeEClass, return the collection of ingoing edges
	 * @param nodeEClassEReference
	 * @return
	 */
	public Collection<EdgeEReference> getInEdges(NodeEClass nodeEClassEReference);

}
