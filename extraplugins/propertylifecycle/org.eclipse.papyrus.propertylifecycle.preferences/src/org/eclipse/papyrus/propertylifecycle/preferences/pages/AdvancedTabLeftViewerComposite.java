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
import java.util.LinkedList;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.AdvancedTabLabelProvider;
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
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;


/**
 * Class handling the left viewer of the advanced Tab
 * 
 */
public class AdvancedTabLeftViewerComposite extends Composite {

	/** Factory used to get the information on the elements to populate the viewer */
	protected AdapterFactory adapterFactory;

	/** the viewer showing the available strategies */
	protected FilteredTree filteredViewer;

	/** Listener used to detect a different selection */
	protected ISelectionChangedListener selectionChangedListener;

	/** Listener used to identify the selected strategies */
	protected ISelection viewerSelection = StructuredSelection.EMPTY;

	/** Filter used to... filter the displayed strategies */
	protected PatternFilter patternFilter;

	// protected String elementFilter;


	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 *            The parent composite
	 * @param style
	 */
	public AdvancedTabLeftViewerComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout(1, true));
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		PropertylifecycleEditor contentEditor = new PropertylifecycleEditor();
		adapterFactory = contentEditor.getAdapterFactory();
		patternFilter = new PatternFilter();
		patternFilter.setIncludeLeadingWildcard(true);

		initStrategySelectionListener();
		createViewer(this);
	}

	/**
	 * Create the viewer
	 * 
	 * @param parent
	 *            This composite
	 */
	protected void createViewer(Composite parent) {
		filteredViewer = new FilteredTree(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, patternFilter, true);
		getViewer().setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		getViewer().setLabelProvider(new AdvancedTabLabelProvider(adapterFactory));

		getViewer().addSelectionChangedListener(selectionChangedListener);

		// Used to filter the elements in order to display the popup menu
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

				if ((((StructuredSelection) viewerSelection).getFirstElement() instanceof Resource)) {
					strategySetMenu(rightClickMenu);
				}
			}
		});

	}

	/**
	 * Create the menu item used to remove the selected model
	 * 
	 * @param associatedMenu
	 */
	private void strategySetMenu(Menu associatedMenu) {
		final MenuItem strategySetItem = new MenuItem(associatedMenu, SWT.NONE);
		strategySetItem.setText(Messages.RemoveStrategyModel_Label);
		strategySetItem.setImage(Activator.getDefault().getImage(Messages.RemoveStrategyModel_IconPath));
		strategySetItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Collection<Resource> viewerResources = new LinkedList<Resource>();
				for (Object object : ((StructuredSelection) getViewer().getSelection()).toArray()) {
					if (object instanceof Resource) {
						viewerResources.add((Resource) object);
					}
				}

				getViewerInput().getResources().removeAll(viewerResources);
			}
		});
	}

	/**
	 * Initialize the SelectionChangedListener
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
	 * Method used to add new models
	 * 
	 * @param resource
	 *            The resource linked to the model
	 */
	public void addNewModel(Resource resource) {
		if (getViewerInput() == null) {
			getViewer().setInput(resource.getResourceSet());
			return;
		}

		getViewerInput().getResources().add(resource);
	}

	/**
	 * @return
	 * 		The current strategies selection
	 */
	public ISelection getStrategiesSelection() {
		return viewerSelection;
	}

	/**
	 * @return
	 * 		The viewer
	 */
	public TreeViewer getViewer() {
		return filteredViewer.getViewer();
	}

	/**
	 * @return
	 * 		The names of the viewer's models
	 */
	public Collection<String> getViewerResourcesNames() {
		ResourceSet viewerInput = getViewerInput();
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
	 * Get the viewer input, i.e. the elements contained in the tree
	 * 
	 * @param viewer
	 * @return
	 * 		The resourceSet containing the models displayed in the viewer
	 */
	public ResourceSet getViewerInput() {
		Object viewerInput = getViewer().getInput();
		if (viewerInput instanceof ResourceSet) {
			return ((ResourceSet) viewerInput);
		}
		return null;
	}

	/**
	 * Convenience method
	 * 
	 * @return
	 * 		The list of the strategies in all the models present in the viewer
	 */
	public Collection<StrategyElement> getViewerStrategies() {
		Collection<StrategyElement> viewerStrategies = new LinkedList<StrategyElement>();

		for (Resource resource : getViewerInput().getResources()) {
			EObject eObject = resource.getContents().get(0);
			if (eObject instanceof StrategySet) {
				StrategySet set = (StrategySet) eObject;
				for (StrategyElement strategy : set.getStrategies()) {
					viewerStrategies.add(strategy);
				}
			}
		}

		return viewerStrategies;
	}


	// TODO implement dispose()

}
