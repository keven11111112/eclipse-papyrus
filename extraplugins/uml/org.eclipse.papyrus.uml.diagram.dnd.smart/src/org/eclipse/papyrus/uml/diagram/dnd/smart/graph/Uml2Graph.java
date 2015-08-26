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
package org.eclipse.papyrus.uml.diagram.dnd.smart.graph;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.EClassComparator;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.EdgeEReference;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.NodeEClass;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.UmlGraph;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Object model to manipulate the graph
 * @author Francois Le Fevre - CEA francois.le-fevre@cea.fr
 *
 */
public class Uml2Graph {

	private static Uml2Graph INSTANCE = null;
	public static final String NAME_SPLITTER=new String("@");

	private UmlGraph myGraph;
	private HashMap<String, NodeEClass> nodeEClassMap;
	private HashMap<EClass, List<EClass>> eclass2ChildrenMap;
	private HashMap<EClass, EList<EClass>> eclass2ParentMap;
	private HashMap<EClass, List<EClass>> eclass2ConcreteMap;

	private HashMap<String, EdgeEReference> edgeEReferenceMap;
	private UMLFactory umlFactory;

	public static Uml2Graph getInstance()
	{			
		if (INSTANCE == null)
		{ 	INSTANCE = new Uml2Graph();	
		}
		return INSTANCE;
	}

	private Uml2Graph(){
		Date start = new Date();
		//initialiaze the uml factory
		umlFactory = UMLFactory.eINSTANCE;

		//create the graph
		myGraph = new UmlGraph();

		//prepare the map to navigate
		nodeEClassMap = new  HashMap<String, NodeEClass>();
		edgeEReferenceMap = new HashMap<String, EdgeEReference>();
		eclass2ChildrenMap = new HashMap<EClass, List<EClass>>();
		eclass2ParentMap = new HashMap<EClass, EList<EClass>>();
		eclass2ConcreteMap = new HashMap<EClass, List<EClass>>();

		extractNodesFromUml();

		buildParent2ChildrenMap();
		buildChildren2ParentMap();

		extractEdgesFromUml();

		Date end = new Date();
		if(Activator.log.isDebugEnabled()){
			Activator.log.debug("Parsing of UML model2: done "+(end.getTime()-start.getTime()));
		}
	}

	private void buildChildren2ParentMap() {

		for(EClass eclass : eclass2ParentMap.keySet()){
			EList<EClass> eclassParents = eclass2ParentMap.get(eclass);
			for(EClass eclassParent : eclassParents){
				List<EClass> eclassChildren = eclass2ChildrenMap.get(eclassParent);
				if(eclassChildren==null){
					eclassChildren = new ArrayList<EClass>();
				}
				eclassChildren.add(eclass);
				eclass2ChildrenMap.put(eclassParent, eclassChildren);
			}
		}

	}

	private void buildParent2ChildrenMap() {
		for(NodeEClass nodeEClass : nodeEClassMap.values()){
			fillSpecificHierarchy(nodeEClass.geteClass());
		}
	}

	/**
	 * Extract the parent Eclass information
	 * @param myEClass
	 */
	private void fillSpecificHierarchy(EClass myEClass){
		if(myEClass!=null){
			EList<EClass> myEClassParents = myEClass.getEAllSuperTypes();
			eclass2ParentMap.put(myEClass,myEClassParents);
		}
	}

	private void extractNodesFromUml(){
		//TODO update to get all EClass directly
		for(Method m : UMLPackage.eINSTANCE.getClass().getMethods()){
			if("interface org.eclipse.emf.ecore.EClass".equals(m.getReturnType().toString())){

				if(Activator.log.isDebugEnabled()){
					Activator.log.debug("Will extract data from " + m.getName());

				}
				try {
					//Explore the EClass
					EClass myEclass = (EClass)m.invoke(umlFactory.getUMLPackage());
					exploreNode(myEclass);

				} catch (IllegalAccessException e) {
					Activator.log.error(e.getMessage(),e);
				} catch (IllegalArgumentException e) {
					Activator.log.error(e.getMessage(),e);
				} catch (InvocationTargetException e) {
					Activator.log.error(e.getMessage(),e);
				}
			}
			else{
				if(Activator.log.isDebugEnabled()){
					Activator.log.debug("No parsing of method which returns:" + m.getReturnType().toString()+"\t"+m.getName());
				}
			}
		}
	}

	private void exploreNode(EClass myEClass){
		if(myEClass!=null){
			if(Activator.log.isDebugEnabled()){
				Activator.log.debug("exploreEClass "+myEClass.getInstanceClassName()+"\t"+myEClass.isAbstract());
			}
			NodeEClass nodeEClass;
			if(nodeEClassMap.get(myEClass.getInstanceClassName())==null){

				nodeEClass = nodeEClassMap.get(myEClass.getInstanceClassName());
				if(nodeEClass==null){
					nodeEClass = new NodeEClass(myEClass.getInstanceClassName(),myEClass);
					myGraph.addVertex(nodeEClass);
					nodeEClassMap.put(myEClass.getInstanceClassName(),nodeEClass);
				}
				for(EReference er : myEClass.getEAllReferences()){
					if(!er.getEType().getInstanceClassName().startsWith("org.eclipse.emf.ecore.")){
						if(Activator.log.isDebugEnabled()){
							Activator.log.debug("exploreEClass AllContainments "+er.getEType().getInstanceClassName());
						}

						NodeEClass nodeEClassEReference = nodeEClassMap.get(er.getEType().getInstanceClassName());
						if(nodeEClassEReference==null){
							nodeEClassEReference = new NodeEClass(er.getEType().getInstanceClassName(),er.getEReferenceType());
							myGraph.addVertex(nodeEClassEReference);
							nodeEClassMap.put(er.getEType().getInstanceClassName(),nodeEClassEReference);

							EList<EClass> myEClassParents = er.getEReferenceType().getEAllSuperTypes();
							for(EClass myEClassParent : myEClassParents){
								NodeEClass nodeEClassEReference2 = nodeEClassMap.get(myEClassParent.getInstanceClassName());
								if(nodeEClassEReference2==null){
									nodeEClassEReference2 = new NodeEClass(myEClassParent.getInstanceClassName(),myEClassParent);
									myGraph.addVertex(nodeEClassEReference2);
									nodeEClassMap.put(myEClassParent.getInstanceClassName(),nodeEClassEReference2);
								}
							}
						}
					}
				}

				EList<EClass> myEClassParents = myEClass.getEAllSuperTypes();
				for(EClass myEClassParent : myEClassParents){
					NodeEClass nodeEClassEReference2 = nodeEClassMap.get(myEClassParent.getInstanceClassName());
					if(nodeEClassEReference2==null){
						nodeEClassEReference2 = new NodeEClass(myEClassParent.getInstanceClassName(),myEClassParent);
						myGraph.addVertex(nodeEClassEReference2);
						nodeEClassMap.put(myEClassParent.getInstanceClassName(),nodeEClassEReference2);
					}
				}
			}
		}
	}


	private void extractEdgesFromUml(){
		//TODO update to get all EClass directly
		for(Method m : UMLPackage.eINSTANCE. getClass().getMethods()){
			if("interface org.eclipse.emf.ecore.EClass".equals(m.getReturnType().toString())){
				if(Activator.log.isDebugEnabled()){
					Activator.log.debug("Will extract data from " + m.getName());
				}
				try {
					//Explore the EClass
					EClass myEclass = (EClass)m.invoke(umlFactory.getUMLPackage());
					exploreEdgesOfEClass(myEclass);

				} catch (IllegalAccessException e) {
					Activator.log.error(e.getMessage(),e);
				} catch (IllegalArgumentException e) {
					Activator.log.error(e.getMessage(),e);
				} catch (InvocationTargetException e) {
					Activator.log.error(e.getMessage(),e);
				}
			}
			else{
				if(Activator.log.isDebugEnabled()){
					Activator.log.debug("No parsing of method which returns:" + m.getReturnType().toString()+"\t"+m.getName());
				}
			}
		}
	}

	private void exploreEdgesOfEClass(EClass myEClass){
		if(myEClass!=null){


			if(Activator.log.isDebugEnabled()){
				Activator.log.debug("exploreEdgesofEClass "+myEClass.getInstanceClassName()+"\t"+myEClass.isAbstract());
			}
			NodeEClass source = nodeEClassMap.get(myEClass.getInstanceClassName());

			for(EReference er : myEClass.getEAllReferences()){
				NodeEClass target = nodeEClassMap.get(er.getEType().getInstanceClassName());

				if(source!=null && target !=null){
					//Filter the EReference
					if(!"org.eclipse.emf.ecore.EAnnotation".equals(er.getEType().getInstanceClassName())
							&& !"ownedElement".equals(er.getName())
							&& !"owner".equals(er.getName())
							&& !"ownedMember".equals(er.getName())
							&& !"importedMember".equals(er.getName())
							&& !"namespace".equals(er.getName())
							&& !"member".equals(er.getName())
							&& !"redefinedElement".equals(er.getName())
							&& !"clientDependency".equals(er.getName())
							&& !"packageImport".equals(er.getName())
							&& !"elementImport".equals(er.getName())
							&& !"ownedComment".equals(er.getName())
							){

						//Work with real Target
						List<EClass> targetConcretEclasses = getAllConcreteEClasses(target.geteClass());

						NodeEClass targetConcretEclasseNode2;
						EdgeEReference edgeEReference2;
						String edgeName2;
						boolean b;
						for(EClass targetConcretEclasse : targetConcretEclasses){
							targetConcretEclasseNode2 = nodeEClassMap.get(targetConcretEclasse.getInstanceTypeName());
							edgeName2 = buildUniqName(myEClass, er, targetConcretEclasse);
							edgeEReference2 = new EdgeEReference(edgeName2,er.eContainmentFeature().isContainment(), er,targetConcretEclasse);
							b = myGraph.addEdge(edgeEReference2, source, targetConcretEclasseNode2);
							if(!b){
								Activator.log.error("problem in creation of graph",new Error());
							}
							edgeEReferenceMap.put(edgeName2,edgeEReference2);
						}

					}
				}
			}
		}
	}

	/**
	 * Given an EClass, return all concrete EClasses, withitself if it is already a concrete EClass
	 * @param initialEClass
	 * @return
	 */
	public List<EClass> getAllConcreteEClasses(EClass initialEClass){
		List<EClass> result=null;
		if(initialEClass!=null){

			result = eclass2ConcreteMap.get(initialEClass);

			if(result==null){
				result = new ArrayList<EClass>();
				TreeSet<EClass> preResult = new TreeSet<EClass>(new EClassComparator());

				if(initialEClass!=null){

					//Add it if it is alaready a concrete EClass
					if(!initialEClass.isAbstract()){
						preResult.add(initialEClass);
						if(Activator.log.isDebugEnabled()){
							Activator.log.debug("adding non abstract class: "+initialEClass.getInstanceTypeName());
						}
					}

					//Explore its children
					List<EClass> potentialConcreteEClasses= eclass2ChildrenMap.get(initialEClass);
					if(Activator.log.isDebugEnabled()){
						Activator.log.debug("exploring "+initialEClass.getInstanceTypeName()+ "\tchildren["+potentialConcreteEClasses+"]");
					}
					if(potentialConcreteEClasses!=null){
						for(EClass potentialConcreteEClass: potentialConcreteEClasses){
							//Explore it again
							preResult.addAll(getAllConcreteEClasses(potentialConcreteEClass));
						}	
					}
				}

				result.addAll(preResult);

				eclass2ConcreteMap.put(initialEClass,result);
			}
		}
		return result;
	}

	public void computeStatusActions(EClass source,EClass target) {
		NodeEClass sourceNode = nodeEClassMap.get(source.getInstanceTypeName());
		NodeEClass targetNode = nodeEClassMap.get(target.getInstanceTypeName());

		Collection<EdgeEReference> mySourceIncidentEdges = myGraph.getInEdges(sourceNode);
		for(EdgeEReference myEdgeEReference : mySourceIncidentEdges){
			NodeEClass potentialIntermediate = myGraph.getSource(myEdgeEReference);
			Collection<EdgeEReference> mySourceIncidentEdges2 = myGraph.getInEdges(potentialIntermediate);
			for(EdgeEReference myEdgeEReference2 : mySourceIncidentEdges2){
				NodeEClass potentialTarget = myGraph.getSource(myEdgeEReference2);
				if(potentialTarget==targetNode){
					if(Activator.log.isDebugEnabled()){
						Activator.log.debug("Found path source["+source.getInstanceTypeName()+"] <- "+myEdgeEReference2.getName()+"["+potentialIntermediate.geteClass().getInstanceTypeName()+"] <- target["+target.getInstanceTypeName()+"]");
					}
				}
			}

			Collection<EdgeEReference> mySourceIncidentEdges3 = myGraph.getOutEdges(potentialIntermediate);
			for(EdgeEReference myEdgeEReference3 : mySourceIncidentEdges3){
				NodeEClass potentialTarget = myGraph.getSource(myEdgeEReference3);
				if(potentialTarget==targetNode){
					if(Activator.log.isDebugEnabled()){
						Activator.log.debug("Found path source["+source.getInstanceTypeName()+"] <- "+myEdgeEReference3.getName()+"["+potentialIntermediate.geteClass().getInstanceTypeName()+"] -> target["+target.getInstanceTypeName()+"]");
					}
				}
			}
		}

		Collection<EdgeEReference> mySourceIncidentEdges3 = myGraph.getOutEdges(sourceNode);
		for(EdgeEReference myEdgeEReferenceZ : mySourceIncidentEdges3){
			NodeEClass potentialIntermediate = myGraph.getSource(myEdgeEReferenceZ);
			Collection<EdgeEReference> mySourceIncidentEdges2 = myGraph.getInEdges(potentialIntermediate);
			for(EdgeEReference myEdgeEReferenceE : mySourceIncidentEdges2){
				NodeEClass potentialTarget = myGraph.getSource(myEdgeEReferenceE);
				if(potentialTarget==targetNode){
					if(Activator.log.isDebugEnabled()){
						Activator.log.debug("Found path source["+source.getInstanceTypeName()+"] <- "+myEdgeEReferenceZ.getName()+"["+potentialIntermediate.geteClass().getInstanceTypeName()+"] <- target["+target.getInstanceTypeName()+"]");
					}
				}
			}

			Collection<EdgeEReference> mySourceIncidentEdges4 = myGraph.getOutEdges(potentialIntermediate);
			for(EdgeEReference myEdgeEReference4 : mySourceIncidentEdges4){
				NodeEClass potentialTarget = myGraph.getSource(myEdgeEReference4);
				if(potentialTarget==targetNode){
					if(Activator.log.isDebugEnabled()){
						Activator.log.debug("Found path source["+source.getInstanceTypeName()+"] <- "+myEdgeEReferenceZ.getName()+"["+potentialIntermediate.geteClass().getInstanceTypeName()+"] -> target["+target.getInstanceTypeName()+"]");
					}
				}
			}
		}
	}


	/**
	 * Generate an unique name for a given EReference based on the source and target
	 * @param myEClass
	 * @param er
	 * @param targetConcreteEClass
	 * @return
	 */
	private String buildUniqName(EClass myEClass, EReference er, EClass targetConcreteEClass) {
		return er.getName()+NAME_SPLITTER+myEClass.getInstanceTypeName()+NAME_SPLITTER+er.getEType().getInstanceTypeName()+NAME_SPLITTER+targetConcreteEClass.getInstanceTypeName();
	}

	public UmlGraph getUmlGraph() {
		return myGraph;
	}

	public HashMap<String, NodeEClass> getEclass2Node() {
		return nodeEClassMap;
	}

	public static Uml2Graph getINSTANCE() {
		return INSTANCE;
	}

	public HashMap<String, NodeEClass> getNodeEClassMap() {
		return nodeEClassMap;
	}

	public HashMap<EClass, List<EClass>> getEclass2ChildrenMap() {
		return eclass2ChildrenMap;
	}

	public HashMap<EClass, EList<EClass>> getEclass2ParentMap() {
		return eclass2ParentMap;
	}

	public HashMap<String, EdgeEReference> getEdgeEReferenceMap() {
		return edgeEReferenceMap;
	}

	public UMLFactory getUmlFactory() {
		return umlFactory;
	}

}
