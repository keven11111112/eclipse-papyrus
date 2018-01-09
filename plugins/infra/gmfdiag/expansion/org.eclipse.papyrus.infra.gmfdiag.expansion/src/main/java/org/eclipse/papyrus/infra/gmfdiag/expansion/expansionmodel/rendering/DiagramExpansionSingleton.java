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

package org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.rendering;

/**
 * This factory is used to give an instance of the diagram expansion
 *
 */
public class DiagramExpansionSingleton  {

	protected  DiagramExpansionsRegistry diagramExpansionRegistry;

	protected static DiagramExpansionSingleton diagramExpansionSingleton= null;
	
	
	private DiagramExpansionSingleton(){
		diagramExpansionRegistry= new DiagramExpansionsRegistry();
	}
	
	/**
	 * 
	 * @return an instance of the DiagramExpansion Singleton
	 */
	public static  DiagramExpansionSingleton getInstance(){
		if( diagramExpansionSingleton==null){
			diagramExpansionSingleton= new DiagramExpansionSingleton();
		}
		return diagramExpansionSingleton;
	}
	/**
	 * get the diagram expansion associated to this singleton
	 * @return {@link DiagramExpansionsRegistry}
	 */
	public  DiagramExpansionsRegistry getDiagramExpansionRegistry() {
		return diagramExpansionRegistry;
	}


}
