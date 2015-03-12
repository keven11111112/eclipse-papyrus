/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.filter;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IColumnAccessor;
import org.eclipse.nebula.widgets.nattable.filterrow.FilterRowDataLayer;
import org.eclipse.nebula.widgets.nattable.filterrow.IFilterStrategy;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.services.IDisposable;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.matchers.CompositeMatcherEditor;
import ca.odell.glazedlists.matchers.MatcherEditor;
import ca.odell.glazedlists.util.concurrent.ReadWriteLock;



/**
 * the filter strategy used by Papyrus table. It allows to manage invert axis
 * 
 * NOT IN THE API
 *
 */
public class PapyrusFilterStrategy implements IFilterStrategy<Object>, IDisposable {

	/**
	 * the nattable model manager
	 */
	private NattableModelManager manager;

	/**
	 * the column accessor
	 */
	protected final IColumnAccessor<Object> columnAccessor;

	/**
	 * the row matcher editor
	 */
	protected CompositeMatcherEditor<Object> rowMatcherEditor;

	/**
	 * column matcher edito
	 */
	protected CompositeMatcherEditor<Object> columnMatcherEditor;

	/**
	 * the row filter list
	 */
	private FilterList<Object> rowFilterList;

	/**
	 * the column filter list
	 */
	private FilterList<Object> columnFilterList;

	/**
	 * the table
	 */
	private Table table;

	/**
	 * listener used to know when the user invert the table
	 */
	private Adapter invertAxisAdapter;

	/**
	 * 
	 * @return
	 *         the table manager
	 * 
	 */
	private INattableModelManager getTableManager() {
		return this.manager;
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param manager
	 *            the table manager
	 * @param columnAccessor
	 *            a column accessor
	 */
	public PapyrusFilterStrategy(NattableModelManager manager, final IColumnAccessor<Object> columnAccessor) {

		this.columnAccessor = columnAccessor;
		this.manager = manager;

		this.table = this.manager.getTable();
		if (this.table.isInvertAxis()) {
			this.rowFilterList = manager.getVerticalFilterList();
			this.columnFilterList = manager.getHorizontalFilterEventList();
		} else {
			this.rowFilterList = manager.getHorizontalFilterEventList();
			this.columnFilterList = manager.getVerticalFilterList();
		}
		// this.currentFilterList = this.manager.get
		this.invertAxisAdapter = new AdapterImpl() {

			/**
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 *
			 * @param msg
			 */
			@Override
			public void notifyChanged(Notification msg) {
				Object notifier = msg.getNotifier();
				if (notifier == getTableManager().getTable()) {
					if (msg.getFeature() == NattablePackage.eINSTANCE.getTable_InvertAxis()) {
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								resetFilter();
							}
						});

					}
				}
			}
		};
		table.eAdapters().add(invertAxisAdapter);

		this.rowMatcherEditor = new CompositeMatcherEditor<Object>();
		this.rowMatcherEditor.setMode(CompositeMatcherEditor.AND);
		this.columnMatcherEditor = new CompositeMatcherEditor<Object>();
		this.columnMatcherEditor.setMode(CompositeMatcherEditor.AND);

		this.columnFilterList.setMatcherEditor(this.columnMatcherEditor);
		this.rowFilterList.setMatcherEditor(this.rowMatcherEditor);
		resetFilter();
	}

	/**
	 * reset the row and the column filters
	 */
	public void resetFilter() {
		this.rowMatcherEditor.getMatcherEditors().clear();
		this.columnMatcherEditor.getMatcherEditors().clear();
	}


	private ReadWriteLock getReadWriteLockToUse() {
		if (this.table.isInvertAxis()) {
			return this.columnFilterList.getReadWriteLock();
		}
		return this.rowFilterList.getReadWriteLock();
	}

	private CompositeMatcherEditor<Object> getMatcherEditorToUse() {
		if (this.table.isInvertAxis()) {
			return this.columnMatcherEditor;
		}
		return this.rowMatcherEditor;
	}

	/**
	 * Create GlazedLists matcher editors and apply them to facilitate filtering.
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void applyFilter(Map<Integer, Object> filterIndexToObjectMap) {
		// find the lock and the matcher to use, it depends on the table invert axis state
		ReadWriteLock filterLock = getReadWriteLockToUse();
		CompositeMatcherEditor<Object> matcherEditor = getMatcherEditorToUse();
		// wait until all listeners had the chance to handle the clear event
		try {
			filterLock.writeLock().lock();
			matcherEditor.getMatcherEditors().clear();
		} finally {
			filterLock.writeLock().unlock();
		}

		if (filterIndexToObjectMap.isEmpty()) {
			return;
		}

		try {
			EventList<MatcherEditor<Object>> matcherEditors = new BasicEventList<MatcherEditor<Object>>();
			NatTable natTable = (NatTable) this.manager.getAdapter(NatTable.class);
			IConfigRegistry configRegistry = natTable.getConfigRegistry();
			for (Entry<Integer, Object> mapEntry : filterIndexToObjectMap.entrySet()) {
				final Integer columnIndex = mapEntry.getKey();
				final Object value = mapEntry.getValue();
				StringBuilder configLabel = new StringBuilder(FilterRowDataLayer.FILTER_ROW_COLUMN_LABEL_PREFIX);
				configLabel.append(columnIndex.toString());


				IPapyrusMatcherEditorFactory matcherCreator = configRegistry.getConfigAttribute(NattableConfigAttributes.MATCHER_EDITOR_FACTORY, DisplayMode.NORMAL, configLabel.toString());
				if (matcherCreator != null) {
					if (value instanceof Collection<?>) {
						Collection<?> coll = (Collection<?>) value;
						Iterator<?> iter = coll.iterator();
						CompositeMatcherEditor<Object> composite = new CompositeMatcherEditor<Object>();
						composite.setMode(CompositeMatcherEditor.OR);
						while (iter.hasNext()) {
							Object next = iter.next();
							composite.getMatcherEditors().addAll(matcherCreator.instantiateMatcherEditors(columnAccessor, columnIndex, next, configRegistry));
						}
						matcherEditors.add(composite);
					} else {
						matcherEditors.addAll(matcherCreator.instantiateMatcherEditors(columnAccessor, columnIndex, value, configRegistry));
					}
				} else {
					Activator.log.warn(NLS.bind("No matcher editor found for column {0}, we will use the default string matcher", columnIndex)); //$NON-NLS-1$
					matcherEditors.addAll(new StringMatcherEditorFactory<Object>().instantiateMatcherEditors(columnAccessor, columnIndex, value, configRegistry));
				}
			}

			// wait until all listeners had the chance to handle the clear event
			try {
				filterLock.writeLock().lock();
				matcherEditor.getMatcherEditors().addAll(matcherEditors);
			} finally {
				filterLock.writeLock().unlock();
			}

		} catch (Exception e) {
			Activator.log.error("Error on applying a filter", e); //$NON-NLS-1$
		}
	}

	protected FilterList<?> getRowFilterList() {
		return ((NattableModelManager) this.manager).getHorizontalFilterEventList();
	}

	protected ReadWriteLock getHorizontalFilterLock() {
		return getRowFilterList().getReadWriteLock();
	}

	/**
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 *
	 */
	@Override
	public void dispose() {
		this.table.eAdapters().remove(this.invertAxisAdapter);
		this.table = null;
		this.manager = null;
	}


}
