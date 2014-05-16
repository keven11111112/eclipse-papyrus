/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.util;

/**
 * 
 * This class provides utils methods for mathematics
 * 
 */
public class MathUtil {

	/**
	 * 
	 * @param aValue
	 *        a value
	 * @param base
	 *        the base to use to find closest multiple
	 * @return
	 *         the closed multiple
	 */
	public static final double getClosestMultiple(final double aValue, final double base) {
		int div = (int)(aValue / base);

		double remainder = aValue % base;
		if((remainder * 2) > base) {
			div++;
		}
		return div * base;
	}
}
