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

import java.util.Comparator;

import org.eclipse.emf.ecore.EClass;

/**
 * Comparator of two ECLass
 * @author flefevre
 *
 */
public class EClassComparator implements Comparator<EClass>{

	public int compare(EClass e1, EClass e2) {
		if(e1.getName()!=null){
			return e1.getName().compareTo(e2.getName());
		}
		else{
			return -1;
		}
	}
}
