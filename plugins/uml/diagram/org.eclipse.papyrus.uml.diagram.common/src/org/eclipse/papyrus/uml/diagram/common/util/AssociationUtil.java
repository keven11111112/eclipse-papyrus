/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fanch Bonnabesse (ALL4TEC) fanch.bonnabesse@alltec.net - Bug 419357
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Property;

/**
 * 
 * An utility class to use association.
 *
 */
public class AssociationUtil {

	public static boolean isAssociationEndProperty(Property property) {
		return property.getAssociation() != null;
	}

	/**
	 * This compares the Property of an Association with expected informations.
	 * 
	 * @param expectedNavigable
	 *            The expected navigable information.
	 * @param expectedAggregation
	 *            The expected kind of aggregation.
	 * @param property
	 *            The property containing the aggregation to compare.
	 * @return The result of the comparison.
	 */
	public static boolean isIdenticalProperties(final boolean expectedNavigable, final AggregationKind expectedAggregation, final Property property) {
		return (isIdenticalAggregations(expectedAggregation, property) && isIdenticalNavigables(expectedNavigable, property));
	}

	/**
	 * This compares the aggregation information of a Property with an expected kind of aggregation.
	 * 
	 * @param expectedAggregation
	 *            The expected kind of aggregation.
	 * @param property
	 *            The property containing the aggregation to compare.
	 * @return The result of the comparison.
	 */
	public static boolean isIdenticalAggregations(final AggregationKind expectedAggregation, final Property property) {
		boolean identicalAggregation = false;

		final AggregationKind aggregation = property.getAggregation();

		if (expectedAggregation.equals(aggregation)) {
			identicalAggregation = true;
		}

		return identicalAggregation;
	}

	/**
	 * This compares the navigable information of a Property with an expected navigable.
	 * 
	 * @param expectedNavigable
	 *            The expected navigable information.
	 * @param property
	 *            The property containing the navigable information to compare.
	 * @return The result of the comparison.
	 */
	public static boolean isIdenticalNavigables(final boolean expectedNavigable, final Property property) {
		boolean identicalNavigable = false;
		final boolean navigable = property.isNavigable();

		if (expectedNavigable == navigable) {
			identicalNavigable = true;
		}

		return identicalNavigable;
	}
}
