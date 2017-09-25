/*****************************************************************************
 * Copyright (c) 2012, 2017 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 476618
 *  Vincent Lorenzo (CEA LIST) - bug 525221
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.nebula.widgets.nattable.coordinate.PositionCoordinate;
import org.eclipse.nebula.widgets.nattable.coordinate.Range;
import org.eclipse.nebula.widgets.nattable.layer.ILayerListener;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.event.CellSelectionEvent;
import org.eclipse.nebula.widgets.nattable.selection.event.ColumnSelectionEvent;
import org.eclipse.nebula.widgets.nattable.selection.event.ISelectionEvent;
import org.eclipse.nebula.widgets.nattable.selection.event.RowSelectionEvent;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableSelectionWrapper;
import org.eclipse.papyrus.infra.nattable.utils.TypeSelectionEnum;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.ui.services.IDisposable;

/**
 * The selection provider used by the table. The returned selection is used to display property views or to do the synchronization in the
 * ModelExplorer
 */
public class TableSelectionProvider implements ISelectionProvider, IDisposable, ILayerListener {

	/**
	 * the selection layer used in the table
	 */
	private SelectionLayer selectionLayer;

	/**
	 * the selection listener
	 */
	private final ILayerListener selectionListener;

	/**
	 * the current selection in the table
	 */
	private ISelection currentSelection;

	/**
	 * the list of listener on the selections
	 */
	private final List<ISelectionChangedListener> listeners;

	/**
	 * the table model manager to use to find selected elements
	 */
	private INattableModelManager manager;

	/**
	 * boolean indicating than the class is disposed
	 */
	private boolean isDisposed = false;

	/**
	 * Constructor.
	 *
	 * @param manager
	 *            the table model manager to use to find selected elements
	 * @param selectionLayer
	 *            the selection layer
	 */
	public TableSelectionProvider(final INattableModelManager manager, final SelectionLayer selectionLayer) {
		this.selectionLayer = selectionLayer;
		this.selectionListener = this;
		this.selectionLayer.addLayerListener(this.selectionListener);
		this.currentSelection = new StructuredSelection();
		this.listeners = new ArrayList<ISelectionChangedListener>();
		this.manager = manager;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	@Override
	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		this.listeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	@Override
	public synchronized ISelection getSelection() {
		return this.currentSelection;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	@Override
	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public synchronized void setSelection(final ISelection selection) {
		if (this.currentSelection.equals(selection)) {
			return;
		}
		this.currentSelection = selection;
		final SelectionChangedEvent event = new SelectionChangedEvent(this, this.currentSelection);
		for (final ISelectionChangedListener current : this.listeners) {
			current.selectionChanged(event);
		}
	}

	/**
	 * This allows to calculate the new selection from the event and the layer.
	 * 
	 * @param event
	 *            The event caught.
	 */
	protected void calculateAndStoreNewSelection(final ILayerEvent event) {
		// the list of the selected elements
		Collection<Object> selection = new HashSet<Object>();
		final ISelection newSelection;
		if (event instanceof ISelectionEvent) {
			TableSelectionWrapper wrapper = new TableSelectionWrapper(this.manager, ListHelper.asList(this.selectionLayer.getSelectedCellPositions()), new HashMap<Integer, Object>(0), new HashMap<Integer, Object>(0));

			// Get the type selection event if it is a specific selection event
			TypeSelectionEnum typeSelectionEvent = TypeSelectionEnum.NONE;
			boolean isWithShiftMask = false;
			boolean isWithControlMask = false;

			// Check if it is a simple cell selection event
			if (event instanceof CellSelectionEvent) {
				typeSelectionEvent = TypeSelectionEnum.CELL;
				isWithShiftMask = ((CellSelectionEvent) event).isWithShiftMask();
				isWithControlMask = ((CellSelectionEvent) event).isWithControlMask();
				// Check if it is a column selection event
			} else if (event instanceof ColumnSelectionEvent) {
				typeSelectionEvent = TypeSelectionEnum.COLUMN;
				isWithShiftMask = ((ColumnSelectionEvent) event).isWithShiftMask();
				isWithControlMask = ((ColumnSelectionEvent) event).isWithControlMask();
				// Check if it is a row selection event
			} else if (event instanceof RowSelectionEvent) {
				typeSelectionEvent = TypeSelectionEnum.ROW;
				isWithShiftMask = ((RowSelectionEvent) event).isWithShiftMask();
				isWithControlMask = ((RowSelectionEvent) event).isWithControlMask();
			}

			// If this is a specific selection event, manage the selection with event
			if (!TypeSelectionEnum.NONE.equals(typeSelectionEvent)) {
				// The shift mask will be managed by adding all the selection between the previous selection and the current
				if (isWithShiftMask) {
					// Calculate the selection with the shift mask
					selection = calculateSelectionWithShiftMask(wrapper, typeSelectionEvent);
					// The control mask will be managed by adding the current selection to the previous one
				} else if (isWithControlMask) {
					// Calculate the selection with the control mask
					selection = calculateSelectionWithControlMask(wrapper, typeSelectionEvent, event);
				} else {
					// Manage the rows and the columns selection event
					selection = calculateSelectionRowsAndColumnsWithTypeSelectionEvent(wrapper, typeSelectionEvent, event);
				}

			} else {
				selection = calculateSelectionRowsAndColumnsWithoutTypeSelectionEvent(wrapper, event);
			}
			// If no selection appended, the selection must be the context of the table 
			if(selection.isEmpty()){
				newSelection = new TableStructuredSelection(manager.getTable().getContext(), wrapper);
			}else{
				newSelection = new TableStructuredSelection(selection.toArray(), wrapper);
			}
		} else {
			newSelection = new StructuredSelection(manager.getTable().getContext());
		}
		setSelection(newSelection);
	}

	/**
	 * This allows to calculate the selection when the shift key is pressed with the selection.
	 * 
	 * @param wrapper
	 *            The table selection wrapper to fill.è
	 * @param typeSelectionEvent
	 *            The type of selection from the event (cell, row or column selection).
	 * @return The collection of object selected.
	 */
	protected Collection<Object> calculateSelectionWithShiftMask(final TableSelectionWrapper wrapper, final TypeSelectionEnum typeSelectionEvent) {
		// If a cell is selected with shift mask, only keep the line and column selected (the cells added with be added automatically
		if (TypeSelectionEnum.CELL.equals(typeSelectionEvent)) {
			if (this.currentSelection instanceof TableStructuredSelection) {
				// Add the previous selected rows and columns to the current wrapper
				final TableSelectionWrapper existingWrapper = (TableSelectionWrapper) ((TableStructuredSelection) currentSelection).getAdapter(TableSelectionWrapper.class);
				wrapper.getFullySelectedRows().putAll(existingWrapper.getFullySelectedRows());
				wrapper.getFullySelectedColumns().putAll(existingWrapper.getFullySelectedColumns());
			}
			// If a row is selected with shift mask, the selected rows by the layer must be the wrapper selected rows
		} else if (TypeSelectionEnum.ROW.equals(typeSelectionEvent)) {
			for (final int i : this.selectionLayer.getFullySelectedRowPositions()) {
				final int rowIndex = this.selectionLayer.getRowIndexByPosition(i);
				Object el = this.manager.getRowElement(rowIndex);
				if (el != null) {
					if (!wrapper.getFullySelectedRows().containsKey(rowIndex)) {
						// Check if the column to select is corresponding to at least one cell
						if (isSelectedCellsContainsRow(wrapper.getSelectedCells(), this.manager.getBodyLayerStack().getRowHideShowLayer().getRowPositionByIndex(rowIndex))) {
							wrapper.getFullySelectedRows().put(Integer.valueOf(rowIndex), el);
						}
					}
				}
			}
			// If a row is selected with shift mask, the selected rows by the layer must be the wrapper selected rows
		} else if (TypeSelectionEnum.COLUMN.equals(typeSelectionEvent)) {
			// TODO : Some bugs exists in nattable column selection
			// When the bugs are resolved, we needed to be like rows shift selection

			if (this.currentSelection instanceof TableStructuredSelection) {
				// Add the previous selected rows and columns to the current wrapper
				final TableSelectionWrapper existingWrapper = (TableSelectionWrapper) ((TableStructuredSelection) currentSelection).getAdapter(TableSelectionWrapper.class);
				wrapper.getFullySelectedRows().putAll(existingWrapper.getFullySelectedRows());
				wrapper.getFullySelectedColumns().putAll(existingWrapper.getFullySelectedColumns());
			}

			for (final int i : this.selectionLayer.getFullySelectedColumnPositions()) {
				final int columnIndex = this.selectionLayer.getColumnIndexByPosition(i);
				Object el = this.manager.getColumnElement(columnIndex);
				if (el != null) {
					if (!wrapper.getFullySelectedColumns().containsKey(columnIndex)) {
						// Check if the column to select is corresponding to at least one cell
						if (isSelectedCellsContainsColumn(wrapper.getSelectedCells(), this.manager.getBodyLayerStack().getColumnHideShowLayer().getColumnPositionByIndex(columnIndex))) {
							wrapper.getFullySelectedColumns().put(Integer.valueOf(columnIndex), el);
						}
					}
				}
			}
		}

		return calculateSelectionFromWrapper(wrapper);
	}

	/**
	 * This allows to calculate the selection when the control key is pressed with the selection.
	 * 
	 * @param wrapper
	 *            The table selection wrapper to fill.
	 * @param typeSelectionEvent
	 *            The type of selection from the event (cell, row or column selection).
	 * @param event
	 *            The event caught.
	 * @return The collection of object selected.
	 */
	protected Collection<Object> calculateSelectionWithControlMask(final TableSelectionWrapper wrapper, final TypeSelectionEnum typeSelectionEvent, final ILayerEvent event) {
		if (this.currentSelection instanceof TableStructuredSelection) {
			// Add the previous selected rows and columns to the current wrapper
			final TableSelectionWrapper existingWrapper = (TableSelectionWrapper) ((TableStructuredSelection) currentSelection).getAdapter(TableSelectionWrapper.class);
			wrapper.getFullySelectedRows().putAll(existingWrapper.getFullySelectedRows());
			wrapper.getFullySelectedColumns().putAll(existingWrapper.getFullySelectedColumns());
		}

		// If a cell is selected by the control and was already selected, remove it and remove the selected row and column
		if (TypeSelectionEnum.CELL.equals(typeSelectionEvent)) {
			final int columnPosition = ((CellSelectionEvent) event).getColumnPosition();
			final int rowPosition = ((CellSelectionEvent) event).getRowPosition();
			final PositionCoordinate tmpCoordinate = new PositionCoordinate(selectionLayer, columnPosition, rowPosition);

			// Check if the cell was unselected
			if (!wrapper.getSelectedCells().contains(tmpCoordinate)) {
				if (wrapper.getFullySelectedRows().containsKey(rowPosition)) {
					wrapper.getFullySelectedRows().remove(rowPosition);
				}
				if (wrapper.getFullySelectedColumns().containsKey(columnPosition)) {
					wrapper.getFullySelectedColumns().remove(columnPosition);
				}
			}
		} else {
			calculateSelectionRowsAndColumnsWithTypeSelectionEvent(wrapper, typeSelectionEvent, event);
		}

		return calculateSelectionFromWrapper(wrapper);
	}

	/**
	 * This allows to calculate the selection for rows and columns (cells already added to the wrapper).
	 * 
	 * @param wrapper
	 *            The table selection wrapper to fill.
	 * @param typeSelectionEvent
	 *            The type of selection from the event (cell, row or column selection).
	 * @param event
	 *            The event caught.
	 * @return The collection of object selected.
	 */
	protected Collection<Object> calculateSelectionRowsAndColumnsWithTypeSelectionEvent(final TableSelectionWrapper wrapper, final TypeSelectionEnum typeSelectionEvent, final ILayerEvent event) {
		// Manage the column selection event
		if (TypeSelectionEnum.COLUMN.equals(typeSelectionEvent)) {
			for (Range range : ((ColumnSelectionEvent) event).getColumnPositionRanges()) {
				for (int index = range.start; index < range.end; index++) {
					final int columnIndex = this.selectionLayer.getColumnIndexByPosition(index);
					Object el = this.manager.getColumnElement(columnIndex);
					if (wrapper.getFullySelectedColumns().containsKey(index)) {
						// The selected column was only selected, so it need to be removed
						wrapper.getFullySelectedColumns().remove(columnIndex);
					} else if (el != null) {
						// Check if the column to select is corresponding to at least one cell
						if (isSelectedCellsContainsColumn(wrapper.getSelectedCells(), this.manager.getBodyLayerStack().getColumnHideShowLayer().getColumnPositionByIndex(columnIndex))) {
							// The selected column was not already in selection, add it
							wrapper.getFullySelectedColumns().put(Integer.valueOf(columnIndex), el);
						}
					}
				}
			}
			// Manage the row selection event
		} else if (TypeSelectionEnum.ROW.equals(typeSelectionEvent)) {
			for (Range range : ((RowSelectionEvent) event).getRowPositionRanges()) {
				for (int index = range.start; index < range.end; index++) {
					final int rowIndex = this.selectionLayer.getRowIndexByPosition(index);
					Object el = this.manager.getRowElement(rowIndex);
					if (wrapper.getFullySelectedRows().containsKey(index)) {
						// The selected row was only selected, so it need to be removed
						wrapper.getFullySelectedRows().remove(rowIndex);
					} else if (el != null) {
						// Check if the row to select is corresponding to at least one cell
						if (isSelectedCellsContainsRow(wrapper.getSelectedCells(), this.manager.getBodyLayerStack().getRowHideShowLayer().getRowPositionByIndex(rowIndex))) {
							// The selected row was not already in selection, add it
							wrapper.getFullySelectedRows().put(Integer.valueOf(rowIndex), el);
						}
					}
				}
			}
		}

		return calculateSelectionFromWrapper(wrapper);
	}

	/**
	 * This allows to determinate if the row index to add to the rows selected have at least one of its cells in the selected cells.
	 * 
	 * @param selectedCells
	 *            The selected cells.
	 * @param rowIndex
	 *            The row index to search.
	 * @return <code>true</code> if the row corresponding to at least one cell, <code>false</code> otherwise.
	 */
	private boolean isSelectedCellsContainsRow(final Collection<PositionCoordinate> selectedCells, final int rowIndex) {
		boolean result = false;

		Iterator<PositionCoordinate> selectedCellsIterator = selectedCells.iterator();
		while (!result && selectedCellsIterator.hasNext()) {
			final PositionCoordinate selectedCell = selectedCellsIterator.next();
			if (selectedCell.getRowPosition() == rowIndex) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * This allows to determinate if the column index to add to the columns selected have at least one of its cells in the selected cells.
	 * 
	 * @param selectedCells
	 *            The selected cells.
	 * @param columnIndex
	 *            The column index to search.
	 * @return <code>true</code> if the column corresponding to at least one cell, <code>false</code> otherwise.
	 */
	private boolean isSelectedCellsContainsColumn(final Collection<PositionCoordinate> selectedCells, final int columnIndex) {
		boolean result = false;

		Iterator<PositionCoordinate> selectedCellsIterator = selectedCells.iterator();
		while (!result && selectedCellsIterator.hasNext()) {
			final PositionCoordinate selectedCell = selectedCellsIterator.next();
			if (selectedCell.getColumnPosition() == columnIndex) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * This allows to calculate the selected objects from the wrapper filled.
	 * 
	 * @param wrapper
	 *            The wrapper filled.
	 * @return The collection of object selected.
	 */
	protected Collection<Object> calculateSelectionFromWrapper(final TableSelectionWrapper wrapper) {
		final Collection<Object> selection = new ArrayList<Object>();

		// Fill the selection list with the selected columns
		final List<Integer> selectedColumnsIndexes = new ArrayList<Integer>();
		for (final Entry<Integer, Object> selectedColumn : wrapper.getFullySelectedColumns().entrySet()) {
			final Object selectedObject = AxisUtils.getRepresentedElement(selectedColumn.getValue());
			selection.add(selectedObject);
			selectedColumnsIndexes.add(selectedColumn.getKey());
		}
		// Fill the selection list with the selected rows
		final List<Integer> selectedRowsIndexes = new ArrayList<Integer>();
		for (final Entry<Integer, Object> selectedRow : wrapper.getFullySelectedRows().entrySet()) {
			final Object selectedObject = AxisUtils.getRepresentedElement(selectedRow.getValue());
			selection.add(selectedObject);
			selectedRowsIndexes.add(selectedRow.getKey());
		}
		// Fill the selection list with the selected cells
		for (final PositionCoordinate cellLocation : wrapper.getSelectedCells()) {
			final int colPos = cellLocation.getColumnPosition();
			final int rowPos = cellLocation.getRowPosition();
			if (!selectedColumnsIndexes.contains(new Integer(this.selectionLayer.getColumnIndexByPosition(colPos))) && !selectedRowsIndexes.contains(new Integer(this.selectionLayer.getRowIndexByPosition(rowPos)))) {
				final ILayerCell cell = this.selectionLayer.getCellByPosition(colPos, rowPos);
				if (cell != null) {
					final Object value = cell.getDataValue();
					if (value != null) {
						if (value instanceof Collection<?>) {
							final Iterator<?> iter = ((Collection<?>) value).iterator();
							while (iter.hasNext()) {
								final Object current = iter.next();
								selection.add(current);
							}
						} else {
							selection.add(value);
						}
					}else{
						// Bug 481817 : When the value is null, we need to have the cell selection, so add the cell as selection instead of value
						selection.add(cell);
					}
				}
			}
		}

		return selection;
	}

	/**
	 * This allows to manage the selection when any type of selection was done (cell, row or column selection from the selection event).
	 * 
	 * @param wrapper
	 *            The wrapper to fill.
	 * @param event
	 *            The event caught.
	 * @return The collection of object selected.
	 */
	protected Collection<Object> calculateSelectionRowsAndColumnsWithoutTypeSelectionEvent(final TableSelectionWrapper wrapper, final ILayerEvent event) {
		final Collection<Object> selection = new ArrayList<Object>();

		// we are not able to distinguish the 2 ways to select a full axis :
		// - first way : clicking on axis header
		// - second way : clicking on first cell of the axis, Pressing SHIFT, clicking on the last cell of the axis (or selecting each cell of the axis pressing CTRL)
		// so we are not able to know if the user want to select the element represented by the axis OR all values displayed on the axis, without the element represented by the axis
		// we decided to implements this behavior for all kind of selection event :
		// 1- we add in the selection elements represented by fully selected rows
		// 2- we add in the selection elements represented by fully selected columns
		// 3- we add in the selection the contents of selected cell which are not included in the fully selected axis

		final List<Integer> selectedRowsIndexes = new ArrayList<Integer>();
		for (int i : this.selectionLayer.getFullySelectedRowPositions()) {
			int rowIndex = this.selectionLayer.getRowIndexByPosition(i);
			selectedRowsIndexes.add(new Integer(rowIndex));
			Object el = this.manager.getRowElement(rowIndex);
			if (el != null) {
				wrapper.getFullySelectedRows().put(Integer.valueOf(rowIndex), el);
				el = AxisUtils.getRepresentedElement(el);
				selection.add(el);
			}
		}
		final List<Integer> selectedColumnsIndexes = new ArrayList<Integer>();
		for (int i : this.selectionLayer.getFullySelectedColumnPositions()) {
			int columnIndex = this.selectionLayer.getColumnIndexByPosition(i);
			selectedColumnsIndexes.add(new Integer(columnIndex));
			Object el = this.manager.getColumnElement(columnIndex);
			if (el != null) {
				wrapper.getFullySelectedColumns().put(Integer.valueOf(columnIndex), el);
				el = AxisUtils.getRepresentedElement(el);
				selection.add(el);
			}
		}

		for (final PositionCoordinate cellLocation : wrapper.getSelectedCells()) {
			final int colPos = cellLocation.getColumnPosition();
			final int rowPos = cellLocation.getRowPosition();
			if (!selectedColumnsIndexes.contains(new Integer(this.selectionLayer.getColumnIndexByPosition(colPos))) && !selectedRowsIndexes.contains(new Integer(this.selectionLayer.getRowIndexByPosition(rowPos)))) {
				final ILayerCell cell = this.selectionLayer.getCellByPosition(colPos, rowPos);
				if (cell != null) {
					final Object value = cell.getDataValue();
					if (value != null) {
						if (value instanceof Collection<?>) {
							final Iterator<?> iter = ((Collection<?>) value).iterator();
							while (iter.hasNext()) {
								final Object current = iter.next();
								selection.add(current);
							}
						} else {
							selection.add(value);
						}
					}else{
						// Bug 481817 : When the value is null, we need to have the cell selection, so add the cell as selection instead of value
						selection.add(cell);
					}
				}
			}
		}

		return selection;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 */
	@Override
	public void dispose() {
		this.isDisposed = true;
		this.manager = null;
		// To be sure, to fix the bug 469376: [Table] Memory Leak : (Tree)NattableWidgetManager, EObjectTreeItemAxis and others objects are not disposed when the table is closed
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=469376
		setSelection(StructuredSelection.EMPTY);

		if (this.selectionLayer != null) {
			this.selectionLayer.removeLayerListener(this.selectionListener);
			this.selectionLayer = null;
		}
		this.listeners.clear();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.layer.ILayerListener#handleLayerEvent(org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent)
	 */
	@Override
	public void handleLayerEvent(final ILayerEvent event) {
		if (!isDisposed && event instanceof ISelectionEvent) {
			calculateAndStoreNewSelection(event);
		}
	}
}
