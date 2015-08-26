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
package org.eclipse.papyrus.uml.diagram.dnd.smart.graph.api;

import java.util.Set;

import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.Uml2Graph;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.NodeEClass;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.Path;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.service.AllPathDetector;


/**
 * Shared implementation to retrieve the set of path for a given drag and drop
 * @author Francois Le Fevre - francois.le-fevre@cea.fr
 *
 */
public abstract class AbstractUml2GraphServices implements Uml2GraphServices {
	
	protected AllPathDetector allPathDetector;
	
	/**
	 * The graph view of the UML model
	 */
	protected Uml2Graph uml2Graph;
	
	public AbstractUml2GraphServices(){
		allPathDetector = new AllPathDetector();
		uml2Graph  = Uml2Graph.getInstance();
	}
	
	public AbstractUml2GraphServices(int depth, int threshold){
		allPathDetector = new AllPathDetector(depth, threshold);
		uml2Graph  = Uml2Graph.getInstance();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.dnd.smart.graph.api.Uml2GraphServices#proposedActionsFromDnd(org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.NodeEClass, org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.NodeEClass)
	 *
	 * @param source
	 * @param target
	 * @return
	 */
	public Set<Path> proposedActionsFromDnd(NodeEClass source, NodeEClass target) {
		//Compute the paths and filter them
		return allPathDetector.filterAnalysis(uml2Graph,source, target);
	}
	
	/*
	 * Getter
	 */

	/**
	 * @return the allPathDetector
	 */
	public AllPathDetector getAllPathDetector() {
		return allPathDetector;
	}

}
