/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Utility class for <code>org.eclipse.uml2.uml.MultiplicityElement</code><BR>
 */
public class MultiplicityElementUtil {

	/**
	 * The string representing the multiplicity with space " [x..y]"
	 * Clients should format the spaces at the calling side, but this method left here for backward compatibility
	 */
	@Deprecated
	public static String getMultiplicityAsString(MultiplicityElement element) {
		String multiplicity = formatMultiplicity(element);
		return multiplicity == null || multiplicity.isEmpty() ? "" : " " + multiplicity;
	}

	/**
	 * Return the multiplicity of the element "[x..y]"
	 *
	 * @return the string representing the multiplicity
	 */
	public static String formatMultiplicity(MultiplicityElement element) {
		String multiplicityStr = formatMultiplicityNoBrackets(element);
		if (multiplicityStr == null || multiplicityStr.isEmpty()) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		buffer.append(multiplicityStr);
		buffer.append("]");
		return buffer.toString();
	}

	/**
	 * Returns the String corresponding to the multiplicity without square brackets
	 *
	 * @return the string representing the multiplicity, without square brackets
	 */
	public static String formatMultiplicityNoBrackets(MultiplicityElement element) {
		ValueSpecification lowerSpecification = element.getLowerValue();
		ValueSpecification upperSpecification = element.getUpperValue();
		if (lowerSpecification == null && upperSpecification == null) {
			return setupMultiplicityAsInteger(element.getLower(), element.getUpper());
		}
		if (lowerSpecification == null && upperSpecification instanceof LiteralUnlimitedNatural) {
			return setupMultiplicityAsInteger(element.getLower(), ((LiteralUnlimitedNatural) upperSpecification).unlimitedValue());
		}
		if (lowerSpecification instanceof LiteralInteger && upperSpecification == null) {
			return setupMultiplicityAsInteger(((LiteralInteger) lowerSpecification).integerValue(), element.getUpper());
		}
		if (lowerSpecification instanceof LiteralInteger && upperSpecification instanceof LiteralUnlimitedNatural) {
			return setupMultiplicityAsInteger(((LiteralInteger) lowerSpecification).integerValue(), ((LiteralUnlimitedNatural) upperSpecification).unlimitedValue());
		}
		return setupMultiplicityAsString(element, lowerSpecification, upperSpecification);
	}

	private static String setupMultiplicityAsInteger(int lower, int upper) {
		// special case for [1] and [*]
		if (lower == upper) {
			return new Integer(lower).toString();
		} else if ((lower == 0) && (upper == -1)) {
			return "*";
		} else if (upper == -1) {
			return lower + "..*";
		} else {
			return lower + ".." + upper;
		}
	}

	private static String setupMultiplicityAsString(MultiplicityElement element, ValueSpecification lower, ValueSpecification upper) {
		String lowerStr = ValueSpecificationUtil.getSpecificationValue(lower);
		if ("*".equals(lowerStr)) {
			return "";
		}
		String upperStr = ValueSpecificationUtil.getSpecificationValue(upper);
		if (lowerStr != null && false == lowerStr.isEmpty() && lowerStr.equalsIgnoreCase(upperStr)) {
			return lowerStr;
		}
		StringBuffer result = new StringBuffer();
		result.append(lowerStr == null || lowerStr.isEmpty() ? element.getLower() : lowerStr);
		result.append("..");
		result.append(upperStr == null || upperStr.isEmpty() ? getUpper(element) : upperStr);
		return result.toString();
	}

	private static String getUpper(MultiplicityElement element) {
		return element.getUpper() == -1 ? "" : new Integer(element.getUpper()).toString();
	}

	/**
	 * Parses the given String and returns the value of the multiplicity.
	 * <P>
	 * a lower bound with value infinite (<code>*</code>) will be set at <code>-1</code>.
	 * </P>
	 *
	 * @param value
	 *            the string representing the multiplicity. it can be <code>1</code>, <code>1..2</code> or <code>1..*</code>
	 * @return a 2-size integer table, with the first element corresponding to the lower bound, the second corresponds to the upper bound
	 */
	public static int[] parseMultiplicity(String value) throws NumberFormatException {
		int lower = 0;
		int upper = 0;
		int firstIndex = value.indexOf("..");

		// ".." was not found => this should be an integer, for example a multiplicity ~ [1]
		if (firstIndex == -1) {
			// this should be directly an integer or a star
			if ("*".equals(value)) {
				lower = 0;
				upper = -1;
			} else {
				lower = Integer.parseInt(value);
				upper = lower;
			}
		} else {
			String lowerValue = value.substring(0, firstIndex);
			String upperValue = value.substring(firstIndex + "..".length());

			lower = Integer.parseInt(lowerValue);
			upper = -2;
			if ("*".equals(upperValue)) {
				upper = -1;
			} else {
				upper = Integer.parseInt(upperValue);
			}
		}
		return new int[] { lower, upper };
	}

}
