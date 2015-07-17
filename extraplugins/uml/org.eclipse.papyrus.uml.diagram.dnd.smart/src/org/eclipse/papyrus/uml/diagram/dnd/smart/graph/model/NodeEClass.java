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

import org.eclipse.emf.ecore.EClass;

/**
 * Object model to manipulate the node of the uml graph
 * @author Francois Le Fevre - CEA francois.le-fevre@cea.fr
 *
 */
public class NodeEClass implements Comparable<NodeEClass>{
	
	/**
	 * the name of the EClass
	 */
	private String name;
	/**
	 * the ECore EClass
	 */
	private EClass eClass;

	public NodeEClass(String name, EClass eClass) {
		super();
		this.name = name;
		this.eClass = eClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeEClass other = (NodeEClass) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public int compareTo(NodeEClass o) {
		
		return this.getName().compareTo(o.getName());
	}


	@Override
	public String toString() {
		return name ;
	}
	
	/*
	 * Getter methods
	 */


	public EClass geteClass() {
		return eClass;
	}
	
	public String getName() {
		return name;
	}
}
