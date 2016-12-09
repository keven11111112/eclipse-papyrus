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
package org.eclipse.papyrus.migration.rhapsody.importer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.migration.rhapsody.Activator;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.Messages;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RhapsodyFileUtils;
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
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProject;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyFactory;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;


/**
 * @author sr246418
 *
 */
public class UMLRhapsodyImporter {

	private RpyProjectHandler projectHandler;
	private ResourceSet resSet = new ResourceSetImpl();
	private	IProject rootProject = null; 
	private String targetPath;

	Map<EObject, EObject> transformedObjectMap = new HashMap<EObject, EObject>();
	Map<RpyFileHandler, Resource> fileToResourceMap = new HashMap<RpyFileHandler, Resource>();

	//TODO : would be better with URI instead of string
	public UMLRhapsodyImporter(String rpyPath, String targetPath){
		projectHandler = new RpyProjectHandler(rpyPath);
		this.targetPath = targetPath;
	}

//	public UMLRhapsodyImporter(URI rpyPath, String targetPath){
//		projectHandler = new RpyProjectHandler(rpyPath);
//		this.targetPath = targetPath;
//	}

	
	public IProject getRootProject(){
		if (rootProject == null){
			doTransformation();
		}
		return (rootProject);
	}

	public void save(){
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_ESCAPE_USING_CDATA, true);
		options.put(XMLResource.OPTION_XML_VERSION, "1.1");
		
		for (Resource res : resSet.getResources()) {
			try {
				res.save(options);
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * 
	 */
	private void doTransformation() {	
		RpyFileHandler projectFileHandler = projectHandler.getProjectFile();
		EObject rootTransformedObject = transform(projectFileHandler);
		
		//post transformation cleaning
		if (rootTransformedObject instanceof IProject){
			rootProject = (IProject)rootTransformedObject;
			if (projectFileHandler.getRpyFile() != null && projectFileHandler.getRpyFile().getVersion() != null){
				//set the RPY version to the project
				rootProject.setVersion(projectFileHandler.getRpyFile().getVersion());
			}
			
			//embedd the transformed proxies in the root resource (proxies are placeholder for not found references)
			for (RpyNode proxyNode : projectHandler.getAllProxies()){
				EObject transformedProxy = transformedObjectMap.get(proxyNode);
				if( transformedProxy != null){
					rootProject.eResource().getContents().add(transformedProxy);
				}
			}
			
		}	
	}

	/**
	 * @param projectFileHandler
	 * @return
	 */
	private EObject transform(RpyFileHandler rpyFileHandler) {
		Resource outputRes = getResource(rpyFileHandler);
		if (outputRes.getContents().isEmpty()){
			RpyFile rpyFile = rpyFileHandler.getRpyFile();

			List<EObject> roots= new ArrayList<EObject>();
			for (RpyContent fileContent : rpyFile.getContents()){
				if (fileContent instanceof RpyNode){
					EObject ret= transformNode((RpyNode) fileContent);
					if (ret!= null) {
						roots.add(ret);
					}
				}
			}
			outputRes.getContents().addAll(roots);			
		}
		if (outputRes.getContents().isEmpty()){
			return null;
		}else {
			return outputRes.getContents().get(0);
		}
	}

	
	
	/**
	 * @param fileContent
	 * @param rpyFileHandler
	 */
	private EObject  transformNode(RpyNode node) {
		EObject ret = transformedObjectMap.get(node);
		if (ret == null){
			String nodeName = node.getName();
			EClass targetEClass =(EClass) UMLRhapsodyPackage.eINSTANCE.getEClassifier(nodeName);
			if (targetEClass != null){
				ret = UMLRhapsodyFactory.eINSTANCE.create(targetEClass);
				transformedObjectMap.put(node, ret);
				List<EObject> subNodes = new ArrayList<EObject>();
				for (RpyContent nodeContent : node.getContents()){
					if (nodeContent instanceof RpyFeature){
						transformFeature (ret,(RpyFeature) nodeContent);
					}else if (nodeContent instanceof RpyNode){
						EObject transformedNode = transformNode((RpyNode) nodeContent);
						if (transformedNode != null){
							subNodes.add(transformedNode);
						}
					}
				}
				if (!subNodes.isEmpty() ){
					EStructuralFeature graphicalElementsFeature = targetEClass.getEStructuralFeature(RpyUtil.OWNED_ELEMENT_FEATURE_NAME);
					if (graphicalElementsFeature != null){
						setEReferenceValue(ret, graphicalElementsFeature, subNodes);
					}
				}
			}
			

		}

		return ret;


	}

	/**
	 * @param ret
	 * @param nodeContent
	 * @param rpyFileHandler
	 */
	private void transformFeature(EObject receiver, RpyFeature rpyFeature) {

		EStructuralFeature targetFeature = receiver.eClass().getEStructuralFeature(rpyFeature.getName().replaceAll("^_", ""));
		if (targetFeature != null){
			RpyFeatureValue rpyFeatureValue = RpyUtil.getFeatureValue(rpyFeature);

			if (rpyFeatureValue instanceof SimpleValueList ){
				if (RpyUtil.isDirectReference(rpyFeature)){
					RpyNode referencedNode = projectHandler.getSimpleFeatureReferencedNode(rpyFeature);

					transformOwningHandlerIfDifferent(referencedNode, rpyFeature);
					EObject value = transformNode(referencedNode);

					if (value != null && targetFeature instanceof EReference && isCompatibleType((EReference) targetFeature, value)) {
						setEReferenceValue(receiver, targetFeature, value);
					}
				}else if(targetFeature instanceof EAttribute){
					if (targetFeature.isMany()){
						List featValueList = (List) receiver.eGet(targetFeature);
						for (RpySimpleValueElement valueElement : ((SimpleValueList)rpyFeatureValue).getValueElements()){
							for (String value : valueElement.getValues()){
								featValueList.add(value.replaceAll("^\"", "").replaceAll("\"$", ""));
							}
						}
					}else {
						receiver.eSet(targetFeature, RpyUtil.getStringValue((SimpleValueList)rpyFeatureValue).replaceAll("^\"", "").replaceAll("\"$", ""));
					}

				}

			}else if (rpyFeatureValue instanceof RpyNodeList){
				RpyNodeList nodeList = (RpyNodeList) rpyFeatureValue;
				List<EObject> transformedObjects = new ArrayList<EObject>();
				for (RpyNode rpyNode : projectHandler.getNodes(nodeList)){
					transformOwningHandlerIfDifferent(rpyNode, rpyFeature);
					EObject targetObject = transformNode(rpyNode);
					if (targetObject != null){
						transformedObjects.add(targetObject);
					}
				}
				if (targetFeature instanceof EReference
						&& isCompatibleType((EReference) targetFeature, transformedObjects)) {
					setEReferenceValue(receiver, targetFeature, transformedObjects);
				}

			}
		}else {
			RpyNode sourceNode = (RpyNode) rpyFeature.eContainer();
			Activator.log.error(NLS.bind(Messages.FeatureNotFound,
					new String[] { rpyFeature.getName(), receiver.eClass().getName(),
							RpyUtil.getNodeIndexInFile(sourceNode),
							projectHandler.getOwningFileHandler(sourceNode).getURI().toFileString() }),
					null);
		}

	}

	/**
	 * @param referencedNode
	 * @param rpyFeature
	 */
	private void transformOwningHandlerIfDifferent(RpyNode referencedNode, RpyFeature rpyFeature) {
		RpyFileHandler referencedNodeHandler = projectHandler.getOwningFileHandler(referencedNode);
		if (referencedNodeHandler != null && referencedNodeHandler != projectHandler.getOwningFileHandler((RpyNode)rpyFeature.eContainer())){
			transform(referencedNodeHandler);
		}
	}

	/**
	 * @param receiver
	 * @param targetFeature
	 * @param value
	 */
	private void setEReferenceValue(EObject receiver, EStructuralFeature targetFeature, Object value) {
		if(targetFeature.isMany()){
			List receiverList = (List) receiver.eGet(targetFeature);
			if (value instanceof List){
				receiverList.addAll((List)value);
			}else {
				receiverList.add(value);
			}
		}else {
			if (value instanceof List){
				if (!((List)value).isEmpty()){
					receiver.eSet(targetFeature, ((List)value).get(0));
				}
				
			}else {
				receiver.eSet(targetFeature, value);
			}
		}

	}

	private boolean isCompatibleType(EReference targetReference, Object value) {
		boolean result = true;
		EClass containingEClass = targetReference.getEContainingClass();
		EClass eType = targetReference.getEReferenceType();
		if (value instanceof Collection) {
			for (Object valueElement : (Collection) value) {
				if (!eType.isInstance(valueElement)) {
					result = false;
					value = valueElement;

					break;
				}
			}

		} else {
			result = eType.isInstance(value);
		}
		if (!result) {
			Activator.log.warn("Object " + value + " has an incompatible type with " + eType.getName() + " of feature "
					+ targetReference.getName() + " of EClass " + containingEClass.getName()
					+ ".\n This element won't be imported. RhapsodyMetamodel implementation in Papyrus should be updated");

		}

		return result;
	}

	/**
	 * @param rpyFileHandler
	 * @return
	 */
	private Resource getResource(RpyFileHandler rpyFileHandler) {
		Resource ret = fileToResourceMap.get(rpyFileHandler);
		if (ret == null){
			URI inURI = rpyFileHandler.getURI();
			if (inURI != null){
				URI outURI = URI.createFileURI(targetPath).appendSegment(inURI.trimFileExtension().lastSegment()).appendFileExtension(RhapsodyFileUtils.UML_RHAPSODY_FILE);
				ret= resSet.createResource(outURI);
				fileToResourceMap.put(rpyFileHandler, ret);
			}
		}
		return ret;
	}







}
