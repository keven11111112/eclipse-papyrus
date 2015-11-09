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

import org.eclipse.papyrus.aof.core.IBox;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * The {@link IBox#sameAs(IBox)} matcher.
 */
class SameAs<E> extends BaseMatcher<IBox<E>> {

	private final IBox<E> expected;

	SameAs(IBox<E> expected) {
		super();

		this.expected = expected;
	}

	@Override
	public boolean matches(Object item) {
		boolean result = false;

		if (item instanceof IBox<?>) {
			@SuppressWarnings("unchecked")
			IBox<E> box = (IBox<E>) item;
			result = box.sameAs(expected);
		}

		return result;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText(" the same as ").appendValue(expected);
	}

}
