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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyProjectHandler;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode;
import org.eclipse.ui.PlatformUI;

public class RhapsodyMetamodelUpdater {

	private static List<File> rpyProjects = new ArrayList<>();

	public static void updateMetamodel(URI inputMetamodelURI, URI outputMetamodelURI, File folderWithRhpProjects ) throws Exception{
		
		if (folderWithRhpProjects.exists() && folderWithRhpProjects.isDirectory()){
			rpyProjects.addAll(FileUtils.listFiles(folderWithRhpProjects, new String [] {"rpy"}, true));
			if (rpyProjects.isEmpty()){
				IllegalArgumentException exception = new IllegalArgumentException("The folder " +folderWithRhpProjects.getAbsolutePath() +" does not contain .rpy projects");
				Activator.log.error(exception);
				throw exception;
			}
		}else {
			IllegalArgumentException exception = new IllegalArgumentException("Error : " +folderWithRhpProjects.getAbsolutePath() +" does not exist or is not a directory");
			Activator.log.error(exception);
			throw exception;
		}
		
		ResourceSet resSet = new ResourceSetImpl();
		
		Resource mmRes = resSet.getResource(inputMetamodelURI, true);
		EPackage ecorePackage;
		if (mmRes !=null && ! mmRes.getContents().isEmpty() && mmRes.getContents().get(0) instanceof EPackage){
			ecorePackage = (EPackage) mmRes.getContents().get(0);
		}else {
			IllegalArgumentException exception = new IllegalArgumentException("Failed to load input metamodel "+ inputMetamodelURI.toFileString());
			Activator.log.error(exception);
			throw exception;
		}
		
		RhapsodyMetamodelGenerator mmGen = new RhapsodyMetamodelGenerator(ecorePackage);
		
		Map<String, Object> sharedFileMap = new HashMap<String, Object>();
		List<RpyNode> visitedNodes = new ArrayList<RpyNode>();
		for (File projectFile : rpyProjects){
			RpyProjectHandler projectHandler= new RpyProjectHandler(projectFile.getAbsolutePath());
			projectHandler.setSharedFilesMap(sharedFileMap);
			mmGen.setHandler(projectHandler);
			
			for(Object sharedResource : sharedFileMap.values()){
				if (sharedResource instanceof Resource){
					Iterator<EObject> shareResourceContent = ((Resource)sharedResource).getAllContents();
					while (shareResourceContent.hasNext()){
						EObject next = shareResourceContent.next();
						if (next instanceof RpyNode){
							visitedNodes.add((RpyNode) next);
						}
					}
				}
			}
			mmGen.setVisitedNodes(visitedNodes);
			mmGen.generateMetatmodel();	
		}
		
		EPackage mmPackage = mmGen.getGeneratedPackage();
	
		
		if (mmPackage != null){
			MetamodelFactorizer.factorizeMetamodel(mmPackage);
		}
		
		Comparator<EClassifier> comparator = new Comparator<EClassifier>() {

			@Override
			public int compare(EClassifier arg0, EClassifier arg1) {
				return arg0.getName().compareTo(arg1.getName());
			
			}
		};
		ECollections.sort(mmPackage.getEClassifiers(), comparator);
		
		
		Resource outputRes = resSet.createResource(outputMetamodelURI);
		if(outputRes != null){
			outputRes.getContents().add(mmPackage);
			try {
				outputRes.save(null);
			} catch (IOException e) {
				Activator.log.error("Failed to save output metamodel", e);
				throw e;
			}
		}else {
			IOException outputException = new IOException("Failed to create output metamodel resource for URI " + outputMetamodelURI.toString());
			Activator.log.error(outputException);
			throw outputException;
		}
		
		MessageDialog.openInformation(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Update success", "Successfully saved updated metamodel " + outputMetamodelURI.toString());
	}
	
}
