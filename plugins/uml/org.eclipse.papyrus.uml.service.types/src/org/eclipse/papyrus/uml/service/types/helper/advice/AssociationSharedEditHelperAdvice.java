/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and Others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * Association Composite edit helper advice.
 */
public class AssociationSharedEditHelperAdvice extends AssociationEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 *
	 * The currently created {@link Association} is Shared (manage by super class), and directed
	 * (meaning navigable in one direction only) which means the target end is owned by the association itself.
	 *
	 * Moreover this end name should not be set in that case, this latter rule is not followed here for now.
	 * </pre>
	 */
	@Override
	protected void configureSourceProperty(Property sourceProperty) {
		sourceProperty.setAggregation(AggregationKind.SHARED_LITERAL);
	}
}
