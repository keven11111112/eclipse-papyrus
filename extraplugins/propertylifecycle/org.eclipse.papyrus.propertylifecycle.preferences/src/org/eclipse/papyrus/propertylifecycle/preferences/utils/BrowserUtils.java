/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.preferences.utils;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;

/**
 * Convenience class regrouping methods to retrieve model resources
 *
 */
public class BrowserUtils {

	/**
	 * Add the browsed models to the viewer
	 * 
	 * @param newSystemPaths
	 *            The selected models' paths
	 * @param viewer
	 *            The viewer that will receive these new models
	 */
	public static void addBrowsedModel(Collection<String> newSystemPaths, Viewer viewer) {

		for (String filePath : newSystemPaths) {
			Resource resource = getModelResource(filePath);
			if (resource == null || getViewerResources(viewer).contains(resource.getURI().lastSegment())) {
				continue;
			}

			EObject content = resource.getContents().get(0);
			if (content instanceof StrategySet) {
				// Preferences browsedNode = renamePreferences.node(Messages.BrowsedModels_Node);
				// browsedNode.putBoolean(filePath, true);
				addNewModel(resource, viewer);
			}
		}

		viewer.refresh();
	}

	/**
	 * @param filePath
	 *            The path of the selected model
	 * @return
	 * 		The resource associated to this path or null if none can be retrieved
	 */
	public static Resource getModelResource(String filePath) {
		URI fileURI = CommonPlugin.resolve(URI.createFileURI(filePath));
		// URI fileURI = URI.createFileURI(filePath);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(fileURI);

		try {
			resource.load(null);
			return resource;
		} catch (IOException ioerror) {
			Activator.log.error(ioerror);
		}
		return null;
	}

	/**
	 * @param filePath
	 *            The path of the selected model
	 * @return
	 * 		The strategy set associated to this path or null if none can be found
	 */
	public static StrategySet getStrategySet(String filePath) {
		Resource resource = getModelResource(filePath);
		if (resource == null) {
			return null;
		}
		EObject eObject = resource.getContents().get(0);

		if (eObject instanceof StrategySet) {
			return (StrategySet) eObject;
		}

		return null;
	}

	/**
	 * @param viewer
	 *            The viewer receiving the inputed resource
	 * @return
	 * 		The viewer's current contents @see org.eclipse.emf.ecore.resource.ResourceSet
	 */
	public static ResourceSet getViewerInput(Viewer viewer) {
		Object viewerInput = viewer.getInput();
		if (viewerInput instanceof ResourceSet) {
			return ((ResourceSet) viewerInput);
		}
		return null;
	}

	/**
	 * @param viewer
	 *            The viewer receiving the inputed resource
	 * @return
	 * 		The viewer's current contents' identifiers
	 */
	public static Collection<String> getViewerResources(Viewer viewer) {
		ResourceSet viewerInput = getViewerInput(viewer);
		if (viewerInput == null) {
			return new LinkedList<String>();
		}

		Collection<String> existingResources = new LinkedList<String>();
		for (Resource resource : viewerInput.getResources()) {
			// List used to verify that the user is not adding an existing model in the viewer
			existingResources.add(resource.getURI().lastSegment());
		}

		return existingResources;
	}

	/**
	 * Add the browsed resource to the viewer
	 * 
	 * @param resource
	 *            The selected resource
	 * @param viewer
	 *            The viewer to receive this resource
	 */
	public static void addNewModel(Resource resource, Viewer viewer) {
		if (getViewerInput(viewer) == null) {
			viewer.setInput(resource.getResourceSet());
			return;
		}

		getViewerInput(viewer).getResources().add(resource);
	}

}
