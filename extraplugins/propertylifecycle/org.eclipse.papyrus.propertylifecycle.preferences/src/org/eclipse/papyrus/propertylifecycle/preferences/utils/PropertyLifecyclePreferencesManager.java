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

package org.eclipse.papyrus.propertylifecycle.preferences.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.model.registries.StrategySetRegistry;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * Convenience class used to handle the preferences in one place
 * 
 */
public class PropertyLifecyclePreferencesManager {

	/** Preference node containing the strategies informations */
	// private Preferences renamePreferences = InstanceScope.INSTANCE.getNode(Messages.PreferenceRenameStrategies);
	// We need to retain the preferences through multiple restarts
	private Preferences propertyLifecyclePreferences = ConfigurationScope.INSTANCE.getNode(Messages.PropertyLifecycleStrategies);

	// Basic Tab
	/** Set containing the selected models in the basic tab viewer */
	private HashSet<StrategySet> basicTabParentModels;

	/** Ids of the strategies contained in the selected models */
	private HashSet<String> basicTabStrategiesIDs;

	/** Addresses of the selected models */
	private HashSet<String> basicTabBrowsedModelsURI;

	/** strategies and their ids used to filter duplicates */
	private HashMap<String, StrategyElement> basicTabStrategies;

	// Advanced Tab
	/** Set containing the selected models in the advanced tab viewer */
	private HashSet<StrategySet> advancedTabParentModels;

	/** Ids of the selected strategies */
	private HashSet<String> advancedTabStrategiesIDs;

	/** Addresses of the models containing the selected strategies */
	private HashSet<String> advancedTabBrowsedModelsURI;

	/** Strategies and their ids used to filter duplicates */
	private HashMap<String, StrategyElement> advancedTabStrategies;


	/**
	 * Build the skeleton of the future preference Node
	 * 
	 * Constructor.
	 */
	public PropertyLifecyclePreferencesManager() {
		basicTabParentModels = new HashSet<StrategySet>();
		basicTabStrategiesIDs = new HashSet<String>();
		basicTabBrowsedModelsURI = new HashSet<String>();
		browseRegisteredPreferences(basicTabParentModels, basicTabStrategiesIDs,
				basicTabBrowsedModelsURI, Messages.BasicBrowsedModels_Node, Messages.BasicSelectedStrategies_Node);

		advancedTabParentModels = new HashSet<StrategySet>();
		advancedTabStrategiesIDs = new HashSet<String>();
		advancedTabBrowsedModelsURI = new HashSet<String>();
		browseRegisteredPreferences(advancedTabParentModels, advancedTabStrategiesIDs,
				advancedTabBrowsedModelsURI, Messages.AdvancedBrowsedModels_Node, Messages.AdvancedSelectedStrategies_Node);
	}

	/**
	 * 
	 * @return
	 * 		The strategies preferences
	 */
	public Preferences getRenamePreferences() {
		return propertyLifecyclePreferences;
	}

	/**
	 * Parse the current preference Node and retrieve the associated informations on the models and their strategies
	 * 
	 * @param parentModels
	 *            The current models
	 * @param strategiesIDs
	 *            The current strategies IDs
	 * @param browsedModelsURI
	 *            The current models' URis
	 * @param modelNodePath
	 *            The model node to parse
	 * @param strategiesNodePath
	 *            The strategy node to parse
	 */
	private void browseRegisteredPreferences(HashSet<StrategySet> parentModels, HashSet<String> strategiesIDs,
			HashSet<String> browsedModelsURI, String modelNodePath, String strategiesNodePath) {

		try {
			for (String childName : propertyLifecyclePreferences.childrenNames()) {
				Preferences childNode = propertyLifecyclePreferences.node(childName);
				if (childName.equalsIgnoreCase(modelNodePath)) {
					for (String modelURI : childNode.keys()) {
						browsedModelsURI.add(modelURI);
						StrategySet model = BrowserUtils.getStrategySet(modelURI);
						if (model != null) {
							parentModels.add(model);
						}
					}
				}

				if (childName.equalsIgnoreCase(strategiesNodePath)) {
					for (String strategyID : childNode.keys()) {
						strategiesIDs.add(strategyID);
					}
				}

			}
		} catch (BackingStoreException bse) {
			Activator.log.error(bse);
		}
	}

	/**
	 * Retrieve the strategy corresponding to an ID from the selected models
	 * 
	 * @param strategyID
	 *            The unique ID
	 * @param parentModels
	 *            The selected models
	 * @param strategies
	 *            The set containing the newly found pair
	 */
	private void getCorrespondigStrategy(String strategyID, HashSet<StrategySet> parentModels,
			HashMap<String, StrategyElement> strategies) {
		for (StrategySet model : parentModels) {
			for (StrategyElement strategy : model.getStrategies()) {
				if (strategyID.equals(strategy.getId())) {
					strategies.put(strategyID, strategy);
				}
			}
		}
	}

	/**
	 * @return
	 * 		The strategies from the basic tab
	 */
	public Collection<StrategyElement> retrieveBasicTabStrategies() {
		basicTabStrategies = new HashMap<String, StrategyElement>();
		basicTabStrategiesIDs = new HashSet<String>();
		basicTabBrowsedModelsURI = new HashSet<String>();
		basicTabParentModels = new HashSet<StrategySet>();

		browseRegisteredPreferences(basicTabParentModels, basicTabStrategiesIDs,
				basicTabBrowsedModelsURI, Messages.BasicBrowsedModels_Node, Messages.BasicSelectedStrategies_Node);

		for (String strategyID : basicTabStrategiesIDs) {
			getCorrespondigStrategy(strategyID, basicTabParentModels, basicTabStrategies);
		}

		// Activator.log.trace(Activator.RENAMING_PREFERENCES_TRACE, "basicTabStrategies.values(): " + basicTabStrategies.values().size());
		return basicTabStrategies.values();
	}

	/**
	 * @return
	 * 		The models' URI
	 */
	public Collection<String> retrieveBasicTabModelPaths() {
		return basicTabBrowsedModelsURI;
	}

	/**
	 * @return
	 * 		The strategies from the advanced tab
	 */
	public Collection<StrategyElement> retrieveAdvancedTabStrategies() {
		advancedTabStrategies = new HashMap<String, StrategyElement>();
		advancedTabStrategiesIDs = new HashSet<String>();
		advancedTabBrowsedModelsURI = new HashSet<String>();
		advancedTabParentModels = new HashSet<StrategySet>();

		browseRegisteredPreferences(advancedTabParentModels, advancedTabStrategiesIDs,
				advancedTabBrowsedModelsURI, Messages.AdvancedBrowsedModels_Node, Messages.AdvancedSelectedStrategies_Node);

		for (String strategyID : advancedTabStrategiesIDs) {
			getCorrespondigStrategy(strategyID, advancedTabParentModels, advancedTabStrategies);
		}

		// Activator.log.trace(Activator.RENAMING_PREFERENCES_TRACE, "advancedTabStrategies.values(): " + advancedTabStrategies.values().size());
		return advancedTabStrategies.values();
	}

	/**
	 * @return
	 * 		All the strategies from the preference node and the selected strategies from both tabs
	 */
	public Collection<StrategyElement> retrieveAllStrategies() {
		Map<String, StrategyElement> allStrategies = new HashMap<>();
		try {
			Activator.log.trace(Activator.STRATEGY_PREFERENCES_TRACE, "childrenNodes: " + propertyLifecyclePreferences.childrenNames().length);
			if (propertyLifecyclePreferences.childrenNames().length == 0) {
				// The User still hasn't selected anything in the preference page
				// Populate the preferences with the default models
				Map<String, StrategySet> renameSets = StrategySetRegistry.getInstance().getStrategySets();
				if (renameSets != null) {
					for (String setKey : renameSets.keySet()) {
						StrategySet renameSetConfiguration = renameSets.get(setKey);
						String modelURI = renameSetConfiguration.eResource().getURI().toString();
						// Activator.log.trace(Activator.RENAMING_PREFERENCES_TRACE, "modelURI: " + modelURI);

						Preferences basicModelNode = propertyLifecyclePreferences.node(Messages.BasicBrowsedModels_Node);
						basicModelNode.putBoolean(modelURI, true);
						Preferences basicConfigurationNode = propertyLifecyclePreferences.node(Messages.BasicSelectedStrategies_Node);
						for (StrategyElement configuration : renameSetConfiguration.getStrategies()) {
							basicConfigurationNode.putBoolean(configuration.getId(), true);
						}
					}
				}

				savePreferences();
			}
		} catch (BackingStoreException e) {
			Activator.log.error(e);
		}

		// Get the preferences selected by the user
		for (StrategyElement strategy : retrieveBasicTabStrategies()) {
			allStrategies.put(strategy.getId(), strategy);
		}
		for (StrategyElement strategy : retrieveAdvancedTabStrategies()) {
			allStrategies.put(strategy.getId(), strategy);
		}

		Activator.log.trace(Activator.STRATEGY_PREFERENCES_TRACE, "allStrategies.size(): " + allStrategies.values().size());
		return allStrategies.values();
	}

	/**
	 * @return
	 * 		The models' URI
	 */
	public Collection<String> retrieveAdvancedTabModelPaths() {
		return advancedTabBrowsedModelsURI;
	}

	/**
	 * Register the selected strategies and their models in the preference node
	 * 
	 * @param basicModelsURIs
	 *            {@link #retrieveBasicTabModelPaths() retieveBasicTabModelPaths()}
	 * @param advancedModelsURIs
	 *            {@link #retrieveAdvancedTabModelPaths() retieveAdvancedTabModelPaths()}
	 * @param basicConfigurations
	 *            {@link #retrieveBasicTabStrategies() retrieveBasicTabStrategies()}
	 * @param advancedConfigurations
	 *            {@link #retrieveAdvancedTabStrategies() retrieveAdvancedTabStrategies()}
	 */
	public void registerCurrentPreferences(Collection<String> basicModelsURIs, Collection<String> advancedModelsURIs,
			Collection<StrategyElement> basicConfigurations, Collection<StrategyElement> advancedConfigurations) {

		clearPreferences();
		// Create the Nodes to house the preferences
		Preferences basicModelNode = propertyLifecyclePreferences.node(Messages.BasicBrowsedModels_Node);
		Preferences basicConfigurationNode = propertyLifecyclePreferences.node(Messages.BasicSelectedStrategies_Node);
		Preferences advancedModelNode = propertyLifecyclePreferences.node(Messages.AdvancedBrowsedModels_Node);
		Preferences advancedConfigurationNode = propertyLifecyclePreferences.node(Messages.AdvancedSelectedStrategies_Node);

		// Save all the models (URIs) used to get the current configuration
		if (basicModelsURIs != null) {
			for (String modelURI : basicModelsURIs) {
				basicModelNode.putBoolean(modelURI, true);
			}
		}
		if (advancedModelsURIs != null) {
			for (String modelURI : advancedModelsURIs) {
				advancedModelNode.putBoolean(modelURI, true);
			}
		}

		// Save all the strategies (IDs) used in the current configuration
		if (basicConfigurations != null) {
			for (StrategyElement strategy : basicConfigurations) {
				basicConfigurationNode.putBoolean(strategy.getId(), true);
			}

		}
		if (advancedConfigurations != null) {
			for (StrategyElement strategy : advancedConfigurations) {
				advancedConfigurationNode.putBoolean(strategy.getId(), true);
			}
		}

		savePreferences();
	}

	/**
	 * Clear the preference node completely
	 */
	public void clearPreferences() {
		try {
			// Deletes all the preference's children nodes
			String[] childrenNames = propertyLifecyclePreferences.childrenNames();
			for (String childName : childrenNames) {
				Preferences childNode = propertyLifecyclePreferences.node(childName);
				childNode.removeNode();
			}

			savePreferences();
		} catch (BackingStoreException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Save the amended preference node
	 */
	private void savePreferences() {
		try {
			// Save the current strategies model's informations
			propertyLifecyclePreferences.flush();
		} catch (BackingStoreException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Verify that the node exists
	 * 
	 * @param pathName
	 *            The node's name
	 * @return
	 * 		true or false
	 */
	public boolean nodeExists(String pathName) {
		try {
			return propertyLifecyclePreferences.nodeExists(pathName);
		} catch (BackingStoreException e) {
			Activator.log.error(e);
		}
		return false;
	}

}
