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
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.BrowseButton;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.SaveButton;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Handle the creation of the advanced Tab in the preference page
 * 
 */
public class AdvancedTab implements SelectionListener {

	/** Composite containing the left viewer representing the resources and strategies available for selection */
	protected AdvancedTabLeftViewerComposite leftViewerComposite;

	/** Composite containing the right viewer representing the current selection of strategies */
	protected AdvancedTabRightViewerComposite rightViewerComposite;

	/** Composite containing the middle buttons used to add, delete or sync the strategies between both viewers */
	private Composite controlComposite;

	/** Button used to synchronize the selection between both viewers */
	private Button syncButton;

	/** Button used to add a new set of strategies to the selected ones */
	private Button addButton;

	/** Button used to remove the selection from the selected strategies */
	private Button removeButton;

	/** Button used to add all the strategies from the left viewer to the right */
	private Button addAllButton;

	/** Button used to remove all the strategies from the right viewer */
	private Button removeAllButton;

	/** the selection in the viewer */
	private List<Object> viewerSelection = new LinkedList<>();

	/** the IDs of the selected strategies to filter during synchronization */
	private List<String> viewerSelectionIDs = new LinkedList<>();

	/** List containing the strategies found on both viewers */
	private List<StrategyElement> twinViewerSelection = new LinkedList<>();


	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 *            The containing Composite
	 * @param style
	 */
	public AdvancedTab(CTabFolder parent, int style) {
		CTabItem advancedTabItem = new CTabItem(parent, SWT.NONE);
		advancedTabItem.setText("Advanced Selection");

		GridLayout compositeLayout = new GridLayout(3, false);
		Composite advancedTabComposite = new Composite(parent, style);
		advancedTabComposite.setLayout(compositeLayout);
		advancedTabComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 3));
		advancedTabItem.setControl(advancedTabComposite);

		createStrategiesComposite(advancedTabComposite);
		createControlsComposite(advancedTabComposite);
		createSelectionComposite(advancedTabComposite);

		new BrowseButton(advancedTabComposite, leftViewerComposite.getViewer());
		new SaveButton(advancedTabComposite, getRightViewer());
	}


	/**
	 * Creates the rightViewer containing all the possible choices
	 *
	 * @param parent
	 *            this
	 */
	protected void createStrategiesComposite(Composite parent) {
		leftViewerComposite = new AdvancedTabLeftViewerComposite(parent, SWT.NONE);
		((GridData) leftViewerComposite.getLayoutData()).verticalSpan = 2;
		((GridData) leftViewerComposite.getLayoutData()).horizontalSpan = 1;
	}

	/**
	 * The selection buttons' composite
	 *
	 * @param parent
	 *            this
	 */
	protected void createControlsComposite(Composite parent) {
		controlComposite = new Composite(parent, SWT.NONE);
		controlComposite.setLayout(new GridLayout(1, true));
		GridData controlLayoutData = new GridData(SWT.CENTER, SWT.CENTER, false, true, 1, 3);
		controlComposite.setLayoutData(controlLayoutData);

		syncButton = new Button(controlComposite, SWT.TOGGLE);
		syncButton.setImage(Activator.getDefault().getImage(Messages.Sync_IconPath));
		syncButton.addSelectionListener(this);
		syncButton.setToolTipText(Messages.Sync_Label);

		addButton = new Button(controlComposite, SWT.PUSH);
		addButton.setImage(Activator.getDefault().getImage(Messages.Add_IconPath));
		addButton.addSelectionListener(this);
		addButton.setToolTipText(Messages.Add_Label);

		removeButton = new Button(controlComposite, SWT.PUSH);
		removeButton.setImage(Activator.getDefault().getImage(Messages.Remove_IconPath));
		removeButton.addSelectionListener(this);
		removeButton.setToolTipText(Messages.Remove_Label);

		addAllButton = new Button(controlComposite, SWT.PUSH);
		addAllButton.setImage(Activator.getDefault().getImage(Messages.AddAll_IconPath));
		addAllButton.addSelectionListener(this);
		addAllButton.setToolTipText(Messages.AddAll_Label);

		removeAllButton = new Button(controlComposite, SWT.PUSH);
		removeAllButton.setImage(Activator.getDefault().getImage(Messages.RemoveAll_IconPath));
		removeAllButton.addSelectionListener(this);
		removeAllButton.setToolTipText(Messages.RemoveAll_Label);
	}

	/**
	 * Creates the left viewer containing the selected options
	 *
	 * @param parent
	 *            this
	 */
	protected void createSelectionComposite(Composite parent) {
		rightViewerComposite = new AdvancedTabRightViewerComposite(parent, SWT.NONE);
		((GridData) rightViewerComposite.getLayoutData()).horizontalSpan = 1;
		((GridData) rightViewerComposite.getLayoutData()).verticalSpan = 2;
	}


	/**
	 * Get the left Viewer
	 * 
	 * @return
	 */
	public TreeViewer getLeftViewer() {
		return leftViewerComposite.getViewer();
	}

	/**
	 * Get the right Viewer
	 * 
	 * @return
	 */
	public TreeViewer getRightViewer() {
		return rightViewerComposite.getViewer();
	}

	/**
	 * Method forwarding the selected configurations to the right viewer
	 * 
	 * @param advancedTabStrategies
	 */
	public void addStrategies(Collection<StrategyElement> advancedTabStrategies) {
		rightViewerComposite.addStrategies(advancedTabStrategies);
	}

	/**
	 * Method removing all the right viewer strategies
	 */
	public void removeAllSelectionCompositeStrategies() {
		rightViewerComposite.removeAllStrategies();
	}

	/**
	 * Method forwarding the resources to populate the left viewer
	 * 
	 * @param resourceSet
	 */
	public void setRegisteredCompositeInput(ResourceSet resourceSet) {
		leftViewerComposite.getViewer().setInput(resourceSet);
	}

	/**
	 * Get the addresses of the resources containing the selected strategies
	 * 
	 * @return
	 */
	public Collection<String> getAdvancedParentModels() {
		return rightViewerComposite.getParentModels();
	}

	/**
	 * Get the strategies selected in the right viewer
	 * 
	 * @return
	 */
	public Collection<StrategyElement> getAdvancedStrategies() {
		return rightViewerComposite.getViewerStrategies();
	}

	/**
	 * Handles the buttons' behavior
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 *
	 * @param e
	 *            The selection event
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.widget == addButton) {
			addAction();
		} else if (e.widget == removeButton) {
			removeAction();
		} else if (e.widget == addAllButton) {
			addAllAction();
		} else if (e.widget == removeAllButton) {
			removeAllAction();
		} else if (e.widget == syncButton) {
			syncAction();
		}
	}

	/**
	 * Add the selected preference(s) to the Viewer
	 */
	private void addAction() {
		rightViewerComposite.addStrategies(leftViewerComposite.getStrategiesSelection());
	}

	/**
	 * Add all the possible preferences to the Viewer
	 */
	private void addAllAction() {
		rightViewerComposite.addStrategies(leftViewerComposite.getViewerInput());
	}

	/**
	 * Remove the selected preference(s) from the Viewer
	 */
	private void removeAction() {
		rightViewerComposite.removeSelectedStrategies();
	}

	/**
	 * Remove all the selected preferences from the Viewer
	 */
	private void removeAllAction() {
		rightViewerComposite.removeAllStrategies();
	}

	/**
	 * Method handling the synchronization between the left and right viewer
	 * 
	 * @param selectionViewer
	 * @param twinViewer
	 * @param twinStrategies
	 */
	private void doSync(TreeViewer selectionViewer, TreeViewer twinViewer, Collection<StrategyElement> twinStrategies) {
		viewerSelection.clear();
		viewerSelectionIDs.clear();
		twinViewerSelection.clear();
		viewerSelection.addAll(selectionViewer.getStructuredSelection().toList());

		if (viewerSelection.size() < 0) {
			return;
		}

		for (Object object : viewerSelection) {
			if (!(object instanceof StrategyElement)) {
				continue;
			}
			StrategyElement strategy = (StrategyElement) object;
			viewerSelectionIDs.add(strategy.getId());
		}

		for (StrategyElement strategy : twinStrategies) {
			if (viewerSelectionIDs.contains(strategy.getId())) {
				twinViewerSelection.add(strategy);
			}
		}

		twinViewer.setSelection(new StructuredSelection(twinViewerSelection), true);
	}

	/** Listener used to sync to the right to the left viewer */
	ISelectionChangedListener syncToRegisteredListener = new ISelectionChangedListener() {

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			doSync(rightViewerComposite.getViewer(), leftViewerComposite.getViewer(), leftViewerComposite.getViewerStrategies());
		}
	};

	/** Listener used to sync the left to the right viewer */
	ISelectionChangedListener syncToSelectedListener = new ISelectionChangedListener() {

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			doSync(leftViewerComposite.getViewer(), rightViewerComposite.getViewer(), rightViewerComposite.getViewerStrategies());
		}
	};

	/** @see org.eclipse.swt.events.FocusListener used to detect the synchronization and update the viewer accordingly */
	FocusListener selectedFocusListener = new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {
			Activator.log.trace(Activator.STRATEGY_PREFERENCES_TRACE, "selectedViewerFocus gained");
			if (syncButton.getSelection()) {
				rightViewerComposite.getViewer().addSelectionChangedListener(syncToRegisteredListener);
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			Activator.log.trace(Activator.STRATEGY_PREFERENCES_TRACE, "selectedViewerFocus lost");
			rightViewerComposite.treeViewer.removeSelectionChangedListener(syncToRegisteredListener);
		}
	};

	/** @see org.eclipse.swt.events.FocusListener used to detect the synchronization and update the viewer accordingly */
	FocusListener registeredFocusListener = new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {
			Activator.log.trace(Activator.STRATEGY_PREFERENCES_TRACE, "registeredViewerFocus gained");
			if (syncButton.getSelection()) {
				leftViewerComposite.getViewer().addSelectionChangedListener(syncToSelectedListener);
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			Activator.log.trace(Activator.STRATEGY_PREFERENCES_TRACE, "registeredViewerFocus lost");
			leftViewerComposite.getViewer().removeSelectionChangedListener(syncToSelectedListener);
		}
	};

	/**
	 * Method enabling the listeners used to detect the selected strategies on the viewers
	 */
	private void syncAction() {
		if (syncButton.getSelection()) {
			rightViewerComposite.getViewer().getTree().addFocusListener(selectedFocusListener);
			leftViewerComposite.getViewer().getTree().addFocusListener(registeredFocusListener);
		} else {
			rightViewerComposite.getViewer().getTree().removeFocusListener(selectedFocusListener);
			leftViewerComposite.getViewer().getTree().removeFocusListener(registeredFocusListener);
		}
	}


	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// nothing
	}
}
