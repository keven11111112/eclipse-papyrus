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

package org.eclipse.papyrus.infra.nattable.celleditor.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;


/**
 * @author MA244259
 *
 */
public class CellAxisConfigurationRegistry {

	private Map<Integer, ICellAxisConfiguration> registry;

	public static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.celleditor.configuration"; //$NON-NLS-1$

	public static final String CELL_EDITOR_CONFIGURATION_CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	public static final String ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

	public static final CellAxisConfigurationRegistry INSTANCE = new CellAxisConfigurationRegistry();

	// public static final String EXTENSION_POINT_NAMESPACE = "org.eclipse.papyrus.infra.nattable.celleditor";

	public static final String CONFIGURATION_EXT_NEW = "cellAxisConfiguration";

	/**
	 *
	 * Constructor.
	 * Initial the registry of the configuration factories
	 */
	private CellAxisConfigurationRegistry() {
		// to prevent instantiation
		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		// final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_NAMESPACE, EXTENSION_POINT_NAME, EXTENSION_ID);
		this.registry = new TreeMap<Integer, ICellAxisConfiguration>();
		for (final IConfigurationElement iConfigurationElement : configElements) {
			if (CONFIGURATION_EXT_NEW.equals(iConfigurationElement.getName())) {
				// final String id = iConfigurationElement.getAttribute(FACTORY_ID_ATTRIBUTE);
				final Integer order = new Integer(iConfigurationElement.getAttribute(ORDER_ATTRIBUTE));
				try {
					final ICellAxisConfiguration factory = (ICellAxisConfiguration) iConfigurationElement.createExecutableExtension(CELL_EDITOR_CONFIGURATION_CLASS_ATTRIBUTE);
					// factory.initFactory(id);

					if (factory != null) {
						this.registry.put(order, factory);
					}
				} catch (final CoreException e) {
					Activator.log.error(e);
				}
			}
		}
	}

	/**
	 *
	 * @param configurationId
	 *            the id of the factory
	 * @return
	 * 		the cellEditorFactory declared on this id or <code>null</code> if not found
	 * 
	 * 
	 */
	public ICellAxisConfiguration getCellEditorConfiguration(final String configurationId) {
		Assert.isNotNull(configurationId);
		for (final Integer order : this.registry.keySet()) {
			final ICellAxisConfiguration current = this.registry.get(order);
			if (configurationId.equals(current.getConfigurationId())) {
				return current;
			}
		}
		return null;
	}

	/**
	 *
	 * @param table
	 *            the table for which we are looking for a cell editor factory
	 * @param obj
	 *            the object for which we are looking for a cell editor factory
	 * @return
	 * 		the first cell editor configuration factory which is able to manage this object
	 */
	public ICellAxisConfiguration getFirstCellEditorConfiguration(final Table table, final Object obj) {
		final List<ICellAxisConfiguration> configurations = getCellEditorConfigurationFactories(table, obj);
		if (!configurations.isEmpty()) {
			return configurations.get(0);
		}
		return null;
	}


	/**
	 *
	 * @param tableManager
	 *            the table manager for which we are looking for a cell editor factory
	 * @param obj
	 *            the object for which we are looking for a cell editor factory
	 * @return
	 * 		the first cell editor configuration factory which is able to manage this object
	 */
	public ICellAxisConfiguration getFirstCellEditorConfiguration(final INattableModelManager tableManager, final Object obj) {
		return getFirstCellEditorConfiguration(tableManager.getTable(), obj);
	}

	/**
	 *
	 * @param table
	 *            the table for which we are looking for a cell editor factory
	 * @param obj
	 *            the object for which we are looking for a cell editor factory
	 * @return
	 * 		the list of the cell editor configuration which are able to manage this object
	 */
	public List<ICellAxisConfiguration> getCellEditorConfigurationFactories(final Table table, final Object obj) {
		final List<ICellAxisConfiguration> factories = new ArrayList<ICellAxisConfiguration>();
		for (final ICellAxisConfiguration current : this.registry.values()) {
			if (current.handles(table, obj)) {
				factories.add(current);
			}
		}
		return factories;
	}
}
