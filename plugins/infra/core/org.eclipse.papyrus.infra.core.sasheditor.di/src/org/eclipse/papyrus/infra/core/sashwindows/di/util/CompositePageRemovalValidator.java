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

package org.eclipse.papyrus.infra.core.sashwindows.di.util;

import java.util.Collection;

import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;

/**
 * A composition of two or more {@link PageRemovalValidator}s.
 */
class CompositePageRemovalValidator implements PageRemovalValidator {

	private final PageRemovalValidator one;
	private final PageRemovalValidator two;

	CompositePageRemovalValidator(PageRemovalValidator one, PageRemovalValidator two) {
		super();

		this.one = one;
		this.two = two;
	}

	@Override
	public boolean canRemovePage(PageRef page) {
		return one.canRemovePage(page) && two.canRemovePage(page);
	}

	@Override
	public Collection<? extends PageRef> filterRemovablePages(Collection<? extends PageRef> pages) {
		return two.filterRemovablePages(one.filterRemovablePages(pages));
	}
}
