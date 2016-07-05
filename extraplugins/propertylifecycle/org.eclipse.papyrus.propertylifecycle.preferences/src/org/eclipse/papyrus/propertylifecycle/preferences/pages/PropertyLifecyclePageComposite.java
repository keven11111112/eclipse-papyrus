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

package org.eclipse.papyrus.propertylifecycle.preferences.pages;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.model.registries.StrategySetRegistry;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.BrowserUtils;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.PropertyLifecyclePreferencesManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


/**
 * This Composite is the root of the Basic and Advanced Tabs showing the selected and possible strategies
 * 
 */
public class PropertyLifecyclePageComposite extends CTabFolder {

	/** This collection contains the resources referenced in an extension and retrievable from the registry */
	private Collection<Resource> registryResources;

	/** This tab will show the entire resources as a whole entity */
	protected BasicTab basicTab;

	/** In this tab the resources will display all the underlying strategies for the user to choose from */
	protected AdvancedTab advancedTab;

	// BEGIN TEST-GREYOUT
	/** This set is used to visualize the currently selected strategies */
	private Set<String> handledStrategyRepositories = new HashSet<String>();
	// END TEST-GREYOUT


	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *            The parent composite used to harbor this one
	 * @param style
	 *            The border style of this composite
	 */
	public PropertyLifecyclePageComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createBasicTab();
		createAdvancedTab();

		initViewers();
		this.setSelection(0);
	}

	/**
	 * Creates the Basic selection tab
	 */
	private void createBasicTab() {
		basicTab = new BasicTab(this, SWT.BORDER) {
			// BEGIN TEST-GREYOUT
			@Override
			public void selectAllAction() {
				super.selectAllAction();
				getSelectedStrategyRepositories();
			}

			@Override
			public void deselectAllAction() {
				super.deselectAllAction();
				getSelectedStrategyRepositories();
			}
		};

		basicTab.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				getSelectedStrategyRepositories();
			}
		});
		// END TEST-GREYOUT
	}

	/**
	 * Creates the advanced selection tab
	 */
	private void createAdvancedTab() {
		advancedTab = new AdvancedTab(this, SWT.BORDER) {
			// BEGIN TEST-GREYOUT
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				getSelectedStrategyRepositories();
			}
			// END TEST-GREYOUT
		};
	}

	/**
	 * Call the necessary methods to populate the basic and advanced tabs
	 */
	private void initViewers() {
		// clearViewers();

		// Load the Registry strategySet models as a default behavior
		addRegistryStrategiesToViewers();

		// Retrieve the previous preferences
		PropertyLifecyclePreferencesManager preferencesManager = new PropertyLifecyclePreferencesManager();
		BrowserUtils.addBrowsedModel(preferencesManager.retrieveAdvancedTabModelPaths(), advancedTab.getLeftViewer());
		BrowserUtils.addBrowsedModel(preferencesManager.retrieveBasicTabModelPaths(), basicTab.getViewer());

		// Initialize the viewers' selections
		basicTab.initSelection(preferencesManager.retrieveBasicTabModelPaths());
		if (!preferencesManager.nodeExists(Messages.BasicBrowsedModels_Node)) {
			// The Default behavior, if the user has not deactivated all the models, is to preselect all
			// basicTab.defaultSelection();
		}
		advancedTab.addStrategies(preferencesManager.retrieveAdvancedTabStrategies());

		getSelectedStrategyRepositories();
	}

	/**
	 * Retrieve the resources referenced in the registry
	 */
	private void addRegistryStrategiesToViewers() {
		ResourceSet resourceSet = new ResourceSetImpl();
		registryResources = new HashSet<Resource>();
		Map<String, StrategySet> strategySets = StrategySetRegistry.getInstance().getStrategySets();
		if (strategySets != null) {
			for (String setKey : strategySets.keySet()) {
				StrategySet strategySet = strategySets.get(setKey);
				resourceSet.getResources().add(strategySet.eResource());
				registryResources.add(strategySet.eResource());
			}
		}

		advancedTab.getLeftViewer().setInput(resourceSet);
		basicTab.getViewer().setInput(resourceSet);
	}

	/**
	 * Clear the viewers to their default state
	 */
	public void resetViewers() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResources().addAll(registryResources);

		advancedTab.removeAllSelectionCompositeStrategies();
		advancedTab.setRegisteredCompositeInput(resourceSet);
		basicTab.removeNonRegistryModels(resourceSet);
	}

	/**
	 * Get the adresses of the selected resources from the basic tab
	 * 
	 * @return
	 */
	public Collection<String> getBasicParentModels() {
		return basicTab.getSelectedModels();
	}

	/**
	 * Get the resulting selected strategies from the selected resources
	 * 
	 * @return
	 */
	public Collection<StrategyElement> getBasicStrategies() {
		return basicTab.getSelectedStrategies();
	}

	/**
	 * Get the adresses of the selected resources from the advanced tab
	 * 
	 * @return
	 */
	public Collection<String> getAdvancedParentModels() {
		return advancedTab.getAdvancedParentModels();
	}

	/**
	 * Get the resulting strategies from the selected resources
	 * 
	 * @return
	 */
	public Collection<StrategyElement> getAdvancedStrategies() {
		return advancedTab.getAdvancedStrategies();
	}

	/**
	 * Get the currently selected resources and initiate the corresponding visual representation
	 * 
	 * @return
	 * 		The list of the selected addresses
	 */
	private Set<String> getSelectedStrategyRepositories() {
		handledStrategyRepositories.clear();
		if (advancedTab.rightViewerComposite == null || basicTab == null) {
			return new HashSet<String>();
		}

		for (String modelName : advancedTab.rightViewerComposite.getParentModels()) {
			URI test = URI.createFileURI(modelName);
			handledStrategyRepositories.add(test.lastSegment());
		}
		for (String modelName : basicTab.getSelectedModels()) {
			URI test = URI.createFileURI(modelName);
			handledStrategyRepositories.add(test.lastSegment());
		}

		Activator.log.trace(Activator.STRATEGY_PREFERENCES_TRACE, handledStrategyRepositories.toString());
		basicTab.setItemColor(handledStrategyRepositories);
		return handledStrategyRepositories;
	}

	// TODO implement dispose()

}
