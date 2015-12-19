/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Bonnabesse Fanch (ALL4TEC) fanch.bonnabesse@alltec.net - Bug 478288
 *   
 *****************************************************************************/

package org.eclipse.papyrus.sysml.service.types.utils;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Property;

/**
 * Utility class for Association edit helpers.
 */
public class AssociationUtils {

	/**
	 * This compares the Property of an Association with expected informations.
	 * 
	 * @param expectedNavigable
	 *            The expected navigable information.
	 * @param expectedAggregation
	 *            The expected kind of aggregation.
	 * @param source
	 *            To specify if the member in treatment is a source.
	 * @param property
	 *            The property containing the aggregation to compare.
	 * @return The result of the comparison.
	 */
	public static boolean isIdenticalProperties(final boolean expectedNavigable, final AggregationKind expectedAggregation, final boolean source, final Property property) {
		return (isIdenticalAggregations(expectedAggregation, source, property) && isIdenticalNavigables(expectedNavigable, source, property));
	}

	/**
	 * This compares the aggregation information of a Property with an expected kind of aggregation.
	 * 
	 * @param expectedAggregation
	 *            The expected kind of aggregation.
	 * @param source
	 *            To specify if the member in treatment is a source.
	 * @param property
	 *            The property containing the aggregation to compare.
	 * @return The result of the comparison.
	 */
	public static boolean isIdenticalAggregations(final AggregationKind expectedAggregation, final boolean source, final Property property) {
		boolean identicalAggregation = false;

		final AggregationKind aggregation = property.getAggregation();

		if (source) {
			// If the member is the source member, the aggregation must be NONE
			if (AggregationKind.NONE_LITERAL.equals(aggregation)) {
				identicalAggregation = true;
			}

			// If the member is the target member, the aggregation must be the same than the expected aggregation
		} else if (expectedAggregation.equals(aggregation)) {
			identicalAggregation = true;
		}

		return identicalAggregation;
	}

	/**
	 * This compares the navigable information of a Property with an expected navigable.
	 * 
	 * @param expectedNavigable
	 *            The expected navigable information.
	 * @param source
	 *            To specify if the member in treatment is a source.
	 * @param property
	 *            The property containing the navigable information to compare.
	 * @return The result of the comparison.
	 */
	public static boolean isIdenticalNavigables(final boolean expectedNavigable, final boolean source, final Property property) {
		boolean identicalNavigable = false;

		final boolean navigable = property.isNavigable();

		if (source) {
			// If the member is the source member, the navigable value must be the same than the expected navigable
			if (expectedNavigable == navigable) {
				identicalNavigable = true;
			}

			// If the member is the source member, the navigable value must be the same than the expected navigable
		} else if (navigable) {
			identicalNavigable = true;
		}

		return identicalNavigable;
	}

}
