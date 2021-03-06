/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.utils;

import java.io.Reader;

import org.eclipse.papyrus.infra.nattable.parsers.CSVParser;
import org.eclipse.papyrus.infra.nattable.paste.PasteSeparator;
import org.eclipse.papyrus.infra.nattable.paste.TextDelimiter;

/**
 *
 * This class provides utils method to split a string to do a paste in the table
 *
 */
public class CSVPasteHelper {

	/**
	 * the default separator used for columns
	 */
	public static final char DEFAULT_CLIPBOARD_COLUMN_SEPARATOR = PasteSeparator.TABULATION.getSeparator();

	/**
	 * the default separator used for multivalue
	 */
	public static final String DEFAULT_MULTI_VALUE_SEPARATOR = ","; //$NON-NLS-1$

	public static final char DEFAULT_TEXT_MARKER = TextDelimiter.DOUBLE_QUOTE.getDelimiter();

	private final char textMarker;

	private final char cellSeparator;

	private final String multiValueSeparator;


	/**
	 *
	 * Constructor.
	 * The default constructor initialize the class with {@value #DEFAULT_CLIPBOARD_COLUMN_SEPARATOR}, {@value #DEFAULT_TEXT_MARKER}, {@value #DEFAULT_MULTI_VALUE_SEPARATOR}
	 */
	public CSVPasteHelper() {
		this(DEFAULT_CLIPBOARD_COLUMN_SEPARATOR, DEFAULT_TEXT_MARKER, DEFAULT_MULTI_VALUE_SEPARATOR);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param cellSeparator
	 *            the column separator to use
	 * @param textMarked
	 *            the row separator to use
	 * @param textMarker
	 *            the multi value separator to use
	 */
	public CSVPasteHelper(final char cellSeparator, final char textMarker, final String multiValueSeparator) {
		this.cellSeparator = cellSeparator;
		this.textMarker = textMarker;
		this.multiValueSeparator = multiValueSeparator;
	}

	/**
	 * Create the CSV Parser.
	 *
	 * @param reader
	 *            a reader
	 * @return
	 *         create a parser from the reader
	 */
	public CSVParser createParser(final Reader reader) {
		return createParser(reader, false);
	}

	/**
	 * Create the CSV Parser with the boolean for the beginning whitespace.
	 *
	 * @param reader
	 *            a reader
	 * @param keepBeginningWhiteSpace
	 *            Boolean to determinate if the beginning string whitespace must be kept or removed
	 * @return
	 * 		create a parser from the reader
	 */
	public CSVParser createParser(final Reader reader, final boolean keepBeginningWhiteSpace) {
		return new CSVParser(reader, this.cellSeparator, textMarker, keepBeginningWhiteSpace);
	}

	/**
	 *
	 * @return
	 *         the separator used for multivalue
	 */
	public String getMultiValueSeparator() {
		return multiValueSeparator;
	}


}
