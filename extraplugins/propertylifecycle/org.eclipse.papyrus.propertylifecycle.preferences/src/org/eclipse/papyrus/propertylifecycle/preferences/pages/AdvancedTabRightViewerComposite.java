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

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.propertylifecycle.PropertylifecycleFactory;
import org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.AdvancedTabLabelProvider;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.AdvancedTabViewerUtils;
import org.eclipse.papyrus.propertylifecycle.presentation.PropertylifecycleEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;

/**
 * The Composite containing the right viewer of the advanced tab
 * 
 */
public class AdvancedTabRightViewerComposite extends Composite {

	/** The models containing the selected strategies */
	protected Map<String, String> parentModels;

	/** Factory used to get the information on the elements to populate the viewer */
	protected AdapterFactory adapterFactory;

	/** The viewer containing the selected strategies */
	protected TreeViewer treeViewer;

	/** The resourceSet containing the advanced Tab's custom model constructed by the user selected strategies */
	protected ResourceSet customStrategySetResourceSet;

	/** The set containing the selected strategies */
	protected StrategySet customStrategySet;

	/** The model containing the selected strategies */
	protected Resource strategySetResource;

	/** Factory used to construct the new custom model */
	protected PropertylifecycleFactory newModelFactory = PropertylifecycleFactory.eINSTANCE;

	/** The list of the selected strategies */
	protected Map<String, StrategyElement> viewerStrategies;

	/** Listener used to detect a different selection */
	protected ISelectionChangedListener selectionChangedListener;

	/** Listener used to identify the selected strategies */
	protected ISelection viewerSelection;


	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 *            The containing composite
	 * @param style
	 */
	public AdvancedTabRightViewerComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout(1, true));
		// this.setLayout(new GridLayout(2, false));
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// parentModels = new LinkedList<String>();
		parentModels = new HashMap<String, String>();

		PropertylifecycleEditor contentEditor = new PropertylifecycleEditor();
		adapterFactory = contentEditor.getAdapterFactory();
		viewerStrategies = new HashMap<String, StrategyElement>();

		initStrategySelectionListener();
		createViewer(this);
		initViewer();
	}

	/**
	 * Create the viewer and its associated popup menus
	 * 
	 * @param parent
	 *            this
	 */
	protected void createViewer(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		treeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		treeViewer.setLabelProvider(new AdvancedTabLabelProvider(adapterFactory));

		treeViewer.addSelectionChangedListener(selectionChangedListener);

		Tree tree = getViewer().getTree();
		final Menu rightClickMenu = new Menu(tree);
		tree.setMenu(rightClickMenu);
		rightClickMenu.addMenuListener(new MenuAdapter() {

			@Override
			public void menuShown(MenuEvent e) {
				MenuItem[] items = rightClickMenu.getItems();
				for (int i = 0; i < items.length; i++) {
					items[i].dispose();
				}

				if (((StructuredSelection) viewerSelection).getFirstElement() instanceof StrategyElement) {
					strategyMenu(rightClickMenu);
				}

				if (((StructuredSelection) viewerSelection).getFirstElement() instanceof StrategyElement) {
					strategySetMenu(rightClickMenu);
				}

			}
		});

	}

	/**
	 * Create the menu item controlling the removal of the selected strategies
	 * 
	 * @param associatedMenu
	 *            The parent menu
	 */
	private void strategyMenu(Menu associatedMenu) {
		final MenuItem configurationItem = new MenuItem(associatedMenu, SWT.NONE);
		configurationItem.setText(Messages.RemoveStrategy_Label);
		configurationItem.setImage(Activator.getDefault().getImage(Messages.RemoveStrategy_IconPath));
		configurationItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				StrategySet customSet = (StrategySet) getViewerInput().getResources().get(0).getContents().get(0);
				Collection<StrategyElement> strategiesToRemove = new LinkedList<StrategyElement>();

				for (Object object : ((StructuredSelection) viewerSelection).toArray()) {
					if (object instanceof StrategyElement) {
						strategiesToRemove.add((StrategyElement) object);
					}
				}

				for (StrategyElement strategy : strategiesToRemove) {
					customSet.getStrategies().remove(strategy);
					viewerStrategies.remove(strategy.getId());
				}

			}
		});
	}

	/**
	 * Create the menu item controlling the removal of the selected model
	 * 
	 * @param associatedMenu
	 *            The parent menu
	 */
	private void strategySetMenu(Menu associatedMenu) {
		final MenuItem strategySetItem = new MenuItem(associatedMenu, SWT.NONE);
		strategySetItem.setText(Messages.RemoveAllStrategies_Label);
		strategySetItem.setImage(Activator.getDefault().getImage(Messages.RemoveAllStrategies_IconPath));
		strategySetItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				StrategySet customSet = (StrategySet) getViewerInput().getResources().get(0).getContents().get(0);

				for (StrategyElement strategy : getViewerStrategySet().getStrategies()) {
					viewerStrategies.remove(strategy.getId());
				}

				customSet.getStrategies().clear();

			}
		});
	}

	/**
	 * @return
	 * 		The viewer
	 */
	public TreeViewer getViewer() {
		return treeViewer;
	}

	/**
	 * Initialize the listener used to retrieve the selected items
	 */
	protected void initStrategySelectionListener() {
		selectionChangedListener = new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				viewerSelection = event.getSelection();
			}
		};
	}

	/**
	 * Initialize the viewer contents
	 */
	protected void initViewer() {
		customStrategySetResourceSet = new ResourceSetImpl();
		// configurationResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMLResourceFactoryImpl());
		// configurationResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		// Default behavior
		initFromScratch();

		getViewer().refresh();
	}

	/**
	 * Create the viewer contents if no previous activity/selection existed
	 */
	private void initFromScratch() {
		// Only launch if there were no previously constructed resource
		// Creates the root object for the custom model
		customStrategySet = newModelFactory.createStrategySet();
		customStrategySet.setId("CustomConfiguration"); //$NON-NLS-1$
		// Empty resourceSet to be filled by the custom selection of the user
		URI fileURI = CommonPlugin.resolve(URI.createFileURI(Platform.getLocation().toOSString() + "/Custom.propertylifecyclestrategyset")); //$NON-NLS-1$
		// URI fileURI = URI.createFileURI(Platform.getLocation().toOSString() + "/Custom.renamestrategiesconfigurations"); //$NON-NLS-1$
		strategySetResource = customStrategySetResourceSet.createResource(fileURI, PropertylifecyclePackage.eCONTENT_TYPE);
		strategySetResource.getContents().add(customStrategySet);

		getViewer().setInput(customStrategySetResourceSet);

		expandToLevel(1);
	}

	/**
	 * Utility method used to expand the tree
	 * 
	 * @param level
	 *            The required level
	 */
	private void expandToLevel(int level) {
		// Search the tree for the Set and expand from there to reveal the strategies if any exists
		getViewer().expandToLevel(getViewerInput().getResources().get(0), level);
	}

	/**
	 * @return
	 * 		The viewer's contents
	 */
	public ResourceSet getViewerInput() {
		Object viewerInput = getViewer().getInput();
		if (viewerInput instanceof ResourceSet) {
			return ((ResourceSet) viewerInput);
		}
		return null;
	}

	/**
	 * Add method, pointing to {@link #addStrategies(Collection)}
	 * 
	 * @param selection
	 *            The selected items from another viewer
	 */
	public void addStrategies(ISelection selection) {
		if (!(selection instanceof StructuredSelection)) {
			return;
		}
		Collection<?> selectedElements = ((StructuredSelection) selection).toList();

		addStrategies(selectedElements);
	}

	/**
	 * Add method, pointing to {@link #addStrategies(Collection)}
	 * 
	 * @param resourceSet
	 *            The selected items from another source
	 */
	public void addStrategies(ResourceSet resourceSet) {
		Collection<Resource> resources = new LinkedList<Resource>();
		for (Resource resource : resourceSet.getResources()) {
			resources.add(resource);
		}

		addStrategies(resources);
	}

	/**
	 * Main add method
	 * 
	 * @param selection
	 *            The selected strategies
	 */
	public void addStrategies(Collection<?> selection) {
		// Copy of the selection to update as the cases are treated
		Collection<Object> remainingSelection = new ArrayList<Object>(selection);
		Collection<StrategyElement> selectedStrategies = new LinkedList<StrategyElement>();

		// First - extract the strategies from the inputed resources and delete these from the remaining selection
		for (Object object : selection) {
			if (!(object instanceof Resource)) {
				continue;
			}

			for (Object resourceContent : ((Resource) object).getContents()) {
				if (!(resourceContent instanceof StrategySet)) {
					continue;
				}

				// This will only be the case if the user has selected both the resource and the contained set
				StrategySet strategySet = (StrategySet) resourceContent;
				if (remainingSelection.contains(strategySet)) {
					// In this case, the configurations of the set will be revealed by getContentConfigurations
					remainingSelection.remove(strategySet);
				}

				List<StrategyElement> newStrategies = getContentStrategies(resourceContent);
				// This will only be the case if the user has selected both the resource and the contained configuration
				for (StrategyElement strategy : newStrategies) {
					if (remainingSelection.contains(strategy)) {
						remainingSelection.remove(strategy);
					}
				}

				selectedStrategies.addAll(newStrategies);
			}

			if (remainingSelection.contains(object)) {
				remainingSelection.remove(object);
			}
		}

		// Second - extract the strategies from the inputed sets and delete those from the remaining selection
		List<Object> postResourceSelection = new ArrayList<Object>(remainingSelection);
		for (Object object : postResourceSelection) {
			if (!(object instanceof StrategySet)) {
				continue;
			}

			List<StrategyElement> newStrategies = getNewStrategySetStrategies((StrategySet) object);
			// This case will occur if the user has selected a set and some of its contained configurations
			for (StrategyElement strategy : newStrategies) {
				if (remainingSelection.contains(strategy)) {
					remainingSelection.remove(strategy);
				}
			}

			selectedStrategies.addAll(newStrategies);
		}

		// Lastly - extract the remaining strategies to complete the selection
		for (Object object : remainingSelection) {
			if (!(object instanceof StrategyElement)) {
				continue;
			}

			StrategyElement remainigStrategy = (StrategyElement) object;
			if (!(viewerStrategies.containsKey(remainigStrategy.getId()))) {
				viewerStrategies.put(remainigStrategy.getId(), remainigStrategy);
				selectedStrategies.add(remainigStrategy);
			}
		}

		populateViewer(selectedStrategies);
	}

	/**
	 * Used to extract the strategies from the set @see RenameSetConfiguration
	 * 
	 * @param object
	 *            The set
	 * @return
	 * 		The list of the contained strategies or an empty list
	 */
	private List<StrategyElement> getContentStrategies(Object object) {
		List<StrategyElement> contentStrategies = new LinkedList<StrategyElement>();
		if (object instanceof StrategySet) {
			return getNewStrategySetStrategies((StrategySet) object);
		}

		return contentStrategies;
	}

	/**
	 * Used to extract the strategies from the set @see RenameSetConfiguration
	 * 
	 * @param strategySet
	 *            The set
	 * @return
	 * 		The list of the contained strategies
	 */
	private List<StrategyElement> getNewStrategySetStrategies(StrategySet strategySet) {
		List<StrategyElement> newStrategies = new LinkedList<StrategyElement>();
		for (StrategyElement strategy : strategySet.getStrategies()) {
			if (viewerStrategies.containsKey(strategy.getId())) {
				continue;
			}

			viewerStrategies.put(strategy.getId(), strategy);
			newStrategies.add(strategy);
		}

		return newStrategies;
	}

	/**
	 * Populates the viewer with the inputed strategies
	 * 
	 * @param strategies
	 *            The selected strategies
	 */
	private void populateViewer(Collection<StrategyElement> strategies) {

		for (StrategyElement strategy : strategies) {
			setParentModelsURI(strategy);

			// This will remove the configuration from the left viewer to add it to the right one
			// newRenameSetConfiguration.getConfigurations().add((RenameConfiguration) configuration);

			// getViewerStrategySet().getStrategies().add(AdvancedTabViewerUtils.getnewStrategy(strategy));
			getViewerStrategySet().getStrategies().add(AdvancedTabViewerUtils.cloneStrategy(strategy));
			viewerStrategies.put(strategy.getId(), strategy);
		}

		// Search the tree for the Set and expand one more level from there
		if (!getViewer().getExpandedState(getViewerStrategySet()) || !getViewer().getExpandedState(customStrategySetResourceSet)) {
			getViewer().expandToLevel(getViewerStrategySet(), 1);
		}
		getViewer().refresh();
	}

	/**
	 * Add the URI of the model containing the added strategy to the list of handled models
	 * 
	 * @param renameConfiguration
	 *            The added strategy
	 */
	private void setParentModelsURI(StrategyElement strategy) {
		StrategySet strategySet = (StrategySet) strategy.eContainer();
		String setURI = strategySet.eResource().getURI().toString();
		// if (!parentModels.contains(setURI)) {
		// parentModels.add(setURI);
		// }
		if (!parentModels.containsKey(strategy.getId())) {
			parentModels.put(strategy.getId(), setURI);
		}
	}

	/**
	 * @return
	 * 		The parent models of the selected strategies
	 */
	public Collection<String> getParentModels() {
		HashSet<String> usedModels = new HashSet<String>();
		for (String key : parentModels.keySet()) {
			usedModels.add(parentModels.get(key));
		}

		return usedModels;
	}

	/**
	 * Remove the selected configurations from the viewer and their associated model from the parent list of necessary
	 */
	protected void removeSelectedStrategies() {
		@SuppressWarnings("unchecked")
		List<StrategyElement> strategiesToRemove = viewerSelection instanceof StructuredSelection ? ((StructuredSelection) viewerSelection).toList() : new LinkedList<StrategyElement>();
		getViewerStrategySet().getStrategies().removeAll(strategiesToRemove);
		for (StrategyElement renameConfiguration : strategiesToRemove) {
			viewerStrategies.remove(renameConfiguration.getId());
			parentModels.keySet().removeAll(Collections.singleton(renameConfiguration.getId()));
		}

		getViewer().refresh();
	}

	/**
	 * @return
	 * 		The strategy set build inside this viewer
	 */
	private StrategySet getViewerStrategySet() {
		if (getViewerInput().getResources().get(0).getContents().get(0) instanceof StrategySet) {
			return (StrategySet) getViewerInput().getResources().get(0).getContents().get(0);
		}
		return null;
	}

	/**
	 * @return
	 * 		The strategies selected in this viewer
	 */
	public Collection<StrategyElement> getViewerStrategies() {
		return getViewerStrategySet().getStrategies();
	}

	/**
	 * Clear all the strategies from the viewer and their associated lists
	 */
	protected void removeAllStrategies() {
		getViewerStrategies().clear();
		viewerStrategies.clear();
		parentModels.clear();

		getViewer().refresh();
	}

	/**
	 * @return
	 * 		The resource containing the strategy set build inside this viewer
	 */
	public Resource getStrategiesModelResource() {
		return strategySetResource = getViewerInput().getResources().get(0);
	}

	/**
	 * @return
	 * 		The state of the viewer
	 */
	protected boolean isEmpty() {
		// The second condition can be achieved if the user added an empty selection to an empty tree
		if (getViewer().getTree().getItems().length > 0 && customStrategySet != null) {
			return false;
		}
		return true;
	}


	// TODO implement dispose()

}
