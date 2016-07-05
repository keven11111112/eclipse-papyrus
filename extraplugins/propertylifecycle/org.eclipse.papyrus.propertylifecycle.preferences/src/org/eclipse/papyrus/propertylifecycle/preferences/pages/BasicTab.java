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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.BrowseButton;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Handle the creation of the basic tab of the preference page
 * 
 */
public class BasicTab implements SelectionListener {

	/** Viewer displaying the strategy models declared in the registry by extension or imported by the user */
	protected TableViewer tableViewer;

	/** The table contained in the viewer */
	protected Table table;

	/** The composite containing the buttons controlling the selection and browsing */
	protected Composite controlComposite;

	/** Select all the models */
	protected Button selectAllButton;

	/** Deselect all the models */
	protected Button deselectAllButton;

	/** Map of the selected models */
	protected Map<Resource, String> selectedModels;

	/** Color indicating a selected model or used in the advanced tab */
	protected Color colorBlack = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);

	/** Color indicating an unselected model */
	protected Color colorGrey = Display.getDefault().getSystemColor(SWT.COLOR_DARK_GRAY);

	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 *            The parent composite
	 * @param style
	 */
	public BasicTab(CTabFolder parent, int style) {
		CTabItem basicTabItem = new CTabItem(parent, SWT.NONE);
		basicTabItem.setText("Basic Selection");

		selectedModels = new HashMap<Resource, String>();
		Composite basicTabComposite = new Composite(parent, style);
		basicTabComposite.setLayout(new GridLayout(2, false));
		basicTabComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		basicTabItem.setControl(basicTabComposite);

		createTableViewer(basicTabComposite);
		createControlsComposite(basicTabComposite);
	}

	/**
	 * Create the viewer
	 * 
	 * @param parent
	 *            The parent composite
	 */
	private void createTableViewer(final Composite parent) {
		table = new Table(parent, SWT.MULTI | SWT.BORDER);
		tableViewer = new TableViewer(table);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tableViewer.setContentProvider(new ArrayContentProvider() {

			@Override
			/** Override used to get the list of the displayed resource in order to */
			public Object[] getElements(Object inputElement) {
				Collection<Resource> resources = new LinkedList<Resource>();
				if (inputElement instanceof ResourceSet) {
					for (Resource resource : ((ResourceSet) inputElement).getResources()) {
						resources.add(resource);
					}
					return resources.toArray();
				}
				return super.getElements(inputElement);
			}
		});

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableViewerColumn checkbox = createTableViewerColumn("", 22, tableViewer);
		checkbox.getColumn().setResizable(false);
		checkbox.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ""; //$NON-NLS-1$
			}

			@Override
			// Set the toggle boxes
			public Image getImage(Object element) {
				if (selectedModels.containsKey(element)) {
					return Activator.getDefault().getImage(Messages.Checked_IconPath);
				} else {
					return Activator.getDefault().getImage(Messages.Unchecked_IconPath);
				}
			}
		});
		// Set the toggle boxes behavior
		checkbox.setEditingSupport(new EditingSupport(tableViewer) {

			private CheckboxCellEditor checkboxCellEditor;

			@Override
			protected CellEditor getCellEditor(Object element) {
				// The new visual
				checkboxCellEditor = new CheckboxCellEditor(parent, SWT.CHECK | SWT.READ_ONLY);
				return checkboxCellEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				// Always true
				return true;
			}

			@Override
			protected Object getValue(Object element) {
				// Check if the model is currently selected
				return selectedModels.containsKey(element);
			}

			@Override
			protected void setValue(Object element, Object value) {
				Resource resource = element instanceof Resource ? ((Resource) element) : null;
				// This line's object object is not correctly formated
				if (resource == null) {
					return;
				}

				// Update the list of selected models
				if (checkboxCellEditor.getValue() == Boolean.TRUE) {
					selectedModels.put(resource, resource.getURI().lastSegment());
				} else {
					selectedModels.remove(resource);
				}

				// Update the visual of the table
				tableViewer.update(element, null);
			}
		});


		TableViewerColumn modelColumn = createTableViewerColumn("model", 300, tableViewer);
		modelColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// Get the name of the file handled
				return element instanceof Resource ? ((Resource) element).getURI().lastSegment().toString() : super.getText(element);
			}
		});

		TableViewerColumn descriptionColumn = createTableViewerColumn("description", 300, tableViewer);
		descriptionColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// Get the description, if any, of the model
				Resource resource = element instanceof Resource ? ((Resource) element) : null;
				Object setResource = resource.getContents().get(0);
				return setResource instanceof StrategySet ? ((StrategySet) setResource).getDecription() : "N/A";
			}
		});
	}

	/**
	 * Color scheme of the lines
	 * 
	 * @param lastSegs
	 *            The file names
	 */
	protected void setItemColor(Set<String> lastSegs) {
		for (TableItem item : table.getItems()) {
			String lastSeg = item.getData() instanceof Resource ? ((Resource) item.getData()).getURI().lastSegment() : "NA";
			if (lastSegs.contains(lastSeg)) {
				item.setForeground(1, colorBlack);
				item.setForeground(2, colorBlack);
				// item.setForeground(null);
			} else {
				item.setForeground(1, colorGrey);
				item.setForeground(2, colorGrey);
			}
		}
	}

	/**
	 * Generic creator of the columns
	 * 
	 * @param header
	 *            The name of the column
	 * @param width
	 *            The width of the column
	 * @param parentViewer
	 *            The associated viewer
	 * @return
	 * 		The new {@link #org.eclipse.jface.viewers.TableViewerColumn column}
	 */
	protected TableViewerColumn createTableViewerColumn(String header, int width, TableViewer parentViewer) {
		TableViewerColumn newColumn = new TableViewerColumn(parentViewer, SWT.BORDER);
		TableColumn column = newColumn.getColumn();
		column.setWidth(width);
		column.setText(header);
		column.setResizable(true);
		column.setMoveable(false);

		return newColumn;
	}

	/**
	 * Create the control composite containing the selection and browsing buttons
	 * 
	 * @param parent
	 *            The parent composite
	 */
	protected void createControlsComposite(Composite parent) {
		controlComposite = new Composite(parent, SWT.NONE);
		controlComposite.setLayout(new GridLayout(1, true));
		GridData controlLayoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		controlComposite.setLayoutData(controlLayoutData);

		selectAllButton = new Button(controlComposite, SWT.PUSH);
		selectAllButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		selectAllButton.addSelectionListener(this);
		selectAllButton.setToolTipText(Messages.SelectAllButton_Label);
		selectAllButton.setText(Messages.SelectAllButton_Label);

		deselectAllButton = new Button(controlComposite, SWT.PUSH);
		deselectAllButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		deselectAllButton.addSelectionListener(this);
		deselectAllButton.setToolTipText(Messages.DeselectAllButton_Label);
		deselectAllButton.setText(Messages.DeselectAllButton_Label);

		new BrowseButton(controlComposite, getViewer());
	}

	/**
	 * Link the selection events with the correct methods
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 *
	 * @param e
	 *            The selection event
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.widget == selectAllButton) {
			selectAllAction();
		} else if (e.widget == deselectAllButton) {
			deselectAllAction();
		}
	}

	/**
	 * Select all the items present in the viewer
	 */
	public void selectAllAction() {
		for (TableItem item : table.getItems()) {
			Resource resource = (Resource) item.getData();
			selectedModels.put(resource, resource.getURI().lastSegment());
			getViewer().update(resource, null);
		}
	}

	/**
	 * Deselect all the models present in the viewer
	 */
	public void deselectAllAction() {
		for (TableItem item : table.getItems()) {
			Resource resource = (Resource) item.getData();
			selectedModels.remove(resource);
			getViewer().update(resource, null);
		}
	}

	/**
	 * Method used to initialize the selection in the viewer based on the current preferences
	 * 
	 * @param filePaths
	 *            The currently active strategy models' {@link #org.eclipse.emf.common.util.URI URI}
	 */
	public void initSelection(Collection<String> filePaths) {
		for (String filePath : filePaths) {
			String preferenceKey = (URI.createPlatformPluginURI(filePath, true)).lastSegment();
			for (TableItem item : table.getItems()) {
				Resource resource = (Resource) item.getData();
				String resourceKey = resource.getURI().lastSegment();

				if (preferenceKey.equals(resourceKey)) {
					selectedModels.put(resource, resourceKey);
					getViewer().update(resource, null);
				}
			}
		}
	}

	/**
	 * Clear any selected models that are not declared in the registry and reset the selection to the default state
	 * 
	 * @param registryResourceSet
	 *            The {@link #org.eclipse.emf.ecore.resource.ResourceSet resourceSet} containing the models
	 */
	public void removeNonRegistryModels(ResourceSet registryResourceSet) {
		table.clearAll();
		selectedModels.clear();
		tableViewer.setInput(registryResourceSet);
		selectAllAction();
	}

	/**
	 * Convenience method used to initialize the viewer from the parent Composite
	 */
	public void defaultSelection() {
		selectAllAction();
	}

	/**
	 * @return
	 * 		The selected models
	 */
	public Collection<String> getSelectedModels() {
		Collection<String> selectedModelsURI = new LinkedList<String>();
		for (Resource resource : selectedModels.keySet()) {
			selectedModelsURI.add(resource.getURI().toString());
		}

		return selectedModelsURI;
	}

	/**
	 * @return
	 * 		The selected models' strategies
	 */
	public HashSet<StrategyElement> getSelectedStrategies() {
		HashSet<StrategyElement> selectedStrategies = new HashSet<StrategyElement>();
		for (Resource resource : selectedModels.keySet()) {
			if (resource.getContents().get(0) instanceof StrategySet) {
				selectedStrategies.addAll(((StrategySet) resource.getContents().get(0)).getStrategies());
			}
		}

		return selectedStrategies;
	}

	/**
	 * Convenience method
	 * 
	 * @return
	 * 		This composite's Viewer
	 */
	public StructuredViewer getViewer() {
		return tableViewer;
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// nothing
	}

}
