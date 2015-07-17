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

import java.util.List;

/**
 * A path is the succession of EdgeEReference between two NodeEClass
 * @author Francois Le Fevre - CEA francois.le-fevre@cea.fr
 */
public class Path implements Comparable<Path>{
	
	private final List<EdgeEReference> way;
	private final String name;
	
	public Path(List<EdgeEReference> way) {
		super();
		this.way = way;
		this.name = getRepresentation(way);
	}
	
	
	private String getRepresentation(List<EdgeEReference> path){
		StringBuffer tmp = new StringBuffer();
		for(EdgeEReference c : path){
			tmp.append(c.getName()+" _ ");
		}
		return tmp.toString();
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
		Path other = (Path) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public List<EdgeEReference> getWay() {
		return way;
	}


	public String getName() {
		return name;
	}


	public int compareTo(Path o) {
		return name.compareTo(o.getName());
	}

}
