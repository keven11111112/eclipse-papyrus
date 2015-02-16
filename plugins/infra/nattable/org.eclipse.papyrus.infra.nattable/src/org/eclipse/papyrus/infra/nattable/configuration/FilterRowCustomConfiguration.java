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

package org.eclipse.papyrus.infra.nattable.configuration;

import java.util.List;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.AbstractRegistryConfiguration;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.filterrow.FilterIconPainter;
import org.eclipse.nebula.widgets.nattable.filterrow.FilterRowDataLayer;
import org.eclipse.nebula.widgets.nattable.filterrow.FilterRowPainter;
import org.eclipse.nebula.widgets.nattable.filterrow.config.FilterRowConfigAttributes;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.style.CellStyleAttributes;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.style.Style;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.papyrus.infra.nattable.command.UpdateFilterMapCommand;
import org.eclipse.papyrus.infra.nattable.converter.GenericDisplayConverter;
import org.eclipse.papyrus.infra.nattable.filter.configuration.FilterConfigurationFactory;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;

/**
 * This class configure the filters for the table
 *
 */
public class FilterRowCustomConfiguration extends AbstractRegistryConfiguration {

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.config.IConfiguration#configureRegistry(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 *
	 * @param configRegistry
	 */
	public void configureRegistry(IConfigRegistry configRegistry) {

		// Shade the row to be slightly darker than the blue background.
		final Style rowStyle = new Style();
		rowStyle.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, GUIHelper.getColor(197, 212, 231));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, rowStyle, DisplayMode.NORMAL, GridRegion.FILTER_ROW);

		configRegistry.registerConfigAttribute(FilterRowConfigAttributes.FILTER_DISPLAY_CONVERTER, new GenericDisplayConverter());

		// configure the filter for each columns
		INattableModelManager modelManager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new FilterRowPainter(new FilterIconPainter(GUIHelper.getImage("filter"))), DisplayMode.NORMAL, GridRegion.FILTER_ROW); //$NON-NLS-1$

		configRegistry.registerConfigAttribute(FilterRowConfigAttributes.TEXT_DELIMITER, "&"); //$NON-NLS-1$

		List<?> columnElement = modelManager.getColumnElementsList();
		INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL,  NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		NatTable nattable = (NatTable) manager.getAdapter(NatTable.class);
		for (int i = 0; i < columnElement.size(); i++) {
			StringBuilder builder = new StringBuilder(FilterRowDataLayer.FILTER_ROW_COLUMN_LABEL_PREFIX);
			builder.append(Integer.valueOf(i).toString());
			FilterConfigurationFactory.INSTANCE.configureFilter(configRegistry, columnElement.get(i), builder.toString());
			nattable.doCommand(new UpdateFilterMapCommand(i));
		}
	}


}
