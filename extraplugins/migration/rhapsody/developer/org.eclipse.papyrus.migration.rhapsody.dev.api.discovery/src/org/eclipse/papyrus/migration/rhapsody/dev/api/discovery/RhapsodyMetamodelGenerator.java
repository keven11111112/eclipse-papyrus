/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien Revol (CEA LIST) sebastien.revol@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.dev.api.discovery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyFileHandler;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyProjectHandler;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyUtil;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeatureValue;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList;


/**
 * @author sr246418
 *
 */
public class RhapsodyMetamodelGenerator {
	private static final String ECORE_TEMPLATE_PATH = "org.eclipse.papyrus.migration.rhapsody.dev.api.discovery/model/Rhapsody_template.ecore";



	private EPackage rhpEPackage;

	private Map<String, EClass> eClassMap = new HashMap<String, EClass>();

	private List<RpyNode> visitedNode = new ArrayList<RpyNode>();
	private RpyProjectHandler projectHandler;

	private List<RpyFileHandler> transformedFileHandlers = new ArrayList<RpyFileHandler>();



	/**
	 * Constructor.
	 *
	 */
	public RhapsodyMetamodelGenerator() {
		ResourceSet resSet = new ResourceSetImpl();
		Resource res = resSet.getResource(URI.createPlatformPluginURI(ECORE_TEMPLATE_PATH, true), true);
		rhpEPackage = (EPackage) res.getContents().get(0);

	}

	public RhapsodyMetamodelGenerator(EPackage initialPackage) {
		rhpEPackage = initialPackage;
		initializeEClassMap();
	}


	/**
	 * 
	 */
	private void initializeEClassMap() {
		for (EClassifier eClassifier : rhpEPackage.getEClassifiers()){
			eClassMap.put(eClassifier.getName(), (EClass)eClassifier);
		}

	}

	public void setHandler(RpyProjectHandler handler){
		this.projectHandler = handler;
		handler.loadSubFiles();
		visitedNode.clear();

	}

	public EPackage generateMetatmodel() {

		for (RpyFileHandler rpyFileHandler : projectHandler.getFiles()){
			System.out.println("------Analyzing file : "+ rpyFileHandler.getRpyFile().eResource().getURI().toFileString());
			transformedFileHandlers.add(rpyFileHandler);

			for (RpyContent content : rpyFileHandler.getContents()){
				if (content instanceof RpyNode){
					transform((RpyNode)content);
				}
			}
		}
		return rhpEPackage;
	}

	/**
	 * @param content
	 */
	private EClass transform(RpyNode node) {
		if (node.getName() == null || node.getName().isEmpty()){
			return null;
		}
		EClass eClass = eClassMap.get(node.getName());
		if (eClass == null){
			eClass = EcoreFactory.eINSTANCE.createEClass();
			eClass.setName(node.getName());
			rhpEPackage.getEClassifiers().add(eClass);
			eClassMap.put(node.getName(), eClass);
		}

		if (! visitedNode.contains(node)){
			visitedNode.add(node);
			for (RpyContent content : node.getContents()){
				List<EStructuralFeature> features = generateFeature(eClass ,content);
				for (EStructuralFeature feature : features){
					addFeatureIfNotAlreadyPresent(eClass, feature);
				}
			}
		}



		return eClass;

	}


	/**
	 * @param referencedNode
	 * @param rpyFeature
	 */
	private void transformOwningHandlerIfDifferent(RpyNode referencedNode, RpyFeature rpyFeature) {
		RpyFileHandler referencedNodeHandler = projectHandler.getOwningFileHandler(referencedNode);
		if (referencedNodeHandler != null && referencedNodeHandler != projectHandler.getOwningFileHandler((RpyNode)rpyFeature.eContainer()) && !transformedFileHandlers.contains(referencedNodeHandler)){
			transformedFileHandlers.add(referencedNodeHandler);
			transform(referencedNodeHandler);
		}
	}
	private void transform(RpyFileHandler rpyFileHandler) {

		RpyFile rpyFile = rpyFileHandler.getRpyFile();

		List<EObject> roots= new ArrayList<EObject>();
		for (RpyContent fileContent : rpyFile.getContents()){
			if (fileContent instanceof RpyNode){
				EObject ret= transform((RpyNode) fileContent);
				if (ret!= null) {
					roots.add(ret);
				}
			}
		}

	}



	/**
	 * @param eClass
	 * @param content
	 */
	private List<EStructuralFeature> generateFeature(EClass eClass, RpyContent content) {
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		if (content instanceof RpyFeature){
			RpyFeature rpyFeature = (RpyFeature) content;
			RpyFeatureValue rpyFeatureValue = RpyUtil.getFeatureValue(rpyFeature);
			EStructuralFeature ecoreFeature = null;
			if (rpyFeatureValue instanceof SimpleValueList){
				if (RpyUtil.isDirectReference(rpyFeature)){
					RpyNode referencedNode = projectHandler.getSimpleFeatureReferencedNode(rpyFeature);
					transformOwningHandlerIfDifferent(referencedNode, rpyFeature);
					ecoreFeature = generateEReference(rpyFeature,referencedNode);
				}else{
					ecoreFeature = generateEAttribute(rpyFeature ,(SimpleValueList) rpyFeatureValue);
				}
				if (ecoreFeature != null){
					features.add(ecoreFeature);
				}


			}else if (rpyFeatureValue instanceof RpyNodeList) {
				boolean isContainment = ! RpyUtil.containsHandle((RpyNodeList) rpyFeatureValue);
				List<RpyNode> nodes = projectHandler.getNodes((RpyNodeList) rpyFeatureValue);
				boolean isMultiple = nodes.size() > 1;

				for (RpyNode referencedNode : nodes) {
					transformOwningHandlerIfDifferent(referencedNode, rpyFeature);
				}

				if (nodes.isEmpty()){
					ecoreFeature = generateUnknownFeature(rpyFeature.getName());
					features.add(ecoreFeature);
				}else {

					for (RpyNode node : nodes){
						//first implem : we explore all the features value to identify subtypes
						ecoreFeature = generateEReference(rpyFeature,node);
						if (isMultiple){
							ecoreFeature.setUpperBound(-1);
						}
						if (isContainment){
							((EReference)ecoreFeature).setContainment(true);
						}
						if (ecoreFeature != null){
							features.add(ecoreFeature);
						}
					}
				}
			}else if (rpyFeatureValue == null){
				ecoreFeature = generateUnknownFeature(rpyFeature.getName());
				features.add(ecoreFeature);
			}


		}else if (content instanceof RpyNode){
			EReference feature =  EcoreFactory.eINSTANCE.createEReference();
			feature.setName(RpyUtil.OWNED_ELEMENT_FEATURE_NAME);
			feature.setEType(transform((RpyNode) content));
			feature.setContainment(true);
			feature.setUpperBound(-1);
			features.add(feature);
			
		
		}
		return features;
	}



	/**
	 * @return
	 */
	private EStructuralFeature generateUnknownFeature(String featureName) {
		EClass unknownClass = eClassMap.get(RpyUtil.UNKNWON_CLASS_NAME);
		if (unknownClass == null){
			unknownClass = EcoreFactory.eINSTANCE.createEClass();
			unknownClass.setName(RpyUtil.UNKNWON_CLASS_NAME);
			eClassMap.put(RpyUtil.UNKNWON_CLASS_NAME, unknownClass);
			rhpEPackage.getEClassifiers().add(unknownClass);
		}
		EStructuralFeature ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName(featureName.replaceFirst("^_", ""));
		ref.setEType(unknownClass);
		ref.setUpperBound(-1);
		return ref;
	}

	/**
	 * @param eClass
	 * @param ecoreFeature
	 */
	private void addFeatureIfNotAlreadyPresent(EClass eClass, EStructuralFeature ecoreFeature) {

		if (ecoreFeature.getEType() != null){
			boolean found = false;
			for (EStructuralFeature feat : eClass.getEAllStructuralFeatures()){
				if (feat.getName().equals(ecoreFeature.getName()) && feat.getEType().equals(ecoreFeature.getEType())){
					found = true; 

					if (ecoreFeature.getUpperBound() == -1){
						feat.setUpperBound(-1);
					}
					continue;
				}
			}
			if (found == false){
				eClass.getEStructuralFeatures().add(ecoreFeature);
			}
		}

	}



	/**
	 * @param rpyFeature 
	 * @param rpyFeatureValue
	 * @return
	 */
	private EStructuralFeature generateEReference(RpyFeature rpyFeature, RpyNode node) {
		EReference ret =  EcoreFactory.eINSTANCE.createEReference();

		ret.setName(rpyFeature.getName().replaceFirst("^_", ""));
		ret.setEType(transform(node));

		return ret;
	}

	/**
	 * @param rpyFeature 
	 * @param rpyFeatureValue
	 * @return
	 */
	private EStructuralFeature generateEAttribute(RpyFeature rpyFeature, SimpleValueList simpleValueList) {
		EAttribute ret =  EcoreFactory.eINSTANCE.createEAttribute();
		ret.setName(rpyFeature.getName().replaceFirst("^_", ""));


		boolean isMultiple = false;
		if (!simpleValueList.getValueElements().isEmpty()){
			if (simpleValueList.getValueElements().size()>1){
				isMultiple = true;
			}else {
				RpySimpleValueElement element = simpleValueList.getValueElements().get(0);
				if (element.getValues().size() >1){
					isMultiple = true;
				}
			}
		}

		if (isMultiple){
			ret.setUpperBound(-1);
		}
		ret.setEType(EcorePackage.eINSTANCE.getEString());
		return ret;
	}



	/**
	 * @return
	 */
	public EPackage getGeneratedPackage() {

		return rhpEPackage;
	}

	/**
	 * @param visitedNodes
	 */
	public void setVisitedNodes(List<RpyNode> visitedNodes) {
		this.visitedNode = visitedNodes;
		
	}
}
