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

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.NodeEClass;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.Path;

/**
 * Interface defining services relative to given a source/target give me the set of possible actions
 * @author Francois Le Fevre - francois.le-fevre@cea.fr
 *
 */
public interface Uml2GraphServices {
	
	/**
	 * @param source the initial EClass selected by the user in the ModelExplorer
	 * @param target the targeted EClass selected by the user in the Diagram
	 * @return the set of path could not be null
	 */
	public Set<Path> proposedActionsFromDnd(EClass source, EClass target);
	
	/**
	 * @param source the initial EClass selected by the user in the ModelExplorer
	 * @param target the targeted EClass selected by the user in the Diagram
	 * @return the set of path could not be null
	 */
	public Set<Path> proposedActionsFromDnd(String source, String target);
	
	/**
	 * @param source the initial EClass selected by the user in the ModelExplorer
	 * @param target the targeted EClass selected by the user in the Diagram
	 * @return the set of path could not be null
	 */
	public Set<Path> proposedActionsFromDnd(NodeEClass source, NodeEClass target);
	
	/**
	 * @param source the initial EClass selected by the user in the ModelExplorer
	 * @param target the targeted EClass selected by the user in the Diagram
	 * @return the set of path could not be null
	 */
	public Collection<String> proposedLitteralActionsFromDnd(String source, String target);

}
