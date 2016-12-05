/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.utils;

/**
 * This allows to manage percentage calculation utils method.
 */
public class PercentageCalculationUtils {

	/**
	 * This allows to calculate the correct round percentage.
	 * 
	 * @param index
	 *            The index of the item to manage.
	 * @param sumPercentage
	 *            The sum of the percentage.
	 * @param fragmentSize
	 *            The number of fragment.
	 * @return The correct percentage to set.
	 */
	public static int calculatePercentageToSet(final int index, final int sumPercentage, final int fragmentSize) {
		int roundPercentage = Math.round(sumPercentage / fragmentSize);

		int remainingPercentage = sumPercentage - (fragmentSize * roundPercentage);

		if (0 < remainingPercentage && index < remainingPercentage) {
			roundPercentage++;
		}

		return roundPercentage;
	}

}
