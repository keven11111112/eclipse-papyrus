/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.aof.core.tests.matchers;

import org.eclipse.papyrus.aof.core.IConstraints;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * The {@link IConstraints#matches(IConstraints)} matcher.
 */
class Matches extends BaseMatcher<IConstraints> {

	private final IConstraints expected;

	Matches(IConstraints expected) {
		super();

		this.expected = expected;
	}

	@Override
	public boolean matches(Object item) {
		boolean result = false;

		if (item instanceof IConstraints) {
			IConstraints constraints = (IConstraints) item;
			result = constraints.matches(expected);
		}

		return result;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText(" matches ").appendValue(expected);
	}

}
