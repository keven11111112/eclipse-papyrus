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
import static org.eclipse.nebula.widgets.nattable.filterrow.config.FilterRowConfigAttributes.FILTER_COMPARATOR;
import static org.eclipse.nebula.widgets.nattable.filterrow.config.FilterRowConfigAttributes.FILTER_DISPLAY_CONVERTER;
import static org.eclipse.nebula.widgets.nattable.filterrow.config.FilterRowConfigAttributes.TEXT_DELIMITER;
import static org.eclipse.nebula.widgets.nattable.filterrow.config.FilterRowConfigAttributes.TEXT_MATCHING_MODE;
import static org.eclipse.nebula.widgets.nattable.style.DisplayMode.NORMAL;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IColumnAccessor;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.filterrow.DefaultGlazedListsFilterStrategy;
//import org.eclipse.nebula.widgets.nattable.extension.glazedlists.filterrow.FilterRowUtils;
import org.eclipse.nebula.widgets.nattable.filterrow.ParseResult;
import org.eclipse.nebula.widgets.nattable.filterrow.ParseResult.MatchType;
import org.eclipse.nebula.widgets.nattable.filterrow.TextMatchingMode;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.layerstack.BodyLayerStack;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FunctionList;
import ca.odell.glazedlists.FunctionList.Function;
import ca.odell.glazedlists.TextFilterator;
import ca.odell.glazedlists.matchers.CompositeMatcherEditor;
import ca.odell.glazedlists.matchers.MatcherEditor;
import ca.odell.glazedlists.matchers.TextMatcherEditor;

/**
 * This class has been adapted from the works done for string in {@link DefaultGlazedListsFilterStrategy}
 *
 */
public class StringMatcherEditorFactory<T> implements IPapyrusMatcherEditorFactory<T> {

	/**
	 * internal converter between PapyrusMatchingMode and nattable matching mode
	 */
	private static final TextMatchingMode convertToTextMatchingMode(PapyrusTextMatchingMode mode) {
		switch (mode) {
		case CONTAINS:
			return TextMatchingMode.CONTAINS;
		case EXACT:
			return TextMatchingMode.EXACT;
		case REGEX_FIND:
		case REGEX_MATCH:
			return TextMatchingMode.REGULAR_EXPRESSION;
		case NUM:
			return TextMatchingMode.REGULAR_EXPRESSION;
		case START:
			return TextMatchingMode.STARTS_WITH;
		default:
			return TextMatchingMode.CONTAINS;
		}

	}

	/**
	 * @param columnAccessor
	 * @param columnIndex
	 * @param wantedValue
	 * @param configRegistry
	 * @see org.eclipse.papyrus.infra.nattable.filter.IPapyrusMatcherEditorFactory#instantiateMatcherEditors(org.eclipse.nebula.widgets.nattable.data.IColumnAccessor, java.lang.Integer, java.lang.Object,
	 *      org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EventList<MatcherEditor<T>> instantiateMatcherEditors(IColumnAccessor<T> columnAccessor, Integer columnIndex, Object wantedValue, IConfigRegistry configRegistry) {
		Assert.isTrue(wantedValue instanceof String);
		EventList<MatcherEditor<T>> matcherEditors = new BasicEventList<MatcherEditor<T>>();

		StringBuilder columnLabelBuilder = new StringBuilder();
		columnLabelBuilder.append(FILTER_ROW_COLUMN_LABEL_PREFIX);
		columnLabelBuilder.append(columnIndex);

		String columnLabelId = columnLabelBuilder.toString();
		// for (Entry<Integer, Object> mapEntry : filterIndexToObjectMap.entrySet()) {
		// Integer columnIndex = mapEntry.getKey();

		PapyrusTextMatchingMode papyrusTextMatchingMode = getTextMatchingMode((String) wantedValue, configRegistry, columnLabelId);

		// we look for the text delimiter

		String textDelimiter = configRegistry.getConfigAttribute(TEXT_DELIMITER, NORMAL, columnLabelId);
		// TextMatchingMode textMatchingMode = configRegistry.getConfigAttribute(TEXT_MATCHING_MODE, NORMAL, FILTER_ROW_COLUMN_LABEL_PREFIX + columnIndex);

		// we get the text to filter
		String filterText = getStringFromColumnObject(columnIndex, wantedValue, configRegistry);
		EventList<MatcherEditor<T>> stringMatcherEditors = new BasicEventList<MatcherEditor<T>>();


		TextMatchingMode textMatchingMode = convertToTextMatchingMode(papyrusTextMatchingMode);
		IDisplayConverter displayConverter = configRegistry.getConfigAttribute(FILTER_DISPLAY_CONVERTER, NORMAL, columnLabelId);
		@SuppressWarnings("rawtypes")
		Comparator comparator = configRegistry.getConfigAttribute(FILTER_COMPARATOR, NORMAL, columnLabelId);
		final Function<T, Object> columnValueProvider = getColumnValueProvider(columnIndex, columnAccessor);
		if (PapyrusTextMatchingMode.REGEX_FIND.equals(papyrusTextMatchingMode)) {
			stringMatcherEditors.add((MatcherEditor<T>) new RegexFindEditor((IColumnAccessor<Object>) columnAccessor, columnIndex, filterText, configRegistry));
		} else {

			List<ParseResult> parseResults = FilterRowUtils.parse(filterText, textDelimiter, textMatchingMode);


			for (ParseResult parseResult : parseResults)
			{
				MatchType matchOperation = parseResult.getMatchOperation();
				if (matchOperation == MatchType.NONE) {
					stringMatcherEditors.add(getTextMatcherEditor(columnIndex, textMatchingMode, displayConverter, parseResult.getValueToMatch(), columnAccessor, configRegistry));
				} else {
					Object threshold = displayConverter.displayToCanonicalValue(parseResult.getValueToMatch());
					matcherEditors.add(getThresholdMatcherEditor(columnIndex, threshold, comparator, columnValueProvider, matchOperation, configRegistry));
				}
			}
		}
		if (stringMatcherEditors.size() > 0) {
			CompositeMatcherEditor<T> stringCompositeMatcherEditor = new CompositeMatcherEditor<T>(stringMatcherEditors);
			stringCompositeMatcherEditor.setMode(CompositeMatcherEditor.OR);
			matcherEditors.add(stringCompositeMatcherEditor);
		}

		return matcherEditors;

	}



	/**
	 * 
	 * @param wantedValue
	 *            the string typed in the text editor
	 * @param configRegistry
	 *            the configRegistry used by the nattable widget
	 * @param columnLabel
	 *            the label of the column
	 * @return
	 *         the matching mode to use, according to the table configuration and the wanted value
	 */
	protected PapyrusTextMatchingMode getTextMatchingMode(String wantedValue, IConfigRegistry configRegistry, String columnLabel) {
		PapyrusTextMatchingMode papyrusMatchingMode = configRegistry.getConfigAttribute(NattableConfigAttributes.STRING_FILTER_MATCHING_MODE, NORMAL, columnLabel);
		TextMatchingMode nattableMatchingMode = configRegistry.getConfigAttribute(TEXT_MATCHING_MODE, NORMAL, columnLabel);

		if (papyrusMatchingMode == null && nattableMatchingMode == null) {
			papyrusMatchingMode = PapyrusTextMatchingMode.CONTAINS;
		}
		if (papyrusMatchingMode != null || (papyrusMatchingMode == null && nattableMatchingMode != null)) {
			if (PapyrusTextMatchingMode.CONTAINS.equals(papyrusMatchingMode) || nattableMatchingMode.equals(TextMatchingMode.CONTAINS)) {
				if (wantedValue.startsWith(PapyrusTextMatchingMode.REGEX_FIND.getMode())) {
					return PapyrusTextMatchingMode.REGEX_FIND;
				}
				if (wantedValue.startsWith(PapyrusTextMatchingMode.REGEX_MATCH.getMode())) {
					return PapyrusTextMatchingMode.REGEX_MATCH;
				}
				if (wantedValue.startsWith(PapyrusTextMatchingMode.CONTAINS.getMode())) {
					return PapyrusTextMatchingMode.CONTAINS;
				}
				if (wantedValue.startsWith(PapyrusTextMatchingMode.EXACT.getMode())) {
					return PapyrusTextMatchingMode.EXACT;
				}
				if (wantedValue.startsWith(PapyrusTextMatchingMode.START.getMode())) {
					return PapyrusTextMatchingMode.START;
				}
				if (wantedValue.startsWith(PapyrusTextMatchingMode.NUM.getMode())) {
					return PapyrusTextMatchingMode.NUM;
				}
			}
		}
		if (papyrusMatchingMode == null) {
			switch (nattableMatchingMode) {
			case CONTAINS:// managed before this line!
				return PapyrusTextMatchingMode.CONTAINS;
			case EXACT:
				return PapyrusTextMatchingMode.EXACT;
			case REGULAR_EXPRESSION:
				return PapyrusTextMatchingMode.NUM;
			case STARTS_WITH:
				return PapyrusTextMatchingMode.START;
			default:
				// not possible
				return PapyrusTextMatchingMode.CONTAINS;
			}
		}
		return papyrusMatchingMode;
	}


	/**
	 * Converts the object inserted to the filter cell at the given column position to the corresponding String.
	 * 
	 * @param columnIndex
	 *            The column index of the filter cell that should be processed.
	 * @param object
	 *            The value set to the filter cell that needs to be converted
	 * @param configRegistry
	 *            the config registry used by the nattable widget
	 * @return The String value for the given filter value.
	 */
	protected String getStringFromColumnObject(final int columnIndex, Object object, IConfigRegistry configRegistry) {
		Assert.isTrue(object instanceof String);
		// if (object instanceof String) {
		String str = (String) object;
		if (str.startsWith(PapyrusTextMatchingMode.REGEX_FIND.getMode())) {
			str = str.replaceFirst(PapyrusTextMatchingMode.REGEX_FIND.getMode(), ""); //$NON-NLS-1$
		} else if (str.startsWith(PapyrusTextMatchingMode.REGEX_MATCH.getMode())) {
			str = str.replaceFirst(PapyrusTextMatchingMode.REGEX_MATCH.getMode(), ""); //$NON-NLS-1$
		} else if (str.startsWith(PapyrusTextMatchingMode.CONTAINS.getMode())) {
			str = str.replaceFirst(PapyrusTextMatchingMode.CONTAINS.getMode(), ""); //$NON-NLS-1$
		} else if (str.startsWith(PapyrusTextMatchingMode.EXACT.getMode())) {
			str = str.replaceFirst(PapyrusTextMatchingMode.EXACT.getMode(), ""); //$NON-NLS-1$
		} else if (str.startsWith(PapyrusTextMatchingMode.START.getMode())) {
			str = str.replaceFirst(PapyrusTextMatchingMode.START.getMode(), ""); //$NON-NLS-1$
		} else if (str.startsWith(PapyrusTextMatchingMode.NUM.getMode())) {
			str = str.replaceFirst(PapyrusTextMatchingMode.NUM.getMode(), ""); //$NON-NLS-1$
		}
		return str;
	}

	/**
	 * Set up a threshold matcher for tokens like '&gt;20', '&lt;=10' etc.
	 * 
	 * @param columnIndex
	 *            of the column for which the matcher editor is being set up
	 * @param configRegistry
	 *            the config registry used by the nattable widget
	 */
	protected PapyrusThresholdMatcherEditor<T, Object> getThresholdMatcherEditor(Integer columnIndex, Object threshold, Comparator<Object> comparator, Function<T, Object> columnValueProvider, MatchType matchOperation, IConfigRegistry configRegistry) {
		PapyrusThresholdMatcherEditor<T, Object> thresholdMatcherEditor = new PapyrusThresholdMatcherEditor<T, Object>(
				threshold,
				null,
				comparator,
				columnValueProvider) {

		};

		FilterRowUtils.setMatchOperation(thresholdMatcherEditor, matchOperation);
		return thresholdMatcherEditor;
	}

	/**
	 * @return Function which exposes the content of the given column index from the row object
	 */
	protected FunctionList.Function<T, Object> getColumnValueProvider(final int columnIndex, final IColumnAccessor<T> columnAccessor) {
		return new FunctionList.Function<T, Object>() {
			@Override
			public Object evaluate(T rowObject) {
				return columnAccessor.getDataValue(rowObject, columnIndex);
			}
		};
	}

	/**
	 * Sets up a text matcher editor for String tokens
	 * 
	 * @param columnIndex
	 *            of the column for which the matcher editor is being set up
	 * @param filterText
	 *            text entered by the user in the filter row
	 * @param configRegistry
	 *            the config registry used by the nattable widget
	 */
	protected TextMatcherEditor<T> getTextMatcherEditor(Integer columnIndex, TextMatchingMode textMatchingMode, IDisplayConverter converter, String filterText, final IColumnAccessor<T> columnAccessor, IConfigRegistry configRegistry) {
		TextMatcherEditor<T> textMatcherEditor = new TextMatcherEditor<T>(getTextFilterator(columnIndex, converter, columnAccessor, configRegistry));
		textMatcherEditor.setFilterText(new String[] { filterText });
		textMatcherEditor.setMode(getGlazedListsTextMatcherEditorMode(textMatchingMode));
		return textMatcherEditor;
	}

	/**
	 * @param configRegistry
	 *            the config registry used by the nattable widget
	 * @return {@link TextFilterator} which exposes the contents of the column as a {@link String}
	 */
	protected TextFilterator<T> getTextFilterator(final Integer columnIndex, final IDisplayConverter converter, final IColumnAccessor<T> columnAccessor, final IConfigRegistry configRegistry) {
		return new TextFilterator<T>() {
			@Override
			public void getFilterStrings(List<String> objectAsListOfStrings, T rowObject) {
				INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
				int index = manager.getRowElementsList().indexOf(rowObject);
				BodyLayerStack stack = manager.getBodyLayerStack();
				ILayerCell cell = stack.getBodyDataLayer().getCellByPosition(columnIndex, index);
				Object value = CellManagerFactory.INSTANCE.getCrossValue(manager.getColumnElement(columnIndex), rowObject, manager);
				final IDisplayConverter displayConverter = configRegistry.getConfigAttribute(FILTER_DISPLAY_CONVERTER, NORMAL, FILTER_ROW_COLUMN_LABEL_PREFIX + columnIndex);
				Object res = displayConverter.canonicalToDisplayValue(cell, configRegistry, value);
				if (res instanceof String) {
					objectAsListOfStrings.add((String) res);
				} else if (res instanceof Collection<?>) {
					// to manage multivalued properties
					Collection<?> col = (Collection<?>) res;
					for (Object object : col) {
						objectAsListOfStrings.add(object.toString());
					}
				}
			}
		};
	}

	/**
	 * @return the equivalent for GlazedLists TextMatcherEditor.
	 */
	public static final int getGlazedListsTextMatcherEditorMode(TextMatchingMode textMatchingMode) {
		switch (textMatchingMode) {
		case EXACT:
			return TextMatcherEditor.EXACT;
		case STARTS_WITH:
			return TextMatcherEditor.STARTS_WITH;
		case REGULAR_EXPRESSION:
			return TextMatcherEditor.REGULAR_EXPRESSION;
		default:
			return TextMatcherEditor.CONTAINS;
		}
	}
}
