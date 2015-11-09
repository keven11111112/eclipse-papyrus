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
import org.hamcrest.Matcher;

/**
 * Hamcrest matchers for {@link IBox}es.
 */
public class BoxMatchers {

	private BoxMatchers() {
		super();
	}

	public static <E> Matcher<IBox<E>> sameAs(IBox<E> box) {
		return new SameAs<E>(box);
	}
}
