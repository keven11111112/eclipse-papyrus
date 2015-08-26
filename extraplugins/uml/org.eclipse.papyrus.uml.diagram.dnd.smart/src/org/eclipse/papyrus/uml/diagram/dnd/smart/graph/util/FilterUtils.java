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

package org.eclipse.papyrus.uml.diagram.dnd.smart.graph.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.Uml2Graph;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.EdgeEReference;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.Path;

/**
 * A set of filter methods in charge to reduce the number of paths found.
 * @author flefevre
 *
 */
public class FilterUtils {
	
	public static List<Path> hardFilter(List<Path> bs){
		List<Path> result = new  ArrayList<Path>();

		boolean isprint;
		for(Path b : bs){
			isprint=true;
			for(EdgeEReference c : b.getWay()){
				String[] names = c.getName().split(Uml2Graph.NAME_SPLITTER);
				if(!names[2].equals(names[3])){
					isprint=false;
					break;
				}	
			}

			if(isprint){
				result.add(b);
			}
		}

		return result;
	}

	public static List<Path> softFilter(List<Path> bs){
		List<Path> result = new  ArrayList<Path>();

		boolean isprint;
		for(Path b : bs){
			isprint=false;
			for(EdgeEReference c : b.getWay()){
				String[] names = c.getName().split(Uml2Graph.NAME_SPLITTER);
				if(names[2].equals(names[3])){
					isprint=true;
				}	
			}

			if(isprint){
				result.add(b);
			}
		}

		return result;
	}

	public static List<Path> endFilter(List<Path> bs){
		List<Path> result = new  ArrayList<Path>();

		boolean isprint;
		for(Path b : bs){
			isprint=false;

			EdgeEReference c = b.getWay().get(b.getWay().size()-1);
			String[] names = c.getName().split(Uml2Graph.NAME_SPLITTER);
			if(names[2].equals(names[3])){
				isprint=true;
			}	

			if(isprint){
				result.add(b);
			}
		}

		return result;
	}

	public static List<Path> startFilter(List<Path> bs){
		List<Path> result = new  ArrayList<Path>();

		boolean isprint;
		for(Path b : bs){
			isprint=false;

			EdgeEReference c = b.getWay().get(0);
			String[] names = c.getName().split(Uml2Graph.NAME_SPLITTER);
			if(names[2].equals(names[3])){
				isprint=true;
			}	

			if(isprint){
				result.add(b);
			}
		}

		return result;
	}

	public static List<Path> trimFilter(List<Path> bs){
		List<Path> tmp = endFilter(bs);
		return startFilter(tmp);
	}

}
