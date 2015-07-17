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
package org.eclipse.papyrus.uml.diagram.dnd.smart.graph.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.Uml2Graph;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.EdgeEReference;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.NodeEClass;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.Path;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.UmlGraph;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.util.FilterUtils;

import java.util.Date;

/**
 * Class dedicated to compute the path between two nodes given an uml graph
 * @author Francois Le Fevre - CEA francois.le-fevre@cea.fr
 */
public class AllPathDetector
{
	/**
	 * the maximum number of edges to walk throught
	 */
	protected int depth;

	/**
	 * the maximum number of path to filter
	 */
	protected int displayThreshold;
	
	protected HashMap<String, Set<Path> > precomputePath;
	
	public AllPathDetector(){
		this.depth = 2;
		this.displayThreshold=20;
		precomputePath = new HashMap<String, Set<Path>>();
	}
	
	public AllPathDetector(int depth, int threshold){
		this.depth = depth;
		this.displayThreshold=threshold;
		precomputePath = new HashMap<String, Set<Path>>();
	}

	/**
	 * Given a graph, a start node and a end node, and the maximum steps , it will return a list of possible path between the two nodes
	 * @param graph
	 * @param startNode
	 * @param endNode
	 * @param maxDepth
	 * @return
	 */
	public List<Path> getAllPathsBetweenNodes(UmlGraph graph,
			NodeEClass startNode, NodeEClass endNode, int maxDepth)
	{
		List<Path> allPaths = new ArrayList<Path>();

		List<EdgeEReference> currentPath = new ArrayList<EdgeEReference>();

		findAllPaths(startNode, startNode, endNode, currentPath, graph, maxDepth , 0 , allPaths);

		return allPaths;
	}

	/**
	 * Recursive methods in charge to compute the different paths between a start and an end node given a maximum of edges to walk throught
	 * @param currentNode
	 * @param startNode
	 * @param endNode
	 * @param currentPath
	 * @param graph
	 * @param maxDepth
	 * @param currentDepth
	 * @param allPaths
	 */
	public void findAllPaths(NodeEClass currentNode, NodeEClass startNode, NodeEClass endNode,
			List<EdgeEReference> currentPath,UmlGraph graph,
			int maxDepth, int currentDepth, List<Path> allPaths)
	{

		Collection<EdgeEReference> outgoingEdges = graph.getOutEdges(currentNode);
		if (currentDepth < maxDepth)
		{
			for (EdgeEReference outEdge : outgoingEdges)
			{
				NodeEClass outNode = graph.getDest(outEdge);
				if (outNode.equals(startNode))
				{
					List<EdgeEReference> cyclePath = new ArrayList<EdgeEReference>(currentPath);
					cyclePath.add(outEdge);
					continue;
				}

				List<EdgeEReference> newPath = new ArrayList<EdgeEReference>(currentPath);
				newPath.add(outEdge);

				if (outNode.equals(endNode))
				{
					Path myPath = new Path(newPath);
					allPaths.add(myPath);
					continue;
				}

				findAllPaths(outNode, startNode, endNode, newPath, graph, maxDepth, currentDepth + 1, allPaths);
			}
		}
	}

	/**
	 * Method in charge to filter the different paths found, to retrieve a shorter number of soultion.
	 * it is an heuristic.
	 * @param uml2graph
	 * @param source
	 * @param target
	 * @return
	 */
	public Set<Path> filterAnalysis(Uml2Graph uml2graph, NodeEClass source, NodeEClass target){
		Date startTime = new Date();
		
		Set<Path> result = precomputePath.get(source.getName()+Uml2Graph.NAME_SPLITTER+target.getName()); 
		
		if(result==null){
			result = new TreeSet<Path>();

			List<Path> resultFull = getAllPathsBetweenNodes(uml2graph.getUmlGraph(), target ,source, depth);
			Date endTime = new Date();
			
			if(Activator.log.isDebugEnabled()){
				Activator.log.debug("path compute in "+(endTime.getTime()-startTime.getTime()));
			}

			startTime = new Date();
			List<Path> hard = FilterUtils.hardFilter(resultFull);

			List<Path> tmp = new ArrayList<Path>();
			if(hard.size()<=displayThreshold){
				result.addAll(hard);
			}
			else{
				for(Path h : hard){
					if(h.getWay().size()<=2){
						tmp.add(h);
					}
				}

				if(tmp.size()<=displayThreshold){
					result.addAll(tmp);
				}
			}

			List<Path> soft = FilterUtils.softFilter(resultFull);
			tmp = new ArrayList<Path>();
			if(soft.size()<=displayThreshold){
				result.addAll(soft);
			}
			else{
				for(Path s : soft){
					if(s.getWay().size()<=2){
						tmp.add(s);
					}
				}

				if(tmp.size()<=displayThreshold){
					result.addAll(tmp);
				}
			}
			List<Path> trim = FilterUtils.trimFilter(resultFull);
			tmp = new ArrayList<Path>();
			if(trim.size()<=displayThreshold){
				result.addAll(trim);
			}
			else{
				for(Path t : trim){
					if(t.getWay().size()<=2){
						tmp.add(t);
					}
				}

				if(tmp.size()<=displayThreshold){
					result.addAll(tmp);
				}
			}
			List<Path> end = FilterUtils.endFilter(resultFull);
			tmp = new ArrayList<Path>();
			if(end.size()<=displayThreshold){
				result.addAll(end);
			}
			else{
				for(Path e : end){
					if(e.getWay().size()<=2){
						tmp.add(e);
					}
				}

				if(tmp.size()<=displayThreshold){
					result.addAll(tmp);
				}
			}
			
			precomputePath.put(source.getName()+Uml2Graph.NAME_SPLITTER+target.getName(), result); 
			endTime = new Date();
			if(Activator.log.isDebugEnabled()){
				Activator.log.debug("path filter in "+(endTime.getTime()-startTime.getTime()));
			}
		}
		
		return result;
	}
	
	/*
	 * getter and setter
	 */

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @return the displayThreshold
	 */
	public int getDisplayThreshold() {
		return displayThreshold;
	}

	/**
	 * @param displayThreshold the displayThreshold to set
	 */
	public void setDisplayThreshold(int displayThreshold) {
		this.displayThreshold = displayThreshold;
	}
}