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

import static org.eclipse.nebula.widgets.nattable.filterrow.FilterRowDataLayer.FILTER_ROW_COLUMN_LABEL_PREFIX;
import static org.eclipse.nebula.widgets.nattable.filterrow.config.FilterRowConfigAttributes.FILTER_DISPLAY_CONVERTER;
import static org.eclipse.nebula.widgets.nattable.style.DisplayMode.NORMAL;

import java.util.regex.Pattern;

import org.eclipse.core.runtime.Assert;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IColumnAccessor;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.layerstack.BodyLayerStack;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;

import ca.odell.glazedlists.matchers.Matcher;

/**
 * 
 * The editor used for {@link PapyrusTextMatchingMode#REGEX_FIND}.
 * 
 * For the {@link PapyrusTextMatchingMode#REGEX_MATCH}, we use GlazedList implementation. It could be interesting to override its matching stategy, but it is not possible (not in API)
 *
 */
public class RegexFindEditor extends AbstractPapyrusMatcherEditor {

	/**
	 * Constructor.
	 *
	 * @param columnAccesor
	 * @param columnIndex
	 * @param matchOn
	 * @param configRegistry
	 */
	public RegexFindEditor(IColumnAccessor<Object> columnAccesor, int columnIndex, Object matchOn, IConfigRegistry configRegistry) {
		super(columnAccesor, columnIndex, matchOn, configRegistry);

	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.filter.AbstractPapyrusMatcherEditor#createMatcher(org.eclipse.nebula.widgets.nattable.data.IColumnAccessor, int, java.lang.Object, org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 *
	 * @param columnAccesor
	 * @param columnIndex
	 * @param matchOn
	 * @param configRegistry
	 * @return
	 */
	@Override
	protected Matcher<Object> createMatcher(IColumnAccessor<Object> columnAccesor, final int columnIndex, final Object matchOn, final IConfigRegistry configRegistry) {
		Assert.isTrue(matchOn instanceof String);
		return new Matcher<Object>() {

			@Override
			public boolean matches(Object item) {
				if (matchOn == null || ((String) matchOn).isEmpty()) {
					return true;
				}

				Pattern pattern;
				try {
					pattern = Pattern.compile((String) matchOn);
				} catch (Exception e) {
					// when the entered regex is not valid, we don't filter the rows
					return true;
				}

				INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
				int index = manager.getRowElementsList().indexOf(item);
				BodyLayerStack stack = manager.getBodyLayerStack();
				ILayerCell cell = stack.getCellByPosition(columnIndex, index);
				Object value = CellManagerFactory.INSTANCE.getCrossValue(manager.getColumnElement(columnIndex), item, manager);
				final IDisplayConverter displayConverter = configRegistry.getConfigAttribute(FILTER_DISPLAY_CONVERTER, NORMAL, FILTER_ROW_COLUMN_LABEL_PREFIX + columnIndex);
				Object res = displayConverter.canonicalToDisplayValue(cell, configRegistry, value);
				String str = (String) res;

				java.util.regex.Matcher m = pattern.matcher(str);
				return m.find();
			}
		};
	}
}
