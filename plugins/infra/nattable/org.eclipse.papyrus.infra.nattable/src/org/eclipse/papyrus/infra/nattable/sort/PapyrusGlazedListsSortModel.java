/*******************************************************************************
 * Copyright (c) 2012, 2013 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.nattable.sort;

import java.util.Comparator;
import java.util.List;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IColumnAccessor;
import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyResolver;
//import org.eclipse.nebula.widgets.nattable.extension.glazedlists.NatColumnTableFormat;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent;
import org.eclipse.nebula.widgets.nattable.layer.event.StructuralRefreshEvent;
import org.eclipse.nebula.widgets.nattable.sort.SortDirectionEnum;
import org.eclipse.papyrus.infra.nattable.glazedlists.PapyrusSortingState;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.sort.copy.NatTableComparatorChooser;

import ca.odell.glazedlists.SortedList;


/**
 * 
 * @author Vincent Lorenzo
 *         This class provides the sort model for an axis
 */
public class PapyrusGlazedListsSortModel extends AbstractGlazedListSortModel {
	
	/**
	 * the column accessor
	 */
	protected IColumnAccessor<Object> columnAccessor;

	/**
	 * the sorted list
	 */
	protected SortedList<Object> sortedList;

	// TODO : useful
	private NatTableComparatorChooser<Object> comparatorChooser;
	// protected SortedList<T> sortedList;

	// TODO : useful ?
	protected IColumnPropertyResolver columnPropertyResolver;

	// TODO : useful ?
	protected ILayer columnHeaderDataLayer;


	/**
	 * Constructor.
	 *
	 * @param manager
	 * @param sortedList
	 * @param columnAccessor
	 */
	public PapyrusGlazedListsSortModel(INattableModelManager manager, SortedList<Object> sortedList, IColumnAccessor<Object> columnAccessor) {
		super(manager);
		this.columnAccessor = columnAccessor;
		this.sortedList = sortedList;
	}


	
	protected PapyrusNatColumnTableFormat<Object> f;

	protected NatTableComparatorChooser<Object> getComparatorChooser() {

		if (comparatorChooser == null) {
			f = new PapyrusNatColumnTableFormat<Object>(columnAccessor, getTableManager(), columnHeaderDataLayer);
			comparatorChooser =
					new PapyrusNatTableComparatorChooser(sortedList, f) {

						/**
						 * @see ca.odell.glazedlists.gui.AbstractTableComparatorChooser#createSortingState()
						 *
						 * @return
						 */
						@Override
						protected org.eclipse.papyrus.infra.nattable.glazedlists.copy.SortingState createSortingState() {
							return new PapyrusSortingState(this, getTableManager());
						}
					};
		}

		return comparatorChooser;
	}

	protected IConfigRegistry getConfigRegistry() {
		NatTable nat = (NatTable) getTableManager().getAdapter(NatTable.class);
		return nat.getConfigRegistry();
	}

	@Override
	public List<Integer> getSortedColumnIndexes() {
		return getComparatorChooser().getSortingColumns();
	}

	@Override
	public int getSortOrder(int columnIndex) {
		return getComparatorChooser().getClickSequence(columnIndex);
	}

	@Override
	public SortDirectionEnum getSortDirection(int columnIndex) {
		return getComparatorChooser().getSortDirectionForColumnIndex(columnIndex);
	}

	@Override
	public boolean isColumnIndexSorted(int columnIndex) {
		return getComparatorChooser().isColumnIndexSorted(columnIndex);
	}

	@Override
	public List<Comparator> getComparatorsForColumnIndex(int columnIndex) {
		return getComparatorChooser().getComparatorsForColumn(columnIndex);
	}

	@Override
	public void sort(int columnIndex, SortDirectionEnum sortDirection, boolean accumulate) {
		getComparatorChooser().sort(columnIndex, sortDirection, accumulate);
	}

	@Override
	public void clear() {
		getComparatorChooser().clearComparator();
	}

	@Override
	public void handleLayerEvent(ILayerEvent event) {
		if (event instanceof StructuralRefreshEvent && ((StructuralRefreshEvent) event).isHorizontalStructureChanged()) {
			String test = getComparatorChooser().toString();
			this.comparatorChooser = null;
			getComparatorChooser().fromString(test);
		}
	}

	/**
	 * @param compositeLayer
	 */
	// TODO : try to remove me
	public void setColumnHeaderLayer(ILayer compositeLayer) {
		this.columnHeaderDataLayer = compositeLayer;
		this.columnHeaderDataLayer.addLayerListener(this);// useful ?
		if (f != null) {
			f.setColumnHeaderDataLayer(columnHeaderDataLayer);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.sort.IPapyrusSortModel#updateSort()
	 *
	 */
	// @Override
	public void updateSort() {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.sort.ISortModel#getColumnComparator(int)
	 *
	 * @param columnIndex
	 * @return
	 */
	@Override
	public Comparator<?> getColumnComparator(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
