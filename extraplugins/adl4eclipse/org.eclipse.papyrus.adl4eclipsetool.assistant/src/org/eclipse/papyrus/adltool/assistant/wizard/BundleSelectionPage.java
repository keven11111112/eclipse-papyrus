/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *  Thomas Daniellou (CEA LIST) - Refactoring
 *****************************************************************************/
package org.eclipse.papyrus.adltool.assistant.wizard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.adltool.ADLConstants;
import org.eclipse.papyrus.adltool.designer.ReverseSettings;
import org.eclipse.papyrus.adltool.reversible.Reversible;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Package;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Spinner;

/**
 * A wizard page that will help selecting a set of bundles from a list
 */
public class BundleSelectionPage extends WizardPage {

	/**
	 * The composite that holds the wizard's widget.
	 */
	private Composite composite;

	/**
	 * The list of bundles that can be selected for the reverse.
	 */
	private Set<ReversibleProject> bundleList;

	/**
	 * The list of selected bundles to be reversed.
	 */
	private Set<ReversibleProject> selectedBundleList;

	/**
	 * The tree viewer with check-boxes on each node.
	 */
	private CheckboxTreeViewer viewer;

	/**
	 * The combo viewer of available Papyrus models.
	 */
	private ComboViewer comboViewer;

	/**
	 * The group holding the tree widgets.
	 */
	private Group groupTree;

	/**
	 * The tree that will help the user selecting the project(s) to reverse.
	 */
	private BundleSelectionTree elementTree;

	/**
	 * The text area that will hold the selected project's description.
	 */
	private Text descriptionContent;

	/**
	 * The indicator of the number of selected project to reverse.
	 */
	protected Label selectionIndicator;

	/**
	 * The model to show in the combo viewer. The wizard will not be able to
	 * finish if this field is null.
	 */
	private Package selectedModel;

	/**
	 * Whether the page is in "Advanced mode" or not.
	 */
	private boolean advanced;

	/**
	 * Depth selector. (Advanced mode)
	 */
	private Spinner depthSpinner;

	/**
	 * Whether the depth is infinite or not.
	 */
	private boolean infiniteDepth;

	private ReverseSettings settings;

	/**
	 * Constructor.
	 *
	 * @param bundleList
	 *            The list of bundles to display in the selection tree
	 * @param modelList
	 */
	public BundleSelectionPage(Set<ReversibleProject> bundleList, boolean advanced) {
		super("Bundle Selection");
		setTitle("Bundle Selection");
		setDescription("Select bundles to create the architecture model.");

		this.bundleList = bundleList;
		this.advanced = advanced;

		selectedBundleList = new HashSet<>();
		settings = new ReverseSettings();
	}

	/**
	 *
	 * @return
	 */
	public Package getSelectedModel() {
		return selectedModel;
	}

	/**
	 * Sets the model to display in the combo box.
	 *
	 * @param selectedModel
	 */
	public void setSelectedModel(Package selectedModel) {
		this.selectedModel = selectedModel;
	}

	/**
	 * Returns the elements to import.
	 *
	 * @return the list of selected bundle
	 */
	public Set<ReversibleProject> getResult() {
		return selectedBundleList;
	}

	@Override
	public void createControl(Composite parent) {
		// Create the composite to hold the widgets
		composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(1, false));

		// Create the widgets
		createGroupModel();
		createTree();
		createDescription();
		createButtons();
		createAdvancedProperties();

		selectionIndicator = new Label(groupTree, NONE);
		updateSelectionIndicator();

		setControl(composite);

		setPageComplete(false);
	}

	private void createAdvancedProperties() {
		Group grpSettings = new Group(composite, SWT.NONE);
		grpSettings.setLayout(new GridLayout(5, false));
		GridData groupSettingsGridData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		groupSettingsGridData.exclude = !advanced;
		grpSettings.setLayoutData(groupSettingsGridData);
		grpSettings.setText("Reverse settings");

		final Button btnChildren = new Button(grpSettings, SWT.CHECK);
		btnChildren.setText("Dependencies");
		btnChildren.setSelection(settings.reverseDependencies());

		final Button btnCheckExportPackages = new Button(grpSettings, SWT.CHECK);
		btnCheckExportPackages.setText("Exported packages");
		btnCheckExportPackages.setSelection(settings.reverseExportPackages());

		final Button btnCheckImportPackages = new Button(grpSettings, SWT.CHECK);
		btnCheckImportPackages.setText("Imported packages");
		btnCheckImportPackages.setSelection(settings.reverseImportPackages());

		final Button btnCheckExtensionPoints = new Button(grpSettings, SWT.CHECK);
		btnCheckExtensionPoints.setText("Extension points");
		btnCheckExtensionPoints.setSelection(settings.reverseExtensionPoints());

		final Button btnCheckExtensions = new Button(grpSettings, SWT.CHECK);
		btnCheckExtensions.setText("Extensions");
		btnCheckExtensions.setSelection(settings.reverseExtensions());

		Group grpAdvanced = new Group(composite, SWT.NONE);
		grpAdvanced.setLayout(new GridLayout(3, false));
		GridData groupAdvancedGridData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		groupAdvancedGridData.exclude = !advanced;
		grpAdvanced.setLayoutData(groupAdvancedGridData);
		grpAdvanced.setText("Advanced settings");

		Label depthLabel = new Label(grpAdvanced, SWT.NONE);
		depthLabel.setText("Reverse depth:");

		depthSpinner = new Spinner(grpAdvanced, SWT.BORDER);
		depthSpinner.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		depthSpinner.setPageIncrement(1);
		depthSpinner.setMinimum(1);
		depthSpinner.setSelection(1);

		final Button btnInfinite = new Button(grpAdvanced, SWT.CHECK);
		btnInfinite.setText("Infinite");

		btnChildren.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean reverseChildren = ((Button) event.getSource()).getSelection();

				settings.setReverseChildren(reverseChildren);
			}

		});

		btnCheckExportPackages.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean reverseExportPackages = ((Button) event.getSource()).getSelection();

				settings.setReverseExportPackages(reverseExportPackages);
			}

		});

		btnCheckImportPackages.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean reverseImportPackages = ((Button) event.getSource()).getSelection();

				settings.setReverseImportPackages(reverseImportPackages);
			}

		});

		btnCheckExtensionPoints.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean reverseExtensionPoints = ((Button) event.getSource()).getSelection();

				settings.setReverseExtensionPoints(reverseExtensionPoints);
				settings.setReverseExtensions(reverseExtensionPoints);

				btnCheckExtensions.setSelection(reverseExtensionPoints);
				btnCheckExtensions.setEnabled(reverseExtensionPoints);
			}

		});

		btnCheckExtensions.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean reverseExtensions = ((Button) event.getSource()).getSelection();

				settings.setReverseExtensions(reverseExtensions);
			}

		});

		btnInfinite.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				infiniteDepth = ((Button) event.getSource()).getSelection();
				depthSpinner.setEnabled(!infiniteDepth);
			}

		});
	}

	private void createGroupModel() {
		Composite groupModel = new Composite(composite, NONE);
		groupModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		groupModel.setLayout(new GridLayout(2, false));

		Label labelModel = new Label(groupModel, SWT.NONE);
		labelModel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 1, 1));
		labelModel.setText("Model:");

		comboViewer = new ComboViewer(groupModel, SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
		combo.setEnabled(false);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Package) {
					return ((Package) element).getLabel();
				}
				return super.getText(element);
			}
		});

		if (selectedModel != null) {
			// Add the selected model in the combo box and preselect it
			Package[] input = new Package[] { selectedModel };

			comboViewer.setInput(input);
			comboViewer.setSelection(new StructuredSelection(comboViewer.getElementAt(0)), true);
		}
	}

	private void createTree() {
		groupTree = new Group(composite, NONE);
		groupTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		groupTree.setText("Available projects");
		groupTree.setLayout(new GridLayout(1, false));

		elementTree = new BundleSelectionTree(groupTree);

		GridData gridElementTree = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gridElementTree.heightHint = 150;

		elementTree.setLayoutData(gridElementTree);

		viewer = elementTree.getViewer();
		viewer.setContentProvider(new BundleContentProvider());
		viewer.setLabelProvider(new BundleLabelProvider());
		viewer.setInput(getTreeItems());

		viewer.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getElement() instanceof ReversibleProject) {
					if (event.getChecked()) {
						selectedBundleList.add((ReversibleProject) event.getElement());
					} else {
						selectedBundleList.remove(event.getElement());
					}

					if (selectedBundleList.size() > 0) {
						setPageComplete(true);
					} else {
						setPageComplete(false);
					}

					updateSelectionIndicator();
				}
			}
		});

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					Iterator<?> iterator = selection.iterator();

					while (iterator.hasNext()) {
						Object domain = iterator.next();
						if (domain instanceof Reversible) {
							String text = ((ReversibleProject) domain).getDescription();
							descriptionContent.setText(( text !=null ) ? text : "");
						}
					}
				}
			}
		});
	}

	private void createDescription() {
		Composite descriptionContainer = new Composite(groupTree, SWT.NULL);
		descriptionContainer.setLayout(new GridLayout(1, false));

		GridData gridDescriptionContainer = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gridDescriptionContainer.heightHint = 120;

		descriptionContainer.setLayoutData(gridDescriptionContainer);

		Label descriptionLabel = new Label(descriptionContainer, SWT.NONE);
		descriptionLabel.setText("Description:");

		descriptionContent = new Text(descriptionContainer, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		descriptionContent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	}

	private void createButtons() {
		Composite buttonsContainer = new Composite(groupTree, SWT.NULL);
		buttonsContainer.setLayout(new RowLayout());

		Button selectAll = new Button(buttonsContainer, SWT.PUSH);
		selectAll.setText("Select All");
		selectAll.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// Select all items in the filtered tree
				TreeItem[] treeItems = viewer.getTree().getItems();

				for (TreeItem treeItem : treeItems) {
					ReversibleProject bundle = (ReversibleProject) treeItem.getData();
					viewer.setChecked(bundle, true);
					selectedBundleList.add(bundle);
				}

				setPageComplete(true);
				updateSelectionIndicator();
			}
		});

		Button deselectAll = new Button(buttonsContainer, SWT.PUSH);
		deselectAll.setText("Deselect All");
		deselectAll.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem[] treeItems = viewer.getTree().getItems();

				for (TreeItem treeItem : treeItems) {
					viewer.setChecked(treeItem.getData(), false);
				}

				selectedBundleList.clear();

				setPageComplete(false);
				updateSelectionIndicator();
			}
		});
	}

	private Object getTreeItems() {
		List<ReversibleProject> treeItems = new ArrayList<>();

		for (ReversibleProject bundle : bundleList) {
			treeItems.add(bundle);
		}

		// Sort the tree items by Id
		Collections.sort(treeItems, new Comparator<ReversibleProject>() {
			@Override
			public int compare(ReversibleProject reversible1, ReversibleProject reversible2) {
				return reversible1.getId().compareTo(reversible2.getId());
			}
		});

		return treeItems;
	}

	private void updateSelectionIndicator() {
		selectionIndicator.setText(selectedBundleList.size() + " of " + bundleList.size() + " projects selected");
	}

	public ReverseSettings getReverseSettings() {
		int reverseDepth = infiniteDepth ? ADLConstants.INFINITE_DEPTH_OPTION : depthSpinner.getSelection();

		settings.setReverseDepth(reverseDepth);

		return settings;
	}

	@Override
	public boolean isPageComplete() {
		return super.isPageComplete() && getSelectedModel() != null;
	}
}
