/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
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

package org.eclipse.papyrus.infra.tools.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author VL222926
 *
 */
public class TypeUtils {

	/**
	 * Constructor.
	 *
	 */
	private TypeUtils() {
		// to prevent instanciation
	}

	/**
	 * 
	 * @param str
	 *            a string representing a boolean
	 * @return
	 *         <code>true</code> if the string represents a valid boolean
	 */
	public static final boolean isBooleanValue(String str) {
		return "true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * 
	 * @param str
	 *            a string representing a boolean
	 * @return
	 *         <code>true</code> if the string represents a valid boolean
	 */
	public static final boolean isIntegerValue(String str) {
		/** the pattern that checks visual ids are valid integers */
		Pattern digit = Pattern.compile("\\d+"); //$NON-NLS-1$
		boolean result = false;
		Matcher matcher = digit.matcher(str);
		if (matcher != null) {
			result = matcher.matches();
		}
		return result;
	}

	/**
	 * 
	 * @param str
	 *            a string
	 * @return
	 *         <code>true</code> if the string represents a double
	 */
	public static final boolean isDoubleValue(String str) {
		try {
			new BigDecimal(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param str
	 *            a string
	 * @return
	 *         <code>true</code> if the string represents a double
	 */
	public static final boolean isNaturalValue(String str) {
		boolean res = isIntegerValue(str);
		if (res) {
			int tmp = Integer.parseInt(str);
			return tmp >= 0;
		}
		return res;
	}

	/**
	 * 
	 * @param object
	 *            an object
	 * @return
	 *         <code>true</code> if the object represents a numeric value
	 */
	public static final boolean isNumericValue(Object object) {
		if (object instanceof String) {
			try {
				new BigDecimal((String) object);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		if(object instanceof Integer || object instanceof Double || object instanceof Float){
			return true;
		}
		return false;
	
	}
}
