/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thibault Le Ouay (Sherpa Engineering) t.leouay@sherpa-eng.com  - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.kind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.uml.diagram.wizards.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;


public class DiagramKindComposite extends Composite {

	private static final Image CHECKED = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("org.eclipse.papyrus.uml.diagram.wizards", "icons/checked.gif"); //$NON-NLS-1$ //$NON-NLS-2$

	private static final Image UNCHECKED = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("org.eclipse.papyrus.uml.diagram.wizards", "icons/unchecked.gif"); //$NON-NLS-1$ //$NON-NLS-2$

	private Map<ViewPrototype, String> diagramNames = new HashMap<ViewPrototype, String>();

	List<String> listNames = new ArrayList<String>();


	private Map<ViewPrototype, Integer> selectedDiagrams = new HashMap<ViewPrototype, Integer>();

	public TableViewer viewer;




	public DiagramKindComposite(Composite parent) {
		super(parent, SWT.NONE);
		this.setLayout(new GridLayout());
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createTableViewer(this);
	}

	public void createTableViewer(final Composite container) {

		viewer = new TableViewer(container, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.minimumHeight = viewer.getTable().getItemHeight() * 3;
		gridData.heightHint = viewer.getTable().getItemHeight() * 3;
		viewer.getTable().setLayoutData(gridData);

		// viewer.setContentProvider(new ArrayContentProvider());
		final Table table = viewer.getTable();
		viewer.setContentProvider(new DiagramKindContentProvider());
		table.setHeaderVisible(true);

		// The check column
		TableViewerColumn colCheckbox = createTableViewerColumn("", 20, viewer); //$NON-NLS-1$
		colCheckbox.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				return ""; //$NON-NLS-1$
			}

			@Override
			public Image getImage(Object element) {
				if (selectedDiagrams.containsKey(element)) {
					return CHECKED;
				} else {
					return UNCHECKED;
				}
			}

		});
		colCheckbox.setEditingSupport(new EditingSupport(viewer) {

			private CheckboxCellEditor checkboxCellEditor;

			@Override
			protected void setValue(Object element, Object value) {
				if (checkboxCellEditor.getValue() == Boolean.TRUE) {
					selectedDiagrams.put((ViewPrototype) element, 1);
				} else {
					selectedDiagrams.remove(element);
				}
				viewer.update(element, null);
			}

			@Override
			protected Object getValue(Object element) {
				return selectedDiagrams.containsKey(element);
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				checkboxCellEditor = new CheckboxCellEditor(container, SWT.CHECK | SWT.READ_ONLY);
				return checkboxCellEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		// no need to enable the resize on the check box column
		colCheckbox.getColumn().setResizable(false);


		// The Diagram name column
		TableViewerColumn colDiagramKind = createTableViewerColumn(Messages.DiagramKindComposite_0, 200, viewer);
		colDiagramKind.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof ViewPrototype) {
					return ((ViewPrototype) element).getLabel();
				}
				return ""; //$NON-NLS-1$
			}

			@Override
			public Image getImage(Object element) {
				if (element instanceof ViewPrototype) {
					return ((ViewPrototype) element).getIcon();
				}
				return null;
			}


		});


		// the name of the diagram the user can edit it to set his onw name
		TableViewerColumn colDiagramName = createTableViewerColumn(Messages.DiagramKindComposite_2, 300, viewer);
		colDiagramName.setEditingSupport(new EditingSupport(viewer) {

			@Override
			protected void setValue(Object element, Object value) {

				diagramNames.put((ViewPrototype) element, (String) value);
				viewer.update(element, null);

			}

			@Override
			protected Object getValue(Object element) {

				if (diagramNames.containsKey(element)) {
					return diagramNames.get(element);
				}
				return ""; //$NON-NLS-1$

			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new TextCellEditor(viewer.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		colDiagramName.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				return diagramNames.get(element);
			}
		});


		// the quantity of the diagram the user would like to create
		TableViewerColumn colDiagramQuantity = createTableViewerColumn(Messages.DiagramKindComposite_3, 70, viewer);
		colDiagramQuantity.setEditingSupport(new EditingSupport(viewer) {

			@Override
			protected void setValue(Object element, Object value) {
				selectedDiagrams.put((ViewPrototype) element, Integer.parseInt((String) value));
				viewer.update(element, null);
			}

			@Override
			protected Object getValue(Object element) {
				if (selectedDiagrams.containsKey(element)) {
					return selectedDiagrams.get(element).toString();
				}
				return "0"; //$NON-NLS-1$
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				TextCellEditor textCellEditor = new TextCellEditor(viewer.getTable());
				textCellEditor.setValidator(new ICellEditorValidator() {

					@Override
					public String isValid(Object value) {
						if (!(value instanceof Integer)) {
							return null;
						}
						return value.toString();
					}
				});
				return textCellEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		colDiagramQuantity.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (selectedDiagrams.containsKey(element)) {
					return selectedDiagrams.get(element).toString();
				}
				// return "0"; //$NON-NLS-1$
				return ""; //$NON-NLS-1$
			}
		});


		// TODO - The description of the diagram not yet implemented, should be implemented will generating the diagram
		// TableViewerColumn colDiagramDescription = createTableViewerColumn("Description", 400, viewer);
		// colDiagramDescription.setLabelProvider(new ColumnLabelProvider() {
		//
		// @Override
		// public String getText(Object element) {
		// return null;
		// }
		//
		// });
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// if(selectedConfigs.size() > 0) {
				// setPageComplete(true);
				// } else {
				// setPageComplete(false);
				// }
			}
		});

	}

	/**
	 * Constructor.
	 *
	 * @param title
	 * @param bound
	 * @param viewer
	 * @return
	 */
	private TableViewerColumn createTableViewerColumn(String title, int bound, TableViewer viewer) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(false);
		return viewerColumn;
	}


	/**
	 * Creates the diagram kind label provider.
	 *
	 * @return the i base label provider
	 */
	protected IBaseLabelProvider createDiagramKindLabelProvider() {
		return new DiagramKindLabelProvider();
	}


	public void setInput(Object input) {
		viewer.setInput(input);
	}

	public ArrayList<ViewPrototype> getCheckElement() {
		ArrayList<ViewPrototype> list = new ArrayList<ViewPrototype>();
		Set<Entry<ViewPrototype, Integer>> set = selectedDiagrams.entrySet();
		Iterator<Entry<ViewPrototype, Integer>> ite = set.iterator();
		while (ite.hasNext()) {
			Entry<ViewPrototype, Integer> me = ite.next();
			int nb = me.getValue();
			String tempname = diagramNames.get(me.getKey());
			// If the name field was not filled
			if (tempname == null || tempname.equalsIgnoreCase("")) {
				tempname = me.getKey().getLabel();
			}

			for (int i = 0; i < nb; i++) {
				list.add(me.getKey());
				if (nb > 1) {
					listNames.add(tempname + "_" + i); //$NON-NLS-1$
				} else {
					listNames.add(tempname);
				}
			}
		}
		return list;
	}


	/**
	 * @return
	 */
	public List<String> getDiagramName() {
		return listNames;
	}

}
