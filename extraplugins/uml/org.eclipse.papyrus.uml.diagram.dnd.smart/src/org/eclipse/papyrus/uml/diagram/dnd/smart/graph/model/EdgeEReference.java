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
import org.eclipse.emf.ecore.EReference;

/**
 * Object model to manipulate the edges of the uml graph
 * @author Francois Le Fevre - CEA francois.le-fevre@cea.fr
 *
 */
public class EdgeEReference  implements Comparable<EdgeEReference>{
	
	/**
	 * the name of the Ecore EdgeEreference
	 * 
	 */
	private final String name;
	/**
	 * is the EReference a composition
	 */
	private final boolean isComposition;
	/**
	 * the Ecore Ereference
	 */
	private final EReference eReference;
	/**
	 * the target class associated with the EReference
	 */
	private final EClass targetConcretEclasse;

	public EdgeEReference(String name, boolean isComposition, EReference eReference,EClass targetConcretEclasse) {
		super();
		this.name = name;
		this.isComposition=isComposition;
		this.eReference = eReference;
		this.targetConcretEclasse = targetConcretEclasse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eReference == null) ? 0 : eReference.hashCode());
		result = prime * result + (isComposition ? 1231 : 1237);
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
		EdgeEReference other = (EdgeEReference) obj;
		if (eReference == null) {
			if (other.eReference != null)
				return false;
		} else if (!eReference.equals(other.eReference))
			return false;
		if (isComposition != other.isComposition)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int compareTo(EdgeEReference o) {
		
		return this.getName().compareTo(o.getName());
	}
	
	/*
	 * getter methods
	 */

	public EClass getTargetConcretEclasse() {
		return targetConcretEclasse;
	}
	
	public String getName() {
		return name;
	}

	public boolean isComposition() {
		return isComposition;
	}

	public EReference geteReference() {
		return eReference;
	}

}
