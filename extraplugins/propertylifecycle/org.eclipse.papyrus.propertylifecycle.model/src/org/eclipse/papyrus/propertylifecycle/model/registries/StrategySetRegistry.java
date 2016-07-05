/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.model.registries;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.model.Activator;
import org.eclipse.papyrus.propertylifecycle.model.extensionpoints.IStrategySetExtensionPoint;


/**
 * Convenience class used to get the informations on the strategy models referenced by extensions
 * 
 * @author QL238289
 *
 */
public class StrategySetRegistry {

	/** The registry */
	private static StrategySetRegistry strategySetRegistry;

	/** The models */
	protected Map<String, StrategySet> strategySets;

	/** ResourceSet hosting the registered strategySets */
	protected ResourceSet strategySetResourceSet;

	/**
	 * Retrieve the existing instance of the registry or create a new one
	 * 
	 * @return
	 * 		The current strategy registry
	 */
	public static synchronized StrategySetRegistry getInstance() {
		if (strategySetRegistry == null) {
			strategySetRegistry = new StrategySetRegistry();
			strategySetRegistry.init();
		}

		return strategySetRegistry;
	}

	/**
	 * Initialize the contents of the new instance of the registry
	 * 
	 */
	protected void init() {
		// Resets values
		strategySetResourceSet = null;
		strategySets = null;
		// Creates the resource set
		strategySetResourceSet = createResourceSet();
		// Creates the list only when registry is acceded for the first time, (or on reload?)
		// TODO select the strategies models from the preference page activations, store the ids and retrieve them here
		strategySets = readStrategySetModels();
	}

	/**
	 * Create a new {@link #org.eclipse.emf.ecore.resource.ResourceSet resourceSet}
	 * 
	 * @return
	 * 		The resourceSet that will contain the strategy models
	 */
	protected ResourceSet createResourceSet() {
		ResourceSet set = new ResourceSetImpl();
		return set;
	}

	/**
	 * @return
	 * 		A non null map containing the models retrieved from {@link #readExtensionsStrategySet() readExtensionsStrategySet()}
	 */
	protected Map<String, StrategySet> readStrategySetModels() {
		Map<String, StrategySet> localStrategySet = new HashMap<String, StrategySet>();

		// Retrieves from the platform, e.g. extension points
		// The localSets argument is used to verify that we do not load the same model twice, i.e. from the local and extension
		Map<String, StrategySet> registeredSets = readExtensionsStrategySet();
		if (registeredSets != null && !registeredSets.isEmpty()) {
			localStrategySet.putAll(registeredSets);
		}

		return localStrategySet;
	}

	/**
	 * @see org.eclipse.papyrus.propertylifecycle.model.extensionpoints.IStrategySetExtensionPoint
	 * 
	 * @return
	 * 		A map containing the models referenced by the extensions containing the correct ID
	 */
	protected Map<String, StrategySet> readExtensionsStrategySet() {
		Map<String, StrategySet> platformStrategySets = new HashMap<String, StrategySet>();
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(IStrategySetExtensionPoint.EXTENSION_POINT_ID);

		for (IConfigurationElement extension : extensions) {
			String modelPath = extension.getAttribute(IStrategySetExtensionPoint.PATH);
			String renameSetID = extension.getAttribute(IStrategySetExtensionPoint.ID);
			String contributorID = extension.getContributor().getName();
			StrategySet set = getStrategySetInBundle(modelPath, contributorID);
			// Verify if the models are already loaded or not
			if (set != null) {
				if (platformStrategySets.containsKey(renameSetID)) {
					continue;
				}
				platformStrategySets.put(renameSetID, set);
			}
		}

		return platformStrategySets;
	}

	/**
	 * Load the resource based on the given parameters
	 * 
	 * @param modelPath
	 *            The path of the resource from the contained bundle
	 * @param bundleID
	 *            The bundle ID used to form the URI
	 * @return
	 * 		The retrieved {@link #org.eclipse.emf.ecore.resource.ResourceSet resourceSet} or null
	 */
	protected StrategySet getStrategySetInBundle(String modelPath, String bundleID) {
		String path = bundleID + IPath.SEPARATOR + modelPath;
		Resource resource = strategySetResourceSet.createResource(URI.createPlatformPluginURI(path, true));
		try {
			resource.load(null);
		} catch (IOException e) {
			Activator.log.error(e);
		}

		EObject content = resource.getContents().get(0);
		if (content instanceof StrategySet) {
			return (StrategySet) content;
		}

		return null;
	}

	/**
	 * Convenience method
	 * 
	 * @return
	 * 		The Map containing the successfully retrieved models, identified by their extensionPoint's ID
	 */
	public Map<String, StrategySet> getStrategySets() {
		return strategySets;
	}

}
