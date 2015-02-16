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

/**
 * @author the matching mode provided by Papyrus for filter
 *
 */
public enum PapyrusTextMatchingMode {


	/** to do a comparison using {@link String#contains(CharSequence)}. it is the default case */
	CONTAINS("contains:"),

	/** to do a comparison using {@link String#equals(Object))} */
	EXACT("="),

	/** to do a numeric comparison */
	NUM("num:"),

	/** to find element using regex find */
	REGEX_FIND("regex:"),

	/** to find element using regex match, so the full string must match */
	REGEX_MATCH("regex_m:"),

	/** to do a comparison using {@link String#startsWith(String)} */
	START("start:");



	/**
	 * the string corresponding to the mode
	 */
	private String mode;

	/**
	 * Constructor.
	 *
	 */
	private PapyrusTextMatchingMode(String mode) {
		this.mode = mode;
	}


	/**
	 * 
	 * @return
	 *         the string representing the comparison mode
	 */
	public String getMode() {
		return this.mode;
	}
}
