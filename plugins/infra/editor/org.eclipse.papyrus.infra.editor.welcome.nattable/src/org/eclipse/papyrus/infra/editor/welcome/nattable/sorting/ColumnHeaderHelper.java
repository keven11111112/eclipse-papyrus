/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.editor.welcome.nattable.sorting;

import java.text.Collator;
import java.util.Comparator;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.GlazedListsSortModel;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultColumnHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ColumnOverrideLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.sort.ISortModel;
import org.eclipse.nebula.widgets.nattable.sort.SortConfigAttributes;
import org.eclipse.nebula.widgets.nattable.sort.SortHeaderLayer;
import org.eclipse.nebula.widgets.nattable.sort.config.SingleClickSortConfiguration;
import org.eclipse.nebula.widgets.nattable.sort.painter.SortableHeaderTextPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.style.IStyle;
import org.eclipse.nebula.widgets.nattable.ui.util.CellEdgeEnum;
import org.eclipse.papyrus.infra.editor.welcome.nattable.ServiceConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

import ca.odell.glazedlists.SortedList;

/**
 * A helper utility for the configuration of sorting a NatTable that renders a
 * SWT Forms-compatible flat presentation.
 */
public class ColumnHeaderHelper<T> {
	private final IConfigRegistry configRegistry;

	private final ILayer viewportLayer;
	private final SelectionLayer selectionLayer;

	private IColumnPropertyAccessor<T> columnAccessor;
	private DataLayer headerData;
	private SortHeaderLayer<T> sortHeaders;

	/**
	 * Initializes me.
	 *
	 * @param configRegistry
	 *            the NatTable configuration registry
	 * @param viewportLayer
	 *            the viewport layer to track for positioning of header cells
	 * @param selectionLayer
	 *            the selection layer in the table body
	 */
	public ColumnHeaderHelper(IConfigRegistry configRegistry, ILayer viewportLayer, SelectionLayer selectionLayer) {
		super();

		this.configRegistry = configRegistry;
		this.viewportLayer = viewportLayer;
		this.selectionLayer = selectionLayer;
	}

	/**
	 * Creates the header layer. <b>Note</b> that this must be done exactly once, as the returned
	 * layer and other parts of it are retained for follow-up work.
	 * 
	 * @param data
	 *            the sorted Glazed-list backing store of the table
	 * @param columnAccessor
	 *            the column accessor describing the columns to be presented
	 * @param columnHeadings
	 *            the localized heading titles corresponding to each column
	 * 
	 * @return the column header layer
	 */
	public ILayer createHeaderLayer(SortedList<T> data, IColumnPropertyAccessor<T> columnAccessor, String... columnHeadings) {
		this.columnAccessor = columnAccessor;
		IDataProvider headerProvider = new DefaultColumnHeaderDataProvider(columnHeadings);
		headerData = new DataLayer(headerProvider);
		ColumnHeaderLayer headers = new ColumnHeaderLayer(headerData, viewportLayer, selectionLayer);
		ISortModel sortModel = new GlazedListsSortModel<>(data, columnAccessor, configRegistry, headerData);
		sortHeaders = new SortHeaderLayer<>(headers, sortModel, false);
		return sortHeaders;
	}

	/**
	 * Configures the header layer {@linkplain #createHeaderLayer previously created} for sorting
	 * control behavior.
	 * 
	 * @see #createHeaderLayer(SortedList, IColumnPropertyAccessor, String...)
	 */
	public void configureSorting() {
		ColumnOverrideLabelAccumulator labelAccumulator = new ColumnOverrideLabelAccumulator(headerData);
		headerData.setConfigLabelAccumulator(labelAccumulator);

		for (int i = 0; i < columnAccessor.getColumnCount(); i++) {
			String label = sortLabel(i);
			labelAccumulator.registerColumnOverrides(i, label);
			configRegistry.registerConfigAttribute(SortConfigAttributes.SORT_COMPARATOR, getByLabelOrdering(), DisplayMode.NORMAL, label);
		}
	}

	/**
	 * Configures the visual styling of the header layer {@linkplain #createHeaderLayer previously created}
	 * for presentation in a SWT Forms UI with a flat appearance.
	 * 
	 * @see #createHeaderLayer(SortedList, IColumnPropertyAccessor, String...)
	 */
	public void configureHeaders(ICellPainter cellPainter, IStyle style) {
		sortHeaders.addConfiguration(new SingleClickSortConfiguration(new SortableHeaderTextPainter(cellPainter, CellEdgeEnum.LEFT, true, 3, true)));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, cellPainter, DisplayMode.NORMAL, GridRegion.COLUMN_HEADER);
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, style, DisplayMode.NORMAL, GridRegion.COLUMN_HEADER);
		for (int i = 0; i < columnAccessor.getColumnCount(); i++) {
			String label = sortLabel(i);
			configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, cellPainter, DisplayMode.NORMAL, label);
			configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, style, DisplayMode.NORMAL, label);
		}
	}

	String sortLabel(int columnIndex) {
		return sortLabel(columnAccessor.getColumnProperty(columnIndex));
	}

	static String sortLabel(String propertyName) {
		return "sortBy:" + propertyName;
	}

	private Comparator<IObservableValue<?>> getByLabelOrdering() {
		Collator collator = Collator.getInstance();
		collator.setStrength(Collator.PRIMARY);
		return (a, b) -> collator.compare(getLabel(a), getLabel(b));
	}

	private String getLabel(IObservableValue<?> observable) {
		LabelProviderService labels = ServiceConfigAttributes.getService(LabelProviderService.class, configRegistry, DisplayMode.NORMAL);
		Object value = (observable == null) ? null : observable.getValue();
		ILabelProvider labelProvider = (value == null) ? null : labels.getLabelProvider(observable);
		return (labelProvider == null) ? null : labelProvider.getText(value);
	}

}
